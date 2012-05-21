package com.tuenti.competition2011.challenge03;

import junit.framework.TestCase;

/**
 * Clase de pruebas del ejercicio 3.
 * @author adiaz
 *
 */
public class Challenge03Test  extends TestCase {

	public void testRevertir(){
		assertEquals (Challenge03.revertir(2), 2);
	}
	
	public void testRevertirFacil(){
		assertEquals (Challenge03.revertir(12), 21);
	}
	
	public void testRevertirDificil(){
		assertEquals (Challenge03.revertir(312), 213);
	}
	
	public void testCien(){
		assertEquals (Challenge03.sumaSomirp(100),418);
	}
	
	public void testDoscientos(){
		assertEquals (Challenge03.sumaSomirp(200), 1489);
	}
	
	
}
