
import java.awt.Color;
import java.util.ArrayList;
/*
 * classe represantant un point 
 */

public class Points {

	/*
	 * x et y sont les vrais
	 */
	private int x = -10;
	private int y = - 10 ;
	private int taille = 15;
	private Color color = Color.GREEN ;

/*
 * xx et yy sont juste pour l'affichage
 */
	private double xx = -10;
	
	private double yy = -10 ;
	/*
	 * Verifie si c'est un point , ou  si c'est un point dans un bjet geometrique
	 */
	private int veri ;
	/*
	 * Pointeur relatif aux droites avec equations
	 */
	public int max ;
	public int min ;
	
	
	public double co ;
	public double co2 ;
		
	
	/*
	 * Valeur pour le graphe , qui change en fonction du zoom
	 */

		public Points(){}

		
		public 	Points(int x, int y ,double co , double co2 ,int veri){
			this.x = x ;
			this.y = y ;
			this.co=co;
			this.co2=co2;
			this.veri=veri ;
		
			this.xx =  ((x+6 - 400)*0.01)*co ;
			this.yy =  ((-(y+6 - 275))*0.01)*co2 ;
		}
		
		/*
		 * Convertion inverse des valeurs 
		 * Attention au cas ou co = co2 = 1 ...
		 */
		public 	Points(double x, double y ,double co , double co2 ,int veri){
			this.x =  (int)(((x/co/0.01) + 400 ) -6); 
			this.y =  (int)((-(y/co2/0.01) +275 )-6); 
			
			this.veri=veri;
			this.xx = x*co ;
			this.yy = y*co2 ;
		
		}
		
		
		
		
		
		public Points (double gx , double gy , Color color){
			this.xx = gx ;
			this.yy = gy ;
			this.color = color ;
		}
		
		
		
		public boolean equalss (Points p){
			return p == this;
		}

		
		public int getX(){
			return x ;
		}
		public void setX(int x){
			this.x = x ;
		}
		
		
		public int getY(){
			return y ;
		}
		public void setY(int y){
			this.y = y ;
		}	
		

		
		public int getVeri(){
			return veri ;
		}
		public void setTaille(int t){
			this.taille = t ;
		}	
		
		
			
		public double getYy(){
			return yy ;
		}
		public void setYy(double yy){
			this.yy = yy ;
		}	
		
		

		public double getXx(){
			return xx ;
		}
		public void setXx(double xx){
			this.xx = xx ;
		}
		
		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public void setVeri(int veri) {
			this.veri = veri;
		}
		
	
		
}
