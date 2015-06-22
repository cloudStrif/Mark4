

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Morpion extends JFrame{
	private M2 p = new M2() ;
	private JMenuBar m = new JMenuBar();
	private JMenu m1 = new JMenu("Parametre");
	private JMenuItem i = new JMenuItem("Score");
	private JMenuItem i2 = new JMenuItem("ReCommencer");
	private JMenu m2 = new JMenu("?");
	
	public Morpion(){
		this.setTitle("Tic Tac Toc");
	    this.setSize(320, 345);
	  
	    this.setLocationRelativeTo(null);
	    this.setResizable(false); 
	    m1.add(i);
	    i.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		JOptionPane j = new JOptionPane() ;
	    		j.showMessageDialog(null ,"Score du bleu :" + p.bleu +"\n Score du rouge :"+ p.rouge,"Score" , JOptionPane.INFORMATION_MESSAGE);
	    	}
		});
	    m1.add(i2);
	    i2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		int pp = 2 ;
	    		for(int i = 0 ; i < p.t.length ;i++){
	    			for(int j = 0 ; j < p.t[0].length ;j++){
	    				p.t[i][j] = pp ;
	    				pp++ ;
	    			}
	    		}
	    	p.repaint();
	    	if(p.tour){
	    		p.bleu -- ;
	    	}
	    	else {
	    		p.rouge--;
	    	}
	    	
	    	}
		});
	    m.add(m1);
	    m.add(m2);
	    this.setJMenuBar(m) ;
	    this.setContentPane(p);
	    this.setVisible(true);
	   //this.setResizable(false); 
		
	}
	
	public static void main(String[] args) {
		new Morpion() ;

	}

}
