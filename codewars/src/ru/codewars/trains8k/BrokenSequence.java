package ru.codewars.trains8k;

import java.util.Arrays;

public class BrokenSequence {
	public int findMissingNumber(String sequence) {	
	  int missing = 0;
	  String[] seqArr;
	  if (sequence == null || (seqArr = sequence.split("\\s")).length < 1) {
		  return 1;
	  }
	  char[] a = sequence.toCharArray();
//	  Character ch =a[0];
	  int[] numbers = new int[seqArr.length];
	  for (int i = 0; i < seqArr.length; ++i) {
		  try {
		  	numbers[i] = Integer.parseInt(seqArr[i]);
		  } catch (NumberFormatException e) {
			 return 1; 
		  }
	  }
	  Arrays.sort(numbers);
	  for (int i = 0; (i + 1) < numbers.length; ++i) {
		  if (numbers[i+1] - numbers[i] > 1) {
			  missing = numbers[i] + 1;
			  break;
		  }
	  } 
	  return numbers.length;
	  //return missing > 0 ? missing : 1;
}

}