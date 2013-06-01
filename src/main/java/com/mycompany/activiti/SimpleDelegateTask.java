package com.mycompany.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SimpleDelegateTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("Got message from service task delegate: " + arg0.getProcessInstanceId());
	}
}
