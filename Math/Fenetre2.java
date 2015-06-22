

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Fenetre2 extends JPanel{
	
	//PLateau
	public int [][] t =
		{
		      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		      { 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
		      { 1, 0, 0, 1, 1, 1, 0, 1, 1, 1 },
		      { 1, 0, 1, 1, 1, 1, 0, 0, 0, 1 },
		      { 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
		      { 1, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
		      { 1, -1, 0, 0, 0, 1, 0, 1, 1, 1 },
		      { 1, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
		      { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
		      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
		};
			
	
 	
	int x = 0 ;
	int y = 0 ;
	int tx ;
	int ty ;
	
	public Fenetre2(int taille , int taille2){
		this.tx = taille ;
		this.ty = taille2 ;
	}
	
	public void print(Graphics g){
		for(int i = 0 ; i< t.length ; i++){
			for(int j = 0; j< t.length ;j++){
				
				
				if(t[i][j] == 0 || t[i][j]==42){
					g.setColor(Color.black);
					g.fillRect(x, y, 65,65);
					g.setColor(Color.WHITE);
					g.fillRect(x, y, 55,55);
				}
				if(t[i][j] == 1){
					g.setColor(Color.black);
					g.fillRect(x, y, 65,65);
					g.setColor(Color.ORANGE);
					g.fillRect(x, y, 55,55);
				}
				if(t[i][j]==-1){
					g.setColor(Color.black);
					g.fillRect(x, y, 65,65);
					g.setColor(Color.RED);
					g.fillRect(x, y, 55,55);
				}
				if(t[i][j]==33){
					g.setColor(Color.black);
					g.fillRect(x, y, 65,65);
					g.setColor(Color.GREEN);
					g.fillRect(x, y, 55,55);
				}
				
				if(i==0 || j==0 || i==9 ||j==9){
					g.setColor(Color.black);
					g.fillRect(x, y, 65,65);
					g.setColor(Color.GRAY);
					g.fillRect(x, y, 55,55);
				}
				
				
				x = x + (int)(tx/10) ;
			}
			x = 0;
			y = y + (int)(ty/10) ;
		}
		x=y=0;	
	}
	
	public void paint(Graphics g){
		print(g);
	}
	
	
}
