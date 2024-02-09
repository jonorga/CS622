/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 2/5/2024
 * File Name: UserInterface.java
 * Description: This file contains the UserInterface class. This class acts as the main facilitator for the user
 * to interact with the merge and sort program. The loop is handled within the constructor with some helper methods.
 */

package merge_and_search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface {
	FindFiles findFiles;
	SearchMaster searchMaster;
	boolean running = true;
	
	/**
     * This is the constructor method loops until the user decides to exit the program. It allows the user
     * to merge the found files, specify a different data directory, search for a term, or exit the program
     */
	public UserInterface() {
		findFiles = new FindFiles();
		searchMaster = new SearchMaster();
		
		try
		{
			Files.createDirectories(Paths.get("results"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("Welcome to merge and search. Please enter an int to chose a function");
			
			while (running) {
				System.out.println("Choices - 1: merge found files, 2: change data directory, 3: search for term, 4: quit");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				int selection = bufferedReader.read();
				
				if (selection == 49) {
					mergeFoundFiles();
				}
				
				else if (selection == 50) {
					bufferedReader.readLine();
					System.out.println("Enter directory name to search for:");
					String dirName = bufferedReader.readLine();
					System.out.println("Searching for directory: " + dirName);
					findFiles.getDataDirectory(dirName);
				}
				
				else if (selection == 51) {
					bufferedReader.readLine();
					System.out.println("Enter term to search for:");
					String term = bufferedReader.readLine();
					System.out.println("Searching for term: " + term);
					searchMaster.scanForTerm(term);
				}
				
				else if (selection == 52) {
					running = false;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * This is a helper method that merges all of the found files. This method was separated out for the sake
     * of readability.
     */
	private void mergeFoundFiles() {
		if (!findFiles.getDataDirectoryIsSet()) {
			System.out.println("Please specify a data directory before attempting to merge");
			return;
		}
		MergeFile mergeFile = new MergeFile();
		mergeFile.doMerge(findFiles.getFileByIndex(0), true);
		System.out.println("Merging file 0 " + findFiles.getFileByIndex(1));
		
		for (int i = 1; i < 20; i++) {
			System.out.println("Merging file " + i + " " + findFiles.getFileByIndex(i));
			mergeFile.doMerge(findFiles.getFileByIndex(i));
		}
	}
}
