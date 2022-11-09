package personnages;

import personnages.Equipement;;

public class Romain {

	private String nom;

	private int force;

	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {

		assert force >= 0;

		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {

		assert this.force >= 0;
		int force_avant_coup = this.force;

		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");

			assert this.force < force_avant_coup;
		}
	}
	
	public void sEquiper(Equipement arme) {
		if (nbEquipement == 2) {
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
		}
		else if (nbEquipement == 1 && equipement[0] == arme)  {
			System.out.println("Le soldat " + this.nom + " possède déjà un.e " + arme + " !");
		}
		else {
			equipement[0]=arme ;
			nbEquipement ++ ;
			System.out.println("Le soldat " + this.nom + " s'équipe d'un.e " + arme + "!");
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		
		
		for (Equipement equipement : Equipement.values()) {
			System.out.println(equipement);
			minus.sEquiper(equipement);
			minus.sEquiper(equipement);
		}

	}
}