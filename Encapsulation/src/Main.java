public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        player.name = "Arjun";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        damage = 11;
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Arjun", 99, "Sword" );
        System.out.println("Initial health is " + enhancedPlayer.getHitPoints());

        Printer printer = new Printer(50, true);
        System.out.println("Initial page count " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());
    }
}
