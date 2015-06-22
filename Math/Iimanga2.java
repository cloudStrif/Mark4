
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Iimanga2 extends JPanel{	
	
    int orientation =0 ;
    int avance =1 ;
    public int x = 100 ;
    public int y = 350 ;
    public boolean bool=false;
    //(400,100)
    boolean tombe=false;
    int target = 700;
    int target2 = 500 ;
    boolean eff =false ;
    boolean ef=false;
    boolean e=false;
    int co = 0;
    /*
     * Niveau des mappages 
     */
    public int MAP = -1 ;

	
    public void pause (int a){
	try {
	    Thread.sleep(a);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}	
    }
	
	
    public void paint(Graphics g){
		
	g.setColor(new Color(co,co,co));	
	g.fillRect(0,0,1000,200);
		
	g.setColor(Color.ORANGE);
	g.fillOval(400,(200-(4*co)),200,160);
		
	g.setColor(Color.BLACK);
	g.fillRect(0,200,1000,1000);
		
		
		
	if(MAP==-2){
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,1000,1000);
	    g.setColor(Color.ORANGE);
	    g.setFont(new Font("Arial", Font.BOLD, 20));
	    g.drawString("Intox alimentaire -author : L",370,250);
	}
		
	if(MAP==-1){
	    try{
		Image apa = ImageIO.read(new File("HR/titre.jpg"));
		g.drawImage(apa,500,100,300,300,this);
	    }catch(Exception e){}
			
	}
	g.setColor(Color.ORANGE);
	g.setFont(new Font("Arial", Font.BOLD, 30));
	if(eff){
	    g.drawString("DARK ADVENTURE",180,300);
	    g.drawString("appuyer sur ENTER",180,200);
	}
		
	if(MAP==0){
	    try{
		Image apa = ImageIO.read(new File("HR/ham.png"));
		g.drawImage(apa,700,450,this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		if(ef){
		    g.drawString("Mon tendre et delicieux hamburger !",100,300);
		}
		if(e){
		    g.drawString("Viens me manger !grumpf",700,400);
		}
			
	    }catch(Exception e){}
	}
		
	if(MAP==1){
	    try{
		Image apa = ImageIO.read(new File("HR/cherry.png"));
		g.drawImage(apa,700,450,this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		if(ef){
		    g.drawString("Ma tendre et delicieuse Fraise !",100,300);
		}
		if(e){
		    g.drawString("Viens me manger !grumpf",700,400);
		}
		g.setColor(Color.darkGray);
		//g.fillRect(350,480,250,200);
		g.fillOval(350,400,250,150);
				
				
		if(x>=350 && x<=480){
		    tombe=true;
		}else{
		    tombe=false;
		}
	    }catch(Exception e){}
	}
		
	if(MAP==2){
	    try{
		Image apa = ImageIO.read(new File("HR/cerise.png"));
		g.drawImage(apa,700,450,this);
			
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		if(ef){
		    g.drawString("Ma tendre et adorable cerise !",100,300);
		}
		if(e){
		    g.drawString("Viens me manger !grumpf",700,400);
		}
	    }catch(Exception e){}
	}
		
	if(MAP==3){
	    try{
		Image apa = ImageIO.read(new File("HR/gateau.png"));
		g.drawImage(apa,700,450,this);
				
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		if(ef){
		    g.drawString("Mon tendre et beau gateau prefere !!",100,300);
		}
		if(e){
		    g.drawString("Viens me manger !grumpf",700,400);
		}
	    }catch(Exception e){}
		
	    g.setColor(Color.gray);
	    g.fillOval(350,400,250,150);
	    if(x>=350 && x<=480){
		tombe=true;
	    }else{
		tombe=false;
	    }
		
	}
		
	if(MAP==4){
	    try{
		Image apa = ImageIO.read(new File("HR/sushi.png"));
		g.drawImage(apa,700,450,this);
			
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		if(ef){
		    g.drawString("Sushi au saumon !",100,300);
		}
		if(e){
		    g.drawString("Viens me manger !grumpf",700,400);
		}
	    }catch(Exception e){}
	}
		
	if(MAP==-3){
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,1000,1000);
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.BOLD, 20));
	    g.drawString("Bon Ap !FIN -Author L",370,250);
		
	}
		
	if(x<=target+30 && x >=target-80 && y <=target2+4){
	    bool =true;
	}else {
	    bool=false;
	}
		
	if(MAP>=0){
		
	    if(orientation== 0){
		switch(avance){
		case 1 :
			
		    ImageIcon imageIcon = new ImageIcon("HR/p1.jpg");
		    Image w = imageIcon.getImage();   
			
		    g.drawImage(w,x,y,this);
		    break ;
			
			
		case 2 :
				
		    ImageIcon image = new ImageIcon("HR/p2.jpg");
		    Image d = image.getImage();   
				
		    g.drawImage(d,x,y,this);
		    break ;
			
		case 3 :
			
		    ImageIcon image2 = new ImageIcon("HR/p3.jpg");
		    Image d1 = image2.getImage();   
			
		    g.drawImage(d1,x,y,this);
		    break ;
		
			
		case 4:
			
		    ImageIcon image4 = new ImageIcon("HR/p4.jpg");
		    Image d4 = image4.getImage();   
			
		    g.drawImage(d4,x,y,this);
		    break ;
		case 5:
			
		    ImageIcon image5 = new ImageIcon("HR/p5.jpg");
		    Image d5 = image5.getImage();   
			
		    g.drawImage(d5,x,y,this);
		    break ;
		
		case 6 :

		    ImageIcon image6 = new ImageIcon("HR/p6.jpg");
		    Image d6 = image6.getImage();   
			
		    g.drawImage(d6,x,y,this);
		    break ;
			
		case 7 :

		    ImageIcon image7 = new ImageIcon("HR/p7.jpg");
		    Image d7 = image7.getImage();   
			
		    g.drawImage(d7,x,y,this);
		    break ;
		
		case 8 :

		    ImageIcon image8 = new ImageIcon("HR/p8.jpg");
		    Image d8 = image8.getImage();   
			
		    g.drawImage(d8,x,y,this);
		    break ;
			
		}
	    }
		
	    if(orientation== 1){
		switch(avance){
		case 1 :
			
		    ImageIcon imageIcon = new ImageIcon("HR/r1.jpg");
		    Image w = imageIcon.getImage();   
			
		    g.drawImage(w,x,y,this);
		    break ;
			
			
		case 2 :
				
		    ImageIcon image = new ImageIcon("HR/r2.jpg");
		    Image d = image.getImage();   
				
		    g.drawImage(d,x,y,this);
		    break ;
			
		case 3 :
			
		    ImageIcon image2 = new ImageIcon("HR/r3.jpg");
		    Image d1 = image2.getImage();   
			
		    g.drawImage(d1,x,y,this);
		    break ;
		
			
		case 4:
			
		    ImageIcon image4 = new ImageIcon("HR/r4.jpg");
		    Image d4 = image4.getImage();   
			
		    g.drawImage(d4,x,y,this);
		    break ;
		case 5:
			
		    ImageIcon image5 = new ImageIcon("HR/r5.jpg");
		    Image d5 = image5.getImage();   
			
		    g.drawImage(d5,x,y,this);
		    break ;
		
		case 6 :

		    ImageIcon image6 = new ImageIcon("HR/r6.jpg");
		    Image d6 = image6.getImage();   
			
		    g.drawImage(d6,x,y,this);
		    break ;
			
		case 7 :

		    ImageIcon image7 = new ImageIcon("HR/r7.jpg");
		    Image d7 = image7.getImage();   
			
		    g.drawImage(d7,x,y,this);
		    break ;
		
		case 8 :

		    ImageIcon image8 = new ImageIcon("HR/r8.jpg");
		    Image d8 = image8.getImage();   
			
		    g.drawImage(d8,x,y,this);
		    break ;
		case 9 :

		    ImageIcon image9 = new ImageIcon("HR/r9.jpg");
		    Image d9 = image9.getImage();   
			
		    g.drawImage(d9,x,y,this);
		    break ;	
			
		}
	    }
	    if(orientation== 2){
		switch(avance){
		case 1 :
			
		    ImageIcon imageIcon = new ImageIcon("HR/d1.jpg");
		    Image w = imageIcon.getImage();   
			
		    g.drawImage(w,x,y,this);
		    break ;
			
			
		case 2 :
				
		    ImageIcon image = new ImageIcon("HR/d2.jpg");
		    Image d = image.getImage();   
				
		    g.drawImage(d,x,y,this);
		    break ;
			
		case 3 :
			
		    ImageIcon image2 = new ImageIcon("HR/d3.jpg");
		    Image d1 = image2.getImage();   
			
		    g.drawImage(d1,x,y,this);
		    break ;
		
			
		case 4:
			
		    ImageIcon image4 = new ImageIcon("HR/d4.jpg");
		    Image d4 = image4.getImage();   
			
		    g.drawImage(d4,x,y,this);
		    break ;
		case 5:
			
		    ImageIcon image5 = new ImageIcon("HR/d5.jpg");
		    Image d5 = image5.getImage();   
			
		    g.drawImage(d5,x,y,this);
		    break ;
		
		case 6 :

		    ImageIcon image6 = new ImageIcon("HR/d6.jpg");
		    Image d6 = image6.getImage();   
			
		    g.drawImage(d6,x,y,this);
		    break ;
			
		case 7 :

		    ImageIcon image7 = new ImageIcon("HR/d7.jpg");
		    Image d7 = image7.getImage();   
			
		    g.drawImage(d7,x,y,this);
		    break ;
		
		case 8 :

		    ImageIcon image8 = new ImageIcon("HR/d8.jpg");
		    Image d8 = image8.getImage();   
			
		    g.drawImage(d8,x,y,this);
		    break ;
			
		}
	    }
		
	    if(orientation== 3){
		switch(avance){
		case 1 :
			
		    ImageIcon imageIcon = new ImageIcon("HR/po1.jpg");
		    Image w = imageIcon.getImage();   
			
		    g.drawImage(w,x,y,this);
		    break ;
			
			
		case 2 :
				
		    ImageIcon image = new ImageIcon("HR/po2.jpg");
		    Image d = image.getImage();   
				
		    g.drawImage(d,x,y,this);
		    break ;
			
		case 3 :
			
		    ImageIcon image2 = new ImageIcon("HR/po3.jpg");
		    Image d1 = image2.getImage();   
			
		    g.drawImage(d1,x,y,this);
		    break ;
		
			
		case 4:
			
		    ImageIcon image4 = new ImageIcon("HR/po4.jpg");
		    Image d4 = image4.getImage();   
			
		    g.drawImage(d4,x,y,this);
		    break ;
		case 5:
			
		    ImageIcon image5 = new ImageIcon("HR/po5.jpg");
		    Image d5 = image5.getImage();   
			
		    g.drawImage(d5,x,y,this);
		    break ;
		
		case 6 :

		    ImageIcon image6 = new ImageIcon("HR/po6.jpg");
		    Image d6 = image6.getImage();   
			
		    g.drawImage(d6,x,y,this);
		    break ;
			
		case 7 :

		    ImageIcon image7 = new ImageIcon("HR/po7.jpg");
		    Image d7 = image7.getImage();   
			
		    g.drawImage(d7,x,y,this);
		    break ;
		
		case 8 :

		    ImageIcon image8 = new ImageIcon("HR/po8.jpg");
		    Image d8 = image8.getImage();   
			
		    g.drawImage(d8,x,y,this);
		    break ;
		case 9 :

		    ImageIcon image9 = new ImageIcon("HR/po9.jpg");
		    Image d9 = image9.getImage();   
			
		    g.drawImage(d9,x,y,this);
		    break ;	
			
		case 10 : 	ImageIcon z = new ImageIcon("HR/po10.jpg");
		    Image qq  = z.getImage();   

		    g.drawImage(qq,x,y,this);
		    break ;
		case 11: 	ImageIcon a1 = new ImageIcon("HR/po11.jpg");
		    Image qqq = a1.getImage();   

		    g.drawImage(qqq,x,y,this);
		    break ;
		case 12 : 	ImageIcon a2 = new ImageIcon("HR/po12.jpg");
		    Image q2= a2.getImage();   

		    g.drawImage(q2,x,y,this);
		    break ;
		case 13 : 	ImageIcon a3 = new ImageIcon("HR/po13.jpg");
		    Image q3= a3.getImage();   	

		    g.drawImage(q3,x,y,this);
		    break ;
		case 14: 	ImageIcon a4 = new ImageIcon("HR/po14.jpg");
		    Image q5= a4.getImage();   

		    g.drawImage(q5,x,y,this);
		    break ;
		
		case 15 :
		    ImageIcon r2 = new ImageIcon("HR/po15.jpg");
		    Image qr2= r2.getImage();   

		    g.drawImage(qr2,x,y,this);
		    break ;
		case 16 :
		    ImageIcon r = new ImageIcon("HR/po16.jpg");
		    Image qr= r.getImage();   

		    g.drawImage(qr,x,y,this);
		    break ;
		case 17: 
		    ImageIcon yyy = new ImageIcon("HR/po17.jpg");
		    Image io= yyy.getImage();   

		    g.drawImage(io,x,y,this);
		    break ;
		case 18 : 
		    ImageIcon y2 = new ImageIcon("HR/po18.jpg");
		    Image iy= y2.getImage();   

		    g.drawImage(iy,x,y,this);
		    break ;
		case 19 : 
		    ImageIcon rich = new ImageIcon("HR/po19.jpg");
		    Image bunel= rich.getImage();   

		    g.drawImage(bunel ,x,y,this);
			
		    break ;
		case 20: 	ImageIcon a4e = new ImageIcon("HR/po20.jpg");
		    Image q5e= a4e.getImage();   

		    g.drawImage(q5e,x,y,this);
		    break ;
		
		case 21:
		    ImageIcon r2e = new ImageIcon("HR/po21.jpg");
		    Image qr2e= r2e.getImage();   

		    g.drawImage(qr2e,x,y,this);
		    break ;
		case 22 :
		    ImageIcon re = new ImageIcon("HR/po22.jpg");
		    Image qre= re.getImage();   

		    g.drawImage(qre,x,y,this);
		    break ;	
		case 23 :
		    ImageIcon rez = new ImageIcon("HR/po23.jpg");
		    Image qrez= rez.getImage();   

		    g.drawImage(qrez,x,y,this);
		    break ;	
		
		}
	    }
	    if(orientation== 4){
		switch(avance){
		case 1 :
			
		    ImageIcon imageIcon = new ImageIcon("HR/sa1.jpg");
		    Image w = imageIcon.getImage();   
			
		    g.drawImage(w,x,y,this);
		    break ;
			
			
		case 2 :
				
		    ImageIcon image = new ImageIcon("HR/sa2.jpg");
		    Image d = image.getImage();   
				
		    g.drawImage(d,x,y,this);
		    break ;
			
		case 3 :
			
		    ImageIcon image2 = new ImageIcon("HR/sa3.jpg");
		    Image d1 = image2.getImage();   
			
		    g.drawImage(d1,x,y,this);
		    break ;
		
			
		case 4:
			
		    ImageIcon image4 = new ImageIcon("HR/sa4.jpg");
		    Image d4 = image4.getImage();   
			
		    g.drawImage(d4,x,y,this);
		    break ;
		case 5:
			
		    ImageIcon image5 = new ImageIcon("HR/sa5.jpg");
		    Image d5 = image5.getImage();   
			
		    g.drawImage(d5,x,y,this);
		    break ;
		
		case 6 :

		    ImageIcon image6 = new ImageIcon("HR/sa6.jpg");
		    Image d6 = image6.getImage();   
			
		    g.drawImage(d6,x,y,this);
		    break ;
			
		case 7 :

		    ImageIcon image7 = new ImageIcon("HR/sa7.jpg");
		    Image d7 = image7.getImage();   
			
		    g.drawImage(d7,x,y,this);
		    break ;
		
		case 8 :

		    ImageIcon image8 = new ImageIcon("HR/sa8.jpg");
		    Image d8 = image8.getImage();   
			
		    g.drawImage(d8,x,y,this);
		    break ;
			
		}
	    }
		
	    if(orientation== 5){
		switch(avance){
		case 1 :
			
		    ImageIcon imageIcon = new ImageIcon("HR/v1.jpg");
		    Image w = imageIcon.getImage();   
			
		    g.drawImage(w,x,y,this);
		    break ;
			
			
		case 2 :
				
		    ImageIcon image = new ImageIcon("HR/v2.jpg");
		    Image d = image.getImage();   
				
		    g.drawImage(d,x,y,this);
		    break ;
			
		case 3 :
			
		    ImageIcon image2 = new ImageIcon("HR/v3.jpg");
		    Image d1 = image2.getImage();   
			
		    g.drawImage(d1,x,y,this);
		    break ;
		
			
		case 4:
			
		    ImageIcon image4 = new ImageIcon("HR/v4.jpg");
		    Image d4 = image4.getImage();   
			
		    g.drawImage(d4,x,y,this);
		    break ;
		}
	    }
		
		
	}
    }
}
