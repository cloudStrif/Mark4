

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class M2 extends JPanel{
    public int [][] t = {{2,3,4},
    		             {5,6,7},
    		             {8,9,10}};
    
	public int x =0 ;
	public int y = 0 ;
	public boolean tour = true ;
	
	public int bleu = 0 ;
	public int rouge = 0 ;
	
	public M2(){
		   this.addMouseListener(new MouseAdapter(){
			      public void mousePressed(MouseEvent e){
			    	  if(tour){
			      t[(int)(e.getY()/(300/3))][(int)(e.getX()/(300/3))] = 1 ; 
			      System.out.println((int)(e.getY()/(325/3)));
			       repaint() ;
			       tour  = false ;
			    	  }else {
			    		  t[(int)(e.getY()/(300/3))][(int)(e.getX()/(300/3))] = -1 ; 
					     
					       repaint() ; 
					       tour  = true ;
			    	  }
			      }
			    });

			    this.addMouseMotionListener(new MouseMotionListener(){
			      public void mouseDragged(MouseEvent e) {
			       
			      }

			      public void mouseMoved(MouseEvent e) {
			    	  System.out.println(e.getX());
			      }
			    });
	
	
	
	}
	
	public boolean verif2(int[][]t){
		for(int i = 0 ; i< t.length ; i++){
			for(int j = 0 ; j < t[0].length ;j++){
				if(t[i][j]!=0){
					return false ;
				}
			}
		}
		return true ;
	}
	
	
	
	public boolean verif (int [][] t){
	//if(verif2(t) == false    ){
		if(t[0][0] == t[0][1] && t[0][1] == t[0][2]){
			 
		return true ;
		}
		if(t[1][0] == t[1][1] && t[1][1] == t[1][2]){
			
			return true ;
		}
		if(t[2][0] == t[2][1] && t[2][1] == t[2][2]){
			
			return true ;
		}
		if(t[0][0] == t[1][0] && t[1][0] == t[2][0]){
			
			return true ;
		}	
		if(t[0][1] == t[1][1] && t[1][1] == t[2][1]){
			
			return true ;
		}	
		if(t[0][2] == t[1][2] && t[1][2] == t[2][2]){
			
			return true ;
		}	
		if(t[0][0] == t[1][1] && t[1][1] == t[2][2]){
			
			return true ;
		}
		if(t[0][2] == t[1][1] && t[1][1] == t[2][0]){
			
			return true ;
		}
		
		return false ;
	//}
	

	}
	public void affiche(int [][]t ,Graphics g){
	for(int i = 0 ;i < t.length ; i++){
		for(int j = 0 ; j< t[0].length ; j++){
			
			if(t[i][j] == 1){
				g.setColor(Color.blue);
				g.drawLine(x, y, x+100, y+100);
				g.drawLine(x, y+100, x+100, y);
			}
			if(t[i][j] == -1){
				g.setColor(Color.red);
				g.drawLine(x, y, x+100, y+100);
				g.drawLine(x, y+100, x+100, y);
				
			}
			
			x = x + 100;
		}
		x = 0 ;
		y = y + 100 ;
	}
	
	x = y =0 ;
	}
	
	public void paintComponent(Graphics g){
		
	
		
		
			g.setColor(Color.white);
			
			/*g.fillRect(0,0,500,500);
			g.setColor(new Color(206,206,206));
			g.fillRect(230, 80, 110, 130);*/
			g.setColor(Color.black);
			g.drawLine(100, 0, 100, 300);
			g.drawLine(200, 0, 200, 300);
			g.drawLine(0, 100, 300, 100);
			g.drawLine(0, 200, 300, 200);
			
			
			affiche(t,g) ;
			
			if(verif(t)){
				if(tour){
					tour = false ;
					System.out.println("bravo " + tour );
					g.setColor(Color.red);
					 g.setFont(new Font("Arial", Font.BOLD, 20));
					 
					 g.drawString("Bravo ,Tu as gagn� , croix rouge ! ", 5, 150);
					 rouge ++ ;
				}else{
					tour = true ;
					System.out.println("bravo " + tour );
					g.setColor(Color.blue);
					 g.setFont(new Font("Arial", Font.BOLD, 20));
					 
					 g.drawString("Bravo ,Tu as gagn� , croix bleu ! ", 5, 150);
					 bleu ++ ;
				}
			}
			
		
	 
		
	}
	
}
