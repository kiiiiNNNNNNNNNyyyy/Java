import java.util.*;
public class AreaofTriangle.java{
	public static void main(String args[]){

		System.out.println();
		System.out.println("This program calculates the area of a triangle.");
		System.out.println("************************************\n");

		double x1, y1, x2, y2, x3, y3, side1, side2, side3, s, area;

		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter x and y coordinates of first point separated by a space: ");
		x1 = sc.nextDouble();
		y1 = sc.nextDouble();

		System.out.println("\nEnter x and y coordinates of second point separated by a space: ");
		x2 = sc.nextDouble();
		y2 = sc.nextDouble();

		System.out.println("\nEnter x and y coordinates of third point separated by a space: ");
		x3 = sc.nextDouble();
		y3 = sc.nextDouble();

		side1 = Math.pow(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)), 0.5);
		side2 = Math.pow(((x3 - x2) * (x3 - x2)) + ((y3 - y2) * (y3 - y2)), 0.5);
		side3 = Math.pow(((x1 - x3) * (x1 - x3)) + ((y1 - y3) * (y1 - y3)), 0.5);

		s = (side1 + side2 + side3)/2;
		area = Math.pow((s * (s-side1) * (s-side2) * (s-side3)), 0.5);
		System.out.println("\nThe area of the triangle is : " + area);
	}
}