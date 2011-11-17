package com.classtest;

import org.springframework.stereotype.Component;

@Component("mySingleton")
public class SingletonTest {

	private static SingletonTest singleton;
	private static Object token = SingletonTest.class;
	private static long countInstance;

	public static SingletonTest getInstance() {
		synchronized (token) {
			if (singleton == null)
				singleton = new SingletonTest();

			countInstance++;
			return singleton;
		}

	}

	public long nbInstance() {
		return countInstance;
	}

	public void initIt() throws Exception {
		System.out.println("-- Init de " + this.getClass()
				+ ", val de count instance : " + countInstance);
	}

	public void cleanUp() throws Exception {
		System.out.println("-- Destruction de " + this.getClass()
				+ ", val de count instance : " + countInstance);
	}

}
