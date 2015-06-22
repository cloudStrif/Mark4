import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Application2 extends JPanel{
	public int [][] t = new int[20][20] ;
	public int x  = 0 ;
	public int y = 0 ;
	
	public int [][] ve = new int [20][20] ;
	
	public int voisins = 0 ;

	Font police = new Font("Arial", Font.BOLD, 15);
	public boolean confirm = false ;
	
	public int [] tab  = new int [2];
	public int c = 0 ;
	
	public int rr  = 0 ;
	
	
	public boolean trace  = false ;
	
	
	public Application2(){
		//Grenouille
	/*	t[10][8] = 1 ;
		t[10][9] = 1 ;
		t[11][9] = 1 ;
		t[11][8] = 1 ;
		t[10][7] =1;
		t[11][10] = 1 ;
		*/
		
		//vaisceau
		/*t[10][10] = 1 ;
		t[11][10] = 1 ;
		t[12][10] = 1 ;
		t[12][9] = 1 ;
		t[11][8] = 1 ;
		*/
		
	/*	t[9][9] = 1 ;
		t[9][10] = 1 ;
		t[9][11] = 1 ;
		t[10][10] = 1 ;
		t[10][8] = 1 ;
		t[10][12] = 1 ;
		t[11][9] = 1 ;
		t[11][10] = 1 ;
		t[11][11] = 1 ;
		*/
		
		this.addMouseListener(new MouseAdapter(){
		      public void mousePressed(MouseEvent e){
		    	  t[(int)(e.getY()/(400/20))][(int)(e.getX()/(400/20))] = 1 ;
		    	  repaint();
		    	  
		      }
		    });

		    this.addMouseMotionListener(new MouseMotionListener(){
		      public void mouseDragged(MouseEvent e) {
		      }

		      public void mouseMoved(MouseEvent e) {}
		    });
		
	}
	
	public void affiche(int [][] t , Graphics g)
	{
	
		
		for(int i = 0 ; i< t.length ; i ++){
			for(int j = 0 ; j < t[0].length ; j++){
				if(t[i][j] == 0){
				g.setColor(Color.black) ;
				g.fillRect(x,y,30,30);
				g.setColor(Color.white);
				g.fillRect(x,y,17,17);
				}
				if(t[i][j] == 1){
					g.setColor(Color.black) ;
					g.fillRect(x,y,30,30);
					g.setColor(Color.blue);
					g.fillRect(x,y,17,17);	
					g.setColor(Color.black) ;
					g.setFont(police);
					g.drawString("P",x,y);
				}
				
				x = x + 20;
				
				
			}
			x = 0 ;
			y = y + 20 ;
		}
		x = y = 0 ;
	}
	
	public void R(){

		
		
		for(int i = 0 ; i < 20 ; i++){
			for(int j = 0 ; j<20 ; j++){
				confirm = false ;
				
				if(i == 0 && j == 0 && confirm == false){
					tab[0] = i ;
					tab[1] = j ;
					for(int k =  0 ; k < 2 ;  k ++) {
						for(int h = 0 ; h < 2 ; h ++){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							if(t[k][h] == 1 && k == 0 && h == 0){
								voisins =voisins - 1 ;
							}
							
						}
					}
					confirm = true ;eval() ;
				}
				if(i == 0 && j == 19 && confirm == false){
					tab[0] = i ;
					tab[1] = j ;
					for(int k = 0 ; k < 1 ; k ++ ){
						for(int h = 18 ; h < 20 ; h++){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							if(t[k][h] == 1 && h == 0 && k == 19){
								voisins --  ;
							}
						}
					}
					confirm = true ;eval() ;
				}
				
				if(i == 19 && j == 0 && confirm == false){
					tab[0] = i ;
					tab[1] = j ;
					for(int k = 18 ; k < 20 ; k ++ ){
						for(int h = 0 ; h < 2 ; h++){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							if(t[k][h] == 1 && h == 0  && k == 19)
							{
								voisins -- ;
							}
							
							
							
						}
					}
					confirm = true ;eval() ;
				}
				if(i == 19 && j == 19  && confirm == false ){
					tab[0] = i ;
					tab[1] = j ;
					for(int k = 18 ; k < 20 ; k ++ ){
						for(int h = 18 ; h < 20 ; h++){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							
							if(t[k][h] == 1 && h == 19 && k == 19){
								voisins  -- ;
							}
							
						}
					}
					confirm = true ;eval() ;
				}
				if(i == 0 && confirm ==false ){
					tab[0] = i ;
					tab[1] = j ;
					for(int k = 0 ; k < 2 ; k++){
						for(int h = j - 1 ; h < j+2 ; h++){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							  if(t[k][h] == 1  && k == i && h == j){
							    
										voisins  = voisins - 1  ;
										
								 }
							
							
						}
					}
					confirm = true ;eval() ;
				}
				// Completer 
				
				if(i == 19 && confirm == false){
					tab[0] = i ;
					tab[1] = j ;
					for(int k = 18 ; k < 20 ; k++){
						for(int h =  j - 1 ; h < j+2 ; h++ ){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							if(t[k][h] == 1 && h == j  && k == i){
								voisins -- ;
							}
							
						}
					}
					confirm = true ;eval() ;
				}
				
				//Errata
				if(j ==  0 && confirm == false){
					tab[0] = i ;
					tab[1] = j ;
					for(int k = i -1 ; k < i+2 ; k++){
						for(int h =  0 ; h < 2 ; h++ ){
							if(t[k][h] == 1 ){
								voisins ++ ;
							}
							if(t[k][h] == 1 && h == j  && k == i){
								voisins -- ;
							}
						}
					}
					confirm = true ;
					eval() ;
				}
				
				if(j == 19 && confirm == false){
					tab[0] = i ;
					tab[1] = j ;
				for(int k = i-1 ; k < i+2 ; k ++){
					for(int h = 18 ; h< 20 ; h++){
						if(t[k][h] == 1 ){
							voisins ++ ;
						}
						if(t[k][h] == 1 && h != j  && k != i){
							voisins -- ;
						}
						
						
					}
				}
				confirm = true ;
				eval() ;
				}
				
				if(confirm == false ){
					//rr ++ ;
					//System.out.print(rr + "   ");
					
					tab[0] = i ;
					tab[1] = j ;
					for(int k = i-1 ; k < i+2 ; k++){
						for(int h = j -1 ; h < j+2 ; h ++){
						//	System.out.println(" k = " + k + "h =" + h);
							//System.out.println(" i = " + i+ "  j = " + j);
							  if(t[k][h] == 1 ){
							    	// System.out.println("Je suis de retour !!");
										//trace = true ;
										voisins  = voisins + 1  ;
									
								 }
									
							
					     if(t[k][h] == 1  && k == i && h == j){
					    	// System.out.println("Je suis de retour !!");
								//trace = true ;
								voisins  = voisins - 1  ;
								
						 }
							
						
						}
					}
					eval() ;
					confirm = true ;
				}
				
				
				
			}
			
		}
	}
	
	
	public void eval (){
	 	
	 
	/* if(trace == true){
		 voisins -- ;
		 trace = false ; 
	 } */
		switch(voisins){
		case 3 : ve[tab[0]][tab[1]] = 1 ;
		break ;
		case 2 : ve[tab[0]][tab[1]] = t[tab[0]][tab[1]] ;
		break ;
		default :ve[tab[0]][tab[1]] = 0  ;
		}
		//System.out.println("voisins = " + this.voisins + "    tab[0] =  " + tab[0] + "    tab[1] = " + tab[1]);
		
		voisins = 0 ;
	}
	
	public void thor(){
		//System.out.println("DEBUT");
		for(int  i = 0 ; i < 20 ; i++){
			for(int j = 0 ; j< 20 ; j++){
				System.out.print(t[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println("THEN");
		System.out.println();
		for(int  i = 0 ; i < 20 ; i++){
			for(int j = 0 ; j< 20 ; j++){
				System.out.print(ve[i][j]);
			}
		System.out.println();
		}
	}
	
	public void remet(){
		for(int i = 0 ; i < 20 ; i ++){
			for(int j = 0 ; j < 20 ; j++){
				t[i][j] = ve[i][j] ;
			}
		}
	}

	
	public void paintComponent(Graphics g){
		
		
		c ++ ;
		affiche(t,g);
	
		//if(c == 1){
		R() ;
	//	thor() ;
		
		//}
		
		
		
	}
}




