package vue;

import controleur.AbstractControleur;
import controleur.Controleur;
import model.AbstractModele;
import model.Modele;

public class TestVue {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractModele m = new Modele();
		AbstractControleur v = new Controleur(m);
		m.addObservateur(v);
		
		AbstractControleur w = new Controleur(m);
		m.addObservateur(w);
	}
}
