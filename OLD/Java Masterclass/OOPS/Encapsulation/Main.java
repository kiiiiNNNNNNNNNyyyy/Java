class Main {
    public static void main(String[] args) {
        EnhancedPlayer player = new EnhancedPlayer("Tim", 50, "Sword");

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.getHealth());
    }
}