package com.tuenti.competition2011.challenge12;


public class DestinationDistance {
		
		@Override
		public boolean equals(Object obj) {
			boolean areEquals = false;
			if (obj instanceof DestinationDistance) {
				DestinationDistance myObj = (DestinationDistance)obj;
				areEquals = this.destination.equals(myObj.destination) && this.distance.equals(myObj.distance);
			}
			return areEquals;
		}

		@Override
		public String toString() {
			return destination + "-" + distance;
		}
		
		public DestinationDistance (Integer destination, Integer distance) {
			this.destination = destination;
			this.distance = distance;
		}
		
		private Integer destination;
		
		private Integer distance;

		public Integer getDestination() {
			return destination;
		}
		public void setDestination(Integer destination) {
			this.destination = destination;
		}
		public Integer getDistance() {
			return distance;
		}
		public void setDistance(Integer distance) {
			this.distance = distance;
		}
		
		
	};