public class Penguin extends Bird {

    Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I cant fly... but i am cute..");
    }

}
