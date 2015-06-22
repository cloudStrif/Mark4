import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
/*
 * EVOLUTION DE LA FRACTALE COURVE DU DRAGON
 */
class Dragon extends JPanel{

	Color color = Color.red ; 
	boolean verifion = false ;
	JFrame fr ;
	
	private JMenuBar m = new JMenuBar() ;
	private JMenu m1 = new JMenu("Quit") ;
	public JMenuItem i1 = new JMenuItem("Quitter") ;
	
	/*
	 * Evolution de la barrede menu
	 */
	
    public   void pause(int a){
	try{
	    Thread.sleep(a) ;
	}catch(Exception e){}
    }
    
    public int i  =1 ;
    public Dragon(Color r , boolean b){
    verifion=b ; 	
    color=r ;	
	 fr = new JFrame() ;
	fr.setTitle("Wait ....");
	fr.setSize(500,400);
	fr.setContentPane(this);
	fr.setLocationRelativeTo(null);
	fr.setUndecorated(true);

	fr.setVisible(true);
	if(verifion){
		m1.add(i1);
		
		i1.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent event){
 				fr.dispose() ;
 			}
 		});
		i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		m.add(m1);
		
		fr.setJMenuBar(m);
		
	}
	
	
	

	
	for(int ii  =1 ; ii < 15 ; ii++){
	    i++; 
	   this.repaint() ;
	    pause(500);
	}
	fr.dispose() ;
	
	
    }
    
    static void dragon(int n, int x, int y, int z, int t,Graphics g) {
	int u, v ;
	if (n == 1) {
	    g.drawLine(x,y,z,t);
	    
	    
	}
	else {
	    u = (x + z + t - y) / 2 ;
	    v = (y + t - z + x) / 2 ;
	    dragon(n - 1, x, y, u, v,g) ;
	    dragon(n - 1, z, t, u, v,g) ;
	    
	}
	
	
    }
    
    static void dragon2(int n, int x, int y, int z, int t,Graphics g) {
	
	int u, v ;
	if (n == 1) {
	    g.drawLine(x,y,z,t); 
	    
	}
	else {
	    u = (x + z + t - y) / 2 ;
	    v = (y + t - z + x) / 2 ;
	    dragon2(n - 1, x, y, u, v,g) ;
	    dragon3(n - 1, u, v, z, t,g) ;
	    
	}
    }
    /*
     * Fonction recursif 
     */
    
    static void dragon3(int n, int x, int y, int z, int t,Graphics g) {
	int u, v ;
	if (n == 1) {
	    g.drawLine(x,y,z,t) ;    
	    
	}
	else {
	    u = (x + z - t + y) / 2 ;
	    v = (y + t + z - x) / 2 ;
	    dragon2(n - 1, x, y, u, v,g) ;
	    dragon3(n - 1, u, v, z, t,g) ;
	}
    }
    
    public void paintComponent(Graphics g){
	g.setColor(Color.black);
	g.fillRect(0,0,700,700);
	g.setColor(color);
	dragon2(i, 249, 249, 100, 100,g) ;
    
	//dragon3(i,  200, 120, 100, 100,g) ;
    }
    
    public static void main(String[]args){
	new Dragon(Color.blue , true);
    }
    
    
}
