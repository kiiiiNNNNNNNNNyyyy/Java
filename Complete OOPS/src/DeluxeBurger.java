public class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 9, "White");
        super.addHamburderAddition1("Chips", 2);
        super.addHamburderAddition2("Drink", 2);
    }

    @Override
    public void addHamburderAddition1(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }

    @Override
    public void addHamburderAddition2(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }

    @Override
    public void addHamburderAddition3(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }

    @Override
    public void addHamburderAddition4(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }
}
