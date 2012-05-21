package com.tuenti.competition2011.challenge12;

import java.util.Comparator;

public class ComparaDistancias<E extends DestinationDistance> implements Comparator<DestinationDistance> {

	public int compare(DestinationDistance o1, DestinationDistance o2) {
		return o1.getDistance().compareTo(o2.getDistance());
	}

}
