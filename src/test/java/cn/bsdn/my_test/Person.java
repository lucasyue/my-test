package cn.bsdn.my_test;

import java.util.Observable;

public class Person extends Observable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void changeData(String data){
		System.out.println("I'm changing "+data);
		this.setChanged();
		this.notifyObservers(data);
	}
	
	
}
