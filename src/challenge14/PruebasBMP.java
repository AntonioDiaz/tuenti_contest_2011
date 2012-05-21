package challenge14;

import java.io.IOException;

public class PruebasBMP {

	public static void main(String[] args) throws IOException {
		String fileName = "trabaja.bmp";
		BmpStructure bmp = new BmpStructure(fileName);
		//System.out.println(bmp);
		System.out.println(bmp.calculaRGB(515, BmpStructure.EnumColores.BLUE.getPosicion()));
		
		System.out.println(bmp.calculaRGB(335, BmpStructure.EnumColores.GREEN.getPosicion()));
		
		System.out.println(bmp.calculaRGB(380, BmpStructure.EnumColores.RED.getPosicion()));
		
		
	}
	
}
