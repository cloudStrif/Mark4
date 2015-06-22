

import java.awt.Color;

public class Triangle extends Figure implements Deformable{
    private int base ;
    private int hauteur ;
    
    
    private Points p1 ;
    private Points p2 ;
    private Points p3 ;
    public Color co = Color.blue ;
    
    public int [] tx = new int [3];
    public int [] ty = new int [3] ;
    
    
    /*
     * Cas echeant
     */
    public Triangle(int x , int y , int base, int hauteur){
	super(x,y);
	base = base ;
	hauteur=hauteur ;
    }
    
    
    public Triangle(Points a , Points b , Points c ,Color co){
	this.p1=a;
	this.p2=b;
	this.p3=c ;
	this.co = co ;
	
	tx[0] = p1.getX()+6 ;
	tx[1] = p2.getX()+6 ;
	tx[2] = p3.getX()+6 ;
	
	ty[0] = p1.getY()+6 ;
	ty[1] = p2.getY()+6 ;
	ty[2] = p3.getY()+6 ;
	
    }
    public void affiche(){
	System.out.print("base = "+base + "hauteur = "+ hauteur +" centres = " + super.getPosX()+"  "+ super.getPosY());
    }
    
    public void deformer(double coeffH, double coeffV) {
	base = (int)(base*coeffH) ;
	hauteur = (int)(hauteur*coeffV);
	
    }
    
    public double surface() {
	double a  = base ;
	double b = hauteur ;
	return ((a*b)/2) ;
    }
    
    public double perimetre() {
	
	double d1 = Math.sqrt((p1.getXx() - p2.getXx())*(p1.getXx() - p2.getXx()) + (p1.getYy() - p2.getYy())*(p1.getYy() - p2.getYy()));
	
	double d2 =  Math.sqrt((p1.getXx() - p3.getXx())*(p1.getXx() - p3.getYy()) + (p1.getYy() - p3.getXx())*(p3.getYy() - p2.getYy()));
	
	double d3 =  Math.sqrt((p3.getXx() - p2.getXx())*(p3.getXx() - p2.getYy()) + (p3.getYy() - p2.getYy())*(p3.getYy() - p2.getYy()));
	return ((d1+d2+d3)) ;	
	
    }
    
    
    public int getBase() {
	return base;
    }
    
    public void setBase(int base) {
	this.base = base;
    }
    
    public int getHauteur() {
	return hauteur;
    }
    
    public void setHauteur(int hauteur) {
	this.hauteur = hauteur;
    }
    
    
    public Points getP1() {
	return p1;
    }
    
    
    public void setP1(Points p1) {
	this.p1 = p1;
    }
    
    
    public Points getP2() {
	return p2;
    }
    
    
    public void setP2(Points p2) {
	this.p2 = p2;
    }
    
    
    public Points getP3() {
	return p3;
    }
    
    
    public void setP3(Points p3) {
	this.p3 = p3;
    }
    
    
    
}
