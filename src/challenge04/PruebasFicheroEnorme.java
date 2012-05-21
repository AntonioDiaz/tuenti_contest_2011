package challenge04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PruebasFicheroEnorme {

	
	
	public static void main(String[] args) throws IOException {
		//String nombreFichero = "inSmall.txt";	
		String nombreFichero = "inBig.txt";	
		long timeBefore = System.currentTimeMillis();
		InputStream inputStream = PruebasFicheroEnorme.class.getResourceAsStream(nombreFichero);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		bufferReader.readLine();
		int numLineas = Integer.parseInt(bufferReader.readLine());
		bufferReader.readLine();
		bufferReader.readLine();
		int[] tiemposTareas = new int[numLineas];
		for (int i = 0; i < numLineas; i++) {
			String[] tiempos = bufferReader.readLine().split(",");
			tiemposTareas[i] = Integer.parseInt(tiempos[1]);
		}
		bufferReader.readLine();
		bufferReader.readLine();
		
		String linea;
		int contador = 0;
		Map<Integer, String> mapaDependencias = new HashMap<Integer, String>();
		while ((linea = bufferReader.readLine())!=null){
			String[] formateado = linea.split(",");
			mapaDependencias.put(Integer.valueOf(formateado[0]), formateado[1]);
			contador++;
		}
		long timeAfter = System.currentTimeMillis();
		bufferReader.close();
		System.out.println("lineas: " + numLineas);
		System.out.println("dependencias: " + contador);
		System.out.println("El tiempo empleado es: " + (timeAfter - timeBefore));
	}
	
}
