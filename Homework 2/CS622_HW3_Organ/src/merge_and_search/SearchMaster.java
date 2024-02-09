/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 2/5/2024
 * File Name: SearchMaster.java
 * Description: This file contains the SearchMaster class. This class searches the master file for a given term
 * and returns the close date and fund raised percent for any matches
 */

package merge_and_search;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class SearchMaster {
	/**
     * This method pulls in the output file and searches each line for that term. When it finds a line with the
     * term is parses the line and prints out the close data and fund raised percent
     */
	public void scanForTerm(String term) {
		Scanner inFile = null;
		try
		{
			inFile = new Scanner(new File("results/output.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String regexTerm = ".+" + term + ".+";
		String temp = "";
		String[] results;
		while (inFile.hasNext())
		{
			temp = inFile.nextLine();
			if (temp.matches(regexTerm)) {
				results = temp.split(",");
				if (results.length > 7)
					System.out.println("Found term: " + term + "\nClose date: " + results[4] + "\nFund Raised Percent: " + results[7] + "\n");
			}
		}
		
		inFile.close();
	}
}
