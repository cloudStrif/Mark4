

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FenetreC extends JFrame implements ActionListener{

	private JLabel lab = new JLabel("rouge") ;
	private JLabel lab2 = new JLabel("vert") ;
	private JLabel lab3 = new JLabel("Bleu") ;
	
	private JPanel cont = new JPanel();
	private Pan p = new Pan() ;
	
	private int a = 0 ;
	private int b = 0 ;
	private int c = 0 ;
	
	public Color colo = Color.red;
	
	Panneau pan ;
	
	private JMenuBar bar = new JMenuBar() ;
	private JMenu m = new JMenu("Quit") ;
	private JMenuItem i = new JMenuItem("quitter sans rien changer") ;
	
	private JButton bou = new JButton("Valider") ;
	
	public FenetreC(Panneau pp){
		this.pan = pp ;
		this.setTitle("");
		this.setSize(800, 300);
	
		this.setLocationRelativeTo(null);
		this.setUndecorated(true); 
		
		cont.setBackground(Color.white);
	    cont.setLayout(new BorderLayout());
	    cont.add(p, BorderLayout.CENTER);
		/*
		 * seulement 3 objet JSlider 
		 */
	    m.add(i);
	    bar.add(m);
	  
	    bou.addActionListener(this);
		
		JSlider slide = new JSlider();
		slide.setMaximum(130);
		slide.setMinimum(0);
		slide.setValue(0);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(10);
		slide.setMajorTickSpacing(20);
		slide.addChangeListener(new ChangeListener(){
		public void stateChanged(ChangeEvent event){
			
			a = ((JSlider)event.getSource()).getValue();
			p.aa = a ;
			 p.repaint() ;
			System.out.println(a);
		}
		});
		
		
		
		JSlider slid = new JSlider();
		slid.setMaximum(130);
		slid.setMinimum(0);
		slid.setValue(0);
		slid.setPaintTicks(true);
		slid.setPaintLabels(true);
		slid.setMinorTickSpacing(10);
		slid.setMajorTickSpacing(20);
		slid.addChangeListener(new ChangeListener(){
		public void stateChanged(ChangeEvent event){
			
			b = ((JSlider)event.getSource()).getValue();
			p.bb = b ;
			 p.repaint() ;
			System.out.println(b);
		}
		});
		
		JSlider sli = new JSlider();
		sli.setMaximum(130);
		sli.setMinimum(0);
		sli.setValue(0);
		sli.setPaintTicks(true);
		sli.setPaintLabels(true);
		sli.setMinorTickSpacing(10);
		sli.setMajorTickSpacing(20);
		sli.addChangeListener(new ChangeListener(){
		public void stateChanged(ChangeEvent event){
			
			 c = ((JSlider)event.getSource()).getValue();
			 p.cc = c ;
			 p.repaint() ;
			System.out.println(c);
		}
		});
		
		
		JPanel s = new JPanel() ;
		s.add(slide);
		s.add(lab);
		s.add(slid);
		s.add(lab2);
		s.add(sli);
		s.add(lab3);
		
		JPanel s2 = new JPanel();
		s2.add(bou) ;
		
		cont.add(s , BorderLayout.NORTH);
		cont.add(s2 , BorderLayout.SOUTH);
		
		
		   i.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent event){
				dispose();
			    	
			    }
			});
			i.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		
		this.setJMenuBar(bar);
		 this.setContentPane(cont) ;
		
		this.setVisible(true);
		
	}
	
	
	
	 public void actionPerformed(ActionEvent arg0) {
		 if(arg0.getSource() == bou){
			 colo = new Color(a,b,c) ;
			 
			 pan.r = colo ;
			 dispose() ;
		 }
		 
	 }
	
	
}
