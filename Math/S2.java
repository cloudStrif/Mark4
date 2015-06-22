
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.*;

public class S2 extends JPanel{
    public 	int ca = 0 ;
    public int x  = 0 ;
    public int y = 0 ;
    public int pause = 100 ;
    public int [][] t = {{0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},//{0,0,5,5,5,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0}} ;
    
    public ArrayList<Integer> file1 = new ArrayList<Integer>() ;//j
    public ArrayList<Integer> file2 = new ArrayList<Integer>() ;//i
    
    public int [] yy = new int[2];
    
    
    public S2(){
	proie();
	file1.add(2);file1.add(3);file1.add(4);
	file2.add(7);file2.add(7);file2.add(7);
		
    }
    
    public void proie(){
	int ss = (int)(Math.random()*9);
	int ff = (int)(Math.random()*9);
	yy[0] = ss ;
	yy[1] = ff;
	t[ss][ff] = 6 ;
	
	//System.out.println(ss+"    "+ff+" " +t[ss][ff]);
    }
    
	
    public void affiche(int [][]t,Graphics g){
	
	for(int i = 0 ; i< 10 ; i++){
	    for(int j = 0; j< 10 ;j++){
		if(t[i][j] == 0){
		    g.setColor(Color.blue);
				    
				    
		    g.fillRect(x, y, 50, 50);
		}
		else if(t[i][j] == 5){
		    g.setColor(Color.black);
		    g.fillRect(x, y, 50, 50);
		    g.setColor(Color.green);
		    g.fillRect(x, y, 45, 45);
		    System.out.println("he");
		}
		else if(t[i][j] == 6){
		    g.setColor(Color.red);
		    g.fillRect(x, y, 50, 50);
		    System.out.println("helloooo");
		}
				
				
				
		x = x + 48 ;
	    }
	    x = 0;
	    y = y + 48 ;
	}
	x=y=0;	
    }
    
    
	
    
    public void avance (int a ){// a = orientation 
	if(a == 0){//en haut
	    
	    
	    file1.add(file1.get(file1.size()-1));//i
	    file2.add(file2.get(file2.size()-1)-1);//j
	    
	    file2.remove(0);
	    file1.remove(0);
	}else if(a == 1){ // a droite
	    file1.add(file1.get(file1.size()-1)+1);//i
	    file2.add(file2.get(file2.size()-1));//j
	    
	    file2.remove(0);
	    file1.remove(0);
	    
	}else if(a==2){//a gauche
	    file1.add(file1.get(file1.size()-1)-1);//i
	    file2.add(file2.get(file2.size()-1));//j
			
	    file2.remove(0);
	    file1.remove(0);
	}else if(a==3){
	    file1.add(file1.get(file1.size()-1));//i
	    file2.add(file2.get(file2.size()-1)+1);//j
	    
	    file2.remove(0);
	    file1.remove(0);
	}
	
	
	
	
	int jj = 0 ;
	for(int i = 0 ; i < file1.size();i++){
	    t[file2.get(i)][file1.get(jj)] = 5 ;
	    jj++;
	    
	    if(file2.get(i)== yy[0] && file1.get(i) == yy[1]){
		proie();
	    }
			
			
	    if(file2.get(file2.size()-1)== yy[0] && file1.get(file1.size()-1) == yy[1]){
		if(ca == 0){
		    System.out.println("homer simpson");
		    file1.add(yy[1]);
		    file2.add(yy[0]);
		    //pause = pause - 100;
		    proie() ;
				
		    ca = 0 ;
		}
		//ca ++ ;
		System.out.println(ca);
	    }
			
	}
    }
	
    public boolean verif (){
	for(int o = 0 ; o<file1.size(); o++){
	    if(file1.get(o)== yy[0] && file2.get(o) == yy[1]){
		return true ;
	    }
	}
	return false ;
    }
	
    public void efface(){
	for(int ii = 0 ; ii < t.length ; ii++){
	    for(int j=0 ; j < t[0].length ;j++){
		if(t[ii][j] == 6){
				
		}else {
		    t[ii][j] = 0 ;
		}
	    }
	}
    }
    
    
    public void pause(){
	if(pause == 0){
	    pause = 200 ;
	}
	try {
	    Thread.sleep(pause);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}	
	    
    }
	
    
    public void paintComponent(Graphics g){
	g.setColor(Color.white);
	g.fillRect(0, 0, 500, 500);
	//tr = new Thread(new Play());

	affiche(t,g);
	
	
	
	
    }
    
    
    
    
}

