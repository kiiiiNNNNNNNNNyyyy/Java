import java.util.*;

public class DistanceBetTwoPts{
	public static void main(String args[]){
		
		System.out.println();
		System.out.println("This program calculates the distance between two points.");
		System.out.println("************************************\n");

		double x1, y1, x2, y2, resultx, resulty, distance, difference;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x and y coordinates of first point separated by a space: ");
		x1 = sc.nextDouble();
		y1 = sc.nextDouble();

		System.out.println("Enter x and y coordinates of second point separated by a space (,): ");
		x2 = sc.nextDouble();
		y2 = sc.nextDouble();

		resultx = (x2 - x1) * (x2 - x1);
		resulty = (y2 - y1) * (y2 - y1);
		
		difference = resultx + resulty;

		distance = Math.pow(difference, 0.5);

		System.out.println("Distance between two points (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + "): " + distance);
	}
}