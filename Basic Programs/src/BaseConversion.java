import java.io.*;
import java.util.*;

class BaseConversion {
	
	public static String toBaseNString(int a, int base) {

		String s = "";
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while (true){
			if(base == 16){
				int rem=a%16; 
				s =hex[rem]+s; 
				a=a/16;
				if (a == 0)
					break;
			}else{
				int lastdigit = a % base;
				s = lastdigit + s;
				a = a / base;
				if (a == 0)
					break;
			}
		}

		return s;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter value: ");
		int val = s.nextInt();
		System.out.println("Enter base : ");
		int base = s.nextInt();
		System.out.println(toBaseNString(val, base));
	}
}
