package com.tuenti.competition2011.challenge04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Scheduler {

	List<Integer> listaTareas = null;
	Map<Integer, List<Integer>> mapaDependencias = null;
	
	/**
	 * Contruye el scheduler para obtener los tiempos que tardan en ejecutarse las tareas.
	 * @param fichero
	 * @throws IOException 
	 */
	public Scheduler (File fichero) throws IOException{
		listaTareas = new ArrayList<Integer>();
	    FileReader fileReader = new FileReader(fichero);
	    BufferedReader bufferReader = new BufferedReader(fileReader);
	    String linea = "";
	    bufferReader.readLine();
	    linea = bufferReader.readLine();
	    /* lee el numero de tareas */
	    listaTareas = new ArrayList<Integer>(Integer.parseInt(linea));
	    bufferReader.readLine();
	    bufferReader.readLine();
	    while (!(linea = bufferReader.readLine()).equals("")){
	    	String[] formateada = linea.split(",");
	    	listaTareas.add(Integer.parseInt(formateada[1]));
	    }
	    /* lee las dependencias. */
	    mapaDependencias = new HashMap<Integer, List<Integer>>();
	    bufferReader.readLine();
	    while ((linea = bufferReader.readLine())!=null){
	    	String[] formateada = linea.split(",");
	    	List<Integer> listaDependencias = new ArrayList<Integer>();
	    	Integer clave = new Integer (formateada[0]);
	    	for (int i = 1; i < formateada.length; i++) {
				listaDependencias.add (new Integer(formateada[i]));
			}
	    	mapaDependencias.put(clave, listaDependencias);
	    }
	    bufferReader.close();
	}
	
	/**
	 * Calcula los tiempos que tardan en ejecutarse las tareas.
	 * @param tareasStr lista de tareas separadas por comas.
	 * @return
	 */
	public Map<Integer, Integer> calculaTiempos(String tareasStr){
		Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
		String[] tareas = tareasStr.split(",");
		for (String miTarea : tareas) {
			Integer tarea = new Integer(miTarea);
			tiempos.put(tarea, new Integer(this.durationTask(tarea)));
		}
		return tiempos;
	}

	class Nodo{
		private int id;
		private int padre;
		public Nodo(int id, int padre){
			this.id = id;
			this.padre = padre;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPadre() {
			return padre;
		}
		public void setPadre(int padre) {
			this.padre = padre;
		}
		public String toString(){
			return id + "-" + padre;
		}
		
		
	}
	
	/**
	 * Calcula el tiempo que tarda una tarea concreta. Se tendra que usar recursividad para su resolución.
	 * @param myTask
	 * @return
	 */
	private int durationTask(int myTask) {
		int mayor = 0;
		/* Obtenemos el mayor periodo de todas las tareas dependientes. */
		if (this.mapaDependencias.get(myTask)!=null) {
			for (int tareaDependiente: this.mapaDependencias.get(myTask)) {
				int miDuracion = this.durationTask(tareaDependiente);
				if (miDuracion>mayor) {
					mayor = miDuracion;
				}
			}
		}
		return mayor + this.getListaTareas().get(myTask);
	}

	/**
	 * 
	 * @param myTask
	 * @return
	 */
	public int durationTaskSinRecursion(Integer myTask) {
		Integer myTaskOrigien = myTask;
		Stack<Nodo> pila = new Stack<Nodo>();
		//List<Integer> dependencias = this.mapaDependencias.get(myTask);
		Set<Integer> visitados = new HashSet<Integer>();
		Map<Integer, Integer> pesos = new HashMap<Integer, Integer>();
		if (this.mapaDependencias.get(myTask)!=null) {
			while (this.mapaDependencias.get(myTask)!=null) {
				/* Guardo todos los hijos en la pila. */
				for (Integer integer : this.mapaDependencias.get(myTask)) {
					pila.push(new Nodo(integer, myTask));
				}
				/* Obtengo todos los hijos que no tienen hijos. */
				Nodo miNodo = pila.peek();
				while (this.mapaDependencias.get(miNodo.getId())==null) {
					if (!visitados.contains(miNodo.getId())) {
						pila.pop();
						Integer peso = this.getListaTareas().get(miNodo.getId());
						System.out.println("el peso de " + miNodo.getPadre() + "->" + peso);
						/* si procede hay que actualizar el peso del padre. */
						if (!pesos.containsKey(miNodo.getPadre())){
							pesos.put(miNodo.getPadre(), peso);
						} else {
							Integer pesoActual = pesos.get(miNodo.getPadre());
							if (pesoActual.compareTo(peso)<0){
								pesos.put(miNodo.getPadre(), peso);
							}
						}
						miNodo = pila.peek();
						/* si el peso es mayor que el del hermano lo sustituimos.*/						
					}
				}
				myTask = null;
				if (!visitados.contains(miNodo.getId())){
					myTask = miNodo.getId();
				}
				visitados.add(myTask);
			}
		}
		return pesos.get(myTaskOrigien);
	}
	
	
	public List<Integer> getListaTareas() {
		return listaTareas;
	}

	public Map<Integer, List<Integer>> getMapaDependencias() {
		return mapaDependencias;
	}

	
}
