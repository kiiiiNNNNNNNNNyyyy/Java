public class Main {
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread!!");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            private static final String ANSI_GREEN = "\u001B[32m";

            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread!!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's runnable implementation");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "Another thread terminated or timed out, so I am running again..");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all, I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        // anotherThread.interrupt();
        System.out.println("Hello again from the main thread!!");
    }
}
