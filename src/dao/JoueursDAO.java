package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Calendar;

import connexion.Connexion;
import daoModel.JoueursModel;
import interfaces.DAOCRUD;

public class JoueursDAO implements DAOCRUD<JoueursModel> {
	//we use the Query as attributes
	private static final String SQL_INSERT ="INSERT INTO joueurs (nom, prenom, sexe, birthday, pseudo, email, password) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE ="DELETE FROM joueurs WHERE idjoueurs =? ";
	private static final String SQL_UPDATE ="UPDATE joueurs SET nom= ?, prenom =?, sexe =?, birthday =?, pseudo=?, email = ?, password =?  WHERE idjoueurs LIKE ? ";
	private static final String SQL_READ ="SELECT * FROM joueurs WHERE idjoueurs =? ";


	private static final String SQL_READALL ="SELECT * FROM joueurs";

	//esto es un singleto LA CONEXION ESTA ESTABLECIDA DEBE CERRARCE NE LOS METODOS
	private static final Connexion conn = Connexion.etatDeConnexion();

	@Override
	public boolean create(JoueursModel j) {
		PreparedStatement ps; 

		try {
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			//ps.setString(1, j.getIdjoueurs());
			ps.setString(1, j.getNom());
			ps.setString(2, j.getPrenom());
			ps.setString(3, j.getSexe());
			ps.setDate(4, j.getBirthday());
			ps.setString(5, j.getPseudo());
			ps.setString(6, j.getEmail());
			ps.setString(7, j.getPassword());

			if(ps.executeUpdate() > 0){
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			conn.fermerConnexion();
		}

		return false; 
	}// end of insert()

	@Override
	public boolean delete(Object key) {
		PreparedStatement ps; 

		try {
			ps = conn.getConn().prepareStatement(SQL_DELETE);
			ps.setString(1, key.toString());

			if(ps.executeUpdate() > 0){
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			conn.fermerConnexion();
		}

		return false;
	}// end of delete()

	@Override
	public boolean update(JoueursModel j) {
		PreparedStatement ps; 

		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setString(1, j.getIdjoueurs());
			ps.setString(2, j.getNom());
			ps.setString(3, j.getPrenom());
			ps.setString(4, j.getSexe());
			ps.setDate(5, j.getBirthday());
			ps.setString(6, j.getPseudo());
			ps.setString(7, j.getEmail());
			ps.setString(8, j.getPassword());

			if(ps.executeUpdate() > 0){
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			conn.fermerConnexion();
		}

		return false;
	}//end of update()

	@Override
	public JoueursModel read(Object key) {
		PreparedStatement ps; 
		ResultSet res; // a variable type res show the select query 
		JoueursModel joueur  = null; // we create a temporary object

		try {
			ps = conn.getConn().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());

			res = ps.executeQuery();

			while(res.next()){
				joueur = new JoueursModel( res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getDate(5),res.getString(6),res.getString(7),res.getString(8)
						);

			}
			return joueur;	

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.fermerConnexion();
		}

		return joueur;
	}//end of read();

	@Override
	public List<JoueursModel> readAll() {
		
		
		PreparedStatement ps; 
		ResultSet res; // a variable type res show the select query 
		ArrayList<JoueursModel> joueurs = new ArrayList();
		try {
			ps = conn.getConn().prepareStatement(SQL_READALL);
			res = ps.executeQuery();

			while(res.next()){
				joueurs.add( new JoueursModel( res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getDate(5),res.getString(6),res.getString(7),res.getString(8) ) );		
			}
			return  joueurs;	

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.fermerConnexion();
		}

		return  joueurs;
	}
}//end of reaAll()
