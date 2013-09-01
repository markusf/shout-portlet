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

package de.markusf.shout.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.markusf.shout.model.Shout;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Shout in entity cache.
 *
 * @author Markus Feindler
 * @see Shout
 * @generated
 */
public class ShoutCacheModel implements CacheModel<Shout>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{shoutId=");
		sb.append(shoutId);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", scopeId=");
		sb.append(scopeId);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", message=");
		sb.append(message);
		sb.append("}");

		return sb.toString();
	}

	public Shout toEntityModel() {
		ShoutImpl shoutImpl = new ShoutImpl();

		shoutImpl.setShoutId(shoutId);
		shoutImpl.setSenderId(senderId);
		shoutImpl.setScopeId(scopeId);

		if (publishDate == Long.MIN_VALUE) {
			shoutImpl.setPublishDate(null);
		}
		else {
			shoutImpl.setPublishDate(new Date(publishDate));
		}

		if (message == null) {
			shoutImpl.setMessage(StringPool.BLANK);
		}
		else {
			shoutImpl.setMessage(message);
		}

		shoutImpl.resetOriginalValues();

		return shoutImpl;
	}

	public long shoutId;
	public long senderId;
	public long scopeId;
	public long publishDate;
	public String message;
}