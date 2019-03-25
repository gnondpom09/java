package puissance4;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import controller.GrilleCase;

/**
 * Description: Statistiques des joueurs
 * 
 * @author macuser
 *
 */
public class AffichageStatsJoueurs extends JPanel implements MouseListener, Observer {

	private static final long serialVersionUID = 5832886641804505623L;

	private JPanel panel_global;
	private JPanel[] panel_joueurs;

	public AffichageStatsJoueurs(GrilleCase gc) {
		this.setBackground(Color.LIGHT_GRAY);
		gc.addObserver(this);
		
		panel_global = new JPanel();

		panel_joueurs = new JPanel[gc.getNbJoueur() + 1];

		for (int i = 1; i <= gc.getNbJoueur(); i++) {
			panel_joueurs[i] = new JPanel();
			
			//GridLayout panel_single = new GridLayout(8, 4);

			panel_joueurs[i].setBackground(Color.LIGHT_GRAY);

			panel_joueurs[i].setBorder(BorderFactory.createTitledBorder("Joueur " + i));
	
			panel_joueurs[i].add(new JLabel("                        "));
			this.add(panel_joueurs[i]);
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void update(Observable t, Object o) {
		GrilleCase gc = (GrilleCase) t;
		for (int i = 1; i <= gc.getNbJoueur(); i++) {
			panel_joueurs[i].removeAll();
			panel_joueurs[i].add(new JLabel("Coups joué : " + gc.getStatJoueur(i).getNbCoups()));
			panel_joueurs[i].add(new JLabel("Gagné : " + gc.getStatJoueur(i).getNbWin()));
			panel_joueurs[i].add(new JLabel("Perdu : " + gc.getStatJoueur(i).getNbLoose()));
		}
	}

}
