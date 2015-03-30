package controleur;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.AbstractModele;
import observer.Observable;
import observer.Observateur;
import vue.Vue;

public abstract class AbstractControleur extends Vue implements Observable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pas ="", nbrepetition="1";
	protected String action;
	protected double deplacement, val_rep;
	protected AbstractModele modele; //=new Modele();
	protected ArrayList<String>maListe = new ArrayList<String>();
	private ArrayList<Observateur> listeObservateurmod = new ArrayList<Observateur>() ;
	
	private JButton champ1 = new JButton("avancer");
	private JButton champ2 = new JButton("reculer");
	private JButton champ3 = new JButton("T.droite");
	private JButton champ4 = new JButton("T.gauche");
	private JButton champ10 = new JButton("Rotation");
	private JButton champ5 = new JButton("Poser");
	private JButton champ6 = new JButton("Lever");
	private JButton champ7 = new JButton("Initialiser");
	private JButton champ9 = new JButton("Conclusion");
	private JButton champ8 = new JButton("ChangerPosition");
	private JButton b1 = new JButton("Pas_OK");
	private JButton b2 = new JButton("Rept_OK");

	protected JTextField champ00 = new JTextField(5);
	protected JTextField champ01 = new JTextField(5);
  
	public AbstractControleur(AbstractModele mod){
		   super();
		   this.modele = mod;
		   initialisercontroleur();	
		   initialisermaliste();
		   this.listeObservateurmod.add(modele);
	}   
	public void initialisercontroleur(){	   
		    p3.add(new JLabel("PAS"));
			p3.add(champ00);
			p3.add(b1);
			p3.add(new JLabel("Repeter"));
			p3.add(champ01);
			p3.add(b2);
			p3.setBackground(Color.blue);
			p3.setLayout(new GridLayout(2,2,5,5));
		    champ01.setText("1");
			b1.addActionListener(new Pas());
			b2.addActionListener(new Repeter());
			
			p4.add(champ1);
			p4.add(champ2);
			p4.add(champ3);
		    p4.add(champ4);
		    p4.add(champ10);
			p4.setBackground(Color.white);
			
			p5.add(champ5);
			p5.add(champ6);
			p5.add(champ7);
		    p5.add(champ8);
		    p5.add(champ9);
		    p5.setBackground(Color.red);
		    
		    p1.setLayout(new GridLayout(1,3,5,5));
		    p1.add(p3);
			p1.add(p4);
			p1.add(p5);	
			
		    champ1.addActionListener(new Avancer());
		    champ2.addActionListener(new Reculer());
		    champ3.addActionListener(new Tournerdroite());
		    champ4.addActionListener(new Tournergauche());
		    champ10.addActionListener(new Rotation());
		    champ5.addActionListener(new Poser());
		    champ6.addActionListener(new Lever());
		    champ7.addActionListener(new Initialiser());
		    champ9.addActionListener(new Conclusion());
		    champ8.addActionListener(new Changerpoisition());
	}
	
	public double getDeplacement(){return deplacement;}
	public double getRepetition(){return val_rep;}
	public String getPas(){return pas;}
	public String getNBrepetition(){return nbrepetition;}
	
	public void setAction(String s){
		this.action=s;
		controler();
	}
	public void setPas(String s){
		this.pas=s;
	}
	public void setNBrepetition(String s){
	this.nbrepetition=s;
	}
	public void initialisermaliste(){

		   this.maListe.add("Av");
		   this.maListe.add("Re");
		   this.maListe.add("Td");
		   this.maListe.add("Tg");
		   this.maListe.add("Ps");
		   this.maListe.add("Ls");
		   this.maListe.add("In");
		   this.maListe.add("Ch");
		   this.maListe.add("Co");
		   this.maListe.add("Ro");
	}
	
		class Pas implements ActionListener{
			public void actionPerformed(ActionEvent e){
				setPas(String.valueOf(champ00.getText()));
				if( (!pas.equals("")) && (pas.matches("^[0-9.]+$")) ){
					deplacement = Double.valueOf(pas);
					updateObservateur();
				}else{
					JOptionPane.showMessageDialog(null, "j'attend un Nombre sans caractere, pour effectuer une actions.Merci", "Veuillez saisir un Nombre Correcte",JOptionPane.OK_CANCEL_OPTION);
				}	
			}
		}		
		
		class Repeter implements ActionListener{
			public void actionPerformed(ActionEvent e){
				 setNBrepetition(String.valueOf(champ01.getText()));
				 if((!nbrepetition.equals(""))&&(nbrepetition.matches("^[0-9.]+$"))){
						val_rep=Double.valueOf(nbrepetition);
						updateObservateur();
				 }
			}
		}
	
		class Avancer implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Av");
			}
		}
		class Reculer implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Re");
			}
		}
		class Tournerdroite implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Td");
			}
		}
		class Tournergauche implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Tg");
			}
		}
		
		class Rotation implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Ro");
			}
		}
		class Poser implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Ps");
			}
		}
		class Lever implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Ls");
			}
		}
		class Initialiser implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("In");
			}
		}
		class Changerpoisition implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Ch");
			}
		}
		class Conclusion implements ActionListener{
			public void actionPerformed(ActionEvent evt){
				setAction("Co");
			}
		}
		
	@Override
	public void addObservateur(Observateur obs) {
		this.listeObservateurmod.add(obs);
	}
	@Override
	public void updateObservateur(){
		for(Observateur obs : this.listeObservateurmod)
			obs.update(this);
	}
	@Override
	public void deleteObserateur() {
		this.listeObservateurmod = new ArrayList<Observateur>() ;
	}
	
	abstract void controler();
}
