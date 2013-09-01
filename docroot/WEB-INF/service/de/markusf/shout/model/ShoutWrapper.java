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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Shout}.
 * </p>
 *
 * @author    Markus Feindler
 * @see       Shout
 * @generated
 */
public class ShoutWrapper implements Shout, ModelWrapper<Shout> {
	public ShoutWrapper(Shout shout) {
		_shout = shout;
	}

	public Class<?> getModelClass() {
		return Shout.class;
	}

	public String getModelClassName() {
		return Shout.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shoutId", getShoutId());
		attributes.put("senderId", getSenderId());
		attributes.put("scopeId", getScopeId());
		attributes.put("publishDate", getPublishDate());
		attributes.put("message", getMessage());

		return attributes;
	}

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

	/**
	* Returns the primary key of this shout.
	*
	* @return the primary key of this shout
	*/
	public long getPrimaryKey() {
		return _shout.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shout.
	*
	* @param primaryKey the primary key of this shout
	*/
	public void setPrimaryKey(long primaryKey) {
		_shout.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the shout ID of this shout.
	*
	* @return the shout ID of this shout
	*/
	public long getShoutId() {
		return _shout.getShoutId();
	}

	/**
	* Sets the shout ID of this shout.
	*
	* @param shoutId the shout ID of this shout
	*/
	public void setShoutId(long shoutId) {
		_shout.setShoutId(shoutId);
	}

	/**
	* Returns the sender ID of this shout.
	*
	* @return the sender ID of this shout
	*/
	public long getSenderId() {
		return _shout.getSenderId();
	}

	/**
	* Sets the sender ID of this shout.
	*
	* @param senderId the sender ID of this shout
	*/
	public void setSenderId(long senderId) {
		_shout.setSenderId(senderId);
	}

	/**
	* Returns the scope ID of this shout.
	*
	* @return the scope ID of this shout
	*/
	public long getScopeId() {
		return _shout.getScopeId();
	}

	/**
	* Sets the scope ID of this shout.
	*
	* @param scopeId the scope ID of this shout
	*/
	public void setScopeId(long scopeId) {
		_shout.setScopeId(scopeId);
	}

	/**
	* Returns the publish date of this shout.
	*
	* @return the publish date of this shout
	*/
	public java.util.Date getPublishDate() {
		return _shout.getPublishDate();
	}

	/**
	* Sets the publish date of this shout.
	*
	* @param publishDate the publish date of this shout
	*/
	public void setPublishDate(java.util.Date publishDate) {
		_shout.setPublishDate(publishDate);
	}

	/**
	* Returns the message of this shout.
	*
	* @return the message of this shout
	*/
	public java.lang.String getMessage() {
		return _shout.getMessage();
	}

	/**
	* Sets the message of this shout.
	*
	* @param message the message of this shout
	*/
	public void setMessage(java.lang.String message) {
		_shout.setMessage(message);
	}

	public boolean isNew() {
		return _shout.isNew();
	}

	public void setNew(boolean n) {
		_shout.setNew(n);
	}

	public boolean isCachedModel() {
		return _shout.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shout.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shout.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shout.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shout.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shout.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shout.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoutWrapper((Shout)_shout.clone());
	}

	public int compareTo(de.markusf.shout.model.Shout shout) {
		return _shout.compareTo(shout);
	}

	@Override
	public int hashCode() {
		return _shout.hashCode();
	}

	public com.liferay.portal.model.CacheModel<de.markusf.shout.model.Shout> toCacheModel() {
		return _shout.toCacheModel();
	}

	public de.markusf.shout.model.Shout toEscapedModel() {
		return new ShoutWrapper(_shout.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shout.toString();
	}

	public java.lang.String toXmlString() {
		return _shout.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shout.persist();
	}

	public java.lang.String getDisplayName() {
		return _shout.getDisplayName();
	}

	public void setDisplayName(java.lang.String displayName) {
		_shout.setDisplayName(displayName);
	}

	public java.lang.String getAvatarURL() {
		return _shout.getAvatarURL();
	}

	public void setAvatarURL(java.lang.String avatarURL) {
		_shout.setAvatarURL(avatarURL);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Shout getWrappedShout() {
		return _shout;
	}

	public Shout getWrappedModel() {
		return _shout;
	}

	public void resetOriginalValues() {
		_shout.resetOriginalValues();
	}

	private Shout _shout;
}