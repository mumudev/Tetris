package control;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import config.DataInterfaceConfig;
import config.GameConfig;
import dao.Data;
import service.GameTetris;
import ui.JPanelGame;
/*
 * 接受玩家键盘事件
 * 控制画面
 * 控制游戏逻辑
 * 
 * 
 */
public class GameControl {
	/*
	 * 游戏窗口
	 */
	private JPanelGame panelGame;
	/*
	 * 数据访问接口A
	 */
	private Data dataA;
	/*
	 * 数据访问接口B
	 */
	private Data dataB;
	/*
	 * 游戏逻辑块
	 */
	private GameTetris gameservice;
	/*
	 * 游戏线程
	 */
	private Thread gameThread = null;
	/**
	 * 游戏控制器初始化函数
	 * 
	 * @param panelGame 游戏窗口
	 * @param gameservice 游戏逻辑块
	 */
	public GameControl(JPanelGame panelGame,GameTetris gameservice) {
		this.panelGame=panelGame;
		this.gameservice=gameservice;
//		获得类对象
		this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
//		设置数据库记录到游戏
		this.gameservice.setRecodeDataBase(dataA.loadData());
//		从数据接口A获得数据库记录
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
//		设置本地磁盘记录到游戏
		this.gameservice.setRecodeDisk(dataB.loadData());
	}
	
	private Data createDataObject(DataInterfaceConfig cfg) {

		try {
//			获得类对象
			Class<?> cls = Class.forName(cfg.getClassName());
//			获得构造器
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
//			创建对象
			return (Data)ctr.newInstance(cfg.getParam());
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*
	 * 控制器方向键（上）
	 * （方块翻滚）
	 */
	public void keyUp() {
		this.gameservice.keyUp();
		this.panelGame.repaint();
	}
	/*
	 * 控制器方向键（下）
	 * 方块加速
	 */
	public void keyDown() {
		this.gameservice.keyDown();
		this.panelGame.repaint();
	}
	/*
	 * 控制器方向键（左）
	 */
	public void keyLeft() {
		this.gameservice.keyLeft();
		this.panelGame.repaint();
	}
	/*
	 * 控制器方向键（右）
	 */
	public void keyRight() {
		this.gameservice.keyRight();
		this.panelGame.repaint();
	}
	
	/********************************测试专用方法************************/
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

