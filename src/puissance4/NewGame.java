/**
 * package
 */
package puissance4;

// imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Description : formulaire qui demande le nom des joueurs pour une nouvelle
 * partie
 * 
 * @author Team LDNR
 *
 */
public class NewGame extends JDialog {

	/************
	 * Attributs
	 ************/
	private Plateforme startGame = new Plateforme();
	private boolean sendData;
	private JLabel nomLabel;
	private JTextField nom;

	/******************
	 * Constructeur
	 * 
	 * @param parent
	 * @param title
	 * @param modal
	 ******************/
	public NewGame(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	/**
	 * informations du joueur
	 * 
	 * @return
	 */
	// public JoueurInfo showJoueurInfo() {
	public Plateforme startNewGame() {
		this.sendData = false;
		this.setVisible(true);
		// return this.gamerInfo;
		return this.startGame;
	}

	/**
	 * Composants boite de dialogue
	 */
	private void initComponent() {

		// Joueur 1
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(220, 60));
		nom = new JTextField(); // champ texte
		nom.setPreferredSize(new Dimension(100, 25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nom du joueur 1"));
		nomLabel = new JLabel("Saisir un nom :");
		panNom.add(nomLabel);
		panNom.add(nom);

		// Joueur 2
		JPanel panNom2 = new JPanel();
		panNom2.setBackground(Color.white);
		panNom2.setPreferredSize(new Dimension(220, 60));
		nom = new JTextField(); // champ texte
		nom.setPreferredSize(new Dimension(100, 25));
		panNom2.setBorder(BorderFactory.createTitledBorder("Nom du joueur 2"));
		nomLabel = new JLabel("Saisir un nom :");
		panNom2.add(nomLabel);
		panNom2.add(nom);

		// panel joueurs
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panNom);
		content.add(panNom2);

		// bouton demarrer la partie
		JPanel control   = new JPanel();
		JButton okBouton = new JButton("Demarrer la partie");

		// evenement sur click demarrer la partie
		okBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// affichage de la grille de jeu
				startGame = new Plateforme();

				// recuperer les pseudo des joueurs pour les afficher dans la partie en cours
				
				// fermeture de la boite de dialogue apres depart de la partie
				setVisible(false);
			}
		});

		// evenement sur click bouton annuler
		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// fermeture de la boite de dialogue
				setVisible(false);
			}
		});

		// panels boutons
		control.add(okBouton);
		control.add(cancelBouton);

		// disposition panels
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}
