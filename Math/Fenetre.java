
import java.awt.BorderLayout;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

	Stack<Integer> pile = new Stack<Integer>() ;
	
	int ii =6;
	int jj =1;
	private JPanel container = new JPanel();
	private Fenetre2 pan = new Fenetre2(600,600) ;
	public Fenetre(){
		this.setTitle("track");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		
		this.setContentPane(container);
		this.setVisible(true);
		
		this.setVisible(true);
		search2() ;
	}
	

	
	public void search2(){
		boolean arrive =false ;
		int rd = 2 ;
		int fo = 0 ;
		boolean test= false ;
		while(!arrive){
			for(int i =fo ; i < 4 ; i++){
				System.out.println(i);
				System.out.println();
		
			if(i==rd){}
			else {
					if(i==0){
						rd = 2 ;
						if(pan.t[ii][jj+1] == 0){
							
							pile.push(i);
							pan.t[ii][jj+1]=-1 ;
							jj++ ;
							test= false ;
							
							break ;
					}
					}
					if(i==1){
						rd = 3 ;
						if(pan.t[ii-1][jj] == 0){
					
						pile.push(i);
						pan.t[ii-1][jj]=-1 ;
						ii--;
						test= false ;
						break ;
						}
					}	
					if(i==2){
						rd = 0 ;
						
						if(pan.t[ii][jj-1] == 0){
							
							pile.push(i);
							pan.t[ii][jj-1]=-1 ;
							jj--;
							test= false ;
							break ;
					}
					}
					if(i==3){
						rd = 1 ;
						if(pan.t[ii+1][jj] == 0){
							
							pile.push(i);
							pan.t[ii+1][jj]=-1 ;
							ii++ ;
							test= false ;
							fo=0 ;
							break ;
					}else{
						test= true ;
						break ;
					}
				
					
					}
					if(ii==1 && jj==8){
						arrive=true ;
						JOptionPane jop1 ;
			  			jop1 = new JOptionPane();
			  			jop1.showMessageDialog(null, "Nous sommes arrives", "Information",
			  			JOptionPane.INFORMATION_MESSAGE);
						break ;
					}
			  }
			}
			
			
			if(test){
				fo = pile.pop();
				System.out.println(fo+" : fo");
			
				if(fo==0){
					jj-- ;
					pan.t[ii][jj+1]=0;
					rd=0 ;
				}
				if(fo==1){
					ii++;
				pan.t[ii-1][jj]=0;
				rd=1;
				}
				if(fo==2){
					jj++;
				pan.t[ii][jj-1]=0;
				rd= 2 ;
				}
				if(fo==3){
					ii-- ;
				pan.t[ii+1][jj]=0;
				rd=3;
				}
				
				test=false ;
			}
			pause(600);
			pan.repaint() ;
			
		}
	}
	
	public void pause (int a){
		 try {
	            Thread.sleep(a);
	     } catch (InterruptedException e) {
	            e.printStackTrace();
	     }	
	}
	
}
