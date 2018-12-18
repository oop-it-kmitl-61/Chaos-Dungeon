import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;


public class Enemy2 extends GameObject{

	private float width = 64, height = 64;
	private float gravity = 1f;
	private int health = 120;
	private int walk = 3;
	private boolean death = false;
	private Animation walkright, walkleft;
	private Handler handler;
	Texture tex = Game.getInstance();
	Random rand = new Random();
	int r = rand.nextInt(9) + 32;
	int ri = rand.nextInt(100);
	public Enemy2(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		walkright = new Animation(10, tex.monster1[0], tex.monster1[1],tex.monster1[2], tex.monster1[3],tex.monster1[4], tex.monster1[5]);
		walkleft = new Animation(10, tex.monster1[6], tex.monster1[7],tex.monster1[8], tex.monster1[9],tex.monster1[10], tex.monster1[11]);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		y += gravity;
		x += walk;
		if(health <= 0) {
			death = true;
		}
		Collision(object);
		walkright.runAnimation();
		walkleft.runAnimation();
	}
	private void Collision(LinkedList<GameObject> object) {
		
		for(int i=0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ObjectId.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					walk = 3;
					facing =1;
				}
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					walk = -3;
					facing =-1;
				}
			}
			else if(tempObject.getID() ==  ObjectId.Fireball) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 50;
					System.out.println(health);
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy2(r*32 ,10*32, handler, ObjectId.Enemy2)); 
							if(ri%2 == 0) {
								handler.addObject(new Item2(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item2));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.WaterATK) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 10;
					System.out.println(health);
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy2(r*32 ,10*32, handler, ObjectId.Enemy2)); 
							if(ri%2 == 0) {
								handler.addObject(new Item2(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item2));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.Storm) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 20;
					y -= 50;
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy2(r*32 ,10*32, handler, ObjectId.Enemy2)); 
							if(ri%2 == 0) {
								handler.addObject(new Item2(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item2));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.Skills) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 10;
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy2(r*32 ,10*32, handler, ObjectId.Enemy2)); // สร้างใหม่เมื่อตาย
							if(ri%2 == 0) {
								handler.addObject(new Item2(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item2));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.Visible) {
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					walk = 2;
					facing =1;
				}
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					walk = -2;
					facing =-1;
				}
			}
	}
}
	@Override
	public void render(Graphics g) {

		if(facing == 1) {
			walkright.drawAnimation(g, (int)x, (int)y, 64, 64);
			}
			else {
			walkleft.drawAnimation(g, (int)x, (int)y, 64,64);
			}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsHalf() {
		return new Rectangle((int)x+30, (int)y, 4, 64 );
	}
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
}
