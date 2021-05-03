public class Pyramids{
	public static void main(String args[]){
		int x;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j<=i){
					System.out.print("*");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<5;i++){
			for(int j=5;j>0;j--){
				if(i<j){
					System.out.print("*");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<5;i++){
			for(int j=4;j>=0;j--){
				if(j<=i){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<5;i++){
			for(int j=5;j>=0;j--){
				if(j<=i){
					System.out.print("*");
					System.out.print(" ");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}