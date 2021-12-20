import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


public class NotenListe {
	
	//double dimensionale Array mit 3 Spalte und 98 Zeile
	public static int notenliste[][] = new int[size("Notenliste.csv")][3];
	
	public static void main(String[] args) {
		
		String csvFile = System.getProperty("user.dir")+"\\Notenliste.csv";
		
		System.out.println();
		System.out.println("Size: "+size(csvFile));
		
		
		ausfullen(csvFile);
		
		
		for(int i=0; i<size(csvFile); i++) {
			System.out.println("Matrikulnummer: "+notenliste[i][0]+" Note: "+notenliste[i][1]+" Auswertung: "+notenliste[i][2]);	
		}
		
        anzah_der_auswertung(notenliste);
        
        
		htmlseite() ;
		
	}
	//diese Methode übergibt ein String und gibt ein int zurück
	//sie berechnet alle Zeile der cvs-datei ohne die erste Zeile.
	static int size(String csvFile) {
		
		
		 	BufferedReader br = null;
	        int size = 0;
	        
	        try {
	        	//erzeugt der BufferedReader um die csv Datei zu lesen
	            br = new BufferedReader(new FileReader(csvFile));
	            br.readLine();
	            
	            //zählt jede Zeile von der csv Datei
	            while ((br.readLine()) != null) {
	            	size++;
	            }
	            
	        	br.close();
	        	
	        }catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	return size;
	     }
	//Diese Methode übergibt ein String(csvFile) und füllt das zwei dimensuionale Array NotenListe aus
	static void ausfullen(String csvFile) {
	 	BufferedReader br = null;
	 	int i = 0;
	 	String data = "";
	 	
       
        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((data= br.readLine()) != null) {
            	//schneidt der csv datei mit hilfe vom Komma ","
            String[] donnees = data.split(",");
            
            
            NotenListe.notenliste[i][0]= Integer.parseInt(donnees[0]);
            NotenListe.notenliste[i][1]= Integer.parseInt(donnees[1]);
            NotenListe.notenliste[i][2]=auswertung(notenliste[i][1]);
            i++;
            }
            
        	br.close();
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
     }
	
	//diese Methode macht ein Korrespondenz bei Note in Prozent zu auswertung(1,2,3,4 oder 5)
	static int auswertung(int note) {
		
		if(note>=88 && note<=100){
            return  1;
        }
        else if(note>=73 && note<=87){
            return  2;
        }
        else if(note>=58 && note<=72){
            return  3;
        }
        else if(note>=50 && note<=57){
            return  4;
        }
        else if(note>=0 && note<=49){
            return  5;
        }
        else{
            return 0;//error
        }
		
	}
	
	//diese Methode zählt die Bewertungen separant( anzahl der 1, anzahl der 2 ...)
	public static void anzah_der_auswertung(int[][] tab) {
		int x=0,b=0,c=0,d=0,e=0;
		
		for(int i=0;i<tab.length;i++) {
			
			if(tab[i][1]>=88 && tab[i][1]<=100){
			x=x+1;
		    }
		
			if(tab[i][1]>=73 && tab[i][1]<=87){
			b=b+1;
			}
			
			if(tab[i][1]>=58 && tab[i][1]<=72){
			c=c+1;
			}
			
			if(tab[i][1]>=50 && tab[i][1]<=57){
			d=d+1;
		    }
			
			if(tab[i][1]>=0 && tab[i][1]<=49){
			e=e+1;
			}
	    }
		System.out.println(" Anzahl der Note 1: "+x+"\n Anzahl der Note 2: "+b+" \n Anzahl der Note 3:"+c+"\n Anzahl der Note 4:"+d+
				"\n Anzahl der Note 5:"+e);
		
	}
	
	public static void ausgabe(String filename) {
		
	}
	
	//die gibt die HTML-Quelcode aus.
   public static void htmlseite() {
	   
	    String seitenkopf = "<!DOCTYPE html> \n <html> \n <body> \n <svg height='500' width='1300'>";
	    String htmlPath=System.getProperty("user.dir") + "/html/Auswertung.html";
		String seitenfuss = "\n </svg>\n </html> \n </body>";
		
		String test1="<text x=\"10\" y=\"50\" font-size=\"22\" font-family=\"Arial\" fill=green>Note 1: 13</text>";
		
		String rechteck1 = "<rect x=\"200\" y=\"10\" width=\"520\" height=\"70\" rx=\"3\" ry=\"3\" fill=green />";

		String test2="<text x=\"10\" y=\"150\" font-size=\"22\" font-family=\"Arial\" fill=orange>Note 2: 21</text>";
		String rechteck2 = "<rect x=\"200\" y=\"110\" width=\"800\" height=\"70\" rx=\"3\" ry=\"3\" fill=orange />";
		
		String test3="<text x=\"10\" y=\"250\" font-size=\"22\" font-family=\"Arial\" fill=purple>Note 3: 24</text>";
		String rechteck3 = "<rect x=\"200\" y=\"210\" width=\"950\" height=\"70\" rx=\"3\" ry=\"3\" fill=purple />";
		
		String test4="<text x=\"10\" y=\"350\" font-size=\"22\" font-family=\"Arial\" fill=blue>Note 4: 15</text>";
		String rechteck4 = "<rect x=\"200\" y=\"310\" width=\"600\" height=\"70\" rx=\"3\" ry =\"3\" fill=blue />";
		
		String test5="<text x=\"10\" y=\"450\" font-size=\"22\" font-family=\"Arial\" fill=grey>Note 5: 25</text>";
		String rechteck5 = " <rect x=\"200\" y=\"410\" width=\"1000\" height=\"70\" rx=\"3\" ry =\"3\" fill=grey />";
		
		String h2="<h2> Bestnote </h2>";
		String h3="<h3> Bestnote ist:  97 Punkte</h3>";
		
		
		
		String[] htmls= {seitenkopf, test1,rechteck1,test2,rechteck2,test3,rechteck3,test4,rechteck4,test5,rechteck5,h2,h3,seitenfuss};
		
		  for(String z:htmls) {
		  System.out.println(z);
		  System.out.println();
		  }
   }
	

 }
			
	
		
	
	
	 


