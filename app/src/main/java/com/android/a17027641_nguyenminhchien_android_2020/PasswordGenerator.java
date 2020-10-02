package com.android.a17027641_nguyenminhchien_android_2020;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static final String FULL_OPTION_PASS = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    // optional, make it more random
//    private static final String PASSWORD_ALLOW_BASE_SHUFFLE = shuffleString(PASSWORD_ALLOW_BASE);
//    private static final String PASSWORD_ALLOW = PASSWORD_ALLOW_BASE_SHUFFLE;

    private static SecureRandom random = new SecureRandom();


    public static String generateRandomPassword(int length,
                                                boolean hasLower,
                                                boolean hasUpper,
                                                boolean hasNumber,
                                                boolean hasSpecial) {

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder builderOptionPass = new StringBuilder();
        if(hasLower){
            builderOptionPass.append(CHAR_LOWER);
        }
        if(hasUpper){
            builderOptionPass.append(CHAR_UPPER);
        }
        if (hasNumber){
            builderOptionPass.append(NUMBER);
        }
        if (hasSpecial){
            builderOptionPass.append(OTHER_CHAR);
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
           if (builderOptionPass.length() == 0){
               builderOptionPass.append(FULL_OPTION_PASS);
           }
            int rndCharAt = random.nextInt(builderOptionPass.toString().length());
            char rndChar = builderOptionPass.toString().charAt(rndCharAt);

            // debug
            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }
        return sb.toString();

    }

    // shuffle
    public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return letters.stream().collect(Collectors.joining());
    }

}
