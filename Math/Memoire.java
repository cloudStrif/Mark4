
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Memoire {
	public boolean fg = false ;
	
	public Memoire (String nomF) {
		File fic = new File(nomF);
	}
	
	public Memoire(){}
	//vv = sauvegarde.txt

	
	
	public Memoire (String str,String vv) throws IOException{
		if(!fg){
		//File f = new File("Sauvegarde.txt");
		
		// Oui on efface
		ecrire(vv,str);
		/*  System.out.println("Chemin absolu du fichier : " +
				  f.getAbsolutePath());
				  System.out.println("Nom du fichier : " + f.getName());
				  System.out.println("Est-ce qu'il existe ? " + f.exists());
				  System.out.println("Est-ce un rpertoire ? " + f.isDirectory());
				  System.out.println("Est-ce un fihier ? " + f.isFile());
				  System.out.println();
	*/
		af(vv) ;
		
		}
		/*else {
		   new FileWriter(new File("sauvegarde.txt")).close();
		   fg = false ;
		}*/
	
		 // af() ;
		  
	}
	
	
	public String af (String ss){
		String chaine="";
		String fichier = ss;
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
			//	System.out.println(ligne);
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
			return "" ;
		}
		System.out.println(chaine);
		
		
		
		
		return chaine ;
		//return chaine ;
		//chaine contient le terrain
		//System.out.println("hello" + chaine);
	}
	
	
	
	
	
	   public void ecrire(String nomFic , String texte)
		{
			//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
			String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic;
		
			//on met try si jamais il y a une exception
			try
			{
				/**
				 * BufferedWriter a besoin d un FileWriter, 
				 * les 2 vont ensemble, on donne comme argument le nom du fichier
				 * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus 
				 
				 */
				FileWriter fw = new FileWriter(adressedufichier, true);
				
				// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
				BufferedWriter output = new BufferedWriter(fw);
				
				//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
				output.write(texte);
				//on peut utiliser plusieurs fois methode write
				
				output.flush();
				//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
				
				//output.close();
				//et on le ferme
				System.out.println("fichier cr");
			}
			catch(IOException ioe){
				System.out.print("Erreur : ");
				ioe.printStackTrace();
				}

		}
	   
	public static void main (String []a) throws IOException{
		// new Memoire ("hero") ;
	//String aa  =  "123456" ;
	//System.out.println(Integer.parseInt(aa , 0));
	/*char wc = '1' ;
	String fff = String.valueOf(wc);
	int aaaa  = wc ;
	System.out.println(aaaa);*/
	}
	   
   }
 
 
