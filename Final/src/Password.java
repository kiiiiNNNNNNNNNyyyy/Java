public class Password {

    private static final int key = 73412523;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptPassword(password);
    }

    private int encryptPassword(int password) {
        return password ^ key;
    }

    public void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if (encryptPassword(password) == this.encryptedPassword) {
            System.out.println("Welcome!!");
            return true;
        } else {
            System.out.println("Can't come in");
            return false;
        }
    }
}
