import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
public abstract class GameObject {
	// เป้นคลาสที่ไม่สมบูรณ์ คลาสอื่นสามารถเรียกใช้จากที่นี่ได้
	protected float x, y;
	protected ObjectId id;
	protected float velX = 0, velY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	protected int facing = 1;
	protected int mana =  100;
	
	protected int getMana() {
		return mana;
	}
	protected void setMana(int mana) {
		this.mana = mana;
	}

	protected static int countItem0 =0;
	protected static int countItem1 =0;
	protected static int countItem2 =0;
	protected static int countItem3 =0;
	protected static int countItem4 =0;
	protected static float EXP = 0;
	protected static int LEVEL = 1;
	protected static float BAR_EXP = 500;
	
	protected int count = 0;
	
	protected boolean isFalling() {
		return falling;
	}
	protected void setFalling(boolean falling) {
		this.falling = falling;
	}
	protected boolean isJumping() {
		return jumping;
	}
	protected void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public GameObject(float x, float y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract Rectangle getBoundsHalf();
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void setX(float x) {
		this.x =x;
	}
	public void setY(float y) {
		this.y =y;
	}
	
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public int getFacing() {
		return facing;
	}
	
	public ObjectId getID() {
		return id;
	}
}
