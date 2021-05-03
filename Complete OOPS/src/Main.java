public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "Beef", 3.50, "White");
        double price = hamburger.itemizedHamburger();
        hamburger.addHamburderAddition1("Tomato", 0.50);
        hamburger.addHamburderAddition2("Onions", 0.50);
        hamburger.addHamburderAddition3("Cheese", 0.50);
        System.out.println("Final Price " + hamburger.itemizedHamburger());

        HealthyBurger healthyburger = new HealthyBurger("Chicken", 6.00);
        healthyburger.addHamburderAddition1("Egg", 1.00);
        healthyburger.addHealthyAddition1("Lentils", 1.00);
        healthyburger.itemizedHamburger();
        System.out.println("Final Price " + healthyburger.itemizedHamburger());

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addHamburderAddition3("Something",  2.00);
        System.out.println("Final Price " + deluxeBurger.itemizedHamburger());
    }
}
