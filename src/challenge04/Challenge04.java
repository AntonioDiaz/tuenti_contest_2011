package challenge04;

import java.io.File;
import java.io.IOException;

import challenge04.test.Challenge04Test;

/**
 * Prueba 04 del Tuenti Challenger 2011: https://contest.tuenti.net/resources/2011/Question_4.html
 * @author adiaz
 *
 */
public class Challenge04 {

	public static final String nombreFichero = "inSmall.txt";
	
	/**
	 * Método estático
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/* Lee el fichero y crea el objeto. */
		String ruta = Challenge04Test.class.getResource("Challenge04Test.class").getPath();
		ruta = ruta.substring(0, ruta.lastIndexOf("/")+1);
		File fich = new File(ruta +  "inSmall.txt");
		Scheduler scheduler = new Scheduler(fich);
		scheduler.durationTaskSinRecursion(3);
		
	}
}
