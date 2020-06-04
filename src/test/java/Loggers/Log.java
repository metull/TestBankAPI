package Loggers;


public class Log {
    public static void logInfo(String text) {
        System.out.println("------------------------------\n" + text + "\n------------------------------\n ");
    }

    public static void logAssert(String resultsBody, String result) {
        logInfo("Получаем  " + resultsBody + " и сравниваем с " + result);
    }

}
