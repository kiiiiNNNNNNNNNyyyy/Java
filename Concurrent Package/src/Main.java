import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();
        Producer producer = new Producer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_RED, bufferLock);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class Producer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Producer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted!!");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}

class Consumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Consumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            if (buffer.isEmpty()) {
                continue;
            }

            if (buffer.get(0).equals("EOF")) {
                System.out.println(color + "Exiting...");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }
}
