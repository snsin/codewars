package ru.codewars.trains8k;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static final Random rnd = new Random();
	public static final Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		long[] a = WeirdPrimeGen.an(1000);
		long[] g = WeirdPrimeGen.gn(1000);
		for (int i = 1; i < a.length; ++i) {
			System.out.println(i + "\t" + a[i] + "\t" + g[i] + "\t" 
					+ a[i]%3);
		}
	}
}
