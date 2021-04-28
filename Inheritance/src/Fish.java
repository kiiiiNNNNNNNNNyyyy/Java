public class Fish extends Animal {
    private int gills;
    private int eyes;
    private int fins;

    public Fish(int size, int weight, String name, int gills,  int eyes, int fins) {
        super(1, 1, size, weight, name);
        this.eyes = eyes;
        this.fins = fins;
        this.gills = gills;
    }

    private void rest() {
        System.out.println(this.getName() + " is resting at the moment..");
    }

    private void moveMuscles() {
        System.out.println(this.getName() + " is gonna start moving its muscles...");
    }

    private void moveBackFin() {
        System.out.println(this.getName() + " is gonna start moving its backfin...");
    }

    public void swim() {
        this.move();
    }

    private void move() {
        moveMuscles();
        moveBackFin();
    }

    public void sleep() {
        this.rest();
        super.move(0);
    }

    @Override
    public void move(int speed) {
        this.swim();
        super.move(speed);
    }
}
