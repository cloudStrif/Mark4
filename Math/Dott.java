
import java.awt.Color;

public class Dott {
	
	/*
	 * class spécialisé en dessin 
	 * elle est nescessaire car elle differe d'un simple point
	 */

	private int x , y = -10 ;
	
	private int lent = 10 ;
	
	private Color col = Color.red ;
	
	public Dott(int x , int y , int len , Color col){
		this.x = x ;
		this.y=y;
		this.lent=len;
		this.col=col ;
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

	public int getLent() {
		return lent;
	}

	public void setLent(int lent) {
		this.lent = lent;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}
	
}
