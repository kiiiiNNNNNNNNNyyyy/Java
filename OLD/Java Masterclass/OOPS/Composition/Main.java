public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("PC 011", "Lian Li", "240", dimensions);
        Monitor monitor = new Monitor("27inch", "MSI", 27, new Resolution(2540, 1440));
        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(theCase, monitor, motherboard);
        thePC.getMonitor().drawPixelAt(1500, 1200, "red");
        thePC.getMotherboard().loadProgram("Windows 10");
        thePC.getPcCase().pressPowerButton();
    }
}