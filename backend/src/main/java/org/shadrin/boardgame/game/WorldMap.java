package org.shadrin.boardgame.game;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
	Map<Point,Tile> grid = new HashMap<>();

	
	public boolean canPutTileTo(int x, int y, Tile tile) {
		if (tile == null) {
			return false;
		}
		if (grid.get(new Point(x,y)) != null) {
			return false;
		}
		boolean result = true;
		boolean noNeighbours = true;
		for (Position position : Position.values()) {
			Point positionShift = position.getNeighbourPointShift();
			Tile existing = grid.get(new Point(x + positionShift.getX(), y + positionShift.getY()));
			noNeighbours = noNeighbours && existing == null;
			result = result && (existing == null ? true : tile.canConcatWithBy(existing, position));
		}
		if (result && noNeighbours) {
			return grid.size() == 0;
		}
		return result;
	}
	
	public boolean putTileTo(int x, int y, Tile tile) {
		if (canPutTileTo(x, y, tile)) {
			grid.put(new Point(x,y), tile);
			return true;
		}
		return false;
	}
	
	
}
