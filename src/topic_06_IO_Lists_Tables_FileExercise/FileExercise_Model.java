package topic_06_IO_Lists_Tables_FileExercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Our model only contains a bunch of strings
 */
public class FileExercise_Model {
	private static String NUMBERS_FILE = "numbers.txt";

	private ArrayList<Integer> numbers = null;

	public void readFile_v1() {
		InputStream inStream = this.getClass().getResourceAsStream(NUMBERS_FILE);
		try (BufferedReader fileIn = new BufferedReader(new InputStreamReader(inStream))) {
			numbers = new ArrayList<>();
			String line = fileIn.readLine();
			while (line != null) {
				int number = Integer.parseInt(line);
				numbers.add(number);
				line = fileIn.readLine();
			}
		} catch (IOException event) {
			numbers = null;
		}
	}

	public void readFile_v2() {
		InputStream inStream = this.getClass().getResourceAsStream(NUMBERS_FILE);
		try (Scanner in = new Scanner(inStream)) {
			numbers = new ArrayList<>();
			while (in.hasNext()) {
				int number = in.nextInt();
				numbers.add(number);
			}
		} catch (Exception e) {
			numbers = null;
		}
	}

	public boolean hasNumbers() {
		return (numbers != null);
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	public int calculateTotal() {
		int total = 0;
		for (int number : numbers)
			total += number;
		return total;
	}
}
