package challenge14;

import java.math.BigInteger;

public class PruebasBigDecimal {

	public static void main(String[] args) {
		BigInteger bd = new BigInteger("-3", 10);
		System.out.println(bd.toString());
		System.out.println(bd.toString(2));
		String str = Integer.toBinaryString(-3);
		System.out.println(str.substring(str.length()-8));
		System.out.println(Integer.toBinaryString(23));
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(new BigInteger("0000101111111110111111101", 2));
		System.out.println(new BigInteger("11111101", 2).intValue());
		byte[] bytes = new byte[]{54, 0};
		PruebasBigDecimal.reverse(bytes);
		System.out.println(bytes);
		for (byte b : bytes) {
			System.out.println(b);
		}
		System.out.println(new BigInteger (bytes));
		System.out.println("Representacion de -30 en complemento a 2: " + Integer.toBinaryString(-30));
		System.out.println("Representacion de -30 en complemento a 2: " + new BigInteger (Integer.toBinaryString(-30), 2));
		System.out.println("Representacion de -30 en complemento a 2: " + new BigInteger ("11100010", 2).toString(10));
		System.out.println("Representacion de -30 en complemento a 2: " + new BigInteger ("11100010", 2).toString(16));
		bytes = new byte[]{-30};
		System.out.println(new BigInteger (bytes));
		System.out.println("Representacion de -30 en complemento a 2: " + new BigInteger (Integer.toBinaryString(-104), 2));
		byte x = -30|1;
		System.out.println("x ->" + x);
		System.out.println("Representacion de -30 en complemento a 2: " + new BigInteger (Integer.toBinaryString(-30), 2));
		System.out.println("Representacion de -30 en complemento a 2: " + new BigInteger (Integer.toBinaryString(-30|1), 2));
		byte bitmask = -30;
		int mascara = 0x00FF;
		System.out.println(bitmask & mascara);
		System.out.println(~bitmask);
	}
	
	
	public static void reverse(byte[] validData) {
		for (int i = 0; i < validData.length / 2; i++) {
			byte temp = validData[i];
			validData[i] = validData[validData.length - i - 1];
			validData[validData.length - i - 1] = temp;
		}
	}
}
