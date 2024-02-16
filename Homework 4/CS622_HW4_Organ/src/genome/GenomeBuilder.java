package genome;

import java.util.concurrent.Callable;
import java.util.Random;

public class GenomeBuilder implements Callable<String> {
	public String call() {
		Random rand = new Random();
		int selection;
		StringBuilder genomeSequence = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			selection = rand.nextInt(4);
			switch (selection)
			{
				case 0:
					genomeSequence.append('A');
					break;
				case 1:
					genomeSequence.append('T');
					break;
				case 2:
					genomeSequence.append('G');
					break;
				case 3:
					genomeSequence.append('C');
					break;
			}
		}
		
		return genomeSequence.toString();
	}
}
