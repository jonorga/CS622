package genome;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadRunner {

	public static void main(String[] args) {
		threadPool();
		
		
//		GenomeBuilder gb = new GenomeBuilder();
//		FutureTask<String> future = new FutureTask<String>(gb);
//		ExecutorService threadPool = Executors.newCachedThreadPool();
//		threadPool.execute(future);
		
//		Thread thread = new Thread(future);
//		thread.start();
//		try
//		{
//			System.out.println(future.get());
//		} catch (ExecutionException | InterruptedException e) {
//			e.printStackTrace();
//		}
//		threadPool.shutdown();
	}

	public static void noThreads(int bound) {
		long startTime = System.nanoTime();
		
		for (int i = 0; i < bound; i++) {
			GenomeBuilder genomeBuilder = new GenomeBuilder();
			genomeBuilder.call();
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Generating " + bound + " genome sequences with no threads completed in "
				+ endTime + " nanoseconds. " + (endTime / 1000000) + " (milliseconds)");
	}
	
	public static void threadPool() {
		long startTime = System.nanoTime();
		

		GenomeBuilder[] genomeBuilder = new GenomeBuilder[5];
		for (int i = 0; i < 5; i++) {
			genomeBuilder[i] = new GenomeBuilder();
		}
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			FutureTask<String> future1 = new FutureTask<String>(genomeBuilder[0]);
			FutureTask<String> future2 = new FutureTask<String>(genomeBuilder[1]);
			FutureTask<String> future3 = new FutureTask<String>(genomeBuilder[2]);
			FutureTask<String> future4 = new FutureTask<String>(genomeBuilder[3]);
			FutureTask<String> future5 = new FutureTask<String>(genomeBuilder[4]);
			
			threadPool.execute(future1);
			threadPool.execute(future2);
			threadPool.execute(future3);
			threadPool.execute(future4);
			threadPool.execute(future5);
			
			try
			{
				future1.get();
				future2.get();
				future3.get();
				future4.get();
				future5.get();
			} catch (ExecutionException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		threadPool.shutdown();
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Generating 100 genome sequences with no threads completed in "
				+ endTime + " nanoseconds. " + (endTime / 1000000) + " (milliseconds)");
	}
}
