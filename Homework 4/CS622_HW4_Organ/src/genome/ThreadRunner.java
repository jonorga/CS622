package genome;

import java.util.concurrent.FutureTask;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadRunner {

	public static void main(String[] args) {
		noThreads(1000);
//		threadPool(5, 20000);
//		threadNoPools(5, 20000);
//		threadNoLists(200);
	}
	
	public static void threadNoLists(int runCount) {
		long startTime = System.nanoTime();
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
			
		for (int i = 0; i < runCount; i++) {
			FutureTask<String> future1 = new FutureTask<String>(new GenomeBuilder());
			FutureTask<String> future2 = new FutureTask<String>(new GenomeBuilder());
			FutureTask<String> future3 = new FutureTask<String>(new GenomeBuilder());
			FutureTask<String> future4 = new FutureTask<String>(new GenomeBuilder());
			FutureTask<String> future5 = new FutureTask<String>(new GenomeBuilder());
			
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
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Generating " + (runCount * 5) + " genome sequences with thread pool (no lists) completed in "
				+ endTime + " nanoseconds. " + (endTime / 1000000) + " (milliseconds)");
	}
	
	public static void threadNoPools(int threadCount, int runCount) {
		long startTime = System.nanoTime();
		
		ArrayList<FutureTask<String>> futures = new ArrayList<FutureTask<String>>();
		for (int i = 0; i < runCount; i++) {
			for (int j = 0; j < threadCount; j++) {
				futures.add(new FutureTask<String>(new GenomeBuilder()));
			}
			
			for (int j = 0; j < threadCount; j++) {
				Thread thread = new Thread(futures.get(j));
				thread.start();
			}
			
			try
			{
				for (int j = 0; j < threadCount; j++) {
					futures.get(j).get();
				}
			} catch (ExecutionException | InterruptedException e) {
				e.printStackTrace();
			}
			futures.clear();
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Generating " + (runCount * threadCount) + " genome sequences with threads (no pool) completed in "
				+ endTime + " nanoseconds. " + (endTime / 1000000) + " (milliseconds)");
	}

	public static void noThreads(int runCount) {
		long startTime = System.nanoTime();
		GenomeBuilder genomeBuilder;
		for (int i = 0; i < runCount; i++) {
			genomeBuilder = new GenomeBuilder();
			genomeBuilder.call();
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Generating " + runCount + " genome sequences with no threads completed in "
				+ endTime + " nanoseconds. " + (endTime / 1000000) + " (milliseconds)");
	}
	
	public static void threadPool(int threadCount, int runCount) {
		long startTime = System.nanoTime();
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		ArrayList<FutureTask<String>> futures = new ArrayList<FutureTask<String>>();
		for (int i = 0; i < runCount; i++) {
			for (int j = 0; j < threadCount; j++) {
				futures.add(new FutureTask<String>(new GenomeBuilder()));
			}
			
			for (int j = 0; j < threadCount; j++) {
				threadPool.execute(futures.get(j));
			}
			
			try
			{
				for (int j = 0; j < threadCount; j++) {
					futures.get(j).get();
				}
			} catch (ExecutionException | InterruptedException e) {
				e.printStackTrace();
			}
			futures.clear();
		}
		threadPool.shutdown();
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Generating " + (runCount * threadCount) + " genome sequences with thread pool completed in "
				+ endTime + " nanoseconds. " + (endTime / 1000000) + " (milliseconds)");
	}
}
