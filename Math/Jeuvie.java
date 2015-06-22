
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;




public class Jeuvie extends JFrame implements ActionListener{
	public Application2 p  = new Application2() ;
	
	private JPanel container = new JPanel();
	private JTextField jtf  ;
	public Thread t ;
	
	private JButton bouton = new JButton ("Start") ;
	private JButton bouton2 = new JButton ("Stop ! ") ;
	private JButton bouton3 = new JButton ("Efface") ;
	public Jeuvie(){
		this.setTitle("Jeu de La Vie");
	    this.setSize(400, 440);
	  
	    this.setLocationRelativeTo(null);
	    // this.setResizable(false); 
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    container.add(p, BorderLayout.CENTER);
	    
	    bouton.addActionListener(this) ;
	    bouton2.addActionListener(this) ;
	    bouton3.addActionListener(this) ;
	    
	    jtf = new JTextField();
	    
	    JPanel south = new JPanel();
	    south.add(bouton);
	    south.add(bouton2);
	    south.add(bouton3);
	  
	    //south.add(jtf);
       
	    //jtf.setPreferredSize(new Dimension(0, 0));
	    //jtf.addKeyListener(new ClavierListener());
	    container.add(south , BorderLayout.SOUTH);
	     this.setContentPane(container);
	     this.setVisible(true);
	  
	}
	
	public void game (){
		while(true){
			p.repaint() ;
			dort() ;
			p.remet();
			p.repaint() ;
		}
	}
	public void dort(){
		 try {
	            Thread.sleep(90);
	          } catch (InterruptedException e) {
	            e.printStackTrace();
	          }	
	}
	

	
	class P implements Runnable {
		public void run(){
			game() ;
		}
	}
	
	
	public static void main(String[] args) {
	Jeuvie a = new Jeuvie() ;
	}

	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bouton){
			  t = new Thread (new P());
	    	  t.start();
		}
		if(arg0.getSource()== bouton2){
			 t.stop();
		}
		
		if(arg0.getSource()== bouton3){
			 for(int i = 0 ; i < 20 ; i++){
	    		 for(int j = 0 ; j < 20 ; j++){
	    			p.t[i][j]  = 0 ;
	    			p.repaint() ;
	    		 } 
	    	 }
		}
	}

}
