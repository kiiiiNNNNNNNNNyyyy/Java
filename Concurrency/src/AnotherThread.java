public class AnotherThread extends Thread {
    private static final String ANSI_BLUE = "\u001B[34m";

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName() + "!!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up!");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake!!");
    }
}
