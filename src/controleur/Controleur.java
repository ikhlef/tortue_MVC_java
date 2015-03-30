package controleur;

import model.AbstractModele;

public class Controleur extends AbstractControleur{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Controleur(AbstractModele mode){
		super(mode);
	}

	
	 void controler(){	
		if(maListe.contains(this.action)){
			 if(this.action.equals("Av")){
				 this.modele.avancer();
			 }else if(this.action.equals("Re")){
				 this.modele.reculer();
			 }else if(this.action.equals("Td")){
				 this.modele.tournerdroite();
			 }else if(this.action.equals("Tg")){
				 this.modele.tournergauche();
			 }else if(this.action.equals("Ro")){
				 this.modele.rotation();
			 }else if(this.action.equals("Ps")){
				 this.modele.poserstylo();
			 }else if(this.action.equals("Ls")){
				 this.modele.leverstylo();
			 }else if(this.action.equals("Co")){
				this.modele.conclusion();
			 }else if(this.action.equals("In")){
				 this.champ00.setText("");
				 this.champ01.setText("1");
				 this.modele.initialiser();
			 }else if(this.action.equals("Ch")){
				 this.modele.changerposition();
			 } 
		 }		 
	 }
}
