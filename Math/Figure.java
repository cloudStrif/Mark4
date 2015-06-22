


public abstract class Figure {
	/*
	 * Classe Mére 
	 */
	
	private int posX ;
	private int posY ;
	
	
	public Figure(int x , int y){
		this.posX=x ;
		this.posY=y ;
	}
	
	public Figure () {}

	/*
	 * Renvoie la distance entre la figure et une autre
	 */
	public double estDistanDe(Figure fig ){
		return  Math.sqrt((posX-fig.getPosX())*(posX-fig.getPosX())+ (posY-fig.getPosY())*(posY-fig.getPosY()));
		
	}
	public void deplacement(int x , int y){
		posX = x ;
		posY = y ;
	}
	
	/*
	 * Methode abstraite pour les coordonnées des figures 
	 */
	
	public abstract void affiche() ;
	public abstract double surface() ;
	public abstract double perimetre() ;
	
	public int getPosX(){
		return this.posX ;
	}
	public int getPosY(){
		return this.posY ;
	}
	
}
