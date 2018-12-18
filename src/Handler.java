import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

public class Handler {

	public LinkedList<GameObject> object =new LinkedList<GameObject>();
	
	private BufferedImage level2 = null, level3=null, level=null,boss=null;
	private Camera cam;
	private GameObject tempobject;
	
	public int MAP = 1;
	public Handler(Camera cam) {
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level2 = loader.loadImage("/level2.png");
		level3 = loader.loadImage("/level3.png");
		boss = loader.loadImage("/boss.png");
	}
	
	public void tick() {
		for(int i=0;i < object.size();i++) {
			tempobject = object.get(i);
			
			((GameObject) tempobject).tick(object);
		}
	}
	
	public void render(Graphics g) {
		for(int i=0;i < object.size();i++) {
			tempobject = object.get(i); 
			
			((GameObject) tempobject).render(g);
		}
	}
	
	public void switchlevel() {
		clearlevel();
		if(MAP == 1) {
			LoadImageLevel(level2);
		}
		else if(MAP == 2) {
			LoadImageLevel(level3);
		}
		else if(MAP == 3) {
			LoadImageLevel(boss);
			
		}
		else if(MAP == 4) {
			System.exit(1);
		}
		MAP++;
		
	}
	
	private void clearlevel() {
		object.clear();
	}
	
	public void LoadImageLevel(BufferedImage img) {
		int w = img.getWidth();
		int h = img.getHeight();
		for(int xx = 0; xx<h;xx++) {
			for(int yy = 0; yy< w;yy++) {
				int pixel = img.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 && blue == 255) {
					addObject(new Block(xx*32,yy*32, 0,ObjectId.Block));
				}
				if(red == 0 && green == 0 && blue == 255) {
					addObject(new Player(xx*32 ,yy*32, this, cam, ObjectId.Player));// ตำแหน่งตัวละคร
				}
				if(red == 255 && green == 0 && blue == 0) {

					addObject(new Enemy(xx*32 ,yy*32, this, ObjectId.Enemy));// ตำแหน่ง มอนสเตอร์
				}
				if(red == 245 && green == 255 && blue == 63) {
					addObject(new Flag(xx*32 ,yy*32, ObjectId.Flag));
				}
				if(red == 0 && green == 0 && blue == 237) {
					addObject(new Enemy2(xx*32 ,yy*32, this, ObjectId.Enemy2));
				}
				if(red == 255 && green == 96 && blue == 131) {
					addObject(new Enemy3(xx*32 ,yy*32, this, ObjectId.Enemy3));
				}
				if(red == 255 && green == 240 && blue == 109) {
					addObject(new Enemy4(xx*32 ,yy*32, this, ObjectId.Enemy4));
				}
				if(red == 255 && green == 50 && blue == 57) {
					addObject(new Visible(xx*32 ,yy*32, ObjectId.Visible,0));
				}
				if(red == 80 && green == 53 && blue == 255) {
					addObject(new Visible(xx*32 ,yy*32, ObjectId.Visible,1));
				}
				if(red == 210 && green == 50 && blue == 255) {
					addObject(new Visible(xx*32 ,yy*32, ObjectId.Visible,2));
				}
				if(red == 7 && green == 255 && blue == 77) {
					addObject(new Block(xx*32 ,yy*32, 1,ObjectId.Block));
				}
				if(red == 97 && green == 255 && blue == 94) {
					addObject(new Block(xx*32 ,yy*32, 2,ObjectId.Block));
				}
				if(red == 255 && green == 245 && blue == 107) {
					addObject(new Block(xx*32 ,yy*32, 3,ObjectId.Block));
				}
				if(red == 215 && green == 255 && blue == 107) {
					addObject(new Block(xx*32 ,yy*32, 4,ObjectId.Block));
				}
				if(red == 242 && green == 239 && blue == 255) {
					addObject(new Block(xx*32 ,yy*32, 5,ObjectId.Block));
				}
				if(red == 255 && green == 30 && blue == 68) {
					addObject(new Boss(xx*32 ,yy*32, this, ObjectId.Boss));
				}
			}
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}	
	}
	
