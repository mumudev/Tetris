package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameTetris;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		
//		������Ϸ����Դ
		GameDto dto = new GameDto();
//		������Ϸ���
		JPanelGame panel = new JPanelGame(dto);
//		������Ϸ�߼��飨������Ϸ����Դ��
		GameTetris gameService = new GameTetris(dto);
//		������Ϸ��������������Ϸ�������Ϸ�߼��飩
		GameControl gameControl = new GameControl(panel,gameService);
//		������ҿ�������������Ϸ��������
		PlayerControl playerControl = new PlayerControl(gameControl);
//		��װ��ҿ�����
		panel.setPlaerControl(playerControl);
//		������Ϸ���ڣ���װ��Ϸ���
		new JFrameGame(panel);
		
	}
	
}
