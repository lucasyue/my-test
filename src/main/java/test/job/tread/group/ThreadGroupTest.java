package test.job.tread.group;

public class ThreadGroupTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup tg1 = new ThreadGroup("myGroup1");
		MyThread t1=new MyThread(tg1,"t1");
		MyThread t2=new MyThread(tg1,"t2");
		MyThread t3=new MyThread(tg1,"t3");
		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(2000);
	    System.out.println("\n"+tg1.activeCount() + " threads in thread group.");
	    Thread[] thArray=new Thread[tg1.activeCount()];
	    tg1.enumerate(thArray);
	    for(Thread th:thArray)
	    	System.out.println(th.getName());
	    t1.myStop();
	    Thread.sleep(1000);
	    tg1.interrupt();
	}
	
}
class MyThread extends Thread{
	boolean stop;
	public MyThread(ThreadGroup group, String name) {
		super(group, name);
		this.stop=false;
	}

	@Override
	public void run() {
	System.out.println(Thread.currentThread().getName() + " starting.");
	try {
	      for (int i = 1; i < 1000; i++) {
	    	synchronized (this) {
				if(stop){
					break;
				}
			}
	        System.out.print(this.getName()+"."+i+" ");
	        Thread.sleep(250);
	      }
	    } catch (Exception exc) {
	      System.out.println(Thread.currentThread().getName() + " interrupted.");
	    }
	    System.out.println(Thread.currentThread().getName() + " exiting.");
	}
	synchronized void myStop(){
		this.stop=true;
	}
}