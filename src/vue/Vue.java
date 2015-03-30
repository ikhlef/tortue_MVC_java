package vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.*;

import observer.Observable;
import observer.Observateur;

public class Vue extends JFrame implements Observateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p1 = new JPanel();
	protected JPanel p3 = new JPanel();
	protected JPanel p4 = new JPanel();
	protected JPanel p5 = new JPanel();
	private Panneau panneau = new Panneau();
	
	public Vue(){
		setBounds(1,1,10000,1000);
		setTitle("hello foufi,");
		setBackground(Color.red);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		panneau.setBackground(Color.yellow);
		Container aa = getContentPane();
		aa.add(p1, "North");
		aa.add(panneau, "Center");
		setVisible(true);
	}
	
	
	public int []tableauX = new int[1000];
	public int []tableauY = new int[1000];
	
	class Panneau extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		double posX = 50;
		double posY = 300;		
		private Modele model;
		ArrayList<Point>liste; 

		Panneau(){
			super();
			setBackground(Color.white);
		}
		
		public void paintComponent(Graphics g){
			
		    super.paintComponent(g);
		    Graphics2D g2d = (Graphics2D) g; 
		    g.drawString("ARRIVEE",getWidth()-70, getHeight()/2);
		    g.drawString("DEPART",5,getHeight()/2);
			g.setColor(Color.blue);
		
	        try{
	        	if (model== null){
	        		Image img = ImageIO.read(new File("tortue.gif")); // donner un nom a l image
					g2d.drawImage(img,(int)posX,(int)posY, this);  
	        	}else if (model != null){
					Image img = ImageIO.read(new File("tortue.gif"));
					g2d.drawImage(img, (int)model.getPosX(),(int)model.getPosY(), this);
						if((model.dessinerchemintortue == true)&&(model.dessinfinal==false)){
							System.out.println("la taille de la liste actuelle est : "  +  model.listePoint.size()  +  " points.");
							System.out.println("");
							System.out.println("les points de la liste actuelle sont : ");
							for(int i = 0; i < model.listePoint.size(); i++){
								Point pp = model.listePoint.get(i);
								System.out.println("point" + "(" + pp.x + "," + pp.y +")");
								tableauX[i]=pp.x;
								tableauY[i]=pp.y;
							}
							g2d.drawPolyline(tableauX,tableauY,model.taillelistepoint );
						}else  if((model.dessinerchemintortue == true)&&(model.dessinfinal==true)){
							System.out.println("la taille de ma liste des listes est : " + model.maliste.size() + " listes.");
						 		for(int i = 0; i < model.maliste.size(); i++){
						 				this.liste = model.maliste.get(i);
										System.out.println("");
						 				System.out.println("la taille de la liste en cours est : "  +  this.liste.size()  +  " Points.");
						 				System.out.println("");
						 				System.out.println("les points de la liste numéro " + i + " sont :");
						 			for(int j = 0; j < liste.size(); j++){
						 					Point pp = liste.get(j);
						 					System.out.println("point" + "(" + pp.x + "," + pp.y +")");
						 					tableauX[j]=pp.x;
						 					tableauY[j]=pp.y;
						 			}
						 			g2d.drawPolyline(tableauX,tableauY,liste.size());
						 		}
						 	}
					 	}
					
			}catch(IOException e){
				e.printStackTrace();
			}	
		}
	
	public void RepaintTortue(Modele t) {
		this.model = t;
		this.repaint();
	}
	
	}
	@Override
	public void update(Observable o) {
		Modele model = (Modele)o;
		panneau.RepaintTortue(model);	
	}
}
