package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter{
	/*
	 * ��Ϸ������
	 */
	private GameControl gameControl; 
	
	/**
	 * �������������ʼ��
	 * 
	 * @param gameControl ��Ϸ������
	 */
	public PlayerControl(GameControl gameControl) {
		
		this.gameControl=gameControl;
		
	}
	/*
	 * ���̰����¼�
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO ������ö��д������
//		switch case ����ר�ã�����ר�ã�����Զ��
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
//			TODO ���Է���
		case KeyEvent.VK_T:
			this.gameControl.testLevelUp();
			break;
//			TODO ���Է���
		case 45:
			this.gameControl.testLevelUp1();
			break;
//			TODO ���Է���
		case 61:
			this.gameControl.testLevelUp2();
			break;
//			TODO ���Է���
		case KeyEvent.VK_R:
			this.gameControl.restart();
			break;
		default:
			break;
		}
		
	}

}
