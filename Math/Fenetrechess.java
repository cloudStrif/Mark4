import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Fenetrechess extends JFrame{
    private P p = new P() ;
    private JPanel container = new JPanel();
    private JTextField jtf 		 ;
    private JLabel label = new JLabel("Chess Game ");
    public JMenuBar bar = new JMenuBar() ;
    public JMenu menu1 = new JMenu("Parametre") ;
    public JMenu menu2 = new JMenu("?") ;
    public JMenu menu3 = new JMenu ("Couleur type") ;
    public JMenuItem c1 = new JMenuItem("classique");
    public JMenuItem c2 = new JMenuItem("Vert");
    public JMenuItem c3 = new JMenuItem("Bois ");
    
    public JMenuItem items = new JMenuItem("Recommencer La partie") ;
    public JMenuItem item1 = new JMenuItem("Sauvegarder la partie") ;
    public JMenuItem item2 = new JMenuItem("Score des Parties enregistres") ;
    public JMenuItem item3 = new JMenuItem("Intelligence artificielle") ;
    
    //public JMenuItem item4 = new JMenuItem("Sauvegarder la partie") ;
    public JMenuItem item5 = new JMenuItem("Quitter") ;
    public JMenuItem item6 = new JMenuItem("A propos") ;
    public Memoire  m  = new Memoire () ;
    
    
    public Fenetrechess(){
	this.setTitle("Chess Game - PC");
	// this.setSize(375, 425);
	this.setSize(368, 420);
	
	this.setLocationRelativeTo(null);
	
	
	
	
	
	
	String tete  = m.af("couleur.txt");
	System.out.println(tete.charAt(0) +"  tete.length =" + tete.charAt(1));
	
	p.couleur = (int) tete.charAt(0);
	p.couleur = p.couleur - 48 ;
	
	
	menu1.add(item1);
	item1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		    //m.fg = true ;
		    String echec = "" ;
		    for(int  i = 0 ; i <  8 ; i ++){
			for(int j = 0 ; j < 8 ; j ++){
			    echec  = echec  + Integer.toString(p.c[i][j]) ;
			}
			
		    }
		    int colo = p.couleur ;
		    echec = echec  + Integer.toString(p.couleur) ;
		    try {
			new FileWriter(new File("sauvegarde.txt")).close();
			new FileWriter(new File("couleur.txt")).close();
			m = new Memoire(echec,"sauvegarde.txt") ;
			m = new Memoire(Integer.toString(colo),"couleur.txt") ;
		    } catch (IOException e) {
			
			e.printStackTrace();
		    }
		    
		    
		    
		}
	    });
	
	JMenuItem ite = new JMenuItem("Generer la partie sauvegarde") ;	
	menu1.add(ite);
  	ite.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent event){
		    
		    String terr = m.af("sauvegarde.txt") ;
		    if(!terr.isEmpty()){
			String test = "" ;
			int num = 0 ;
			for(int ii = 0 ; ii < 8 ; ii ++){
			    for(int jj = 0 ; jj < 8 ; jj ++){
			    
				test = String.valueOf(terr.charAt(num));
				if(test.equals("-")){
				    num ++ ;
				    p.c[ii][jj] = -1 * Integer.parseInt(String.valueOf(terr.charAt(num)));
				}else {
				    p.c[ii][jj] = Integer.parseInt(test);
				}
				if(num < 120){	
				    num ++ ;
				}
			    }
			}
		    
			/*try{
			  int numeros = Integer.parseInt(m.af("couleur.txt"));
			  p.couleur = numeros ;
			  }catch(NumberFormatException e){
			  e.printStackTrace() ;
			  }*/
			p.repaint();
  		
		    }
  		}
	    });
  	
  	menu3.add(c1);
  	c1.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent event){
		    p.couleur = 0 ;
		    try {
			new FileWriter(new File("couleur.txt")).close();
			m = new Memoire(Integer.toString(p.couleur),"couleur.txt") ;
		    } catch (IOException e) {
			
			e.printStackTrace();
		    }
		    
		    
		    p.repaint();
  		}
	    });
  	
  	menu3.add(c2);
  	c2.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent event){
		    p.couleur = 1 ;
		    try {
			new FileWriter(new File("couleur.txt")).close();
			m = new Memoire(Integer.toString(p.couleur),"couleur.txt") ;
		    } catch (IOException e) {
			
			e.printStackTrace();
		    }
		    p.repaint();
  		}
	    });
  	menu3.add(c3);
  	c3.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent event){
		    p.couleur = 2 ;
		    try {
			new FileWriter(new File("couleur.txt")).close();
			m = new Memoire(Integer.toString(p.couleur),"couleur.txt") ;
		    } catch (IOException e) {
			    
			e.printStackTrace();
		    }
		    p.repaint();
  		}
	    });
	menu1.add(item2);
	menu1.add(item3);
	// meanu1.add(item4);
	menu1.add(items);
	items.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		    p.c = p.c2 ;
		    p.tour = true ;
		    p.repaint();
		}
	    });
	    
	menu1.add(item5);
	item5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		    dispose();
		    //System.exit(0);
		}
	    });
	item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		
		
	menu2.add(item6);
		
	bar.add(menu1);
	bar.add(menu3);
	bar.add(menu2);
		
		
	container.setBackground(Color.white);
	container.setLayout(new BorderLayout());
	container.add(p, BorderLayout.CENTER);
		
		
	// setIconImage(new ImageIcon(this.getClass().getResource("images/BlackKnight.png")).getImage());
	jtf = new JTextField();
		
	JPanel south = new JPanel();
	south.add(jtf);
		
	jtf.setPreferredSize(new Dimension(0, 0));
	jtf.addKeyListener(new ClavierListener());
	container.add(south , BorderLayout.SOUTH);
	/* Font police = new Font("Tahoma", Font.BOLD, 16);
	   label.setFont(police);
	   label.setForeground(Color.red);
		   
	   label.setHorizontalAlignment(JLabel.CENTER);
	   container.add(label, BorderLayout.SOUTH);*/
		
		
	this.setContentPane(container);
	this.setJMenuBar(bar);
	this.setVisible(true);
		
    }
    
    
    
    class ClavierListener implements KeyListener{
	
	public void keyPressed(KeyEvent event) {
	    
	    if(event.getKeyCode() == 65){
		JOptionPane i = new JOptionPane() ;
		i.showMessageDialog(null ,"Voici le niveau du jeu pour ","Niveau de difficult�" , JOptionPane.INFORMATION_MESSAGE);
	    }
	    if(event.getKeyCode() == 78){
		System.exit(0) ;
	    }
	    if(event.getKeyCode() == 73){
		p.ia = true ;
		
	    }
	    
	    System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
	      
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
    
    
    
    public static void main(String[] args) {
    	Fenetrechess f = new Fenetrechess() ;
	
    }
    
}
