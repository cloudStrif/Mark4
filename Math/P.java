
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
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/* interaction classe*/

public class P extends JPanel{
    public boolean tour = true ;
    public int cl = 0 ;
    public int [][] c = {{1,2,3,4,5,3,2,1},
			 {6,6,6,6,6,6,6,6},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},                  
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {-6,-6,-6,-6,-6,-6,-6,-6},
			 {-1,-2,-3,-4,-5,-3,-2,-1}};
    
    public int [][] c2 = {{1,2,3,4,5,3,2,1},
			  {6,6,6,6,6,6,6,6},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},                  
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {-6,-6,-6,-6,-6,-6,-6,-6},
			  {-1,-2,-3,-4,-5,-3,-2,-1}};
    
    public boolean [][] chu = new boolean [8][8];
    public boolean [][] pions = new boolean[2][8];
    
    public boolean [][] chess2 = new boolean [8][8];
	
    public int ii = 0 ;
    public int jj = 0 ;
    
    public String str = "Blancs" ;
    
    public boolean actionFait = false ;
    
    public int x  = 0 ;
    public int y  = 0 ;
    /*position du curseur */
    public int xx = 0 ;
    public int yy = 0 ;
    public int [] pos = {2,2} ;
    public int [] pos2 = {0 ,0} ;
    
    public boolean ia = false ; 
    
    
    public boolean choix = false ;
    
    
    public boolean test = false ;
    
    public boolean bool = false ;
    public int couleur = 0 ;
    
    public ArrayList<Integer> X = new ArrayList<Integer>() ;
    public ArrayList<Integer> Y = new ArrayList<Integer> () ;	
    public ArrayList<Integer> Xp = new ArrayList<Integer>() ;
    public ArrayList<Integer> Yp = new ArrayList<Integer> () ;
    
    
    public P(){
	this.addMouseListener(new MouseAdapter(){
		
		
		public boolean verif(int a){ // grade de la piece 
		    
		    if(pos2[0] == pos[0] || pos2[1] == pos[1]){
			
			
			if(pos[0] == pos2[0] && pos[1] < pos2[1]) {// faux
			    System.out.println("je suis faux : ");
			    
			    for(int i = pos[1] +1; i <= pos2[1] ; i++){
				System.out.println(c[i][pos[1]]);
				if(a >0){
				    if(c[pos[0]][i] >0){
					
					return false ;
				    }
				}else if(a<0){
				    if(c[pos[0]][i] <0){
					
					return false ;
				    }
				    
				}
				
			    }
			}
			else if(pos[0] == pos2[0] && pos[1] > pos2[1]) {
			    System.out.println("1111");
			    for(int i = pos[1] -1; i >= pos2[1] ; i--){   //faux
				if(a>0){
				    if(c[pos[0]][i] >0){
					
					return false ;
				    }
				}else if(a<0){
				    if(c[pos[0]][i] <0){
					
					return false ;
				    }
				}
			    }
			}
			
			else if(pos[1] == pos2[1] && pos[0] < pos2[0]){
			    System.out.println("2");
			    for(int i = pos[0] ; i <= pos2[0] ; i ++){
				System.out.println("je suis la" + c[i][pos[1]]);
				if(a>0){
				    if(c[i][pos[1]] >0 && c[i][pos[1]] != a){
					return false ;
				    }
				}else if(a<0){
				    if(c[i][pos[1]] <0 && c[i][pos[1]] != a){
					return false ;
				    }
				}
			    }
			}
			else if(pos[1] == pos2[1] && pos[0] > pos2[0]){
			    System.out.println("3");
			    for(int i = pos[0] ; i > pos2[0]-1 ; i --){
				System.out.println("je suis laa" + c[i][pos[1]]);
				if(a>0){
				    if(c[i][pos[1]] >0 && c[i][pos[1]] != a){
					return false ;
				    }
				}else if(a<0){
				    if(c[i][pos[1]] <0 && c[i][pos[1]] != a){
					return false ;
				    }
				}
			    }
			}
		    }else { 
			return false ;
		    }
		    return true ;
		} 
		
		
		// Bishop
		public boolean verif2(int a ){
		    // Verification for bishop move				   
		    if(pos[0] >pos2[0] && pos[1] > pos2[1]){
			if(Math.abs(pos[1]-pos2[1]) == Math.abs(pos[0] - pos2[0])){
			    for(int i = pos[0],j= pos[1] ; (i>=pos2[0] && j >= pos2[1]) ; i--,j--){
				System.out.println(c[i][j]+ "  j " + i+"   "+ j);
				if(a>0){
				    if(c[i][j] > 0 && c[i][j] != a){
					return false  ; 
				    }
				}
				else{
				    if(c[i][j] < 0 && c[i][j] != a){
					return false  ; 
				    }
				}
				
			    }
			    return true ;
			    
			}
			else {
			    return false ;
			}
			
			
			
		    }
		    
		    if(pos[0] >pos2[0] && pos[1] < pos2[1]){ // Faux 
			if(Math.abs(pos[1]-pos2[1]) == Math.abs(pos2[0] - pos[0])){
			    for(int i = pos[0],j= pos[1] ; (i>=pos2[0] && j <= pos2[1]) ; i--,j++){
				System.out.println(c[i][j]+ "   " + i+"   "+ j);
				if(a>0){
				    
				    if(c[i][j] > 0 && c[i][j] != a){
					System.out.println("here");
					return false  ; 
				    }
				}else {
				    if(c[i][j] < 0 && c[i][j] != a){
					System.out.println("here");
					return false  ; 
				    }  
				}
			    }
			    return true ;
			    
			}
			else {
			    return false ;
			}
			
		    }
		    
		    if(pos[0] <pos2[0] && pos[1] > pos2[1]){
			if(Math.abs(pos2[0]) - Math.abs(pos[0]) == Math.abs(pos[1])-Math.abs(pos2[1])){
			    for(int i = pos[0] , j = pos[1] ;(i <= pos2[0] && j >= pos2[1]) ; i++,j--){
				if(a>0){
				    if(c[i][j] > 0 && c[i][j] != a){
					System.out.println("here");
					return false  ; 
				    }
				}else {
				    if(c[i][j] < 0 && c[i][j] != a){
					System.out.println("here");
					return false  ; 
				    }  
				}
			    }
			    return true ;
			    
			}else {return false ; }
			
		    }
		    
		    if(pos[0] <pos2[0] && pos[1] < pos2[1]){
			if(Math.abs(pos2[0]) - Math.abs(pos[0]) == Math.abs(pos2[1])-Math.abs(pos[1])){
			    for(int i = pos[0] , j = pos[1] ;(i <= pos2[0] && j <= pos2[1]) ; i++,j++){
				if(a>0){
				    if(c[i][j] > 0 && c[i][j] != a){
					System.out.println("here");
					return false  ; 
				    }
				}else {
				    if(c[i][j] < 0 && c[i][j] != a){
					System.out.println("here");
					return false  ; 
				    }
				}
			    }
			    return true ;
			    
			    
			}else {return false ; }
			
		    }
		    
		    
		    return false  ;
		    
		    
		}
		//Knight
		public boolean verif3(){
				   if(Math.abs(pos[0] - pos2[0]) == 1){
				       if(Math.abs(pos[1]- pos2[1]) == 2){
					   return true ;
				       } 
				   }
				   if(Math.abs(pos[1]- pos2[1]) == 1){
				       if(Math.abs(pos[0]- pos2[0]) == 2){
					   return true ;
				       } 
				   }
				   
				   return false ;
		}
		
		public  boolean gagne (boolean tr){
				  for(int i = 0 ;i < 8 ; i++){
				      for(int  j = 0 ; j < 8 ; j++){
					  if(tr){
					      if(c[i][j] == 5){
						  return false ;
					      }
					  }else {
					      if(c[i][j] == -5){
						  return false ;
					      } 
					  }
				      }
				  }
				  return true ;
		}
		
		
		
		
			   public void Listage (int [][] t){
			       int [] mini = new int [4] ;
			       for(int i = 0 ; i < t.length ; i++){
				   for(int j = 0 ; j < t[0].length ; j++){
				       if(t[i][j] == 1){
					   sortpas(i,j,mini);
						      for(int ii = 0 ; ii < mini.length ; ii ++ ){
						    	  if(mini[ii] == 1){
							      T(ii) ; 
						    	  }
						      }
						      
				       }
				   }
			       }
			       
			   }
		public void sortpas(int i , int  j,int [] mini){
		    if(j-1 <0){
			mini [2] = - 1 ;
		    }else {
			mini[2] = 1 ;
		    }
		    if(j+1 > 7){
			mini[0] = -1 ;
				   }else {
			mini[0] = 1 ;
		    }
		    if(i-1 < 0){
			mini[3] = -1 ;
		    }else {
			mini[3] = 1 ;
		    }
		    if(i+1>7){
			mini[1] = -1 ;
				   }else {
			mini[1] = 1 ;
		    }
		    
		}
		
		
		public void T(int g){
		    //droite
		    if(g == 0){
			for(int i = pos [1] ; i < 8 ; i ++){
			    X.add(i);
			    Y.add(pos[0]);
			    Xp.add(pos[1]);
			    Yp.add(pos[0]);
			    if(c[pos[0]][i]>0){
				break ;
			    }
			}
			
		    }
		    if(g == 1 ){
			for(int i = pos[0] ; i < 8 ; i ++){
			    Xp.add(pos[1]);
			    Yp.add(pos[0]);
			    X.add(pos[1]);
			    Y.add(i);
			    if(c[i][pos[1]]>0){
				break ;
			    }
			    
			}
			
		    }
		    if(g == 2){
			for(int i = pos[1] ; i > 0 ; i--){
			    Xp.add(pos[1]);
			    Yp.add(pos[0]);
			    X.add(i);
			    Y.add(pos[0]);
			    if(c[pos[0]][i]>0){
				break ;
			    }
			}
		    }
		    if(g == 3){
			for(int i = pos[0] ; i > 0 ; i -- ){
			    Xp.add(pos[1]);
			    Yp.add(pos[0]);
			    X.add(pos[1]) ;
			    Y.add(i);
			    if(c[i][pos[1]]>0){
				break ;
			    }
			}
		    }
		    
				   
		}
		
		
		public void mousePressed(MouseEvent e){
		    
		    int aa = 0 ;int aaa = 0 ;
		    int bb = 45 ;int bbb = 45 ;
		        	
		    for(int iii = 0 ; iii < 8 ; iii++){
			for(int jjj = 0 ; jjj < 8 ; jjj++){
			    if(e.getX() >= aa && e.getX() <= bb && e.getY() >= aaa && e.getY() <= bbb){
				if(!bool){
				    pos[0] = iii;
				    pos[1] = jjj ;
				    chu [iii][jjj] = true ;
				    
                			 
				    
				    repaint();
				    bool = true ; 
				}else {
				    pos2[0] = iii;
				    pos2[1] = jjj;
				    
				    
				    
				    
				    if(tour == true){
					// 0 = blancs
					//pion
					if(!pions[0][pos[1]]){
					    if(c[pos[0]][pos[1]] == -6 && (pos2[0] == pos[0] - 1 && pos2[1]==pos[1]|| pos2[0] == pos[0] - 2 && pos2[1]==pos[1]) && c[pos2[0]][pos2[1]] == 0 ){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = -6 ;
						pions[0][pos[1]] = true ;
						repaint() ;
						actionFait = true ;
					    }
					}
                    			
					if(c[pos[0]][pos[1]] == -6 && pos2[0] == pos[0] - 1 && pos2[1]==pos[1] && c[pos2[0]][pos2[1]] == 0 ){
					    c[pos[0]][pos[1]] = 0 ;
					    c[pos2[0]][pos2[1]] = -6 ;
					    pions[0][pos[1]] = true ;
					    
					    repaint() ;
					    actionFait = true ;
					}
					
                    			
                    			
                    			
					if(c[pos[0]][pos[1]] == -6){
					    System.out.println(c[pos[0]-1][pos[1]+1]);
					    if(c[pos[0]-1][pos[1]+1]>0 || c[pos[0]-1][pos[1]-1]>0 ){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = -6 ;
						System.out.println("fermat");
						repaint() ;
						actionFait = true ;
					    }
					}
                    			
					
					//tour
					if(c[pos[0]][pos[1]] == -1){
					    // if(pos2[0] == pos[0] || pos2[1] == pos[1]){
					    if(/*c[pos2[0]][pos2[1]] <= 0 &&*/ verif(-1) == true){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = -1 ;
						repaint() ;
						actionFait = true ;
					    }
					    //}
					}
                    			
					//le fou : bishop 
					if(c[pos[0]][pos[1]] == -3){
					    if(verif2(-3)){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = -3 ;
						repaint() ;
						actionFait = true ;
					    }
					}
                    			
                    			
					// and then the Queen 
					if(c[pos[0]][pos[1]] == -4){
					    //	 System.out.println("the Queen");
					    if(verif(-4)== true || verif2(-4) == true){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = -4 ;
						repaint() ;
						actionFait = true ;
					    }
					    
					    
                    				 }
					//King
                    			
					if(c[pos[0]][pos[1]] == -5){
					    if(Math.abs(pos[0] - pos2[0]) == 1 || Math.abs(pos[1]-pos2[1]) == 1){
						if(c[pos2[0]][pos2[1]] >= 0){
						    
						    
						    c[pos[0]][pos[1]] = 0 ;
						    c[pos2[0]][pos2[1]] = -5 ;
						    repaint() ;
						    actionFait = true ;
						}
					    }
					}
                    			
					//Shikamaru 
					if(c[pos[0]][pos[1]] == -2){
					    if(verif3() == true && c[pos2[0]][pos2[1]] >= 0){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = -2;
						repaint() ;
						actionFait = true ;
					    }
					}
                    			
                    			
					if(actionFait){ 
					    tour = false  ;
					    str = "Noirs " ;
					    if(gagne(tour)){
						JOptionPane boite  = new JOptionPane() ;
						boite.showMessageDialog(null ,"Victoire des Noirs !!" ,"Victoire !", JOptionPane.INFORMATION_MESSAGE);
					    }
                                 }
                    			
                    			
                    			
				    }else if(tour == false && ia == false){
					//pion
                    			
					if(!pions[1][pos[1]]){
					    if(c[pos[0]][pos[1]] == 6 && (pos2[0] == pos[0] + 1 && pos2[1]==pos[1]|| pos2[0] == pos[0] + 2 && pos2[1]==pos[1]) && c[pos2[0]][pos2[1]] == 0 ){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = 6 ;
						pions[1][pos[1]] = true ;
						repaint() ;
                    						actionFait = false ;
					    }
					}
					if(c[pos[0]][pos[1]] == 6 && pos2[0] == pos[0] + 1 && pos2[1]==pos[1] && c[pos2[0]][pos2[1]] == 0 ){
					    c[pos[0]][pos[1]] = 0 ;
					    c[pos2[0]][pos2[1]] = 6 ;
					    pions[1][pos[1]] = true ;
					    repaint() ;
					    actionFait = false ;
					}
                    					
                    			
                    			
                    			
                    			
					if(c[pos[0]][pos[1]] == 6){
					    if(c[pos[0]+1][pos[1]+1]<0 || c[pos[0]+1][pos[1]-1]<0 ){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = 6 ;
						repaint() ;
						actionFait = false ;
					    }
					}
                    			
					
					//tour
					if(c[pos[0]][pos[1]] == 1){
					    // if(pos2[0] == pos[0] || pos2[1] == pos[1]){
					    if(/*c[pos2[0]][pos2[1]] <= 0 &&*/ verif(1) == true){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = 1 ;
						repaint() ;
						actionFait = false ;
					    }
					    //}
					}
                    			
					//le fou : bishop 
					if(c[pos[0]][pos[1]] == 3){
					    if(verif2(3)){
						c[pos[0]][pos[1]] = 0 ;
                    						c[pos2[0]][pos2[1]] = 3 ;
                    						repaint() ;
                    						actionFait = false ;
					    }
					}
                    			
                    			
					// and then the Queen 
					if(c[pos[0]][pos[1]] == 4){
					    //	 System.out.println("the Queen");
					    if(verif(4)== true || verif2(4) == true){
						c[pos[0]][pos[1]] = 0 ;
						c[pos2[0]][pos2[1]] = 4 ;
						repaint() ;
						actionFait = false ;
					    }
					    
					}
					//King
                    			
                    				 if(c[pos[0]][pos[1]] == 5){
						     if(Math.abs(pos[0] - pos2[0]) == 1 || Math.abs(pos[1]-pos2[1]) == 1){
							 if(c[pos2[0]][pos2[1]] <= 0){
							     
							     
							     c[pos[0]][pos[1]] = 0 ;
							     c[pos2[0]][pos2[1]] = 5 ;
							     repaint() ;
							     actionFait = false ;
							 }
						     }
                    				 }
                    				 
                    				 //Shikamaru 
                    				 if(c[pos[0]][pos[1]] == 2){
						     if(verif3() == true && c[pos2[0]][pos2[1]] <= 0){
							 c[pos[0]][pos[1]] = 0 ;
							 c[pos2[0]][pos2[1]] = 2;
							 repaint() ;
							 actionFait = false ;
						     }
                    				 }
                    				 
                    				 if(!actionFait){
						     tour = true ;
						     if (gagne(tour)){
                    					 JOptionPane boite  = new JOptionPane() ;
                    					 boite.showMessageDialog(null ,"Victoire des blancs !!" ,"Victoire !", JOptionPane.INFORMATION_MESSAGE);
						     }
						     str = "Blancs" ;
						     
						     
                    				 }
						 
                    				 
				    }
				    // l'intelligence artificiel est ici 
				    else if(tour == false && ia == true){
					//listage 
                    			
                    			
                    			
                    				 System.out.println("stax");
                    				 tour = true ; 
                    				 
                    				 str = "Blancs" ;
                    				 
                    				 
				    }
				    
				    
				    
				    bool = false ; 
				}
                		 }
			    aa = aa+ 45 ;
			    bb = bb +45 ;
			    
			}
			aa = 0 ;
			bb = 45 ;
			aaa = aaa+ 45 ;
			bbb = bbb + 45 ;
		    }
		    
		    System.out.println(pos[0] + " nihao " + pos[1]);
		    System.out.println(pos2[0] + " hapouha  " + pos2[1]);
		}
		    });
	
	this.addMouseMotionListener(new MouseMotionListener(){
		public void mouseDragged(MouseEvent e) {
		    
		}
		
		public void mouseMoved(MouseEvent e) {
		    
		    chess2[(int)(e.getY()/(370/8))][(int)(e.getX()/(370/8))] = true ;
		    repaint() ;
		        }
	    });
	
    }
    
    public boolean dking2(int [][] t){
	for(int i = 0 ; i< t.length ; i++){
	    for(int j = 0 ; j <t[0].length ;j++){
		if(c[i][j] == -5){
		    return false ;
		}
		
	    }
	}
	return true ;
	
    }
    
    
    
    
    public boolean dking(int [][] t){
	for(int i = 0 ; i< t.length ; i++){
	    for(int j = 0 ; j <t[0].length ;j++){
		if(c[i][j] == 5){
		    return false ;
		}
		
	    }
	}
	return true ;
	
    }
    public void erase (){
	for(int i = 0 ; i < 8 ;i++){
	    for(int j = 0 ; j < 8 ;j++){
				chess2[i][j] = false ;
	    }
	}
	
    }
    public void affiche(Graphics g){
	//Image i = ImageIO.read(new File("images/BlackBishop.png"));
	//Fonction d'affichage de base
	// g.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);
	
	g.setColor(Color.white);
	g.fillRect(260,355 ,130 ,70);
		
	for(int i = 0 ; i < c.length ; i++){
	    for(int j = 0 ; j < c[0].length ; j++){
		if(i % 2 == 0 ) {
				if(j % 2 == 0){
				    if(couleur == 0){
					g.setColor(Color.black);
				    }
				    if(couleur == 1)
					g.setColor(new Color(0, 86, 27));
				    if(couleur == 2){
					g.setColor(new Color(200, 173, 127));}
				    g.fillRect(x, y, 50, 50);
				}else {
				    if(couleur == 0 ){
					g.setColor(Color.white);
				    }
				    if(couleur == 1){
					g.setColor(new Color(1, 215, 88));
				    }
				    if(couleur == 2){
					g.setColor(new Color(167, 103, 38)) ;}
				    g.fillRect(x, y, 50, 50);	
				}
				
		}else{
		    if(j % 2 == 0){
			if(couleur == 0  ){
			    g.setColor(Color.white);
			}
			if (couleur == 1){
			    g.setColor(new Color(1, 215, 88));
				}
			if (couleur == 2){
			    g.setColor(new Color(167, 103, 38)) ;}
			g.fillRect(x, y, 50, 50);
		    }else {
			if(couleur == 0 ){
			    g.setColor(Color.black);
			}
			if(couleur == 1){
						g.setColor(new Color(0, 86, 27));
			}
			if(couleur == 2){
			    g.setColor(new Color(200, 173, 127));
			}
					g.fillRect(x, y, 50, 50);	
		    }
		}
		
		if(c[i][j] >0){
		    g.setColor(Color.black);
		}
		if(c[i][j]<0) {
		    g.setColor(Color.blue);
		}
		
		
		if(chu[i][j]){
		    g.setColor(Color.blue);
		    g.drawLine(x,y,x+45,y);
		    g.drawLine(x,y,x,y+45);
		    chu[i][j] = false ;
		}
		
		if(chess2[i][j]){
		    g.setColor(Color.cyan);
		    g.fillRect(x,y,50,50);
		}
		
		
			if(c[i][j] == 6){
			    //Image w = ImageIO.read(new File("images/BlackPawn.png"));
			    ImageIcon imageIcon = new ImageIcon("images/BlackPawn.png");
			    Image w = imageIcon.getImage();  
			    
			    g.drawImage(w,x,y,50,50,this);
			    
			    if(c[pos[0]][pos[1]]==6){
				g.drawString("Pion Noir", 260, 365+18);
				
			    }
			}
			
			if(c[i][j] == -6){
			    //	Image w = ImageIO.read(new File("images/WhitePawn.png"));
				
			    ImageIcon imageIcon = new ImageIcon("images/WhitePawn.png");
			    Image w = imageIcon.getImage(); 
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]==-6){
				g.drawString("Pion Blanc", 260, 365+18);
				
			    }
			}
			
			if(c[i][j] == 1){
			    
			    //Image w = ImageIO.read(new File("images/BlackTower.png"));
			    ImageIcon imageIcon = new ImageIcon("images/BlackTower.png");
			    Image w = imageIcon.getImage(); 
			    
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]==1){
				    g.drawString("Tour Noir", 260, 365+18);
				    
			    }
			}
			
			if(c[i][j] == 2){
			    
			    
			    //	Image w = ImageIO.read(new File("images/BlackKnight.png"));
			    ImageIcon imageIcon = new ImageIcon("images/BlackKnight.png");
			    Image w = imageIcon.getImage();    
			    g.drawImage(w,x,y,50,50,this);
				   	
			    if(c[pos[0]][pos[1]]==2){
				g.drawString("Cavalier Noir", 250, 365+18);
				
			    }
			    
			}
			if(c[i][j] == 3){
		
			    //Image w = ImageIO.read(new File("images/Blackbishop.png"));
			    ImageIcon imageIcon = new ImageIcon("images/BlackBishop.png");
			    Image w = imageIcon.getImage();   
			    g.drawImage(w,x,y,50,50,this);
			    
			    if(c[pos[0]][pos[1]]==3){
				g.drawString("fou Noir", 260, 365+18);
				
			    }
			    
			}
			if(c[i][j] == 4){
			    
			    //Image w = ImageIO.read(new File("images/BlackQueen.png"));
			    ImageIcon imageIcon = new ImageIcon("images/BlackQueen.png");
			    Image w = imageIcon.getImage();   
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]==4){
				g.drawString("Reine Noir", 260, 365+18);
				
			    }
			}
			if(c[i][j] == 5){
				
			    //		Image w = ImageIO.read(new File("images/BlackKing.png"));
			    ImageIcon imageIcon = new ImageIcon("images/BlackKing.png");
			    Image w = imageIcon.getImage(); 
			    
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]==5){
				g.drawString("Roi Noir", 260, 365+18);
				
			    }
			}
			
			
			
			
			if(c[i][j] == -1){
			    
			    
			    //Image w = ImageIO.read(new File("images/WhiteTower.png"));
			    
			    ImageIcon imageIcon = new ImageIcon("images/WhiteTower.png");
			    Image w = imageIcon.getImage(); 
				  
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]==-1){
				g.drawString("Tour blanc", 260, 365+18);
				
			    }
			}
			
			if(c[i][j] == -2){
			    
			    
			    //Image w = ImageIO.read(new File("images/WhiteKnight.png"));
				ImageIcon imageIcon = new ImageIcon("images/WhiteKnight.png");
				Image w = imageIcon.getImage();   
				
				g.drawImage(w,x,y,50,50,this);
				if(c[pos[0]][pos[1]]== -2){
				    g.drawString("Cavalier Blanc", 250, 365+18);
				    
				}
			}
			if(c[i][j] == -3){
			    
			    //	Image w = ImageIO.read(new File("images/Whitebishop.png"));
			    ImageIcon imageIcon = new ImageIcon("images/WhiteBishop.png");
			    Image w = imageIcon.getImage(); 
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]== -3){
				g.drawString("Fou blanche", 260, 365+18);
					   	
			    }
			}
			if(c[i][j] == -4){
			    
			    //	Image w = ImageIO.read(new File("images/WhiteQueen.png"));
			    ImageIcon imageIcon = new ImageIcon("images/WhiteQueen.png");
			    Image w = imageIcon.getImage(); 
			    
				g.drawImage(w,x,y,50,50,this);
				if(c[pos[0]][pos[1]]== -4){
				    g.drawString("Reine Blanc", 260, 365+18);
				    
				}
				}
			if(c[i][j] == -5){
			    
			    //	Image w = ImageIO.read(new File("images/WhiteKing.png"));
			    ImageIcon imageIcon = new ImageIcon("images/WhiteKing.png");
			    Image w = imageIcon.getImage(); 
				
			    g.drawImage(w,x,y,50,50,this);
			    if(c[pos[0]][pos[1]]== -5){
				g.drawString("Roi Blanc", 260, 365+18);
				
			    }
			}
			
			if(choix){
			    if(c[pos[0]][pos[1]] == 6){
				g.setColor(Color.red);
				g.fillRect(x ,y +45, 50, 50);
			    }
			    
			    choix = false ; 
			}
			
			x = x + 45;
			
			
	    }
	    x = 0 ;
	    y = y + 45 ;
	}
	//	x = y= 0 ;
	x = 0 ; y = 0 ;
	erase() ;
	
	g.setColor(Color.white);
	g.fillRect(178, 365+3,80 ,22 );
	
	g.setFont(new Font("Arial", Font.BOLD, 17));
	g.setColor(Color.red);

	g.drawString("C'est au tour des " + str + ":", 10, 365+18);
	
    }
    public void paintComponent(Graphics g){
	g.setColor(Color.white);
	g.fillRect(0,0,375,500);
	affiche(g);
	//5347 ancien code 
	
	
	
	//5011 apperement nouveau code
	//auto-l2se140037  Identifiant
	if(test){
	    g.setColor(Color.red);
	    g.fillRect(50, 50, 80, 80);
	}
    }
    
    
    
}
