class Player {
    
    public String fullName;
    public String weapon;
    public int health;

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out!!");
            // reduce the nuber of lives
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}