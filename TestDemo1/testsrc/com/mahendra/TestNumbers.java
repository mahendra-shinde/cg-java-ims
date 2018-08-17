package com.mahendra;

import org.junit.Test;

public class TestNumbers {

	@Test(expected=ArithmeticException.class)
	public void test1() {
		int n1 = 299/0;
	}
}
