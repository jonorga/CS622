/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 2/5/2024
 * File Name: MergeFile.java
 * Description: This file contains the MergeFile class. This class handles the merging the contents of the two files
 * with no duplicates. 
 */

package merge_and_search;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeFile {
	private FileContents fileContents = new FileContents();
	
	/**
     * This is an overloaded method to allow for the perception of a default parameter
     */
	public void doMerge(File file)
	{
		doMerge(file, false);
	}
	
	/**
     * This method actually handles the merging. If the file is the first to be merged, it write's the filtered
     * contents to the output file. If not, it pulls the output file in, adds an lines that aren't duplicates
     * and puts the file back on the disk.
     */
	public void doMerge(File file, boolean firstFile) {
		File masterFile = null;
		Scanner inFile = null;
		if (!firstFile) {
			masterFile = new File("results/output.csv");
		}
		
		try
		{
			if (firstFile)
				inFile = new Scanner(file);
			else
				inFile = new Scanner(masterFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		fileContents.firstLine = inFile.nextLine();
		while (inFile.hasNext()) {
			inputFilter(inFile.nextLine());
		}
		inFile.close();
		
		if (!firstFile)
		{
			try
			{
				inFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			while (inFile.hasNext()) {
				inputFilter(inFile.nextLine());
			}
			inFile.close();
		}
		
		WriteFile writeFile = new WriteFile(fileContents);
		writeFile.writeFileToDisk(!firstFile);
	}
	
	/**
     * This is a helper method that filters the input for any white space or invalid rows
     */
	private void inputFilter(String input) {
		String[] valueCheck;
		
		valueCheck = input.split(",");
		if (valueCheck.length <= 7)
			return;
		

		if (!input.matches("\\s+") && valueCheck.length > 7 && valueCheck[6].matches("\"\\d+\"")) {
			fileContents.mainContent.add(input);
		}
	}
}
