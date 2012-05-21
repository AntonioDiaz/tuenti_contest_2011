package com.tuenti.competition2011.challenge14;

import java.io.IOException;
import java.io.InputStream;

/**
 * Estructura de un bmp.
 * @author adiaz
 *
 */
public class BmpStructure {

	public BmpStructure(String fileName) throws IOException{
		bmpHeader = new BmpHeader(fileName);
		bmpBitMapHeader = new BmpBitMapHeader(fileName);
		int filas = bmpBitMapHeader.getImageHeight();
		int columnas = bmpBitMapHeader.getImageWidth();
		byte[] miFila;
		InputStream inputStream = this.getClass().getResourceAsStream(fileName);
		pixelArray = new byte[filas][columnas];
		int bytesPerPixel = bmpBitMapHeader.getBitPerPixel()/8;
		int bytesPerColumn = columnas * bytesPerPixel;
		//int padding = bytesPerColumn % 4;
		inputStream.skip(bmpHeader.getPixelOffset());
		for (int i=filas-1; i>=0; i--) {
			miFila = new byte[bytesPerColumn];
			inputStream.read(miFila, 0, bytesPerColumn);
			//inputStream.read(miFila, 0, bytesPerColumn);
			pixelArray[i] = miFila;
		}
		inputStream.close();
	}
	
	
	
	BmpHeader bmpHeader;
	BmpBitMapHeader bmpBitMapHeader;
	byte[][] pixelArray;
	
	public BmpHeader getBmpHeader() {
		return bmpHeader;
	}
	public void setBmpHeader(BmpHeader bmpHeader) {
		this.bmpHeader = bmpHeader;
	}
	public BmpBitMapHeader getBmpBitMapHeader() {
		return bmpBitMapHeader;
	}
	public void setBmpBitMapHeader(BmpBitMapHeader bmpBitMapHeader) {
		this.bmpBitMapHeader = bmpBitMapHeader;
	}
	public byte[][] getPixelArray() {
		return pixelArray;
	}
	public void setPixelArray(byte[][] pixelArray) {
		this.pixelArray = pixelArray;
	}
	
	/**
	 * 
	 * @return
	 */
	public String formatPixel(){
		StringBuilder sb = new StringBuilder();
		int i = this.getBmpBitMapHeader().getImageHeight()-100;
		for (int j = 0; j < pixelArray[i].length/3; j++) {
			int jAux = j*3;
	        int mascara = 0x00FF;
	        String b = Integer.toString((pixelArray[i][jAux]&mascara), 16).toUpperCase();
	        String g = Integer.toString((pixelArray[i][jAux + 1]&mascara), 16).toUpperCase();
	        String r = Integer.toString((pixelArray[i][jAux + 2]&mascara), 16).toUpperCase();
			sb.append("\n ["+ b + g + r +"]");
		}
		sb.append("\n");			
		return sb.toString();
	}
	
	public int calculaRGB (int linea, int rgbSelector){
		int suma = 0;
		for (int j = 0; j < pixelArray[linea].length/3; j++) {
			int jAux = j*3;
	        int mascara = 0x00FF;
	        suma += (pixelArray[linea][jAux + rgbSelector]&mascara);
		}
		return suma + 1;
	}
	
	
	@Override
	public String toString() {
		return "BmpStructure [bmpBitMapHeader=" + bmpBitMapHeader 
			+ ", bmpHeader=" + bmpHeader 
			+ ", \npixelArray=\n" + this.formatPixel() + "]";
	}
	
	public enum EnumColores {
		RED (2),
		GREEN (1),
		BLUE (0);
		
		EnumColores(int myPosition){
			posicion = myPosition;
		}
		
		private int posicion;

		public int getPosicion() {
			return posicion;
		}

		public void setPosicion(int posicion) {
			this.posicion = posicion;
		}
		
	}
	
}
