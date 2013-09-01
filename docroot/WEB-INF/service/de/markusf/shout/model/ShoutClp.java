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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.markusf.shout.service.ShoutLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Markus Feindler
 */
public class ShoutClp extends BaseModelImpl<Shout> implements Shout {
	public ShoutClp() {
	}

	public Class<?> getModelClass() {
		return Shout.class;
	}

	public String getModelClassName() {
		return Shout.class.getName();
	}

	public long getPrimaryKey() {
		return _shoutId;
	}

	public void setPrimaryKey(long primaryKey) {
		setShoutId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_shoutId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shoutId", getShoutId());
		attributes.put("senderId", getSenderId());
		attributes.put("scopeId", getScopeId());
		attributes.put("publishDate", getPublishDate());
		attributes.put("message", getMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long shoutId = (Long)attributes.get("shoutId");

		if (shoutId != null) {
			setShoutId(shoutId);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}

		Long scopeId = (Long)attributes.get("scopeId");

		if (scopeId != null) {
			setScopeId(scopeId);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}
	}

	public long getShoutId() {
		return _shoutId;
	}

	public void setShoutId(long shoutId) {
		_shoutId = shoutId;
	}

	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	public long getScopeId() {
		return _scopeId;
	}

	public void setScopeId(long scopeId) {
		_scopeId = scopeId;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public void setAvatarURL(java.lang.String avatarURL) {
		throw new UnsupportedOperationException();
	}

	public void setDisplayName(java.lang.String displayName) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getAvatarURL() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getDisplayName() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getShoutRemoteModel() {
		return _shoutRemoteModel;
	}

	public void setShoutRemoteModel(BaseModel<?> shoutRemoteModel) {
		_shoutRemoteModel = shoutRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoutLocalServiceUtil.addShout(this);
		}
		else {
			ShoutLocalServiceUtil.updateShout(this);
		}
	}

	@Override
	public Shout toEscapedModel() {
		return (Shout)Proxy.newProxyInstance(Shout.class.getClassLoader(),
			new Class[] { Shout.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ShoutClp clone = new ShoutClp();

		clone.setShoutId(getShoutId());
		clone.setSenderId(getSenderId());
		clone.setScopeId(getScopeId());
		clone.setPublishDate(getPublishDate());
		clone.setMessage(getMessage());

		return clone;
	}

	public int compareTo(Shout shout) {
		long primaryKey = shout.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoutClp shout = null;

		try {
			shout = (ShoutClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = shout.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{shoutId=");
		sb.append(getShoutId());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append(", scopeId=");
		sb.append(getScopeId());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.markusf.shout.model.Shout");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>shoutId</column-name><column-value><![CDATA[");
		sb.append(getShoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderId</column-name><column-value><![CDATA[");
		sb.append(getSenderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scopeId</column-name><column-value><![CDATA[");
		sb.append(getScopeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _shoutId;
	private long _senderId;
	private long _scopeId;
	private Date _publishDate;
	private String _message;
	private BaseModel<?> _shoutRemoteModel;
}