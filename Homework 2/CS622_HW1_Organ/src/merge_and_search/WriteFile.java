package merge_and_search;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {
	private ArrayList<String> newFileContent;
	
	public WriteFile(ArrayList<String> newFileContent) {
		this.newFileContent = newFileContent;
	}
	
	public void WriteFileToDisk() {
		BufferedWriter br = null;
		try
		{
			br = new BufferedWriter(new FileWriter("results/test.csv")); // 2nd arg will append instead of write (true or false)
			for (String line : newFileContent)
				br.write(line + "\n");
			br.close();
			System.out.println("Successfully wrote file to disk");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to initialize BufferedWriter, exiting method...");
			return;
		}	
	}
}
