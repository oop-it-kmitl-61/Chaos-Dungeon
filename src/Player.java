import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;


public class Player extends GameObject{
	
	private float width = 64, height = 96;
	private final float MAX_SPEED = 10;
	private float gravity = 0.1f;
	private static int health = 120;
	private boolean death = false;
	
	private Handler handler;
	private Camera cam;
	Texture tex = Game.getInstance();
	
	private Animation playerstand, playerwalkright, playerjumpright,playerjumpleft,playerstandleft,playerwalkleft;
	
	
	public Player(float x, float y, Handler handler, Camera cam, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		this.cam = cam;
		
		playerstand = new Animation(10, tex.player[0], tex.player[1], tex.player[2]);
		playerwalkright = new Animation(10,tex.player[3],tex.player[4],tex.player[5], tex.player[6]);
		playerjumpright = new Animation(10,tex.player[9]);
		playerjumpleft = new Animation(10,tex.player[10]);
		playerwalkleft = new Animation(10, tex.player[14], tex.player[15], tex.player[16], tex.player[17]);
		playerstandleft = new Animation(10,tex.player[11],tex.player[12],tex.player[13]);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		
		if(velX < 0) {
			facing = -1;
		}else if(velX > 0){
			facing = 1;
		}
		
		if(falling || jumping) {
			velY += gravity;
			if(velY > MAX_SPEED) {
				velY=MAX_SPEED;
			}
		}
		if(y>600) {
			System.exit(1);
		}
		if(health <= 0){
			death = true;
			
		}else {
			death = false;
		}
			Collision(object);
		
		playerstand.runAnimation();
		playerwalkright.runAnimation();
		playerjumpleft.runAnimation();
		playerjumpright.runAnimation();
		playerstandleft.runAnimation();
		playerwalkleft.runAnimation();
	}
	private void Collision(LinkedList<GameObject> object) {
		
		for(int i=0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ObjectId.Block) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					y = tempObject.getY() + 35;
					velY = 0;
				}
				if(getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					falling =false;
					jumping = false;
				}
				//Right หาความเหมาะสมด้วยตัวเอง
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width;
				}
				//Left หาความเหมาะสมด้วยตัวเอง
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + 32;
				}
				else {
					falling = true;
				}
			}
			else if(tempObject.getID() == ObjectId.Enemy) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102 ;
					health = health -10;
				}
				if(getBounds().intersects(tempObject.getBounds())) {

					x = tempObject.getX() - 102 ;
					health = health - 10;
				}
				//Right หาความเหมาะสมด้วยตัวเอง
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102;
					health = health - 10;
				}
				//Left หาความเหมาะสมด้วยตัวเอง
				if(getBoundsLeft().intersects(tempObject.getBounds())) {

					x = tempObject.getX() + 80;
					health = health -10;
				}
			}
			else if(tempObject.getID() == ObjectId.Enemy2) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102 ;
					health = health -10;
				}
				if(getBounds().intersects(tempObject.getBounds())) {

					x = tempObject.getX() - 102 ;
					health = health - 10;
				}
				//Right หาความเหมาะสมด้วยตัวเอง
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102;
					health = health - 10;
				}
				//Left หาความเหมาะสมด้วยตัวเอง
				if(getBoundsLeft().intersects(tempObject.getBounds())) {

					x = tempObject.getX() + 80;
					health = health -10;
				}
			}
			else if(tempObject.getID() == ObjectId.Boss ) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102 ;
					health = health -40;
				}
				if(getBounds().intersects(tempObject.getBounds())) {

					x = tempObject.getX() - 102 ;
					health = health - 40;
				}
				//Right หาความเหมาะสมด้วยตัวเอง
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102;
					health = health - 40;
				}
				//Left หาความเหมาะสมด้วยตัวเอง
				if(getBoundsLeft().intersects(tempObject.getBounds())) {

					x = tempObject.getX() + 80;
					health = health -40;
				}
			}
			else if(tempObject.getID() == ObjectId.Enemy3 ) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102 ;
					health = health -15;
				}
				if(getBounds().intersects(tempObject.getBounds())) {

					x = tempObject.getX() - 102 ;
					health = health - 15;
				}
				//Right หาความเหมาะสมด้วยตัวเอง
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102;
					health = health - 15;
				}
				//Left หาความเหมาะสมด้วยตัวเอง
				if(getBoundsLeft().intersects(tempObject.getBounds())) {

					x = tempObject.getX() + 80;
					health = health -20;
				}
			}
			else if(tempObject.getID() == ObjectId.Enemy4 ) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102 ;
					health = health -20;
				}
				if(getBounds().intersects(tempObject.getBounds())) {

					x = tempObject.getX() - 102 ;
					health = health - 20;
				}
				//Right หาความเหมาะสมด้วยตัวเอง
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - 102;
					health = health - 20;
				}
				//Left หาความเหมาะสมด้วยตัวเอง
				if(getBoundsLeft().intersects(tempObject.getBounds())) {

					x = tempObject.getX() + 80;
					health = health -20;
				}
			}
			else if(tempObject.getID() == ObjectId.Flag) {
				//switch map
				if(getBounds().intersects(tempObject.getBounds()) && countItem1 >= 3 || 
						getBounds().intersects(tempObject.getBounds()) && countItem2 >= 1 && countItem4 >= 1 ||
						getBounds().intersects(tempObject.getBounds()) && countItem2 >= 1 && countItem3 >=2 && countItem4 >= 1 ||
						getBounds().intersects(tempObject.getBounds()) && countItem0 == 3
						) {
					countItem0 = 0;
					countItem1 = 0;
					countItem2 = 0;
					countItem3 = 0;
					countItem4 = 0;
  		 			handler.switchlevel();
				}
			}
			//star
			else if(tempObject.getID() == ObjectId.Item){
				if(getBounds().intersects(tempObject.getBounds())) {
					countItem0 +=1;
					System.out.println(countItem1);
				}
			}
			else if(tempObject.getID() == ObjectId.Item1){
				if(getBounds().intersects(tempObject.getBounds())) {
					countItem1 +=1;
					System.out.println(countItem1);
				}
			}
			else if(tempObject.getID() == ObjectId.Item2){
				if(getBounds().intersects(tempObject.getBounds())) {
					countItem2 +=1;
					System.out.println(countItem1);
				}
			}
			else if(tempObject.getID() == ObjectId.Item3){
				if(getBounds().intersects(tempObject.getBounds())) {
					countItem3 +=1;
					System.out.println(countItem1);
				}
			}
			else if(tempObject.getID() == ObjectId.Item4){
				if(getBounds().intersects(tempObject.getBounds())) {
					countItem4 +=1;
					System.out.println(countItem1);
				}
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		if(jumping) {
			if(facing == 1) {
				playerjumpright.drawAnimation(g, (int)x, (int)y, 64, 96);
			}
			else {
				playerjumpleft.drawAnimation(g, (int)x, (int)y, 64,96);
			}
		}else if(death) {
			System.exit(1);
		}
		else {
			if(velX != 0) {
				if(facing == 1) {
				playerwalkright.drawAnimation(g, (int)x, (int)y, 64, 96);
				}
				else {
					playerwalkleft.drawAnimation(g, (int)x, (int)y, 64,96);
				}
			}
			else {
				if(facing == 1) {
					playerstand.drawAnimation(g, (int)x, (int)y, 64, 96);
				}
				else {
					playerstandleft.drawAnimation(g, (int)x, (int)y, 64, 96);
				}
		}
}
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.red);
		// เป็นการวาดเส้นเพื่อหาความเหมาะในการชนของภาพ
//		g2d.draw(getBounds());
//		g2d.draw(getBoundsRight());
//		g2d.draw(getBoundsLeft());
//		g2d.draw(getBoundsTop());
		//ลบได้เมื่อเสร็จแล้ว
	}
	
	public static int getHealth(){
		return health;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsTop() {
		
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsHalf() {
		return null;
	}

}
