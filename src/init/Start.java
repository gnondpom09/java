package init;



import java.sql.Date;
import java.util.List;

import dao.JoueursDAO;
import daoModel.JoueursModel;
//ajout commentaire test
//import puissance4.Plateforme;
//import puissance4.Plateforme.Game;
import puissance4.Plateforme;

public class Start {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    Plateforme f = new Plateforme();
    f.setVisible(true);

	 JoueursDAO joueur = new JoueursDAO();
	
     
	joueur.create(new JoueursModel("Laurent", "BOUTELLA", "H", new Date(2017, 4, 25), "????", "L@havp1.ldnr", "***"));
	
	JoueursDAO j = new JoueursDAO();
	
	//JoueursModel buscar = j.read("2");
	/*
	   List<LibroDTO> buscar = l.readAll();
       for(LibroDTO re : l.readAll() ){
           System.out.println(re.getIsbn()+" "+re.getNombre()+" "+re.getAutor());
       } */
	
	
	List<JoueursModel> buscar  = j.readAll();
	
    for(JoueursModel showJoueus : j.readAll() ){
        System.out.println(showJoueus.getIdjoueurs()+" "+ showJoueus.getNom()+" "+  showJoueus.getNom()+" "+showJoueus.getPrenom()+" "+
        					showJoueus.getSexe()+" "+showJoueus.getBirthday()+" "+showJoueus.getPseudo()+" "+
        					showJoueus.getEmail()+" "+showJoueus.getPassword());
    } 
   
    
  }

}
