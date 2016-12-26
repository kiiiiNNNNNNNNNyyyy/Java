
public class Animate implements Runnable {
	
	BlockBreaker bb;
	
	Animate(BlockBreaker b){
		bb = b;
	}
	
	public void run(){
		
		while(true){
			bb.update();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
