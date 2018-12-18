import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Storm extends GameObject{

	Texture tex = Game.getInstance();


	private Handler handler;

	public Storm(float x, float y, Handler handler,ObjectId id, int velX) {
		super(x, y, id);
		this.velX = velX;
		this.handler = handler;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		Collision(object);
	}

	private void Collision(LinkedList<GameObject> object) {
		for(int i=0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ObjectId.Enemy) {
				if(getBounds().intersects(tempObject.getBoundsHalf())) {
					handler.removeObject(this);
				}
			}
			if(tempObject.getID() == ObjectId.Enemy2) {
				if(getBounds().intersects(tempObject.getBoundsHalf())) {
					handler.removeObject(this);
				}
			}
			if(tempObject.getID() == ObjectId.Enemy3) {
				if(getBounds().intersects(tempObject.getBoundsHalf())) {
					handler.removeObject(this);
				}
			}
			if(tempObject.getID() == ObjectId.Boss) {
				if(getBounds().intersects(tempObject.getBoundsHalf())) {
					handler.removeObject(this);
				}
			}
			if(tempObject.getID() == ObjectId.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
}
	
	@Override
	public void render(Graphics g) {
			g.drawImage(tex.skills[2], (int)x, (int)y, 50, 80, null);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 30 ,80);
	}
	public Rectangle getBoundsHalf() {
		return null;
	}

	
}
