


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Casse extends JFrame{

    private JPanel container = new JPanel();
    private JTextField jtf; 
		
    private casse2 pan = new casse2() ;

    
    Thread [] tab = new Thread[10];
    
    public Casse(){
	this.setTitle("CASSE BRIQUE");
	this.setSize(600, 600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
		
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
	setVisible(true);
	tab[0] = new Thread(new Balle(0));
	tab[0].start() ;

    }
	
    class ClavierListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent event) {
	    // TODO Auto-generated method stub
	    System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
	
	    if(event.getKeyCode()==37){
	    	if(pan.pos ==1 ){}else{
	    	pan.t[19][pan.pos+1]=0 ;
	    	pan.pos-- ;
	    	pan.repaint() ;
	    	}
	    }
	
	    if(event.getKeyCode()==39){
	    	if(pan.pos ==18 ){}else{
	    	pan.t[19][pan.pos-1]=0 ;
	    	pan.pos++ ;
	    	pan.repaint() ;
	    	}
	    }
	    
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	    // TODO Auto-generated method stub
			
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
    
    class Balle implements Runnable{
    	int o ; 
    	public Balle(int y){
    		this.o=y;
    	}
    	
  
    	public void run(){
    		while(true){
    			//Tombe en bas en ligne droite
    		if(this.o==0){
    			while(true){
    			if(pan.balle[0] ==20){
    				break ;
    			}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==1 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==1 ){
    				this.o = 2 ;
    				break ;
    			}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==0 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==1 ){
    				this.o = 1 ;
    				break ;
    			}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==0 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==1 ){
    				this.o = 3 ;
    				break ;
    			}
    			
    			
    			
    			pan.t[pan.balle[0]][pan.balle[1]] = 0;
    			pan.balle[0]++ ;
    			pan.t[pan.balle[0]][pan.balle[1]] = 1;
    			pause(100);
        		pan.repaint() ;
    			}
    		}
    		//balle envoyé en ligen droite en haut
    		
    		else if(this.o==2){
    			while(true){
        			if(pan.balle[0] ==1){
        				this.o=0;
        				break ;
        			}
        			if(pan.t[pan.balle[0]-1][pan.balle[1]]==2){
        				pan.t[pan.balle[0]-1][pan.balle[1]]=0;
        				this.o = 0 ;
        				break ;
        			}
        			pan.t[pan.balle[0]][pan.balle[1]] = 0;
        			pan.balle[0]-- ;
        			pan.t[pan.balle[0]][pan.balle[1]] = 1;
        			pause(100);
            		pan.repaint() ;
    			}
    		}
    		//en diagonale droite
    		else if(this.o==1){
    			while(true){
    				if(pan.balle[0] ==1){
    					pan.t[pan.balle[0]-1][pan.balle[1]]=0;
        				//diagonal droit bas
    					this.o=4;
        				break ;
        			}
    				if(pan.t[pan.balle[0]-1][pan.balle[1]+1]==2){
        				pan.t[pan.balle[0]-1][pan.balle[1]+1]=0;
        			//diagonal droit bas 
        				this.o=4;
        				break ;
        			}
    				if(pan.balle[1]==18){
    					this.o=3;
    					break ;
    				}
    				
    			
    				pan.t[pan.balle[0]][pan.balle[1]] = 0;
    				pan.balle[0]-- ;
    				pan.balle[1]++ ;
    				pan.t[pan.balle[0]][pan.balle[1]] = 1;
    				pause(100);
            		pan.repaint() ;
    				
    			}
    		}
    		else if(this.o==3){
    			while(true){
    				if(pan.balle[0] ==1){
    					pan.t[pan.balle[0]-1][pan.balle[1]]=0;
        				//diagonale bas gauche
    					this.o = 5 ;
        				break ;
        			}
    				if(pan.t[pan.balle[0]-1][pan.balle[1]-1]==2){
        				pan.t[pan.balle[0]-1][pan.balle[1]-1]=0;
        				//diagonale bas gauche
        			this.o = 5;
        				break ;
        			}
    				if(pan.balle[1]==1){
    					this.o=1;
    					break ;
    				}
    			
    				pan.t[pan.balle[0]][pan.balle[1]] = 0;
    				pan.balle[0]-- ;
    				pan.balle[1]-- ;
    				pan.t[pan.balle[0]][pan.balle[1]] = 1;
    				pause(100);
            		pan.repaint() ;
    				
    			}
    		}else if (this.o==4){
    			while(true){
    			if(pan.balle[1]==19){
    				this.o=5;System.out.println("defaite");
    				break ;
    			}
    			
    			if(pan.t[pan.balle[0]+1][pan.balle[1]+1] == 2 && pan.t[pan.balle[0]][pan.balle[1]+1] == 2  && pan.t[pan.balle[0]+1][pan.balle[1]] == 0 ){
    				this.o = 5;
    				break ;	
    			}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]+1] == 2){
					pan.t[pan.balle[0]+1][pan.balle[1]+1] = 0;
					this.o = 1;
					break;
				}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==1 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==1 ){
    				this.o = 2 ;
    				break ;
    			}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==0 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==1 ){
    				this.o = 1 ;
    				break ;
    			}
    			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==0 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==1 ){
    				this.o = 3 ;
    				break ;
    			}
    			
    			
    			pan.t[pan.balle[0]][pan.balle[1]] = 0;
				pan.balle[0]++ ;
				pan.balle[1]++ ;
				pan.t[pan.balle[0]][pan.balle[1]] = 1;
				pause(100);
        		pan.repaint() ;
    			}
    		}else if(this.o==5){
    			while(true){
    				if(pan.balle[1]==0){
        				this.o=4;System.out.println("defaite");
        				break ;
        			}
    				
    				if(pan.t[pan.balle[0]+1][pan.balle[1]-1] == 2){
    					pan.t[pan.balle[0]+1][pan.balle[1]-1] = 0;
    					this.o = 3;
    					break;
    				}
    				
    				if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==1 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==1 ){
        				this.o = 2 ;
        				break ;
        			}
        			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==0 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==1 ){
        				this.o = 1 ;
        				break ;
        			}
        			if(pan.t[pan.balle[0]+1][pan.balle[1]]==1 && pan.t[pan.balle[0]+1][pan.balle[1]-1]==0 && pan.t[pan.balle[0]+1][pan.balle[1]+1]==1 ){
        				this.o = 3 ;
        				break ;
        			}
    				
    			pan.t[pan.balle[0]][pan.balle[1]] = 0;
				pan.balle[0]++ ;
				pan.balle[1]-- ;
				pan.t[pan.balle[0]][pan.balle[1]] = 1;
				pause(100);
        		pan.repaint() ;
    			}
    		}
    		
    		
    		System.out.println("defaite");
    		}
    
    		
    	}
    }
	
 
}
