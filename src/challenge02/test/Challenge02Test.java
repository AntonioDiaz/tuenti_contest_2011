package challenge02.test;

import challenge02.Challenge02;
import junit.framework.TestCase;

/**
 * Clase de pruebas del ejercicio 2.
 * @author adiaz
 *
 */
public class Challenge02Test  extends TestCase {

	public void testLinea1(){
		assertEquals (Challenge02.calculaTuenti("^= 1 2$"), 3);
	}
	
	public void testLinea2(){
		assertEquals (Challenge02.calculaTuenti("^# 2 2$"), 4);
	}
	
	public void testLinea3(){
		assertEquals (Challenge02.calculaTuenti("^@ 3 1$"), 2);
	}
	
	public void testOperacion01() {
		assertEquals (Challenge02.calculaTuenti("^# ^= 10 ^# 252 244$$ 196$"), 12053608);
	}
	
}
