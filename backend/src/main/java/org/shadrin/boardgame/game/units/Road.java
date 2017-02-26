package org.shadrin.boardgame.game.units;

public class Road extends AbstractTerritoryUnit implements ScorableUnit {

	public Road(int internalObjectId) {
		super(internalObjectId);
	}

	@Override
	public int getRegularPrice() {
		return 1;
	}

	@Override
	public int getLowPrice() {
		return getRegularPrice();
	}
	
}
