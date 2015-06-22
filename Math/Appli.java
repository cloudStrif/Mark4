import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;



/*
 * Fenetre principale du programme
 */




public class Appli extends JFrame  implements ActionListener{
/*
 * conteneur de la fenetre principale pour la grille
 */
	private JPanel container = new JPanel() ;
	
	/*
	 *  c'est ici que l'on va dessiner les choses
	 */
	private Panneau p = new Panneau(this) ;
	
	/*
	 * c'est ici qu'on ecrit les fonctions mathématiques
	 */
	private JTextField jtf ;
	
	/*
	 * Le menu 
	 */
	
	
	private JMenuBar bar = new JMenuBar() ;
	
	private JMenu m = new JMenu("Fichier") ;
	
	private JMenu m2 = new JMenu("Editer") ;

	private JMenu m3 = new JMenu("Fenetre") ;

	private JMenu m4 = new JMenu("Affichage") ;
	
	private JMenu m5 = new JMenu("?");
	
	private JMenu m6 = new JMenu("Jeux");
	
	
	private JMenuItem i = new JMenuItem("Sauvegarder") ;
	
	private JMenuItem i2 = new JMenuItem("Ouvrir") ;
	
	private JMenuItem i3 = new JMenuItem("Effacer");
	
	private JMenuItem i4 = new JMenuItem("refaire");
	
	private JMenuItem i5 = new JMenuItem("nouvelle Fenetre");
	
	private JMenuItem i6 = new JMenuItem("A propos");
	
	private JMenuItem i7 = new JMenuItem("Calculatrice");
	
	private JMenuItem i8 = new JMenuItem("Changer Couleur") ;
	
	//Jeux 
	private JMenuItem i9 = new JMenuItem("Morpion *") ;
	
	private JMenuItem i10 = new JMenuItem("Jeu dela vie *") ;
	
	private JMenuItem i11 = new JMenuItem("Echecs ***") ;
	
	private JMenuItem i12 = new JMenuItem("Gounki ***") ;
	
	private JMenuItem i13 = new JMenuItem("Fight Game ***") ;
	
	private JMenuItem i14 = new JMenuItem("Snake **") ;
	
	private JMenuItem i15 = new JMenuItem("Figure p@ra");
	
	private JMenuItem i16 = new JMenuItem("SPIRAL");
	
	private JMenuItem i17 = new JMenuItem("AXE DIMENSION");

	private JMenuItem i18 = new JMenuItem("Save File");
	
	private JMenuItem i19 = new JMenuItem("Parallele");
	
	private JMenuItem i20 = new JMenuItem("Perpendiculaire");
	
	private JMenuItem i21 = new JMenuItem("Quitter");
	
	private JMenuItem i22 = new JMenuItem("Fractale : courbre du dragon");
	
	private JMenuItem i23 = new JMenuItem("Tangante a une courbe");
	
	private JMenuItem i24 = new JMenuItem("Goku Foods");
	
	private JMenuItem i25 = new JMenuItem("Mario");
	
	private JMenuItem i26 = new JMenuItem("Casse-brique");
	
	private JMenuItem i27 = new JMenuItem("Backtracking Maze");
	/*
	 * 
	 * Les boutons qui permettront de faire des choses en geometrie
	 */
	
	private Bouton b = new Bouton("p") ;
	
	private Bouton b2 = new Bouton("d") ;
	
	private Bouton b3 = new Bouton("b") ;

	private Bouton b4 = new Bouton("s") ;
	
	private Bouton b5 = new Bouton("e") ;
	
	private Bouton b6 = new Bouton("m");
	
	private Bouton b7 = new Bouton("i");
	
	private Bouton b8 = new Bouton("g");

	private Bouton b9 = new Bouton("o") ;
	
	private Bouton b10 = new Bouton("t");
	
	private Bouton b11 = new Bouton("r");
	
	private Bouton b12 = new Bouton("l") ;
	
	private Bouton b13 = new Bouton("y") ;
	
	private Bouton b14 = new Bouton("c");
	
	private Bouton b15 = new Bouton("w");
	
	private Thread thread ;
	
	private boolean repet = true ;
	
	private Brui song ;
	/*
	 * Bouton acioné
	 */
	
	private Brui [] bruitage = new Brui [30] ;
	
	private JLabel lab = new JLabel("F(X) = ");
	
	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	boolean boule = true ;
	
	 Affichage aff = new Affichage() ;
	
	private String fonction = "" ;
	
	
 	Polynome pol ;
	
	
	public Appli(){
		
		bruitage [20] = new Brui("detecteur2_converted",boule);
		bruitage [21] = new Brui("detecteur_converted",boule);
	
		this.setResizable(false); 
		this.setTitle("LyOkO");
		p.setTaille(800);
	
		p.setTaille2(650);
	//	this.setSize(p.getTaille(), p.getTaille2());
		setSize(970,650);
		
		
		this.setLocationRelativeTo(null);
	//	this.setResizable(false); 
		Image icone = Toolkit.getDefaultToolkit().getImage("./crayon.png");
		this.setIconImage(icone);
		
		
		m.add(i2);
		m.add(i21);
		i21.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			//song.stop() ;
	  			System.exit(0);
	  		}
		});
		i21.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		
		m.add(i);
		
		i.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			Memoire memoire = new Memoire() ;
	  			try{
	  			new FileWriter(new File("save")).close();
	  			}catch (IOException e) {
	  				e.printStackTrace();
	  		    }
	  		    
	  			String saw = "";
	  			if(p.points.size() != 0){
	  				for(int i  =0 ; i < p.points.size() ; i++){
	  					saw =saw + p.points.get(i).getX() ;
	  					saw += "/";
	  					saw =saw + p.points.get(i).getY() ;
	  					saw += "/";
	  					saw =saw + p.points.get(i).co ;
	  					saw += "/";
	  					saw =saw + p.points.get(i).co2 ;
	  					saw += "/";
	  					saw =saw + p.points.get(i).getVeri() ;
	  					saw += "/";
	  					saw =saw + p.getIo() ;
	  					saw+="/";
	  					saw =saw + p.getOi() ;
	  					saw += "/";
	  					saw =saw + p.getZo1() ;
	  					saw += "/";
	  					saw =saw + p.getZo2() ;
	  					saw += "/";
	  					saw =saw + p.incremen ;
	  					saw += "/";
	  					saw =saw + p.nom ;
	  					saw += "/";
	  					saw =saw + p.nom2 ;
	  					saw += "/";
	  					saw =saw + p.getLenx() ;
	  					saw += "/";
	  					saw =saw + p.getLeny() ;
	  					saw += " ";
	  					
	  				}
	  				
	  				
	  			}
	  		
	  			memoire.ecrire("save" , saw);
	  			JOptionPane jop1 ;
	  			jop1 = new JOptionPane();
	  			jop1.showMessageDialog(null, "La sauvegarde a ete effectue!", "Information",
	  			JOptionPane.INFORMATION_MESSAGE);
	  		}
	  		
		});
		i.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK));
		
		
		i2.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		Memoire memoire = new Memoire();
	  		String [] tmp = new String[40];
	  		for(int ii = 0 ; ii < tmp.length ; ii++)
	  			tmp[ii]="";
	  		String s = memoire.af("save");
	  	
	  		int inc = 0 ;
	  		for(int i  =0; i < s.length (); i++){
	  			
	  			if(s.charAt(i)==' '){
	  				p.points.add(new Points((int)(Integer.parseInt(tmp[0])), (int)(Integer.parseInt(tmp[1])),
	  						Double.parseDouble(tmp[2]),Double.parseDouble(tmp[3]),Integer.parseInt(tmp[4])));
	  				p.setIo(Double.parseDouble(tmp[5]));
	  				p.setOi(Double.parseDouble(tmp[6]));
	  				p.setZo1(Double.parseDouble(tmp[7]));
	  				p.setZo2(Double.parseDouble(tmp[8]));
	  				p.incremen=Integer.parseInt(tmp[9]);
	  				p.nom=Integer.parseInt(tmp[10]);
	  				p.nom2=Integer.parseInt(tmp[11]);
	  				p.setLenx(Integer.parseInt(tmp[12]));
	  				p.setLeny(Integer.parseInt(tmp[13]));
	  				p.matrix() ;
	  				p.repaint() ;
	  				
	  			
	  				
	  				
	  				
	  				
	  				inc = 0 ;
	  				for(int ii = 0 ;ii < tmp.length ; ii++)
	  					tmp[ii]="";
	  				
	  			}
	  			else if(s.charAt(i)=='/'){
	  				inc ++ ;
	  				
	  			}else{
	  				tmp[inc] = tmp[inc] + s.charAt(i);
	  			}
	  		}
	  		
	  		for(int iy  =0 ; iy < p.points.size() ; iy++){
					if(p.points.get(iy).getVeri() == 1){
						p.droit.add(new Droitee(p.points.get(iy),p.points.get(iy+1),"droite")) ;
						p.bool.add(1);
						iy++ ;
					}
					if(p.points.get(iy).getVeri() == 988){
						p.droit.add(new Droitee(p.points.get(iy),p.points.get(iy+1),"demi")) ;
						p.bool.add(0);
						iy++ ;
					}
					if(p.points.get(iy).getVeri() == 999){
						p.droit.add(new Droitee(p.points.get(iy),p.points.get(iy+1),"media")) ;
						p.bool.add(2);
						iy++ ;
					}
					if(p.points.get(iy).getVeri() == 2){
						p.droit.add(new Droitee(p.points.get(iy),p.points.get(iy+1),p.points.get(iy+2))) ;
						p.bool.add(3);
						iy=iy+2 ; ;
					}
					if(p.points.get(iy).getVeri() == 3){
						p.seg.add(new Segment(p.points.get(iy),p.points.get(iy+1))) ;
						p.bool.add(2);
						iy++ ;
					}
					if(p.points.get(iy).getVeri() == 4){
						p.trig.add(new Triangle(p.points.get(iy) , p.points.get(iy+1) , p.points.get(iy+2),p.r)) ;
						
						iy+=2 ;
					}
					if(p.points.get(iy).getVeri() == 7){
						p.cer.add(new Cercl(p.points.get(iy),p.points.get(iy+1),p.r));
						iy++ ;
					}
					/*	
					 * Polygone
					 */
					if(p.points.get(iy).getVeri() == 98 || p.points.get(iy).getVeri()==42){
						ArrayList<Points> tmpo = new ArrayList<Points>() ;
						int compt = 0 ; 
				
						
						
						for(int k = iy; k < p.points.size() ; k++){
							if(p.points.get(k).getVeri()!=98 || p.points.get(k).getVeri()==42)
								break ;
							tmpo.add(p.points.get(iy));
						}
						p.paul.add(new Polygone(tmpo,p.r));
						iy= iy+ p.paul.get(p.paul.size()-1).size ;
						p.repaint() ;
						
						
					
					}
					
					
	  		}
	  		
	  		
	  		
	  	
	  		p.repaint() ;
	  		
	  		}
		});
		i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
		bar.add(m);
		
		m2.add(i3);
		i3.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			/*
	  			 * On efface tous ce qu'il y a dans le panneau 
	  			 */
	  		//   bruitage [16] = new Brui("delete",boule) ;
	  		
	  			//Bruitage relatif au fichier son 
	  			bruitage [16] = new Brui("erace",boule) ;
	  			
	  			Brui corb = new Brui("corbe",boule);
	  		   bruitage[16].jou() ;
	  		   corb.jou() ;
	  		   /*
	  		    * On efface tous le tableau de bord
	  		    */
	  		   if(!p.confirm){
	  		
	  		    p.paul = new ArrayList<Polygone>() ;
	  			p.points = new ArrayList<Points>	() ;
	  			p.droit = new ArrayList<Droitee>() ;
	  			
	  			
	  			//p.seg = new ArrayList<Segment>() ;
	  			
	  			for(int i = 0 ; i <p.seg.size(); i++){
	  				if(p.seg.get(i).getMatrice() != 1){
	  					p.seg.remove(i);
	  				}
	  			}
	  		
	  			p.bool = new ArrayList<Integer>() ;
	  			p.doot = new ArrayList<Dott>();
	  			p.trig = new ArrayList<Triangle>() ;
	  			p.imag = new ArrayList<Imagee>();
	  			p.cer = new ArrayList<Cercl>() ;
	  			p.rect = new ArrayList<Rectangle>() ;
	  			p.memoire=0 ;
	  			//p.lisp = new ArrayList<Points>() ;
	  		   }else{
	  			   /*
	  			    * ici on efface ce que l'outil de selection a pris
	  			    */
	  			   
	  			   if(p.selection.size()!=0){
	  			   if(p.selection.get(p.selection.size()-1) instanceof Droitee){
	  				   for(int i = 0 ; i < p.droit.size() ; i++){
	  					   if(p.selection.get(p.selection.size()-1).equals(p.droit.get(i))){
	  						   p.droit.remove(p.droit.get(i));
	  						   break ;
	  					   }
	  				   }
	  			   }
	  			   if(p.selection.get(p.selection.size()-1) instanceof Points){
	  				   
	  				   for(int i  =0 ; i < p.points.size()-1 ; i++){
	  					  if(p.selection.get(p.selection.size()-1).equals(p.points.get(i))){
	  					   p.points.remove(i);
	  					   break;
	  					  }
	  				   }
	  			   }
	  			  }
	  		   }
	  			p.bou[6]=false ;
	  			p.repaint() ;
	  		}
		});
		i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
		
		
		m2.add(i4);
		
		m2.add(i18);
		i18.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    		String nom = jop.showInputDialog(null, "Nom de votre Fichier(avec extension)",
	    				"Nom Fichier",
	    		JOptionPane.QUESTION_MESSAGE);
	  			
	  			Memoire mem = new Memoire(nom) ;
	  		

	  			mem.ecrire(nom , aff.getTexte());
	    		
	  		}
		});
		bar.add(m2);
		m3.add(i5);
		/*
		 * ouvre une nouvelle fenetre
		 */
		
		i5.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			new Appli() ;
	  		
	  		}
	  	});
		
		
		m6.add(i24);
		i24.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			new Iimanga() ;
	  		}
	  	});
		
		m6.add(i25);
		i25.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			new Mario1();
	  		}
	  	});		
		
		m3.add(i7);
		/*
		 * ouvre une calculatrice
		 */
		
		i7.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			//bruitage [0] = new Brui("calc",boule) ;
	  			bruitage [0] = new Brui("calculator",boule) ;
	  			bruitage[0].jou() ;
	  			new Calculus() ;
	  		}
	  	});
		bar.add(m3);
		
		
		m4.add(i8);
		m4.add(i16);
		
		m4.add(i23);
		/*
		 * Fonction permettant de tracer la tangante a une courbure
		 * Tres tres aproximatif : l'equation de droite est y = F'(a)(x-a)+f'(a);
		 */
		
		i23.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			if(p.selection.get(p.selection.size()-1) instanceof Points){
	  				Points ppp = (Points)(p.selection.get(p.selection.size()-1)) ;
	  				if(ppp.getVeri()==50){
	  					
	  					pol = new Polynome(fonction);
	  					System.out.println(fonction+" =Fonction ");
	  					pol.analyse() ;
	  					pol.derive() ;
	  					
	  					Points tmp1 ; 
	  				  if(p.getIo() <= 8 && p.getOi() <= 6){
	  					  tmp1 = new Points(ppp.getX() ,ppp.getY(),p.z1[p.incremen] ,p.z2[p.incremen],1);  
	  				  }else {
	  					 tmp1 = new Points( ppp.getX(),ppp.getY(),p.getZo1() ,p.getZo2(),1);
	  				  }
	  				  
	  				  p.points.add(tmp1);
	  				  
	  				 
	  				Points tmp2 ;  
	  				 if(p.getIo() <= 8 && p.getOi() <= 6){
	  					 tmp2 = new Points((double)(4),(double)((pol.fonction2(tmp1.getXx())*(4 - tmp1.getXx()))+(pol.fonction(tmp1.getXx())))  ,p.z1[p.incremen],p.z2[p.incremen],1);
	  				 }else {
	  					 tmp2 = new Points((double)(4),(double)((pol.fonction2(tmp1.getXx())*(4 - tmp1.getXx()))+(pol.fonction(tmp1.getXx())))  ,p.getZo1(),p.getZo2(),1);
	  				 }
	  				 
	  				 System.out.println(pol.fonction2(tmp1.getXx())+" mlmlm"+tmp2.getYy());
	  				p.points.add(tmp2);
  					p.droit.add(new Droitee(tmp1,tmp2,"droite"));
  					p.bool.add(1);
	  					p.repaint();
	  					
	  					
	  				}
	  			}
	  		}
		});
		
		i16.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			naruto(7,7) ;	
	  			p.repaint() ;
	  		}
		});
		
		m4.add(i17);
		i17.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			JOptionPane az = new JOptionPane() ;
	  			int opt = az.showConfirmDialog(null ,"garder l'affichage ?","Menu",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if( opt == JOptionPane.OK_OPTION){
	            	p.depart = true ;
	            }else{
	            	p.depart = false ;
	            	for(int i = 0 ; i <p.seg.size(); i++){
		  				if(p.seg.get(i).getMatrice() == 1){
		  					p.seg.remove(i);
		  					
		  				}
	            	
		  				
		  			}
	            
	            	
	            	p.seg = new ArrayList<Segment>() ;	
	            }
	  		
	  		p.repaint() ;
	  		}
		});
		
		
		m4.add(i19);
		i19.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			if(p.bou [13]){
	  				if(p.points.size()!=0 && p.selection.size()!=0){
	  				
	  					
	  					
	  					Droitee droi = ((Droitee)p.selection.get(p.selection.size()-1));
	  					
	  					
	  					p.points.get(p.points.size()-1).setVeri(1);
	  					 if(p.getIo() <= 8 && p.getOi() <= 6){
	  						 p.points.add(	new Points( 200  ,(int)(droi.getQ()*200 + (p.points.get(p.points.size()-1).getY() - droi.getQ()* p.points.get(p.points.size()-1).getX() )),p.z1[p.incremen],p.z2[p.incremen],1));
	  					 }else{
	  						 
	 	  					p.points.add(	new Points( 200  ,(int)(droi.getQ()*200 +( p.points.get(p.points.size()-1).getY() - droi.getQ()* p.points.get(p.points.size()-1).getX()) ),p.getZo1(),p.getZo2(),1)); 
	  					 }
	  				
	  					
	  					p.droit.add(new Droitee(p.points.get(p.points.size()-1) , p.points.get(p.points.size()-2) , "droite"));
	  					
	  					p.bool.add(1);
	  					p.repaint() ;
	  					
	  			
	  				}else{
	  				JOptionPane	jop3 ; 
	  					jop3 = new JOptionPane();
	  					jop3.showMessageDialog(null, "Il y a une erreure", "Erreur",
	  					JOptionPane.ERROR_MESSAGE);
	  				}
	  			}
	  		}
		});
		
		
		m4.add(i20);
		i20.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			if(p.bou [13]){
	  				if(p.points.size()!=0 && p.selection.size()!=0){
	  					Droitee droi = ((Droitee)p.selection.get(p.selection.size()-1));
	  					p.points.get(p.points.size()-1).setVeri(1);
	  					
	  					
	  					 if(p.getIo() <= 8 && p.getOi() <= 6){
	  						 p.points.add(new Points(200 ,(int)((-1/droi.getQ())*200  + (p.points.get(p.points.size()-1).getY() - (-1/droi.getQ()*p.points.get(p.points.size()-1).getX() )  )) ,p.z1[p.incremen],p.z2[p.incremen],1));
	  					 }else{
	  						 p.points.add(new Points(200 ,(int)((-1/droi.getQ())*200  + (p.points.get(p.points.size()-1).getY() - (-1/droi.getQ()*p.points.get(p.points.size()-1).getX() )  )) ,p.getZo1(),p.getZo2(),1));
	  					 }
	  					 
	  					 p.droit.add(new Droitee(p.points.get(p.points.size()-1) , p.points.get(p.points.size()-2) , "droite"));
	  					
	  					p.bool.add(1);
	  					p.repaint() ;
	  					 
	  				}else{
	  					JOptionPane	jop3 ; 
	  					jop3 = new JOptionPane();
	  					jop3.showMessageDialog(null, "Il y a une erreure", "Erreur",
	  					JOptionPane.ERROR_MESSAGE);
	  				}
	  			}
	  		}
		});
		
		m4.add(i15);
		
		m4.add(i22);
		i22.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			Thread tread = new Thread(new Test()) ;
	  			tread.start() ;
	  			
	  		}
		});
		
		i15.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			JOptionPane az = new JOptionPane() ;
	  			int opt = az.showConfirmDialog(null ,"Figure pleine ?","Menu",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if( opt == JOptionPane.OK_OPTION){
	            	p.plein = true ;
	            }else{
	            	p.plein = false ;
	            }
	            p.repaint() ;
	  		}
		});
		
		i17.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK));
		i16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK));
		
		i8.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			
	  			//bruitage [1] = new Brui("color",boule) ;
	  			bruitage [1] = new Brui("couleur",boule) ;
	  			bruitage[1].jou() ;
	  			FenetreC f = new FenetreC(p) ;
	  		}
	  	});
		
		i8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
		
		bar.add(m4);
		m5.add(i6);
		i6.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		
	  			JOptionPane jop1 = new JOptionPane();
	  			jop1.showMessageDialog(null, "Ce programme a ete programme par Patrick Chen \n ", "Information",
	  			JOptionPane.INFORMATION_MESSAGE);
  		}
		});
		
		m6.add(i9);
		i9.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		  bruitage[12] = new Brui("morpion",boule);
			   bruitage[12].jou() ;
	  			new Morpion() ;
	  		}
	  	});
		
		m6.add(i10);
		i10.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		  bruitage[13] = new Brui("vie",boule);
			   bruitage[13].jou() ;
	  			new Jeuvie() ;
	  			
	  		}
	  	});
		
		m6.add(i11);
		i11.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		  bruitage[14] = new Brui("chess",boule);
			   bruitage[14].jou() ;
	  			new Fenetrechess() ;
	  		}
	  	});
		
	
		m6.add(i12);
		i12.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		  bruitage[15] = new Brui("gounki",boule);
			   bruitage[15].jou() ;
	  			new Gounki() ;
	  		}
	  	});
		
		m6.add(i13);
		i13.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		   bruitage [17] = new Brui("dbz",boule) ;
	  			bruitage[17].jou() ;
	  			new Applica() ;
	  		}
	  	});
		m6.add(i14);
		i14.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		  bruitage[16] = new Brui("snake",boule);
			   bruitage[16].jou() ;
	  			new Snake() ;
	  		}
	  	});
		
		
		m6.add(i26) ;
		i26.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  			new Casse() ;
	  		
	  		}
	  	});
		m6.add(i27) ;
		i27.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent event){
	  		
	  			//bug a reparer
	  			//new Fenetre() ;
	  		}
	  	});
		
		//Custumisation version Matrix 
		
		
		m.setForeground(Color.ORANGE);
		m2.setForeground(Color.ORANGE);
		m3.setForeground(Color.ORANGE);
		m4.setForeground(Color.ORANGE);
		m5.setForeground(Color.ORANGE);
		m6.setForeground(Color.ORANGE);
		i.setForeground(Color.green);
		i.setBackground(Color.black);
		
		i2.setForeground(Color.green);
		i2.setBackground(Color.black);
		
		i3.setForeground(Color.green);
		i3.setBackground(Color.black);
		
		i4.setForeground(Color.green);
		i4.setBackground(Color.black);
		
		i5.setForeground(Color.green);
		i5.setBackground(Color.black);
		
		i6.setForeground(Color.green);
		i6.setBackground(Color.black);
		
		i7.setForeground(Color.green);
		i7.setBackground(Color.black);
		
		i8.setForeground(Color.green);
		i8.setBackground(Color.black);
		i9.setForeground(Color.green);
		i9.setBackground(Color.black);
		i10.setForeground(Color.green);
		i10.setBackground(Color.black);
		
		i11.setForeground(Color.green);
		i11.setBackground(Color.black);
		i12.setForeground(Color.green);
		i12.setBackground(Color.black);
		i13.setForeground(Color.green);
		i13.setBackground(Color.black);
		i14.setForeground(Color.green);
		i14.setBackground(Color.black);
		i17.setForeground(Color.green);
		i17.setBackground(Color.black);
		i16.setForeground(Color.green);
		i16.setBackground(Color.black);
		i15.setForeground(Color.green);
		i15.setBackground(Color.black);
		i18.setForeground(Color.green);
		i18.setBackground(Color.black);
		i19.setForeground(Color.green);
		i19.setBackground(Color.black);
		i20.setForeground(Color.green);
		i20.setBackground(Color.black);
		i21.setForeground(Color.green);
		i21.setBackground(Color.black);
		i22.setForeground(Color.green);
		i22.setBackground(Color.black);
		i23.setForeground(Color.green);
		i23.setBackground(Color.black);
		i24.setForeground(Color.green);
		i24.setBackground(Color.black);
		i25.setForeground(Color.green);
		i25.setBackground(Color.black);
		i26.setForeground(Color.green);
		i26.setBackground(Color.black);
		i27.setForeground(Color.green);
		i27.setBackground(Color.black);
		bar.add(m6);
		bar.add(m5);
		
		
		

		
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(p, BorderLayout.CENTER);
		
		jtf = new JTextField();
		Font police = new Font("Arial", Font.BOLD, 14);
		jtf.setFont(police);
		
		//jtf.setBackground(Color.black);
		jtf.setBackground(new Color(20,20,20));
		
		jtf.setForeground(Color.GREEN);
		
		JPanel north = new JPanel();
		north.setBackground(new Color(20,20,20));
		
		north.add(b);
		north.add(b2);
		north.add(b3);
		north.add(b4);
		north.add(b5);
		north.add(b6);
		north.add(b7);
		north.add(b8);
		north.add(b9);
		north.add(b10);
		north.add(b11);
		north.add(b12);
		north.add(b13);
		north.add(b14);
		north.add(b15);
		JPanel south = new JPanel();
		south.setBackground(new Color(20,20,20));
		lab.setForeground(Color.GREEN);
		south.add(lab);
		south.add(jtf);
		jtf.setPreferredSize(new Dimension(750, 40));
		jtf.addKeyListener(new ClavierListener());
		container.add(south , BorderLayout.SOUTH);
		container.add(north , BorderLayout.NORTH);
		
		bar.setBackground(new Color(20,20,20));
		
		
		this.setJMenuBar(bar) ;
	
		
		this.setContentPane(container);
		
		
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(aff), new JScrollPane(p));
	    //On place le séparateur
	    split.setDividerLocation(150);
	    
	   
	    
	    //On ajoute le tout
	    this.getContentPane().add(split, BorderLayout.CENTER);
		
		

	
		
		this.setVisible(true);
		//this.dispose();
		bruitage[21].jou() ;
		
		
		effacerson();
		//bruitage[3] = new Brui("lancement2",boule);
		bruitage[3] = new Brui("debu",boule);
		bruitage[28] = new Brui("detecteur4_converted",boule);
		bruitage[3].jou()  ;
		//   bruitage[28].lop() ;
		
		if(repet){
		thread = new Thread(new Play());
		thread.start() ;
		
			/*  song = new Brui("ir2",boule);
			  song.lop() ;	*/
	
		repet = false ;
		}
		
		 
		
	
		 

		
	}
	
	public JMenuItem getI() {
		return i;
	}

	public void setI(JMenuItem i) {
		this.i = i;
	}

	public JMenuItem getI2() {
		return i2;
	}

	public void setI2(JMenuItem i2) {
		this.i2 = i2;
	}

	public void effacerson(){
	 for(Brui br :this.bruitage){
		 if(br != null)
			 br.stop() ;
	 }
	}
	class ClavierListener implements KeyListener{
			
	
			public void keyPressed(KeyEvent event) {
			    
		    
		
		 	if(event.getKeyCode() != 18 && event.getKeyCode() != 8  && event.getKeyCode() != 10 &&
		 			event.getKeyCode() != 32 && event.getKeyCode() !=16 
		 			&& event.getKeyCode() != 37  && event.getKeyCode() != 38
		 			&& event.getKeyCode() != 39 && event.getKeyCode() != 40){
				fonction = fonction + event.getKeyChar() ;
				
		 	}
		 	
		 	if(event.getKeyCode() == 8){
		 			fonction = fonction.substring(0 ,fonction.length() -1);
		 	}
		 	if(event.getKeyCode() == 10){
		 	
		 	/*	p.setFonc(fonction);
		 		p.trace = true ;
		 		p.repaint() ;*/
		 	 pol = new Polynome(fonction);
		 	 
		 	 
		 	 for(int i = 0 ; i < fonction.length() ; i++){
		 		 if(Character.toString(fonction.charAt(i)).equals("d") && fonction.length()>3){
		 			pol.analyse() ;
		 			 pol.derive() ;
		 			 for(double xx = -5 ; xx < 5 ; xx=xx+0.01){
		 				p.points.add(new Points(((double)xx) ,((double)pol.fonction2(xx))  ,1,1,50));
		 			
		 			}
		 			 break ;
		 		 }
		 	 }
		 	 
		 		if(Character.toString(fonction.charAt(0)).equals("p")){
		 	
		 			pol.analyse() ;
		 	
		 			for(double x = -5 ; x < 5 ; x=x+0.01){
		 				p.points.add(new Points(((double)x) ,((double)pol.fonction(x))  ,1,1,50));
		 			
		 			}
		 		}else if(Character.toString(fonction.charAt(0)).equals("s")){
		 			for(int x = -7 ; x < 7 ; x+=1){
		 				pol.analyse() ;
		 				p.points.add(new Points(((double)x) ,((double)Math.sin(pol.fonction(x)))  ,1,1,50));
		 			}
		 		}else if(Character.toString(fonction.charAt(0)).equals("c")){
		 			for(int x = -7 ; x < 7 ; x+=1){
		 				pol.analyse() ;
		 				p.points.add(new Points(((double)x) ,((double)Math.cos(pol.fonction(x)))  ,1,1,50));
		 			}
		 		}
		 		
		 	}
		 	p.repaint() ;
		 
		 	
			}
			public void keyReleased(KeyEvent event) {
			            
			} 
			
			public void keyTyped(KeyEvent event) {
			   
			}   	
	   }
	
		public void zero (){
			for(int o = 0 ; o < p.bou.length ; o++)
				p.bou[o] =false ;
		}
	
	   public void actionPerformed(ActionEvent arg0) {
	
		   
		   if(arg0.getSource() == b){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   
			   //bruitage[2] = new Brui("point",boule) ;
			   bruitage[2] = new Brui("pointe",boule) ;
			   bruitage[2].jou() ;
			  zero() ;
			  p.sta = true ;
			   p.bou[0] = true ;
		   }
		   if(arg0.getSource() == b2){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   
			   if(Math.random()<0.4)
			//   bruitage [7] = new Brui("droite",boule) ;
				   bruitage [7] = new Brui("droitee",boule) ;
				   
				   else
			  // bruitage [7] = new Brui("droite2",boule) ;   
			   bruitage [7] = new Brui("dr2",boule) ;
			   
			   bruitage[7].jou() ;
			   zero() ;
			   p.sta = true ;
			   p.bou[1]= true;

		   }
		   if(arg0.getSource() == b4){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   
			   if(Math.random()<0.4)
			   bruitage[9] = new Brui("seg",boule);
			   else
				   bruitage [9] = new Brui("seg2",boule) ;
			   bruitage[9].jou();
			   zero() ;
			   p.bou[3] = true ;
		   }
		   if(arg0.getSource() == b5){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   bruitage [6] = new Brui("half",boule) ;
			 
			   bruitage[6].jou() ;
			   
			   zero() ;
			   p.bou[4] = true ;
		   }
		   if(arg0.getSource() == b6){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   //bruitage [8] = new Brui("media",boule) ;
			   bruitage [8] = new Brui("mediator",boule) ;
			   bruitage[8].jou() ;
			   zero() ;
		   
			   p.bou[5] = true ;
		   }
		   
		   if(arg0.getSource() == b3){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   if(Math.random()<0.5)
			   bruitage [4] = new Brui("bisex",boule) ;
			   else
			   bruitage [4] = new Brui("bisex2",boule) ;
			   bruitage[4].jou() ;
			   zero() ;
			   p.bou[2] = true ;
		   }
		   if(arg0.getSource() == b8){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   if(Math.random()<0.5)
			   bruitage [5] = new Brui("draw",boule) ;
			   else
				   bruitage [5] = new Brui("draw2",boule) ;
			   
			   bruitage[5].jou() ;
			   
			   zero() ;
			   p.bou[7] = true ;
		   }
		   if(arg0.getSource() == b9){
			   effacerson();
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   bruitage [25] = new Brui("iomage",boule) ;
			   bruitage[25].jou() ;
			   
			   zero() ;
			   p.bou[8] = true ;
		   }
		   if(arg0.getSource() == b10){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   if(Math.random() < 0.5)
			   bruitage[10] = new Brui("tri",boule);
			   else
			   bruitage [10] = new Brui("tr2",boule) ;	   
			   bruitage[10].jou() ;
		
			   
			   zero() ;
			   p.bou[9] = true ;
		   }
		   if(arg0.getSource() == b11){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   
			   bruitage[11] = new Brui("baryex",boule);
			   bruitage[11].jou() ;
			   
			   zero() ;
			   p.bou[10] = true ;
		   }
		   
		   if(arg0.getSource() == b12){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   bruitage [28] = new Brui("circle",boule);
			   bruitage [28].jou() ;
			   
			   zero() ;
			   p.bou[11] = true ;
		   }
	
		   if(arg0.getSource() == b13){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   
			   zero() ;
			   p.bou[12] = true ;
			   JOptionPane az = new JOptionPane();
			   int opt = az.showConfirmDialog(null ,"le voulez vous Régulier ?","Menu",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if( opt == JOptionPane.OK_OPTION){
	            	p.regulier=false;
	            }else{
	            	p.regulier=true;
	            }
			   
		   }
		   
		   
		   if(arg0.getSource() == b7){
			 
			   
			   zero() ;
			   p.bou[6] = true ;  
			   if(p.droit.size()==0 || p.selection.isEmpty()){
				   JOptionPane	jop3 ; 
 					jop3 = new JOptionPane();
 					jop3.showMessageDialog(null, "Il y a une erreure", "Erreur",
 					JOptionPane.ERROR_MESSAGE);
			   }else{
			  
			   if(p.getIo() <= 8 && p.getOi() <= 6){
				   Droitee d1 = (Droitee)p.selection.get(p.selection.size()-1) ;
				   Droitee d2 = (Droitee)p.selection.get(p.selection.size()-2);
				   p.points.add(d1.inter(d2 , p.z1[p.incremen] , p.z2[p.incremen]));
			   }else{
				   Droitee d1 = (Droitee)p.selection.get(p.selection.size()-1) ;
				   Droitee d2 = (Droitee)p.selection.get(p.selection.size()-2);
				 p.points.add(d1.inter(d2 , p.getZo1() , p.getZo2()));
			   }
			   p.repaint() ;
			   
			   
			   }
		   }
		   
		   if(arg0.getSource() == b14){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   zero() ;
			   p.bou[13] = true ;
			   
			//  p.droit.get(0).getDep().setX( p.droit.get(0).getDep().getX()+40 );
			  
			 
			   p.repaint() ;
			  
		   }
		   if(arg0.getSource() == b15){
			   if(Math.random() <0.5)
				   bruitage[21].jou() ;
			   else
				   bruitage[20].jou();
			   zero() ;
			   p.bou[14] = true ;
		   }
		   
	   }
	   
	   public void naruto(int aaaa , int bbbb){
			//Permet de faire apparaitre un spiral
		  	int x0=800/2;
			int y0=530/2;
			int xx,yy;
			double aaa,bbb;
			aaa=aaaa;
			bbb=bbbb;
			
			for(int teta=0;teta<180*3;teta+=1){
			    xx=(int)(x0 + (aaa*teta)*Math.cos((Math.PI*teta*bbb)/180));
			    yy=(int)(y0 + (aaa*teta)*Math.sin((Math.PI*teta*bbb)/180));
			
			p.points.add(new Points(xx, yy,p.z1[p.incremen], p.z2[p.incremen] ,50 ));
			
			p.repaint() ;
			 
			}
	   }
	   
	   class Test implements Runnable{
		   public void run(){
			   new Dragon(p.r ,true) ;
		   }
	   }
	   
	   class Play implements Runnable{
		   public void run(){
			 /*En attente de l'import du fichier Son 
			  *song = new Brui("ir2",boule);
			  song.lop() ;
			   */
			   p.pause(2000);
			   p.depart = true ;
			   
			   for(int j = 0 ; j < 2 ; j++){
				   if(j==0)
					   naruto(70,70) ;
				   if(j==1)
					   naruto(7,7);
			   for(int i = 0 ; i < 40; i++){
				   if(i <=15){
					 
					   p.pause(100);
					   p.clone(false);
				   }else if(i>15 && i < 34){
					
					   p.pause(100);
					   p.clone(true);
				   }else{
					   p.pause(150);
					   p.clone(false);
				   }
			   }
			   }
			
			   // p.depart = false ;
			//  p.seg = new ArrayList<Segment>();
			  p.points = new ArrayList<Points>();
			  
			  p.repaint() ;
			//  p.pause(200);
			  
			
			 
		   }
	   }
	   
	   /*
	    * Methode qui presente les fonctionalités 
	    * @test
	    */
	   
	   public void test (){
		   p.points.add(new Points(300,200,1,1,1));
			  p.alter.jou() ;
			  p.pause(500);
			  p.repaint();
			  
			  p.points.add(new Points(500,370,1,1,1));
			  p.alter.jou() ;
			  p.pause(500);
			  p.repaint();
			  
			  p.droit.add(new Droitee(p.points.get(p.points.size()-2), p.points.get(p.points.size()-1) , "droite"));
			  p.bool.add(1);
			 p.faok = new Brui("grap" ,true) ;
			 p.faok.jou() ;
			 p.repaint();
			 
			 p.selection.add(p.droit.get(0));
			 
			  p.points.add(new Points(120,430,1,1,1));
			  p.alter.jou() ;
			  p.pause(500);
			  p.repaint();
			 
		   
	   }
	   

	
	public static void main(String[] args) {
		/*
		 * Debut et Dragon
		 * peuvent etre mis en commentaire 
		 * si on veux demarer vite le programme
		 */
		//Debut deb = new Debut() ;
	//	new Dragon(Color.red , false);
		new Appli() ;
	}

}
