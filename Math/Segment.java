
import java.awt.Color;



public class Segment {
    
    /*
     * Point d'arrivé et point de depart 
     */
    private Points dep ;
    
    private Points ar ;
    
    // taille et taille2 qu'il y a dans Panneau.java
    private int t , t2 = 0 ;
    // coordonnée ax + by = c( equation diophantienne)
    
    private int matrice = 0 ;
    
    
	public Segment (Points dep , Points ar){
    	this.dep = dep ;
    	this.ar = ar ;
    }
    
    public Segment (Points dep , Points ar, int matrice){
    	this.dep = dep ;
    	this.ar = ar ;
    	this.matrice=matrice ;
    }
    
    // calcule la distance entre 2 poitns 
    public double Long(){
	return Math.sqrt((ar.getXx() - dep.getXx())*(ar.getXx() - dep.getXx()) + (ar.getYy() - dep.getYy())*(ar.getYy() - dep.getYy())) ;
	
    }
    
    
    public void deplacement(Points d , Points a){
    	dep=d;
    	ar=a;
    }
    
    /*
     *  Getter et setter  
     */
    
    public int getMatrice() {
		return matrice;
	}

	public void setMatrice(int matrice) {
		this.matrice = matrice;
	}
    
    public Points getDep(){
	return dep ;
    }
    
	public void setDep(Points dep){
	    this.dep = dep ;
	}
    
    public Points getAr(){
	return ar ;
    }
    
    public void setAr(Points ar){
	this.ar = ar ;
    }
    
    public int getT() {
	return t;
    }
    
	public void setT(int t) {
	    this.t = t;
	}
    
    public int getT2() {
	return t2;
    }
    
    public void setT2(int t2) {
	this.t2 = t2;
    }
    
    
	
    
}
