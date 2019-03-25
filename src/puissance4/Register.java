package puissance4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.JoueursDAO;
import daoModel.JoueursModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JDialog {

	/**
	 * Attributs
	 */
	public Color COLOR_WEB   = Color.decode("#9F95FF"); // violet
	public Color COLOR_HOVER = Color.decode("#B5ABF0"); // violet clair
	public Color COLOR_FIELD = Color.decode("#363742");
	public Color COLOR_WEB2  = Color.decode("#4A4C5B"); // nuance degrade clair
	public Color COLOR_WEB3  = Color.decode("#2E2F38"); // nuance degrade fonce
	public Color COLOR_WEB5  = Color.decode("#DEDDFA"); // ecriture claire
	private Plateforme newRegistration = new Plateforme();
	private JLabel nomLabel;
	private JTextField nom;
	private JLabel prenomLabel;
	private JTextField prenom;
	private JLabel pseudoLabel;
	private JTextField pseudo;
	private JLabel emailLabel;
	private JTextField email;
	private JLabel sexeLabel;
	private JTextField sexe;
	private JLabel birthdayLabel;
	private JTextField birthday;
	private JLabel passwordLabel;
	private JPasswordField password;
	
	/******************
	 * Constructeur
	 * 
	 * @param parent
	 * @param title
	 * @param modal
	 ******************/
	public Register(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(250, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	////////////////////////////// METHODES //////////////////////////

	/**
	 * Affichage boite de dialogue
	 * 
	 * @return
	 */
	public Plateforme startNewRegistration() {
		// affichage boite de dialogue
		this.setVisible(true);

		return this.newRegistration;
	}

	/**
	 * Construction des composants du formulaire et actions.
	 */
	private void initComponent() {
		
		// degrade 2 predefini pour panel - copyright Lolo
		class PanelGradientBottom extends JPanel { 
			public void paintComponent(Graphics g){
			    Graphics2D g2d = (Graphics2D)g;
			    GradientPaint gp; 
			    gp = new GradientPaint(0, 0, COLOR_WEB3, 0, getHeight(), COLOR_WEB2, true);
			    g2d.setPaint(gp);
			    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());               
			  }               
		}

		// panel LOGIN
		JPanel panRegister = new JPanel();
		panRegister.setBackground(COLOR_WEB3);
		panRegister.setPreferredSize(new Dimension(220, 560));
		panRegister.setBorder(javax.swing.BorderFactory.
			      createTitledBorder(null, "Inscription", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, COLOR_WEB5));
		
		// champ nom
		nomLabel = new JLabel("Nom");
		nomLabel.setPreferredSize(new Dimension(200, 25));
		nomLabel.setForeground(COLOR_WEB);
		nom = new JTextField(); // champ texte
		nom.setPreferredSize(new Dimension(200, 40));
		nom.setBackground(COLOR_FIELD);
		nom.setForeground(COLOR_WEB5);
		nom.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// champ prenom
		prenomLabel = new JLabel("Prénom");
		prenomLabel.setPreferredSize(new Dimension(200, 25));
		prenomLabel.setForeground(COLOR_WEB);
		prenom = new JTextField();
		prenom.setPreferredSize(new Dimension(200, 40));
		prenom.setBackground(COLOR_FIELD);
		prenom.setForeground(COLOR_WEB5);
		prenom.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// champ pseudo
		pseudoLabel = new JLabel("Pseudo");
		pseudoLabel.setPreferredSize(new Dimension(200, 25));
		pseudoLabel.setForeground(COLOR_WEB);
		pseudo = new JTextField();
		pseudo.setPreferredSize(new Dimension(200, 40));
		pseudo.setBackground(COLOR_FIELD);
		pseudo.setForeground(COLOR_WEB5);
		pseudo.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// champ email
		emailLabel = new JLabel("Email");
		emailLabel.setPreferredSize(new Dimension(200, 25));
		emailLabel.setForeground(COLOR_WEB);
		email = new JTextField();
		email.setPreferredSize(new Dimension(200, 40));
		email.setBackground(COLOR_FIELD);
		email.setForeground(COLOR_WEB5);
		email.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// champ sexe
		sexeLabel = new JLabel("Sexe");
		sexeLabel.setPreferredSize(new Dimension(200,25));
		sexeLabel.setForeground(COLOR_WEB);
		sexe = new JTextField();
		sexe.setText("tapez M ou F");
		sexe.setForeground(COLOR_WEB5);
		sexe.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (sexe.getText().equals("tapez M ou F")) {
					sexe.setText("");
					sexe.setForeground(COLOR_WEB5);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if (sexe.getText().equals("")) {
					sexe.setText("tapez M ou F");
					sexe.setForeground(COLOR_WEB5);
				}
			}
		});
		sexe.setPreferredSize(new Dimension(200, 40));
		sexe.setBackground(COLOR_FIELD);
		sexe.setForeground(COLOR_WEB5);
		sexe.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// champ date de naissance
		birthdayLabel = new JLabel("Date de naissance");
		birthdayLabel.setPreferredSize(new Dimension(200, 25));
		birthdayLabel.setForeground(COLOR_WEB);
		birthday = new JTextField("AAAA-MM-JJ");
		birthday.setForeground(COLOR_WEB5);
		birthday.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (birthday.getText().equals("AAAA-MM-JJ")) {
					birthday.setText("");
					birthday.setForeground(COLOR_WEB5);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if (birthday.getText().equals("")) {
					birthday.setText("AAAA-MM-JJ");
					birthday.setForeground(COLOR_WEB5);
				}
			}
		});
		birthday.setPreferredSize(new Dimension(200, 40));
		birthday.setBackground(COLOR_FIELD);
		birthday.setForeground(COLOR_WEB5);
		birthday.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// champ password
		passwordLabel = new JLabel("Mot de passe");
		passwordLabel.setPreferredSize(new Dimension(200, 25));
		passwordLabel.setForeground(COLOR_WEB);
		password = new JPasswordField();
		password.setPreferredSize(new Dimension(200, 40));
		password.setBackground(COLOR_FIELD);
		password.setForeground(COLOR_WEB5);
		password.setBorder(BorderFactory.createLineBorder(COLOR_WEB2));
		// boutons
		JPanel control       = new PanelGradientBottom();
		control.setPreferredSize(new Dimension(200, 50));
		JButton okBouton     = new JButton("Valider");
		okBouton.setPreferredSize(new Dimension(100, 40));
		okBouton.setBackground(COLOR_FIELD);
		okBouton.setForeground(Color.white);
		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.setPreferredSize(new Dimension(100, 40));
		cancelBouton.setBackground(COLOR_FIELD);
		cancelBouton.setForeground(Color.white);
			
		// ajout des composants du formulaire
		panRegister.add(nomLabel);
		panRegister.add(nom);
		panRegister.add(prenomLabel);
		panRegister.add(prenom);
		panRegister.add(pseudoLabel);
		panRegister.add(pseudo);
		panRegister.add(emailLabel);
		panRegister.add(email);
		panRegister.add(sexeLabel);
		panRegister.add(sexe);
		panRegister.add(birthdayLabel);
		panRegister.add(birthday);
		panRegister.add(passwordLabel);
		panRegister.add(password);
		
		//panel register
		JPanel content = new JPanel();
		content.setBackground(COLOR_WEB3);
		content.add(panRegister);
		//panels boutons
		control.add(okBouton);
		control.add(cancelBouton);
		
		okBouton.addMouseListener(new MouseAdapter() {
			@Override //button clicked
			public void mouseClicked(MouseEvent e) {
				//fermeture de la boite de dialogue apres depart de la partie
					if (nom.getText().length()==0 || prenom.getText().length()==0 || pseudo.getText().length()==0 ||
						email.getText().length()==0|| sexe.getText().length()==0 || birthday.getText().length()==0 || password.getPassword()==null)
					{
						JOptionPane register = new JOptionPane();
						register.showMessageDialog(null,"Veuillez remplir tout les champs avant d'enregistrer votre compte.","Attention",register.WARNING_MESSAGE);
						
					}
					else {
						JoueursModel J = new JoueursModel(nom.getText(),prenom.getText(),sexe.getText(),birthday.getText(),pseudo.getText(),email.getText(), new String (password.getPassword()));
						JoueursDAO JD = new JoueursDAO();
						JD.create(J);
						setVisible(false);
					}
			}
			@Override // survol
			public void mouseEntered(MouseEvent e) {
				JButton okBouton = (JButton)e.getSource();
				okBouton.setBackground(COLOR_WEB);
				okBouton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override // sortie de survol
			public void mouseExited(MouseEvent e) {
				JButton okBouton = (JButton)e.getSource();
				okBouton.setBackground(COLOR_FIELD);
				okBouton.setFocusable(false);
			}
		});
		
		cancelBouton.addMouseListener(new MouseAdapter() {
			@Override // button clicked
			public void mouseClicked(MouseEvent e) {
				// fermeture de la boite de dialogue apres depart de la partie
				setVisible(false);
			}
			@Override // survol
			public void mouseEntered(MouseEvent e) {
				JButton cancelBouton = (JButton)e.getSource();
				cancelBouton.setBackground(COLOR_WEB);
				cancelBouton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override // sortie de survol
			public void mouseExited(MouseEvent e) {
				JButton okBouton = (JButton)e.getSource();
				cancelBouton.setBackground(COLOR_FIELD);
				cancelBouton.setFocusable(false);
			}
		});
		
		// disposition panels
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
		
	}


}
