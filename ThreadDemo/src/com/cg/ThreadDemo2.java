package com.cg;

public class ThreadDemo2 {

	public static void main(String[] args) {
		Repeater r1  = new Repeater("Mahendra");
		Repeater r2 = new Repeater("Rahul");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);


		t1.start();
		t2.start();
	}

}
