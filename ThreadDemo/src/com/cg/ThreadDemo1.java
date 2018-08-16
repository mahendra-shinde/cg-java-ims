package com.cg;

public class ThreadDemo1 {

	public static void main(String[] args) {
		ClockThread t1 = new ClockThread();
		ClockThread t2 = new ClockThread();
		t1.start();
		t2.start();
		
	}

}
