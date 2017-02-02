package org.shadrin.boardgame.game;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
	Map<Point,Tile> grid = new HashMap<>();

	
	public boolean canPutTileTo(int x, int y, Tile tile) {
		
		return false;
	}
	
	public static class Point {
		private int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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
}
