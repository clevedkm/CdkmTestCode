package com.cdkm.kata;

import java.util.logging.Logger;

/**
 * 
 * @author clevedkm
 *
 *FizzBuzz
Vous devez construire une fonction fizzBuzz qui transforme un entier en chaine de carractères selon les règles suivantes.

Règles
Si le nombre est divisible par 3, on le remplace par Fizz, Si le nombre est divisible par 5, on le remplace par Buzz, Si le nombre est divisible par 3 et 5, alors on le remplace par FizzBuzz Dans tous les autres cas, on retourne le nombre sous forme de chaine de carractères.

Examples
1 => 1
2 => 2
3 => Fizz
4 => 4
5 => Buzz
6 => Fizz
15 => FizzBuzz
Étape 2
Construire une fonction compute qui affiche la suite de correspondance de 1 à 100
 
 */


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
