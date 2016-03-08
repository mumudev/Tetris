package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;
import entity.GameAct;

public class GameDto {
	/***********************/
	/*
	 * ������ݿ��¼
	 */
	private List<Player> dbRecode;
	/*
	 * ���Ӳ�̼�¼
	 */
	private List<Player> diskRecode;
	/***********************/
	/*
	 * ��ǰ��Ϸ��ͼ
	 */
	private boolean[][] gameMap;
	/*
	 * ��Ϸ����
	 */
	private GameAct gameAct;
	/*
	 * ��ͼ���
	 */
	private int mapW;
	/*
	 * ��ͼ�߶�
	 */
	private int mapH;
	/***********************/
	/*
	 * ��һ����������
	 */
	private int next;
	/*
	 * ��Ϸ�ȼ�
	 */
	private int nowLevel;
	/*
	 * ��ǰ����
	 */
	private int nowPoint;
	/*
	 * ��ǰ������
	 */
	private int nowRemoveLine;
	/*
	 * TODO �����ļ�
	 */
	public static final int GAMEZONE_W = 10;
	/*
	 * TODO �����ļ�
	 */
	public static final int GAMEZONE_H = 18;
	/***********************/
	/*
	 * ���ݿ��ʼ������
	 */
	public GameDto(){
		mapW=GameConfig.getframeConfig().getMapW();
		mapH=GameConfig.getframeConfig().getMapH();
		dtoInit();
	}
	
	public void dtoInit(){
		this.gameMap=new boolean[mapW][mapH];
//		TODO ��ʼ��������Ϸ����
	}
	
	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = setFillRecode(dbRecode);
	}
	
	private List<Player> setFillRecode(List<Player> players) {
//		����������ǿգ���ô�ʹ���
		if(players == null){
			players = new ArrayList<Player>();
		}
//		�����¼С��5����ô�ͼӵ�5��Ϊֹ
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
