package com.tuenti.competition2011.challenge14;

import java.io.IOException;
import java.io.InputStream;

public class BmpBitMapHeader {

	public BmpBitMapHeader(String fileName) throws IOException{
		InputStream inputStream =  this.getClass().getResourceAsStream("trabaja.bmp");
		byte[] input = new byte[40];
		inputStream.skip(14);
		inputStream.read(input, 0, 4);
		bitMapHeaderSize = UtilsBmp.leeNumber(input, 0, 4);
		inputStream.read(input, 0, bitMapHeaderSize - 4);
		imageWidth = UtilsBmp.leeNumber(input, 0, 4);
		imageHeight = UtilsBmp.leeNumber(input, 4, 4);
		bitPerPixel = UtilsBmp.leeNumber(input, 10, 2);
		imageSize = UtilsBmp.leeNumber(input, 16, 4);
		inputStream.close();
	}

	private int bitMapHeaderSize;
	private int imageWidth;
	private int imageHeight;
	private int imageSize;
	private int bitPerPixel;
	
	
	public int getBitMapHeaderSize() {
		return bitMapHeaderSize;
	}
	public void setBitMapHeaderSize(int myBitMapHeaderSize) {
		bitMapHeaderSize = myBitMapHeaderSize;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public int getImageSize() {
		return imageSize;
	}
	public void setImageSice(int imageSize) {
		this.imageSize = imageSize;
	}
	public int getBitPerPixel() {
		return bitPerPixel;
	}
	public void setBitPerPixel(int bitPerPixel) {
		this.bitPerPixel = bitPerPixel;
	}
	@Override
	public String toString() {
		return "BmpBitMapHeader [bitMapHeaderSize=" + bitMapHeaderSize 
				+ ", bitPerPixel=" + bitPerPixel 
				+ ", imageHeight=" + imageHeight 
				+ ", imageSize=" + imageSize 
				+ ", imageWidth=" + imageWidth + "]";
	}
	
	
}
