package org.shadrin.boardgame.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public enum Position {
	TOP, BOTTOM, LEFT, RIGHT;
	
	public Position getOpposite() {
		return oppositeElements.get(this);
	}
	
	public Position rotate() {
		return rotateMap.get(this);
	}
	
	public List<Position> getSubindexes() {
		return subindexMap.get(this);
	}
	
	private static Map<Position, Position> oppositeElements = new HashMap<>();
	private static Map<Position, Position> rotateMap = new HashMap<>();
	private static Map<Position, List<Position>> subindexMap = new HashMap<>();
	
	private static void initOppositePair(Position first, Position second) {
		oppositeElements.put(first, second);
		oppositeElements.put(second, first);
	}
	
	private static void initSubindexes(Map<Position,Position> rotateMap) {
		for(Position firstSubIndex : rotateMap.keySet()) {
			List<Position> subIndexes = new ArrayList<>(2);
			subIndexes.add(firstSubIndex);
			Position primaryIndex = rotateMap.get(firstSubIndex);
			subIndexes.add(rotateMap.get(primaryIndex));
			subindexMap.put(primaryIndex, subIndexes);
		}
	}
	
	private static Function<Position, Position> addRotateElement(Position to) {
		return (from) -> rotateMap.put(from, to) == null ? to : null;
	}
	
	static {
		initOppositePair(TOP, BOTTOM);
		initOppositePair(LEFT, RIGHT);
		
		//XXX: absolutely crazy applying of the Function interface. Code is unreadable. Used here just to play with Java 8 features.
//		initRotateElement(TOP).andThen(addRotateElement(BOTTOM)).andThen(addRotateElement(LEFT)).andThen(addRotateElement(TOP)).apply(RIGHT);
		addRotateElement(BOTTOM).andThen(addRotateElement(LEFT)).andThen(addRotateElement(TOP)).andThen(addRotateElement(RIGHT)).apply(RIGHT);
		initSubindexes(rotateMap);
	}
}
