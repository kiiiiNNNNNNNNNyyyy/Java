public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Sherdil");
        dog.eat();
        dog.breathe();

        Parrot parrot = new Parrot("Australian ringneck");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Pingoo");
        penguin.eat();
        penguin.breathe();
        penguin.fly();
    }
}
