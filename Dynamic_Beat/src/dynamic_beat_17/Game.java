package dynamic_beat_17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game (String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		
		gameMusic = new Music(this.musicTitle, false);
	

		
	}
	
	int score = 0;
	
	int combo = 0;
	public void screenDraw(Graphics2D g) {
		
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		

		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0,580, null);
		
		for(int i=0; i < noteList.size(); i++) {
			
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
	            score = score - 10;
	            combo = 0;
			}
			
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
			
			
		}
		
		if(score<0) {
			g.drawString(String.valueOf(0), 210,609);
		}
		else {
			g.drawString(String.valueOf(score), 210,609);
		}
		
		
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		//g.drawString("Diamond eyes - Flutter ", 20, 702);
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.WHITE);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(String.valueOf(score), 565, 702);
		
		g.drawImage(blueFlareImage, 250, 150, null);
		g.drawImage(judgeImage, 570, 290, null);
		
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(String.valueOf(combo), 630, 290);
		//g.drawImage(blueFlareImage, 320, 430, null);
		//g.drawImage(judgeImage, 460, 420, null);
		
	}
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Flutter") && difficulty.equals("Easy"))  {
			int startTime = 18000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 24, "F"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 36, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 46, "K"), new Beat(startTime + gap * 50, "F"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 60, "S"), new Beat(startTime + gap * 62, "S"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 75, "F"), new Beat(startTime + gap * 78, "K"),
					new Beat(startTime + gap * 79, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 86, "K"), new Beat(startTime + gap * 97, "Space"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 106, "F"), new Beat(startTime + gap * 110, "D"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 127, "Space"), new Beat(startTime + gap * 129, "F"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 139, "K"), new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 153, "F"), new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 160, "S"), new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 171, "S"), new Beat(startTime + gap * 174, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 183, "J"), new Beat(startTime + gap * 186, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 212, "D"), new Beat(startTime + gap * 216, "F"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 227, "K"), new Beat(startTime + gap * 229, "F"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 239, "K"), new Beat(startTime + gap * 242, "F"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 253, "L"), new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 266, "K"), new Beat(startTime + gap * 269, "S"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 278, "D"), new Beat(startTime + gap * 281, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 297, "Space"), new Beat(startTime + gap * 300, "S"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 310, "J"), new Beat(startTime + gap * 320, "S"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 327, "K"), new Beat(startTime + gap * 329, "F"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 339, "K"), new Beat(startTime + gap * 342, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 353, "L"), new Beat(startTime + gap * 356, "J"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 366, "K"), new Beat(startTime + gap * 369, "L"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 378, "D"), new Beat(startTime + gap * 381, "F"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 388, "S"), new Beat(startTime + gap * 392, "D"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 404, "F"), new Beat(startTime + gap * 407, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 416, "D"), new Beat(startTime + gap * 419, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 430, "F"), new Beat(startTime + gap * 433, "L"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 442, "F"), new Beat(startTime + gap * 446, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 459, "D"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 477, "Space"), new Beat(startTime + gap * 480, "S"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 490, "D"), new Beat(startTime + gap * 493, "F"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 499, "F"), new Beat(startTime + gap * 502, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 512, "F"), new Beat(startTime + gap * 516, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 526, "J"), new Beat(startTime + gap * 530, "S"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 539, "Space"), new Beat(startTime + gap * 541, "S"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 551, "F"), new Beat(startTime + gap * 553, "J"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 568, "S"), new Beat(startTime + gap * 572, "D"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 584, "Space"), new Beat(startTime + gap * 587, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 596, "D"), new Beat(startTime + gap * 599, "K"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 610, "F"), new Beat(startTime + gap * 613, "L"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 622, "S"), new Beat(startTime + gap * 626, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 634, "K"), new Beat(startTime + gap * 638, "D"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 646, "K"), new Beat(startTime + gap * 647, "Space"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 656, "F"), new Beat(startTime + gap * 660, "D"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 674, "F"), new Beat(startTime + gap * 677, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 686, "D"), new Beat(startTime + gap * 689, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 700, "F"), new Beat(startTime + gap * 703, "L"),
					new Beat(startTime + gap * 706, "J"), 
			};
		}
		else if(titleName.equals("Flutter") && difficulty.equals("Hard") ) {
			int startTime = 18000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "F"), new Beat(startTime + gap * 5, "K"),
					new Beat(startTime + gap * 7, "F"), new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 11, "K"), new Beat(startTime + gap * 13, "S"),
					new Beat(startTime + gap * 16, "K"), new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 18, "F"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 21, "S"), new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 24, "F"), new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 31, "S"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 36, "D"), new Beat(startTime + gap * 37, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 44, "K"), new Beat(startTime + gap * 46, "S"),
					new Beat(startTime + gap * 50, "F"), new Beat(startTime + gap * 52, "D"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 58, "J"), new Beat(startTime + gap * 60, "S"),
					new Beat(startTime + gap * 62, "S"), new Beat(startTime + gap * 64, "K"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 73, "F"), new Beat(startTime + gap * 75, "F"),
					new Beat(startTime + gap * 78, "K"), new Beat(startTime + gap * 80, "K"),
					new Beat(startTime + gap * 81, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 85, "S"), new Beat(startTime + gap * 86, "K"),
					new Beat(startTime + gap * 97, "Space"), new Beat(startTime + gap * 99, "J"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 104, "D"), new Beat(startTime + gap * 106, "F"),
					new Beat(startTime + gap * 110, "D"), new Beat(startTime + gap * 115, "S"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 126, "K"), new Beat(startTime + gap * 127, "Space"),
					new Beat(startTime + gap * 129, "F"), new Beat(startTime + gap * 130, "K"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 137, "D"), new Beat(startTime + gap * 139, "K"),
					new Beat(startTime + gap * 142, "F"), new Beat(startTime + gap * 144, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 152, "J"), new Beat(startTime + gap * 153, "F"),
					new Beat(startTime + gap * 156, "J"), new Beat(startTime + gap * 158, "F"),
					new Beat(startTime + gap * 10, "K"), new Beat(startTime + gap * 160, "S"),
					new Beat(startTime + gap * 162, "S"), new Beat(startTime + gap * 164, "K"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 170, "J"), new Beat(startTime + gap * 171, "S"),
					new Beat(startTime + gap * 174, "K"), new Beat(startTime + gap * 176, "F"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 182, "K"), new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "K"), new Beat(startTime + gap * 190, "D"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 205, "F"), new Beat(startTime + gap * 212, "D"),
					new Beat(startTime + gap * 216, "F"), new Beat(startTime + gap * 219, "K"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 225, "K"), new Beat(startTime + gap * 227, "K"),
					new Beat(startTime + gap * 229, "F"), new Beat(startTime + gap * 230, "S"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 237, "F"), new Beat(startTime + gap * 239, "K"),
					new Beat(startTime + gap * 242, "F"), new Beat(startTime + gap * 243, "J"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 251, "D"), new Beat(startTime + gap * 253, "L"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 263, "F"), new Beat(startTime + gap * 266, "K"),
					new Beat(startTime + gap * 269, "S"), new Beat(startTime + gap * 270, "K"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 275, "K"), new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 281, "F"), new Beat(startTime + gap * 282, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 287, "K"), new Beat(startTime + gap * 297, "Space"),
					new Beat(startTime + gap * 300, "S"), new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 307, "K"), new Beat(startTime + gap * 310, "J"),
					new Beat(startTime + gap * 320, "S"), new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 326, "F"), new Beat(startTime + gap * 327, "K"),
					new Beat(startTime + gap * 329, "F"), new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 337, "S"), new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 342, "F"), new Beat(startTime + gap * 343, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 351, "K"), new Beat(startTime + gap * 353, "L"),
					new Beat(startTime + gap * 356, "J"), new Beat(startTime + gap * 357, "K"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 363, "F"), new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "L"), new Beat(startTime + gap * 370, "D"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 375, "F"), new Beat(startTime + gap * 378, "D"),
					new Beat(startTime + gap * 381, "F"), new Beat(startTime + gap * 382, "K"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 385, "F"), new Beat(startTime + gap * 388, "S"),
					new Beat(startTime + gap * 392, "D"), new Beat(startTime + gap * 393, "J"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 401, "K"), new Beat(startTime + gap * 404, "F"),
					new Beat(startTime + gap * 407, "K"), new Beat(startTime + gap * 408, "L"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 413, "S"), new Beat(startTime + gap * 416, "D"),
					new Beat(startTime + gap * 419, "K"), new Beat(startTime + gap * 420, "F"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 427, "D"), new Beat(startTime + gap * 430, "F"),
					new Beat(startTime + gap * 433, "L"), new Beat(startTime + gap * 434, "K"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 441, "F"), new Beat(startTime + gap * 442, "F"),
					new Beat(startTime + gap * 446, "K"), new Beat(startTime + gap * 447, "J"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 456, "K"), new Beat(startTime + gap * 458, "K"),
					new Beat(startTime + gap * 459, "D"), new Beat(startTime + gap * 460, "F"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 467, "K"), new Beat(startTime + gap * 477, "Space"),
					new Beat(startTime + gap * 480, "S"), new Beat(startTime + gap * 482, "F"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 487, "J"), new Beat(startTime + gap * 490, "D"),
					new Beat(startTime + gap * 493, "F"), new Beat(startTime + gap * 494, "F"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 498, "F"), new Beat(startTime + gap * 499, "F"),
					new Beat(startTime + gap * 502, "K"), new Beat(startTime + gap * 503, "S"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 510, "K"), new Beat(startTime + gap * 512, "F"),
					new Beat(startTime + gap * 516, "K"), new Beat(startTime + gap * 517, "F"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 524, "S"), new Beat(startTime + gap * 526, "J"),
					new Beat(startTime + gap * 530, "S"), new Beat(startTime + gap * 531, "D"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 537, "F"), new Beat(startTime + gap * 539, "Space"),
					new Beat(startTime + gap * 541, "S"), new Beat(startTime + gap * 542, "K"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 549, "J"), new Beat(startTime + gap * 551, "F"),
					new Beat(startTime + gap * 553, "J"), new Beat(startTime + gap * 554, "F"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 565, "K"), new Beat(startTime + gap * 568, "S"),
					new Beat(startTime + gap * 572, "D"), new Beat(startTime + gap * 573, "L"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 581, "F"), new Beat(startTime + gap * 584, "Space"),
					new Beat(startTime + gap * 587, "K"), new Beat(startTime + gap * 588, "S"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 593, "K"), new Beat(startTime + gap * 596, "D"),
					new Beat(startTime + gap * 599, "K"), new Beat(startTime + gap * 600, "D"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 607, "K"), new Beat(startTime + gap * 610, "F"),
					new Beat(startTime + gap * 613, "L"), new Beat(startTime + gap * 614, "F"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 621, "J"), new Beat(startTime + gap * 622, "S"),
					new Beat(startTime + gap * 626, "K"), new Beat(startTime + gap * 627, "L"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 632, "Space"), new Beat(startTime + gap * 634, "K"),
					new Beat(startTime + gap * 638, "D"), new Beat(startTime + gap * 639, "F"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 644, "D"), new Beat(startTime + gap * 646, "K"),
					new Beat(startTime + gap * 647, "Space"), new Beat(startTime + gap * 648, "K"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 653, "L"), new Beat(startTime + gap * 656, "F"),
					new Beat(startTime + gap * 660, "D"), new Beat(startTime + gap * 661, "J"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 672, "F"), new Beat(startTime + gap * 674, "F"),
					new Beat(startTime + gap * 677, "K"), new Beat(startTime + gap * 678, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 683, "S"), new Beat(startTime + gap * 686, "D"),
					new Beat(startTime + gap * 689, "K"), new Beat(startTime + gap * 690, "D"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 697, "F"), new Beat(startTime + gap * 700, "F"),
					new Beat(startTime + gap * 703, "L"), new Beat(startTime + gap * 704, "K"),
					new Beat(startTime + gap * 706, "J"), new Beat(startTime + gap * 710, "S"),
					new Beat(startTime + gap * 711, "D"), new Beat(startTime + gap * 712, "S"),
					new Beat(startTime + gap * 716, "K"), new Beat(startTime + gap * 717, "F"),
					new Beat(startTime + gap * 719, "F"), new Beat(startTime + gap * 720, "K"),
			};
		}
		else if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Easy") ) {
			int startTime = 4460 -Main.REACH_TIME * 1000;
			int gap = 170;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime+gap*1, "S"),
					new Beat(startTime+gap*3, "D"),
					new Beat(startTime+gap*5, "S"),
					new Beat(startTime+gap*7, "D"),
					new Beat(startTime+gap*9, "S"),
					new Beat(startTime+gap*11, "D"),
					new Beat(startTime+gap*13, "S"),
					new Beat(startTime+gap*15, "D"),
					new Beat(startTime+gap*18, "J"),
					new Beat(startTime+gap*20, "K"),
					new Beat(startTime+gap*22, "J"),
					new Beat(startTime+gap*24, "K"),
					new Beat(startTime+gap*26, "J"),
					new Beat(startTime+gap*28, "K"),
					new Beat(startTime+gap*30, "J"),
					new Beat(startTime+gap*32, "K"),
					new Beat(startTime+gap*35, "S"),
					new Beat(startTime+gap*37, "D"),
					new Beat(startTime+gap*39, "S"),
					new Beat(startTime+gap*41, "D"),
					new Beat(startTime+gap*43, "S"),
					new Beat(startTime+gap*45, "D"),
					new Beat(startTime+gap*48, "J"),
					new Beat(startTime+gap*49, "K"),
					new Beat(startTime+gap*50, "L"),
					new Beat(startTime+gap*52, "F"),
					new Beat(startTime+gap*52, "Space"),
					new Beat(startTime+gap*52, "J"),
					new Beat(startTime+gap*54, "S"),
					new Beat(startTime+gap*56, "D"),
					new Beat(startTime+gap*59, "F"),
					new Beat(startTime+gap*59, "Space"),
					new Beat(startTime+gap*59, "J"),
					new Beat(startTime+gap*61, "L"),
					new Beat(startTime+gap*63, "K"),
					new Beat(startTime+gap*65, "F"),
					new Beat(startTime+gap*65, "Space"),
					new Beat(startTime+gap*65, "J"),
					new Beat(startTime+gap*70, "S"),
					new Beat(startTime+gap*72, "S"),
					new Beat(startTime+gap*74, "S"),
					new Beat(startTime+gap*78, "J"),
					new Beat(startTime+gap*79, "K"),
					new Beat(startTime+gap*80, "L"),
					new Beat(startTime+gap*83, "Space"),
					new Beat(startTime+gap*85, "S"),
					new Beat(startTime+gap*87, "D"),
					new Beat(startTime+gap*89, "S"),
					new Beat(startTime+gap*91, "D"),
					new Beat(startTime+gap*93, "F"),
					new Beat(startTime+gap*96, "Space"),
					new Beat(startTime+gap*98, "L"),
					new Beat(startTime+gap*100, "Space"),
					new Beat(startTime+gap*102, "S"),
					new Beat(startTime+gap*104, "D"),
					new Beat(startTime+gap*106, "Space"),
					new Beat(startTime+gap*109, "Space"),
					new Beat(startTime+gap*112, "Space"),
					new Beat(startTime+gap*118, "S"),
					new Beat(startTime+gap*119, "D"),
					new Beat(startTime+gap*120, "F"),
					new Beat(startTime+gap*123, "S"),
					new Beat(startTime+gap*124, "D"),
					new Beat(startTime+gap*125, "F"),
					new Beat(startTime+gap*126, "J"),
					new Beat(startTime+gap*127, "K"),
					new Beat(startTime+gap*130, "J"),
					new Beat(startTime+gap*133, "K"),
					new Beat(startTime+gap*136, "L"),
					new Beat(startTime+gap*138, "S"),
					new Beat(startTime+gap*140, "Space"),
					new Beat(startTime+gap*142, "S"),
					new Beat(startTime+gap*144, "Space"),
					new Beat(startTime+gap*146, "Space"),
					new Beat(startTime+gap*150, "Space"),
					new Beat(startTime+gap*152, "Space"),
					new Beat(startTime+gap*157, "J"),
					new Beat(startTime+gap*161, "K"),
					new Beat(startTime+gap*165, "L"),
					new Beat(startTime+gap*167, "S"),
					new Beat(startTime+gap*169, "D"),
					new Beat(startTime+gap*171, "F"),
					new Beat(startTime+gap*174, "S"),
					new Beat(startTime+gap*176, "D"),
					new Beat(startTime+gap*178, "F"),
					new Beat(startTime+gap*180, "Space"),
					new Beat(startTime+gap*181, "L"),
					new Beat(startTime+gap*184, "Space"),
					new Beat(startTime+gap*187, "L"),
					new Beat(startTime+gap*188, "K"),
					new Beat(startTime+gap*189, "J"),
					new Beat(startTime+gap*192, "S"),
					new Beat(startTime+gap*192, "Space"),
					new Beat(startTime+gap*196, "D"),
					new Beat(startTime+gap*196, "Space"),
					new Beat(startTime+gap*200, "S"),
					new Beat(startTime+gap*200, "Space"),
					new Beat(startTime+gap*207, "J"),
					new Beat(startTime+gap*207, "Space"),
					new Beat(startTime+gap*211, "K"),
					new Beat(startTime+gap*211, "Space"),
					new Beat(startTime+gap*216, "L"),
					new Beat(startTime+gap*216, "Space"),
					new Beat(startTime+gap*218, "Space"),
					new Beat(startTime+gap*221, "J"),
					new Beat(startTime+gap*223, "K"),
					new Beat(startTime+gap*225, "L"),
					new Beat(startTime+gap*227, "S"),
					new Beat(startTime+gap*227, "Space"),
					new Beat(startTime+gap*231, "D"),
					new Beat(startTime+gap*231, "Space"),
					new Beat(startTime+gap*235, "S"),
					new Beat(startTime+gap*235, "Space"),
					new Beat(startTime+gap*242, "S"),
					new Beat(startTime+gap*242, "Space"),
					new Beat(startTime+gap*242, "L"),
					new Beat(startTime+gap*246, "D"),
					new Beat(startTime+gap*246, "Space"),
					new Beat(startTime+gap*246, "K"),
					new Beat(startTime+gap*250, "F"),
					new Beat(startTime+gap*250, "Space"),
					new Beat(startTime+gap*250, "J"),
					new Beat(startTime+gap*255, "J"),
					new Beat(startTime+gap*257, "K"),
					new Beat(startTime+gap*259, "K"),
					new Beat(startTime+gap*262, "S"),
					new Beat(startTime+gap*262, "Space"),
					new Beat(startTime+gap*266, "D"),
					new Beat(startTime+gap*266, "Space"),
					new Beat(startTime+gap*270, "S"),
					new Beat(startTime+gap*270, "Space"),
					new Beat(startTime+gap*275, "J"),
					new Beat(startTime+gap*277, "K"),
					new Beat(startTime+gap*279, "L"),
					new Beat(startTime+gap*282, "J"),
					new Beat(startTime+gap*284, "K"),
					new Beat(startTime+gap*286, "L"),
					new Beat(startTime+gap*289, "J"),
					new Beat(startTime+gap*291, "K"),
					new Beat(startTime+gap*293, "L"),
					new Beat(startTime+gap*295, "J"),
					new Beat(startTime+gap*297, "F"),
					new Beat(startTime+gap*299, "D"),
					new Beat(startTime+gap*301, "S"),
					new Beat(startTime+gap*304, "F"),
					new Beat(startTime+gap*306, "D"),
					new Beat(startTime+gap*308, "S"),
					new Beat(startTime+gap*310, "F"),
					new Beat(startTime+gap*312, "D"),
					new Beat(startTime+gap*314, "S"),
					new Beat(startTime+gap*317, "F"),
					new Beat(startTime+gap*319, "D"),
					new Beat(startTime+gap*321, "S"),
					new Beat(startTime+gap*323, "F"),
					new Beat(startTime+gap*325, "D"),
					new Beat(startTime+gap*327, "S"),
					new Beat(startTime+gap*330, "F"),
					new Beat(startTime+gap*332, "S"),
					new Beat(startTime+gap*332, "Space"),
					new Beat(startTime+gap*336, "D"),
					new Beat(startTime+gap*336, "Space"),
					new Beat(startTime+gap*340, "S"),
					new Beat(startTime+gap*340, "Space")
			};
		}
		else if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Hard") ) {
			int startTime = 1000;
			int gap = 150;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime, "Space"),
					new Beat(startTime+gap*1, "S"),
					new Beat(startTime+gap*3, "D"),
					new Beat(startTime+gap*5, "S"),
					new Beat(startTime+gap*7, "D"),
					new Beat(startTime+gap*9, "S"),
					new Beat(startTime+gap*11, "D"),
					new Beat(startTime+gap*13, "S"),
					new Beat(startTime+gap*15, "D"),
					new Beat(startTime+gap*18, "J"),
					new Beat(startTime+gap*20, "K"),
					new Beat(startTime+gap*22, "J"),
					new Beat(startTime+gap*24, "K"),
					new Beat(startTime+gap*26, "J"),
					new Beat(startTime+gap*28, "K"),
					new Beat(startTime+gap*28, "L"),
					new Beat(startTime+gap*30, "J"),
					new Beat(startTime+gap*32, "K"),
					new Beat(startTime+gap*35, "S"),
					new Beat(startTime+gap*37, "D"),
					new Beat(startTime+gap*39, "S"),
					new Beat(startTime+gap*41, "D"),
					new Beat(startTime+gap*41, "K"),
					new Beat(startTime+gap*43, "S"),
					new Beat(startTime+gap*45, "D"),
					new Beat(startTime+gap*48, "J"),
					new Beat(startTime+gap*49, "K"),
					new Beat(startTime+gap*50, "S"),
					new Beat(startTime+gap*50, "L"),
					new Beat(startTime+gap*52, "F"),
					new Beat(startTime+gap*52, "Space"),
					new Beat(startTime+gap*52, "J"),
					new Beat(startTime+gap*54, "S"),
					new Beat(startTime+gap*56, "D"),
					new Beat(startTime+gap*59, "F"),
					new Beat(startTime+gap*59, "Space"),
					new Beat(startTime+gap*59, "J"),
					new Beat(startTime+gap*61, "L"),
					new Beat(startTime+gap*63, "K"),
					new Beat(startTime+gap*65, "F"),
					new Beat(startTime+gap*65, "Space"),
					new Beat(startTime+gap*65, "J"),
					new Beat(startTime+gap*70, "S"),
					new Beat(startTime+gap*72, "S"),
					new Beat(startTime+gap*74, "S"),
					new Beat(startTime+gap*78, "J"),
					new Beat(startTime+gap*78, "L"),
					new Beat(startTime+gap*79, "K"),
					new Beat(startTime+gap*80, "L"),
					new Beat(startTime+gap*83, "Space"),
					new Beat(startTime+gap*85, "S"),
					new Beat(startTime+gap*87, "D"),
					new Beat(startTime+gap*89, "S"),
					new Beat(startTime+gap*89, "Space"),
					new Beat(startTime+gap*91, "D"),
					new Beat(startTime+gap*93, "F"),
					new Beat(startTime+gap*96, "Space"),
					new Beat(startTime+gap*98, "L"),
					new Beat(startTime+gap*100, "Space"),
					new Beat(startTime+gap*102, "S"),
					new Beat(startTime+gap*104, "D"),
					new Beat(startTime+gap*106, "Space"),
					new Beat(startTime+gap*109, "Space"),
					new Beat(startTime+gap*112, "Space"),
					new Beat(startTime+gap*118, "S"),
					new Beat(startTime+gap*119, "D"),
					new Beat(startTime+gap*120, "F"),
					new Beat(startTime+gap*123, "S"),
					new Beat(startTime+gap*124, "D"),
					new Beat(startTime+gap*125, "F"),
					new Beat(startTime+gap*126, "J"),
					new Beat(startTime+gap*127, "K"),
					new Beat(startTime+gap*130, "J"),
					new Beat(startTime+gap*133, "K"),
					new Beat(startTime+gap*136, "L"),
					new Beat(startTime+gap*136, "S"),
					new Beat(startTime+gap*138, "S"),
					new Beat(startTime+gap*140, "Space"),
					new Beat(startTime+gap*142, "S"),
					new Beat(startTime+gap*144, "Space"),
					new Beat(startTime+gap*146, "Space"),
					new Beat(startTime+gap*150, "Space"),
					new Beat(startTime+gap*152, "Space"),
					new Beat(startTime+gap*157, "J"),
					new Beat(startTime+gap*161, "K"),
					new Beat(startTime+gap*165, "L"),
					new Beat(startTime+gap*165, "Space"),
					new Beat(startTime+gap*167, "S"),
					new Beat(startTime+gap*169, "D"),
					new Beat(startTime+gap*171, "F"),
					new Beat(startTime+gap*174, "S"),
					new Beat(startTime+gap*176, "D"),
					new Beat(startTime+gap*178, "F"),
					new Beat(startTime+gap*180, "Space"),
					new Beat(startTime+gap*181, "L"),
					new Beat(startTime+gap*184, "Space"),
					new Beat(startTime+gap*186, "Space"),
					new Beat(startTime+gap*187, "L"),
					new Beat(startTime+gap*188, "K"),
					new Beat(startTime+gap*188, "Space"),
					new Beat(startTime+gap*189, "J"),
					new Beat(startTime+gap*192, "S"),
					new Beat(startTime+gap*192, "Space"),
					new Beat(startTime+gap*196, "D"),
					new Beat(startTime+gap*196, "Space"),
					new Beat(startTime+gap*200, "S"),
					new Beat(startTime+gap*200, "Space"),
					new Beat(startTime+gap*207, "J"),
					new Beat(startTime+gap*207, "Space"),
					new Beat(startTime+gap*211, "K"),
					new Beat(startTime+gap*211, "Space"),
					new Beat(startTime+gap*216, "L"),
					new Beat(startTime+gap*216, "Space"),
					new Beat(startTime+gap*216, "L"),
					new Beat(startTime+gap*218, "Space"),
					new Beat(startTime+gap*218, "S"),
					new Beat(startTime+gap*221, "J"),
					new Beat(startTime+gap*223, "K"),
					new Beat(startTime+gap*225, "L"),
					new Beat(startTime+gap*227, "S"),
					new Beat(startTime+gap*227, "Space"),
					new Beat(startTime+gap*231, "D"),
					new Beat(startTime+gap*231, "Space"),
					new Beat(startTime+gap*235, "S"),
					new Beat(startTime+gap*235, "Space"),
					new Beat(startTime+gap*242, "S"),
					new Beat(startTime+gap*242, "Space"),
					new Beat(startTime+gap*242, "L"),
					new Beat(startTime+gap*246, "D"),
					new Beat(startTime+gap*246, "Space"),
					new Beat(startTime+gap*246, "K"),
					new Beat(startTime+gap*250, "F"),
					new Beat(startTime+gap*250, "Space"),
					new Beat(startTime+gap*250, "J"),
					new Beat(startTime+gap*255, "J"),
					new Beat(startTime+gap*257, "K"),
					new Beat(startTime+gap*259, "K"),
					new Beat(startTime+gap*262, "S"),
					new Beat(startTime+gap*262, "Space"),
					new Beat(startTime+gap*266, "D"),
					new Beat(startTime+gap*266, "Space"),
					new Beat(startTime+gap*270, "S"),
					new Beat(startTime+gap*270, "Space"),
					new Beat(startTime+gap*275, "J"),
					new Beat(startTime+gap*277, "K"),
					new Beat(startTime+gap*279, "L"),
					new Beat(startTime+gap*282, "J"),
					new Beat(startTime+gap*284, "K"),
					new Beat(startTime+gap*286, "L"),
					new Beat(startTime+gap*289, "J"),
					new Beat(startTime+gap*291, "K"),
					new Beat(startTime+gap*293, "L"),
					new Beat(startTime+gap*295, "J"),
					new Beat(startTime+gap*297, "F"),
					new Beat(startTime+gap*299, "D"),
					new Beat(startTime+gap*301, "S"),
					new Beat(startTime+gap*304, "F"),
					new Beat(startTime+gap*306, "D"),
					new Beat(startTime+gap*306, "Space"),
					new Beat(startTime+gap*308, "S"),
					new Beat(startTime+gap*310, "F"),
					new Beat(startTime+gap*312, "D"),
					new Beat(startTime+gap*313, "F"),
					new Beat(startTime+gap*314, "S"),
					new Beat(startTime+gap*317, "F"),
					new Beat(startTime+gap*317, "Space"),
					new Beat(startTime+gap*319, "D"),
					new Beat(startTime+gap*321, "S"),
					new Beat(startTime+gap*321, "Space"),
					new Beat(startTime+gap*321, "F"),
					new Beat(startTime+gap*323, "F"),
					new Beat(startTime+gap*325, "D"),
					new Beat(startTime+gap*327, "S"),
					new Beat(startTime+gap*330, "F"),
					new Beat(startTime+gap*332, "S"),
					new Beat(startTime+gap*332, "Space"),
					new Beat(startTime+gap*336, "D"),
					new Beat(startTime+gap*336, "Space"),
					new Beat(startTime+gap*340, "S"),
					new Beat(startTime+gap*340, "Space")
			};
		}
		else if(titleName.equals("Light")&& difficulty.equals("Easy") ) {
			int startTime = 9000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 24, "F"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 36, "D"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 46, "K"), new Beat(startTime + gap * 50, "F"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 60, "S"), new Beat(startTime + gap * 62, "S"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 75, "F"), new Beat(startTime + gap * 78, "K"),
					new Beat(startTime + gap * 79, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 86, "K"), new Beat(startTime + gap * 97, "Space"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 106, "F"), new Beat(startTime + gap * 110, "D"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 127, "Space"), new Beat(startTime + gap * 129, "F"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 139, "K"), new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 153, "F"), new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 160, "S"), new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 171, "S"), new Beat(startTime + gap * 174, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 183, "J"), new Beat(startTime + gap * 186, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 212, "D"), new Beat(startTime + gap * 216, "F"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 227, "K"), new Beat(startTime + gap * 229, "F"),
					new Beat(startTime + gap * 232, "D"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 239, "L"), new Beat(startTime + gap * 242, "F"),
					new Beat(startTime + gap * 246, "J"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 253, "L"), new Beat(startTime + gap * 256, "J"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 266, "K"), new Beat(startTime + gap * 269, "S"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 278, "D"), new Beat(startTime + gap * 281, "F"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 297, "Space"), new Beat(startTime + gap * 300, "S"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 310, "J"), new Beat(startTime + gap * 320, "S"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 327, "K"), new Beat(startTime + gap * 329, "F"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 339, "K"), new Beat(startTime + gap * 342, "F"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 353, "L"), new Beat(startTime + gap * 356, "J"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 366, "K"), new Beat(startTime + gap * 369, "L"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 378, "D"), new Beat(startTime + gap * 381, "F"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 388, "S"), new Beat(startTime + gap * 392, "D"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 404, "D"), new Beat(startTime + gap * 407, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "L"),
					new Beat(startTime + gap * 416, "D"), new Beat(startTime + gap * 419, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 430, "F"), new Beat(startTime + gap * 433, "L"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 442, "F"), new Beat(startTime + gap * 446, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 459, "D"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 477, "Space"), new Beat(startTime + gap * 480, "S"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 490, "L"), new Beat(startTime + gap * 493, "K"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 499, "F"), new Beat(startTime + gap * 502, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 512, "F"), new Beat(startTime + gap * 516, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 526, "J"), new Beat(startTime + gap * 530, "S"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 539, "Space"), new Beat(startTime + gap * 541, "S"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 551, "F"), new Beat(startTime + gap * 553, "J"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 568, "S"), new Beat(startTime + gap * 572, "D"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 584, "Space"), new Beat(startTime + gap * 587, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 596, "D"), new Beat(startTime + gap * 599, "J"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "S"),
					new Beat(startTime + gap * 610, "D"), new Beat(startTime + gap * 613, "L"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 622, "S"), new Beat(startTime + gap * 626, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 634, "K"), new Beat(startTime + gap * 638, "D"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 646, "K"), new Beat(startTime + gap * 647, "Space"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 656, "F"), new Beat(startTime + gap * 660, "D"),
					new Beat(startTime + gap * 665, "S"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 674, "F"), new Beat(startTime + gap * 677, "K"),
					new Beat(startTime + gap * 679, "D"), new Beat(startTime + gap * 682, "S"),
					new Beat(startTime + gap * 686, "D"), new Beat(startTime + gap * 689, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "D"),
					new Beat(startTime + gap * 700, "J"), new Beat(startTime + gap * 703, "L"),
					new Beat(startTime + gap * 706, "J")
			};
		}
		else if(titleName.equals("Light")&& difficulty.equals("Hard") ) {
			int startTime = 9000 - Main.REACH_TIME;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 7, "F"), new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 11, "K"), new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 16, "K"), new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 18, "F"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 21, "K"), new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 24, "F"), new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 27, "K"), new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 31, "K"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 36, "D"), new Beat(startTime + gap * 37, "K"),
					new Beat(startTime + gap * 39, "K"), new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 44, "K"), new Beat(startTime + gap * 46, "S"),
					new Beat(startTime + gap * 50, "F"), new Beat(startTime + gap * 52, "K"),
					new Beat(startTime + gap * 53, "L"), new Beat(startTime + gap * 56, "J"),
					new Beat(startTime + gap * 58, "K"), new Beat(startTime + gap * 60, "S"),
					new Beat(startTime + gap * 62, "S"), new Beat(startTime + gap * 64, "K"),
					new Beat(startTime + gap * 66, "K"), new Beat(startTime + gap * 69, "S"),
					new Beat(startTime + gap * 73, "K"), new Beat(startTime + gap * 75, "F"),
					new Beat(startTime + gap * 78, "K"), new Beat(startTime + gap * 80, "K"),
					new Beat(startTime + gap * 81, "D"), new Beat(startTime + gap * 83, "J"),
					new Beat(startTime + gap * 85, "K"), new Beat(startTime + gap * 86, "K"),
					new Beat(startTime + gap * 97, "Space"), new Beat(startTime + gap * 99, "K"),
					new Beat(startTime + gap * 100, "S"), new Beat(startTime + gap * 102, "D"),
					new Beat(startTime + gap * 104, "K"), new Beat(startTime + gap * 106, "F"),
					new Beat(startTime + gap * 110, "D"), new Beat(startTime + gap * 115, "K"),
					new Beat(startTime + gap * 120, "F"), new Beat(startTime + gap * 124, "F"),
					new Beat(startTime + gap * 126, "K"), new Beat(startTime + gap * 127, "Space"),
					new Beat(startTime + gap * 129, "F"), new Beat(startTime + gap * 130, "K"),
					new Beat(startTime + gap * 132, "K"), new Beat(startTime + gap * 136, "D"),
					new Beat(startTime + gap * 137, "K"), new Beat(startTime + gap * 139, "K"),
					new Beat(startTime + gap * 142, "F"), new Beat(startTime + gap * 144, "K"),
					new Beat(startTime + gap * 146, "K"), new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 152, "K"), new Beat(startTime + gap * 153, "F"),
					new Beat(startTime + gap * 156, "J"), new Beat(startTime + gap * 158, "K"),
					new Beat(startTime + gap * 10, "K"), new Beat(startTime + gap * 160, "S"),
					new Beat(startTime + gap * 162, "S"), new Beat(startTime + gap * 164, "K"),
					new Beat(startTime + gap * 166, "K"), new Beat(startTime + gap * 169, "Space"),
					new Beat(startTime + gap * 170, "K"), new Beat(startTime + gap * 171, "S"),
					new Beat(startTime + gap * 174, "K"), new Beat(startTime + gap * 176, "K"),
					new Beat(startTime + gap * 178, "D"), new Beat(startTime + gap * 181, "F"),
					new Beat(startTime + gap * 182, "K"), new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "K"), new Beat(startTime + gap * 190, "K"),
					new Beat(startTime + gap * 194, "Space"), new Beat(startTime + gap * 198, "S"),
					new Beat(startTime + gap * 205, "K"), new Beat(startTime + gap * 212, "D"),
					new Beat(startTime + gap * 216, "F"), new Beat(startTime + gap * 219, "K"),
					new Beat(startTime + gap * 220, "F"), new Beat(startTime + gap * 224, "Space"),
					new Beat(startTime + gap * 225, "K"), new Beat(startTime + gap * 227, "K"),
					new Beat(startTime + gap * 229, "F"), new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 237, "K"), new Beat(startTime + gap * 239, "K"),
					new Beat(startTime + gap * 242, "F"), new Beat(startTime + gap * 243, "K"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 251, "K"), new Beat(startTime + gap * 253, "L"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 260, "S"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 263, "K"), new Beat(startTime + gap * 266, "K"),
					new Beat(startTime + gap * 269, "S"), new Beat(startTime + gap * 270, "K"),
					new Beat(startTime + gap * 271, "S"), new Beat(startTime + gap * 274, "K"),
					new Beat(startTime + gap * 275, "K"), new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 281, "F"), new Beat(startTime + gap * 282, "K"),
					new Beat(startTime + gap * 283, "J"), new Beat(startTime + gap * 286, "K"),
					new Beat(startTime + gap * 287, "K"), new Beat(startTime + gap * 297, "Space"),
					new Beat(startTime + gap * 300, "S"), new Beat(startTime + gap * 301, "K"),
					new Beat(startTime + gap * 302, "D"), new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 307, "K"), new Beat(startTime + gap * 310, "J"),
					new Beat(startTime + gap * 320, "S"), new Beat(startTime + gap * 321, "K"),
					new Beat(startTime + gap * 322, "L"), new Beat(startTime + gap * 324, "F"),
					new Beat(startTime + gap * 326, "K"), new Beat(startTime + gap * 327, "K"),
					new Beat(startTime + gap * 329, "F"), new Beat(startTime + gap * 330, "K"),
					new Beat(startTime + gap * 332, "K"), new Beat(startTime + gap * 336, "D"),
					new Beat(startTime + gap * 337, "K"), new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 342, "F"), new Beat(startTime + gap * 343, "K"),
					new Beat(startTime + gap * 346, "K"), new Beat(startTime + gap * 350, "F"),
					new Beat(startTime + gap * 351, "K"), new Beat(startTime + gap * 353, "L"),
					new Beat(startTime + gap * 356, "J"), new Beat(startTime + gap * 357, "K"),
					new Beat(startTime + gap * 360, "S"), new Beat(startTime + gap * 362, "S"),
					new Beat(startTime + gap * 363, "K"), new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "L"), new Beat(startTime + gap * 370, "K"),
					new Beat(startTime + gap * 371, "S"), new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 375, "K"), new Beat(startTime + gap * 378, "D"),
					new Beat(startTime + gap * 381, "F"), new Beat(startTime + gap * 382, "K"),
					new Beat(startTime + gap * 383, "J"), new Beat(startTime + gap * 384, "Space"),
					new Beat(startTime + gap * 385, "K"), new Beat(startTime + gap * 388, "S"),
					new Beat(startTime + gap * 392, "D"), new Beat(startTime + gap * 393, "K"),
					new Beat(startTime + gap * 396, "F"), new Beat(startTime + gap * 400, "S"),
					new Beat(startTime + gap * 401, "K"), new Beat(startTime + gap * 404, "F"),
					new Beat(startTime + gap * 407, "K"), new Beat(startTime + gap * 408, "K"),
					new Beat(startTime + gap * 410, "F"), new Beat(startTime + gap * 412, "K"),
					new Beat(startTime + gap * 413, "K"), new Beat(startTime + gap * 416, "D"),
					new Beat(startTime + gap * 419, "K"), new Beat(startTime + gap * 420, "K"),
					new Beat(startTime + gap * 422, "F"), new Beat(startTime + gap * 426, "J"),
					new Beat(startTime + gap * 427, "K"), new Beat(startTime + gap * 430, "F"),
					new Beat(startTime + gap * 433, "L"), new Beat(startTime + gap * 434, "K"),
					new Beat(startTime + gap * 436, "J"), new Beat(startTime + gap * 440, "S"),
					new Beat(startTime + gap * 441, "K"), new Beat(startTime + gap * 442, "F"),
					new Beat(startTime + gap * 446, "K"), new Beat(startTime + gap * 447, "K"),
					new Beat(startTime + gap * 449, "S"), new Beat(startTime + gap * 455, "F"),
					new Beat(startTime + gap * 456, "K"), new Beat(startTime + gap * 458, "K"),
					new Beat(startTime + gap * 459, "D"), new Beat(startTime + gap * 460, "K"),
					new Beat(startTime + gap * 463, "J"), new Beat(startTime + gap * 466, "K"),
					new Beat(startTime + gap * 467, "K"), new Beat(startTime + gap * 477, "Space"),
					new Beat(startTime + gap * 480, "S"), new Beat(startTime + gap * 482, "K"),
					new Beat(startTime + gap * 482, "D"), new Beat(startTime + gap * 486, "F"),
					new Beat(startTime + gap * 487, "K"), new Beat(startTime + gap * 490, "D"),
					new Beat(startTime + gap * 493, "F"), new Beat(startTime + gap * 494, "K"),
					new Beat(startTime + gap * 494, "S"), new Beat(startTime + gap * 497, "Space"),
					new Beat(startTime + gap * 498, "K"), new Beat(startTime + gap * 499, "F"),
					new Beat(startTime + gap * 502, "K"), new Beat(startTime + gap * 503, "K"),
					new Beat(startTime + gap * 506, "D"), new Beat(startTime + gap * 509, "L"),
					new Beat(startTime + gap * 510, "K"), new Beat(startTime + gap * 512, "F"),
					new Beat(startTime + gap * 516, "K"), new Beat(startTime + gap * 517, "K"),
					new Beat(startTime + gap * 520, "F"), new Beat(startTime + gap * 523, "D"),
					new Beat(startTime + gap * 524, "K"), new Beat(startTime + gap * 526, "J"),
					new Beat(startTime + gap * 530, "S"), new Beat(startTime + gap * 531, "K"),
					new Beat(startTime + gap * 532, "F"), new Beat(startTime + gap * 536, "K"),
					new Beat(startTime + gap * 537, "K"), new Beat(startTime + gap * 539, "Space"),
					new Beat(startTime + gap * 541, "S"), new Beat(startTime + gap * 542, "K"),
					new Beat(startTime + gap * 547, "K"), new Beat(startTime + gap * 548, "D"),
					new Beat(startTime + gap * 549, "K"), new Beat(startTime + gap * 551, "F"),
					new Beat(startTime + gap * 553, "J"), new Beat(startTime + gap * 554, "K"),
					new Beat(startTime + gap * 556, "K"), new Beat(startTime + gap * 564, "Space"),
					new Beat(startTime + gap * 565, "K"), new Beat(startTime + gap * 568, "S"),
					new Beat(startTime + gap * 572, "D"), new Beat(startTime + gap * 573, "K"),
					new Beat(startTime + gap * 576, "F"), new Beat(startTime + gap * 580, "F"),
					new Beat(startTime + gap * 581, "K"), new Beat(startTime + gap * 584, "Space"),
					new Beat(startTime + gap * 587, "K"), new Beat(startTime + gap * 588, "K"),
					new Beat(startTime + gap * 589, "F"), new Beat(startTime + gap * 592, "K"),
					new Beat(startTime + gap * 593, "K"), new Beat(startTime + gap * 596, "D"),
					new Beat(startTime + gap * 599, "K"), new Beat(startTime + gap * 600, "K"),
					new Beat(startTime + gap * 602, "F"), new Beat(startTime + gap * 606, "K"),
					new Beat(startTime + gap * 607, "K"), new Beat(startTime + gap * 610, "F"),
					new Beat(startTime + gap * 613, "L"), new Beat(startTime + gap * 614, "K"),
					new Beat(startTime + gap * 616, "J"), new Beat(startTime + gap * 620, "S"),
					new Beat(startTime + gap * 621, "K"), new Beat(startTime + gap * 622, "S"),
					new Beat(startTime + gap * 626, "K"), new Beat(startTime + gap * 627, "K"),
					new Beat(startTime + gap * 629, "S"), new Beat(startTime + gap * 631, "S"),
					new Beat(startTime + gap * 632, "K"), new Beat(startTime + gap * 634, "K"),
					new Beat(startTime + gap * 638, "D"), new Beat(startTime + gap * 639, "K"),
					new Beat(startTime + gap * 641, "F"), new Beat(startTime + gap * 643, "J"),
					new Beat(startTime + gap * 644, "K"), new Beat(startTime + gap * 646, "K"),
					new Beat(startTime + gap * 647, "Space"), new Beat(startTime + gap * 648, "K"),
					new Beat(startTime + gap * 650, "S"), new Beat(startTime + gap * 652, "D"),
					new Beat(startTime + gap * 653, "K"), new Beat(startTime + gap * 656, "F"),
					new Beat(startTime + gap * 660, "D"), new Beat(startTime + gap * 661, "K"),
					new Beat(startTime + gap * 665, "F"), new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 672, "K"), new Beat(startTime + gap * 674, "F"),
					new Beat(startTime + gap * 677, "K"), new Beat(startTime + gap * 678, "K"),
					new Beat(startTime + gap * 679, "F"), new Beat(startTime + gap * 682, "K"),
					new Beat(startTime + gap * 683, "K"), new Beat(startTime + gap * 686, "D"),
					new Beat(startTime + gap * 689, "K"), new Beat(startTime + gap * 690, "K"),
					new Beat(startTime + gap * 692, "F"), new Beat(startTime + gap * 696, "K"),
					new Beat(startTime + gap * 697, "K"), new Beat(startTime + gap * 700, "F"),
					new Beat(startTime + gap * 703, "L"), new Beat(startTime + gap * 704, "K"),
					new Beat(startTime + gap * 706, "J"), new Beat(startTime + gap * 710, "S"),
					new Beat(startTime + gap * 711, "K"), new Beat(startTime + gap * 712, "S"),
					new Beat(startTime + gap * 716, "K"), new Beat(startTime + gap * 717, "K"),
					new Beat(startTime + gap * 719, "F"), new Beat(startTime + gap * 720, "K"),
					new Beat(startTime + gap * 721, "S"), new Beat(startTime + gap * 722, "D"),
					new Beat(startTime + gap * 725, "F"), new Beat(startTime + gap * 728, "D"),
					new Beat(startTime + gap * 730, "K"), new Beat(startTime + gap * 733, "L"),
					new Beat(startTime + gap * 737, "F"), new Beat(startTime + gap * 737, "K"),
			};
		}
		
		int i=0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public void judge(String input) {
		for(int i=0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				//note.judge()
				break;
			}
					
		}
	}
	
	
	public void judgeEvent(String judge) {
        if (!judge.equals("None")) {
        	blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
        }
        if (judge.equals("Miss")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
            score = score - 10;
            combo = 0;
        } else if (judge.equals("Late")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
            score = score + 10;
            combo = combo + 1;
        } else if (judge.equals("Good")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
            score = score + 20;
            combo = combo + 1;
        } else if (judge.equals("Great")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
            score = score + 30;
            combo = combo + 1;
        } else if (judge.equals("Perfect")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
            score = score + 40;
            combo = combo + 1;
        } else if (judge.equals("Early")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
            score = score + 10;
            combo = combo + 1;
        }
    }
}