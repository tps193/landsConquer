package boardgame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shadrin.boardgame.game.Position;
import org.shadrin.boardgame.game.Tile;
import org.shadrin.boardgame.game.Tile.SectorPosition;
import org.shadrin.boardgame.game.units.TerritoryUnit;
import org.shadrin.boardgame.game.units.TerritoryUnitType;

public class TileTest {

	@Before
	public void setUp() throws Exception {
	}
	
	public static Tile generateStartTile() {
		Tile startTile = new Tile();
		startTile.addSector(new SectorPosition(Position.TOP, Position.LEFT), new TerritoryUnit(1, 0.5f, TerritoryUnitType.CITY));
		startTile.addSector(new SectorPosition(Position.TOP, Position.RIGHT), new TerritoryUnit(1, 0.5f, TerritoryUnitType.CITY));
		
		startTile.addSector(new SectorPosition(Position.LEFT, Position.TOP), new TerritoryUnit(2, 0, TerritoryUnitType.FIELD));
		startTile.addSector(new SectorPosition(Position.RIGHT, Position.TOP), new TerritoryUnit(2, 0.5f, TerritoryUnitType.FIELD));

		startTile.addSector(new SectorPosition(Position.LEFT, Position.BOTTOM), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		startTile.addSector(new SectorPosition(Position.RIGHT, Position.BOTTOM), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		startTile.addSector(new SectorPosition(Position.BOTTOM, Position.LEFT), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		startTile.addSector(new SectorPosition(Position.BOTTOM, Position.RIGHT), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		
		startTile.addRoad(Position.LEFT, new TerritoryUnit(1, 0.5f, TerritoryUnitType.ROAD));
		startTile.addRoad(Position.RIGHT, new TerritoryUnit(1, 0.5f, TerritoryUnitType.ROAD));
		
		return startTile;
	}
	
	private Tile getOnceRotatedStartTile() {
		Tile rotated = new Tile();
		rotated.addSector(new SectorPosition(Position.TOP, Position.LEFT), new TerritoryUnit(1, 0.5f, TerritoryUnitType.CITY));
		rotated.addSector(new SectorPosition(Position.TOP, Position.RIGHT), new TerritoryUnit(1, 0.5f, TerritoryUnitType.CITY));
		
		rotated.addSector(new SectorPosition(Position.LEFT, Position.TOP), new TerritoryUnit(2, 0, TerritoryUnitType.FIELD));
		rotated.addSector(new SectorPosition(Position.RIGHT, Position.TOP), new TerritoryUnit(2, 0.5f, TerritoryUnitType.FIELD));

		rotated.addSector(new SectorPosition(Position.LEFT, Position.BOTTOM), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		rotated.addSector(new SectorPosition(Position.RIGHT, Position.BOTTOM), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		rotated.addSector(new SectorPosition(Position.BOTTOM, Position.LEFT), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		rotated.addSector(new SectorPosition(Position.BOTTOM, Position.RIGHT), new TerritoryUnit(3, 0.5f, TerritoryUnitType.FIELD));
		
		rotated.addRoad(Position.LEFT, new TerritoryUnit(1, 0.5f, TerritoryUnitType.ROAD));
		rotated.addRoad(Position.RIGHT, new TerritoryUnit(1, 0.5f, TerritoryUnitType.ROAD));
		
		return rotated;
	}

	@Test
	public void test() {
		Tile startTile = generateStartTile();
		Tile startTileCopy = generateStartTile();
		
		assertTrue(startTile.canConcatWithBy(startTileCopy, Position.RIGHT));
		assertTrue(startTile.canConcatWithBy(startTileCopy, Position.LEFT));
		assertFalse(startTile.canConcatWithBy(startTileCopy, Position.TOP));
		assertFalse(startTile.canConcatWithBy(startTileCopy, Position.BOTTOM));
		
		startTileCopy.rotate();
		assertFalse(startTile.canConcatWithBy(startTileCopy, Position.RIGHT));
		startTileCopy.rotate();
		assertTrue(startTile.canConcatWithBy(startTileCopy, Position.RIGHT));
		startTileCopy.rotate();
		assertFalse(startTile.canConcatWithBy(startTileCopy, Position.RIGHT));
		startTileCopy.rotate();
		assertTrue(startTile.canConcatWithBy(startTileCopy, Position.RIGHT));
	}

}
