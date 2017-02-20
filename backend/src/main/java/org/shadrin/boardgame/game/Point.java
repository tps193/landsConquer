package org.shadrin.boardgame.game;

public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 17 * result + x;
		result = 17 * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Point) {
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}
		return false;
	}
}