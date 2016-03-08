package ui;

import java.awt.Graphics;

public class LayerPoint extends Layer {
	/*
	 * 共通X坐标
	 */
	private   int comX;
	/*
	 * 分数Y坐标
	 */
	private  final int pointY;
	/*
	 * 分数最大位数
	 */
//	TODO 配置文件
	private  final int POINT_BIG = 5;
	private  final int LEVEL_UP = 20;
	/*
	 * 经验值y坐标
	 */
	private  int expY ;
	/*
	 * 消行Y坐标
	 */
	private  final int rmLineY=Img.POINT.getHeight(null)+(PADDING<<1);

	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
//		初始化共通X坐标
		this.comX = this.w - IMG_NUMBER_W*POINT_BIG - PADDING;
//		初始化分数Y坐标
		this.pointY=PADDING;
//		初始化经验值Y坐标
		this.expY = this.rmLineY + Img.POINT.getHeight(null)+PADDING;
		
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
//		窗口标题（分数）
		g.drawImage(Img.POINT, this.x+PADDING, this.y+pointY, null);
//		显示分数
		this.drawNumberLeftPad(comX, pointY, this.dto.getNowPoint(), POINT_BIG, g);
//		窗口标题（消行）
		g.drawImage(Img.RMLINE, this.x+PADDING, this.y+rmLineY, null);
//		显示消行
		this.drawNumberLeftPad(comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIG, g);
//		值槽比值
		double percent = (double)(this.dto.getNowRemoveLine() % LEVEL_UP)/(double)LEVEL_UP;
//		绘制经验值槽 （经验值）
		drawRect(expY, "下一级", "", percent, g);
		
		
	}
	
	
	
	
	
}
