package atomType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import util.*;

public class mvhd {
    public byte[] Version = new byte[1];
    // understand what is flag and add it to printMvhd
    public byte[] Flags = new byte[3];
    public byte[] CreationTime = new byte[4];
    public byte[] ModificationTime = new byte[4];
    public byte[] TimeScale = new byte[4];
    public byte[] Duration = new byte[4];
    public byte[] PreferredRate = new byte[4];
    public byte[] PreferredVolume = new byte[2];

    public void printMvhd() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("mvhd:");
        System.out.println("Version : " + (Version[0] & 0XFF));
        System.out.println("Creation time : " + converter.arrayByteToDate(CreationTime));
        System.out.println("Modification time : " + converter.arrayByteToDate(ModificationTime));
        System.out.println("Duration : "
                + converter.arrayByteToUnsignedLong(Duration) / converter.arrayByteToUnsignedLong(TimeScale) + "s");
        System.out.println("Preferred rate : " + converter.arrayByteToUnsignedFixedPoint(PreferredRate));
        System.out.println("Preferred Volume : " + converter.arrayByteToUnsignedFixedPoint(PreferredVolume));
        System.out.println("---------------------------------------------------------------------------------");
    }

    public mvhd(InputStream S) {
        try {
            S.read(Version);
            S.read(Flags);
            S.read(CreationTime);
            S.read(ModificationTime);
            S.read(TimeScale);
            S.read(Duration);
            S.read(PreferredRate);
            S.read(PreferredVolume);
            // skipped 10 byte because it is reserved for apple
            S.skip(10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
