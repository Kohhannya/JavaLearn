package Homework3;

public class Log {

    public static void main(String[] args) {
        log("Message");
    }

    public static void log(String message) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int len = stackTrace.length;
        System.out.println(stackTrace[len - 1].getClassName() + ": " + stackTrace[len - 1].getMethodName()
                + ": " + message);
    }
}
