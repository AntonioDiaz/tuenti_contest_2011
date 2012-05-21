package com.tuenti.competition2011.challenge14;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class BmpHeader {

	public BmpHeader (String nomFichero) throws IOException {
		InputStream inputStream =  this.getClass().getResourceAsStream("trabaja.bmp");
		/* se leen los primeros 14 bytes q corresponden con la cabecera. */
		byte input[] = new byte[14];
		inputStream.read(input, 0, 14);
		signature = new char[2];
		signature[0] = (char)input[0];
		signature[1] = (char)input[1];
		fileSize = UtilsBmp.leeNumber(input, 2, 4);
		reserved1 = new char[2];
		reserved1[0] = (char)input[10];
		reserved1[1] = (char)input[11];
		reserved2 = new char[2];
		reserved2[0] = (char)input[12];
		reserved2[1] = (char)input[13];
		pixelOffset = UtilsBmp.leeNumber(input, 10, 4);
		inputStream.close();
	}

	private char[] signature;
	private int fileSize;
	private char[] reserved1;
	private char[] reserved2;
	private int pixelOffset;
	
	@Override
	public String toString() {
		return "BmpHeader [fileSize=" + fileSize 
				+ ", pixelOffset=" + pixelOffset 
				//+ ", reserved1=" + Arrays.toString(reserved1) 
				//+ ", reserved2=" + Arrays.toString(reserved2) 
				+ ", signature=" + Arrays.toString(signature) + "]";
	}

	public char[] getSignature() {
		return signature;
	}
	
	public void setSignature(char[] signature) {
		this.signature = signature;
	}
	
	public int getFileSize() {
		return fileSize;
	}
	
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	
	public char[] getReserved1() {
		return reserved1;
	}
	
	public void setReserved1(char[] reserved1) {
		this.reserved1 = reserved1;
	}
	
	public char[] getReserved2() {
		return reserved2;
	}
	
	public void setReserved2(char[] reserved2) {
		this.reserved2 = reserved2;
	}
	
	public int getPixelOffset() {
		return pixelOffset;
	}
	
	public void setPixelOffset(int pixelOffset) {
		this.pixelOffset = pixelOffset;
	}
}
