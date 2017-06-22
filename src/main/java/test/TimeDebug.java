package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDebug{
	private long begin;
	private long total;
	private long time;
	private long last;
	private String debug;
	private static TimeDebug instance;
	public static TimeDebug getInstance(String ...debug){
		if(debug!=null){
			if(debug.length == 1){
				TimeDebug.instance = new TimeDebug(debug[0]);
			}
		}
		if(TimeDebug.instance == null){
			TimeDebug.instance = new TimeDebug();
		}
		return instance;
	}
	private TimeDebug(){
		this.begin=new Date().getTime();
	}
	private TimeDebug(String debug){
		this.begin=new Date().getTime();
		this.debug=debug;
	}
	public void debug(){
		this.debug("default","debug");
	}
	public void debug(String msg){
		this.debug(msg, this.debug);
	}
	public void debugStep(int step){
		this.debug(" ["+step+"]......", this.debug);
	}
	public void debug(String msg,String debug){
		if("debug".equals(debug)){
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss SSS");
			StringBuffer str=new StringBuffer();
			str.append(sdf.format(new Date()));
			str.append(msg);
			str.append(" last ");
			str.append(last);
			str.append(",time ");
			this.time=new Date().getTime()-this.getBegin()-this.getTotal();
			str.append(time);
		    this.last=this.time;
		    this.total+=this.time;
		    str.append(",total ");
		    str.append(total);
		    System.out.println(str.toString());
		}
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getLast() {
		return last;
	}
	public void setLast(long last) {
		this.last = last;
	}
	public long getBegin() {
		return begin;
	}
	public void setBegin(long begin) {
		this.begin = begin;
	}
}