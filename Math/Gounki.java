
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;//le detail avec eclipse
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;  
import java.util.Stack ;//pile

public class Gounki extends JFrame implements ActionListener{
  private JTextField jtf; 
  private G2 pan = new G2();
 
  private JPanel container = new JPanel();
  private JLabel label = new JLabel("c'est le tour du Joueur 1 ");
  private int compteur = 0;
  private JMenuBar m = new JMenuBar();
  private JMenu pp = new JMenu ("Parametres");
  private JMenuItem i = new JMenuItem("man vs man");
  private JMenuItem oo = new JMenuItem("man vs cpu");
  private JMenuItem rr = new JMenuItem("Cpu vs Cpu ");
  private JMenu p2 = new JMenu ("Scores");
  private JMenuItem lol = new JMenuItem("Scores de la derni�re partie");
  private JMenuItem  rest = new JMenuItem ("Recommencer la partie");
  private JMenuItem  quit = new JMenuItem("Quitter le jeu");
   private JMenuItem  retour = new JMenuItem("Revenir en arriere");
     private JMenuItem  rule = new JMenuItem("Quelques mots sur les regles");
   public boolean te = false ;
    public int push = 0 ;
    public int [] g ;
    public int [] d ;

  public Gounki(){
	  
    this.setTitle("Jeu du Gounki - L");
    this.setSize(420, 400);
   
    this.setLocationRelativeTo(null);
   
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    container.add(pan, BorderLayout.CENTER);
          jtf = new JTextField();

jtf.setPreferredSize(new Dimension(0, 0));
jtf.addKeyListener(new ClavierListener());
    //bou.addActionListener(this);
         // b.addActionListener(this);
    //bouton2.addActionListener(this);
      //b2.addActionListener(this);
      pp.add(i) ;
      pp.add(oo);
      pp.add(rr) ;
      p2.add(lol);
     
      lol.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent event){
	JOptionPane jo = new JOptionPane();

	jo.showMessageDialog(null ,"Nombre de pieces blanches carr�s " +pan.nbblanc[0]+ "\nNombre de rond blanc :" + pan.nbblanc[1] +"\nNombre de pieces noirs carr�s" +pan.nbblanc[2]+"\nNombre de rond noir :" + pan.nbblanc[3],"Score entre les Blancs et noirs" , JOptionPane.INFORMATION_MESSAGE);
	}
	});
	
	p2.add(rule); 
	rule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent event){
	           JOptionPane j1 = new JOptionPane();
          ImageIcon q1 = new ImageIcon("images/gounki.jpeg");
	j1.showMessageDialog(null ,"Bienvenu dans le jeu du gounki \n Voici les regles principales :\n On gagne lorsque on a mang� toutes les pieces \n ou lorsqu'une piece est au bout du terrain adverse","Regles" , JOptionPane.INFORMATION_MESSAGE,q1);
	 JOptionPane j2 = new JOptionPane();
          ImageIcon q2 = new ImageIcon("images/carré.png");
	j2.showMessageDialog(null ,"Voici comment se deplace les carr�s","Regles" , JOptionPane.INFORMATION_MESSAGE,q2);
	 JOptionPane j3 = new JOptionPane();
          ImageIcon q3 = new ImageIcon("images/rond.png");
	j3.showMessageDialog(null ,"Voici comment se deplace les ronds","Regles" , JOptionPane.INFORMATION_MESSAGE,q3);
	 JOptionPane j4 = new JOptionPane();
          ImageIcon q4 = new ImageIcon("images/piece.png");
	j4.showMessageDialog(null ,"Voici l'emsemble des pieces existante,on les obtient en mangeant d'autre pieces","Regles" , JOptionPane.INFORMATION_MESSAGE,q4);
	
	 JOptionPane j5 = new JOptionPane();
          ImageIcon q5 = new ImageIcon("images/doubles.png");
	j5.showMessageDialog(null ,"Par exemple , les doubles carr�s et rond \n bouge ainsi","Regles" , JOptionPane.INFORMATION_MESSAGE,q5);
	
	
	
	}
	});
	
	
		
      p2.add(rest);
      rest.addActionListener(new ActionListener(){    
       public void actionPerformed(ActionEvent event){
       for(int i =0 ;i < pan.t.length ; i++){
       if(i % 2 == 0){
       pan.t[0][i] = 1;
       pan.t[1][i] = 2;
       pan.t[6][i] =-1 ;
       pan.t[7][i] = -2;
       }else {
        pan.t[0][i] = 2;
       pan.t[1][i] = 1;
       pan.t[6][i] =-2 ;
       pan.t[7][i] = -1; 
       }
        pan.t[2][i] = 0;
       pan.t[3][i] = 0;
       pan.t[4][i] =0 ;
       pan.t[5][i] = 0; 
 	// A revoir pour lIA     
       }
       pan.repaint() ;
       
       }
      });
      
      rest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
      p2.add(rest);
      p2.add(quit) ;
       quit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent event){
        dispose() ;
	}
	});
	quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
      p2.add(quit);
     
      rest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
       p2.add(retour);
        retour.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent event){
          int g = pan.pd.pop() ; int d = pan.pa.pop() ;
          int g2 = pan.pd.pop() ; int d2 = pan.pa.pop() ;
           //System.out.println(g[0] +" "+g[1]+" dans Fenetre "+d[0]+" "+ d[1]);
           pan.t[g][g2] =  pan.pie.pop();
           pan.t[d2][d] = 0;
           if(pan.tour ==false){
           pan.tour = true ;
	pan.repaint() ;}
	else {pan.tour = false ;pan.repaint();}
	}
	});
       retour.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_MASK));
       p2.add(retour);
       
       
       
      m.add(pp) ;
      m.add(p2);
      this.setJMenuBar(m);
      
      
      
    JPanel south = new JPanel();
    south.add(jtf);
   // south.add(bou);
    //south.add(b);
   //south.add(bouton2);
          // south.add(b2);
    container.add(south, BorderLayout.SOUTH);

    Font police = new Font("Tahoma", Font.BOLD, 16);
    label.setFont(police);
    label.setForeground(Color.blue);
    
    label.setHorizontalAlignment(JLabel.CENTER);
    container.add(label, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true);
    
    
  }
  

   class ClavierListener implements KeyListener{
  /*  public void estdans(int a ){
     if(a<0) return true ;
     else return false ;
             
    }
    //IA primaire ,qui fait tout au pif
    public void alea (int [][] t){
    ArrayList<Integer> x = new ArrayList<Integer>() ;
    ArrayList<Integer> y = new ArrayList<Integer>() ;
    ArrayList<Integer> pp = new ArrayList<Integer>() ;
    for(int i = 0 ; i < pan.t.length ; i++){
            for(int j =0 ; j< pan.t[0].length ; j++){
                    if(t[i][j] == -1 && i+1 <t.length && i-1 > 0){
                      x.add(i+1);x.add(i-1)
                      y.add(0);y.add(0);
            
   
                    }     
    
          }
    }
    
    
    
    } */
    public void keyPressed(KeyEvent event) {
    
    
    
    
    
          if(pan.tour == false){
          label.setText("c'est au tour des Noirs");
         
          }
          if(pan.tour == true){
          label.setText("C'est au tour des Blancs");
          }
          
          if(pan.winB(pan.t) == true ){
          label.setText("VICTOIRE DES BLANCS !");
           JOptionPane jo = new JOptionPane();
ImageIcon qsd = new ImageIcon("images/blanc.png");
	jo.showMessageDialog(null ,"VICTOIRE DES BLANCS !","Victoire !" , JOptionPane.INFORMATION_MESSAGE,qsd);
          }
          if(pan.winN(pan.t) == true ){
          label.setText("VICTOIRE DES NOIRS");
           JOptionPane jo = new JOptionPane();
          ImageIcon qs = new ImageIcon("images/noir.png");
	jo.showMessageDialog(null ,"VICTOIRE DES NOIRS !","Victoire !" , JOptionPane.INFORMATION_MESSAGE,qs);
          }
          
          if(event.getKeyCode() == 39){
          pan.a = pan.a + 45 ;
          pan.j = pan.j + 1; 
          pan.repaint() ;
          } 
            if(event.getKeyCode() == 37){
          pan.a = pan.a - 45 ;
          pan.j = pan.j - 1 ;
          pan.repaint() ;
          } 
           if(event.getKeyCode() == 40){
          pan.b = pan.b + 37 ;
          pan.i = pan.i + 1 ;
          pan.repaint() ;
          } 
          if(event.getKeyCode() == 38){
          pan.b = pan.b - 37 ;
           pan.i = pan.i - 1 ;
          pan.repaint() ;
          } 
          
           if(event.getKeyCode() == 10 || event.getKeyCode() == 32  ){
           pan.push ++ ;
           if(pan.push == 1){
           
           pan.tes = true ;pan.repaint() ;
           pan.ef = 1 ;}
           else {
           //pan.tes = false ;
           pan.repaint() ;
           //pan.push = 0 ;
           
           }
           
           }
           
           
           System.out.println(pan.pos[0] +" et "+pan.pos[1]); 
      //System.out.println("Code touche press�e : " + event.getKeyCode() + " - caract�re touche press�e : " + event.getKeyChar());
      //pause();
    }

          public void keyReleased(KeyEvent event) {
     /* System.out.println("Code touche rel�ch�e : " + event.getKeyCode() + " - caract�re touche rel�ch�e : " + event.getKeyChar());         
      pause();*/           
    } 

    public void keyTyped(KeyEvent event) {
     /* System.out.println("Code touche tap�e : " + event.getKeyCode() + " - caract�re touche tap�e : " + event.getKeyChar());
      pause();*/   
    }   	
  } 
    
  


public void pause(){//pause
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }	
     
	
}


  public void actionPerformed(ActionEvent arg0) {
  /*        if(arg0.getSource() == b2){
         
                   
                   
  }
 if(arg0.getSource() == bouton2){
  
       
    label.setText("jouer en mode 1 joueur");
    }
    
    if(arg0.getSource() == bou) {
      
      
    
     }  */

    
}
 
  public static void main(String []args ){
	  new Gounki() ; 
  }
     





}