import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private boolean running = false;
	private Thread th;
	public static int WIDTH, HEIGHT;
	GameObject ob;
	//Object
	Handler handler;
	Camera cam;
	static Texture tex;
	public BufferedImage level = null, bg=null;
	
	public void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level.png");
		bg = loader.loadImage("/BG.png");
		
		handler = new Handler(cam);
		cam = new Camera(0, 0);

		
		
		handler.LoadImageLevel(level);
		//handler.addObject(new Player(100,100, handler, ObjectId.Player));
		//handler.addObject(new Enemy(0,300, handler, ObjectId.Enemy));
		//handler.creatLevel();
		
		this.addKeyListener(new Controll(handler));
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		th = new Thread(this);
		th.start();
	}
	
	public void run() {
		
		init();
		this.requestFocus();
		
		int fps = 60;
		double timePerTick = 1000000000 /fps;
		double delta =0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks =0;
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) {
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " +ticks);
				ticks=0;
				timer = 0;
			}
		}
	}
	
	private void tick() {
		handler.tick();
		for(int i=0;i < handler.object.size();i++) {
			if(handler.object.get(i).getID() == ObjectId.Player) {
				cam.tick(handler.object.get(i));
			}
		}


	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
         
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//draw

		
		
		g.drawImage(bg, 0, 0, 999,625,this);
		
		g2d.translate(cam.getX(), cam.getY()); // เริ่ม
		handler.render(g);
		g2d.translate(-cam.getX(), -cam.getY()); // จบ
		//End
		g.dispose();
		bs.show();
		
	}
	
	
	public static Texture getInstance() {
		return tex;
	}
}
