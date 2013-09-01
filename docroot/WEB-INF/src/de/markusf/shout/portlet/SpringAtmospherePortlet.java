package de.markusf.shout.portlet;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import org.springframework.web.portlet.DispatcherPortlet;

import de.markusf.shout.atmosphere.PortletAccess;

public class SpringAtmospherePortlet extends DispatcherPortlet {
	
	@Override
	public void init(final PortletConfig config) throws PortletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		PortletAccess.setPortlet(this);
	}
	
}
