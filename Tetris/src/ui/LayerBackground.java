package ui;

import java.awt.Graphics;
import config.FrameConfig;
import config.GameConfig;

public class LayerBackground extends Layer {
	/*
	 * ���ڿ��
	 */
	private int width;
	/*
	 * ���ڸ߶�
	 */
	private int height;
	/*
	 * ����ͼƬ���
	 */
	private int imageWidth;
	/*
	 * ����ͼƬ�߶�
	 */
	private int imageHeight;

	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
//		��ô�������
		FrameConfig cfg=GameConfig.getframeConfig();
//		��ô��ڿ��
		this.width=cfg.getWidth();
//		��ô��ڸ߶�
		this.height=cfg.getHeight();
//		���ͼƬ���
		this.imageWidth=cfg.getImageWidth();
//		���ͼƬ�߶�
		this.imageHeight=cfg.getImageHeight();
	}

	public void paint(Graphics g) {
//		���ݵȼ����Ʊ���
		int bgIdx = this.dto.getNowLevel()%8;
//		���Ʊ���
		g.drawImage(Img.BG_LIST.get(bgIdx), 0, 0, width, height, 0, 0, imageWidth, imageHeight, null);
	}

}
