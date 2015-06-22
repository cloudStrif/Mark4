
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;  

import java.util.*;

public class Snake extends JFrame{
    public boolean vv = false ;
    int po = 0 ;
    public int ff = 0 ;
    JMenuBar m = new JMenuBar() ;
    JMenu m1 = new JMenu("Parametre");
    JMenuItem i1 = new JMenuItem("Pause");
    JMenuItem i2 = new JMenuItem("Quitter");
    JMenuItem i5 = new JMenuItem("Recommencer");
    JMenu m2 = new JMenu("A propos");
    JMenuItem i3 = new JMenuItem("Note de l'auteur");
    JMenu m3 = new JMenu("?");
    JMenuItem i4 = new JMenuItem("R�gles du jeu");
    private JPanel container = new JPanel();
    private S2 p = new S2() ;
    Thread te ;
    Thread d ; 
    Thread g ;
    Thread b ;
    Thread no ;
    public Snake(){
	this.setTitle("Snake by L");
	this.setSize(495, 535);
	
	this.setLocationRelativeTo(null);
	
	
	this.setResizable(false); 
	container.setLayout(new BorderLayout());
	container.add(p,BorderLayout.CENTER);
	JTextField t = new JTextField();
	
	t.setPreferredSize(new Dimension(0,0));
	t.addKeyListener(new ClavierListener());
	JPanel s = new JPanel();
	s.add(t);
	container.add(s,BorderLayout.SOUTH);
	m1.add(i1);
		 i1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
			     po ++ ;
			     if(po == 1){
				 no = new Thread(new Playo());
				 no.start();
				 
			     }else {
				 p.pause = ff ;
				 no.stop();
			     }
			     
			 }
		     });
		 m1.add(i2);
		 m1.add(i5);
		 i5.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
			     
			     
			 }
		     });
		 
		 
		
		 i2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
			     System.exit(0);
			     
			 }
		     });
		 i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		 m2.add(i3);
		 i3.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
			     JOptionPane jo = new JOptionPane();
			     
			     jo.showMessageDialog(null ,"Je suis choqu� de voir que des gens disent que le snake est facile a coder \n paroles de debutants en plus , C'EST FAUX ! il faut avoir des connaissance minime en informatiquue !" ,"note de l'auteur", JOptionPane.INFORMATION_MESSAGE);
			     
				}
		     });
		 m3.add(i4);
		 i4.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
			     JOptionPane jo = new JOptionPane();
			     
			     jo.showMessageDialog(null ,"Le but est de manger la proie (truc rouge) , c'est tout pour le moment" ,"rules", JOptionPane.INFORMATION_MESSAGE);
			     
			 }
		     });
		 m.add(m1);
		 m.add(m2);
		m.add(m3);
		
		this.setContentPane(container);
		this.setJMenuBar(m);
		//p.proie();
		this.setVisible(true);
		JOptionPane j = new JOptionPane();
		
		j.showMessageDialog(null ,"Etes vous pr�t ? Parce que �a va tr�s vite!" ,"Avertissement", JOptionPane.QUESTION_MESSAGE);
		te = new Thread(new Playe());
		te.start();
    }
    
    
	
    
    
	
	
	class ClavierListener implements KeyListener{
		   
	    public void keyPressed(KeyEvent event) {
	    
	        
	          if(event.getKeyCode() == 39){
	        	
	        	  if(te != null){
	        	  te.stop();
	        	  
	        	  } 
	        	 if(d != null){
		        	  d.stop();
		        	  
		         }
	        	 if(g != null){
		        	  g.stop();
		        	 
		         }
	        	 if(b != null){
		        	  b.stop();
		        	  
		         } 
	        	 
	        	 	d = new Thread(new Playd());
	        		 	d.start();
	        	 
	          } 
	     
	          if(event.getKeyCode() == 37){
	        	 
	        	  if(te != null){
		        	  te.stop();
		        	  
		        	  } 
		        	 if(d != null){
			        	  d.stop();
			        
			         }
		        	 if(g != null){
			        	  g.stop();
			        	  
		        	 }
		        	 if(b != null){
			        	  b.stop();
			        	 
			         } 
	        	 
		         g = new Thread(new Playg());
		         g.start();
	        	 
		          } 
	          if(event.getKeyCode() == 40){
	        	 
	        	  if(te != null){
		        	  te.stop();
		        	 
		        	  } 
		        	 if(d != null){
			        	  d.stop();
			        	
			         }
		        	 if(g != null){
			        	  g.stop();
			        	  
			         }
		        	 if(b != null){
			        	  b.stop();
			        
			         } 
		        
		        	 b = new Thread(new Playb());
		        	 b.start();
		        	 
	          }
	          if(event.getKeyCode() == 38){
	        	  
	        	  if(te != null){
		        	  te.stop();
		        	 
		        	  } 
		        	 if(d != null){
			        	  d.stop();
			         }
		        	 if(g != null){
			        	  g.stop();
			         }
		        	 if(b != null){
			        	  b.stop();
			        	 
			         } 
		        	 
		        	 te = new Thread(new Playe());
		        	 te.start();
		        	 
		       	}
	         
	     // System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
	      //pause();
	    }

	          public void keyReleased(KeyEvent event) {
	     /* System.out.println("Code touche relâchée : " + event.getKeyCode() + " - caractère touche relâchée : " + event.getKeyChar());         
	      pause();*/           
	    } 

	    public void keyTyped(KeyEvent event) {
	     /* System.out.println("Code touche tapée : " + event.getKeyCode() + " - caractère touche tapée : " + event.getKeyChar());
	      pause();*/   
	    }   	
	  } 
	
	class Playe implements Runnable{
		public void run(){
			for(int i = 0 ; i< 50;i++){
				p.efface();
				p.avance(0) ;
				p.repaint();
				p.pause();
			}	
		}
	}
	class Playb implements Runnable{
		public void run(){
			for(int i = 0 ; i< 50;i++){
				p.efface();
				p.avance(3) ;
				p.repaint();
				p.pause();
			}	
		}
	}	

	class Playd implements Runnable{
		public void run(){
			for(int i = 0 ; i<50;i++){
				p.efface();
				p.avance(1) ;
				p.repaint();
				p.pause();
			}	
		}
	}	
	
	class Playg implements Runnable{
		public void run(){
			for(int i = 0 ; i< 50;i++){
				p.efface();
				p.avance(2) ;
				p.repaint();
				p.pause();
			}	
		}
	}	
	class Playo implements Runnable{
		public void run(){
			 ff = p.pause ;
			 p.pause = 1000000;
			 po = 0 ;
		}
	}
	
	
	public static void main(String[] args) {
		new Snake() ;

	}

}
