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
	 * 窗口基坐标X
	 */
	protected final int x;
	/*
	 * 窗口基座标Y
	 */
	protected final int y;
	/*
	 * 窗口长度（去除边框）
	 */
	protected final int w;
	/*
	 * 窗口高度（去除边框）
	 */
	protected final int h;
	/*
	 * 值槽高度
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);
	/*
	 * 值槽宽度
	 */
	protected static final int IMG_RECT_W = Img.RECT.getWidth(null);
	/*
	 * 默认字体
	 */
	protected static final Font DEF_FONT = new Font("黑体",Font.BOLD,20);
	/*
	 * 素材边角像素
	 */
	protected final static int BORDER;
	/*
	 *素材边框长度 
	 */
	protected static final int l;
	/*
	 * 数字图片宽度
	 */
	protected static final int IMG_NUMBER_W=26;
	/*
	 * 数字高度
	 */
	protected static final int IMG_NUMBER_H=36;
	/*
	 * 方块长度
	 */
	protected static final int ACT_SIZE;
	/*
	 * 方块偏移量
	 */
	protected static final int SIZE_ROL;
	/*
	 * 内边距
	 */
	protected static final int PADDING;
	/*
	 * dto数据对象
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
	 * @param x 方框X坐标
	 * @param y 方框Y坐标
	 * @param w 方框宽度
	 * @param h 方框高度
	 */
	public Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	/**
	 * 显示数字
	 * 
	 * @param x 左上角x坐标
	 * @param y 左上角y坐标
	 * @param num 要显示的数字
	 * @param maxBit 数字位数
	 * @param g	画笔对象
	 */
	protected void drawNumberLeftPad(int x,int y, int num,int maxBit, Graphics g) {
//		把数字number中的每一位都取出来
		String strNum = Integer.toString(num);
//		循环绘制数字右对齐
		for (int i = 0; i < maxBit; i++) {
//			判断是否满足绘制条件
			if(maxBit - i<= strNum.length()){
//				获得数字在字符串中的下表
				int idx = i - maxBit+strNum.length();
//				把数字number中的每一位取出
				int bit  = strNum.charAt(idx)-'0';
//				绘制数字
				g.drawImage(Img.NUMBER,
						this.x+x+IMG_NUMBER_W*i, this.y+y,
						this.x+x+IMG_NUMBER_W*(i+1), this.y+y+IMG_NUMBER_H,
						IMG_NUMBER_W*bit, 0,
						(bit+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
			}
			
		}
		
	}
	/*
	 * 绘制方框
	 */
	protected void createWindow(Graphics g){
		Image img=Img.WINDOW;
		/*
		 * 素材四边角
		 */
//		左上角
		g.drawImage(img, x, y, x+BORDER, y+BORDER, 0, 0, BORDER, BORDER, null);
//		右上角
		g.drawImage(img, x+w+BORDER, y, x+w+2*BORDER, y+BORDER, l+BORDER, 0, l+2*BORDER, BORDER, null);
//		左下角
		g.drawImage(img, x, y+h+BORDER, x+BORDER, y+h+2*BORDER, 0, l+BORDER, BORDER, l+2*BORDER, null);
//		右下角
		g.drawImage(img, x+w+BORDER, y+h+BORDER, x+w+2*BORDER, y+h+2*BORDER, l+BORDER, l+BORDER, l+2*BORDER, l+2*BORDER, null);
		/*
		 * 素材四边框（除角）
		 */
//		上边
		g.drawImage(img, x+BORDER, y, x+BORDER+w, y+BORDER, BORDER, 0, BORDER+l, BORDER, null);
//		下边
		g.drawImage(img, x+BORDER, y+h+BORDER, x+BORDER+w, y+h+2*BORDER, BORDER, 0, BORDER+l, BORDER, null);
//		左边
		g.drawImage(img, x, y+BORDER, x+BORDER, y+BORDER+h, 0, BORDER, BORDER, BORDER+l, null);
//		右边
		g.drawImage(img, x+BORDER+w, y+BORDER, x+w+2*BORDER, y+h+BORDER, 0, BORDER, BORDER, BORDER+l, null);
		/*
		 * 素材内容
		 */
		g.drawImage(img, x+BORDER, y+BORDER, x+BORDER+w, y+BORDER+h, BORDER, BORDER, BORDER+l, BORDER+l, null);
	}
	
		public abstract void paint(Graphics g);

		public void setDto(GameDto dto) {
			this.dto = dto;
		}
	

		/**
		 * @param x 值槽相对X坐标
		 * @param y 值槽相对Y坐标
		 * @param rect_W 值槽宽度
		 * @param title 值槽标题
		 * @param number 值槽数值
		 * @param value 当前值
		 * @param maxValue 最大值
		 * @param g 
		 */
		protected void drawRect(int y,String title,String number,
				double percent,Graphics g) {
//			各种值初始化
			int rect_X = this.x + PADDING;
			int rect_Y = this.y + y;
			//		初始化经验值槽宽度
			int rect_W = this.w - (PADDING<<1);
//			绘制背景
			g.setColor(Color.BLACK);
			g.fillRect(rect_X  , rect_Y  , rect_W    , IMG_RECT_H+4);
			g.setColor(Color.WHITE);
			g.fillRect(rect_X+1, rect_Y+1, rect_W  -2, IMG_RECT_H+2);
			g.setColor(Color.BLACK);
			g.fillRect(rect_X+2, rect_Y+2, rect_W - 4, IMG_RECT_H  );
//			求出比值
//			求出宽度
			int width =(int) (percent*(rect_W -4));
//			求出颜色
			int subIdx= (int)(percent*IMG_RECT_W) - 1;
//			绘制值槽
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
		 * 正中绘图
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
