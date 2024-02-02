package merge_and_search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FindFiles {
	private String currentPath;
	private ArrayList<File> dataFilePaths;
	private File dataDirectory;

	public FindFiles() {
		dataFilePaths = new ArrayList<File>();
		try
		{
			currentPath = new File(".").getCanonicalPath();
			System.out.println("Current working path: " + currentPath);
			GetDataDirectory();
		}
		catch (IOException e) 
		{
			currentPath = "";
			System.out.println("An exception occured while initializing a FindFiles object");
			e.printStackTrace();
		}
	}
	
	private void GetDataDirectory() {
		if ( new File(currentPath + "/data").exists() ) {
			System.out.print("Found data directory in current working path. ");
			dataDirectory = new File(currentPath + "/data");
		}
		else {
			dataDirectory = new File(currentPath);
		}
		RecursiveFileSearch(dataDirectory);
		System.out.println("Found " + dataFilePaths.size() + " files");
	}
	
	private void RecursiveFileSearch(File directory) {
		for (File fileEntry : directory.listFiles()) {
			if (fileEntry.isDirectory()) {
				RecursiveFileSearch(fileEntry);
			}
			else {
				if (fileEntry.toString().matches("/.*csv"))
					dataFilePaths.add(fileEntry);
			}
		}
	}
	
	public File getFirstFile() {
		return dataFilePaths.get(0);
	}
}
