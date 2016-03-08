package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	/**
	 * 方块数组
	 */
	private Point[] actPoints;
	
	private static int MIN_X=0;
	private static int MAX_X=9;
	private static int MIN_Y=0;
	private static int MAX_Y=17;
	private static int typeCode;
	
	private static final List<Point[]> TYPE_CONFIG;
	
	static{
//		TODO 配置文件
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,1),new Point(5,0),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(4,1),new Point(5,0),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1)});
	}
	
	public GameAct(int actCode){
//		TODO配置文件
		typeCode=actCode;
		init(actCode);
	}
	/*
	 * 初始化
	 */
	public void init(int actCode) {
		typeCode=actCode;
//		TODO 根据actCode的值刷新方块
		Point[] points = TYPE_CONFIG.get(actCode);
		actPoints = new Point[points.length];
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
//		actPoints=TYPE_CONFIG.get(actCode);
	}

	public int getTypeCode() {
		return typeCode;
	}
	public Point[] getActPoints() {
		return actPoints;
	}
	/*
	 * 方块移动
	 * 
	 * @param moveX X轴偏移量
	 * @param moveY Y轴偏移量
	 */
	public boolean move(int moveX,int moveY,boolean[][] gameMap) {
//		判断
		for (int i = 0; i < actPoints.length; i++) {
			if(isOverZone(actPoints[i].x+moveX, actPoints[i].y+moveY,gameMap)){
				return false;
			}
		}
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x+=moveX;
			actPoints[i].y+=moveY;
		}
		return true;
	}
	/*
	 * 
	 * 方块旋转
	 * 
	 * 顺时针
	 * A.x = O.y + O.x -B.y
	 * A.y = O.y - O.x + B.x
	 */
	public void round(boolean[][] gameMap) {
//		TODO 配置
		if(this.getTypeCode() == 4){
			return;
		}
//		判断是否可以旋转
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y-actPoints[0].x+actPoints[i].x;
			if(isOverZone(newX,newY,gameMap)){
				return;
			}
		}
//		方块进行旋转
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y-actPoints[0].x+actPoints[i].x;
			actPoints[i].y = newY;
			actPoints[i].x = newX;
		}
		
	}
	/*
	 * 判断是否超出边界
	 */
	private boolean isOverZone(int newX,int newY,boolean[][] gameMap) {
		return newX<MIN_X||newY<MIN_Y||newX>MAX_X||newY>MAX_Y||gameMap[newX][newY];
	}
}
