package atomType;

import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;
import util.*;

public class trak {
    public tkhd tkhd;

    public trak(InputStream S, long typesize) {
        try {
            byte[] b;
            String type;
            long subtypesize;
            long size = 0;
            while (size != typesize) {
                b = S.readNBytes(globalVariables.ATOM_HEADER_SIZE);
                subtypesize = converter.arrayByteToUnsignedLong(Arrays.copyOfRange(b, 0, 4));
                type = converter.arrayByteToString(Arrays.copyOfRange(b, 4, 8));
                size += subtypesize;
                System.out.println(" type now =" + type);
                switch (type) {
                    case "tkhd":
                        tkhd = new tkhd(S);
                        break;
                    default:
                        System.err.println(
                                "ERROR : atom type not supported. moov");
                        System.exit(1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}