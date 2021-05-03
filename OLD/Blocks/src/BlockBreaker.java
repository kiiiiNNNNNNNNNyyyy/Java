import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class BlockBreaker extends JPanel implements KeyListener{
	
	//Array list for the paddle's movement
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	//Arraylist for the ball
	ArrayList<Block> ball = new ArrayList<Block>();
	
	//Arraylist for the powerups
	ArrayList<Block> powerup = new ArrayList<Block>();
	
	Block paddle;
	Thread thread;
	Animate animate;
	int size = 25;	//size of the ball
	
	BlockBreaker(){
		
		paddle = new Block(175, 480, 150, 25, "paddle.png");
		
		for(int i=0; i<8; i++){
			blocks.add(new Block((i*60+2), 0, 60, 25, "Blue Panel.png"));
		}
		for(int i=0; i<8; i++){
			blocks.add(new Block((i*60+2), 25, 60, 25, "Red Panel.png"));
		}
		for(int i=0; i<8; i++){
			blocks.add(new Block((i*60+2), 50, 60, 25, "Green Panel.png"));
		}
		for(int i=0; i<8; i++){
			blocks.add(new Block((i*60+2), 75, 60, 25, "Yellow Panel.png"));
		}
		
		//setting a random number on a block for a powerup
		Random random = new Random();
		blocks.get(random.nextInt(32)).powerup = true;		
		blocks.get(random.nextInt(32)).powerup = true;
		blocks.get(random.nextInt(32)).powerup = true;
		blocks.get(random.nextInt(32)).powerup = true;
		blocks.get(random.nextInt(32)).powerup = true;
		
		
		//adding first ball to the array list
		ball.add(new Block(237, 437, 25, 25, "ball.png"));
		
		//without these two lines, program will not read the keys
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		//for the blocks
		for(Block b: blocks){
			b.draw(g, this);
			paddle.draw(g, this);
		}
		
		//for the ball
		for(Block b: ball){
			b.draw(g, this);
			paddle.draw(g, this);
		}
		
		//for the ball
		for(Block p: powerup){
			p.draw(g, this);
			paddle.draw(g, this);
		}
		
	}
	
	public void update(){
		
		for(Block p: powerup){
			p.y += 1;
			if(p.intersects(paddle) && !p.destroyed){
				p.destroyed = true;
				ball.add(new Block(paddle.dx + 75, 437, 25, 25, "ball.png"));
			}
		}
		
		//for the ball
		for(Block ba: ball){
			ba.x += ba.dx;
			if(ba.x > (getWidth()-size) && ba.dx > 0 || ba.x < 0){
				ba.dx *= -1;
			}
			
			if(ba.y < 0 || ba.intersects(paddle)){
				ba.dy *= -1;
			}
			 
			ba.y += ba.dy;
			
			for(Block b: blocks){
				
				if((b.left.intersects(ba) || b.right.intersects(ba)) && !b.destroyed){
					ba.dx *= -1;
					b.destroyed = true;
					if(b.powerup){
						powerup.add(new Block(b.x, b.y, 25, 19, "ball.png"));
					}
				}
				
				else if(ba.intersects(b) && !b.destroyed){
					b.destroyed = true;
					ba.dy *= -1; 
					
					if(b.powerup){
						powerup.add(new Block(b.x, b.y, 25, 19, "ball.png"));
					}
				}
			}
			
			
		}
		
		//for the components
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			animate = new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0){
			paddle.x -= 15;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < getWidth()-paddle.width){
			paddle.x += 15;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
