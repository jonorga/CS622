/**
 * Name: Jon Organ
 * Course: CS-622 Advanced Programming Techniques
 * Date: 2/5/2024
 * File Name: SearchHistory.java
 * Description: This file contains the SearchHistory class. This class manages the user's search history, including
 * adding queries to history, printing the history, writing the history to the disk, and reading it back. 
 */

package merge_and_search;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class SearchHistory {
	private HashMap<String, SearchQuery> queries = new HashMap<String, SearchQuery>();
	private int totalQueries = 0;
	private final String pattern = "MM/dd/yyyy HH:mm:ss";
	private final DateFormat df = new SimpleDateFormat(pattern);
	
	/**
     * This is the constructor method that uses the working path to check for an existing history
     * on the disk
     */
	public SearchHistory(String currentPath) {		
		checkForPreviousHistory(currentPath);
	}
	
	/**
     * This is a private helper class to store the timestamps of each query
     */
	private class SearchQuery {
		ArrayList<String> timestamps = new ArrayList<String>();
		
		public SearchQuery(String currentTime) {
			timestamps.add(currentTime);
		}
	}
	
	/**
     * This method adds a given search term to the history. If it already exists, it just adds the 
     * timestamp, otherwise it adds the term and timestamp. It also writes this to the disk.
     */
	public void addSearchQuery(String searchTerm) {
		Date today = Calendar.getInstance().getTime();
		String todayAsString = df.format(today);
		if (queries.containsKey(searchTerm)) {
			queries.get(searchTerm).timestamps.add(todayAsString);
		}
		else {
			queries.put(searchTerm, new SearchQuery(todayAsString));
		}
		writeHistoryToDisk();
		totalQueries++;
	}
	
	/**
     * This method prints out the user's search history. It iterates through each query and prints the term
     * and all of their timestamps.
     */
	public void printSearchHistory() {
		System.out.println("Search history:");
		
		System.out.println("Total number of queries: " + totalQueries);
		System.out.println("Total unique queries: " + queries.size());
		System.out.println("===========================================");
		System.out.println("Queries:");
		
		for (Map.Entry<String, SearchQuery> value : queries.entrySet()) {
			System.out.println("Search term: " + value.getKey() + ", frequency: " + value.getValue().timestamps.size()
					+ ", timestamps:");
			for (String date : value.getValue().timestamps) {
				System.out.println(date);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
     * This is a helper method that writes the current search history to the disk as a CSV file
     */
	private void writeHistoryToDisk() {
		BufferedWriter br = null;
		try
		{
			br = new BufferedWriter(new FileWriter("searchhistory.csv"));
			
			
			for (Map.Entry<String, SearchQuery> value : queries.entrySet()) {
				StringBuilder newLine = new StringBuilder();
				newLine.append(value.getKey() + ",");
				for (String date : value.getValue().timestamps) {
					newLine.append(date + ";");
				}
				br.write(newLine.toString() + "\n");
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * This is a helper method that checks for a previously existing search history CSV file on the disk.
     * If one is found, each line is fed to a parsing method.
     */
	private void checkForPreviousHistory(String currentPath) {
		if (new File(currentPath + "/searchhistory.csv").exists()) {
			Scanner inFile = null;
			try
			{
				inFile = new Scanner(new File("searchhistory.csv"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			while (inFile.hasNext()) {
				parseLine(inFile.nextLine());
			}
			
			inFile.close();
			System.out.println("Previous search history loaded");
		}
		else {
			System.out.println("No previous search history data found");
		}
	}
	
	/**
     * This is a helper method that parses each line of the previous search history. The first found
     * cell contains the search term and the second contains a list of timestamps separated by ";"
     */
	private void parseLine(String line) {
		String[] lineCells = line.split(",");
		String[] timestamps = lineCells[1].split(";");
		
		
		SearchQuery temp = new SearchQuery(timestamps[0]);
		for (int i = 1; i < timestamps.length; i++) {
			temp.timestamps.add(timestamps[i]);
			totalQueries++;
		}
		queries.put(lineCells[0], temp);
		totalQueries++;
	}
}
