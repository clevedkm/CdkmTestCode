package com.cdkm.kata;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

public class KataMiroir {
	
	
	private static final Logger log = Logger.getLogger(KataMiroir.class.getName());
	private static Scanner scan;
	private static Scanner scan1;

	private static void visualiserMot(String chaine) {
		//on divise pas 2 la chaine pour trouver le milieu
		if(!chaine.isEmpty()) {	
			
			boolean ispair = isChaineNbreCaracterePaire(chaine);
			if(ispair) {
				System.out.println("la chaine est pair...........");
			}else {
				System.out.println("la chaine est impair...........");
			}
			
			boolean isMiroir = isMiroirVersion1(chaine);
			if(isMiroir) {
				System.out.println("--------la chaine est miroir---------");
			}else {
				System.out.println("--------la chaine n'est pas miroir-------");
				afficherElementIntruDansLaChaine(chaine);
			}
			//verifie si miroir et afficher intru
			isMiroirEtAfficherIntru(chaine);
			//verifie si miroir le texte et son reverse
			isMiroirSurTexteIdentiqueAvecSonInverse(chaine);
			
		}else {
			log.info("Le texte est vide");
		}
		
	}

	/**
	 * affiche les intru qui empeche le mot d'etre miroire
	 * @param chaine
	 */
	private static void afficherElementIntruDansLaChaine(String chaine) {
		String chaineReverse = new StringBuilder(chaine).reverse().toString();
		String [] tabIntru = new String[chaine.length()];
		int j = 0;
		for (int i = 0 ; i < chaine.length(); i++) {			
			if(chaine.charAt(i)!= chaineReverse.charAt(i)) {
				//les intrut de la chaine saisie sont
				String intru = chaine.charAt(i)+"-"+chaineReverse.charAt(i);
				tabIntru[j] = intru;
				j++;
			}
		}
		afficherContenuTableau(tabIntru);
	}


	private static boolean isChaineNbreCaracterePaire(String chaine) {
		if(chaine.length()%2==0)  
			return true;
		else
			return false; 
	}
		

	private static void isMiroirEtAfficherIntru(String chaine) {
		String chaineReverse = new StringBuilder(chaine).reverse().toString();
		String [] tabIntru = new String[chaine.length()];
		int j = 0;
		for (int i = 0 ; i < chaine.length(); i++) {			
			if(chaine.charAt(i)!= chaineReverse.charAt(i)) {
				System.out.println("La texte n'est pas miroir");
				//les intrut de la chaine saisie sont				
				String intru = chaine.charAt(i)+"-"+chaineReverse.charAt(i);
				tabIntru[j] = intru;
				j++;
			}
		}
		afficherContenuTableau(tabIntru);
	}

	private static void afficherContenuTableau(String[] tabIntru) {
		for(int i=0; i< tabIntru.length; i++) {
			if(tabIntru[i] != null) {				
				System.out.println("les intrus sont: "+ tabIntru[i]);
			}
		}
	}


	private static void isMiroirSurTexteIdentiqueAvecSonInverse(String chaine) {
		String chaineReverse = new StringBuilder(chaine).reverse().toString();
		if(chaine.equalsIgnoreCase(chaineReverse)) {
			System.out.println("La texte saisie Miroir");
		}
	}
	
	/**
	 * cette Methode verifie si un texte est miroir avec un algo de comparaison 
	 * en divisant le mot en deux	 
	 * @param chaine
	 * @param chaine1
	 */
	private static boolean isMiroirVersion1(String chaine) {
		//verifier que le code est bien miroir
		int i = 0;
		int j=chaine.length()-1;
		char[] tab = chaine.toCharArray();
		boolean isMiroir = true;
		while(i<= chaine.length()/2) {
			if(tab[i]!=tab[j]) {
				log.info("Le mot n'est pas Miroir: " + chaine);
				return false;
			}
		i++;
		j--;
		}
		log.info("Le mot est Miroir: " + chaine);
		return isMiroir;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Kata Miroir");
		scan = new Scanner(System.in);
		System.out.println("Combien de test voulez vous  faire ? Saisir un nombre < 5");
		int nbre = scan.nextInt();
		if(nbre < 1 || nbre > 5) {
			System.out.println("Le nombre saisie doit  être compris entre 1 et 5");
			nbre = scan.nextInt();
		}
		for(int i= 1 ; i<=nbre; i++) {
			System.out.println("saisir un mot sur le test: "+ i +"/"+ nbre);
			scan1 = new Scanner(System.in);
			String chaine = scan1.nextLine();
			visualiserMot(chaine);
		}
		
		//lire un fichier et dire s'il contient un mot miroir
		try {			
			Scanner scan2 = new Scanner(System.in);
			log.info("Saisir la source du fichier..... exemple D:\\Usersdata\\cleve.kengue-mabial\\Documents\\Doc Memoire\toto.txt ");
			String fileName = scan2.nextLine();
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				//process the line
				System.out.println(line);
				String [] tab = line.split(" ");
				for(int i = 0 ; i<tab.length ; i++) {
					isMiroirVersion1(tab[i]);
				}
			}
			fr.close();
		}catch (Exception e) {
			e.getMessage();
		}
		
	}

	

}
