package ui;

import java.awt.Graphics;
import config.FrameConfig;
import config.GameConfig;

public class LayerBackground extends Layer {
	/*
	 * 窗口宽度
	 */
	private int width;
	/*
	 * 窗口高度
	 */
	private int height;
	/*
	 * 背景图片宽度
	 */
	private int imageWidth;
	/*
	 * 背景图片高度
	 */
	private int imageHeight;

	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
//		获得窗口属性
		FrameConfig cfg=GameConfig.getframeConfig();
//		获得窗口宽度
		this.width=cfg.getWidth();
//		获得窗口高度
		this.height=cfg.getHeight();
//		获得图片宽度
		this.imageWidth=cfg.getImageWidth();
//		获得图片高度
		this.imageHeight=cfg.getImageHeight();
	}

	public void paint(Graphics g) {
//		依据等级绘制背景
		int bgIdx = this.dto.getNowLevel()%8;
//		绘制背景
		g.drawImage(Img.BG_LIST.get(bgIdx), 0, 0, width, height, 0, 0, imageWidth, imageHeight, null);
	}

}
