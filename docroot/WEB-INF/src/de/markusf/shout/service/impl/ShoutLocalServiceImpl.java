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

package de.markusf.shout.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import de.markusf.shout.model.Shout;
import de.markusf.shout.model.impl.ShoutImpl;
import de.markusf.shout.service.ShoutLocalServiceUtil;
import de.markusf.shout.service.base.ShoutLocalServiceBaseImpl;

/**
 * The implementation of the shout local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.markusf.shout.service.ShoutLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Markus Feindler
 * @see de.markusf.shout.service.base.ShoutLocalServiceBaseImpl
 * @see de.markusf.shout.service.ShoutLocalServiceUtil
 */
public class ShoutLocalServiceImpl extends ShoutLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.markusf.shout.service.ShoutLocalServiceUtil} to access the shout local
	 * service.
	 */

	@SuppressWarnings("unchecked")
	public List<Shout> getShouts(long scopeId, Date before, int count)
			throws SystemException {
		// TODO: Add caching (implement finder)
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Shout.class)
				.add(PropertyFactoryUtil.forName("scopeId").eq(scopeId))
				.add(PropertyFactoryUtil.forName("publishDate").lt(before))
				.addOrder(OrderFactoryUtil.desc("publishDate"));

		return dynamicQuery(query, 0, count);
	}

	public Shout createShout(long scopeId, Date publishDate, long senderId,
			String message) throws SystemException {
		Shout shout = new ShoutImpl();
		shout.setShoutId(CounterLocalServiceUtil.increment());
		shout.setMessage(message);
		shout.setPublishDate(new Date());
		shout.setScopeId(scopeId);
		shout.setSenderId(senderId);

		ShoutLocalServiceUtil.addShout(shout);

		return shout;
	}

	public void addTransientProperties(ThemeDisplay themeDisplay,
			List<Shout> shouts) throws PortalException, SystemException {
		for (Shout shout : shouts) {
			addTransientProperties(themeDisplay, shout);
		}
	}

	public void addTransientProperties(ThemeDisplay themeDisplay, Shout shout)
			throws PortalException, SystemException {
		long senderId = shout.getSenderId();

		User user = null;

		try {
			user = UserLocalServiceUtil.getUser(senderId);
		} catch (Exception e) {
			user = UserLocalServiceUtil.getDefaultUser(themeDisplay
					.getCompanyId());
		}
		
		shout.setAvatarURL(user.getPortraitURL(themeDisplay));
		shout.setDisplayName(user.getFullName());
	}

}