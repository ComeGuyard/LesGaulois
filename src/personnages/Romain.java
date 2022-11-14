package personnages;

import personnages.Equipement;;

public class Romain {

	private String nom;

	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Romain(String nom, int force) {

		assert force >= 0;

		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " " + texte + " ");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//
//		assert this.force >= 0;
//		int force_avant_coup = this.force;
//
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//
//			assert this.force < force_avant_coup;
//		}
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
		 parler("Aïe");
		 } else {
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 }
//		switch (force) {
//		case 0:
//			parler("Aïe");
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0 ;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement arme) {
		if (nbEquipement == 2) {
			System.out.println("Le soldat " + this.nom + " est déjà  bien protégé !");
		} else if (nbEquipement == 1 && equipement[0] == arme) {
			System.out.println("Le soldat " + this.nom + " possède déjà  un.e " + arme + " !");
		} else {
			equipement[0] = arme;
			nbEquipement++;
			System.out.println("Le soldat " + this.nom + " s'équipe d'un.e " + arme + "!");
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

//		for (Equipement equipement : Equipement.values()) {
//			System.out.println(equipement);
//			minus.sEquiper(equipement);
//			minus.sEquiper(equipement);
		// }

	}
}