package ui;

import java.awt.Graphics;

public class LayerLevel extends Layer {

	private static final int IMG_LV_W = Img.LEVEL.getWidth(null);
	
	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		int centerX =  BORDER + (this.w - IMG_LV_W>>1);
//		窗口标题
		g.drawImage(Img.LEVEL, this.x +centerX, this.y+PADDING, null);
//		显示等级
//		TODO 配置文件
		drawNumberLeftPad(22, 55,this.dto.getNowLevel(),2, g);
	}
	
	
	
	
	
	
	
	
	
	
	
}
