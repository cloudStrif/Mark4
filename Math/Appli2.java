import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Appli2 extends JPanel{
	public int avance = 0;
	public int x = 100 ;
	public int y = 350 ;
	public int orientation = 0 ;
	
	public int stage  = 0 ;
	
	public boolean eff = true ;
	
	public int avan  = 0 ;
	public int ori = 0 ;
	public int xx = 300 ;
	public int yy = 340 ;
	
	
	public int v = 100;
	public int v2 = 290;
	public boolean oui = false ;
	
	public int longb =200 ;
	public Appli2(){
		 this.addMouseListener(new MouseAdapter(){
		      public void mousePressed(MouseEvent e){
		    	  System.out.println(e.getX()+"  "+ e.getY());
		    	  
		      }
		    });

		    this.addMouseMotionListener(new MouseMotionListener(){
		      public void mouseDragged(MouseEvent e) {
		       
		      }

		      public void mouseMoved(MouseEvent e) {}
		    });

	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,500,500);
		
		g.setColor(Color.black);
		g.fillRect(0,400,500,100);
		
		if(stage == 1){
		
		
		try {
		//	Image map = ImageIO.read(new File("goku/map2.png"));
			Image map = ImageIO.read(new File("goku/map1.gif"));
			// g.drawImage(map,-60,-30,700,550,this);
			g.drawImage(map,0,-5,500,500,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.setColor(Color.black);
		g.fillRect(0,20,v+5,35);
		
		g.fillRect(v2,20,205,35);
		
		//g.setFont(new Font("Arial", Font.BOLD, 15));
		//g.drawString("Goku",0,90 );
		if(oui){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.yellow);
		}
		g.fillRect(0,20,v,30);
		g.setColor(Color.yellow);
		g.fillRect(v2+5,20,205,30);
		
		if(orientation== 0){
		switch(avance){
		case 1 :
		
		ImageIcon imageIcon = new ImageIcon("goku/d.png");
		  Image w = imageIcon.getImage();   
		
		g.drawImage(w,x,y,50,80,this);
		break ;
		
		
		case 2 :
			
			ImageIcon image = new ImageIcon("goku/d2.png");
			  Image d = image.getImage();   
			
			g.drawImage(d,x,y,50,80,this);
			break ;
		
	case 3 :
		
		ImageIcon image2 = new ImageIcon("goku/d3.png");
		  Image d1 = image2.getImage();   
		
		g.drawImage(d1,x,y,50,80,this);
		break ;
	
		
	case 4:
		
		ImageIcon image4 = new ImageIcon("goku/d4.png");
		  Image d4 = image4.getImage();   
		
		g.drawImage(d4,x,y,50,80,this);
		break ;
	case 5:
		
		ImageIcon image5 = new ImageIcon("goku/dd.png");
		  Image d5 = image5.getImage();   
		
		g.drawImage(d5,x,y,50,80,this);
		break ;
	
	case 6 :

		ImageIcon image6 = new ImageIcon("goku/pos.png");
		  Image d6 = image6.getImage();   
		
		g.drawImage(d6,x,y,70,80,this);
		break ;
		
	case 7 :

		ImageIcon image7 = new ImageIcon("goku/s.png");
		  Image d7 = image7.getImage();   
		
		g.drawImage(d7,x,y,70,80,this);
		break ;
	
	case 8 :

		ImageIcon image8 = new ImageIcon("goku/s3.png");
		  Image d8 = image8.getImage();   
		
		g.drawImage(d8,x,y,70,80,this);
		break ;
		
	case 9 :

		ImageIcon image9 = new ImageIcon("goku/s2.png");
		  Image d9 = image9.getImage();   
		
		g.drawImage(d9,x,y,70,80,this);
		break ;
		
		case 10 :

			ImageIcon image10 = new ImageIcon("goku/pos.png");
			  Image d10 = image10.getImage();   
			
			g.drawImage(d10,x,y,70,80,this);
			break ;
		
		
		
		}
	}
	if(orientation== 1){
		ImageIcon aaa = new ImageIcon("goku/saut.png");
		 Image q= aaa.getImage();   
			
			g.drawImage(q,x,y,70,80,this);
		
	}
	
	if(orientation == 2){
		switch(avance){
		case 0 : 	ImageIcon z = new ImageIcon("goku/pied.png");
					Image qq  = z.getImage();   
			
			g.drawImage(qq,x,y,70,80,this);
		break ;
		case 1: 	ImageIcon a1 = new ImageIcon("goku/pied2.png");
		Image qqq = a1.getImage();   

		g.drawImage(qqq,x,y,70,80,this);
		break ;
		case 2 : 	ImageIcon a2 = new ImageIcon("goku/pied3.png");
		Image q2= a2.getImage();   

		g.drawImage(q2,x,y,70,80,this);
		break ;
		case 3 : 	ImageIcon a3 = new ImageIcon("goku/pied4.png");
		Image q3= a3.getImage();   

		g.drawImage(q3,x,y,70,80,this);
		break ;
		case 4: 	ImageIcon a4 = new ImageIcon("goku/pied5.png");
		Image q5= a4.getImage();   

		g.drawImage(q5,x,y,70,80,this);
		break ;
		
		
		
		}
		
	}
	if(orientation == 3){
		switch(avance){
		case 0 : ImageIcon a4 = new ImageIcon("goku/sayen.png");
		Image q5= a4.getImage();   

		g.drawImage(q5,x,y,70,80,this);
		break ;
		case 1 :ImageIcon a2 = new ImageIcon("goku/sayen2.png");
		Image q2= a2.getImage();   

		g.drawImage(q2,x,y,70,80,this);
			
		break ;
		}
	
		
	}
	if(orientation == 4){
		switch (avance){
		case 0 :ImageIcon a2 = new ImageIcon("goku/k.png");
		Image q2= a2.getImage();   

		g.drawImage(q2,x,y,70,80,this);
		
		break ;
		case 1 :ImageIcon az = new ImageIcon("goku/k3.png");
		Image q5= az.getImage();   

		g.drawImage(q5,x,y,70,80,this);
			
		break ;
		case 2 :
			ImageIcon aaa = new ImageIcon("goku/k2.png");
			Image qt= aaa.getImage();   
			ImageIcon kame = new ImageIcon("goku/kame*.png");
			Image cam = kame.getImage() ;
			
			g.drawImage(qt,x,y,70,80,this);
			g.drawImage(cam,x+80,y,longb ,80,this);	
			break ;
		}
	}
	
	if(orientation == 5){
		if(avance == 0){
		ImageIcon az = new ImageIcon("goku/sorry.gif");
		Image q5= az.getImage();
		g.setFont(new Font("Arial", Font.BOLD, 40));
		 g.setColor(Color.red) ;
		 g.drawString("K-O",250,250);
		g.drawImage(q5,x,y,70,80,this);
		}
		if(avance == 1){
			ImageIcon az = new ImageIcon("goku/mort.png");
			Image q5= az.getImage(); 
			g.setFont(new Font("Arial", Font.BOLD, 40));
			 g.setColor(Color.red) ;
			 g.drawString("K-O",250,250);
			g.drawImage(q5,x,y,80,40,this);
		}
		
	
	}
	
	/*grade de super sayen 3 */
	
	
	if(orientation == 6){
		switch (avance){
		case 0 :
		ImageIcon az = new ImageIcon("ssj3/nor.png");
		Image q5= az.getImage();   

		g.drawImage(q5,x,y,60,90,this);
		break ;
		case 1  : 
			ImageIcon a = new ImageIcon("ssj3/avance.png");
			Image q6= a.getImage();   

			g.drawImage(q6,x,y,70,90,this);
			
			break ;
		case 2 :
			ImageIcon r = new ImageIcon("ssj3/recule2.png");
			Image qr= r.getImage();   

			g.drawImage(qr,x,y,70,90,this);
			break ;
			
		
		}
	}
	
	if(orientation == 7){
		switch (avance){
		case 0 :
			ImageIcon r = new ImageIcon("ssj3/saut6.png");
			Image qr= r.getImage();   

			g.drawImage(qr,x,y,70,90,this);
			break ;
		}
	}
	//coup de pied
	if(orientation == 8){
		switch(avance){
		case 0 : 
			ImageIcon r = new ImageIcon("ssj3/pied.png");
			Image qr= r.getImage();   

			g.drawImage(qr,x,y,70,90,this);
			break ;
		case 1 :
			ImageIcon rr = new ImageIcon("ssj3/pied2.png");
			Image qrr= rr.getImage();   

			g.drawImage(qrr,x,y,70,90,this);
			break ;
		case 2 : 
			ImageIcon r2 = new ImageIcon("ssj3/pied3.png");
			Image qr2= r2.getImage();   

			g.drawImage(qr2,x,y,70,90,this);
			break ;
			
		}
	}
	if(orientation ==9){
		switch(avance){
		case 0 :
			ImageIcon r2 = new ImageIcon("ssj3/poin.png");
			Image qr2= r2.getImage();   

			g.drawImage(qr2,x,y,70,90,this);
			break ;
		case 1 :
			ImageIcon r = new ImageIcon("ssj3/poin2.png");
			Image qr= r.getImage();   

			g.drawImage(qr,x,y,70,90,this);
			break ;
		case 2 : 
			ImageIcon yyy = new ImageIcon("ssj3/poin3.png");
			Image io= yyy.getImage();   

			g.drawImage(io,x,y,70,90,this);
			break ;
		case 3 : 
			ImageIcon y2 = new ImageIcon("ssj3/poin4.png");
			Image iy= y2.getImage();   

			g.drawImage(iy,x,y,70,90,this);
			break ;
		case 4 : 
			ImageIcon rich = new ImageIcon("ssj3/poin5.png");
			Image bunel= rich.getImage();   

			g.drawImage(bunel ,x,y,70,90,this);
			
			break ;
		}
	}
	
	
	
	
	
	
	if(ori  == 0){
		switch(avan){
		case 0 : ImageIcon az = new ImageIcon("goku/b9.png");
		Image q5= az.getImage();   

		g.drawImage(q5,xx,yy,70,90,this);
		break ;
		case 1 : ImageIcon a1 = new ImageIcon("goku/b8.png");
		Image q1= a1.getImage();   

		g.drawImage(q1,xx,yy,70,90,this);
		break ;
		case 2 : ImageIcon a2 = new ImageIcon("goku/b7.png");
		Image q2= a2.getImage();   

		g.drawImage(q2,xx,yy,70,90,this);
		break ;
		case 3 : ImageIcon a3 = new ImageIcon("goku/b6.png");
		Image q3= a3.getImage();   

		g.drawImage(q3,xx,yy,70,90,this);
		break ;
		case 4 : ImageIcon a4 = new ImageIcon("goku/b5.png");
		Image q4= a4.getImage();   

		g.drawImage(q4,xx,yy,70,90,this);
		break ;
		case 5 : ImageIcon a6 = new ImageIcon("goku/b4.png");
		Image q6= a6.getImage();   

		g.drawImage(q6,xx,yy,70,90,this);
		break ;
		case 6 : ImageIcon a7 = new ImageIcon("goku/b3.png");
		Image q7 = a7.getImage();   

		g.drawImage(q7,xx,yy,70,90,this);
		break ;
		case 8 : ImageIcon a8 = new ImageIcon("goku/b2.png");
		Image q8= a8.getImage();   

		g.drawImage(q8,xx,yy,70,90,this);
		break ;
		case 9 : ImageIcon a9 = new ImageIcon("goku/b1.png");
		Image q9= a9.getImage();   

		g.drawImage(q9,xx,yy,70,90,this);
		break ;
		}
		
	}
	if(ori == 1){
		switch(avan){
		case 0 : ImageIcon a9 = new ImageIcon("goku/marche.png");
		Image q9= a9.getImage();   

		g.drawImage(q9,xx,yy,70,90,this);
		
		break ;
		case 1 : ImageIcon a1 = new ImageIcon("goku/marche2.png");
		Image q1= a1.getImage();   

		g.drawImage(q1,xx,yy,70,90,this);
		
		break ;
		case 2 : ImageIcon a3 = new ImageIcon("goku/marche3.png");
		Image q3= a3.getImage();   

		g.drawImage(q3,xx,yy,70,90,this);
		
		break ;
		case 3 : ImageIcon a4 = new ImageIcon("goku/marche4.png");
		Image q4= a4.getImage();   

		g.drawImage(q4,xx,yy,70,90,this);
		
		break ;
		
		}
		
	}
	if(ori == 2){
		switch (avan){
		case 0 :ImageIcon a4 = new ImageIcon("goku/speed.png");
		Image q4= a4.getImage();   

		g.drawImage(q4,xx,yy,70,90,this);
		
		break ;
		case 1 :ImageIcon aaa = new ImageIcon("goku/speed2.png");
		Image qq= aaa.getImage();   

		g.drawImage(qq,xx,yy,70,90,this);
		
		break ;
		}
		
	}
	if(ori == 3){
		switch(avan){
		case 0 :ImageIcon a4 = new ImageIcon("goku/blesse.png");
		Image q4= a4.getImage();   

		g.drawImage(q4,xx,yy,70,90,this);
		
		break ;
		case 1 :ImageIcon a1 = new ImageIcon("goku/blesse2.png");
		Image q1= a1.getImage();   

		g.drawImage(q1,xx,yy,70,90,this);
		
		break ;
		case 2 :ImageIcon aa = new ImageIcon("goku/blesse3.png");
		Image q3= aa.getImage();   

		g.drawImage(q3,xx,yy,70,90,this);
		
		break ;
		case 3 : ImageIcon aaa = new ImageIcon("goku/blesse4.png");
		Image qq= aaa.getImage();   

		g.drawImage(qq,xx,yy,70,90,this);
		
		break ;
		case 4 : ImageIcon e = new ImageIcon("goku/blesse6.png");
		Image qe= e.getImage();   

		g.drawImage(qe,xx,yy,70,90,this);
		
		break ;
		case 5 : ImageIcon ee = new ImageIcon("goku/blesse7.png");
		Image qee= ee.getImage();   

		g.drawImage(qee,xx,yy,70,90,this);
		
		break ;
		case 6 : ImageIcon o = new ImageIcon("goku/blesse8.png");
		Image h= o.getImage();   
		g.drawImage(h,xx,yy+60,100,50,this);
		break ;
		
		}
		
		
	}
	if(ori == 4){
		switch(avan){
		case 0 : ImageIcon ee = new ImageIcon("goku/piedb.png");
		Image qee= ee.getImage();   
		g.drawImage(qee,xx,yy,90,100,this);
		break ;
		case 1 : ImageIcon e = new ImageIcon("goku/piedb2.png");
		Image qe= e.getImage();   
		g.drawImage(qe,xx,yy,90,100,this);
		break ;
		case 2 : ImageIcon e4 = new ImageIcon("goku/piedb3.png");
		Image q4= e4.getImage();   
		g.drawImage(q4,xx,yy,90,100,this);
		break ;
		
		}
	}
	if(ori ==5){
		switch(avan){
		case 0 :ImageIcon e4 = new ImageIcon("goku/sautb.png");
		Image q4= e4.getImage();   
		g.drawImage(q4,xx,yy,90,100,this);
		break ;
		}
	}
	

		
	}
		if(stage  == 0){
			try {
				Image debut = ImageIO.read(new File("goku/vs.jpg"));
				Image debut2 = ImageIO.read(new File("goku/téléchargement.jpg"));
				
				//g.drawImage(debut,0,0,1300,760,this);
				g.drawImage(debut,0,0,500,500,this);
				g.setColor(Color.blue);
				 g.setFont(new Font("Arial", Font.BOLD, 30));
				if(eff)
				 g.drawString("appuyer sur e pour continuer",10,400);
				
			} catch (IOException e) {
				
			}
		
			
		}
		if(stage == 2){
		
			
		}
		
	}

	
}
