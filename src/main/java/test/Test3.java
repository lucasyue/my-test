package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test3 {
	public static void main(String[] args) {
		final Callable callable1=new Callable(){
			@Override
			public Object call() throws Exception {
				System.out.println(222);
				if(true){
					throw new RuntimeException("xxxxx");
				}
				return null;
			}};
		FutureTask task1=new FutureTask(callable1);
		Runnable run1=new Runnable(){
			@Override
			public void run() {
				System.out.println(222);
				if(true){
					throw new RuntimeException("xxxxx");
				}				
			}};
		Thread t1=new Thread(task1){
			@Override
			public void run() {
				super.run();
//				try {
//					callable1.call();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
			
		};
		t1.start();
		ExecutorService executor=Executors.newCachedThreadPool();
		Future future=executor.submit(callable1);
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally{
			executor.shutdown();
		}
	}
}
