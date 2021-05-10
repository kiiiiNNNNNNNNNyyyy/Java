public class Runnable implements java.lang.Runnable {
    private static final String ANSI_RED = "\u001B[31m";

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable implementation");
    }
}
