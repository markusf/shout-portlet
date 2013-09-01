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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Markus Feindler
 * @generated
 */
public class ShoutSoap implements Serializable {
	public static ShoutSoap toSoapModel(Shout model) {
		ShoutSoap soapModel = new ShoutSoap();

		soapModel.setShoutId(model.getShoutId());
		soapModel.setSenderId(model.getSenderId());
		soapModel.setScopeId(model.getScopeId());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setMessage(model.getMessage());

		return soapModel;
	}

	public static ShoutSoap[] toSoapModels(Shout[] models) {
		ShoutSoap[] soapModels = new ShoutSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShoutSoap[][] toSoapModels(Shout[][] models) {
		ShoutSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShoutSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShoutSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShoutSoap[] toSoapModels(List<Shout> models) {
		List<ShoutSoap> soapModels = new ArrayList<ShoutSoap>(models.size());

		for (Shout model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShoutSoap[soapModels.size()]);
	}

	public ShoutSoap() {
	}

	public long getPrimaryKey() {
		return _shoutId;
	}

	public void setPrimaryKey(long pk) {
		setShoutId(pk);
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

	private long _shoutId;
	private long _senderId;
	private long _scopeId;
	private Date _publishDate;
	private String _message;
}