package merge_and_search;

import java.io.File;
import com.opencsv.*;

public class MergeFile {
	private File file1;
	private File file2;
	
	public MergeFile(File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
		DoMerge();
	}
	
	private void DoMerge() {
		CSVReader c;
	}
}
