package personnages;

import  java.util.Random;



public class Druide {

private String nom;

private int effetPotionMin;

private int effetPotionMax;



public Druide(String nom, int effetPotionMin,int effetPotionMax) {
	this.nom = nom;
	this.effetPotionMin = effetPotionMin;
	this.effetPotionMax = effetPotionMax;
	parler("Bonjour, je suis le druide " + nom + " et ma potion donne une force allant de " + effetPotionMin + " à " + effetPotionMax);
}


public String getNom() {
	return nom;
}


public void parler(String texte) {
	System.out.println(prendreParole() + "« " + texte + "»");
}

private String prendreParole() {
	return "Le druide " + nom + " : ";
}

public int preparerPotion(int effetPotionMax) {
	Random rand = new Random();
	int force = 0;
	force = rand.nextInt(effetPotionMax-effetPotionMin) + effetPotionMin;
	
	if (force>7) {
		parler("J'ai préparé une super potion");
	}
	else {
		parler("Je n'ai pas réussi a trouver tout les ingrédients, ma potion est seulement de force " + force);
	}
	return force;
	
}

public static void main(String[] args) {
	
	//private int forcePotion;
	
	Druide panoramix = new Druide("Panoramix",5,10);
	
	System.out.println(panoramix.preparerPotion(panoramix.effetPotionMax));
	System.out.println(panoramix.preparerPotion(panoramix.effetPotionMax));
	System.out.println(panoramix.preparerPotion(panoramix.effetPotionMax));
	System.out.println(panoramix.preparerPotion(panoramix.effetPotionMax));
	System.out.println(panoramix.preparerPotion(panoramix.effetPotionMax));
}
}

