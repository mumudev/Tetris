package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.FrameConfig;
import config.GameConfig;

public class JFrameGame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ϸ������
	 * @param panel ��Ϸ����
	 */
	public JFrameGame(JPanelGame panel){
		FrameConfig cfg = GameConfig.getframeConfig();
		//���ñ���
		this.setTitle(cfg.getTitle());
		//����Ĭ�Ϲر�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(cfg.getWidth(), cfg.getHeight());
		//���ô����ޱ߿�
		this.setUndecorated(true);
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		//����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width-this.getWidth())>>1;
		int y = ((screen.height-this.getHeight())>>1)-cfg.getWindowUp();
		this.setLocation(x,y);
		//������Ϸ����
		this.setContentPane(panel);
		//������ʾ
		this.setVisible(true);
	}	
}
