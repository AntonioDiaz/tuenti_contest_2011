package com.tuenti.competition2011.challenge03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge03 {

	/**
	 * Ejecuta la tercera prueba del Tuenti Challenge:
	 * https://contest.tuenti.net/resources/2011/Question_3.html
	 * What is the sum of all emirps up to X?
	 * 100 --> 418
	 * 200 --> 1489
	 * 
	 * @param args
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null && s.length() != 0)
			try {
				int myNum = Integer.valueOf(s);
				System.out.println(Challenge03.sumaSomirp(myNum));
			} catch (NumberFormatException ex){
				System.out.println("Solo se adminten numeros (positivos o negativos)");
			} catch (Exception ex){
				System.out.println("Error no controlado");
			}
	}

	public static int sumaSomirp(int limiteOriginal) {
		int limite = Challenge03.revertir(limiteOriginal - (limiteOriginal%10 + 1));
		List<Integer> listaPrimos = new ArrayList<Integer>();
		Set<Integer> setPrimos = new HashSet<Integer>();
		int suma = 0;
		int tope = (int) Math.floor(Math.sqrt(limite)) + 1;
		List<Long> compuestos = new ArrayList<Long>();
		int pos = 0;
		for (int i = 2; i <= tope; i++) {
			if (!compuestos.contains(Long.valueOf(i))) {
				for (int j = i; j <= limite / i + 1; j++) {
					compuestos.add(Long.valueOf(i * j));
				}
			}
		}
		for (pos = 2; pos <= limite; pos++) {
			if (!compuestos.contains(Long.valueOf(pos))) {
				if (pos<=limiteOriginal){
					listaPrimos.add(pos);
				}
				setPrimos.add(pos);
			}
		}
		for (int miPrimo : listaPrimos) {
			int reverso = Challenge03.revertir(miPrimo);
			if (miPrimo != reverso && setPrimos.contains(reverso)){
				suma += miPrimo;
			}
			
		}
		return suma;
	}
	
	/**
	 * Recibe un numero positivo y lo da la vuelta, p.e. 12 --> 21
	 * @param n
	 * @return
	 */
	public static int revertir (int n){
		int revertido = 0; 
		int potenciaDiez = 10;
		while (n>0) {
			revertido = revertido*potenciaDiez + (n%potenciaDiez);
			n=n/potenciaDiez;
		}
		return revertido;
	}
}
