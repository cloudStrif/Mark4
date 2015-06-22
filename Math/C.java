import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JPanel;

public class C extends JPanel{
	public int [][] cal = {{1,2,3,10,15},
						   {4,5,6,11,12},
						   {7,8,9,13,14}} ; 
	public boolean [][] bo = new boolean [3][5];
	public int x =0;
	public int y = 0 ;
	public String nb = "" ;
	public int valeur = 0 ;
	
	//valeur de base
	public int g = 0 ;
	public int operator =0 ;
	public AudioClip clip ,clip2;
	// nb == valeur affiché
	
	public C(){
		bo[2][2] = true ;
		File deb = new File("son/detecteur_converted.wav");
		File sao =new File("son/detecteur2_converted.wav");
		try
		{
		clip = Applet.newAudioClip(deb.toURL());
		clip2 = Applet.newAudioClip(sao.toURL());
		}
		catch (MalformedURLException e)
		{
		System.out.println(e.getMessage());
		}
		
		
		this.addMouseListener(new MouseAdapter(){
		      public void mousePressed(MouseEvent e){
		    	 
		    	  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] == 11){
		    		  
		    		  operator = 0 ;
		    		  g = Integer.parseInt(nb)  ;
		    		 
		    		  String f = "" ;
		    		  nb = f ;
		    		  repaint() ;
		    	  }
	  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] == 12){
		    		  
		    		  operator = 1 ;
		    		  g = Integer.parseInt(nb)  ;
		    		 
		    		  String f = "" ;
		    		  nb = f ;
		    		  repaint() ;
		    	  }
	  
	  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] == 13){
		  
		  operator = 2 ;
		  g = Integer.parseInt(nb)  ;
		 
		  String f = "" ;
		  nb = f ;
		  repaint() ;
	  }
  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] == 14){
		  
		  operator = 3 ;
		  g = Integer.parseInt(nb)  ;
		 
		  String f = "" ;
		  nb = f ;
		  repaint() ;
	  }
  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] == 15){
	  
	 
	 
	  String f = "" ;
	  nb = f ;
	  repaint() ;
  }
		    	  
		    	  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] == 10){
		    		  if(operator == 0){
		    			 
		    		  g = Integer.parseInt(nb) + g ;
		    		  System.out.println(g);
		    		  
		    		  String f = "" ;
		    		  nb = f ;
		    		  nb = Integer.toString(g);
		    		  System.out.println(nb+"chiffre") ;
		    		  
		    		  }if(operator == 1){
		    			  g = g -Integer.parseInt(nb)  ;
			    		  System.out.println(g);
			    		  
			    		  String f = "" ;
			    		  nb = f ;
			    		  nb = Integer.toString(g);
			    		  System.out.println(nb+"chiffre") ;  
		    		  }
		    		  if(operator == 2){
		    			  g = g*Integer.parseInt(nb)  ;
			    		  System.out.println(g);
			    		  
			    		  String f = "" ;
			    		  nb = f ;
			    		  nb = Integer.toString(g);
			    		  System.out.println(nb+"chiffre") ;  
		    		  }
		    		  if(operator == 3){
		    			  g = g /Integer.parseInt(nb)  ;
			    		  System.out.println(g);
			    		  
			    		  String f = "" ;
			    		  nb = f ;
			    		  nb = Integer.toString(g);
			    		  System.out.println(nb+"chiffre") ;  
		    		  }
		    		
		    		  repaint() ;
		    	  }
		    	  
		    	  if(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] < 10){
		    	  nb = nb + Integer.toString(cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))]);
		    	  repaint() ;
		    	  }
		    	  
		    	
		    	
		    	  
		      }
		    });

		    this.addMouseMotionListener(new MouseMotionListener(){
		      public void mouseDragged(MouseEvent e) {
		       
		      }

		      public void mouseMoved(MouseEvent e) {
		    //	System.out.println (cal[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))]) ; 
		    	//  clip.play() ;
		    	  bo[(int)(e.getY()/(300/3))][(int)(e.getX()/(400/5))] = true ;
		    	  repaint() ;
		      }
		    });

	}
	
	
	
	public void affichage(Graphics g){
		g.setFont(new Font("Arial", Font.BOLD, 25));
		
		for(int i = 0 ; i < 3; i++){
			
			for(int j =0 ; j < 5 ; j++){
				
				
				if(cal[i][j] < 10){
				
					
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;
					
					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					
					g.setColor(Color.black) ;
					String a  = Integer.toString(cal[i][j]) ;
					g.drawString(a,x+20,y+30) ;
					bo[i][j] = false ;
				}
				if(cal[i][j]==10){
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;

					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					g.setColor(Color.black) ;
					
					g.drawString(" =",x+20,y+30) ;
					bo[i][j] = false ;
				}
				
				if(cal[i][j]==11){
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;

					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					g.setColor(Color.black) ;
					
					g.drawString("+",x+20,y+30) ;
					bo[i][j] = false ;
				}
				if(cal[i][j]==12){
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;
					

					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					g.setColor(Color.black) ;
					g.drawString("-",x+20,y+30) ;
					bo[i][j] = false ;
				}
				if(cal[i][j]==13){
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;
					g.setColor(Color.black) ;

					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					g.drawString("X",x+20,y+30) ;
					bo[i][j] = false ;
				}
				if(cal[i][j]==14){
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;

					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					g.setColor(Color.black) ;
					
					
					g.drawString("/",x+20,y+30) ;
					bo[i][j] = false ;
				}
			
				if(cal[i][j]==15){
					g.setColor(Color.gray);
					g.fillRect(x,y,80,100);
					g.setColor(Color.cyan);
					g.fillRect(x,y,75,95) ;

					if(bo[i][j] == true){
						g.setColor(Color.darkGray) ;
						g.fillRect(x,y,75,95) ;
					}
					g.setColor(Color.black) ;
					
					g.drawString("ce",x+20,y+30) ;
					bo[i][j] = false ;
				}
				
			
			//	System.out.println(cal[i][j]) ;
				x = x + 80;
			}
			x = 0 ;
			y = y + 100 ;
		}
		
		x = 0 ;
		y = 0 ;
	
		g.setColor(Color.red) ;
		g.drawString(nb ,10,350) ;
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,400,400) ;
		
		
		g.setColor(Color.black);
		g.fillRect(0,300,400,100) ;
		g.setColor(Color.white) ;
		g.fillRect(4,305,385,85) ;
		
		affichage(g) ;
		
		
	}
	
}
