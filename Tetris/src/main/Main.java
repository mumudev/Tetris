package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameTetris;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		
//		创建游戏数据源
		GameDto dto = new GameDto();
//		创建游戏面板
		JPanelGame panel = new JPanelGame(dto);
//		创建游戏逻辑块（链接游戏数据源）
		GameTetris gameService = new GameTetris(dto);
//		创建游戏控制器（链接游戏面板与游戏逻辑块）
		GameControl gameControl = new GameControl(panel,gameService);
//		创建玩家控制器（连接游戏控制器）
		PlayerControl playerControl = new PlayerControl(gameControl);
//		安装玩家控制器
		panel.setPlaerControl(playerControl);
//		创建游戏窗口，安装游戏面板
		new JFrameGame(panel);
		
	}
	
}
