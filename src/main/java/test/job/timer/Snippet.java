package test.job.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Snippet {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1000);
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//			}
//		}).start();
		//schedule()方法更注重保持间隔时间的稳定：保障每隔period时间可调用一次
		//scheduleAtFixedRate()方法更注重保持执行频率的稳定：保障多次调用的频率趋近于period时间，如果任务执行时间大于period，会在任务执行之后马上执行下一次任务
		//System.gc();执行一次 立即结束 需要gc一下，否则会系统自动执行gc时才会结束
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("开始运行");
		//System.gc();执行一次 立即结束 需要gc一下，否则会系统自动执行gc时才会结束
	}
}