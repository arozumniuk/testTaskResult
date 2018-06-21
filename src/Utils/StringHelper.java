package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {

    public static String generateTimestamp() {
        return new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(new Date());
    }

    public static String generateRandomString() {
        return generateTimestamp() + "_" + RandomStringUtils.random(4, true, true);
    }

    public static String generateStringWith(int countOfSymbols) {
        return RandomStringUtils.random(countOfSymbols, true, true);
    }

    public static String[] generateArrayOfEmails(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = ("qatest+" + i + "@observepoint.com");
        }

        return array;
    }

    public static String[] generateArrayOfUrls(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = ("https://lifeintheuktestweb.co.uk/test-" + i); //40 returns 200, 41 and further - returns 404
        }

        return array;
    }
}
