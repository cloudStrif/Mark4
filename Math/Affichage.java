
import java.awt.Color;



import javax.swing.JPanel;
import javax.swing.JTextArea;
/*
 * Terminal d'affichage 
 * qui s'actualise a fur et a mesure que l'on crée des objets
 */
public class Affichage extends JPanel {

	  private String texte = "";
	  private JTextArea jta;
	     
	  public Affichage(){
	    this.jta = new JTextArea(texte);
	    this.setBackground(new Color(20,20,20));
	    jta.setBackground(new Color(20,20,20));
	    jta.setForeground(Color.GREEN);
	    this.add(jta);
	    
	   
	  }
	  public void setTexte(String texte) {
	    this.jta.setText(texte);
	  }
	  public String getTexte(){
		  return this.jta.getText();
	  }
}
