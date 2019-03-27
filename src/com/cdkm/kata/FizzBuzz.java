package com.cdkm.kata;

import java.util.logging.Logger;

public class FizzBuzz {

	private static final Logger log = Logger.getLogger(KataMiroir.class.getName());
	
	public static void main (String [] arg) {
		for(int i=1; i <=100 ; i++) {
			String resultat = fizzBuzz(i);
			//log.info(i+" =>"+resultat);
			System.out.println(i+" =>"+resultat);
		}
	}

	private static String fizzBuzz(int i) {
		if(i%3==0 && i%5==0) {
			return "FizzBuzz";
		}
		else if(i%5==0) {
			return "Buzz";
		}
		else if(i%3==0) {
			return "Fizz";
		}else {			
			return i+"";
		}
	}
	
}
