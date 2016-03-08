package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Img {
	public static final Image DB;
	public static final Image DISK;
	public static final Image LEVEL;
	public static final Image POINT;
	public static final Image RMLINE;
	public static final Image SIGN;
	public static final Image START;
	public static final Image NUMBER;
	public static final Image PAUSE;
	public static final Image WINDOW;
	public static final Image ACT;
	public static final Image RECT;
	public static final Image SHODOW;
	public static final Image[] NEXT_ACT;
	public static List<Image> BG_LIST;
	static{

		DB=new ImageIcon("graphics/string/db.png").getImage();
		DISK=new ImageIcon("graphics/string/disk.png").getImage();
		LEVEL=new ImageIcon("graphics/string/level.png").getImage();
		POINT=new ImageIcon("graphics/string/point.png").getImage();
		RMLINE=new ImageIcon("graphics/string/rmline.png").getImage();
		NUMBER=new ImageIcon("graphics/string/num.png").getImage();
		SIGN=new ImageIcon("graphics/string/sign.png").getImage();
		START=new ImageIcon("graphics/string/start.png").getImage();
		PAUSE=new ImageIcon("graphics/string/pause.png").getImage();
		WINDOW= new ImageIcon("graphics/window/Window.png").getImage();
		RECT= new ImageIcon("graphics/window/rect.png").getImage();
		ACT=new ImageIcon("graphics/game/rect.png").getImage();
		SHODOW=new ImageIcon("graphics/game/shodow.png").getImage();
		NEXT_ACT = new Image[7];
		for (int i = 0; i < 7; i++) {
			NEXT_ACT[i]=new ImageIcon("graphics/game/"+i+".png").getImage();
		}
		File dir = new File ("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<Image>() ;
		for(File file : files){
			if(file.isDirectory()){
				continue;
			}
			String path = file.getPath();
			BG_LIST.add(new ImageIcon(path).getImage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
