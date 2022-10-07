package util;

import java.util.Date;

public class converter {

    public static Date arrayByteToDate(byte[] b) {
        return new Date(1000 * (arrayByteToUnsignedLong(b) - globalVariables.EPOCH_ADJUSTER));
    }

    public static String byteToHex(byte i) {
        String output = Integer.toHexString((i & 0xff));
        if (output.length() < 2) {
            output = '0' + output;
        }
        return output;
    }

    public static String arrayByteToHex(byte[] b) {
        String output = "";
        for (byte i : b) {
            output = output + byteToHex(i) + ' ';
        }
        return output.substring(0, output.length() - 1);
    }

    public static long arrayByteToUnsignedLong(byte[] b) {
        long x = 0;
        for (byte i : b) {
            x = (x << 8) + (i & 0xFF);
        }
        return x;
    }

    public static String arrayByteToString(byte[] b) {
        String output = "";
        for (byte i : b) {
            output += (char) (i & 0XFF);
        }
        return output;
    }

}