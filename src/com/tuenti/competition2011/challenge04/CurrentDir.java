package com.tuenti.competition2011.challenge04;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class CurrentDir {
	public static void main(String args[]) throws URISyntaxException, IOException {
		String ruta = CurrentDir.class.getResource("CurrentDir.class").getPath();
		System.out.println(ruta);
		ruta = ruta.substring(0, ruta.lastIndexOf("/"));
		System.out.println(ruta);
		System.out.println(System.getProperty("user.dir"));
		File dir1 = new File(".");
		File dir2 = new File("..");
		try {
			System.out.println("Current dir : " + dir1.getCanonicalPath());
			System.out.println("Parent  dir : " + dir2.getCanonicalPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(CurrentDir.class.getCanonicalName());
		System.out.println(CurrentDir.class.getSimpleName());
		InputStream resourceAsStream = CurrentDir.class.getResourceAsStream("inSmall.txt");
		InputStreamReader isr = new InputStreamReader(resourceAsStream);
		BufferedReader bf = new BufferedReader(isr);
		String line = null;
		while ((line = bf.readLine())!=null){
			System.out.println(line);
		}
	}
}