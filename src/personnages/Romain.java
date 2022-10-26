package personnages;


public class Romain {
	
private String nom;

private int force;

public Romain(String nom, int force) {
	
	assert force >= 0 ;
	
	this.nom = nom;
	this.force = force;
}

public String getNom() {
	return nom;
}

public void parler(String texte) {
	System.out.println(prendreParole() + "« " + texte + "»");
}

private String prendreParole() {
	return "Le romain " + nom + " : ";
}

public void recevoirCoup(int forceCoup) {
	
	assert this.force >= 0 ;
	int force_avant_coup = this.force ;
	
	force -= forceCoup;
	if (force > 0) {
	parler("Aïe");
	} else {
	parler("J'abandonne...");
	
	assert this.force < force_avant_coup ;
	}
}
	
public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		
		minus.parler("Je suis un romain");
		
		minus.recevoirCoup(3);
		minus.recevoirCoup(3);
		
}
}