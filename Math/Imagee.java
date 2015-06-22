
import java.awt.Image;

public class Imagee {
	/*
	 * Taille de l'image 
	 * Place des grands hommes
	 */
	
	private int x = -10 ;
	
	private int y = - 15 ;
	
	private Image im ;
	

	private String nom = "" ;
	// Taille de l'image
	private int x2  = 10 ; 
	
	private int y2 = 10;
	
	public Imagee(int x , int  y , String nom , int x2 , int y2){
		this.x=x ;
		this.y = y ;
		this.nom=nom ;
		this.x2=x2;
		this.y2=y2 ;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public Image getIm() {
		return im;
	}

	public void setIm(Image im) {
		this.im = im;
	}

	
	
}
