
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Iimanga extends JFrame{
    private JPanel container = new JPanel();
    private JTextField jtf; 
    Thread init ;
    int oo=-1 ;
    Thread gravite ,debu ,story,fall;
    AudioClip clip ;
    private Iimanga2 pan = new Iimanga2() ;
    boolean move = false;
    Thread couleur ;
	 
    public Iimanga(){
	this.setTitle("Dbz Battle By L");
	this.setSize(1000, 600);

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
		
	init = new Thread(new Init(0)) ;
	init.start();
	gravite = new Thread(new Gravite());
	//gravite.start() ;
	debu = new Thread(new Debu());
	debu.start() ;
	File deb = new File("ii.wav");
	try{
	    clip = Applet.newAudioClip(deb.toURL());
	}
	catch (MalformedURLException e)
	    {
		System.out.println(e.getMessage());
	    }
		
		
//	clip.loop() ;
		
		
    }
	
    public void pause (int a){
	try {
	    Thread.sleep(a);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}	
    }
	
    class ClavierListener implements KeyListener{

	public void keyPressed(KeyEvent event) {
			
	    if(event.getKeyCode()==10){
		pan.MAP=0 ;
		
		
		debu.stop() ;
		pan.eff=false;
		pan.repaint() ;
		story = new Thread(new Story());
		story.start() ;
		couleur= new Thread(new Color());
		couleur.start() ;
	    }	
			
	    System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
	    if(move){
		  
		if(event.getKeyCode()==39){
				

		    init.stop();
		    if(pan.MAP==2){
			init = new Thread(new Init(2));
			init.start() ;
		    }
		    else if(pan.MAP==3 && pan.tombe){
			pan.x=pan.x+15;
		    }else{
			init = new Thread(new Init(1));
			init.start() ;
		    }
				
				
				
		}
		if(event.getKeyCode()==37){
		    //if(oo==

		    init.stop() ;
		    if(pan.MAP==2){
			init = new Thread(new Init(1)) ;
			init.start() ;
		    }else if(pan.MAP==3 && pan.tombe){
			pan.x=pan.x-15;
		    }else{
			init = new Thread(new Init(2)) ;
			init.start() ;
		    }
		    //	}
		}
		if(event.getKeyCode()==40){
			
		    init.stop() ;
		    init = new Thread(new Init(0));
		    init.start() ;
		}
			
		if(event.getKeyCode()==65){
			
		    init.stop() ;
		    init = new Thread(new Init(3));
		    init.start() ;
		}
		if(event.getKeyCode()==38){
		    init.stop() ;
		    init = new Thread(new Init(4));
		    init.start() ;
		}
		
		if(pan.bool){//&& pan.y <=90){
		    init.stop() ;
		    init = new Thread(new Init(5));
		    init.start() ;
			
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
	 
    class Color implements Runnable{
	public void run(){
	    while(true){
		for(int i=0 ; i < 20 ; i++){
		    pan.co=i;
		    pause(1000);
		}
		for(int i=20 ; i > 0 ; i--){
		    pan.co=i;pause(1000); 
		}
	    }
	}
    }
	 
	 
    class Gravite implements Runnable{
	public void run(){
	    while(pan.y>=300){
		pan.y=+150 ;
		pan.repaint() ;
	    }
	    pause(200); 
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
	 
		
    class Story implements Runnable{
	public void run(){
	    pause(5000);
	    pan.ef=true ;
	    pan.repaint() ;
	    pause(5000);
	    pan.ef=false;
	    pan.repaint();
		
	    pause(5000);
	    pan.e=true ;
	    pan.repaint();
	    pause(5000);
	    pan.e=false;
	    pan.repaint() ;
			
	    move=true ;
	}
    }
	 
    class Init implements Runnable{
	int o =0 ;
		 
	public Init(int o){
	    this.o=o ;
	    oo=o;
	    pan.y=350 ;
	}
	public void run(){
		
			 
	    if(o==0){
		pan.orientation = 0 ;
		pan.avance=1 ;
		while(true){
		    for(int i = 1 ; i < 8 ; i++){
			pan.avance++ ;
			if(pan.tombe && pan.MAP==1){
			    for(int ii=0 ; ii < 7;ii++){
				pan.y=pan.y+20;
				pause(100);
				pan.repaint();
			    }
			    pan.MAP=-2 ;
			    pan.repaint();
			    pause(5000);
			    dispose();
			    new Iimanga();
			    clip.stop();
			    break ;
			}
				 
				 
				 
			pause(200);
			pan.repaint() ;
		    }
		    pan.avance =1 ;
		}
	    }else if (o==1){
		pan.orientation = 1 ;
		pan.avance =0 ;
		while(true){
		    for(int i = 1 ; i < 9 ; i++){
			pan.avance++ ;
			pause(70);
	  				
			if(pan.tombe && pan.MAP==1){
			    for(int ii=0 ; ii < 7;ii++){
				pan.y=pan.y+20;
				pause(100);
				pan.repaint();
			    }
			    pan.MAP=-2 ;
			    pan.repaint();
			    pause(5000);
			    dispose();
			    new Iimanga();
			    clip.stop() ;
						
						
			    break ;
			}
	  				 
			if(pan.tombe && pan.MAP==3){
			    fall=new Thread(new Fall());
			    fall.start();
			    break ;
			}
	  				 
	  				 
			if(pan.MAP!=1){
			    if(pan.x >=900){
	  					 
			    }else{
				pan.x = pan.x + 30 ;
			    }
	  				 
			}else{
			    if(pan.x >=900){
				pan.x=10;
			    }else{
				pan.x = pan.x + 30 ;
			    }
	  					
			}
			if(pan.x<=400 && pan.x>=300){
			    break ;
			}
	  				 
			pan.repaint() ;
		    }
		    pan.avance =1 ;
		}
	    	   
	    }else if(o==2){
		pan.orientation = 2 ;
		pan.avance =0 ;
		while(true){
		    for(int i = 1 ; i < 9 ; i++){
			pan.avance++ ;
			pause(70);
	  				
	  				 
			if(pan.tombe && pan.MAP==1){
			    for(int ii=0 ; ii < 7;ii++){
				pan.y=pan.y+20;
				pause(100);
				pan.repaint();
			    }
			    pan.MAP=-2 ;
			    pan.repaint();
			    pause(5000);
			    dispose();
			    new Iimanga();
			    clip.stop() ;
			    break ;
			}
					 
			if(pan.tombe && pan.MAP==3){
			    fall=new Thread(new Fall());
			    fall.start();
			    break ;
			}
	  				 
			if(pan.MAP!=1){
			    if(pan.x <=10){
	  					 
			    }else{
				pan.x = pan.x -30 ;
			    }
	  				 
			}else{
			    if(pan.x<=10){
				pan.x=800;
			    }else{
				pan.x = pan.x - 30 ;
			    }
			}
			pan.repaint() ;
		    }
		    pan.avance =1 ;
		}
	    }else if(o==3){
		pan.orientation = 3 ;
		pan.avance =1 ;
	    	   
		for(int i = 1 ; i < 23 ; i++){
		    pan.avance++ ;
		    pause(100);
		    System.out.println(pan.avance);
	  				 
	  				 
	  				 
		    if(pan.tombe && pan.MAP==1){
			for(int ii=0 ; ii < 7;ii++){
			    pan.y=pan.y+20;
			    pause(100);
			    pan.repaint();
			}
			pan.MAP=-2 ;
			pan.repaint();
			pause(5000);
			dispose();
			new Iimanga();
			clip.stop() ;
			break ;
		    }
					 
		    if(pan.tombe && pan.MAP==3){
			fall=new Thread(new Fall());
			fall.start();
			break ;
		    }
	  				 
		    if(pan.x <=10){
	  					
		    }else if(pan.x>=10){
			pan.x = pan.x+15 ;
		    }
	  				
	  			
	  				 
		    pan.repaint() ;
		}
		pan.avance =1 ;
	    }else if(o==4){
		pan.orientation = 4 ;
		pan.avance =0 ;
	  
		for(int i = 1 ; i < 9 ; i++){
		    pan.avance++ ;
		    pause(50);
	  				 
	  				 
	  				 
		    if(pan.tombe && pan.MAP==1){
			for(int ii=0 ; ii < 7;ii++){
			    pan.y=pan.y+20;
			    pause(100);
			    pan.repaint();
			}
			pan.MAP=-2 ;
			pan.repaint();
			pause(5000);
			dispose();
			new Iimanga();
			clip.stop() ;
			restart();
			break ;
		    }
		    if(pan.tombe && pan.MAP==3){
			fall=new Thread(new Fall());
			fall.start();
			break ;
		    }
	  				 
	  				 
		    if(pan.avance<=4){
			pan.x = pan.x +20 ;
			pan.y = pan.y -40 ;
		    }else{
			pan.y=pan.y+40;
			pan.x=+pan.x+40 ;
		    }
		    pan.repaint() ;
		}
		pan.avance =1 ; 
		pan.y=350 ;
	    }else if(o==5){
		pan.orientation = 5 ;
		pan.avance =0 ;
	  
		for(int i = 1 ; i < 4 ; i++){
		    pan.avance++ ;
		    pause(200);
	  			
		    pan.repaint() ;
		}
		pause(2000);
		pan.repaint();
		pan.MAP++ ;
		if(pan.MAP>=5){
		    pan.MAP=-3 ;
		    pan.repaint() ;
		    pause(5000);
		    clip.stop() ;
		    dispose() ;
		    new Iimanga() ;
		}
		restart() ;

	    }
			 
			 
	}
		 
	public void restart(){
	    pan.x=100;
	    pan.y=350;
	    pan.orientation=0 ;
	    pan.avance=1 ;
	    move=false ;
	    init = new Thread(new Init(0)) ;
	    init.start();
	    story = new Thread(new Story());
	    story.start() ;
	}
		 
    }
	 
    class Fall implements Runnable{
	public void run(){
	    pan.orientation=4;
	    pan.avance=3 ;
	    while(true){
		pan.y = pan.y + 20 ;
		if(pan.y>=550){
		    pan.y = 20 ;
		}
				 
		pan.avance ++ ;
		if(pan.avance>=8){
		    pan.avance =3 ;
		}
		pan.repaint();
		pause(100);
			
		if(!pan.tombe){
		    pan.y=350 ;
		    pan.repaint() ;
		    break ;
		}
			
	    }
	}
    }
	

    public static void main(String[]args){
	new Iimanga() ;
    }
}
