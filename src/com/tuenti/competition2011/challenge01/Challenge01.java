package com.tuenti.competition2011.challenge01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Challenge01 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null && s.length() != 0) {
			try {
				System.out.println(new ListaChallenge01(s).sumaElementos());
			} catch (NumberFormatException ex){
				System.out.println("Solo se adminten numeros (positivos o negativos)");
			} catch (Exception ex){
				System.out.println("Error no controlado");
			}
		}
	}
}
