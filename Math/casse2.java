


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class casse2 extends JPanel{

//	int [][] t = new int [20][20];
	
	int [][] t={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0},
			{0,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0},
			{0,0,0,0,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0},
			{0,0,0,0,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0},
			{0,0,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	int x = 0 ;
	int y = 0 ;
	int pos = 6;
	
	int [] balle = {12,6};
	
	public void affiche(Graphics g){
		t[19][pos-1]=1;
		t[19][pos]=1;
		t[19][pos+1]=1;
		t[balle[0]][balle[1]]=3;
		for(int i = 0 ; i < t.length ; i++){
			for(int j = 0 ; j < t[0].length ; j++){
				if(t[i][j]==0){
					g.setColor(Color.black);
					g.fillRect(x, y, (int)(600/t[0].length) ,(int)(600/t.length) );
					g.setColor(Color.WHITE);
					g.fillRect(x, y, (int)(600/t[0].length)-5,(int)(600/t.length)-5);
				}
				if(t[i][j]==1){
					g.setColor(Color.black);
					g.fillRect(x, y, (int)(600/t[0].length) ,(int)(600/t.length) );
					g.setColor(Color.red);
					g.fillRect(x, y, (int)(600/t[0].length)-5,(int)(600/t.length)-5);
				}
				if(t[i][j]==2){
					g.setColor(Color.black);
					g.fillRect(x, y, (int)(600/t[0].length) ,(int)(600/t.length) );
					g.setColor(Color.blue);
					g.fillRect(x, y, (int)(600/t[0].length)-5,(int)(600/t.length)-5);
				}	
				if(t[i][j]==3){
					g.setColor(Color.black);
					g.fillOval(x, y, (int)(600/t[0].length) ,(int)(600/t.length) );
					g.setColor(Color.yellow);
					g.fillOval(x, y, (int)(600/t[0].length)-5,(int)(600/t.length)-5);
				}
				x = x + (int)(600/t[0].length) ;
			}
			 x = 0;
			    y = y + (int)(600/t.length) ;
		}
		x=y=0;
	}
	
	
	public void paint(Graphics g){
		affiche(g);
	}
}
