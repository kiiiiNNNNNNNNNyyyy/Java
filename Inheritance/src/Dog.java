public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {
        super(1, 1, size, weight, name);
        this.eyes = eyes;
        this.legs = legs;
        this.teeth = teeth;
        this.tail = tail;
        this.coat = coat;
    }

    private void chew() {
        System.out.println(this.getName() + " is chewing...");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println(this.getName() + " is gonna start walking...");
        super.move(5);
    }

    public void run() {
        System.out.println(this.getName() + " is gonna start running...");
        move(15);
    }

    private void moveLegs(int speed) {
        System.out.println(this.getName() + " is moving its leg");
    }

    // if overridden method is not found... its gonna automatically call the super class move()
    @Override
    public void move(int speed) {
        System.out.println(this.getName() + " is gonna start moving its legs..");
        moveLegs(speed);
        super.move(speed);
    }
}
