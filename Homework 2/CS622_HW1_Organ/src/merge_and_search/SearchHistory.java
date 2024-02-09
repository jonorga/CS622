package merge_and_search;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class SearchHistory {
	private HashMap<String, SearchQuery> queries = new HashMap<String, SearchQuery>();
	private int totalQueries = 0;
	private final String pattern = "MM/dd/yyyy HH:mm:ss";
	
	public SearchHistory(String currentPath) {
		checkForPreviousHistory(currentPath);
	}
	
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
		}
		else {
			System.out.println("No previous search history data found");
		}
	}
	
	private void parseLine(String line) {
		String[] lineCells = line.split(",");
		String[] timestamps = lineCells[1].split(";");
		
		String searchTerm = lineCells[0];
		for (String a : timestamps) {
			DateFormat df = DateFormat.getDateInstance();
			try
			{
				Date temp = df.parse(a);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class SearchQuery {
		ArrayList<Date> timestamps = new ArrayList<Date>();
		
		public SearchQuery(Date currentTime) {
			timestamps.add(currentTime);
		}
	}
	
	public void addSearchQuery(String searchTerm) {
		if (queries.containsKey(searchTerm)) {
			queries.get(searchTerm).timestamps.add(new Date());
		}
		else {
			queries.put(searchTerm, new SearchQuery(new Date()));
		}
		writeHistoryToDisk();
		totalQueries++;
	}
	
	public void printSearchHistory() {
		System.out.println("Search history:");
		
		System.out.println("Total number of queries: " + totalQueries);
		System.out.println("Total unique queries: " + queries.size());
		System.out.println("===========================================");
		System.out.println("Queries:");
		
		for (Map.Entry<String, SearchQuery> value : queries.entrySet()) {
			System.out.println("Search term: " + value.getKey() + ", frequency: " + value.getValue().timestamps.size()
					+ ", timestamps:");
			for (Date date : value.getValue().timestamps) {
				System.out.println(date.toString());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void writeHistoryToDisk() {
		BufferedWriter br = null;
		try
		{
			br = new BufferedWriter(new FileWriter("searchhistory.csv"));
			
			
			for (Map.Entry<String, SearchQuery> value : queries.entrySet()) {
				StringBuilder newLine = new StringBuilder();
				newLine.append(value.getKey() + ",");
				for (Date date : value.getValue().timestamps) {
					newLine.append(date + ";");
				}
				br.write(newLine.toString() + "\n");
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
