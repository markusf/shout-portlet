package de.markusf.shout.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.atmosphere.cpr.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import de.markusf.shout.model.Shout;
import de.markusf.shout.service.BroadcasterService;
import de.markusf.shout.service.ShoutLocalServiceUtil;

/**
 * TODO:
 * Delete own shouts
 * i18n
 * scroll to bottom on loadmore
 * clean debug in js/java
 * @author Pred
 *
 */
@Controller
@RequestMapping("VIEW")
public class ShoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoutController.class);
			
	private static final long DEFAULT_SCOPE_ID = 1;
	
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private BroadcasterService broadcasterService;
	
	@Autowired
	@Qualifier("jsonSerializer")
	private Serializer serializer;
	
	@RenderMapping
	public String defaultRequest() {
		return "view";
	}
	
	@RequestMapping(params = "action=getshouts")
	public void getShouts(ResourceRequest request, ResourceResponse response,
			@RequestParam(defaultValue = "-1") long time) throws SystemException, PortalException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long scopeId = themeDisplay.getScopeGroupId();
		
		Date before = null;
		
		if (time == -1) {
			// now
			before = new Date();
		} else {
			before = new Date(time);
		}
		
		List<Shout> shouts = ShoutLocalServiceUtil.getShouts(scopeId, before, PAGE_SIZE);
		ShoutLocalServiceUtil.addTransientProperties(themeDisplay, shouts);
		
		logger.debug("ShoutCount: " + shouts.size());
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		serializer.write(response.getPortletOutputStream(), shouts);
	}
	
	@RequestMapping(params = "action=subscribe")
	public void subscribe(ResourceRequest request, ResourceResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		logger.debug("Subscribe");
		broadcasterService.subscribe(themeDisplay.getScopeGroupId());
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "action=shout")
	public void shout(ResourceRequest request, @RequestParam String message) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Persist
		long scopeId = themeDisplay.getScopeGroupId();
		long senderId = themeDisplay.getUserId();
		
		Shout shout = ShoutLocalServiceUtil.createShout(scopeId, new Date(), senderId, message);
		ShoutLocalServiceUtil.addTransientProperties(themeDisplay, shout);
		
		// Broadcast
		broadcasterService.broadcast(scopeId, shout);
	}
	
}
