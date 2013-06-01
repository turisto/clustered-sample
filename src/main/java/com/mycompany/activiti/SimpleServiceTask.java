package com.mycompany.activiti;

import javax.inject.Named;

@Named
public class SimpleServiceTask {
	public void printMessage() {
		System.out.println("Got message from service task 2");
	}
}
