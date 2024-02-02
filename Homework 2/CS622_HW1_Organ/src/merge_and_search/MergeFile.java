package merge_and_search;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeFile {
	private File file1;
	private File file2;
	
	public MergeFile(File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
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
			System.out.println(inFile.nextLine());
		}
		
		inFile.close();
	}
}
