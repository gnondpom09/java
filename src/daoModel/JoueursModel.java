package daoModel;

import java.sql.Date;

public class JoueursModel {

	private String idjoueurs;
	private String nom;
	private String prenom;
	private String sexe;
	private java.sql.Date birthday;
	private String pseudo;
	private String email;
	private String password;

	public JoueursModel() {
	}

	public JoueursModel(String idjouers) {
		this.idjoueurs = idjouers;
	}

	public JoueursModel(String idjoueurs, String nom, String prenom, String sexe, Date birthday, String pseudo,String email, String password) {
		this.idjoueurs = idjoueurs;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.birthday = birthday;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}
	public JoueursModel(String nom, String prenom, String sexe, Date birthday, String pseudo,String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.birthday = birthday;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}


	public String getIdjoueurs() {
		return idjoueurs;
	}

	public void setIdjoueurs(String idjoueurs) {
		this.idjoueurs = idjoueurs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
