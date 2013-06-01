package com.mycompany.activiti;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

@Stateless
public class ActivitiService {

	@Inject
	private RepositoryService repositoryService;
	
	@Inject
	private RuntimeService runtimeService;
	
	public Deployment deploy() {
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("/activiti/test.bpmn").deploy();
		return deployment;
	}
	
	public void start(int count) {
		ProcessDefinition pd = getLatestDefinition();
		if (pd == null) {
			throw new IllegalStateException("Process was not deployed!");
		}
		for (int i = 0; i < count; i++) {
			ProcessInstance pi = runtimeService.startProcessInstanceById(pd.getId());
			System.out.println(String.format("Started process: %s, id: %s, count: %d, pi id: %s", pd.getName(), pd.getId(), i, pi.getProcessInstanceId()));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Active count: " + runtimeService.createProcessInstanceQuery().count());		
	}

	private ProcessDefinition getLatestDefinition() {
		List<ProcessDefinition> pds = repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionId().desc().list();
		if (!pds.isEmpty()) {
			return pds.get(0);
		}
		return null;
	}
}
