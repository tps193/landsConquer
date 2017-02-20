package org.shadrin.boardgame.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shadrin.boardgame.game.units.TerritoryUnit;
import org.shadrin.boardgame.game.units.TerritoryUnitType;

public class Tile {
	//TODO: check if the capicity=8,loadfactor=1.0 will help to have the map with the permanent size
	private Map<SectorPosition, TerritoryUnit> sectors = new HashMap<>(8, 1.0f);
	//TODO: the same for roads
	private Map<Position, TerritoryUnit> roads = new HashMap<>(4, 1.0f);
	private boolean hasMonastery = false;
	
	public Tile addSector(SectorPosition position, TerritoryUnit unit) {
		if (unit.getType() != TerritoryUnitType.FIELD && unit.getType() != TerritoryUnitType.CITY) {
			throw new IllegalArgumentException("The Field or City type only is expected");
		}
		sectors.put(position, unit);
		return this;
	}
	
	public Tile addRoad(Position position, TerritoryUnit road) {
		if (road.getType() != TerritoryUnitType.ROAD) {
			throw new IllegalArgumentException("The Road type only is expected");
		}
		roads.put(position, road);
		return this;
	}
	
	public boolean canConcatWithBy(Tile other, Position primarySectorPosition) {
		boolean result = true;
		List<Position> subIndexes = primarySectorPosition.getSubindexes();
		if (subIndexes.size() == 2) {
			for (Position subIndex : subIndexes) {
				SectorPosition mySectorPosition = new SectorPosition(primarySectorPosition, subIndex);
				SectorPosition oppositeSectorPosition = new SectorPosition(primarySectorPosition.getOpposite(), subIndex);
				result &= sectors.get(mySectorPosition).getType() == other.sectors.get(oppositeSectorPosition).getType();
			}
		} else {
			result = false;
		}
		if (result) {
			TerritoryUnit myRoad = roads.getOrDefault(primarySectorPosition, TerritoryUnit.getNullUnit());
			TerritoryUnit otherRoad = other.roads.getOrDefault(primarySectorPosition.getOpposite(), TerritoryUnit.getNullUnit());
			result &= myRoad.getType() == otherRoad.getType();
		}
		return result;
	}
	
	public void rotate() {
		Map<SectorPosition, TerritoryUnit> newSectorsMap = new HashMap<>();
		sectors.forEach((position, unit) -> newSectorsMap.put(new SectorPosition(position.primary.rotate(), position.secondary.rotate()), unit));
		sectors = newSectorsMap;
		
		Map<Position, TerritoryUnit> newRoadsMap = new HashMap<>();
		roads.forEach((position, unit) -> newRoadsMap.put(position.rotate(), unit));
		roads = newRoadsMap;
	}
	
	public static class SectorPosition {
		/*
		 * TODO: we have only 8 different SectorPositions so maybe it is better to cache them and store in some map
		 * instead of create new one every time we need it.
		 */
		private Position primary;
		private Position secondary;
		
		public SectorPosition(Position primary, Position secondary) {
			this.primary = primary;
			this.secondary = secondary;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof SectorPosition) {
				SectorPosition other = (SectorPosition) obj;
				return primary == other.primary && secondary == other.secondary;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = result * 17 + (primary != null ? primary.hashCode() : 0);
			result = result * 17 + (secondary != null ? secondary.hashCode() : 0);
			return result;
		}
	}
}
