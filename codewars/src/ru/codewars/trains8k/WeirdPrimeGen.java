package ru.codewars.trains8k;

import java.util.Arrays;

public class WeirdPrimeGen {
	private static long[] an = new long[] {7};
	private static long[] gn = new long[] {1};
	private static long[] pn;
	
    public static long countOnes(long n) {
    	long[] temp = gn(n).clone();
    	Arrays.sort(temp);
    	for(int i = temp.length - 1; i >= 0; i--) {
    		if (temp[i] == 1) {
    			return i + 1;
    		}
    	}
    	return 0;
    }
    
    public static long[] an(long n){
    	if (n > Integer.MAX_VALUE) {
    		return null;
    	}   	
    	long[] tempAn = Arrays.copyOf(an, (int) n);
    	if (n > an.length) {
	    	for (int i = an.length; i < tempAn.length; ++i){
	    		tempAn[i] = tempAn[i-1] + gcd(i + 1, tempAn[i-1]);
	    	}
	    	an = tempAn;
    	}
    	return tempAn;
    }
    
    public static long[] gn(long n){
    	if (n > Integer.MAX_VALUE){
    		return null;
    	}
    	long[] tempGn = Arrays.copyOf(gn, (int) n);
    	an(gn.length);
    	if (n > gn.length) {
	    	for (int i = gn.length; i < tempGn.length; ++i){
	    		tempGn[i] = an[i] - an[i-1];
	    	}
	    	gn = tempGn;
    	}
    	return tempGn;
    }
    
    public static long[] pn(long n) {
    	if (n > Integer.MAX_VALUE){
    		return null;
    	}
    	long[] tempGn = Arrays.copyOf(pn, (int) n);
    	gn(pn.length);
    	if (n > gn.length) {
	    	for (int i = gn.length; i < tempGn.length; ++i){
	    		tempGn[i] = an[i] - an[i-1];
	    	}
	    	gn = tempGn;
    	}
    	return tempGn;
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
    
    private static long gcd(long nn, long mm) {
    	long d = 1;
    	long n = nn; long m = mm;
    	while ((n > 0) && (m > 0)) {
    		if (((m % 2) == 0) && ((n % 2) == 0)) {
    			d *= 2;
    			m /= 2;
    			n /= 2;
    		} else if (((m % 2) == 0) && ((n % 2) != 0)) {
    			m /= 2;
    		} else if (((m % 2) != 0) && ((n % 2) == 0)) {
    			n /= 2;
    		} else if (((m % 2) != 0) && ((n % 2) != 0) && (m >= n)) {
    			m -= n;
    		} else if (((m % 2) != 0) && ((n % 2) != 0) && (m < n)) {
    			n -= m;
    		}
    	}
    	return m == 0 ? n * d : m * d;
    }

}
