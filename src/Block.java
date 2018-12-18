import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;



public class Block extends GameObject {
	
	Texture tex = Game.getInstance();
	private int type;
	
	public Block(float x, float y,int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}

	
	public void tick(LinkedList<GameObject> object) {
	}


	public void render(Graphics g) {
		
		if(type == 0) {
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		}
		if(type == 1) {
			g.drawImage(tex.block[1], (int)x, (int)y, null);
		}
		if(type == 2) {
			g.drawImage(tex.block[2], (int)x, (int)y, null);
		}
		if(type == 3) {
			g.drawImage(tex.block[3], (int)x, (int)y, null);
		}
		if(type == 4) {
			g.drawImage(tex.block[4], (int)x, (int)y, null);
		}
		if(type == 5) {
			
		}

	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}


	@Override
	public Rectangle getBoundsHalf() {
		// TODO Auto-generated method stub
		return null;
	}
}
