/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.markusf.shout.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Shout service. Represents a row in the &quot;Shout_Shout&quot; database table, with each column mapped to a property of this class.
 *
 * @author Markus Feindler
 * @see ShoutModel
 * @see de.markusf.shout.model.impl.ShoutImpl
 * @see de.markusf.shout.model.impl.ShoutModelImpl
 * @generated
 */
public interface Shout extends ShoutModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.markusf.shout.model.impl.ShoutImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getDisplayName();

	public void setDisplayName(java.lang.String displayName);

	public java.lang.String getAvatarURL();

	public void setAvatarURL(java.lang.String avatarURL);
}