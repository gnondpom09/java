package puissance4;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import controller.GrilleCase;

/**
 * Description: Informations du joueur en cours
 * 
 * @author macuser
 *
 */
public class AffichageJoueur extends JLabel implements MouseListener, Observer {

	private static final long serialVersionUID = 5832886641804505623L;

	public AffichageJoueur(GrilleCase gc) {
		super("En attente : Joueur N° " + gc.getJoueurEnCours());
		gc.addObserver(this);
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
		this.setText("En attente : Joueur N° " + ((GrilleCase) t).getJoueurEnCours());

	}

}
