

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class Mario1 extends JFrame{

    private JPanel container = new JPanel();
    private JTextField jtf; 
	
    private Mario2 pan = new Mario2() ;
    //Action qui s'execute en meme temps
    Thread debu ,saut,piece,deplacement;
		 
    Boolean [] sens = {false,false};
    //Tableau de Brui qui va gerer le son 
    private Brui [] bruitage = new Brui [30] ;
  //Objet qui va recuperer un niveau 
    Memoire mem = new Memoire() ;
    String ter ;
    int limite = 0 ;
    boolean bool=false;
	   
    int posivion =0 ;
    
    
    
    
    public Mario1(){
	this.setTitle("Mario By L");
	this.setSize(600, 600);
	
		
	container.setLayout(new BorderLayout());
	container.add(pan, BorderLayout.CENTER);
	jtf = new JTextField();
			
	jtf.setPreferredSize(new Dimension(0, 0));
	jtf.addKeyListener(new ClavierListener());
	JPanel south = new JPanel();
	south.add(jtf);
	container.add(south, BorderLayout.SOUTH);
	this.setContentPane(container);
	this.setVisible(true);
	pan.t[pan.posx][pan.posy]=1;
		
	stark("map");
		
    }
	
    public void stark(String m){
	ter = mem.af(m);
	//System.out.println(ter.charAt(22)+"==");
	System.out.println(reste(ter,9));
	avancer(ter,0);
	//pan.MAP=-2;
	debu = new Thread(new Debu());
	//debu.start() ;
			
	bruitage [0] = new Brui("sounds/mario_theme_song",true);
	
	//	bruitage[0].lop() ;
	bruitage [1] = new Brui("sounds/mario_letsgo",true);
	//	bruitage[1].jou() ;
	bruitage [2] = new Brui("sounds/jump",true);
			
	bruitage[10] = new Brui("sounds/mario_mamamia1.wav",true);
	saut = new Thread(new Piece());
	saut.start();
    }
	
    //Calcul le reste a parcourir 
    public int reste(String tmp , int pos){
	int res = 0 ;
	while(true){	
	    if(tmp.charAt(pos)=='\n'){
	    	break;
	    }
	    pos++ ;
	    res++;
	}
	return res ;
    }
	
	
	
    public void avancer(String r,int tmp){
	int gg=tmp ;
	for(int i =0 ; i< 12 ; i++){
	    for(int j=limite ; j < 10 ; j++){
		pan.t[i][j] = Integer.parseInt(Character.toString(r.charAt(tmp))) ;
		tmp++;
		System.out.print(pan.t[i][j]);
	    }
	    tmp = tmp+ reste(r,tmp)+1+gg;
	    System.out.println();
	}
	pan.t[pan.posx][pan.posy]=1;
		
    }
	
	
    class ClavierListener implements KeyListener{

	public void keyPressed(KeyEvent event) {
		if(pan.posx >= 11){
			System.out.println("perdu");
			Brui bru = new Brui("sounds/mario_mamamia1",true);
			bru.jou();
			pause(2000);
			dispose();
			new Mario1() ;
		}
			
	 
			
	    if(event.getKeyCode()==10){
	    	pan.MAP=0 ;
	    	pan.repaint();
	    	debu.stop() ;
	    }
			  
	    //DEBUG
	    if(event.getKeyCode() == 68){
	    	sens[0]=false;
	    	sens[1]=false;
	    }
			  
	    if(pan.t[pan.posx][pan.posy+1]==6 ){
				  
		bruitage[11] = new Brui("sounds/win_stage",true);
		bruitage[11].jou() ;
		bruitage[0].stop();
		pause(7000);
		pan.x =0 ;
		pan.y = 0 ;
		posivion=0 ;
		pan.orientation = 0; 
		pan.avance =2 ;
					
		pan.posx=9;
		pan.posy=1;
					
		pan.orientationa = 1 ;
		pan.avanca =1 ;
		stark("map2");
		bruitage [22] = new Brui("sounds/mario_theme_song",true);
		bruitage[22].lop() ;
		pan.repaint() ;
				
				  
	    }
			
	    if(event.getKeyCode() == 39 ){
	 
	    	if(!sens[0])
	    	{
	    		deplacement = new Thread(new Deplacement(0));
	    		deplacement.start();
	    	}
	    	
	/*	pan.orientation=0;
		if(pan.avance >=3)
		    pan.avance=0 ;
		pan.avance ++ ;	  
		if (pan.t[pan.posx][pan.posy+1]==0 || pan.t[pan.posx][pan.posy+1]==7){
		    if(pan.posy==7){
			
			posivion++ ;
			avancer(ter,posivion);
						
			pan.repaint();
		    }else{
			pan.t[pan.posx][pan.posy]=0 ;
			pan.t[pan.posx][pan.posy+1]=1 ;
			pan.posy++;
		    }
		    
		}		  
			pan.repaint() ;	 */ 
	    }
	    
	    	
	    	
	    if(event.getKeyCode() == 37){
	    	if(!sens[1])
	    	{
	    		deplacement = new Thread(new Deplacement(1));
	    		deplacement.start();
	    	}
	    	/*	pan.orientation=1;
		if(pan.avance >=3)
		    pan.avance=0 ;
		pan.avance ++ ;
				  
		if (pan.t[pan.posx][pan.posy-1]==0 || pan.t[pan.posx][pan.posy+1]==7){
		    if(pan.posy==2 && posivion != 0){
						
			posivion-- ;
			avancer(ter,posivion);
						
			pan.repaint();
		    }else{	  
			pan.t[pan.posx][pan.posy]=0 ;
			pan.t[pan.posx][pan.posy-1]=1 ;
			pan.posy--;
		    }
		}
		pan.repaint() ;		  
	    */
	    
	    }	  
	    
	    if(event.getKeyCode()==38){
	    	if(!bool){
				 saut = new Thread(new Saut(0));
				 saut.start() ;
	    	}
	    }
	    
	   
				
			  
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	    // TODO Auto-generated method stub
		   if(pan.t[pan.posx+1][pan.posy]==0 && !bool){
		    	if(saut != null){
			    	saut = new Thread(new Saut(1));
			    	saut.start() ;
				}
		    }
		   
		   if(arg0.getKeyCode() == 39 ){
			   if(!sens[0]){
				   	sens[0]=false ;
			  
			
				   	deplacement.stop() ;
			   }   
		   }
		   if(arg0.getKeyCode() == 37 ){
			   if(!sens[1]){
				   	sens[1]=false ;
			  
			
				   	deplacement.stop() ;
			   }   
		   }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	    // TODO Auto-generated method stub
		
	}
		  
    }
    public void pause (int a){
	try {
	    Thread.sleep(a);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}	
    }
	  
	 /*
	  * Gere les deplacements a gauche et a droite 
	  */
    class Deplacement implements Runnable{
    	int orien ;
    	int max;
    	public Deplacement(int o){
    		this.orien=o ;
    	}
    	
    	public void run(){
    		if(bool){
    			max = 2;
    		}else{
    			max = 1 ;
    		}
    		if(this.orien==0){
        		for(int i =0 ; i < max;i++){	
        			sens[0]=true ;
        			pan.orientation= 0;

    			if(pan.avance >=3)
    			    pan.avance=0 ;
    			pan.avance ++ ;	 
    			
    			if (pan.t[pan.posx][pan.posy+1]==0 || pan.t[pan.posx][pan.posy+1]==7){
    			    if(pan.posy==7){
    				
    				posivion++ ;
    				avancer(ter,posivion);
    			
    				pan.repaint();
    			    }else{
    				pan.t[pan.posx][pan.posy]=0 ;
    				pan.t[pan.posx][pan.posy+1]=1 ;
    				pan.posy++;
    				
    			    }
    		
    			}	
    			pause(80);
    			pan.repaint() ;
    		
    		}
        		sens[0]=false ;
    		}else if(this.orien==1){
    			for(int i =0 ; i< max ;i++){
    				sens[1]=true ;
    			pan.orientation=1;
    			if(pan.avance >=3)
    			    pan.avance=0 ;
    			pan.avance ++ ;
    					  
    			if (pan.t[pan.posx][pan.posy-1]==0 || pan.t[pan.posx][pan.posy+1]==7){
    			    if(pan.posy==2 && posivion != 0){
    							
    				posivion-- ;
    				avancer(ter,posivion);
    							
    				pan.repaint();
    			    }else{	  
    				pan.t[pan.posx][pan.posy]=0 ;
    				pan.t[pan.posx][pan.posy-1]=1 ;
    				pan.posy--;
    			    }
    			}
    			pause(80);
    			pan.repaint() ;		
    		}
    			sens[1]=false ;
    		}
    	}
    }
    
    
    class Saut implements Runnable{
	int o ;
	public Saut(int o){
	    this.o=o;
	}
		  
	public void run(){
	    if(this.o==0){
		bool=true ;
		pan.orientation=2;
		pan.avance=1;
		bruitage[2].jou() ;
		for(int i=0; i < 3;i++){
				
		    if (pan.t[pan.posx-1][pan.posy]==0 || pan.t[pan.posx-1][pan.posy]==7){
					  
			pan.t[pan.posx][pan.posy]=0 ;
			pan.t[pan.posx-1][pan.posy]=1 ;
			pan.posx--;
		    }
		    pause(100);
		    pan.repaint();
		}
		for(int i=0; i < 3;i++){
					
		    if (pan.t[pan.posx+1][pan.posy]==0 || pan.t[pan.posx-1][pan.posy]==7){
			pan.t[pan.posx][pan.posy]=0 ;
			pan.t[pan.posx+1][pan.posy]=1 ;
			pan.posx++;
		    }
		    pause(100);
		    pan.repaint();
		}
		bool = false;
			  this.o=1 ;
			  run();
	    }else if(this.o==1){
		do{
		    if(pan.t[pan.posx+1][pan.posy]!=0 ){
			break ;
		    }
		    pan.t[pan.posx][pan.posy]=0;
		    pan.t[pan.posx+1][pan.posy]=1;
		    pan.posx++;
		  /*  if(p<an.posx == 11 ){
			bruitage[10].jou() ;
			break ;
		    }*/
		    
			if(pan.posx >= 11){
				System.out.println("perdu");
				Brui bru = new Brui("mario_mamamia1",true);
				bru.jou();
				pause(2000);
				dispose();
				new Mario1() ;
			}
		    
		    
		    pause(200);
		    pan.repaint();
		}while(pan.t[1+pan.posx][pan.posy]==0);
				  
				  
	    }
	}
    }
	  
    class Piece implements Runnable{
	public void run(){
	    while(true){
		if(pan.avanca >=8)
		    pan.avanca=1 ;
			
		pan.avanca++ ;
		pan.repaint();
		pause(200);
	    }
	}
    }
	  
    class Debu implements Runnable{
	public void run(){
	    while(true){	
	    	pause(300);
	    	pan.repaint() ;
	    	pan.eff = false ;
	    	pause(300);
	    	pan.repaint() ;
	    	pan.eff = true;	
	    }
		}
    }
    
    class Gravite implements Runnable{
    	public void run(){
    		
    	}
    }
    
    public static void main(String[]args){
    	new Mario1() ;
    }
}
