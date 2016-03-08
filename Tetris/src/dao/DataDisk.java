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
//		先取出数据
		List<Player> players = this.loadData();
//		追加新纪录
		players.add(player);
//		排序新数据
		setFillRecoder(players);
//		只取前五位保存
		if(players.size()>5){
			for (int i = 5; i < players.size(); i++) {
				players.remove(i);
			}
		}
//		重新写入
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
	
	
	
	
}
