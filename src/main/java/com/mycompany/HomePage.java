package com.mycompany;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mycompany.activiti.ActivitiService;
import com.mycompany.jms.JmsSender;


public class HomePage extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8007430834491140998L;

	@Inject
	private JmsSender jmsSender;
	
	@Inject 
	private ActivitiService activitiService;
	
	public HomePage(final PageParameters parameters) {
		super(parameters);
		setStatelessHint(true);
		System.out.println("Got username: " + getMySession().getUser());
		add(new Label("version", getMySession().getUser()));
		add(new BookmarkablePageLink<Void>("home", HomePage.class));
		add(new  Link<Void>("link") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				getMySession().invalidateNow();
				jmsSender.send();
				activitiService.start(4);
			}
		});
		// TODO Add your page's components here

    }

	private CustomSession getMySession() {
		// TODO Auto-generated method stub
		return (CustomSession)getSession();
	}
}
