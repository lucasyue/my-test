package cn.bsdn.my_test;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {

	private String name;
	
	public Watcher(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		Person p = (Person)o;
		System.out.println(this.name+ " 观察到："+p.getName()+ arg);
	}
	
	public static void main(String[] args) {
		Watcher w = new Watcher("w1");
		Watcher w2 = new Watcher("w2");
		Person p = new Person();
		p.addObserver(w);
		p.addObserver(w2);
		p.setName("name!");
		p.changeData("person变化了");
	}
}
