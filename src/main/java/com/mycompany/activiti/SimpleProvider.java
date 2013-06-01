package com.mycompany.activiti;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.activiti.engine.ProcessEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class SimpleProvider {

	private static Logger log = LoggerFactory.getLogger(SimpleProvider.class);

	@Inject
	private ActivitiService activitiService;
	
	@Inject
	private ProcessEngine processEngine;

	@PostConstruct
	public void init() {
		activitiService.deploy();
		log.info("Process engine '" + processEngine.getName() + "' is up and running!");
	}
}
