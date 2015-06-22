
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * classe qui affiche la couleur RGB
 */

public class Pan extends JPanel{
	 int aa , bb , cc =0 ;
	 
	public void paintComponent(Graphics g){
		g.setColor(new Color(aa,bb,cc));
		g.fillRect(0,0 , 800,800);
	}
	
}
