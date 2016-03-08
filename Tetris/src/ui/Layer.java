package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.FrameConfig;
import config.GameConfig;
import dto.GameDto;

public abstract class Layer {

	/*
	 * ���ڻ�����X
	 */
	protected final int x;
	/*
	 * ���ڻ�����Y
	 */
	protected final int y;
	/*
	 * ���ڳ��ȣ�ȥ���߿�
	 */
	protected final int w;
	/*
	 * ���ڸ߶ȣ�ȥ���߿�
	 */
	protected final int h;
	/*
	 * ֵ�۸߶�
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);
	/*
	 * ֵ�ۿ��
	 */
	protected static final int IMG_RECT_W = Img.RECT.getWidth(null);
	/*
	 * Ĭ������
	 */
	protected static final Font DEF_FONT = new Font("����",Font.BOLD,20);
	/*
	 * �زı߽�����
	 */
	protected final static int BORDER;
	/*
	 *�زı߿򳤶� 
	 */
	protected static final int l;
	/*
	 * ����ͼƬ���
	 */
	protected static final int IMG_NUMBER_W=26;
	/*
	 * ���ָ߶�
	 */
	protected static final int IMG_NUMBER_H=36;
	/*
	 * ���鳤��
	 */
	protected static final int ACT_SIZE;
	/*
	 * ����ƫ����
	 */
	protected static final int SIZE_ROL;
	/*
	 * �ڱ߾�
	 */
	protected static final int PADDING;
	/*
	 * dto���ݶ���
	 */
	protected GameDto dto = null;
	static{
		FrameConfig cfg=GameConfig.getframeConfig();
		PADDING=cfg.getPadding();
		BORDER=cfg.getboder();
		ACT_SIZE=cfg.getActSize();
		SIZE_ROL=cfg.getSizeRol();
		l=cfg.getBoximage()-BORDER*2;
	}
	/**
	 * @param x ����X����
	 * @param y ����Y����
	 * @param w ������
	 * @param h ����߶�
	 */
	public Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	/**
	 * ��ʾ����
	 * 
	 * @param x ���Ͻ�x����
	 * @param y ���Ͻ�y����
	 * @param num Ҫ��ʾ������
	 * @param maxBit ����λ��
	 * @param g	���ʶ���
	 */
	protected void drawNumberLeftPad(int x,int y, int num,int maxBit, Graphics g) {
//		������number�е�ÿһλ��ȡ����
		String strNum = Integer.toString(num);
//		ѭ�����������Ҷ���
		for (int i = 0; i < maxBit; i++) {
//			�ж��Ƿ������������
			if(maxBit - i<= strNum.length()){
//				����������ַ����е��±�
				int idx = i - maxBit+strNum.length();
//				������number�е�ÿһλȡ��
				int bit  = strNum.charAt(idx)-'0';
//				��������
				g.drawImage(Img.NUMBER,
						this.x+x+IMG_NUMBER_W*i, this.y+y,
						this.x+x+IMG_NUMBER_W*(i+1), this.y+y+IMG_NUMBER_H,
						IMG_NUMBER_W*bit, 0,
						(bit+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
			}
			
		}
		
	}
	/*
	 * ���Ʒ���
	 */
	protected void createWindow(Graphics g){
		Image img=Img.WINDOW;
		/*
		 * �ز��ı߽�
		 */
//		���Ͻ�
		g.drawImage(img, x, y, x+BORDER, y+BORDER, 0, 0, BORDER, BORDER, null);
//		���Ͻ�
		g.drawImage(img, x+w+BORDER, y, x+w+2*BORDER, y+BORDER, l+BORDER, 0, l+2*BORDER, BORDER, null);
//		���½�
		g.drawImage(img, x, y+h+BORDER, x+BORDER, y+h+2*BORDER, 0, l+BORDER, BORDER, l+2*BORDER, null);
//		���½�
		g.drawImage(img, x+w+BORDER, y+h+BORDER, x+w+2*BORDER, y+h+2*BORDER, l+BORDER, l+BORDER, l+2*BORDER, l+2*BORDER, null);
		/*
		 * �ز��ı߿򣨳��ǣ�
		 */
//		�ϱ�
		g.drawImage(img, x+BORDER, y, x+BORDER+w, y+BORDER, BORDER, 0, BORDER+l, BORDER, null);
//		�±�
		g.drawImage(img, x+BORDER, y+h+BORDER, x+BORDER+w, y+h+2*BORDER, BORDER, 0, BORDER+l, BORDER, null);
//		���
		g.drawImage(img, x, y+BORDER, x+BORDER, y+BORDER+h, 0, BORDER, BORDER, BORDER+l, null);
//		�ұ�
		g.drawImage(img, x+BORDER+w, y+BORDER, x+w+2*BORDER, y+h+BORDER, 0, BORDER, BORDER, BORDER+l, null);
		/*
		 * �ز�����
		 */
		g.drawImage(img, x+BORDER, y+BORDER, x+BORDER+w, y+BORDER+h, BORDER, BORDER, BORDER+l, BORDER+l, null);
	}
	
		public abstract void paint(Graphics g);

		public void setDto(GameDto dto) {
			this.dto = dto;
		}
	

		/**
		 * @param x ֵ�����X����
		 * @param y ֵ�����Y����
		 * @param rect_W ֵ�ۿ��
		 * @param title ֵ�۱���
		 * @param number ֵ����ֵ
		 * @param value ��ǰֵ
		 * @param maxValue ���ֵ
		 * @param g 
		 */
		protected void drawRect(int y,String title,String number,
				double percent,Graphics g) {
//			����ֵ��ʼ��
			int rect_X = this.x + PADDING;
			int rect_Y = this.y + y;
			//		��ʼ������ֵ�ۿ��
			int rect_W = this.w - (PADDING<<1);
//			���Ʊ���
			g.setColor(Color.BLACK);
			g.fillRect(rect_X  , rect_Y  , rect_W    , IMG_RECT_H+4);
			g.setColor(Color.WHITE);
			g.fillRect(rect_X+1, rect_Y+1, rect_W  -2, IMG_RECT_H+2);
			g.setColor(Color.BLACK);
			g.fillRect(rect_X+2, rect_Y+2, rect_W - 4, IMG_RECT_H  );
//			�����ֵ
//			������
			int width =(int) (percent*(rect_W -4));
//			�����ɫ
			int subIdx= (int)(percent*IMG_RECT_W) - 1;
//			����ֵ��
			g.drawImage(Img.RECT, 
					rect_X + 2 , rect_Y + 2,
					rect_X + 2 + width , rect_Y + 2 + IMG_RECT_H,
					subIdx, 0, subIdx+1, IMG_RECT_H,
					null);
			g.setColor(Color.WHITE);
			g.setFont(DEF_FONT);
			g.drawString(title, rect_X + 4, rect_Y + 23);
			if(number!=null){
				g.drawString(number, rect_X+rect_W-60, rect_Y+23);
			}
	
		}
		/**
		 * ���л�ͼ
		 * 
		 * @param g
		 * @param img
		 */
		protected void drawImageAtCenter(Graphics g,Image img) {
			int imgW = img.getWidth(null);
			int imgH = img.getHeight(null);
			int imgX = this.x + (this.w - imgW>>1);
			int imgY = this.y + (this.h - imgH>>1);
			g.drawImage(img, imgX, imgY, null);
		}
	
	
}
