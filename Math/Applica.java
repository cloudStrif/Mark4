import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JFrame;
import javax.sound.sampled.*;
import javax.sound.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Applica extends JFrame{
	public JPanel container = new JPanel() ;
	public Appli2 p = new Appli2() ;
	
	public int fois = 0 ;
	
	public Thread tt ,tr;
	public Thread songo ,time ,boule ,action,debu;
	
	public int etat = 4 ;
	
	public Thread regress , saut3 , coupe ;
	public boolean sur = false;
	//Un tableau de clip aurai fait l'affaire !
	public AudioClip clip ,clip2 ,clip3,clip4 ,clip5,clip6,clip7 ,clip8 , clip9,clip10,clip11,sta;
	
	public AudioClip [] au = new AudioClip [10];
	public Thread [] td = new Thread[10];
	
	public File son ,son2 ,brol;

	public boolean coufini =false ;
	
	public boolean norecharge =false;
	public boolean verif =false ;
	public boolean [] kem = new boolean[3];
	public Thread sup ;
	
	public boolean kamehousse = true ;
	public Applica(){
		this.setTitle("Dbz Battle By PC");
		this.setSize(500, 500);
		
		//this.setSize(1400,1400);
	
		this.setLocationRelativeTo(null);
		
		//setIconImage(new ImageIcon(this.getClass().getResource("goku/b2.png")).getImage());
		
		container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    container.add(p, BorderLayout.CENTER);
		
	    JTextField jtf = new JTextField() ;
	    
	    JPanel south = new JPanel();
	    south.add(jtf);
       
	    jtf.setPreferredSize(new Dimension(0, 0));
	    jtf.addKeyListener(new ClavierListener());
	    container.add(south , BorderLayout.SOUTH);
	    
	    
	    this.setContentPane(container) ;
		this.setVisible(true) ;
		
		
		//sound code 
		File tele = new File("goku/teleportation_converted.wav");
		File marchons = new File("goku/pas_converted.wav");
		 brol = new File("goku/aura03.wav");
		 son = new File("goku/de.wav");	
		  son2 = new File("goku/Aura02.wav");
		  File coup =new File("goku/coup14_converted.wav");
		  File brcoup = new File("goku/vide_converted.wav");
		  File gokublesse = new File("goku/coup7_converted.wav");
		  File voice = new File("goku/kameha.wav");
		  
		  File deb = new File("goku/open.wav");
		  File avan =  new File("goku/teleportation_converted.wav");
		  File kik = new File("goku/vide_converted.wav");
		  File reg = new File("goku/cheveux2_converted.wav");
		// clip = null;
		  
		  
		  
		  
		  
		try
		{
		clip = Applet.newAudioClip(son.toURL());
		clip2 = Applet.newAudioClip(son2.toURL());
		clip3 = Applet.newAudioClip(brol.toURL());
		clip4 = Applet.newAudioClip(tele.toURL());
		clip6 = Applet.newAudioClip(marchons.toURL());
		clip7 = Applet.newAudioClip(coup.toURL());
		clip8 = Applet.newAudioClip(brcoup.toURL());
		clip9 =  Applet.newAudioClip(gokublesse.toURL());
		clip11 =  Applet.newAudioClip(voice.toURL());
		sta =  Applet.newAudioClip(deb.toURL());
		
		au[1] =  Applet.newAudioClip(avan.toURL());
		au[0] = Applet.newAudioClip(kik.toURL());
		au[3] = Applet.newAudioClip(reg.toURL());
		}
		catch (MalformedURLException e)
		{
		System.out.println(e.getMessage());
		}
		debu = new Thread(new Debu());
		debu.start() ;
		
	/*	clip2.play() ;
		clip.loop();
		go() ;
		*/
		sta.loop() ;
		
		

	}
	
	
	
	public void pause (int a){
		  try {
	            Thread.sleep(a);
	          } catch (InterruptedException e) {
	            e.printStackTrace();
	          }	
	}

	
	public void go(){

		for(int i = 0 ; i < 10 ;i++){
			p.avance ++ ;
		
			p.repaint() ;
		pause(250);
		}
		
		norecharge =true ;
		songo = new Thread(new Son());
		songo.start() ;
		p.repaint();
		pause(4000);
		songo.stop() ;
		norecharge = false ;
		p.orientation = 0 ;
		p.avance = 6 ;
		p.repaint() ;
		p.avan ++ ;
		clip3.play() ;
		for(int j = 0 ; j < 8 ; j++){
			p.repaint() ;
			if(j == 6)
				clip4.play() ;
			p.avan ++ ;
			pause(800);
			
		}
		action = new Thread(new Action());
		action.start() ;
		
		
		
	}
	
	
	class ClavierListener implements KeyListener{
		
	    public void keyPressed(KeyEvent event) {
	    	if(p.stage == 0){
	    		
	    		if(event.getKeyCode() == 69){
	    			debu.stop() ;
	    			p.stage  =1 ;
	    			p.repaint() ;
	    			
	    			clip.loop();
	    			sup = new Thread(new Sup()) ;
	    			sup.start() ;
	    			sta.stop() ;
	    			
	    		}
	    		
	    	}
	    	
	    if(p.stage == 1){
	    	
	    	if(p.x >= p.xx - 25){
	    		p.xx = p.x + 30 ;
	    		p.repaint() ;
	    	}
	    	
	    	if(p.v <= 10){
	    		p.orientation = 5 ;
	    		p.avance = 1 ;
	    		p.repaint() ;
	    	}
	    	if(p.v2 >= 480){
	    		p.ori = 3 ;
	    		p.avan = 6 ;
	    		action.stop() ;
	    		p.orientation = 5 ;
	    		p.avance = 0 ;
	    		p.repaint() ;
	    	}
	    	
	    	if(p.v < 160){
	    		p.oui = false;
	    		p.repaint() ;
	    	}
	    	
	    	if(p.x >=400){
	    		p.x = 390 ;
	    		p.repaint() ;
	    	}
	    	if(p.x <= 10)
	    		p.x = 20 ;
	    
	    	if(event.getKeyCode() == 39 && etat == 4){
	    		if(songo != null)
	    			songo.stop() ;
	    		if(clip3 != null)
	    			clip3.stop() ;
	    		
	    		p.x = p.x +15 ;
	    		p.repaint() ;
	    		
	    	}
	    	if(event.getKeyCode() == 37 && etat == 4){
	    		if(songo != null)
	    			songo.stop() ;
	    		if(clip3 != null)
	    			clip3.stop() ;
	    		p.x = p.x - 15 ;
	    		p.repaint() ;
	    	}
	    	
	    	if(event.getKeyCode() == 66 && etat == 4){
	    		if(!sur){
	    		songo = new Thread(new Son());
	    		songo.start();
	    		}else{
	    			songo.stop() ;
	    		}
	    		 File son3 = new File("goku/aura04.wav");
	    		 clip3 = null;
	    		try
	    		{
	    		clip3 = Applet.newAudioClip(son3.toURL());
	    		clip3.loop() ;
	    		}
	    		catch (MalformedURLException e)
	    		{
	    		System.out.println(e.getMessage());
	    		}
	    		
	    		
	    	}
	    	
	    	if(event.getKeyCode() == 38 && fois == 0 && etat == 4){
	    		tt = new Thread(new Saut());
	    		tt.start() ;
	    
	    	}
	    	
	    /*	if(event.getKeyCode() == 65 && p.x + 100 > p.xx){
	    	verif = true ;
	    	if(verif){
	    		if(!coufini){
					tr = new Thread(new Cout());
					tr.start() ;
	    			}
	    	}
	    	
	    	}
	    
	    	*/
	    	if(event.getKeyCode() == 65 && etat == 3){
	    		p.orientation = 8 ;
	    		p.avance = 0 ;
	    		coupe = new Thread (new Coupe()) ;
	    		coupe.start() ;
	    		
	    	}
	    	
	    	if(event.getKeyCode() == 68 && etat == 4){
	    		
	    		au[3].play() ;
	    		p.orientation = 6 ;
	    		p.avance = 0 ;
	    		etat = 3 ;
	    		p.repaint() ;
	    		regress = new Thread () ;
	    		regress.start() ;
	    		
	    	}
	    	
	    	if(event.getKeyCode() == 65 && etat == 4){
	    		verif = false ;
	    		if(!verif){
	    			if(!coufini){
					tr = new Thread(new Cout());
					tr.start() ;
	    			}
	    		}
	    	}
	    	
	    	if(event.getKeyCode() == 67 && etat == 4)
	    	{
	    	if(p.v >= 160){
	    		p.orientation = 4 ;
	    		p.avance =0 ;
	    		
	    		boule = new Thread(new Boule());
	    		boule.start() ;
	    		}
	    	}
	    	if(event.getKeyCode() == 39 && etat == 3){
	    		au[1].play() ;
	    		p.orientation = 6 ;
	    		p.avance = 1 ;
	    		p.x = p.x + 100 ;
	    		p.repaint() ;
	    	}
	    	
	    	if(event.getKeyCode() == 37 && etat == 3){
	    		au[1].play() ;
	    		p.orientation = 6 ;
	    		p.avance = 2 ;
	    		p.x = p.x - 100 ;
	    		
	    		p.repaint();
	    	}
	    	if(event.getKeyCode() == 38 && etat == 3){
	    		p.orientation = 7 ;
	    		p.avance = 0;
	    		saut3 = new Thread(new Saut3()) ;
	    		saut3.start() ;
	    		
	    	}
	    	
	    	if(event.getKeyCode()==90 && etat == 3){
	    		p.orientation = 9 ;
	    		p.avance = 0 ;
	    		td[0] = new Thread(new Poing());
	    		td[0].start() ;

	    		
	    	}
	    	
	    	
	    }
	    
	    	
	    System.out.println("Code touche relâchée : " + event.getKeyCode() + " - caractère touche relâchée : " + event.getKeyChar());         
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
	
	class Saut implements Runnable{
		public void run(){
			  File sonn = new File("goku/saut_converted.wav");
				// clip = null;
			  File tombe= new File("goku/tombe_converted.wav");
				try
				{
				clip4 = Applet.newAudioClip(sonn.toURL());
				
				clip10 =Applet.newAudioClip(tombe.toURL());
				}
				catch (MalformedURLException e)
				{
				System.out.println(e.getMessage());
				}
				clip4.play() ;
			
			
			p.orientation = 1;
			for(int i =0 ; i < 7 ;i++){
				p.y = p.y -20 ;
				p.repaint() ;
				pause(50) ;
				
			}
			for(int i =0 ; i < 7 ;i++){
				p.y = p.y +20 ;
				p.repaint() ;
				pause(50) ;
				
			}
		//	clip10.play() ;
			p.orientation= 0 ;
			p.avance = 8 ;
			p.repaint() ;
			
			fois = 0 ;
		}
	}
	
	class Cout implements  Runnable{
		public int com =0 ;
		public void run (){
			coufini =true ;
			
			com ++ ;
			  File songg = new File("goku/vide3_converted.wav");
			// clip = null;
			try
			{
			clip5 = Applet.newAudioClip(songg.toURL());
			}
			catch (MalformedURLException e)
			{
			System.out.println(e.getMessage());
			}
			if(p.x + 80 > p.xx && p.x +80 < p.xx +90 ){
	
				clip7.play() ;
				p.orientation = 2 ;
				p.avance =0;
				for(int ii = 0 ; ii < 6 ; ii++){
					if(p.avance>= 4){
						p.orientation = 2 ;
						p.avance  =0 ;
					}
					p.ori = 3 ;
					p.avan =0 ;
					p.xx = p.xx + 5 ;
					p.v2 =p.v2 +2 ;
					
					p.repaint() ;
					pause(200) ;
					p.avance  ++ ;
					p.x = p.x + 5 ;
				}
				p.orientation= 0 ;
				p.avance = 8 ;
				p.ori =0 ;
				p.avan = 8 ;
				coufini =false ;
			}
			else{
				
				clip5.play() ;
				p.orientation = 2 ;
				p.avance =0;
				for(int ii = 0 ; ii < 6 ; ii++){
					if(p.avance>= 4){
						p.orientation = 2 ;
						p.avance  =0 ;
					}
				
					p.repaint() ;
					pause(200) ;
					p.avance  ++ ;
					p.x = p.x + 5 ;
				}
				p.orientation= 0 ;
				p.avance = 8 ;
				
				coufini =false ;
			}
		
			
			
			
			
		
		}
	}
	
	class Boule implements Runnable{
		public void run(){
			
			  File songg = new File("goku/f.wav");
			  File explo = new File("goku/explosion6_converted.wav");
			// clip = null;
			try
			{
			clip5 = Applet.newAudioClip(songg.toURL());
			clip6 = Applet.newAudioClip(explo.toURL());
			}
			catch (MalformedURLException e)
			{
			System.out.println(e.getMessage());
			}
			if(kamehousse){
			clip11.play() ;
			pause(8000) ;
			kamehousse = false;
			}
			clip5.play();
			
			p.v = p.v - 30 ;
			if(p.x + p.longb  >= p.xx){
				
				p.ori =3 ;
				p.avan = 0 ;
			for(int i =0 ;i < 6 ; i++){
			
				p.repaint() ;
				//if(p.avan >= 3)
				
			
			
				p.v2 = p.v2 + 15 ;
				//pause(1200);
				pause(500);
				
				p.avance ++ ;
				if(p.avance == 3)
					clip5.stop() ;
				if(p.avance >= 3){
					p.avance = 2 ;
					p.avan ++ ;
					
					clip6.play() ;
					
				}
				
				}
			}
			
			clip5.stop() ;

			/*
			for(int j = 0 ;j < 10 ;j++){
				p.longb  = p.longb + 50;
				pause(100);
				p.repaint() ;
			}*/
			
			
			p.orientation = 0 ;
			p.avance = 8;
			p.ori =0 ;
			p.avan = 8 ;
			p.repaint() ;
			
			
		}
	}
	
	class Son implements Runnable{
		public void run(){
			p.orientation= 3 ;
			p.avance =0 ;
			
			for(int i =0 ; i < 10000 ; i++){
				if(i % 2 == 0){
					p.avance = 0 ;
					p.repaint();
					pause(100);
					
				}
				if(p.v > 160){
					p.oui = true;
				}else {
					p.oui = false ;
				}
				
				if(p.v < 200 && !norecharge){
				p.v = p.v + 5 ;
				}
				p.avance = 1 ;
				pause(100);
				p.repaint() ;
			}
			p.orientation = 0 ;
			p.avance = 10 ;
			p.repaint() ;
		}
	}
	
	class Action implements Runnable{
		public void go(){
			p.ori =2 ;
			p.avan =-1 ;
			clip4.play() ;
		for(int j =0 ;j < 2 ;j++){
			p.avan ++;
			p.xx = p.xx - 50;
			if(p.avan>= 2)
				p.avan = 0;
			pause(1000);
			p.repaint() ;
		}
		p.ori = 0 ;
		p.avan = 8 ;
		p.repaint() ;
		}
		
		public void marche( boolean sens){
			p.ori = 1;
			p.avan =0 ;
			clip6.loop() ;
			for(int  i = 0 ;i < 7 ;i++){
				p.repaint() ;
			
				if(p.avan >=3)
					p.avan =0 ;
				p.avan ++ ;
				if(sens ==true)
				p.xx = p.xx - 15 ;
				else 
				p.xx = p.xx + 40 ;
				pause(400) ;
		}
			clip6.stop() ;
		}
		
		public void pied(){
		p.ori=4 ;
		p.avan = 0 ;
		for(int ii = 0 ; ii < 9 ; ii++){
			p.xx = p.xx - 15 ;
			clip8.play() ;
			pause(100);
			p.repaint() ;
			p.avan ++ ;
			if(p.avan > 2)
				p.avan =0 ;
			
		if(p.xx - 10 <= p.x +90 && p.xx -10 >= p.x){
			clip9.play() ;
			p.v = p.v - 5 ;
		}
			
			
		}
		p.ori = 0 ;
		p.avan = 8 ;
		
		}
		
		public void sauter (){
			p.ori = 5 ;
			p.avan = 0 ;
			p.repaint() ;
			
			  File sonn = new File("goku/saut_converted.wav");
				// clip = null;
			
				try
				{
				clip4 = Applet.newAudioClip(sonn.toURL());
				
				
				}
				catch (MalformedURLException e)
				{
				System.out.println(e.getMessage());
				}
				clip4.play() ;
			
			
			for(int i =0 ; i < 7 ;i++){
				p.yy = p.yy -20 ;
				p.repaint() ;
				pause(50) ;
				
			}
			for(int i =0 ; i < 7 ;i++){
				p.yy = p.yy +20 ;
				p.repaint() ;
				pause(50) ;
				
			}
			p.ori = 0 ;
			p.avan = 8 ;
			p.repaint() ;
			
		}
		
		public void run(){
			marche(true) ;
			while(true){
			pied() ;
			sauter() ;
			pause(1000);
		
			if(p.xx <= 20){
				marche(false);
			}
			if(p.xx >= 430)
				marche(true);
			
			}
			//go() ;
			
	}
	}
	
	class Sup implements Runnable{
		public void run(){
			clip2.play() ;
			for(int i = 0 ; i < 10 ;i++){
				p.avance ++ ;
			
				p.repaint() ;
			pause(250);
			}
			
			norecharge =true ;
			songo = new Thread(new Son());
			songo.start() ;
			p.repaint();
			pause(4000);
			songo.stop() ;
			norecharge = false ;
			p.orientation = 0 ;
			p.avance = 6 ;
			p.repaint() ;
			p.avan ++ ;
			clip3.play() ;
			for(int j = 0 ; j < 8 ; j++){
				p.repaint() ;
				if(j == 6)
					clip4.play() ;
				p.avan ++ ;
				pause(800);
				
			}
			action = new Thread(new Action());
			action.start() ;
		}
	}
	
	class Debu implements Runnable{
		public void run(){
		while(true){
			pause(300);
			p.repaint() ;
			p.eff = false ;
			pause(300);
			p.repaint() ;
			p.eff = true;
		}
			
		}
	}
	//Transformation en super sayen 3 animation
	class Regress implements Runnable{
		public void run(){
			p.orientation = 6 ;
			p.avance = 0 ;
			p.repaint() ;
			
			
		}
	}
	
	
	class Saut3 implements Runnable{
		public void run(){
			p.orientation = 7 ;
			p.avance  =0 ;
			  File sonn = new File("goku/saut_converted.wav");
				// clip = null;
			  File tombe= new File("goku/tombe_converted.wav");
				try
				{
				clip4 = Applet.newAudioClip(sonn.toURL());
				
				clip10 =Applet.newAudioClip(tombe.toURL());
				}
				catch (MalformedURLException e)
				{
				System.out.println(e.getMessage());
				}
				clip4.play() ;
			
			
			for(int i = 0 ; i < 10 ;i++){
				p.y = p.y - 10 ;
				p.repaint() ;
				pause(40);
			}
			for(int i = 0 ; i < 10 ;i++){
				p.y = p.y + 10 ;
				p.repaint() ;
				pause(40);
			}	
			
		}
	}
	
	
	//SJJ 3
	class Coupe implements Runnable{
		public void run(){
			if(p.x + 80 > p.xx && p.x +80 < p.xx +90 ){
				
				clip7.play() ;
				p.orientation = 8 ;
				p.avance =0;
				for(int ii = 0 ; ii < 6 ; ii++){
					if(p.avance>= 4){
						p.orientation = 8 ;
						p.avance  =0 ;
					}
					p.ori = 3 ;
					p.avan =0 ;
					p.xx = p.xx + 5 ;
					p.v2 =p.v2 +2 ;
					
					p.repaint() ;
					pause(200) ;
					p.avance  ++ ;
					p.x = p.x + 5 ;
				}
				p.orientation= 6 ;
				p.avance = 1 ;
				p.ori =0 ;
				p.avan = 8 ;
				coufini =false ;
			}
			else {
			
			
			au[0].play() ;
			for(int i = 0 ; i < 3 ;i++){
				p.avance  ++ ;
				if(p.avance >=3)
					p.avance =0;
				p.repaint() ;
				pause(150);
			}
			p.orientation = 6 ;
			p.avance = 1 ;
			p.repaint() ;
			
			}
		}
	}
	class Poing implements Runnable{
		public void run(){
			p.orientation = 9 ;
			p.avance  = 0 ;
			File kikik = new File("goku/vide2_converted.wav") ;
			try
			{
		
			au[2] = Applet.newAudioClip(kikik.toURL());
			}
			catch (MalformedURLException e)
			{
			System.out.println(e.getMessage());
			}
			au[2].play() ;
			for(int i = 0 ; i < 5 ; i++){
				if(p.avance >= 4)
					p.avance = 0 ;
				p.avance  ++ ;
				pause(120);
				p.repaint() ;
			}
			
			
			
		}
	}
	
	
	public static void main(String[] args) {
		new Applica() ;
	}

}
