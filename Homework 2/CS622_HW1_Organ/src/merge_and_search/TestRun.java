package merge_and_search;

import java.util.ArrayList;

public class TestRun {
	public static void main(String[] args) {
		FindFiles findFiles = new FindFiles();
		System.out.println(findFiles.getFirstFile());
		
		
		MergeFile mf = new MergeFile(findFiles.getFirstFile(), findFiles.getFirstFile());
		ArrayList<String> fileContent = mf.getNewFileContent();
		
		
		WriteFile wf = new WriteFile(fileContent);
		wf.WriteFileToDisk();
		
		System.out.println("Complete");
	}
}
