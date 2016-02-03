package ru.codewars.trains8k;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static final Random rnd = new Random();
	public static final Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		for (long a : WeirdPrimeGen.an(1000)){
			System.out.printf("%4d ", a );
		}
		System.out.println();
		for (long a : WeirdPrimeGen.gn(1000)){
			System.out.printf("%4d ", a );
		}
		System.out.println();
		System.out.println();
		System.out.println(WeirdPrimeGen.countOnes(192));
		WeirdPrimeGen.generateKeys(30);
		for (long a : WeirdPrimeGen.getKeyVals()){
				System.out.print(a/3 + " ");
		}

	}
}
