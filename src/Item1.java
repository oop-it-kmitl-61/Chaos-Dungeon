import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Item1 extends GameObject{
	private float width = 40, height = 40;
	private float gravity = 1f;
	Texture tex = Game.getInstance();
	private Handler handler;
	
	public Item1(float x, float y, Handler handler,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		y += gravity;
		Collision(object);
	}

	private void Collision(LinkedList<GameObject> object) {
		for(int i=0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ObjectId.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - 40;
				}
			}
			if(tempObject.getID() == ObjectId.Player) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(tex.items1[0], (int)x, (int)y, 40, 40, null);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 40 ,40);
	}
	public Rectangle getBoundsHalf() {
		return null;
	}

	
}
