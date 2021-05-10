public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountDownThread t1 = new CountDownThread(countdown);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(countdown);
        t2.setName("Thread 2");

        CountDownThread t3 = new CountDownThread(countdown1);
        CountDownThread t4 = new CountDownThread(countdown2);
        t3.setName("Thread 3");
        t4.setName("Thread 4");

        t1.start();
        t2.start();
        // t3.start();
        // t4.start();
    }
}

class Countdown {

    private int i;

    public void doCountDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            case "Thread 3":
                color = ThreadColor.ANSI_RED;
                break;
            case "Thread 4":
                color = ThreadColor.ANSI_BLUE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (this) {
            for (i=10; i>0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountDownThread extends Thread {
    private Countdown threadCountdown;

    public CountDownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountDown();
    }
}
