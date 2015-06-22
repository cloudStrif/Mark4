

import java.awt.Color;
/*
 * FIgure 
 */

public class Rectangle extends Figure implements Deformable{
	
	private int larg ;
	private int haut ;
	Points p1 ,p2,p3 ,p4 ;
	private Color co = Color.blue ;
	int [] tx = new int [4] ;
	int [] ty = new int [4] ;


	public Rectangle(){}
	
	public Rectangle(int x , int y , int larg , int haut){
		super(x,y);
		this.larg = larg ;
		this.haut= haut ;
	}
	
	public Rectangle(Points p1 , Points p2 , Points p3 , Points p4 , Color c){
	this.co=co;
	this.p1=p1;
	this.p2=p2;
	this.p3=p3;
	this.p4=p4;
	
	tx[0] = p1.getX()+6 ;
	tx[1] = p2.getX()+6 ;
	tx[2] = p3.getX()+6 ;
	tx[3] = p4.getX()+6 ;
	
	ty[0] = p1.getY()+6 ;
	ty[1] = p2.getY()+6 ;
	ty[2] = p3.getY()+6 ;
	ty[3] = p4.getY()+6 ;
	larg= (int)(Math.sqrt((tx[0]-tx[1])*(tx[0]-tx[1]) +(ty[0]-ty[1])*(ty[0]-ty[1])));
	haut=(int)(Math.sqrt((tx[2]-tx[3])*(tx[2]-tx[3]) +(ty[2]-ty[3])*(ty[2]-ty[3])));
	
	}
	/*
	 * 
	 * Information relatif a la figure
	 */
	
	
	public void affiche() {
		System.out.println("hauteur = "+ haut +" largeur = "+ larg +" centres" + super.getPosX()+"  et  "+ super.getPosY());
	}
	
	public void deformer(double coeffH, double coeffV) {
		larg =((int) (larg * coeffH)) ;
		haut = (int)((haut)*(coeffV)) ;
	}
	
	public double surface() {
		 double a = larg ;
		 double b = haut ;
		 return a*b ;
	}
	
	public double perimetre() {
		double a = haut ;
		double b = larg ;
		return (a+b)*2 ;
	}


	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}

	public int getHaut() {
		return haut;
	}

	public void setHaut(int haut) {
		this.haut = haut;
	}
	
	public Color getCo() {
		return co;
	}



	public void setCo(Color co) {
		this.co = co;
	}

}
