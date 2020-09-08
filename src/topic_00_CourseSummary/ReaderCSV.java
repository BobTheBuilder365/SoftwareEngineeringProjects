package topic_00_CourseSummary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

// Lese die Textdatei ein und teile sie durch ein Komma-Trennzeichen. 

public class ReaderCSV {
	
	public static void main(String[] args) {
		
		readFileCSVinPack();
		
	}
	
	public static void readFileCSVinPack() {
		
		
		File file = new File(getClass().getResource("/example.csv");
		String csvFile = "country.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

               //use comma as separator
                String[]country = line.split(cvsSplitBy);

                System.out.println("Country[code= " + country[4]+ " , name=" + country[5]+ "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

		
	}

	
	/**
	 * while getting the Resource, you don't have to write the src folder name.. Because at runtime, jvm will get the resources from src folder and look for the next path.
	 */
	public void readCsv(   ) throws IOException, URISyntaxException { // throws IOException  ---  String[] args
	    System.out.println(".............");
	    System.out.println(System.getProperty("user.dir"));

	    int val = 20; // testing purposes
	    String [][] tab  = new String [100][400];
	    int saveInThisRow = 0;

	    File file = new File(getClass().getResource("/resources/GEMSTONES05.csv").toURI());
	    //String csvFilename = "/resources/GEMSTONES05.csv";

	    CSVReader csvReader = new CSVReader(new FileReader(file));
	    String[] row = null;
	    String total = "";
	    while((row = csvReader.readNext()) != null) {

	        for( int i = 0 ; i < 20 ; i++ ){  // no higher than num of columns to be found or error
	            String saveAway = row[i];
	            parent.println("CVS read  " + saveAway);
	            //tabl[saveInThisRow][i] = row[i];
	            tabl[saveInThisRow][i] = saveAway.replace('_', ' ');
	        }
	        saveInThisRow++;
	        if(saveInThisRow == 20) { saveInThisRow = 0; break; }

	    }

	    csvReader.close();

	    for( int i = 0 ; i < 300 ; i++){

	    }

	}
}
