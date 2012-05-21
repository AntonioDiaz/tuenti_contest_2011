package challenge01;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto que contiene una lista de numeros.
 * @author adiaz
 *
 */
public class ListaChallenge01 {

	private List<Integer> listaElementos;
	/**
	 * Contruye una lista 
	 * @param lista
	 */
	public ListaChallenge01(String lista) throws Exception{
		listaElementos = new ArrayList<Integer>();
		if (!"".equals(lista)){
			String[] split = lista.split("( )+");
			for (String string : split) {
				listaElementos.add(Integer.valueOf(string));
			}
		}
	}
	
	/**
	 * Calcula la suma de los elementos de la lista.
	 * @return
	 */
	public Integer sumaElementos(){
		Integer suma = new Integer(0);
		for (Integer myInteger : this.listaElementos) {
			suma += myInteger;
		}
		return suma;
	}

	public List<Integer> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(List<Integer> listaElementos) {
		this.listaElementos = listaElementos;
	}
	
}
