package merge_and_search;

import java.io.IOException;
import java.io.File;

public class MergeAndSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentPath = "None found";
		try {
			currentPath = new java.io.File(".").getCanonicalPath();
			File folder = new File(currentPath + "/data");
			for (File fileEntry : folder.listFiles()) {
				System.out.println(fileEntry);
			}
		} catch (IOException e) {
			
		}
	}

}
