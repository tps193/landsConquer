package org.shadrin.boardgame.game.units;

public class TerritoryUnit {
	private int id;
	private float cost;
	private TerritoryUnitType type;
	
	private static TerritoryUnit nullUnit;
	
	public TerritoryUnit(int id, float cost, TerritoryUnitType type) {
		this.id = id;
		this.cost = cost;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getCost() {
		return cost;
	}
	
	public TerritoryUnitType getType() {
		return type;
	}

	public static TerritoryUnit getNullUnit() {
		if (nullUnit == null) {
			nullUnit = new TerritoryUnit(0, 0, TerritoryUnitType.NONE);
		}
		return nullUnit;
	}
	
//	public static class Road extends TerritoryUnit {
//		public Road(int id, float cost) {
//			super(id, cost);
//		}
//
//		@Override
//		public TerritoryUnitType getType() {
//			return TerritoryUnitType.ROAD;
//		}
//	}
//	
//	public abstract static class Sector extends TerritoryUnit {
//		public Sector(int id, float cost) {
//			super(id, cost);
//		}
//	}
//	
//	
//	public static class Field extends Sector {
//		public Field(int id, long cost) {
//			super(id,cost);
//		}
//	}
}
