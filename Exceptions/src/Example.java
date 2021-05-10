import java.util.InputMismatchException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    private static int divide() {
        int x = getInt();
        int y = getInt();

        System.out.println("x is " + x + ", y is " + y);
        return x/y;
    }

    private static int getInt() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while(true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Please enter a number only the digits 0 - 9");
            }
        }
    }
}
