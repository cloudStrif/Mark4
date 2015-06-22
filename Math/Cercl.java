
import java.awt.Color;

public class Cercl extends Figure{
	/*
	 * Objet Cercle qui contient les parametres
	 * nescessaire a la formation de celui ci
	 * 
	 */
	
	
	double rayon = 0; 
	private Points dep ; 
	private Points ar ;
	private Color co ;


	public Cercl(int x , int y , int rayon , Color co){
		/*
		 * coordonnées du centre du cercle
		 */
		super(x,y);
	//Vrai coordonnée (ceux de java ) 
	//	this.rayon=rayon;
		this.co = co ;
		
	}
	


	public Cercl(Points dep , Points ar, Color cc){
		this.dep = dep ; 
		this.ar =ar ;
		this.co=cc ;
		this.rayon  = Math.sqrt((dep.getXx() - ar.getXx())*(dep.getXx() - ar.getXx()) +
				(ar.getYy() - dep.getYy())*(ar.getYy() - dep.getYy()) );
		System.out.println("mm"+rayon);
	}

	/*
	 * Getter et setters
	 */


	public void affiche() {
		System.out.println("Rayon = " + (rayon/2));
		
	}


	public double surface() {
	return Math.PI*(rayon)*(rayon) ;
	}

	
	public double perimetre() {
	return 2 * Math.PI * rayon ; 
	}
	
	public Points getDep() {
		return dep;
	}

	public void setDep(Points dep) {
		this.dep = dep;
	}

	public Points getAr() {
		return ar;
	}

	public void setAr(Points ar) {
		this.ar = ar;
	}
	
	public Color getCo() {
		return co;
	}

	public double getRayon() {
		return rayon;
	}
	
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}


	public void setCo(Color co) {
		this.co = co;
	}
	
}
