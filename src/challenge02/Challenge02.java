package challenge02;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge02 {

	/**
	 * Ejecuta la segunda prueba del Tuenti Challenge:
	 * https://contest.tuenti.net/resources/2011/Question_2.html
	 * Fichero de entrada (entrada.txt):
	 * ^= 1 2$
	 * ^# 2 2$
	 * ^@ 3 1$
	 * Fichero de salida (salida.txt):
	 * 3
	 * 4
	 * 2
	 * 
	 * @param args
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException {
		/* Lee el fichero entrada.txt. */
		
		
		/* Escribe los resultado en salida.txt. */
		
	}
	
	public static long calculaTuenti(String text) {
		 Pattern compile = Pattern.compile("(\\^=|\\^#|\\^@) \\d* \\d*\\$");
		 Matcher matcher = compile.matcher(text);
		 System.out.println(text);
		 /* Mientras encuentras el una operacion hay que*/
		 String nuevo = null;
		 while (matcher.find()) {
			 Challenge02.aplicaOperador(matcher.group());
			 long op = Challenge02.aplicaOperador(matcher.group());
			 nuevo = matcher.replaceFirst(String.valueOf(op));
			 matcher = compile.matcher(nuevo);
		 }
		 return Long.parseLong(nuevo); 
	}
	
	
	public static long aplicaOperador(String operacionStr){
		long calculo = 0;
		String[] split = operacionStr.split(" ");
		long operando1 = Long.parseLong(split[1]);
		long operando2 = Long.parseLong(split[2].substring(0, split[2].length()-1));
		if (split[0].equals(Operations.ADD.stringOp)){
			calculo = operando1 + operando2;
		} if (split[0].equals(Operations.SUBSTRACT.stringOp)){
			calculo = operando1 - operando2;
		} if (split[0].equals(Operations.MULTIPLICATION.stringOp)){
			calculo = operando1 * operando2;
		}
		return calculo;
	}
	
	public enum Operations {
		ADD ("^="),
		SUBSTRACT ("^@"),
		MULTIPLICATION ("^#");
		private final String stringOp;
		Operations (String tokenOp){
			this.stringOp = tokenOp;
		}
		public String getStringOp() {
			return stringOp;
		}
		
	}	
	
}
