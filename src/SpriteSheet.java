import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage img;
	public SpriteSheet(BufferedImage img) {
		this.img = img;
	}
	
	public BufferedImage grabImage() {
		return img;
	}
	
	public BufferedImage cropImage(int col, int row, int width, int height) {
		BufferedImage imag = img.getSubimage(col,row, width, height);
		
		return imag;
	}
	
}
