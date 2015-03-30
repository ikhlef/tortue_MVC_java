package model;
import java.awt.Point;
import java.util.ArrayList;

public class Modele extends AbstractModele {
	public Modele(){
		super();
	}
	
    public double getPosX(){return posX;}
	public double getPosY(){return posY;}
	
	public void setPosX(){
		this.posX += getNombre();
		updateObservateur();
	}
	public void setPosY(){
		this.posY += getNombre();
		updateObservateur();
	}
	
	public void initialiser() {	
		listePoint=  new ArrayList<Point>();
		posX = 50;
		posY=300;
		listePoint.add((new Point((int)posX,(int)posY)));
		dessinerchemintortue = false;
		dessinfinal= false;
		maliste= new ArrayList<ArrayList<Point>>();
		maliste.add(listePoint);
		this.nombre =0;
		this.repet =1;
		updateObservateur();
	}

	@Override
	public void avancer() {
		int d=(int)getRepet();
		for(int i=0;i<d;i++){
			point = new Point((int)getPosX(),(int)getPosY());
			listePoint.add(point);
			setPosX();
		}
	}

	@Override
	public void reculer() {
		int d=(int)getRepet();
		for(int i=0;i<d;i++){
		point = new Point((int)getPosX(),(int)getPosY());
		listePoint.add(point);
		this.posX -= getNombre();
		updateObservateur();
		}
	}

	@Override
	public void tournerdroite() {
		int d=(int)getRepet();
		for(int i=0;i<d;i++){
		point = new Point((int)getPosX(),(int)getPosY());
		listePoint.add(point);
		setPosY();
		}
	}

	@Override
	public void tournergauche() {
		int d=(int)getRepet();
		for(int i=0;i<d;i++){
		point = new Point((int)getPosX(),(int)getPosY());
		listePoint.add(point);
		this.posY -= getNombre();
		updateObservateur();
		}
	}

	public void rotation(){
		int d=(int)getRepet();
		for(int i=0;i<d;i++){
			angle = Math.toRadians(getNombre());
		System.out.println("l angle est : "+ angle);
		Point p = listePoint.get(listePoint.size()-1);
		this.posX= p.x * Math.cos(angle) - p.y * Math.sin(angle); 
		this.posY= p.x * Math.sin(angle) + p.y * Math.cos(angle);
		point = new Point((int)getPosX(),(int)getPosY());
		listePoint.add(point);
		updateObservateur();
		}
	}
	@Override
	public void leverstylo() {
		this.dessinerchemintortue = false;
		dessinfinal = false;
		point = new Point((int)getPosX(),(int)getPosY());
		listePoint.add(point);
		updateObservateur();
	}

	@Override
	public void poserstylo() {
		dessinerchemintortue = true;
		dessinfinal = false;
		point = new Point((int)getPosX(),(int)getPosY());
		listePoint.add(point);
		taillelistepoint=listePoint.size();
		updateObservateur();	
	}

	@Override
	public void changerposition() {
		dessinerchemintortue = false;
		maliste.add(this.listePoint);
		this.listePoint = new ArrayList<Point>();
		this.posX=getNombre();
		//this.posY=getNombre()/2;
		this.posY=getRepet();
		point = new Point((int)getPosX(),(int)getPosY());
		this.listePoint.add(point);
		updateObservateur();
	}
	@Override
	public void conclusion() {
		maliste.add(this.listePoint);
			dessinerchemintortue = true;
			dessinfinal = true;
			updateObservateur();
	}
}
