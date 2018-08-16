package com.cg;

import java.util.Date;

public class ClockThread extends Thread {
	
	//Define a TASK to be executed inside a Thread
	public void run() {
		for(int i=0;i<10000;i++) {
			Date d = new Date();
			
			System.out.println("Current Thread : "
					+Thread.currentThread().getName()+d);
		}
	}
}
