package com.tuenti.competition2011.challenge12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;


public class Challenge12Test extends TestCase{


	public void testStartGateConstructor() throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("input.txt");
		InputStreamReader in = new InputStreamReader(inputStream);
		BufferedReader bf = new BufferedReader(in);
		bf.readLine();
		StartGate startGate = new StartGate(bf.readLine());
		assertEquals(startGate.getEarthIndex(), new Integer(0));
		assertEquals(startGate.getAtlantisIndex(), new Integer(2));
		/* valido si se han cargado bien las distancias. */
		DestinationDistance destinationDistance = new DestinationDistance(Integer.valueOf(1), Integer.valueOf(1));
		List<DestinationDistance> distancias = Arrays.asList(new DestinationDistance[]{destinationDistance});
		assertEquals(startGate.getTravelsTimes().get(0), distancias);
		DestinationDistance destinationDistance1 = new DestinationDistance(Integer.valueOf(0), Integer.valueOf(-2));
		DestinationDistance destinationDistance2 = new DestinationDistance(Integer.valueOf(2), Integer.valueOf(1));
		distancias = Arrays.asList(new DestinationDistance[]{destinationDistance1, destinationDistance2});
		assertEquals(startGate.getTravelsTimes().get(1), distancias);

		distancias = new ArrayList<DestinationDistance>();
		assertEquals(startGate.getTravelsTimes().get(2), distancias);
		
		bf.close();
		
	}

	public void testCalculaCamino () throws IOException{
		InputStream inputStream = this.getClass().getResourceAsStream("input.txt");
		InputStreamReader in = new InputStreamReader(inputStream);
		BufferedReader bf = new BufferedReader(in);
		//bf.readLine();
		StartGate startGate = new StartGate(bf.readLine());
		System.out.println(startGate);
		System.out.println(startGate.calculaRutaAtlantis());
	}
	
	
}
