package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter{
	/*
	 * 游戏控制器
	 */
	private GameControl gameControl; 
	
	/**
	 * 玩操作监听器初始化
	 * 
	 * @param gameControl 游戏控制器
	 */
	public PlayerControl(GameControl gameControl) {
		
		this.gameControl=gameControl;
		
	}
	/*
	 * 键盘按下事件
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 这样的枚举写法不好
//		switch case 新手专用，考试专用，高玩远离
		if(gameControl.isStart()||e.getKeyCode() == KeyEvent.VK_T||e.getKeyCode() == KeyEvent.VK_R)
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			this.gameControl.keyRight();
			break;
//			TODO 测试方法
		case KeyEvent.VK_T:
			this.gameControl.testLevelUp();
			break;
//			TODO 测试方法
		case 45:
			this.gameControl.testLevelUp1();
			break;
//			TODO 测试方法
		case 61:
			this.gameControl.testLevelUp2();
			break;
//			TODO 测试方法
		case KeyEvent.VK_R:
			this.gameControl.restart();
			break;
		default:
			break;
		}
		
	}

}
