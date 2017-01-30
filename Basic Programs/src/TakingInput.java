public class TakingInput{
	public static void main(String args[]){

		System.out.println("This program calculates the area and perimeter of a circle.");
		System.out.println("************************************\n");

		double area, perimeter, radius, pi;
		radius = 5.5;
		pi = 3.14;

		area = radius * radius * pi;
		perimeter = radius * 2 * pi;

		System.out.println("Perimeter of the circle with radius " + radius + " is: " + perimeter +".");
		System.out.println("Area of the circle with radius " + radius + " is: " + area +".");

	}
}