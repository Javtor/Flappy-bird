package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

	public static String loadAsString(String file) throws IOException {
		StringBuilder result = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String buffer = "";
		while((buffer = reader.readLine()) != null) {
			result.append(buffer);
			result.append("\n");
		}
		reader.close();
		return result.toString();
	}

}
