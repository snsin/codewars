package ru.codewars.trains8k;

import java.util.Arrays;

public class WeirdPrimeGen {
	private static long[] an = new long[] {7};
	private static long[] gn = new long[] {1};
	private static long[] pn = new long[] {5};
	private static long[] keyValues = new long[] {7, 8};
	
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
    
    public static void generateKeys(int n) {
    	if (n > keyValues.length) {
    		int updLength = n + n % 2;
    		int current = keyValues.length;
    		keyValues = Arrays.copyOf(keyValues, updLength);
    		boolean isNotDone = true;
    		while  (isNotDone){
    			keyValues[current] = keyValues[current - 1] + keyValues[current - 2];
    			keyValues[current + 1] = keyValues[current] + 3;
    			current += 2;
    			isNotDone = (current < updLength) && (current < Integer.MAX_VALUE);
    		}
    	}
    }
    
    public static long[] getKeyVals() {
    	return keyValues;
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
    	an(n);
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
    	gn(n);
    	int start = 0;
    	int counter = pn.length;
    	long[] tempPn = Arrays.copyOf(pn, (int) n);
    	if (n > pn.length) {
    		Arrays.fill(tempPn, pn.length, tempPn.length, Long.MAX_VALUE);
	    	do {
		    	for (int i = start; i < gn.length; ++i){
		    		if (gn[i] != 1) {
		    			if (Arrays.binarySearch(tempPn, gn[i]) < 0){
		    				tempPn[counter++] = gn[i];
		    				Arrays.sort(tempPn);
		    				if (counter == tempPn.length) {
		    					break;
		    				} 
		    			}
		    		}
		    	}
		    	start = gn.length;
		    	gn(2 * start);
	    	} while (counter < tempPn.length);
	    	pn = tempPn;
    	}
    	return tempPn;
    }
    
    public static long[] anOver(long n) {
    	long[] result = new long[(int) n];
    	Arrays.fill(result, 3L);
    	return result;
    }
    
    public static long maxPn(long n) {
    	pn(n+1);
    	return pn[(int)n];


    }
    public static int anOverAverage(long n) {
    	return 3;
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
