package personnages;

public class Village {
	private String nom;
	
	private Chef chef;
	
	private Gaulois[] villageois ;
	
	public int nbVillageoisMaximum ;
	
	public int nbVillageois = 0 ;
	 
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = Gaulois[nbVillageoisMaximum] ;
	}
	
	public void setChef(Chef chef) {
	this.chef = chef;
	}
	
	public String getNom() {
	return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois ;
		nbVillageois += 1 ;
	}
	
	public Gaulois trouverHabitant(int numgaulois) {
		return villageois[numgaulois] ;
	}
	
	public static void main() {
		
		Village village = new Village("Village des Irréductibles",30) ;
		Gaulois gaulois = village.trouverHabitant(30);
		
	}
	
	}
