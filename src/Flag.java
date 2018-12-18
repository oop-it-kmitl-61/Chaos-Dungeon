	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;
	import java.util.LinkedList;
public class Flag extends GameObject {
		Texture tex = Game.getInstance();
		private Handler handler;
		
		public Flag(float x, float y,ObjectId id) {
			super(x, y, id);
		}

		@Override
		public void tick(LinkedList<GameObject> object) {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(tex.warps[0], (int)x, (int)y, 64, 64, null);
		}

		@Override
		public Rectangle getBounds() {
			
			return new Rectangle((int)x, (int)y, 64,64);
		}

		@Override
		public Rectangle getBoundsHalf() {
			// TODO Auto-generated method stub
			return null;
		}
	}
