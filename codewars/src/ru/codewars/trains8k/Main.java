package ru.codewars.trains8k;

import java.util.Random;

public class Main {
	public static final Random rnd = new Random();

	public static void main(String[] args) {
		for (int i = 100; i - 1 > 0; --i) {
			long n = rnd.nextInt(200);
			long m = rnd.nextInt(200);
			System.out.println(n + " " + m + " : " 
					+ WeirdPrimeGen.grcodi(n, m));
		}
		System.out.println((new BrokenSequence().findMissingNumber("")));
	}

}
