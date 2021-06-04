public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
         new Thread1().start();
         new Thread2().start();
    }

    private static class Thread1 extends Thread  {}


    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1 !!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting for lock2!!");
                synchronized (lock2) {
                    System.out.println("Thread 2: Has lock1 and lock2!!");
                }
                System.out.println("Thread 2: released lock2!!");
            }
            System.out.println("Thread 2: release lock1!!");
        }
    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me! %n", this.name, person.getName());
        }
    }
}
