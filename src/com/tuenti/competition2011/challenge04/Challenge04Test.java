package com.tuenti.competition2011.challenge04;

import java.io.File;
import java.util.Map;

import junit.framework.TestCase;

/**
 * Clase de pruebas del ejercicio 4.
 * @author adiaz
 *
 */
public class Challenge04Test  extends TestCase {
	
	public void testCreaScheduler(){
		String ruta = Challenge04Test.class.getResource("Challenge04Test.class").getPath();
		ruta = ruta.substring(0, ruta.lastIndexOf("/")+1);
		File fich = new File(ruta +  "inSmall.txt");
		try {
			Scheduler scheduler = new Scheduler (fich);
			assertEquals(scheduler.getListaTareas().size(), 7);
			/* task duration. */
			assertEquals(scheduler.getListaTareas().get(0), new Integer(2));
			assertEquals(scheduler.getListaTareas().get(4), new Integer(7));
			assertEquals(scheduler.getListaTareas().get(5), new Integer(9));
			/* task dependencies. */
			assertEquals (scheduler.getMapaDependencias().size(), 3);			
			assertEquals (scheduler.getMapaDependencias().get(0).get(0), new Integer (4));
			assertEquals (scheduler.getMapaDependencias().get(3).get(0), new Integer (0));
			assertEquals (scheduler.getMapaDependencias().get(3).get(1), new Integer (1));
			assertEquals (scheduler.getMapaDependencias().get(3).get(2), new Integer (2));
			assertEquals (scheduler.getMapaDependencias().get(4).get(0), new Integer (5));
			assertEquals (scheduler.getMapaDependencias().get(4).get(1), new Integer (6));
		} catch (Exception e) {
			e.printStackTrace();
			fail("[" + e.getMessage() + "]");
		}
	}
	
	public void testAlgoritmoPeque(){
		String ruta = Challenge04Test.class.getResource("Challenge04Test.class").getPath();
		ruta = ruta.substring(0, ruta.lastIndexOf("/")+1);
		File fich = new File(ruta +  "inSmall.txt");
		try {
			Scheduler scheduler = new Scheduler (fich);
			Map<Integer, Integer> calculaTiempos = scheduler.calculaTiempos("3,1,4");
			assertEquals (calculaTiempos.get(3), Integer.valueOf(27));
			assertEquals (calculaTiempos.get(1), Integer.valueOf(3));
			assertEquals (calculaTiempos.get(4), Integer.valueOf(16));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testAlgoritmoBig(){
		String ruta = Challenge04Test.class.getResource("Challenge04Test.class").getPath();
		ruta = ruta.substring(0, ruta.lastIndexOf("/")+1);
		File fich = new File(ruta +  "inBig.txt");
		try {
			Scheduler scheduler = new Scheduler (fich);
			Map<Integer, Integer> calculaTiempos = scheduler.calculaTiempos("3");
			assertEquals (calculaTiempos.get(3), Integer.valueOf(27));
			assertEquals (calculaTiempos.get(1), Integer.valueOf(3));
			assertEquals (calculaTiempos.get(4), Integer.valueOf(16));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
