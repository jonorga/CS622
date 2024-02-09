/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 2/5/2024
 * File Name: WriteFile.java
 * Description: This file contains the WriteFile class. This class takes the data put into a FileContents
 * object and writes it back to the disk.
 */

package merge_and_search;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriteFile {
	public FileContents fileContents;
	
	/**
     * This is the constructor method that sets the initial fileContents value
     */
	public WriteFile(FileContents fileContents) {
		this.fileContents = fileContents;
	}
	
	/**
     * This method allows to set new file content to re-use the same object
     */
	public void setNewFileContent(FileContents fileContents) {
		this.fileContents = fileContents;
	}
	
	/**
     * This method write the information from the fileContent object to a CSV file on the disk
     */
	public void writeFileToDisk(boolean append) {
		BufferedWriter br = null;
		try
		{
			br = new BufferedWriter(new FileWriter("results/output.csv", append));
			br.write(fileContents.firstLine + "\n");
			for (String line : fileContents.mainContent) {
				br.write(line + "\n");
			}
				
			br.close();
			System.out.println("Successfully wrote file to disk");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to initialize BufferedWriter, exiting method...");
			return;
		}	
	}
}
