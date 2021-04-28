public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(1, 1, 5, 5, "Animal");
        Dog dog = new Dog(8, 20, "Sherdil", 2, 4, 1, 20, "silky");
        dog.eat();
        dog.walk();
        dog.run();
        Fish fish = new Fish(3, 3, "Nemo", 2, 2, 2);
        fish.swim();
        fish.sleep();
    }
}

