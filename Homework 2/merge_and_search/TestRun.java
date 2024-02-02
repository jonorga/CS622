package merge_and_search;

public class TestRun {

	public static void main(String[] args) {
		FindFiles findFiles = new FindFiles();
		System.out.println(findFiles.getFirstFile());
		
		
		MergeFile mf = new MergeFile(findFiles.getFirstFile(), findFiles.getFirstFile());
		
		
		System.out.println("Complete");
	}

}
