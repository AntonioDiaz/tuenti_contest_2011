package com.tuenti.competition2011.challenge09;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 09 del Tuenti Programming Challenge 2011.
 * @author adiaz
Instant 0 - All lights are off
Instant 1 - Light #0 turns on
Instant 2 - Light #0 turns off and light #1 turns on
Instant 3 - Light #1 turns off and lights #0 and #2 turn on
Instant 4 - Lights #0 and #2 turn off and lights #1 and #3 turn on
Instant 5 - Lights #1 and #3 turn off and lights #0, #2 and #4 turn on
...
 *
 *
 */
public class Challenge09 {
	
	public static final int MAX_LAMPS = 64;
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * Obtiene el numero de bombillas encendidas en un momento dado.
	 * @param lamps
	 * @param time
	 * @return
	 */
	public static List<Integer> checkLampsOn(int lampsNumber, int time){
		List<Integer> lamps = new ArrayList<Integer>();
		time--;
		int timeSimple = time % MAX_LAMPS;
		boolean hayCiclo = time >= MAX_LAMPS;
		for (int i = 0; i <= (hayCiclo?MAX_LAMPS:timeSimple); i++) {
			if (time%2 == i%2 && (i<lampsNumber)) {
				lamps.add(i);
			}
		} 
		return lamps;
	}
	
	

}
