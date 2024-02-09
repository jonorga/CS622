/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 2/5/2024
 * File Name: FindFiles.java
 * Description: This file contains the FindFiles class. This class finds the CSV files somewhere in one
 * of the child folders from where this project is running and saves an array list of all the paths to
 * CSVs it found.
 */

package merge_and_search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FindFiles {
	private String currentPath;
	private ArrayList<File> dataFilePaths;
	private File dataDirectory;
	private boolean dataDirectoryIsSet;

	/**
     * This is the constructor method that attempts to find a default directory called "data"
     */
	public FindFiles() {
		dataFilePaths = new ArrayList<File>();
		try
		{
			currentPath = new File(".").getCanonicalPath();
			getDataDirectory("data");
		}
		catch (IOException e) 
		{
			currentPath = "";
			System.out.println("An exception occured while initializing a FindFiles object");
			e.printStackTrace();
		}
	}
	
	/**
     * This is a getter method for the dataDirectoryIsSet variable
     */
	public boolean getDataDirectoryIsSet() {
		return dataDirectoryIsSet;
	}
	
	/**
     * This method attempts to find a data directory with the given input name. If one is found,
     * it searches for all CSV files it contains with recursiveFileSearch
     */
	public void getDataDirectory(String dirName) {
		if ( new File(currentPath + "/" + dirName).exists() ) {
			System.out.print("Found data directory in current working path. ");
			dataDirectory = new File(currentPath + "/" + dirName);
			dataDirectoryIsSet = true;
		}
		else {
			System.out.println("No data directory found, please specify data folder name");
			dataDirectoryIsSet = false;
			return;
		}
		recursiveFileSearch(dataDirectory);
		System.out.println("Found " + dataFilePaths.size() + " files");
	}
	
	/**
     * This is a helper method that recursively checks through every child directory of the specified data
     * directory.
     */
	private void recursiveFileSearch(File directory) {
		for (File fileEntry : directory.listFiles()) {
			if (fileEntry.isDirectory()) {
				recursiveFileSearch(fileEntry);
			}
			else {
				if (fileEntry.toString().matches("/.*csv"))
					dataFilePaths.add(fileEntry);
			}
		}
	}
	
	/**
     * This method returns one file by it's index in the array list
     * @return File
     */
	public File getFileByIndex(int index) {
		return dataFilePaths.get(index);
	}
	
	/**
     * This method returns how many files were found
     * @return int
     */
	public int getFoundFilesSize() {
		return dataFilePaths.size();
	}
	
	/**
     * This method returns the current working path
     * @return String
     */
	public String getCurrentPath() {
		return currentPath;
	}
}
