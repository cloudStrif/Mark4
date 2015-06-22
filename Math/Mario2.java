

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Mario2 extends JPanel{
    boolean eff =false ;
    public int MAP = -1 ;

	
    public int [][] t = new int[12][10];
	
	
    int x =0 ;
    int y = 0 ;
	
    int orientation = 0; 
    int avance =2 ;
	
    int posx=9;
    int posy=1;
	
    int orientationa = 1 ;
    int avanca =1 ;
    public void paint(Graphics g){
	
		
	
	if(MAP==-2){
	    try{
			
		Image apache = ImageIO.read(new File("mario/MP9_Mario.png"));
		g.drawImage(apache,0,0,600,600,this);
	    }catch(Exception e){}
	}
		
	g.setColor(Color.ORANGE);
	g.setFont(new Font("Arial", Font.BOLD, 30));
	if(eff){
	    g.drawString("Mario",180,300);
	    g.drawString("appuyer sur ENTER",180,200);
	}
	if(MAP==-1){
			
	    try{
		/*	Image apa = ImageIO.read(new File("backgrounds/NeoHillsBG.PNG"));
			g.drawImage(apa,0,0,600,700,this);*/
		Image apache = ImageIO.read(new File("backgrounds/background2.png"));
		g.drawImage(apache,0,0,600,600,this);
	    }catch(Exception e){}
	    affiche(g);
	}
		
		
    }
	
    public void affiche(Graphics g){
	for(int i = 0 ; i< t.length ; i++){
	    for(int j = 0; j< t[0].length ;j++){
				
				
		if(t[i][j] == 1){
		    /*		g.setColor(Color.black);
				g.fillRect(x, y, (int)(600/t[0].length) ,(int)(600/t.length) );
				g.setColor(Color.WHITE);
				g.fillRect(x, y, (int)(600/t[0].length)-5,(int)(600/t.length)-5);*/
		    if(orientation== 0){
			switch(avance){
			case 1 :
						
			    ImageIcon imageIcon = new ImageIcon("mario/Mario_Big_Right_Still.png");
			    Image w = imageIcon.getImage();   
							
			    g.drawImage(w,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			    break ;
						
						
			case 2 :
							
			    ImageIcon image = new ImageIcon("mario/Mario_Big_Right_1.png");
			    Image d = image.getImage();   
							
			    g.drawImage(d,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			    break ;
						
			case 3 :
						
			    ImageIcon image2 = new ImageIcon("mario/Mario_Big_Right_2.png");
			    Image d1 = image2.getImage();   
						
			    g.drawImage(d1,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			    break ;
					
				
			}
		    }
		    if(orientation== 1){
			switch(avance){
			case 1 :
						
			    ImageIcon imageIcon = new ImageIcon("mario/Mario_Big_Left_StillF.png");
			    Image w = imageIcon.getImage();   
							
			    g.drawImage(w,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			    break ;
						
						
			case 2 :
							
			    ImageIcon image = new ImageIcon("mario/Mario_Big_Left_1.png");
			    Image d = image.getImage();   
							
			    g.drawImage(d,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			    break ;
						
			case 3 :
						
			    ImageIcon image2 = new ImageIcon("mario/Mario_Big_Left_2.png");
			    Image d1 = image2.getImage();   
						
			    g.drawImage(d1,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			    break ;
					
				
			}
		    }
					
					
		    if(orientation== 2){
			switch(avance){
			case 1 :
							
			    ImageIcon imageIcon = new ImageIcon("mario/Mario_Big_Jump_Right.png");
			    Image w = imageIcon.getImage();   
							
			    g.drawImage(w,x,y,(int)(600/t[0].length)-10,(int)(600/t.length)-5,this);
			}
		    }
		}
		//roche bleu
		if(t[i][j] == 3){
		    ImageIcon imageIcon = new ImageIcon("tiles/r3.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
					
		}
		//gagnant
		if(t[i][j]==6){
		    ImageIcon imageIcon = new ImageIcon("items/1_Up.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
		}
			
	
		
		
		//herbe
		if(t[i][j] == 8){
		    ImageIcon imageIcon = new ImageIcon("tiles/r.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
					
		}
		//roche rouge
		if(t[i][j] == 9){
		    ImageIcon imageIcon = new ImageIcon("tiles/r2.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
					
		}
		//cactus
		if(t[i][j] == 2){
		    ImageIcon imageIcon = new ImageIcon("tiles/t.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
					
		}
				
		//cactus
		if(t[i][j] == 4){
		    ImageIcon imageIcon = new ImageIcon("tiles/t2.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
					
		}
		if(t[i][j] == 5){
		    ImageIcon imageIcon = new ImageIcon("tiles/n.png");
		    Image w = imageIcon.getImage();   
					
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
		}
				
				
		if(t[i][j] == 7){
		    if(orientationa== 1){
			switch(avanca){
			case 1 :
							
			    ImageIcon imageIcon = new ImageIcon("items/Coin_1.png");
			    Image w = imageIcon.getImage();   
							
			    g.drawImage(w,x,y,this);
			    break ;
							
							
			case 2 :
								
			    ImageIcon image = new ImageIcon("items/Coin_2.png");
			    Image d = image.getImage();   
								
			    g.drawImage(d,x,y,this);
			    break ;
							
			case 3 :
							
			    ImageIcon image2 = new ImageIcon("items/Coin_3.png");
			    Image d1 = image2.getImage();   
							
			    g.drawImage(d1,x,y,this);
			    break ;
						
							
			case 4:
							
			    ImageIcon image4 = new ImageIcon("items/Coin_4.png");
			    Image d4 = image4.getImage();   
							
			    g.drawImage(d4,x,y,this);
			    break ;
			case 5:
							
			    ImageIcon image5 = new ImageIcon("items/Coin_5.png");
			    Image d5 = image5.getImage();   
							
			    g.drawImage(d5,x,y,this);
			    break ;
						
			case 6 :

			    ImageIcon image6 = new ImageIcon("items/Coin_6.png");
			    Image d6 = image6.getImage();   
							
			    g.drawImage(d6,x,y,this);
			    break ;
							
			case 7 :

			    ImageIcon image7 = new ImageIcon("items/Coin_7.png");
			    Image d7 = image7.getImage();   
							
			    g.drawImage(d7,x,y,this);
			    break ;
						
			case 8 :

			    ImageIcon image8 = new ImageIcon("items/Coin_8.png");
			    Image d8 = image8.getImage();   
							
			    g.drawImage(d8,x,y,this);
			    break ;
							
			}
		    }
		}
		if(t[posx][posy] == 2){
		    ImageIcon imageIcon = new ImageIcon("items/Red_Platform.png");
		    Image w = imageIcon.getImage();   
		    g.drawImage(w,x,y,(int)(600/t[0].length),(int)(600/t.length),this);
		}
				
				
				
		x = x + (int)(600/t[0].length) ;
	    }
	    x = 0;
	    y = y + (int)(600/t.length) ;
	}
	x=y=0;	
    }
}