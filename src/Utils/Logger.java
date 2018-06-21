package Utils;

import org.testng.Reporter;

public class Logger {
    public static final int LOG_LEVEL_STEP = 1;
    public static final int LOG_LEVEL_ACTION = 2;
    public static final int LOG_LEVEL_WARNING = 3;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_DEBUG = 5;

    private static int logLevel = Runner.getCfg().logLevel();

    /**
     * Adds message on EXCEPTION level.
     *
     * @param text message you want to log
     */
    public static void EXCEPTION(String text) {
        System.out.println("EXCEPTION: " + text);
        Reporter.log("EXCEPTION: " + text);
    }

    /**
     * Adds message on ERROR level.
     *
     * @param text message you want to log
     */
    public static void ERROR(String text) {
        System.out.println("ERROR: " + text);
        Reporter.log("ERROR: " + text);
    }

    /**
     * Adds message on ACTION level.
     *
     * @param text message you want to log
     */
    public static void ACTION(String text) {
        System.out.println((char) 27 + "[34m " + "\nACTION: " + text + "\n" + (char) 27 + "[0m");
        Reporter.log((char) 27 + "[34m " + "\nACTION: " + text + "\n" + (char) 27 + "[0m");
    }

    /**
     * Adds message on STEP level.
     *
     * @param text message you want to log
     *             30 - black. 31 - red. 32 - green. 33 - yellow. 34 - blue. 35 - purple. 36 - light blue. 37 - white.
     */
    public static void STEP(String text) {

        System.out.println((char) 27 + "[32m " + "\nSTEP: " + text + "\n" + (char) 27 + "[0m");
        Reporter.log((char) 27 + "[32m " + "\nSTEP: " + text + "\n" + (char) 27 + "[0m");
    }


    /**
     * Adds message on INFO level.
     *
     * @param text message you want to log
     */
    public static void INFO(String text) {
        if (logLevel >= LOG_LEVEL_INFO) {
            System.out.println((char) 27 + "[35m " + "\nINFO: " + text + "\n" + (char) 27 + "[0m");
            Reporter.log((char) 27 + "[35m " + "\nINFO: " + text + "\n" + (char) 27 + "[0m");
        }
    }

    /**
     * Adds message on WARNING level.
     *
     * @param text message you want to log
     */
    public static void WARNING(String text) {
        if (logLevel >= LOG_LEVEL_WARNING) {
            System.out.println("WARNING: " + text);
            Reporter.log("WARNING: " + text);
        }
    }

    /**
     * Adds message on DEBUG level.
     *
     * @param text message you want to log
     */
    public static void DEBUG(String text) {
        if (logLevel >= LOG_LEVEL_DEBUG) {
            System.out.println(" DEBUG: " + text);
            Reporter.log(" DEBUG: " + text);
        }
    }
}
