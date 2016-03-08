package control;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import config.DataInterfaceConfig;
import config.GameConfig;
import dao.Data;
import service.GameTetris;
import ui.JPanelGame;
/*
 * ������Ҽ����¼�
 * ���ƻ���
 * ������Ϸ�߼�
 * 
 * 
 */
public class GameControl {
	/*
	 * ��Ϸ����
	 */
	private JPanelGame panelGame;
	/*
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	/*
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;
	/*
	 * ��Ϸ�߼���
	 */
	private GameTetris gameservice;
	/*
	 * ��Ϸ�߳�
	 */
	private Thread gameThread = null;
	/**
	 * ��Ϸ��������ʼ������
	 * 
	 * @param panelGame ��Ϸ����
	 * @param gameservice ��Ϸ�߼���
	 */
	public GameControl(JPanelGame panelGame,GameTetris gameservice) {
		this.panelGame=panelGame;
		this.gameservice=gameservice;
//		��������
		this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
//		�������ݿ��¼����Ϸ
		this.gameservice.setRecodeDataBase(dataA.loadData());
//		�����ݽӿ�A������ݿ��¼
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
//		���ñ��ش��̼�¼����Ϸ
		this.gameservice.setRecodeDisk(dataB.loadData());
	}
	
	private Data createDataObject(DataInterfaceConfig cfg) {

		try {
//			��������
			Class<?> cls = Class.forName(cfg.getClassName());
//			��ù�����
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
//			��������
			return (Data)ctr.newInstance(cfg.getParam());
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*
	 * ��������������ϣ�
	 * �����鷭����
	 */
	public void keyUp() {
		this.gameservice.keyUp();
		this.panelGame.repaint();
	}
	/*
	 * ��������������£�
	 * �������
	 */
	public void keyDown() {
		this.gameservice.keyDown();
		this.panelGame.repaint();
	}
	/*
	 * ���������������
	 */
	public void keyLeft() {
		this.gameservice.keyLeft();
		this.panelGame.repaint();
	}
	/*
	 * ��������������ң�
	 */
	public void keyRight() {
		this.gameservice.keyRight();
		this.panelGame.repaint();
	}
	
	/********************************����ר�÷���************************/
	private int a = 500;
	@SuppressWarnings("deprecation")
	public void testLevelUp() {
		
		if(this.gameThread==null||!this.gameThread.isAlive()){
			this.gameservice.testLevelUp();
			this.panelGame.repaint();
			this.gameThread = new Thread(){
				@Override
				public void run(){
					while(true){
						try {
							gameservice.keyDown();
							panelGame.repaint();
							sleep(a);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			this.gameThread.start();
			this.panelGame.repaint();
			
		}
		else {
			this.gameThread.stop();
		}
	}
	public void testLevelUp1() {
		a+=50;
	}
	public void testLevelUp2() {
		if(a>50)
		a-=50;
	}
	public boolean isStart() {
		if(this.gameThread !=null)
			return this.gameThread.isAlive();
		else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public void restart() {
		this.gameservice.restart();
		this.panelGame.repaint();
		this.gameThread.stop();
	}
	
	
	
	
	
	
	
	
	
	
	
}

