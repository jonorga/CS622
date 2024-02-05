package merge_and_search;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MergeFile {
	private File file1;
	private File file2;
	private ArrayList<String> newFileContent;
	
	public MergeFile(File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
		newFileContent = new ArrayList<String>();
		DoMerge();
	}
	
	private void DoMerge() {
		Scanner inFile = null;
		try
		{
			inFile = new Scanner(file1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		while (inFile.hasNext()) {
			newFileContent.add(inFile.nextLine());
		}
		
		inFile.close();
	}
	
	public ArrayList<String> getNewFileContent() {
		return newFileContent;
	}
}
