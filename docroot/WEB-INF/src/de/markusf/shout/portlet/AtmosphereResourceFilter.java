package de.markusf.shout.portlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.ResourceFilter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.cpr.AtmosphereServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.util.PortalUtil;

import de.markusf.shout.atmosphere.AtmosphereAccess;
import de.markusf.shout.atmosphere.Constants;
import de.markusf.shout.atmosphere.PortletAccess;
import de.markusf.shout.atmosphere.SpringPortletAtmosphereHandler;
import de.markusf.shout.util.PortletServletContext;

public class AtmosphereResourceFilter implements ResourceFilter {

	private static final Logger logger = LoggerFactory.getLogger(AtmosphereResourceFilter.class);

	private final AtmosphereServlet as;
	private final AtmosphereFramework framework;
	
	public AtmosphereResourceFilter() {
		logger.info("Creating AtmosphereServlet");
		
		as = new AtmosphereServlet(true);
		
		framework = as.framework();
		
		AtmosphereAccess.setFramework(framework);
	}
	
	@Override
	public void destroy() {
		as.destroy();
	}

	@Override
	public void init(FilterConfig config) throws PortletException {
		final PortletContext portletContext = config.getPortletContext();
		
		try {
			as.init(new ServletConfig() {
				
				@Override
				public String getServletName() {
					return portletContext.getPortletContextName();
				}
				
				@Override
				public ServletContext getServletContext() {
					return new PortletServletContext(portletContext);
				}
				
				@Override
				public Enumeration<String> getInitParameterNames() {
					return portletContext.getInitParameterNames();
				}
				
				@Override
				public String getInitParameter(String name) {
					return portletContext.getInitParameter(name);
				}
				
			});
		} catch (ServletException e) {
			throw new PortletException(e);
		}
		
		GenericPortlet portlet = PortletAccess.getPortlet();
		
		if (portlet == null) {
			throw new PortletException("Portlet is null");
		}
		
		framework.addAtmosphereHandler("*", new SpringPortletAtmosphereHandler(portlet));
	}

	@Override
	public void doFilter(ResourceRequest request, ResourceResponse response,
			FilterChain chain) throws IOException, PortletException {
		// Retrieve underlying HttpServletRequest and HttpServletResponse
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
		HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(response);
		
		// Wrap
        AtmosphereRequest req = AtmosphereRequest.wrap(httpServletRequest);
        AtmosphereResponse res = AtmosphereResponse.wrap(httpServletResponse);
        
        req.setAttribute(Constants.ORIGINAL_RESOURCE_REQUEST, request);
        req.setAttribute(Constants.ORIGINAL_RESOURCE_RESPONSE, response);
        
        Action a = null;
        
		try {
			// Comet support for all resource requests
			a = framework.doCometSupport(req, res);
		} catch (ServletException e) {
			throw new PortletException(e);
		}
	}

}
