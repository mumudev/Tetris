package ui;

import java.awt.Graphics;
import java.awt.Point;

public class LayerGame extends Layer {
	/**
	 * 游戏窗口
	 */
	
	private static final int LEFT_SIDE = 0;
	
	private static final int RIGHT_SID = 9;
	
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
//		绘制窗口
		this.createWindow(g);
//		获得地图
		boolean[][] gamemap = this.dto.getGameMap();
//		获得方块数据集合
		Point[] points = this.dto.getGameAct().getActPoints();
//		TODO 阴影关闭
		this.drawShadow(points,true,g);
//		获得方块类型编号
		int typeCode = this.dto.getGameAct().getTypeCode();
//		绘制方块
		for (int i = 0; i < points.length; i++) {
			drawActByPoint(points[i].x, points[i].y, typeCode+1,g );
		}
//		绘制地图
		for (int x = 0; x < gamemap.length; x++) {
			for (int y = 0; y < gamemap[x].length; y++) {
				if(gamemap[x][y]){
					drawActByPoint(x, y, 0,g );
				}
			}
		}
		
		
		
	}
	/**
	 * 绘制阴影
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
	 * 绘制正方形块
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
