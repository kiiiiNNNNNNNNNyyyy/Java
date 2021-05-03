import java.util.Scanner;

public class Searching {
	public static void main(String args[]){
		int a[] = new int[10];
		
		for(int i=0;i<10;i++){
			System.out.println("Enter number : " + i);
			Scanner sc = new Scanner(System.in);
			a[i] = sc.nextInt();
		}
		
		int max = 0;
		
		for(int i=0; i<a.length; i++){
			if(a[i] > max){
				max = a[i];
			}
		}
		System.out.println("The maximum digit is : " + max);
		
		int min = a[0];
		
		for(int i=0; i<a.length; i++){
			if(a[i] < min){
				min = a[i];
			}
		}
		System.out.println("The maximum digit is : " + min);
		
		System.out.println("Enter a number to search : ");
		Scanner sc2 = new Scanner(System.in);
		int search = sc2.nextInt();
		
		int x = 0;
		for(int i=0; i<a.length; i++){
			if(a[i] == search){
				System.out.println("Element " + search + " found at : " + a[i]);
				x = 1;
			}
		}
		
		if(x==0){
			System.out.println("Element not founmd!!");
		}
	}
}
