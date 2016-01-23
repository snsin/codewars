package ru.codewars.trains8k;

public class WeirdPrimeGen {
    public static long countOnes(long n) {
    	return 0;
        // your code
    }
    public static long maxPn(long n) {
    	return 0;
        // your code
    }
    public static int anOverAverage(long n) {
    	return 0;
        // your code
    }
    
    public static long grcodi(long n, long m){
    	return gcd(n, m);
    }
    
    private static long gcd(long n, long m) {
    	long d = 1;

    	while ( n >= 0 || m >= 0) {
    		if ((m % 2 == 0) && (n % 2 == 0)) {
    			d *= 2;
    			m /= 2;
    			n /= 2;
    		} else if ((m % 2 == 0) && (n % 2 != 0)) {
    			m /= 2;
    		} else if ((m % 2 != 0) && (n % 2 == 0)) {
    			n /= 2;
    		} else if ((m % 2 != 0) && (n % 2 != 0) && (m >= n)) {
    			m -= n;
    		} else if ((m % 2 != 0) && (n % 2 != 0) && (m < n)) {
    			n -= m;
    		}
    	}
    	return d;
    }

}
