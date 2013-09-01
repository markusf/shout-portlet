package de.markusf.shout.atmosphere;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.FrameworkConfig;
import org.atmosphere.handler.AbstractReflectorAtmosphereHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SpringPortletAtmosphereHandler extends AbstractReflectorAtmosphereHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringPortletAtmosphereHandler.class);
	
	private final GenericPortlet atmospherePortlet;

	public SpringPortletAtmosphereHandler(GenericPortlet atmospherePortlet) {
		this.atmospherePortlet = atmospherePortlet;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRequest(AtmosphereResource r) throws IOException {
		logger.debug("onRequest");
		AtmosphereRequest request = r.getRequest();

		r.getRequest().setAttribute(FrameworkConfig.ATMOSPHERE_RESOURCE, r);
		r.getRequest().setAttribute(FrameworkConfig.ATMOSPHERE_HANDLER, this);

		ResourceRequest originalRequest = (ResourceRequest) request
				.getAttribute(Constants.ORIGINAL_RESOURCE_REQUEST);
		ResourceResponse originalResponse = (ResourceResponse) request
				.getAttribute(Constants.ORIGINAL_RESOURCE_RESPONSE);
		
		try {
//			PortletAccess.getPortlet().serveResource(originalRequest, originalResponse);
			atmospherePortlet.serveResource(originalRequest, originalResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
