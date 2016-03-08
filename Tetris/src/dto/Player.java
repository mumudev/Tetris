package dto;

import java.io.Serializable;

public class Player implements Comparable<Player>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int point;
	public Player(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	
	@Override
	public int compareTo(Player pla) {
		return pla.getPoint()-this.getPoint();
	}
	
}
