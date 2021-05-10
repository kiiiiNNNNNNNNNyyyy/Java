import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        Producer producer = new Producer(buffer, ThreadColor.ANSI_BLUE);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_RED);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_PURPLE);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class Producer implements Runnable {
    private List<String> buffer;
    private String color;

    public Producer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                synchronized (buffer) {
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted!!");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}

class Consumer implements Runnable {
    private List<String> buffer;
    private String color;

    public Consumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }

                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }
        }
    }
}
