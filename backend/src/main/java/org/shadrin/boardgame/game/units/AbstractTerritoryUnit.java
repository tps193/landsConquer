package org.shadrin.boardgame.game.units;

public class AbstractTerritoryUnit {
	
	private int internalObjectId;
	
	public AbstractTerritoryUnit(int internalObjectId) {
		this.internalObjectId = internalObjectId;
	}
	
	public int getInternalObjectId() {
		return internalObjectId;
	}
}
