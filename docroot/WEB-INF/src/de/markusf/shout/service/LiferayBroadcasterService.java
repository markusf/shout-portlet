package de.markusf.shout.service;

import javax.annotation.PostConstruct;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.atmosphere.cache.UUIDBroadcasterCache;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListener;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.cpr.Meteor;
import org.atmosphere.cpr.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.portlet.context.PortletRequestAttributes;

import com.liferay.portal.util.PortalUtil;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class LiferayBroadcasterService implements BroadcasterService {
	
	private static final Logger logger = LoggerFactory.getLogger(LiferayBroadcasterService.class);
			
	private HttpServletRequest request;
	
	@Autowired
	@Qualifier("jsonSerializer")
	private Serializer serializer;
	
	@PostConstruct
	public void init() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		
		PortletRequest portletRequest = ((PortletRequestAttributes) requestAttributes).getRequest();
		
		request = PortalUtil.getHttpServletRequest(portletRequest);
	}
	
	public LiferayBroadcasterService() {

	}
	
	@Override
	public void subscribe(Object id) {
		Meteor m = Meteor.build(request);
		
		m.addListener(new AtmosphereResourceEventListener() {
			
			@Override
			public void onThrowable(AtmosphereResourceEvent event) {
				logger.debug("error: " + event.getResource().uuid());
			}
			
			@Override
			public void onSuspend(AtmosphereResourceEvent event) {
				logger.debug("suspend: " + event.getResource().uuid());
			}
			
			@Override
			public void onResume(AtmosphereResourceEvent event) {
				logger.debug("resume: " + event.getResource().uuid());
			}
			
			@Override
			public void onDisconnect(AtmosphereResourceEvent event) {
				logger.debug("disconnect: " + event.getResource().uuid());
			}
			
			@Override
			public void onBroadcast(AtmosphereResourceEvent event) {
				logger.debug("broadcast: " + event.getResource().uuid());
			}
		});
		
		m.setBroadcaster(lookupBroadcaster(id));
		// TODO: set serializer
		m.getAtmosphereResource().setSerializer(serializer);
		m.resumeOnBroadcast(true).suspend(30 * 1000);
	}

	@Override
	public void broadcast(Object id, Object o) {
		lookupBroadcaster(id).broadcast(o);
	}
	
	private Broadcaster lookupBroadcaster(Object id) {
		Broadcaster b = BroadcasterFactory.getDefault().lookup(id, false);
		
		if (b == null) {
			// create broadcaster with default settings
			b = BroadcasterFactory.getDefault().lookup(id, true);
			b.getBroadcasterConfig().setBroadcasterCache(new UUIDBroadcasterCache());
		}
		
		return b;
	}

}
