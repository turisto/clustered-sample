package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8007430834491140998L;

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
			}
		});
		// TODO Add your page's components here

    }

	private CustomSession getMySession() {
		// TODO Auto-generated method stub
		return (CustomSession)getSession();
	}
}
