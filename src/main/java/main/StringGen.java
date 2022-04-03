package main;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/*
    Not sure why I made this lol, I might make this a separate jar then link this to sql
    Using this as an activationcode input would be astronomical, but that won't  be here for a long time
 */
class StringGen {

    static String getAlphaNumericString(int n)
    {

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, StandardCharsets.UTF_8);

        // Create a StringBuffer to store the result
        StringBuilder r = new StringBuilder();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }

    public static void main(String[] args)
    {
        // size of random alphanumeric string
        int n = 20;

        // Get and display the alphanumeric string
        System.out.println(getAlphaNumericString(n));
    }
}