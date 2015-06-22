import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Bouton extends JButton{
	/*
	 * Bouton herite de JButton 
	 * Classe qui donne une image a un bouton
	 */
	 private String name;
	  
	  public Bouton(String str){
	    super(str);
	    this.name = str;
	  }
	  
	  /*
	   * en fonction de NAME on affiche la bonne image
	   * Il affiche chaques image sur les boutons qui garde la taile voulu standard
	   * sans setPreferisedSize()..
	   */
	  public void paintComponent(Graphics g){
		switch(name){
		case "p" :
				ImageIcon ee = new ImageIcon("images/point.png");
				Image qee= ee.getImage();   
				g.drawImage(qee,0,0, 40,30 ,this);
			break ;
		case "s" :
			ImageIcon e = new ImageIcon("images/segment.png");
			Image qe= e.getImage();   
			g.drawImage(qe,0,0,40, 30 ,this);
			break ;
		case "b" :
			ImageIcon i = new ImageIcon("images/bissectrisse.png");
			Image q= i.getImage();   
			g.drawImage(q,0,0,40, 30 ,this);
			break ;
			
		case "d" :
			ImageIcon im = new ImageIcon("images/droite.png");
			Image qm= im.getImage();   
			g.drawImage(qm,0,0,40, 30 ,this);
			break ;
			
		case "e" :
			ImageIcon ima = new ImageIcon("images/demidroite.png");
			Image qma= ima.getImage();   
			g.drawImage(qma,0,0,40, 30 ,this);
			break ;
		case "m" :
			ImageIcon imaaa = new ImageIcon("images/media.png");
			Image qmaa = imaaa.getImage();   
			g.drawImage(qmaa,0,0,40, 30 ,this);
			
			break ;
		case "i" :
			ImageIcon image = new ImageIcon("images/inter.png");
			Image qmag = image.getImage();   
			g.drawImage(qmag,0,0,40, 30 ,this);
			break ;
		
			//Crayon
		case "g":
			ImageIcon imaz = new ImageIcon("images/crayon.png");
			Image qmaz = imaz.getImage();   
			g.drawImage(qmaz,0,0,40, 30 ,this);
			break ;
	//image
		case "o":
			ImageIcon imp = new ImageIcon("images/ima.png");
			Image qt = imp.getImage();   
			g.drawImage(qt,0,0,40, 30 ,this);
			break ;
	
		case "t":
			ImageIcon iii = new ImageIcon("images/polygon.png");
			Image qttt = iii.getImage();   
			g.drawImage(qttt,0,0,40, 25 ,this);
			break ;
			
		case "r":
			ImageIcon iiii = new ImageIcon("images/iso.png");
			Image qtttt = iiii.getImage();   
			g.drawImage(qtttt,0,0,40, 25 ,this);
			break ;
			//cercle
		case "l" :
			ImageIcon iiiii = new ImageIcon("images/cercle.png");
			Image qttttt = iiiii.getImage();   
			g.drawImage(qttttt,0,0,40, 25 ,this);
			break ;
			//polygone regulier
		case "y" :
			ImageIcon ioi = new ImageIcon("images/polygonreg.png");
			Image qd = ioi.getImage();   
			g.drawImage(qd,0,0,40, 25 ,this);
			break ;
		case "c" :
			ImageIcon iot = new ImageIcon("images/dep.png");
			Image qdg = iot.getImage();   
			g.drawImage(qdg,0,0,40, 25 ,this);
			break ;
		case "w" :
			ImageIcon idot = new ImageIcon("images/cube.gif");
			Image qdgd = idot.getImage();   
			g.drawImage(qdgd,0,0,40, 25 ,this);
			break ;	
			
		}
		
		  
	  }
	  
}
