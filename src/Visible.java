import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;



public class Visible extends GameObject {
	
	Texture tex = Game.getInstance();
	int type;
	public Visible(float x, float y, ObjectId id,int type) {
		super(x, y, id);
		this.type = type;
	}

	
	public void tick(LinkedList<GameObject> object) {
	}


	public void render(Graphics g) {
		
		if(type == 1 ) {
			g.drawImage(tex.visible[0], (int)x, (int)y, null);
		}
		if(type == 2 ) {
			g.drawImage(tex.visible[1], (int)x, (int)y, null);
		}
		
	Graphics2D g2d = (Graphics2D) g;
		
//		g.setColor(Color.red);
//		g2d.draw(getBounds());

	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	@Override
	public Rectangle getBoundsHalf() {
		return null;
	}
}
