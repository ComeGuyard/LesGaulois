package personnages;

import  java.util.Random;



public class Druide {

private String nom;

private int effetPotionMin;

private int effetPotionMax;

public int forcePotion;

public Druide(String nom, int effetPotionMin,int effetPotionMax) {
	this.nom = nom;
	this.effetPotionMin = effetPotionMin;
	this.effetPotionMax = effetPotionMax;
	parler("Bonjour, je suis le druide " + nom + " et ma potion donne une force allant de " + effetPotionMin + " � " + effetPotionMax);
}


public String getNom() {
	return nom;
}


public void parler(String texte) {
	System.out.println(prendreParole() + "� " + texte + "�");
}

private String prendreParole() {
	return "Le druide " + nom + " : ";
}

public void preparerPotion() {
	Random rand = new Random();
	int force = 0;
	force = rand.nextInt(effetPotionMax-effetPotionMin) + effetPotionMin;
	
	if (force>7) {
		parler("J'ai pr�par� une super potion");
	}
	else {
		parler("Je n'ai pas r�ussi a trouver tout les ingr�dients, ma potion est seulement de force " + force);
	}
	forcePotion = force;	
}


public void booster(Gaulois gaulois) {
	if (gaulois.getNom() == "Ob�lix") {
		parler("Non, Ob�lix !... Tu n�auras pas de potion magique !");
	}
	else {
		gaulois.boirePotion(forcePotion);  
	}
}

public static void main(String[] args) {
	
	
	
	Druide panoramix = new Druide("Panoramix",5,10);
	
	panoramix.preparerPotion();
}
}

