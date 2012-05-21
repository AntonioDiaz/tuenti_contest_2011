package com.tuenti.competition2011.challenge12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Ejercicio 12 del Tuenti Programming Challenge 2011.
 * 
 * @author adiaz
 *
 */
public class StartGate {
	
	public StartGate(String input){
		String[] split = input.split(" ");
		earthIndex = Integer.valueOf(split[1]);
		travelsTimes = new ArrayList<List<DestinationDistance>>();
		for (int i = 0; i < Integer.parseInt(split[0]); i++) {
			travelsTimes.add(new ArrayList<DestinationDistance>());
		}		
		atlantisIndex = Integer.valueOf(split[2]);
		for (int i = 3; i < split.length; i++) {
			String[] split2 = split[i].split(",");
			Integer planetTo = new Integer(split2[1]);
			Integer distance = new Integer(split2[2]);
			travelsTimes.get(Integer.parseInt(split2[0])).add(new DestinationDistance(planetTo, distance));
		}
		for (int i = 0; i < travelsTimes.size(); i++) {
			Collections.sort(travelsTimes.get(i), new ComparaDistancias<DestinationDistance>());
		}
	}
	
	/**
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public int calculaDistanciaMinimaProfundidad(int origen, int destino){
		return -1;
	}
	
	
	public Integer calculaRutaAtlantis (){
		List<DestinationDistance> listaRecorridos = new ArrayList<DestinationDistance>();
		this.calculaDistanciaMinimaAnchura(this.earthIndex, this.atlantisIndex, listaRecorridos, 0);
		return this.encuentraRuta;
	}
	
	private int encuentraRuta;
	
	/**
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public int calculaDistanciaMinimaAnchura(Integer origen, Integer destino, List<DestinationDistance> listaRecorridos, int sumaParcial) {
		if (origen.equals(destino)) {
			return sumaParcial;
		} else {
			/* Busco todos los destinos de origen. */
			int encontrado = -1;
			for (int i = 0; i < this.getTravelsTimes().get(origen).size(); i++) {
				DestinationDistance nodo = this.getTravelsTimes().get(origen).get(i);
				if (!listaRecorridos.contains(nodo)) {
					listaRecorridos.add(nodo);
					int nuevaSuma = sumaParcial + nodo.getDistance();
					encontrado = calculaDistanciaMinimaAnchura(nodo.getDestination(), destino, listaRecorridos, nuevaSuma);
					if (encontrado!=-1){
						encuentraRuta = encontrado;
					}
				}
			}
			return encontrado;
		}
	}
	
	List<List<DestinationDistance>> travelsTimes;
	
	Integer earthIndex;
	
	Integer atlantisIndex;
	
	public List<List<DestinationDistance>> getTravelsTimes() {
		return travelsTimes;
	}
	public void setTravelsTimes(List<List<DestinationDistance>> travelsTimes) {
		this.travelsTimes = travelsTimes;
	}
	public Integer getEarthIndex() {
		return earthIndex;
	}
	public void setEarthIndex(Integer earthIndex) {
		this.earthIndex = earthIndex;
	}
	public Integer getAtlantisIndex() {
		return atlantisIndex;
	}
	public void setAtlantisIndex(Integer atlantisIndex) {
		this.atlantisIndex = atlantisIndex;
	}
}
