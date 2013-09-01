package de.markusf.shout.atmosphere;

import javax.portlet.GenericPortlet;

public class PortletAccess {
	
	private static GenericPortlet portlet;
	
	public static void setPortlet(GenericPortlet portlet) {
		PortletAccess.portlet = portlet;
	}
	
	public static GenericPortlet getPortlet() {
		if (portlet == null) {
			throw new IllegalStateException("Portlet has not been set yet");
		}
		
		return portlet;
	}
	
	
}
