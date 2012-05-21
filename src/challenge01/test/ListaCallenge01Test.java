package challenge01.test;

import challenge01.ListaChallenge01;
import junit.framework.TestCase;

public class ListaCallenge01Test extends TestCase {

	public void testEmptyList() throws Exception{
		ListaChallenge01 lista = null;
		String strInput;
		strInput = "";
		lista = new ListaChallenge01(strInput);
		assertTrue(lista.sumaElementos()==0);
	}
	public void testOneElementList() throws Exception{
		ListaChallenge01 lista = null;
		String strInput;
		strInput = "1";
		lista = new ListaChallenge01(strInput);
		assertTrue(lista.sumaElementos()==1);
	}
	
	public void testNormalList() throws Exception{
		ListaChallenge01 lista = null;
		String strInput;
		strInput = "1 2 4";
		lista = new ListaChallenge01(strInput);
		assertTrue(lista.sumaElementos()==7);
	}
	
	public void testTwoLis() throws Exception{
		ListaChallenge01 lista = null;
		String strInput;
		strInput = "1 2  4";
		lista = new ListaChallenge01(strInput);
		assertTrue(lista.sumaElementos()==7);
	}
	
	public void testNegativeList() throws Exception{
		ListaChallenge01 lista = null;
		String strInput;
		strInput = "1 -2 -4";
		lista = new ListaChallenge01(strInput);
		assertTrue(lista.sumaElementos()==-5);
	}
}
