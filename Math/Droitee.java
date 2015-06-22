import java.awt.Color;



public class Droitee {
	
	/*
	 * Point d'arrivé et point de depart 
	 */
	private Points dep ;
	
	private Points ar ;
	
	private Points ter ;
	
	


	// coordonnée ax + by = c( equation diophantienne)
	private double a ;
	
	private double b ;
	
	private Color colo = Color.red ;



	private double c ;
	
	
	private double q ;
	
	private double r ;
	
	private double tt ;
	
	private String cate  = "" ;
	
	boolean select = false ;
	
	public Droitee (Points dep , Points ar , String cate){
		this.dep = dep ;
		this.ar = ar ;
		//coordonné sur le graphe crée
		
		this.cate=cate ;
		
		this.a = ar.getXx() - dep.getXx() ;
		this.b = ar.getYy() - dep.getYy();
		this.c = a*dep.getXx() + b*dep.getYy() ;
		
		// vrai coordonné
		
		this.q = ar.getX() - dep.getX() ;
		this.r = ar.getY() - dep.getY();
		this.tt =  q*dep.getX() + r*dep.getY() ;
		
		System.out.println(this.q+" et "+this.r+" et "+ this.tt);
		
		// eqution sous la forme Y = Ax +B
		
		//double co = -(q /r) ;
		
		//Code JUSTE 
		System.out.println( ar.getY() + " " + dep.getY() );
		
		
		switch (cate){
		
		case "droite" :
		double co =(double)(((ar.getY()+6) - (dep.getY()+6)) /(double)( (ar.getX()+6) - (dep.getX()+6))) ;
		
		double co2 =( dep.getY()+6) - co*(dep.getX()+6) ;
		
		this.q = co ;
		this.r = co2 ;
		System.out.println("pd"+q);
		
		dep.min =(int)( co*-2 + co2 );
		dep.max =(int) (co*800 + co2 );
		
		System.out.println(co);
		break ;
		
		case "demi":
				
			
			double coe =(double)((ar.getY()+6) - (dep.getY()+6)) /(double)( (ar.getX()+6) - (dep.getX()+6)) ;
			
			double coe2 =(dep.getY()+6) - coe*(dep.getX()+6) ;
			
			this.q = coe ;
			this.r = coe2;
			
			dep.min = (int)(coe*-2 + coe2);
			dep.max =  (int)(800*coe +coe2) ;
			
		break ;
		case "media":
			double a,b,c = 0 ;
		
			a = (double)(ar.getX()+6) - (dep.getX()+6) ;
			
			
			
			b =(double) (ar.getY()+6) - (dep.getY()+6);
			
			
			c = -a*(((ar.getX()+6) + (dep.getX()+6) ) /2)
					+ -b*( ((ar.getY()+6)+(dep.getY()+6) )/2    ) ;
			
			   double coeffa =  -(a / b) ;
			    
			    double coeffb = (- c) / (b) ;
			    
			    this.q = coeffa ;
				this.r = coeffb ;
			    dep.min = (int)(coeffa*-2 + coeffb);
			    dep.max = (int)(800*coeffa +coeffb) ;
			
		break ;
		
		}
		
	}
	
	
	public Droitee(Points dep , Points ar , Points ter){
		this.dep = dep ;
		this.ar = ar ;
		this.ter=ter ;
		
		

		this.a = ar.getXx() - dep.getXx() ;
		this.b = ar.getYy() - dep.getYy();
		this.c = a*dep.getXx() + b*dep.getYy() ;
		
		
		//coordonné sur le graphe crée
		double a, b ,c , x , y, z= 0 ;
		
		//Facteur de la premiere droite 
		
		
		a = (ar.getX() + 6) - (dep.getX()+6) ;
		
		b =( ar.getY()+6) - (dep.getY()+6) ;
 		
		c = a * (ar.getX()+6) + b*(ar.getY()+6) ; 
		
	
		
		    
		x  = (ter.getX()+6) - (ar.getX()+6);
		  
		y = (ter.getY()+6) - (ar.getY()+6);
		
		z = x*(ar.getX()+6) + y*(ar.getY());
		double coeffa  , coeffb = 0 ;
		
		coeffa =  -( a/Math.sqrt(a*a + b*b ) +  x/Math.sqrt(x*x + y*y) ) / (b / Math.sqrt(a*a+b*b ) + y / Math.sqrt(x*x + y*y));
		
		
		coeffb =( c/Math.sqrt(a*a +b*b ) + z/Math.sqrt(x*x + y*y)) / (b/Math.sqrt(a*a +b*b) + y/Math.sqrt(x*x +y*y) ) ; 
		
		this.q = coeffa ;
		this.r = coeffb;
		
		dep.min = (int)(coeffa*-2 + coeffb);
		dep.max = (int)(800*coeffa +coeffb) ;
		
	
	}
	

	
	public Points inter (Droitee d , double to , double to2){
/*	double a1 = q/tt ;
	double b1 = r /tt ;
	
	double a2 = d.q / d.tt ;
	double b2= d.r / d.tt ;
	
	return new Points((int) ((b2 - b1)/(a1*b2 - a2*b1)),
		(int)((a2-a1)/(b1*a2 - b2*a1)) ,1,1, 0) ;*/
		
		double x = (d.r - r)/(q - d.q) ;
		return new Points( (int)((d.r - r)/(q - d.q))-6, (int)(d.q*x+d.r)-6  ,to ,to2,0);
		
		/*return new Points( (int)((tt*d.r - d.tt*r)/(q*d.r - r*d.q)) , 
				(int)((q*d.tt - tt*d.q)/(q*d.r - r*d.q))  ,1,1,0) ;
		*/
		
		
	}
	
	  
    public void deplacement(Points d , Points a){
    	dep=d;
    	ar=a;
    }
	
	/*
	 *  Getter et setter  
	 */
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



	public double getQ() {
		return q;
	}

	public void setQ(double q) {
		this.q = q;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getTt() {
		return tt;
	}

	public void setTt(double tt) {
		this.tt = tt;
	}
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
	public Color getColo() {
		return colo;
	}

	public void setColo(Color colo) {
		this.colo = colo;
	}
	public Points getTer() {
		return ter;
	}


	public void setTer(Points ter) {
		this.ter = ter;
	}
	
}
