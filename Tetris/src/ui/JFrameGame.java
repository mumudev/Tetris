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
	 * 游戏主界面
	 * @param panel 游戏容器
	 */
	public JFrameGame(JPanelGame panel){
		FrameConfig cfg = GameConfig.getframeConfig();
		//设置标题
		this.setTitle(cfg.getTitle());
		//设置默认关闭属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(cfg.getWidth(), cfg.getHeight());
		//设置窗口无边框
		this.setUndecorated(true);
		//不允许用户改变窗口大小
		this.setResizable(false);
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width-this.getWidth())>>1;
		int y = ((screen.height-this.getHeight())>>1)-cfg.getWindowUp();
		this.setLocation(x,y);
		//设置游戏窗口
		this.setContentPane(panel);
		//界面显示
		this.setVisible(true);
	}	
}
