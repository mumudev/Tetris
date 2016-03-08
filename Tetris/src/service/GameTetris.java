package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;
import dto.GameDto;
import dto.Player;
import entity.GameAct;
/*
 * 游戏逻辑块
 * 
 * @author Carrollraider
 */
public class GameTetris {
	/*
	 * 游戏数据源
	 */
	private GameDto dto;
	/*
	 * 随机数生成器
	 */
	private Random random = new Random();
	/*
	 * 方块种类
	 */
	//TODO 硬编码
	private static final int MAX_TYPE = 7;
	
//	获得地图对象
	boolean[][] gameMap;
	public GameTetris(GameDto dto) {
		this.dto=dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		gameMap=this.dto.getGameMap();
		dto.setGameAct(act);
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}
	/*
	 * 控制器方向键（上）
	 */
	public void keyUp() {
//		TODO 旋转
			this.dto.getGameAct().round(this.dto.getGameMap());
		
	}
	/*
	 * 控制器方向键（下）
	 */
	public void keyDown() {
			if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
				return;
			}
			
//			获得游戏地图对象
			Point[] act = this.dto.getGameAct().getActPoints(); 
//			方块堆积到地图数组	
			for (int i = 0; i < act.length; i++) {
				gameMap[act[i].x][act[i].y] = true;
			}
			
//		   	判断消行，并计算获得经验值
			int exp = this.plusExp();
			this.dto.setNowPoint(this.dto.getNowPoint()+exp*10);
//			算分操作
//			TODO 判断是否升级
//			TODO 升级
//			刷新一个方块
			this.dto.getGameAct().init(this.dto.getNext());
//			随机生成下一个方块
			this.dto.setNext(random.nextInt(MAX_TYPE));
				
			
	}
	/*
	 * 控制器方向键（左）
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
		
	}
	/*
	 * 控制器方向键（右）
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	/*
	 * 消行操作
	 */
	private int plusExp(){
//		获得游戏地图
		gameMap = this.dto.getGameMap();
//		计算经验值
		int exp = 0;
//		消行数
		int removeLineNumber = 0;
//		扫描游戏地图，查看是否有可消行
		for (int y = 0; y < GameDto.GAMEZONE_H; y++) {
//			判断是否可消行
			if(isCanRemoveLine(y, gameMap)){
//				如果可以消行，那就消
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
	 * 消行处理
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
	 * 判断是否可以消行
	 */
	private boolean isCanRemoveLine(int y , boolean[][] gameMap) {
//		单行内对每一个单元格进行扫描
		for (int x = 0; x < GameDto.GAMEZONE_W; x++) {
			if(!gameMap[x][y]){
//				如果有一个方格为false则直接跳到下一行
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
	
	/*********************测试专用方法************************/
	public void testLevelUp() {
	}

	public void restart() {
//		刷新一个方块
		this.dto.getGameAct().init(this.dto.getNext());
//		随机生成下一个方块
		this.dto.setNext(random.nextInt(MAX_TYPE));
		for (int x = 0; x < gameMap.length; x++) {
			for (int y = 0; y < gameMap[x].length; y++) {
				gameMap[x][y] = false;
			}
		}
		this.dto.setGameMap(gameMap);
	}
	
	
	
	
}
