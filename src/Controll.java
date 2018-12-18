import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controll extends KeyAdapter {
	GameObject gameobject;
	Handler handler;
	int mana = 100;
	int Q = 0;
	int W = 0;
	int E = 0;
	public Controll(Handler handler){
		this.handler = handler;
	}
	public void recovery() {
		mana += 90;
		System.out.println(mana);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keys = e.getKeyCode();

		for(int i=0;i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ObjectId.Player) {
				if(keys == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(5);
				}
				if(keys == KeyEvent.VK_LEFT) {
					tempObject.setVelX(-5);
				}
				if(keys == KeyEvent.VK_SPACE && !tempObject.isJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(-6);
				}
				if(keys == KeyEvent.VK_Z && mana > 10) {
					if(Q == 3) {
						mana -= 20;
						handler.addObject(new Fireball(tempObject.getX(), tempObject.getY()+48 ,handler, ObjectId.Fireball, tempObject.getFacing() * 10));
					}else if(W == 3) {
						mana -= 20;
						handler.addObject(new Storm(tempObject.getX(), tempObject.getY()+8 ,handler, ObjectId.Storm, tempObject.getFacing() * 5));
					}
					else if(E == 3) {
						mana -= 20;
						handler.addObject(new WaterATK(tempObject.getX(), tempObject.getY() ,handler, ObjectId.WaterATK));
						break;
						
					}
					
					else {
						mana -= 10;
						handler.addObject(new Skills(tempObject.getX(), tempObject.getY()+48 ,handler, ObjectId.Skills, tempObject.getFacing() * 8));
					}
				}
				if(keys == KeyEvent.VK_X && mana <= 10) {	
						recovery();
				}
				if(keys == KeyEvent.VK_Q ) {	
					Q += 1;
					if(W==3 || E ==3) {
						W = 0;
						E = 0;
					}
					if(Q > 3) {
						Q = 0;
					}
					System.out.println(Q);
				}
				if(keys == KeyEvent.VK_W ) {	
					W += 1;
					if(Q==3 || E ==3) {
						Q = 0;
						E = 0;
					}
					if(W > 3) {
						W = 0;
					}
					System.out.println(W);
				}
				if(keys == KeyEvent.VK_E ) {	
					E += 1;
					if(W==3 || Q ==3) {
						W = 0;
						Q = 0;
					}
					if(E > 3) {
						E = 0;
					}
					System.out.println(E);
				}
			}
		}
		
		if(keys == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int keys = e.getKeyCode();
		

		for(int i=0;i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ObjectId.Player) {
				if(keys == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
				if(keys == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
			}
		}
		
	}
	
}
