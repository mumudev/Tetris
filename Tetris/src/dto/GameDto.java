package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;
import entity.GameAct;

public class GameDto {
	/***********************/
	/*
	 * 玩家数据库记录
	 */
	private List<Player> dbRecode;
	/*
	 * 玩家硬盘记录
	 */
	private List<Player> diskRecode;
	/***********************/
	/*
	 * 当前游戏地图
	 */
	private boolean[][] gameMap;
	/*
	 * 游戏方块
	 */
	private GameAct gameAct;
	/*
	 * 地图宽度
	 */
	private int mapW;
	/*
	 * 地图高度
	 */
	private int mapH;
	/***********************/
	/*
	 * 下一个方块类型
	 */
	private int next;
	/*
	 * 游戏等级
	 */
	private int nowLevel;
	/*
	 * 当前分数
	 */
	private int nowPoint;
	/*
	 * 当前消除行
	 */
	private int nowRemoveLine;
	/*
	 * TODO 配置文件
	 */
	public static final int GAMEZONE_W = 10;
	/*
	 * TODO 配置文件
	 */
	public static final int GAMEZONE_H = 18;
	/***********************/
	/*
	 * 数据库初始化函数
	 */
	public GameDto(){
		mapW=GameConfig.getframeConfig().getMapW();
		mapH=GameConfig.getframeConfig().getMapH();
		dtoInit();
	}
	
	public void dtoInit(){
		this.gameMap=new boolean[mapW][mapH];
//		TODO 初始化所有游戏对象
	}
	
	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = setFillRecode(dbRecode);
	}
	
	private List<Player> setFillRecode(List<Player> players) {
//		如果进来的是空，那么就创建
		if(players == null){
			players = new ArrayList<Player>();
		}
//		如果记录小于5，那么就加到5条为止
		while(players.size()<5){
			players.add(new Player("No Data", 0));
		}
		Collections.sort(players);
		return players;
	}
	
	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = setFillRecode(diskRecode);
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct act) {
		this.gameAct = act;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNowLevel() {
		return nowLevel;
	}

	public void setNowLevel(int level) {
		this.nowLevel = level;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
	
	
	
	
}
