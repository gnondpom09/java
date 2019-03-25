package puissance4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GrilleCase;

// import fenetre introduction

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

import javax.swing.JOptionPane;

/**
 * Description: Affichage de la grille de jeu Puissance4
 * 
 * @author Team LDNR
 */
public class Plateforme extends JFrame {

	/******************************
	 * Attributs
	 ******************************/
	private DefaultComboBoxModel comboModel;
	private JComboBox combo;
	public JFrame frame;
	private static final long serialVersionUID = 2026580921442617098L;
	private static final int COLONNE = 10;
	private static final int LIGNE = 10;
	private static final int NB_JOUEUR = 2;
	private static final int MARGIN_BUTTON = 4;
	public Color COLOR_WEB = Color.decode("#6556ed");
	public Color COULEUR_BG = Color.lightGray;
	private GrilleCase gc;
	private JPanel zonePrincipale = new JPanel();
	private JPanel zoneCase = new JPanel();

	/***************
	 * Construct
	 ***************/
	public Plateforme() {

		this.setTitle("STUPID GAME - Team LDNR");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gc = new GrilleCase(COLONNE, LIGNE, NB_JOUEUR);

		// zooning
		setZonePrincipale();
		setZoneCase();

		this.setContentPane(zonePrincipale);

	}

	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////// METHODES ///////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	private void setZonePrincipale() {

		////////////////////////// CREATION PANELS /////////////////////////
		// fenetre principale
		zonePrincipale.setLayout(new BorderLayout());
		
		// top
		JPanel header = new JPanel();
		header.setBackground(COLOR_WEB);
		
		// colone gauche
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(COULEUR_BG);
		JPanel panel_login = new JPanel();
		panel_login.setBackground(COULEUR_BG);
		panel_login.setBorder(BorderFactory.createTitledBorder("Login"));
		JPanel panel_rules = new JPanel();
		panel_rules.setBackground(COULEUR_BG);
		panel_rules.setBorder(BorderFactory.createTitledBorder("Menu"));
		
		// zone centre
		JPanel panel_game = new JPanel();
		panel_game.setBackground(COULEUR_BG);
		
		// colone droite
		JPanel panel_aside = new JPanel();
		panel_aside.setBackground(COULEUR_BG);
		JPanel panel_choix = new JPanel();
		panel_choix.setBackground(COULEUR_BG);
		panel_choix.setBorder(BorderFactory.createTitledBorder("Jeu"));
		JPanel panel_start = new JPanel();
		panel_start.setBackground(COULEUR_BG);
		panel_start.setBorder(BorderFactory.createTitledBorder("Partie"));
		
		// footer
		JPanel footer = new JPanel();
		footer.setBackground(COULEUR_BG);
		footer.setBorder(BorderFactory.createTitledBorder("Credit"));

		//////////////////////////////////////////////////////////////////////
		////////////////////////////// HEADER ////////////////////////////////
		//////////////////////////////////////////////////////////////////////

		//////////////////////////// TITRE H1 ////////////////////////////////
		JLabel lblStupidGame = new JLabel("STUPID GAME");
		lblStupidGame.setFont(new Font("Oswald", Font.PLAIN, 20));
		lblStupidGame.setForeground(Color.WHITE);

		//////////////////////////////////////////////////////////////////////
		////////////////////////////// MENU GAUCHE ///////////////////////////
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////// LOGIN ///////////////////////////////
		JLabel lblLogin = new JLabel("Déjà inscrit");
		JLabel lblRegister = new JLabel("Nouveau joueur");
		
		/////////////////////// BOUTON DE CONNEXION //////////////////////////
		JButton btnConnexion = new JButton("Connexion");
		// events
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ouvre une boite de dialogue pour la connexion
			}
		});

		///////////////////////// BOUTON INSCRIPTION /////////////////////////
		JButton btnSinscrire = new JButton("S'inscrire");
		// events
		btnSinscrire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ouvre boite de dialogue pour inscrire un joueur dans la base
				// de donnees
			}
		});
		
		////////////////////////// BOUTON HISTORIQUE ////////////////////////
		JButton btnHistorique = new JButton("Historique");
		btnHistorique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// afficher la boite de dialogue avec l historique de jeu
			}
		});

		//////////////////////////// BOUTON REGLEMENT ///////////////////////
		JButton btnRglement = new JButton("Règlement");
		// events
		btnRglement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// affiche une boite de dialogue avec le reglement
			}
		});

		zonePrincipale.add(panel_game, BorderLayout.CENTER);
		zoneCase.setBackground(COULEUR_BG);
		
		////////////////////////////// CHOIX DU JEU //////////////////////////
		JLabel lblChoix = new JLabel("Choix du jeu");
		
		// remplissage des jeux dans la combobox
		comboModel = new DefaultComboBoxModel();
		comboModel.addElement("Puissance 4");
		comboModel.addElement("Tic Tac Toe");
		
		JComboBox comboBox = new JComboBox(comboModel);
		// evenements
		comboBox.addActionListener(new ActionListener() {
			// action sur la selection du jeu
			public void actionPerformed(ActionEvent e) {
				// selection du jeu puissance 4
			}
		});
		
		////////////////////// VALIDER LA SELECTION DU JEU ///////////////////
		JButton btnValider = new JButton("Valider");
		// evenement sur le bouton valider de la selection du jeu
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Affiche la grille du jeu dans la fenetre principale
				zonePrincipale.add(zoneCase, BorderLayout.CENTER);
				
				// affichage de la grille de jeu
				panel_game.setVisible(false);
			}
		});
		
		/////////////////////// BOUTON NOUVELLE PARTIE ///////////////////////
		JButton newPart = new JButton("Nouvelle Partie");
		newPart.addActionListener(new BtnNouvellePartie());
		newPart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 1 - ouvre la boite de dialogue pour demarrer la partie
		        NewGame game = new NewGame(null, "Nouvelle partie", true);

		        Plateforme startGame = game.startNewGame();
		        JOptionPane gamePanel = new JOptionPane();
			}
		});
		
		/////////////////////////// BOUTON QUITTER ////////////////////////////
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// quitter le programme
			}
		});
		
		/////////////////////////// INFOS FOOTER /////////////////////////////
		JLabel lblCredit = new JLabel("Team LDNR");

		///////////////////////// DISTRIBUTION BOUTONS ////////////////////////
		
		// separateur
		JSeparator separator_1 = new JSeparator();
		JSeparator separator_2 = new JSeparator();
		
		// header
		header.add(lblStupidGame);
		
		// menu gauche
		panel_menu.setLayout(new GridLayout(2, 1));
		panel_menu.add(panel_login);
		panel_login.setLayout(new GridLayout(4, 8));
		panel_login.add(lblLogin);
		panel_login.add(btnConnexion);
		panel_login.add(lblRegister);
		panel_login.add(btnSinscrire);
		panel_menu.add(panel_rules);
		panel_rules.setLayout(new GridLayout(4, 8));
		panel_rules.add(btnHistorique);
		panel_rules.add(btnRglement);
		
		// menu droite
		panel_aside.setLayout(new GridLayout(2, 1));
		panel_aside.add(panel_choix);
		panel_choix.setLayout(new GridLayout(4, 2));
		panel_choix.add(lblChoix);
		panel_choix.add(comboBox);
		panel_choix.add(btnValider);
		panel_aside.add(panel_start);
		panel_start.setLayout(new GridLayout(4, 4));
		panel_start.add(newPart);
		panel_start.add(btnQuitter);
		
		// footer
		//footer.add(lblCredit);
		footer.add(new AffichageStatsJoueurs(gc));
		footer.add(new AffichageJoueur(gc));

		////////////////////////// DISPOSITION GRILLE ////////////////////////////

		// header
		zonePrincipale.add(header, BorderLayout.NORTH);
		// colone menu
		zonePrincipale.add(panel_menu, BorderLayout.WEST);
		// aside 
		zonePrincipale.add(panel_aside, BorderLayout.EAST);
		// footer
		zonePrincipale.add(footer, BorderLayout.SOUTH);

	}

	private void setZoneCase() {

		GridLayout gl = new GridLayout(LIGNE, COLONNE);
		gl.setHgap(MARGIN_BUTTON);
		gl.setVgap(MARGIN_BUTTON);

		zoneCase.setLayout(gl);

		for (int i = 0; i < LIGNE; i++) {
			for (int j = 0; j < COLONNE; j++) {
				zoneCase.add(new AffichageCase(j, i, gc));
			}
		}
	}

	class BtnNouvellePartie implements ActionListener {

		/**
		 * Redéfinition de la méthode actionPerformed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			gc.nouvellePartie();
		}
	}
}
