package com.tuenti.competition2011.challenge09;

import java.util.Arrays;

import junit.framework.TestCase;


public class Challenge09Test extends TestCase{


	public void testCheckLamps01(){
		Integer[] encendidas = new Integer[]{0,2};
		assertEquals(Challenge09.checkLampsOn(5, 3), Arrays.asList(encendidas));
	}

	public void testCheckLamps02(){
		Integer[] encendidas = new Integer[]{1,3,5};
		assertEquals(Challenge09.checkLampsOn(8, 6), Arrays.asList(encendidas));
	}
	
	public void testCheckLamps03(){
		Integer[] encendidas = new Integer[]{};
		assertEquals(Challenge09.checkLampsOn(1, 2), Arrays.asList(encendidas));
	}

	public void testCheckLamps04(){
		Integer[] encendidas = new Integer[]{0};
		assertEquals(Challenge09.checkLampsOn(2, 3), Arrays.asList(encendidas));
	}
	
	public void testCheckLamps05(){
		Integer[] encendidas = new Integer[]{1,3,5,7};
		assertEquals(Challenge09.checkLampsOn(8, 8), Arrays.asList(encendidas));
		assertEquals(Challenge09.checkLampsOn(8, 64), Arrays.asList(encendidas));
	}
	
	public void testCheckLamps06(){
		Integer[] encendidas = new Integer[]{0,2,4,6};
		assertEquals(Challenge09.checkLampsOn(8, 7), Arrays.asList(encendidas));
		assertEquals(Challenge09.checkLampsOn(8, 9), Arrays.asList(encendidas));
		assertEquals(Challenge09.checkLampsOn(8, 63), Arrays.asList(encendidas));
		assertEquals(Challenge09.checkLampsOn(8, 65), Arrays.asList(encendidas));
	}

	public void testCheckLamps07(){
		Integer[] encendidas = new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61};
		assertEquals(Challenge09.checkLampsOn(63, 64), Arrays.asList(encendidas));
	}


}
