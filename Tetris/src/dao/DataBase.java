package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.Player;

public class DataBase implements Data {
	
	private final String DbUrl;
	
	private final String DbUser;
	
	private final String DbPwd;
	
	private final String LOAD_SQL = "SELECT TOP 5 user_name, point FROM user_point WHERE type_id = 1 ORDER BY point DESC";
	
	private final String SQVE_SQL = "INSERT INTO user_point(user_name, point , type_id)VALUES(?,?,?)";
	
	public DataBase(HashMap<String, String> param) {
		this.DbUrl = param.get("dbUrl");
		this.DbUser = param.get("dbUser");
		this.DbPwd = param.get("dbPwd");
		try {
			Class.forName(param.get("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Player> loadData() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		List<Player> players = new ArrayList<Player>();
		try {
			conn = DriverManager.getConnection(DbUrl, DbUser, DbPwd);
			stmt = conn.prepareStatement(LOAD_SQL);
			rs = stmt.executeQuery();
			while(rs.next()){
				players.add(new Player(rs.getString(1), rs.getInt(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(conn != null)stmt.close();
				if(conn != null)rs.close();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return players;
	}

	@Override
	public void saveData(Player player) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(DbUrl, DbUser, DbPwd);
			stmt = conn.prepareStatement(SQVE_SQL);
			stmt.setObject( 1, player.getName());
			stmt.setObject( 2, player.getPoint());
			stmt.setObject( 3, 1);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)conn.close();
				if(conn != null)stmt.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}
	
}
