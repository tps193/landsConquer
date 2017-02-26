package org.shadrin.boardgame.game.units;

public class CitySector extends AbstractTerritoryUnit implements ScorableUnit {

	private boolean shield;
	
	public CitySector(int internalObjectId, boolean shield) {
		super(internalObjectId);
		this.shield = shield;
	}
	
	public boolean hasShield() {
		return shield;
	}
	
	public int getShieldPrice() {
		return 2;
	}
	
	@Override
	public int getRegularPrice() {
		return 2;
	}

	@Override
	public int getLowPrice() {
		return 1;
	}
	
}
