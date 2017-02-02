package boardgame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.shadrin.boardgame.game.Position;

public class PositionMapsInitialization {

	@Test
	public void rotation() {
		List<Position> positions = new LinkedList<>();
		positions.add(Position.TOP);
		positions.add(Position.RIGHT);
		positions.add(Position.BOTTOM);
		positions.add(Position.LEFT);
		positions.add(Position.TOP);
		Iterator<Position> it = positions.iterator();
		Position rotated = null;
		while (it.hasNext()) {
			if (rotated == null) {
				rotated = it.next();
				continue;
			}
			Position next = it.next();
			Position expectedRotation = rotated.rotate();
			if (next != expectedRotation) {
				fail("Incorrect rotation for " + rotated);
			}
			rotated = next;
		}
	}
	
	@Test
	public void subIndexes() {
		Map<Position, List<Position>> subindexMap = new HashMap<>();
		subindexMap.put(Position.TOP, Arrays.asList(new Position[]{Position.LEFT, Position.RIGHT}));
		subindexMap.put(Position.BOTTOM, Arrays.asList(new Position[]{Position.LEFT, Position.RIGHT}));
		subindexMap.put(Position.LEFT, Arrays.asList(new Position[]{Position.TOP, Position.BOTTOM}));
		subindexMap.put(Position.RIGHT, Arrays.asList(new Position[]{Position.TOP, Position.BOTTOM}));
		
		for(Position key : subindexMap.keySet()) {
			List<Position> expected = new ArrayList<>(subindexMap.get(key));
			List<Position> actual = key.getSubindexes();
			assertTrue(expected.size() == actual.size());
			expected.removeAll(actual);
			assertTrue(expected.isEmpty());
		}
	}
	
	@Test
	public void oppositeElements() {
		Map<Position, Position> expectedOpposite = new HashMap<>();
		expectedOpposite.put(Position.TOP, Position.BOTTOM);
		expectedOpposite.put(Position.BOTTOM, Position.TOP);
		expectedOpposite.put(Position.LEFT, Position.RIGHT);
		expectedOpposite.put(Position.RIGHT, Position.LEFT);
		for(Position key : expectedOpposite.keySet()) {
			assertEquals(expectedOpposite.get(key), key.getOpposite());
		}
	}

}
