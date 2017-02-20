package boardgame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.shadrin.boardgame.game.Tile;
import org.shadrin.boardgame.game.WorldMap;

public class WorldMapTest {

	@Test
	public void testTilePutting() {
		WorldMap map = new WorldMap();
		
		Tile startTile = TileTest.generateStartTile();
		assertTrue(map.putTileTo(0, 0, startTile));
		assertFalse(map.putTileTo(0, 1, startTile));
		assertTrue(map.putTileTo(1, 0, startTile));
		assertTrue(map.putTileTo(2, 0, startTile));
		
		assertFalse(map.putTileTo(5, 5, startTile));
	}
}
