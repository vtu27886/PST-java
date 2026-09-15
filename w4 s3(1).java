import java.io.*;
import java.util.*;

class Result {

    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String ampm = s.substring(8, 10);

        if (ampm.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d%s", hour, s.substring(2, 8));
    }
}
