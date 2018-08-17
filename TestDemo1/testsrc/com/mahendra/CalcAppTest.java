package com.mahendra;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class CalcAppTest {
	
	@Mock private CalculatorService service;

	@TestSubject //Target object which need Mock
	private CalcApp app = new CalcApp(); 
	
	@Test
	public void testDoAdd() {
		app.setCalculatorService(service);
		EasyMock.expect(service.add(10.0, 20.0)).andReturn(30.0);
		//EasyMock.expect(service.add(11.0, 25.0)).andReturn(36.0);
		EasyMock.replay(service);
		assertEquals(30.0, app.doAdd(10.0, 20.0),0.01);
	}

}
