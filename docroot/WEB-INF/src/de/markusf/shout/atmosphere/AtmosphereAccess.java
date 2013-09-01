package de.markusf.shout.atmosphere;

import org.atmosphere.cpr.AtmosphereFramework;

/**
 * Not Threadsafe!
 * @author Pred
 *
 */
public class AtmosphereAccess {
	
	private static AtmosphereFramework framework;
	
	public static AtmosphereFramework getFramework() {
		if (framework == null) {
			throw new IllegalStateException("Atmosphere Framework is null");
		}
		
		return framework;
	}
	
	public static void setFramework(AtmosphereFramework framework) {
		AtmosphereAccess.framework = framework;
	}
	
}
