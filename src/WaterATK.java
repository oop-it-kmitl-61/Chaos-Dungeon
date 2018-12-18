import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class WaterATK extends GameObject{

	Texture tex = Game.getInstance();


	private Handler handler;

	public WaterATK(float x, float y, Handler handler,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		y -= 8;
		Collision(object);
	}

	private void Collision(LinkedList<GameObject> object) {
		for(int i=0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ObjectId.Enemy2) {
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
			g.drawImage(tex.skills[3], (int)x, (int)y, 50, 50, null);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 30 ,30);
	}
	public Rectangle getBoundsHalf() {
		return null;
	}

	
}
