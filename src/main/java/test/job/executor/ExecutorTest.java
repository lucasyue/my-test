package test.job.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		Thread t3=new MyThread();
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.shutdown();
	}
}
class MyThread extends Thread {
    @Override
    public void run() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(new Date())+""+Thread.currentThread().getName() + "正在执行。。。");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}