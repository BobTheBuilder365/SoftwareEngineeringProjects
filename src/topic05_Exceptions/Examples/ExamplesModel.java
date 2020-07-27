package topic05_Exceptions.Examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * This model contains methods that (may) cause various kinds of exceptions
 */
public class ExamplesModel {
	
	public String stackOverflow() {
		ArrayList<String> numbers = new ArrayList<>();
		try {
			while(true) {
				// This causes a stack overflow
				return Double.toString(deepRecursion(0));
			}
		} catch (Throwable e) {
			return e.getClass().toString();
		}
	}
	
	public String arrayIndex() {
		int[] nums = new int[3];
		try {
			nums[3] = 13;
			return "Success!"; // Will never happen
		} catch (Exception e) {
			return e.getClass().toString();
		}
	}
	
	public String parseInteger(String s) {
		// parseInt throws NumberFormatException
		// Try-Catch not required (maybe you already know the data is ok)
		try {
			Integer.parseInt(s);
			return "Success!";
		} catch (Exception e) {
			return e.getClass().toString();
		}
	}
	
	public String openFile(String path) {
		String result = null;
		File myFile = new File(path);
		InputStream is = null;
		try {
			is = new FileInputStream(myFile);
			is.read();
			result = "Success!";
		} catch (Exception e) {
			result = e.getClass().toString();
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				// We don't care about this exception,
				// but we must have the try/catch anyway
			}
		}
		return result;
	}
	
	private double deepRecursion(double in) {
		return deepRecursion(in + Math.random());
	}
}
