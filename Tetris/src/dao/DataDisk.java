package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dto.Player;

public class DataDisk implements Data{
	
	private String FilePath;
	public DataDisk(HashMap<String, String> param) {
		this.FilePath = param.get("path");
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> loadData() {
		List<Player> players = null;
		ObjectInputStream ois = null;
		if(new File(FilePath).exists())
		try {
			ois = new ObjectInputStream(new FileInputStream(FilePath));
			players = (List<Player>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return players;
	}

	@Override
	public void saveData(Player player) {
//		��ȡ������
		List<Player> players = this.loadData();
//		׷���¼�¼
		players.add(player);
//		����������
		setFillRecoder(players);
//		ֻȡǰ��λ����
		if(players.size()>5){
			for (int i = 5; i < players.size(); i++) {
				players.remove(i);
			}
		}
//		����д��
		ObjectOutputStream oos = null;
		try {
			 oos = new ObjectOutputStream(new FileOutputStream(FilePath));
			 oos.writeObject(players);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private List<Player> setFillRecoder(List<Player> players) {
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
	
	
	
	
}
