package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import config.GameConfig;
import dto.Player;

public abstract class LayerData extends Layer {

	/*
	 * ���������
	 */
	private static final int MAX_ROM = GameConfig.getDataConfig().getMaxRow();
	/*
	 *��ʼY���� 
	 */
	private static int START_Y = 0;
	/*
	 * ���
	 */
	private static int SPA = 0;

	private static final int RECT_H = IMG_RECT_H+4;
	
	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - RECT_H *5 - (PADDING<<1) - Img.DB.getHeight(null))/MAX_ROM;
		START_Y = PADDING + Img.DB.getHeight(null)+SPA;
	}

	@Override
	 abstract public void paint(Graphics g) ;
	/**
	 * ���Ƹô�������ֵ��
	 * 
	 * @param imgTitle ����ͼƬ
	 * @param players ����Դ
	 * @param g ����
	 */
	public void showData(Image imgTitle ,List<Player> players ,Graphics g) {
//		���Ʊ���
		g.drawImage(imgTitle, this.x+PADDING, this.y+PADDING, null);
//		������ڷ���
		int nowPoint = this.dto.getNowPoint();
//		ѭ�����Ƽ�¼
		for (int i = 0; i < MAX_ROM; i++) {
//			���һ����Ҽ�¼
			Player player = players.get(i);
//			ֵ�۱�ֵ
			double percent = (double)nowPoint/player.getPoint();
//			�������ڷ������¼������ֵ
			percent = percent > 1 ? 1.0: percent;
//			����ֵ��
			this.drawRect(START_Y+i*(RECT_H+SPA), player.getName(),
					Integer.toString(player.getPoint()),percent, g);
		}
	}
}
