package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Util {
    public static String readAll(String filename) {
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e1) {
			System.err.println("File " + filename + " does not exist");
			e1.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		String line = null;
		do {
			try {
				line = r.readLine();
				sb.append(line);
				sb.append("\n");
			} catch (IOException e) {
				System.err.println("Error when reading file " + filename);
				e.printStackTrace();
			}
		} while (line != null);

		try {
			r.close();
		} catch (IOException e) {
			System.err.println("Error closing file " + filename);
			e.printStackTrace();
		}
		return sb.toString();
	}
}
