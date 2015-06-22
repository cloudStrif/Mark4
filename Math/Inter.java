
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;




public class Inter extends JFrame implements ActionListener{

	JButton b = new JButton(new ImageIcon("picture/broly.png"));
	JButton b1 =new JButton(new ImageIcon("picture/chess.png"));
	JButton b2 =new JButton(new ImageIcon("picture/Dim.png"));
	JButton b3= new JButton(new ImageIcon("picture/gounki.png"));
	JButton b4 =new JButton(new ImageIcon("picture/jdv.png"));
	JButton b5 =new JButton(new ImageIcon("picture/mar.png"));
	JButton b6 = new JButton(new ImageIcon("picture/piepoepie.png"));
	JButton b7 =new JButton(new ImageIcon("picture/pip.png"));
	JButton b8 =new JButton(new ImageIcon("picture/snake.png"));
	public Inter(){
		this.setTitle("Boite a jeux V1");
		this.setSize(800, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setLayout(new GridLayout(4, 3));
		 b.addActionListener(this);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
		 b6.addActionListener(this);
		 b7.addActionListener(this);
		 b8.addActionListener(this);
		 
		this.getContentPane().add(b);
		this.getContentPane().add(b1);
		this.getContentPane().add(b2);
		this.getContentPane().add(b3);
		this.getContentPane().add(b4);
		this.getContentPane().add(b5);
		this.getContentPane().add(b6);
		this.getContentPane().add(b7);
		this.getContentPane().add(b8);
		
	
		this.setVisible(true);
	}
	public static void main(String[]args){
		new Inter();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==b){
			new Applica();
		}else if(arg0.getSource()==b1){
			new Fenetrechess();
		}else if(arg0.getSource()==b2){
			new Appli() ;
		}else if(arg0.getSource()==b3){
			Gounki g = new Gounki() ;
		//	this.requestFocusInWindow();
		}
		else if(arg0.getSource()==b4){
			new Jeuvie() ;
		}
		else if(arg0.getSource()==b5){
			new Mario1() ;
		}else if(arg0.getSource()==b6){
			new Morpion() ;
		}else if(arg0.getSource()==b7){
			new Iimanga() ;
		}else if(arg0.getSource()==b8){
			new Snake() ;
		}
		
	}
}
