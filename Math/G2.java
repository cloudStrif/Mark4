
import java.awt.Graphics;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.Stack ;


public class G2 extends JPanel {
    public int a = 38;
    public int b = 35 ;//position graphique 
    public boolean tes = false ;
    public int i = 0 ;//pour le tableau(position)
    public int j = 0 ; 
    public int [] pos = {-1,-1};//memoire de la 1ere position
    public int ef =0;
    public boolean tour = false ;
    public int [] nbblanc ={8,8,8,8}  ;
    public int push =0 ;
    public Stack<Integer> pd = new Stack<Integer> () ;//pour pos
    //public int [] ij = new int[2] ;
    //public int [] ll = new int[2] ;
          
     public Stack<Integer> pie = new Stack<Integer>() ;        
    public int a1 =0; // Variable Pour la pile de retour
    public int a2 =0 ;
     public int d1 =0;
    public int d2 =0 ;
    public Stack <Integer> pa = new Stack<Integer>() ;
    public int [][] t = {{1,2,1,2,1,2,1,2},  // jeu de base
			 {2,1,2,1,2,1,2,1},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {-1,-2,-1,-2,-1,-2,-1,-2},
			 {-2,-1,-2,-1,-2,-1,-2,-1}};
    
    boolean winB(int [][] t){  
	for(int i =0 ; i < t.length ;i++){
	    if(t[0][i] == -2  || t[0][i] == -1 || t[0][i] == -3 || t[0][i] == -4 || t[0][i] == -5 || t[0][i] == -6 || t[0][i] == -7 || t[0][i] == -8 || t[0][i] == -9){
		return true ;
	    }
	}
	return false ;
    
    }
    boolean winN(int [][] t){
	for(int i =0 ; i < t.length ;i++){
	    if(t[7][i] == 2  || t[7][i] == 1 || t[7][i] == 3 || t[7][i] == 4 || t[7][i] == 5 || t[7][i] == 6 || t[7][i] == 7 || t[7][i] == 8 || t[7][i] == 9){
		return true ;
	    }
	}
	return false ;        
	
    }       
    
    
    
    
    
    
    public void affiche(Graphics g,int [][] t){
	
	try {
	    // Image img = ImageIO.read(new File("logo2.jpeg"));
	    Image i = ImageIO.read(new File("images/gounki.png"));
	    //Fonction d'affichage de base
	    g.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);
	    int ii =-1 ;
	    int jj = -1 ;
	    
	    for(int y = 46 ; y < 320 ; y = y + 38){
		ii++ ;
		
		for(int x = 38 ; x < 370  ; x =x+ 45){
		    jj++;
		    
		    if(t[ii][jj] == 1){
			g.setColor(Color.black);
			g.fillRect(x-10,y-20,25,25); 
		    }
		    if(t[ii][jj] == 2){
			g.setColor(Color.black);
			g.fillOval(x-10,y-20,25,25); 
		    }
		    if(t[ii][jj] == -1){
			g.setColor(Color.white);
			g.fillRect(x-10,y-20,25,25); 
		    }     
		    if(t[ii][jj] == -2){
			g.setColor(Color.white);
			g.fillOval(x-10,y-20,25,25); 
		    }
		    if(t[ii][jj] == -3) //ceci est un test
			{
			    g.setColor(Color.white);
			    g.fillRect(x-10,y-20,25,25); 
			    g.setColor(Color.white);
			    g.fillRect(x-2,y-10,25,25);
			}
		    if(t[ii][jj] == 3) //ceci est un test
			{
			    g.setColor(Color.black);
			    g.fillRect(x-10,y-20,25,25); 
			    g.setColor(Color.black);
			    g.fillRect(x-2,y-10,25,25);
			}
		    if(t[ii][jj] == -4) //ceci est un test
			{
			    g.setColor(Color.white);
			    g.fillOval(x-10,y-20,25,25); 
			    g.setColor(Color.white);
			    g.fillOval(x-2,y-10,25,25);
			}
		    if(t[ii][jj] == 4) //ceci est un test
			{
			    g.setColor(Color.black);
			    g.fillOval(x-10,y-20,25,25); 
			    g.setColor(Color.black);
			    g.fillOval(x-2,y-10,25,25);
			}
		    if(t[ii][jj] == -5) //ceci est un test
			{
			    g.setColor(Color.white);
			    g.fillRect(x-10,y-20,25,25); 
			    g.setColor(Color.white);
			    g.fillRect(x-2,y-15,25,25);
			    g.setColor(Color.white);
			    g.fillRect(x+8,y-8,25,25);
			}
		    if(t[ii][jj] == 5) //ceci est un test
		    {
			g.setColor(Color.black);
			g.fillRect(x-10,y-20,25,25); 
			g.setColor(Color.black);
			g.fillRect(x-2,y-15,25,25);
			g.setColor(Color.black);
			g.fillRect(x+8,y-8,25,25);
		    }
		    if(t[ii][jj] == 6) //ceci est un test
			{
			    g.setColor(Color.black);
			    g.fillOval(x-10,y-20,25,25); 
			    g.setColor(Color.black);
			    g.fillOval(x-2,y-15,25,25);
			    g.setColor(Color.black);
			    g.fillOval(x+8,y-8,25,25);
			}
		    if(t[ii][jj] == -6) //ceci est un test
			{
			    g.setColor(Color.white);
			    g.fillOval(x-10,y-20,25,25); 
			    g.setColor(Color.white);
			    g.fillOval(x-2,y-15,25,25);
			    g.setColor(Color.white);
			    g.fillOval(x+8,y-8,25,25);
			}
		    if(t[ii][jj] == -7) //ceci est un test
			{
			    g.setColor(Color.white);
			    g.fillRect(x-10,y-20,25,25); 
			    g.setColor(Color.white);
			    g.fillOval(x-2,y-10,25,25);
			}
		    if(t[ii][jj] == 7) //ceci est un test
			{
			    g.setColor(Color.black);
			    g.fillRect(x-10,y-20,25,25); 
			    g.setColor(Color.black);
			    g.fillOval(x-2,y-10,25,25);
			}
		    if(t[ii][jj] == -8){
			g.setColor(Color.white);
			g.fillRect(x-10,y-20,25,25); 
			g.setColor(Color.white);
			g.fillRect(x-2,y-15,25,25);
			g.setColor(Color.white);
			g.fillOval(x+8,y-8,25,25);
			
		    }
		    if(t[ii][jj] == 8){
			g.setColor(Color.black);
			g.fillRect(x-10,y-20,25,25); 
			g.setColor(Color.black);
			g.fillRect(x-2,y-15,25,25);
			g.setColor(Color.black);
			g.fillOval(x+8,y-8,25,25);
			
		    }
		    if(t[ii][jj] == 9){
			g.setColor(Color.black);
			g.fillRect(x-10,y-20,25,25); 
			g.setColor(Color.black);
			g.fillOval(x-2,y-15,25,25);
			g.setColor(Color.black);
			g.fillOval(x+8,y-8,25,25);
			
		    }
		    if(t[ii][jj] == -9){
			g.setColor(Color.white);
			g.fillRect(x-10,y-20,25,25); 
			g.setColor(Color.white);
			g.fillOval(x-2,y-15,25,25);
			g.setColor(Color.white);
			g.fillOval(x+8,y-8,25,25);
			
		    }
		    
		    
		}
		jj = -1 ;
	    }
	    
	    
	} catch (IOException e) {
	    e.printStackTrace();
	} 
	
    }          
    
    public void paintComponent(Graphics g){
	
	
	
	affiche(g,t);
	
	
	if(tes == true){
	    g.setColor(Color.red);   
	    
	    
	    
	}else if(tes==false){
	    g.setColor(Color.blue);
	}
	
	if(tes == true && ef == 1){
	    pos[0] = i;
	    pos[1] = j;
	    System.out.println(pos[0]+" et aussi un autre truc" +pos[1]);
	    this.ef = 0 ;
	    repaint();
	   // ll[0] = pos[0];
	    //ll[1] = pos[1] ;
	    //System.out.println("voici les valeurs de ll :"+ll[0] +" "+ll[1]);
	     d1 = pos[0]; d2 = pos[1] ;
	     pd.push(d2);
	     pd.push(d1);
	}
	//deplacements de pieces NOIR
	
	else if(tes == true && this.j == pos[1]+1 && this.i == pos[0]+ 1 && t[pos[0]][pos[1]] == 2 && push == 2 && tour == false  ){
	    if(t[i][j] == 0 || t[i][j] == -1 || t[i][j] == -3 || t[i][j] == -4|| t[i][j] == -5|| t[i][j] == -6|| t[i][j] == -7|| t[i][j] == -8 || t[i][j] == -9){  //si un rond mange un haut grad� ,il le tue , c'est tout
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 2 ;
		this.push = 0 ;
		this.tour =true ;
		repaint() ;
		//ij[0] = this.j ; ij[1] = this.i ;
          a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	    }
	    
	    if(t[i][j] == -2){   
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 4 ;
		this.push = 0 ;
		this.tour =true ;
		repaint() ;
		 nbblanc[1]-- ;
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	    }  
	    
	}  
	else if(tes == true && this.j == pos[1]-1 && this.i == pos[0]+ 1 && t[pos[0]][pos[1]] == 2 && push == 2  && tour == false){
	    if(t[i][j] == 0 || t[i][j] == -1 || t[i][j] == -3 || t[i][j] == -4|| t[i][j] == -5|| t[i][j] == -6|| t[i][j] == -7|| t[i][j] == -8 || t[i][j] == -9){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 2 ;
		this.push = 0 ;
		this.tour =true ;
		repaint() ;
	    }
	    
	    if(t[i][j] == -2){   
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 4 ;
		this.push = 0 ;
		this.tour =true ;
		repaint() ;
		nbblanc[1]-- ;
		
	    }  
            a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}  
	// on enumere tous les cas possible avec des sous conditions 
	//il n'y a pas mille choix
	else if(tes == true  && t[pos[0]][pos[1]] == 4 && push == 2  && tour == false){
	    if(this.j == pos[1]-1 && this.i == pos[0]+ 1  ||  this.j == pos[1]-2 && this.i == pos[0]+ 2 || this.j == pos[1]+1 && this.i == pos[0]+ 1  ||  this.j == pos[1]+2 && this.i == pos[0]+ 2){
		
          if(t[i][j] ==  -2){                 
	      tes = false ;
	      pie.push(t[pos[0]][pos[1]]);
	      t[pos[0]][pos[1]] = 0 ;
	      t[i][j] = 6 ;
	      this.push = 0 ;
	      this.tour =true ;
	      repaint() ;
          }
          if(t[i][j] == 0 || t[i][j] == -1){ // le zero est le vide 
	      tes = false ;
	    pie.push(t[pos[0]][pos[1]]);
	      t[pos[0]][pos[1]] = 0 ;
	      t[i][j] = 4 ;
	      this.push = 0 ;
	      this.tour =true ;
	      repaint() ;
	      
	      
          }
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	    }
	}
	//le triple rond est dans la route 
	else if(tes == true  && t[pos[0]][pos[1]] == 6 && push == 2  && tour == false){
	    if(this.j == pos[1]-1 && this.i == pos[0]+ 1  ||  this.j == pos[1]-2 && this.i == pos[0]+ 2 || this.j == pos[1]+1 && this.i == pos[0]+ 1  ||  this.j == pos[1]+2 && this.i == pos[0]+ 2 || this.j == pos[1]-3 && this.i == pos[0]+ 3  ||  this.j == pos[1]+3 && this.i == pos[0]+3 ){
          
		
		// le zero est le vide 
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 6 ;
		this.push = 0 ;
		this.tour =true ;
		repaint() ;
		   a1 = this.j ; a2 = this.i ;
	 
	             pa.push(a2);
	             pa.push(a1);
		
	    }
	}
	
	
	
	
	
	
	else if(tes == true && this.j == pos[1] && this.i == pos[0]+ 1 && t[pos[0]][pos[1]] == 1 && push == 2  && tour == false ){
	    if(t[i][j] == 0 || t[i][j] == -3 ||t[i][j] == -4 || t[i][j] == -5 || t[i][j] == -6 ||t[i][j] == -7 ||t[i][j] == -8 ||t[i][j] == -9){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 1 ;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }
	    if(t[i][j] == -1){
	    tes = false ;
	   pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] =  3;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	    }
	    if(t[i][j] == -2){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  7;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }
	    
	    a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	    
	    
	}  
	else if(tes == true && this.j == pos[1]+1 && this.i == pos[0] && t[pos[0]][pos[1]] == 1 && push == 2  && tour ==false  ){
	    if(t[i][j] == 0 || t[i][j] == -3 ||t[i][j] == -4 || t[i][j] == -5 || t[i][j] == -6 ||t[i][j] == -7 ||t[i][j] == -8 ||t[i][j] == -9 ){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 1 ;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }
	    if(t[i][j] == -1){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  3;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }
	    if(t[i][j] == -2){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  7;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }

            a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	} 
	else if(tes == true && this.j == pos[1]-1 && this.i == pos[0] && t[pos[0]][pos[1]] == 1 && push == 2 && tour ==false  ){
	    if(t[i][j] == 0 || t[i][j] == -3 ||t[i][j] == -4 || t[i][j] == -5 || t[i][j] == -6 ||t[i][j] == -7 ||t[i][j] == -8 ||t[i][j] == -9 ){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = 1 ;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }
	    if(t[i][j] == -1){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  3;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    }
	    if(t[i][j] == -2){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  7;
		this.push = 0 ;this.tour =true ;
		repaint() ;
	    } 
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	
	} 
	
	
	
	
	
	
	
	//double carr�
	 else if(tes == true  && t[pos[0]][pos[1]] == 3 && push == 2 && tour ==false  ){
	     if( this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] +1 ||this.j == pos[1] && this.i == pos[0] + 2  || this.j == pos[1]-1  && this.i == pos[0]  ||this.j == pos[1]-2 && this.i == pos[0]){
	 
	if(t[i][j] == 0 || t[i][j] == -3 ||t[i][j] == -4 || t[i][j] == -5 || t[i][j] == -6 ||t[i][j] == -7 ||t[i][j] == -8 ||t[i][j] == -9 ){
	    tes = false ;
	   pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = 3 ;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	    }
	      if(t[i][j] == -1){
	    tes = false ;
	pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] =  5;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	    }
	    if(t[i][j] == -2){
	    tes = false ;
	  pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = 8;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	    } 
	}
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	} 
	
	
	 else if(tes == true  && t[pos[0]][pos[1]] == 7 && push == 2 && tour ==false  ){
	if( this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+1 && this.i == pos[0]+1 || this.j == pos[1]-1 && this.i == pos[0] +1 ||this.j == pos[1]-1 && this.i == pos[0]   || this.j == pos[1]  && this.i == pos[0]+1  ){
	 if(t[i][j] == -2){
	 tes = false ;
	pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = 9;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	 }
	if(t[i][j] == 0 || t[i][j] == -1 || t[i][j] == -3 || t[i][j] == -4 || t[i][j] == -5 || t[i][j] == -6 || t[i][j] == -7 || t[i][j] == -8 || t[i][j] == -9 ){
	 tes = false ;
	pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = 7;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	}
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}
  
  
  
    }
	
	
	 else if(tes == true  && t[pos[0]][pos[1]] == 5 && push == 2 && tour ==false  ){
	if( this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] +1 ||this.j == pos[1] && this.i == pos[0] + 2  || this.j == pos[1]-1  && this.i == pos[0]  ||this.j == pos[1]-2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] + 3  || this.j == pos[1]+3 && this.i == pos[0] || this.j == pos[1]-3 && this.i == pos[0] ){
	 
	
	    tes = false ;
	 pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = 5 ;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;

	}
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}
	//carre carre rond
	else if(tes == true  && t[pos[0]][pos[1]] == 8 && push == 2 && tour ==false  ){
	if(this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] +1 ||this.j == pos[1] && this.i == pos[0] + 2  || this.j == pos[1]-1  && this.i == pos[0]  ||this.j == pos[1]-2 && this.i == pos[0] || this.j == pos[1]-1 && this.i == pos[0]+ 1 || this.j == pos[1]+1 && this.i == pos[0]+ 1){
	
	   tes = false ;
	 pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = 8 ;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}
       }
	//carre rond rond
	else if(tes == true  && t[pos[0]][pos[1]] == 9 && push == 2 && tour ==false  ){
	if(this.j == pos[1]-1 && this.i == pos[0]+ 1  ||  this.j == pos[1]-2 && this.i == pos[0]+ 2 || this.j == pos[1]+1 && this.i == pos[0]+ 1  ||  this.j == pos[1]+2 && this.i == pos[0]+ 2 ||  this.j == pos[1]+1 && this.i == pos[0] ||  this.j == pos[1]-1 && this.i == pos[0] ||  this.j == pos[1] && this.i == pos[0]+ 1){
	 tes = false ;
	pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] =  9   ;
	    this.push = 0 ;this.tour =true ;
	    repaint() ;
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}
}
	
	
	
	
	
	
	
	
	 
	//deplacement pourles pieces Blanches 
	
	
	//Rond Blanc  (les blancs sont represent� par des nombres n�gatifs)
	
	else if(tes == true && this.j == pos[1]+1 && this.i == pos[0]- 1 && t[pos[0]][pos[1]] == -2 && push == 2 && tour == true  ){
	    if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 3 || t[i][j] == 4|| t[i][j] == 5|| t[i][j] == 6|| t[i][j] == 7|| t[i][j] == 8 || t[i][j] == 9){  //si un rond mange un haut grad� ,il le tue , c'est tout
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -2 ;
		this.push = 0 ;
		this.tour =false ;
		repaint() ;
	    }
	    
	    if(t[i][j] == 2){   
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -4 ;
		this.push = 0 ;
		this.tour =false ;
		repaint() ;
		
	    }  
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}  //V
	else if(tes == true && this.j == pos[1]-1 && this.i == pos[0]- 1 && t[pos[0]][pos[1]] == -2 && push == 2  && tour == true){
	    if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 3 || t[i][j] == 4|| t[i][j] == 5|| t[i][j] == 6|| t[i][j] == 7|| t[i][j] == 8 || t[i][j] == 9){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -2 ;
		this.push = 0 ;
		this.tour =false ;
		repaint() ;
	    }
	    
	    if(t[i][j] == 2){   
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -4 ;
		this.push = 0 ;
		this.tour =false ;
		repaint() ;
		
	    }  
    a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}  // V
	
	//il n'y a pas mille choix
	else if(tes == true  && t[pos[0]][pos[1]] == -4 && push == 2  && tour == true){
	    if(this.j == pos[1]-1 && this.i == pos[0]- 1  ||  this.j == pos[1]-2 && this.i == pos[0]- 2 || this.j == pos[1]+1 && this.i == pos[0]- 1  ||  this.j == pos[1]+2 && this.i == pos[0]- 2){
		
          if(t[i][j] ==  2){                 
	      tes = false ;
	   pie.push(t[pos[0]][pos[1]]);
	      t[pos[0]][pos[1]] = 0 ;
	      t[i][j] = -6 ;
	      this.push = 0 ;
	      this.tour =false ;
	      repaint() ;
          }
          if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 3 ||t[i][j] == 4 || t[i][j] == 5 || t[i][j] == 6 ||t[i][j] == 7 ||t[i][j] == 8 ||t[i][j] == 9){ // le zero est le vide 
	      tes = false ;
	    pie.push(t[pos[0]][pos[1]]);
	      t[pos[0]][pos[1]] = 0 ;
	      t[i][j] = -4 ;
	      this.push = 0 ;
	      this.tour =false ;
	      repaint() ;
	      
          }
	  
	    }
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}//V
	//le triple rond est dans la route 
	else if(tes == true  && t[pos[0]][pos[1]] == -6 && push == 2  && tour == true){
	    if(this.j == pos[1]-1 && this.i == pos[0]- 1  ||  this.j == pos[1]-2 && this.i == pos[0]- 2 || this.j == pos[1]+1 && this.i == pos[0]- 1  ||  this.j == pos[1]+2 && this.i == pos[0]- 2 || this.j == pos[1]-3 && this.i == pos[0]- 3 ||this.j == pos[1]+3 && this.i == pos[0]- 3 ){
          
		
		// le zero est le vide 
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -6 ;
		this.push = 0 ;
		this.tour =false ;
		repaint() ;
		   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	    }
	}//V
	
	
	
	
	
	
	
	
	else if(tes == true && this.j == pos[1] && this.i == pos[0]- 1 && t[pos[0]][pos[1]] == -1 && push == 2  && tour == true ){
	    if(t[i][j] == 0 || t[i][j] == 3 ||t[i][j] == 4 || t[i][j] == 5 || t[i][j] == 6 ||t[i][j] == 7 ||t[i][j] == 8 ||t[i][j] == 9){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -1 ;
		this.push = 0 ;this.tour = false ;
		repaint() ;
	    }
	    if(t[i][j] == 1){
	    tes = false ;
	   pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] =  -3;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    }
	    if(t[i][j] == 2){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  -7;
		this.push = 0 ;this.tour = false ;
		repaint() ;
	    }
	    a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}  //V
	
	
	else if(tes == true && this.j == pos[1]+1 && this.i == pos[0] && t[pos[0]][pos[1]] == -1 && push == 2  && tour ==true){
	    if(t[i][j] == 0 || t[i][j] == 3 ||t[i][j] == 4 || t[i][j] == 5 || t[i][j] == 6 ||t[i][j] == 7 ||t[i][j] == 8 ||t[i][j] == 9 ){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -1 ;
		this.push = 0 ;this.tour =false ;
		repaint() ;
	    }
	    if(t[i][j] == 1){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  -3;
		this.push = 0 ;this.tour =false;
		repaint() ;
	    }
	    if(t[i][j] == 2){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  -7;
		this.push = 0 ;this.tour =false ;
		repaint() ;
	    }
   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	} 









	else if(tes == true && this.j == pos[1]-1 && this.i == pos[0] && t[pos[0]][pos[1]] == -1 && push == 2 && tour ==true ){
	    if(t[i][j] == 0 || t[i][j] == 3 ||t[i][j] == 4 || t[i][j] == 5 || t[i][j] == 6 ||t[i][j] == 7 ||t[i][j] == 8 ||t[i][j] == 9 ){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] = -1 ;
		this.push = 0 ;this.tour =false ;
		repaint() ;
	    }
	    if(t[i][j] == 1){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  -3;
		this.push = 0 ;this.tour =false ;
		repaint() ;
	    }
	    if(t[i][j] == 2){
		tes = false ;
		pie.push(t[pos[0]][pos[1]]);
		t[pos[0]][pos[1]] = 0 ;
		t[i][j] =  -7;
		this.push = 0 ;this.tour =false ;
		repaint() ;
	    } 
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	} //V
	
	
	
	
	
	
	
	//double carr�
	 else if(tes == true  && t[pos[0]][pos[1]] == -3 && push == 2 && tour ==true  ){
	     if( this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] -1 ||this.j == pos[1] && this.i == pos[0] - 2  || this.j == pos[1]-1  && this.i == pos[0]  ||this.j == pos[1]-2 && this.i == pos[0]){
	 
	if(t[i][j] == 0 || t[i][j] == 3 ||t[i][j] == 4 || t[i][j] == 5 || t[i][j] == 6 ||t[i][j] == 7 ||t[i][j] == 8 ||t[i][j] == 9 ){
	    tes = false ;
	pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -3 ;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    }
	      if(t[i][j] == 1){
	    tes = false ;
	  pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] =  -5;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    }
	    if(t[i][j] == 2){
	    tes = false ;
	    pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -8;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    } 
	}
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	} //V
	
	//
	 else if(tes == true  && t[pos[0]][pos[1]] == -7 && push == 2 && tour ==true ){
	if( this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+1 && this.i == pos[0]-1 || this.j == pos[1]-1 && this.i == pos[0] -1 ||this.j == pos[1]-1 && this.i == pos[0]   || this.j == pos[1]  && this.i == pos[0]-1  ){
	 if(t[i][j] == 2){
	 tes = false ;
	 pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -9;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	 }
	if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 3 || t[i][j] == 4 || t[i][j] == 5 || t[i][j] == 6 || t[i][j] == 7 || t[i][j] == 8 || t[i][j] == 9 ){
	 tes = false ;
	pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -7;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	}
	
	}
     a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
    }//V
	
	
	 else if(tes == true  && t[pos[0]][pos[1]] == -5 && push == 2 && tour ==true  ){
	if( this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] -1 ||this.j == pos[1] && this.i == pos[0] - 2  || this.j == pos[1]-1  && this.i == pos[0]  ||this.j == pos[1]-2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] - 3  || this.j == pos[1]+3 && this.i == pos[0] || this.j == pos[1]-3 && this.i == pos[0] ){
	 
	
	    tes = false ;
	    pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -5 ;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
            a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}
	
	}//V
	
	
	
	//carre carre rond
	else if(tes == true  && t[pos[0]][pos[1]] == -8 && push == 2 && tour ==true  ){
	if(this.j == pos[1]+1 && this.i == pos[0] || this.j == pos[1]+2 && this.i == pos[0] || this.j == pos[1] && this.i == pos[0] -1 ||this.j == pos[1] && this.i == pos[0] - 2  || this.j == pos[1]-1  && this.i == pos[0]  ||this.j == pos[1]-2 && this.i == pos[0] || this.j == pos[1]-1 && this.i == pos[0]- 1 || this.j == pos[1]+1 && this.i == pos[0]- 1){
	
	   tes = false ;
	  pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -8 ;
	    this.push = 0 ;this.tour = false  ;
	    repaint() ;
	
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	
	}
       }
	//carre rond rond
	else if(tes == true  && t[pos[0]][pos[1]] == -9 && push == 2 && tour == true ){
	if(this.j == pos[1]-1 && this.i == pos[0]- 1  ||  this.j == pos[1]-2 && this.i == pos[0]- 2 || this.j == pos[1]+1 && this.i == pos[0]- 1  ||  this.j == pos[1]+2 && this.i == pos[0]- 2 ||  this.j == pos[1]+1 && this.i == pos[0] ||  this.j == pos[1]-1 && this.i == pos[0] ||  this.j == pos[1] && this.i == pos[0]- 1){
	 tes = false ;
	 pie.push(t[pos[0]][pos[1]]);
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] =  -9   ;
	    this.push = 0 ;this.tour = false ;
	    repaint() ;
	   a1 = this.j ; a2 = this.i ;
	 
	pa.push(a2);
	pa.push(a1);
	}
} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*else if(tes == true && this.j == pos[1]-1 && this.i == pos[0]- 1 && t[pos[0]][pos[1]] == -2 && push == 2  && tour == true ){
	if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 2){
	    tes = false ;
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -2 ;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    }
	}
	
	
	else if(tes == true && this.j == pos[1]+1 && this.i == pos[0]- 1 && t[pos[0]][pos[1]] == -2 && push == 2 && tour == true  ){
	if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 2){
	    tes = false ;
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -2 ;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    }
	}
	
	
	
	
	
	
	
	
	
	  else if(tes == true && this.j == pos[1] && this.i == pos[0]-1 && t[pos[0]][pos[1]] == -1 && push == 2 && tour == true ){
	if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 2){
	    tes = false ;
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -1 ;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	}    
      }  
	 
	  else if(tes == true && this.j == pos[1]-1 && this.i == pos[0] && t[pos[0]][pos[1]] == -1 && push == 2 && tour == true  ){
	if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 2){
	    tes = false ;
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -1 ;
	    this.push = 0 ;this.tour =false ;
	    repaint() ;
	    }
	}  else if(tes == true && this.j == pos[1]+1 && this.i == pos[0] && t[pos[0]][pos[1]] == -1 && push == 2  && tour == true ){
	if(t[i][j] == 0 || t[i][j] == 1 || t[i][j] == 2){
	    tes = false ;
	    t[pos[0]][pos[1]] = 0 ;
	    t[i][j] = -1 ;
	    this.push = 0 ;this.tour =false;
	    repaint() ;
	    }
	}  */
	
	
	
	
	
	
	
	else if(tes == true && push ==2 ){
	System.out.println("kjkj");
	tes = false ;
	this.push =0 ;
	repaint() ;
	
	}
	
	
	
	//fonction de delimitation
	g.fillOval(a,b,25,25);
	if(this.a < 38){
	    this.a = 38 ;
	    this.j =0 ;
	    repaint() ;
	}
	if(this.b < 35){
	    this.b = 35 ; repaint() ;
	    this.i = 0 ;
	}
	if(this.a >370 ){
	    this.a = 350 ;repaint();
	    this.j = 7 ;
         }
	if(this.b >298 ){
	    this.b = 294 ;repaint();
	    this.i = 7 ;
	}
	
        
	
	
	
   
   
    }               
}