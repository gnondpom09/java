/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrGrob
 */
public class Connexion {
    
    public static Connexion instance; 
    
   
    private Connection conn;
    
    // the constructor must be private to bloc the instances by creating a Object from class
    private Connexion(){
        try {
        
        Class.forName("com.mysql.jdbc.Driver"); //Mysql drivers
       // "jdbc:mysql://mbret.net:3306/INTtech?useSSL=false","javap1","ldnr"
        conn =  DriverManager.getConnection("jdbc:mysql://mbret.net:3306/javap1?useSSL=false", "javap1", "ldnr");
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
          
         }   catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }//end of constructor
    } 
    
    //this is the methods to get a connection
    public synchronized static Connexion etatDeConnexion(){
             
      if(instance == null){
        instance = new Connexion();
        }
        return instance;
    }
    
    //method for connecting
    public Connection getConn() {
        return conn;
    }
    
    // methods to close the connection
    public void fermerConnexion(){
        instance = null;
    }
    
}
