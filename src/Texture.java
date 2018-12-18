import java.awt.image.BufferedImage;

public class Texture {
	
	SpriteSheet pj,bs, ps,ps1,ps2,sk2,sk,sk1,sk3,wp, it,it1,it2,it3,it4,ms2,boss1,boss2,boss3,boss4;
	SpriteSheet msA,msB,msC,msD;
	SpriteSheet ms4A,ms4B,ms4C,ms4D;
	SpriteSheet ms1A,ms1B;
	SpriteSheet vs,vs1,bs1,bs2,bs3,bs4;
	private BufferedImage block_sheet = null,block_sheet1 = null, block_sheet2=null, block_sheet3=null, block_sheet4=null;
	
	private BufferedImage Boss1 = null;
	private BufferedImage Boss2 = null;
	private BufferedImage Boss3 = null;
	private BufferedImage Boss4 = null;
	
	private BufferedImage visible_sheet = null;
	private BufferedImage visible_sheet1 = null;
	
	private BufferedImage monster_sheet1a=null;
	private BufferedImage monster_sheet1b = null;
	//monster 2
	private BufferedImage monster_sheeta=null;
	private BufferedImage monster_sheetb=null;
	private BufferedImage monster_sheetc=null;
	private BufferedImage monster_sheetd=null;
	//monster 4
	private BufferedImage monster_sheet4a = null;
	private BufferedImage monster_sheet4b = null;
	private BufferedImage monster_sheet4c = null;
	private BufferedImage monster_sheet4d = null;
	
	
	private BufferedImage monster_sheet2 = null;
	private BufferedImage player_sheet = null;
	private BufferedImage player_sheet1 = null;
	private BufferedImage player_sheet2 = null;
	private BufferedImage player_jump = null;
	//skills
	private BufferedImage skill = null;
	private BufferedImage skill1 = null;
	private BufferedImage skill2 = null;
	private BufferedImage skill3 = null;
	//items
	private BufferedImage item = null;
	private BufferedImage item1 = null;
	private BufferedImage item2 = null;
	private BufferedImage item3 = null;
	private BufferedImage item4 = null;
	
	private BufferedImage warp = null;
	
	public BufferedImage[] monster = new BufferedImage[4];
	public BufferedImage[] monster1 = new BufferedImage[12];
	public BufferedImage[] monster2 = new BufferedImage[6];
	public BufferedImage[] monster3 = new BufferedImage[4];
	public BufferedImage[] block = new BufferedImage[5];
	public BufferedImage[] player = new BufferedImage[18];
	public BufferedImage[] skills = new BufferedImage[4];
	//items
	public BufferedImage[] items = new BufferedImage[1];
	public BufferedImage[] items1 = new BufferedImage[1];
	public BufferedImage[] items2 = new BufferedImage[1];
	public BufferedImage[] items3 = new BufferedImage[1];
	public BufferedImage[] items4 = new BufferedImage[1];
	
	public BufferedImage[] visible = new BufferedImage[3];
	public BufferedImage[] warps = new BufferedImage[1];
	public BufferedImage[] bosss = new BufferedImage[4];
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			visible_sheet = loader.loadImage("/tiles/18.png");
			visible_sheet1 = loader.loadImage("/tiles/17.png");
			
			
			block_sheet = loader.loadImage("/tiles/5.png");
			block_sheet1 = loader.loadImage("/tiles/2.png");
			block_sheet2 = loader.loadImage("/tiles/9.png");
			block_sheet3 =loader.loadImage("/tiles/1.png");
			block_sheet4 = loader.loadImage("/tiles/3.png");
			
			player_sheet = loader.loadImage("/player1.png");
			player_sheet1 = loader.loadImage("/left.png");
			player_sheet2 = loader.loadImage("/left1.png");
			player_jump = loader.loadImage("/jump.png");
			
			skill = loader.loadImage("/skill.png");
			skill1 = loader.loadImage("/fire.png");
			skill2 = loader.loadImage("/storm.png");
			skill3 = loader.loadImage("/Water.png");
			//monster2
			monster_sheeta = loader.loadImage("/monster1/mosterright1.png");
			monster_sheetb = loader.loadImage("/monster1/mosterright2.png");
			monster_sheetc = loader.loadImage("/monster1/mosterleft1.png");
			monster_sheetd = loader.loadImage("/monster1/mosterleft2.png");
			
			//monster 4
			monster_sheet4a = loader.loadImage("/monster1/right1.png");
			monster_sheet4b = loader.loadImage("/monster1/right2.png");
			monster_sheet4c = loader.loadImage("/monster1/left1.png");
			monster_sheet4d = loader.loadImage("/monster1/left2.png");
			
			Boss1 = loader.loadImage("/monster1/bossr1.png");
			Boss2 = loader.loadImage("/monster1/bossr2.png");
			Boss3 = loader.loadImage("/monster1/bossl1.png");
			Boss4 = loader.loadImage("/monster1/bossl2.png");
			
			monster_sheet1a = loader.loadImage("/slime.png");
			monster_sheet1b = loader.loadImage("/slime2.png");
			
			monster_sheet2 = loader.loadImage("/harpy.png");
			warp = loader.loadImage("/warp.png");
			item = loader.loadImage("/item.png");
			item1 = loader.loadImage("/item1.png");
			item2 = loader.loadImage("/item2.png");
			item3 = loader.loadImage("/item3.png");
			item4 = loader.loadImage("/item4.png");

		}catch(Exception e) {
			e.printStackTrace();
		}
		vs = new SpriteSheet(visible_sheet);
		vs1 = new SpriteSheet(visible_sheet1);
		
		bs = new SpriteSheet(block_sheet);
		bs1 = new SpriteSheet(block_sheet1);
		bs2 = new SpriteSheet(block_sheet2);
		bs3 = new SpriteSheet(block_sheet3);
		bs4 = new SpriteSheet(block_sheet4);
		
		boss1 = new SpriteSheet(Boss1);
		boss2 = new SpriteSheet(Boss2);
		boss3 = new SpriteSheet(Boss3);
		boss4 = new SpriteSheet(Boss4);
		
		ps = new SpriteSheet(player_sheet);
		ps1 = new SpriteSheet(player_sheet1);
		ps2 = new SpriteSheet(player_sheet2);
		pj = new SpriteSheet(player_jump);
		sk2 = new SpriteSheet(skill2);
		sk = new SpriteSheet(skill);
		sk1 = new SpriteSheet(skill1);
		sk3 = new SpriteSheet(skill3);
		
		msA = new SpriteSheet(monster_sheeta);
		msB = new SpriteSheet(monster_sheetb);
		msC = new SpriteSheet(monster_sheetc);
		msD = new SpriteSheet(monster_sheetd);
		
		ms4A = new SpriteSheet(monster_sheet4a);
		ms4B = new SpriteSheet(monster_sheet4b);
		ms4C = new SpriteSheet(monster_sheet4c);
		ms4D = new SpriteSheet(monster_sheet4d);
		
		ms1A = new SpriteSheet(monster_sheet1a);
		ms1B = new SpriteSheet(monster_sheet1b);
		ms2 = new SpriteSheet(monster_sheet2);
		wp = new SpriteSheet(warp);
		
		it = new SpriteSheet(item);
		it1 = new SpriteSheet(item1);
		it2 = new SpriteSheet(item2);
		it3 = new SpriteSheet(item3);
		it4 = new SpriteSheet(item4);
		
		getTextures();
		
	}
	
	private void getTextures() {
		visible[0] = vs.cropImage(0, 0, 32, 32);
		visible[1] = vs1.grabImage();
		block[0] = bs.cropImage(0, 0, 32, 32);
		block[1] = bs1.grabImage();
		block[2] = bs2.grabImage();
		block[3] = bs3.grabImage();
		block[4] = bs4.grabImage();

		//skills
		skills[0] = sk.grabImage();
		skills[1] = sk1.grabImage();
		skills[2] = sk2.grabImage();
		skills[3] = sk3.grabImage();
		//item
		items[0] = it.grabImage();
		items1[0] = it1.grabImage();
		items2[0] = it2.grabImage();
		items3[0] = it3.grabImage();
		items4[0] = it4.grabImage();
		//monster
		monster[0] = msA.cropImage(0,0,127,106);
		monster[1] = msB.cropImage(0,0,127,106);
		monster[2] = msC.cropImage(0,0,127,106);
		monster[3] = msD.cropImage(0,0,127,106);
		
		//monster 4
		monster3[0] = ms4A.cropImage(16, 0, 87, 88);
		monster3[1] = ms4B.cropImage(16, 0, 87, 88);
		monster3[2] = ms4C.cropImage(16, 0, 87, 88);
		monster3[3] = ms4D.cropImage(16, 0, 87, 88);
		//slime
		monster1[0] = ms1A.cropImage(13,20,52,32);
		monster1[1] = ms1A.cropImage(88,20,52,32);
		monster1[2] = ms1A.cropImage(162,20,52,32);
		monster1[3] = ms1A.cropImage(236,20,52,32);
		monster1[4] = ms1A.cropImage(310,20,52,32);
		monster1[5] = ms1A.cropImage(386,20,52,32);
		monster1[6] = ms1B.cropImage(13,20,52,32);
		monster1[7] = ms1B.cropImage(88,20,52,32);
		monster1[8] = ms1B.cropImage(162,20,52,32);
		monster1[9] = ms1B.cropImage(236,20,52,32);
		monster1[10] = ms1B.cropImage(310,20,52,32);
		monster1[11] = ms1B.cropImage(386,20,52,32);

		//monster 3
		monster2[0] = ms2.cropImage(9,120,42,59);
		monster2[1] = ms2.cropImage(77,120,42,59);
		monster2[2] = ms2.cropImage(154,120,42,59);
		monster2[3] = ms2.cropImage(22,60,42,59);
		monster2[4] = ms2.cropImage(93,60,42,59);
		monster2[5] = ms2.cropImage(167,60,42,59);

		//boss
		bosss[0] = boss1.cropImage(16, 29, 99, 88);
		bosss[1] = boss2.cropImage(16, 29, 99, 88);
		bosss[2] = boss3.cropImage(16, 29, 99, 88);
		bosss[3] = boss4.cropImage(16, 29, 99, 88);
		
		//warp
		warps[0] = wp.grabImage();
		//stand
		player[0] = ps.cropImage(47, 13, 74, 74);
		player[1] = ps.cropImage(123, 13, 74, 74);
		player[2] = ps.cropImage(199, 13, 74, 74);
		
		//right
		player[3] = ps.cropImage(24, 102, 74, 74);
		player[4] = ps.cropImage(98, 102, 74, 74);
		player[5] = ps.cropImage(186, 102, 74, 74);
		player[6] = ps.cropImage(264, 101, 74, 74);
		
		//jump

		player[9] = ps.cropImage(169, 189, 74, 74);
		player[10] = pj.cropImage(13, 0, 61, 79);

		
		//standlef
		player[11] = ps1.cropImage(13, 0, 62,73);
		player[12] = ps1.cropImage(86, 0, 62, 73);
		player[13] = ps1.cropImage(159, 0, 62, 73);
		//left
		player[14] = ps2.cropImage(13, 0, 59, 73);
		player[15] = ps2.cropImage(87, 0, 59, 73);
		player[16] = ps2.cropImage(163, 0, 59, 73);
		player[17] = ps2.cropImage(239, 0, 57, 73);
	}
	
}
