import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Calculus extends JFrame{
	/*
	 * Calculatrice	 , il n'y a pas de zéro parce que 
	 * le siteduZero est devenu openclassrooms payant.
	 */
	
	private C p = new C () ;
	private JMenuBar m = new JMenuBar() ;
	private JMenu m1 = new JMenu("Quit") ;
	public JMenuItem i = new JMenuItem("Quitter") ;
	
	public Calculus (){
		this.setTitle("Calculatrice");
		this.setSize(400, 400);
		this.setUndecorated(true);
		
		
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);	
		
		m1.add(i);
		
		i.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent event){
 				dispose() ;
 			}
 		});
		i.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		m.add(m1);
		
		this.setJMenuBar(m);
		this.setContentPane(p);
		this.setVisible(true);

	}
	

}
