package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;
import dto.GameDto;
import dto.Player;
import entity.GameAct;
/*
 * ��Ϸ�߼���
 * 
 * @author Carrollraider
 */
public class GameTetris {
	/*
	 * ��Ϸ����Դ
	 */
	private GameDto dto;
	/*
	 * �����������
	 */
	private Random random = new Random();
	/*
	 * ��������
	 */
	//TODO Ӳ����
	private static final int MAX_TYPE = 7;
	
//	��õ�ͼ����
	boolean[][] gameMap;
	public GameTetris(GameDto dto) {
		this.dto=dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		gameMap=this.dto.getGameMap();
		dto.setGameAct(act);
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}
	/*
	 * ��������������ϣ�
	 */
	public void keyUp() {
//		TODO ��ת
			this.dto.getGameAct().round(this.dto.getGameMap());
		
	}
	/*
	 * ��������������£�
	 */
	public void keyDown() {
			if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
				return;
			}
			
//			�����Ϸ��ͼ����
			Point[] act = this.dto.getGameAct().getActPoints(); 
//			����ѻ�����ͼ����	
			for (int i = 0; i < act.length; i++) {
				gameMap[act[i].x][act[i].y] = true;
			}
			
//		   	�ж����У��������þ���ֵ
			int exp = this.plusExp();
			this.dto.setNowPoint(this.dto.getNowPoint()+exp*10);
//			��ֲ���
//			TODO �ж��Ƿ�����
//			TODO ����
//			ˢ��һ������
			this.dto.getGameAct().init(this.dto.getNext());
//			���������һ������
			this.dto.setNext(random.nextInt(MAX_TYPE));
				
			
	}
	/*
	 * ���������������
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
		
	}
	/*
	 * ��������������ң�
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	/*
	 * ���в���
	 */
	private int plusExp(){
//		�����Ϸ��ͼ
		gameMap = this.dto.getGameMap();
//		���㾭��ֵ
		int exp = 0;
//		������
		int removeLineNumber = 0;
//		ɨ����Ϸ��ͼ���鿴�Ƿ��п�����
		for (int y = 0; y < GameDto.GAMEZONE_H; y++) {
//			�ж��Ƿ������
			if(isCanRemoveLine(y, gameMap)){
//				����������У��Ǿ���
				this.removeLine(y,gameMap);
				removeLineNumber++;
				exp = 1;
			}
		}
		this.dto.setNowRemoveLine(this.dto.getNowRemoveLine()+removeLineNumber);
		while(--removeLineNumber>0){
			exp = (removeLineNumber<<1)+exp;
		}
		return exp;
	}
	/*
	 * ���д���
	 */
	private void removeLine(int rowNumber,boolean[][] gameMap) {
		for (int x = 0; x < GameDto.GAMEZONE_W; x++) {
			for (int y = rowNumber; y >0; y--) {
				gameMap[x][y] = gameMap[x][y - 1];
			}
			gameMap[x][0]=false;
		}
	}

	/*
	 * �ж��Ƿ��������
	 */
	private boolean isCanRemoveLine(int y , boolean[][] gameMap) {
//		�����ڶ�ÿһ����Ԫ�����ɨ��
		for (int x = 0; x < GameDto.GAMEZONE_W; x++) {
			if(!gameMap[x][y]){
//				�����һ������Ϊfalse��ֱ��������һ��
				return false;
			}
		}
		return true;
	}

	public void setRecodeDataBase(List<Player> players) {
		this.dto.setDbRecode(players);
	}
	
	
	public void setRecodeDisk(List<Player> players) {
		this.dto.setDiskRecode(players);
	}
	
	/*********************����ר�÷���************************/
	public void testLevelUp() {
	}

	public void restart() {
//		ˢ��һ������
		this.dto.getGameAct().init(this.dto.getNext());
//		���������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));
		for (int x = 0; x < gameMap.length; x++) {
			for (int y = 0; y < gameMap[x].length; y++) {
				gameMap[x][y] = false;
			}
		}
		this.dto.setGameMap(gameMap);
	}
	
	
	
	
}
