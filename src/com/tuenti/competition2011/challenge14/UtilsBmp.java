package com.tuenti.competition2011.challenge14;

import java.math.BigInteger;

public class UtilsBmp {

	/**
	 * Obtiene los byts q se indican desde el offset y hasta size. 
	 * Se tiene en cuenta que la representación es little endian.
	 * @param input
	 * @param offset
	 * @param size
	 * @return
	 */
	public static int leeNumber(byte[] input, int offset, int size){
		byte[] temp = new byte[size];
		int desde = (offset+size-1);
		for (int i=desde; i>=offset ; i-- ) {
			temp[desde-i] = input[i];
		}
		return (new BigInteger(temp)).intValue();
	}
}
