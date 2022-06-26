package com.zensar.test_app;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public Demo() {
		System.out.println("In Constructor");
	}

	public void calculateData() {
		String s = "";
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);

		Object obj = null;
		System.out.println(obj.toString());
	}

}
