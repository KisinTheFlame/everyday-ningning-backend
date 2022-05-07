package tech.kisin.everydayningning.util;

import java.util.Random;

public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<length;i++) {
            int index = random.nextInt(base.length());
            stringBuffer.append(base.charAt(index));
        }
        return stringBuffer.toString();
    }
}
