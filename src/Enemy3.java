import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;



public class Enemy3 extends GameObject{
	
	private float width = 48, height = 48;
	private int health = 200;
	private int walk = 3;
	private float gravity = 1f;
	private Animation walkright, walkleft;
	
	private boolean death = false;
	private Handler handler;
	Texture tex = Game.getInstance();
	Random rand = new Random();
	int r = rand.nextInt(9) + 6;
	int ri = rand.nextInt(100);
	public Enemy3(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		walkright = new Animation(10, tex.monster2[0], tex.monster2[1],tex.monster2[2]);
		walkleft = new Animation(10, tex.monster2[3], tex.monster2[4],tex.monster2[5]);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		x += walk;
		y += gravity;
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
					y = tempObject.getY() - 70;
					
				}
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					walk = 3;
					facing =1;
				}
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					walk = -3;
					facing = -1;
				}
			}
			else if(tempObject.getID() ==  ObjectId.Skills) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 60;
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy3(r*32 ,1*32, handler, ObjectId.Enemy3)); 
							if(ri%2 == 0) {
								handler.addObject(new Item3(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item3));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.Fireball) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 20;
					System.out.println(health);
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy3(r*32 ,1*32, handler, ObjectId.Enemy3)); 
							if(ri%2 == 0) {
								handler.addObject(new Item3(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item3));
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
							handler.addObject(new Enemy3(r*32 ,1*32, handler, ObjectId.Enemy3)); 
							if(ri%2 == 0) {
								handler.addObject(new Item3(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item3));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.Storm) {
				if(getBounds().intersects(tempObject.getBounds())) {
					health = health - 20;
					System.out.println(health);
					System.out.println(health);
					if(death) {
							handler.removeObject(this);
							handler.addObject(new Enemy3(r*32 ,1 *32, handler, ObjectId.Enemy3)); 
							if(ri%2 == 0) {
								handler.addObject(new Item3(tempObject.getX(), tempObject.getY() ,handler, ObjectId.Item3));
							}
					} 
				}
			}
			else if(tempObject.getID() ==  ObjectId.Visible) {
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					walk = 3;
					facing = 1;
				}
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					walk = -3;
					facing = -1;
				}
			}
	}
}
	@Override
	public void render(Graphics g) {
//		g.setColor(Color.yellow);
//		g.fillRect((int)x, (int)y, (int)width, (int)height);
			if(facing == 1) {
				walkright.drawAnimation(g, (int)x, (int)y, 48, 48);
				}
				else {
					walkleft.drawAnimation(g, (int)x, (int)y, 48,48);
				}
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.red);
//		// เป็นการวาดเส้นเพื่อหาความเหมาะในการชนของภาพ
//		g2d.draw(getBounds());
//		g2d.draw(getBoundsHalf());
//		g2d.draw(getBoundsRight());
//		g2d.draw(getBoundsLeft());
		//ลบได้เมื่อเสร็จแล้ว
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsHalf() {
		return new Rectangle((int)x+22, (int)y, 4, 48 );
	}
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
}
