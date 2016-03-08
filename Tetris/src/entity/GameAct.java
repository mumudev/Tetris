package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	/**
	 * ��������
	 */
	private Point[] actPoints;
	
	private static int MIN_X=0;
	private static int MAX_X=9;
	private static int MIN_Y=0;
	private static int MAX_Y=17;
	private static int typeCode;
	
	private static final List<Point[]> TYPE_CONFIG;
	
	static{
//		TODO �����ļ�
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
//		TODO�����ļ�
		typeCode=actCode;
		init(actCode);
	}
	/*
	 * ��ʼ��
	 */
	public void init(int actCode) {
		typeCode=actCode;
//		TODO ����actCode��ֵˢ�·���
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
	 * �����ƶ�
	 * 
	 * @param moveX X��ƫ����
	 * @param moveY Y��ƫ����
	 */
	public boolean move(int moveX,int moveY,boolean[][] gameMap) {
//		�ж�
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
	 * ������ת
	 * 
	 * ˳ʱ��
	 * A.x = O.y + O.x -B.y
	 * A.y = O.y - O.x + B.x
	 */
	public void round(boolean[][] gameMap) {
//		TODO ����
		if(this.getTypeCode() == 4){
			return;
		}
//		�ж��Ƿ������ת
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y-actPoints[0].x+actPoints[i].x;
			if(isOverZone(newX,newY,gameMap)){
				return;
			}
		}
//		���������ת
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y-actPoints[0].x+actPoints[i].x;
			actPoints[i].y = newY;
			actPoints[i].x = newX;
		}
		
	}
	/*
	 * �ж��Ƿ񳬳��߽�
	 */
	private boolean isOverZone(int newX,int newY,boolean[][] gameMap) {
		return newX<MIN_X||newY<MIN_Y||newX>MAX_X||newY>MAX_Y||gameMap[newX][newY];
	}
}
