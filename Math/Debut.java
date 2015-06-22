
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * Image qui s'affiche au debut
 */

public class Debut extends JPanel{
	/*
	 * Frame de depart qui ouvre le logiciel
	 */
	
	private JPanel cont = new JPanel() ;
	public Debut(){
		JFrame f =new JFrame() ;
	
		f.setSize(400,150);
		
		/*
		 * Cache la barre du haut
		 */
		f.setUndecorated(true); 
		
		cont.setBackground(Color.white);
		cont.setLayout(new BorderLayout());
		cont.add(this, BorderLayout.CENTER);
		f.setContentPane(cont);
		f.setLocationRelativeTo(null);
		
		f.setVisible(true);
	
		Brui b = new Brui("CreateSpeech",true);
		Brui b22 = new Brui("ir",true);
		
		b.jou() ;
		b22.jou() ;
		try {
				Thread.sleep(6000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }	
		b.stop() ;
		b22.stop() ;
		
		f.dispose();	
	}

	public void paintComponent(Graphics g){
		try{
			
			Image image = ImageIO.read(new File("images/logo.png"));
	
			g.drawImage(image,0,0,400,150,this); 
			
		
		} catch (IOException e) {
			System.out.println(e.getMessage()) ;
		}
	}
}
