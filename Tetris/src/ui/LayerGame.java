package ui;

import java.awt.Graphics;
import java.awt.Point;

public class LayerGame extends Layer {
	/**
	 * ��Ϸ����
	 */
	
	private static final int LEFT_SIDE = 0;
	
	private static final int RIGHT_SID = 9;
	
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
//		���ƴ���
		this.createWindow(g);
//		��õ�ͼ
		boolean[][] gamemap = this.dto.getGameMap();
//		��÷������ݼ���
		Point[] points = this.dto.getGameAct().getActPoints();
//		TODO ��Ӱ�ر�
		this.drawShadow(points,true,g);
//		��÷������ͱ��
		int typeCode = this.dto.getGameAct().getTypeCode();
//		���Ʒ���
		for (int i = 0; i < points.length; i++) {
			drawActByPoint(points[i].x, points[i].y, typeCode+1,g );
		}
//		���Ƶ�ͼ
		for (int x = 0; x < gamemap.length; x++) {
			for (int y = 0; y < gamemap[x].length; y++) {
				if(gamemap[x][y]){
					drawActByPoint(x, y, 0,g );
				}
			}
		}
		
		
		
	}
	/**
	 * ������Ӱ
	 * 
	 */
	private void drawShadow(Point[] points, boolean isShowShadow,Graphics g) {
		if(!isShowShadow){
			return ;
		}
		int leftX = RIGHT_SID;
		int rightX = LEFT_SIDE;
		for (Point point :points) {
			leftX = leftX<point.x? leftX:point.x;
			rightX = rightX>point.x? rightX:point.x;
		}
		g.drawImage(Img.SHODOW,
				this.x +BORDER+ (leftX <<SIZE_ROL), this.y+BORDER,
				(rightX - leftX + 1)<<SIZE_ROL, this.h,
				null);
	}

	/**
	 * ���������ο�
	 */
	
	private void drawActByPoint(int x,int y,int imgIdx,Graphics g) {
		g.drawImage(Img.ACT,
				(x<< SIZE_ROL)+this.x+BORDER,
				(y<< SIZE_ROL)+this.y+BORDER,
				(x<< SIZE_ROL)+ACT_SIZE+this.x+BORDER,
				(y<< SIZE_ROL)+ACT_SIZE+this.y+BORDER, 
				((imgIdx)<< SIZE_ROL), 0, ((imgIdx+1)<< SIZE_ROL), ACT_SIZE,null);
		
	}
	
	
	
	
	
	
	
	
	
	
}
