

import java.awt.Color;
import java.util.ArrayList;

/*
 * classe qui gere les polygones
 */
public class Polygone extends Figure{
	//Liste des points du polygone
	Points [] dot ;
	private double co ;
	private double co2 ;
	/*
	 * Position du centre du pointeur
	 */
	double posx  = 0 ;
	double posy = 0;
	
	int [] pox ;
	int [] poy ;
	ArrayList <Points> attente ; 
	
	Color colo = Color.red ;
	//Cas ou le polygone est regulier de n cotés
	
	 int size = 0 ;

	public Polygone(int taille , double co , double co2 ,double posx, double posy){
		
		dot = new Points[taille] ;
		size=taille;
		this.co =co ;
		this.co2 = co2 ;
		this.posx=posx ;
		this.posy=posy ;
		
		
		comp(taille) ;
	}
	/*
	 * Recupere les coordonnes des points pour le zoom
	 */
	
	public Polygone(Points []tab , Color r){
		colo=r;
		size = tab.length;
		dot=tab ;
		pox = new int [tab.length];
		poy=new int[tab.length];
		for(int i = 0 ; i < tab.length ; i++){
			pox[i] = (int)(tab[i].getX()+6 );
			poy[i] = (int)(tab[i].getY()+6 );
		}
	}

	public Polygone (ArrayList<Points> liste , Color r){
		colo=r ;
		attente=liste;
		size=liste.size() ;
		pox=new int[liste.size()];
		poy=new int[liste.size()];
		dot = new Points[liste.size()];
		for(int i = 0 ; i < liste.size() ; i++){
			dot[i] = liste.get(i);
			pox[i] = liste.get(i).getX()+6;
			poy[i] = liste.get(i).getY()+6 ;
		}	
		
		
	}
	
	public void comp(int t){
		pox = new int [t] ;
		poy = new int [t] ;
	
		
		for(int  i  =0 ;  i < t ; i++ ){
			Points tmp = new Points( Math.cos((2*i*Math.PI)/t)  ,
					Math.sin((2*i*Math.PI)/t) ,co,co2,42)  ;
			tmp.setX((int)(tmp.getX()-6));
			tmp.setY((int)(tmp.getY()-6));
			dot[i] = tmp ;
			pox[i] = (int)(tmp.getX() );//((posx+6 - 400)*0.01)*co ) ;
			poy[i] = (int)(tmp.getY() );//-((-(posy+6 - 275))*0.01)*co2 );
			
			
		}
		// initialisation des coordonnes du polygone 
		
		
	}
	
	public void affiche() {
		
	}

	
	public double surface() {
		double per ;
		if(pox.length>1){
		per =( Math.sqrt(((pox[0] - poy[0])*(pox[0] - poy[0]) + (pox[1] - poy[1])*(pox[1] - poy[1]) ) ) )/2;
		return ((per*2 )/2 )*size*2;
		}
		return 0 ;
	}

	

	public double perimetre() {
		double per ;
		if(pox.length > 1){
			 per = Math.sqrt(((pox[0] - poy[0])*(pox[0] - poy[0]) + (pox[1] - poy[1])*(pox[1] - poy[1]) )  );
			return (per*size);
		}
		return 0 ;
		
	}
	
	public String cord(){
	
		String cor = "";
		
		for(int  i =0 ; i < dot.length ; i++){
			cor = cor + "Coordoné Xdu point "+ i + " : "+dot[i].getXx() + "\n";
			cor = cor + "Coordoné Ydu point "+ i + " : "+dot[i].getYy() + "\n";
			cor = cor + "\n\n";
		}
		return cor ;
		
	}
	/*
	 * Getters et setters
	 */
	

	public double getCo() {
		return co;
	}

	public void setCo(double co) {
		this.co = co;
	}

	public double getCo2() {
		return co2;
	}

	public void setCo2(double co2) {
		this.co2 = co2;
	}
	
	
}
