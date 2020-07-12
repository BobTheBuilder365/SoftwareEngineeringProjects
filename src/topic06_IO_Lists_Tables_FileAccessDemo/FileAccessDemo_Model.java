package topic06_IO_Lists_Tables_FileAccessDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileAccessDemo_Model {
	
	private static String SAVE_FILE = "FileAccess_SaveFile.sav";
	private static String PACKAGE_FILE = "FileAccess_ThisPackage.txt";
	private static String OTHER_PACKAGE = "sampleFiles";
	private static String OTHER_PACKAGE_FILE = "FileAccess_OtherPackage.txt";
	
	private String saveFileData;
	private String packageFileData;
	private String otherPackageData;
	
	
	public void readPackageFile() {
		// Das aktuelle Objekt kannst du bitte eine andere Resource holen
		// die am gleichen Ort liegt wie die aktuelle Klasse
		InputStream inStream = this.getClass().getResourceAsStream(PACKAGE_FILE);
		String data = "";
		
		// Von dem Stream möchte ich jetzt Text lesen und nicht binär
		// Vom InputStream zum Reader
		// und vom Reader zum BufferedReader um ein soclhes Objekt zu erhalten
		try (BufferedReader fileIn = new BufferedReader(new InputStreamReader(inStream))){
			data = fileIn.readLine();
		} catch (IOException event) {
			data = event.getClass().toString();
		}
		this.packageFileData = data;
			
		
		
	} 

}
