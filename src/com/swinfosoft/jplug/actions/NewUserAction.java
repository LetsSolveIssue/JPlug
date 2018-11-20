package com.swinfosoft.jplug.actions;

import com.swinfosoft.mvc.web.Action;

public class NewUserAction implements Action {

	@Override
	public String processRequest() throws Exception {
		return "registrationForm";
	}

}
