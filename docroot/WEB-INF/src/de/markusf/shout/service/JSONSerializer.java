package de.markusf.shout.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.atmosphere.cpr.Serializer;
import org.springframework.stereotype.Component;

import de.markusf.shout.model.Shout;

@Component("jsonSerializer")
public class JSONSerializer implements Serializer {
	
	/**
	 * not used, since PropertyFilte is somehow not called (investigate, or keep manual solution)
	 */
	private JsonConfig config;
	
	@PostConstruct
	public void init() {
		// could be configured via Spring
		List<String> allowedProperties = new ArrayList<String>();
		allowedProperties.add("shoutId");
		allowedProperties.add("scopeId");
		allowedProperties.add("senderId");
		allowedProperties.add("publishDate");
		allowedProperties.add("message");
		allowedProperties.add("avatarURL");
		allowedProperties.add("displayName");

		
		JsonConfig config = new JsonConfig();
		config.setJavaPropertyFilter(new InversePropertyFilter(allowedProperties));
		
		this.config = config;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void write(OutputStream os, Object object) throws IOException {
		String response = "EMPTY";
		
		if (Shout.class.isAssignableFrom(object.getClass())) {
			Shout shout = (Shout) object;
			
			JSONObject jsonShout = createJSONShout(shout);
			
			response = jsonShout.toString();
		} else if (List.class.isAssignableFrom(object.getClass())) {
			JSONArray jsonShouts = new JSONArray();
			
			List<Shout> shouts = (List<Shout>) object;
			
			for (Shout shout : shouts) {
				jsonShouts.add(createJSONShout(shout));
			}
			
			response = jsonShouts.toString();
		}
		
		os.write(response.getBytes("UTF-8"));
	}
	
	private JSONObject createJSONShout(Shout shout) {
		JSONObject jsonShout = new JSONObject();
		
		jsonShout.put("id", shout.getShoutId());
		jsonShout.put("scopeId", shout.getScopeId());
		jsonShout.put("senderId", shout.getSenderId());
		jsonShout.put("message", shout.getMessage());
		jsonShout.put("time", shout.getPublishDate().getTime());
		jsonShout.put("avatarURL", shout.getAvatarURL());
		jsonShout.put("displayName", shout.getDisplayName());
		
		return jsonShout;
	}
	
	private static class InversePropertyFilter implements PropertyFilter {
		
		private List<String> allowedProperties;
		
		public InversePropertyFilter(List<String> allowedProperties) {
			this.allowedProperties = allowedProperties;
		}
		
		@Override
		public boolean apply(Object source, String name, Object value) {
			if (allowedProperties.contains(name)) {
				// allow (do not exclude)
				return false;
			}
			
			// exclude
			return true;
		}
		
	}

}
