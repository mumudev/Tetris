package dao;

import java.util.List;

import dto.Player;

public interface Data {
	
	/*
	 * ��ȡ����
	 */
	List<Player> loadData();
	/*
	 * ��������
	 */
	void saveData(Player player);
}
