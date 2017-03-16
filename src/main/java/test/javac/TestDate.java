package test.javac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	private boolean isValid(String time){
		boolean flag = false;
		Calendar now = Calendar.getInstance();
		long nowMill = now.getTimeInMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHH:mm:ss");
		System.out.println("now:"+sdf1.format(now.getTime()));
		System.out.println("now:"+sdf.format(now.getTime()));
		Date timeDate = null;
		try {
			timeDate = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timeMill = timeDate.getTime();
		System.out.println("timeDate:"+sdf.format(timeDate.getTime()));
		now.setTime(timeDate);
		now.add(Calendar.MINUTE, 10);
		System.out.println("timeAdd10:"+sdf.format(now.getTime()));
	    long timeAdd10 = now.getTimeInMillis();
	    if(timeMill < nowMill && nowMill < timeAdd10){
	    	flag = true;
	    }
		return flag;
	}
	public static void main(String[] args) {
		String time = null;
		if(args.length == 1){
			time= args[0];
		}
		time="20170315152901";
		boolean valid=new TestDate().isValid(time);
		System.out.println(valid);
	}
}