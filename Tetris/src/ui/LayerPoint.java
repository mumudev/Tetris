package ui;

import java.awt.Graphics;

public class LayerPoint extends Layer {
	/*
	 * ��ͨX����
	 */
	private   int comX;
	/*
	 * ����Y����
	 */
	private  final int pointY;
	/*
	 * �������λ��
	 */
//	TODO �����ļ�
	private  final int POINT_BIG = 5;
	private  final int LEVEL_UP = 20;
	/*
	 * ����ֵy����
	 */
	private  int expY ;
	/*
	 * ����Y����
	 */
	private  final int rmLineY=Img.POINT.getHeight(null)+(PADDING<<1);

	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
//		��ʼ����ͨX����
		this.comX = this.w - IMG_NUMBER_W*POINT_BIG - PADDING;
//		��ʼ������Y����
		this.pointY=PADDING;
//		��ʼ������ֵY����
		this.expY = this.rmLineY + Img.POINT.getHeight(null)+PADDING;
		
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
//		���ڱ��⣨������
		g.drawImage(Img.POINT, this.x+PADDING, this.y+pointY, null);
//		��ʾ����
		this.drawNumberLeftPad(comX, pointY, this.dto.getNowPoint(), POINT_BIG, g);
//		���ڱ��⣨���У�
		g.drawImage(Img.RMLINE, this.x+PADDING, this.y+rmLineY, null);
//		��ʾ����
		this.drawNumberLeftPad(comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIG, g);
//		ֵ�۱�ֵ
		double percent = (double)(this.dto.getNowRemoveLine() % LEVEL_UP)/(double)LEVEL_UP;
//		���ƾ���ֵ�� ������ֵ��
		drawRect(expY, "��һ��", "", percent, g);
		
		
	}
	
	
	
	
	
}
