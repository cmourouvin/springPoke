package com.stepinfo;

import com.classtest.SingletonTest;

import junit.framework.TestCase;

public class SingletonTestTest extends TestCase {

	SingletonTest s = null; 

	public SingletonTestTest() {
		s = s.getInstance();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testNbInstance ()
	{
		System.out.println("Test du nombre d'instance : " + s.nbInstance() );
		assertFalse (s.nbInstance()<1);
	}

}
