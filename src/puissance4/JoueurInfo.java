package puissance4;

/**
 * Description: Affichage des infos du joueur (dans une fenetre temporaire)
 * @author Team LDNR
 *
 */
public class JoueurInfo {

	  /************
	   * Attributs
	   ************/
	  private String nom;

	  /***************
	   * Constructeurs
	   ***************/
	  public JoueurInfo() {
	  }
	  public JoueurInfo(String nom) {
	    this.nom = nom;
	  }

	  /***********
	   * Methodes
	   ***********/
	  public String toString() {
	    String str;
	    if (this.nom != null){
	      str = "Description du joueur";
	      str += "Nom : " + this.nom + "\n";
	    }
	    else {
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}