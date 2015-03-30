package model;

import java.awt.Point;
import java.util.ArrayList;

import controleur.*;
import observer.*;


public abstract class  AbstractModele implements Observable, Observateur {
	protected double nombre, repet, angle, sinp, cosp; 
	public double posX =50, posY = 300;
	public int taillelistepoint;
	
	public boolean dessinerchemintortue;
	public boolean dessinfinal;
	
	protected Point point;
	public 	ArrayList<Point>listePoint = new ArrayList<Point>();
	public  ArrayList<ArrayList<Point>>maliste = new ArrayList<ArrayList<Point>>();
	private ArrayList<Observateur>listeObservateur = new ArrayList<Observateur>();
	
	public double getNombre(){return nombre;}
	public double getRepet(){return repet;}
//	public void setRepet(){
//		this.repet= getRepet();
//		}
	
	public void setDonnees(AbstractControleur control){
		this.nombre = control.getDeplacement();
		this.repet = control.getRepetition();
	}
	
	public abstract void initialiser();
	public abstract void avancer();
	public abstract void reculer();
	public abstract void tournerdroite();
	public abstract void tournergauche();
	public abstract void rotation();
	
	public abstract void leverstylo();
	public abstract void poserstylo();
	public abstract void changerposition();
	public abstract void conclusion();
	
	@Override
	public void update(Observable o) {
		AbstractControleur control = (AbstractControleur)o;
			setDonnees(control);			
	}
	@Override
	public void addObservateur(Observateur obs) {
		this.listeObservateur.add(obs);
	}
	@Override
	public void updateObservateur() {
		for(Observateur obs : this.listeObservateur)
			obs.update(this);
	}
	@Override
	public void deleteObserateur() {
		listeObservateur = new ArrayList<Observateur>();
	}
}
	