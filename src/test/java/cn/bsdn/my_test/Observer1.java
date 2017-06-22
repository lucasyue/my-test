package cn.bsdn.my_test;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Observer1 extends Observable implements Observer {
	private String name;
	public Observer1(String string) {
		this.name = string;
	}
	public static void main(String[] args) {
		Observer1 s1 = new Observer1("1");
		Observer1 s2 = new Observer1("2");
		Observer1 s3 = new Observer1("3");
		s1.setFlag(false);
		s2.setFlag(false);
		s3.setFlag(true);
		s1.addObser(s2);
		s2.addObser(s3);
		s1.update(null, new HashMap<String,Object>());
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable arg0, Object arg1) {
		if(this.isSupport()){
			System.out.println(this.name + "我生效");
		} else {
			super.setChanged();
			if(arg1 == null){
				arg1 = new HashMap<String,Object>();
			}
			System.out.println(this.name + "通知他人");
			super.notifyObservers(((HashMap<String,Object>)arg1).put("name", this.name));
		}
	}
	
	public void addObser(Observer o){
		super.deleteObservers();
		super.addObserver(o);
	}
	
	public boolean isSupport(){
		if(this.flag){
			return true;
		}
		return false;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private boolean flag;
	
}
