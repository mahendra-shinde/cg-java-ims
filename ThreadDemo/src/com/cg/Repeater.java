package com.cg;

public class Repeater implements Runnable {
	private String name;
	
	public Repeater(String name) {
		this.name = name;	
	}
	
	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		for(int i=0;i<10000;i++) {
			System.out.println("Thread: "+tname+", Name: "+name);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
