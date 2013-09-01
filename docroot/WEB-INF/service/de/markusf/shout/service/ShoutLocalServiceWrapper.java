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

package de.markusf.shout.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ShoutLocalService}.
 * </p>
 *
 * @author    Markus Feindler
 * @see       ShoutLocalService
 * @generated
 */
public class ShoutLocalServiceWrapper implements ShoutLocalService,
	ServiceWrapper<ShoutLocalService> {
	public ShoutLocalServiceWrapper(ShoutLocalService shoutLocalService) {
		_shoutLocalService = shoutLocalService;
	}

	/**
	* Adds the shout to the database. Also notifies the appropriate model listeners.
	*
	* @param shout the shout
	* @return the shout that was added
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout addShout(
		de.markusf.shout.model.Shout shout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.addShout(shout);
	}

	/**
	* Creates a new shout with the primary key. Does not add the shout to the database.
	*
	* @param shoutId the primary key for the new shout
	* @return the new shout
	*/
	public de.markusf.shout.model.Shout createShout(long shoutId) {
		return _shoutLocalService.createShout(shoutId);
	}

	/**
	* Deletes the shout with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shoutId the primary key of the shout
	* @return the shout that was removed
	* @throws PortalException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout deleteShout(long shoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.deleteShout(shoutId);
	}

	/**
	* Deletes the shout from the database. Also notifies the appropriate model listeners.
	*
	* @param shout the shout
	* @return the shout that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout deleteShout(
		de.markusf.shout.model.Shout shout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.deleteShout(shout);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _shoutLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.dynamicQueryCount(dynamicQuery);
	}

	public de.markusf.shout.model.Shout fetchShout(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.fetchShout(shoutId);
	}

	/**
	* Returns the shout with the primary key.
	*
	* @param shoutId the primary key of the shout
	* @return the shout
	* @throws PortalException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout getShout(long shoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.getShout(shoutId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the shouts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shouts
	* @param end the upper bound of the range of shouts (not inclusive)
	* @return the range of shouts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.markusf.shout.model.Shout> getShouts(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.getShouts(start, end);
	}

	/**
	* Returns the number of shouts.
	*
	* @return the number of shouts
	* @throws SystemException if a system exception occurred
	*/
	public int getShoutsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.getShoutsCount();
	}

	/**
	* Updates the shout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shout the shout
	* @return the shout that was updated
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout updateShout(
		de.markusf.shout.model.Shout shout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.updateShout(shout);
	}

	/**
	* Updates the shout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shout the shout
	* @param merge whether to merge the shout with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shout that was updated
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout updateShout(
		de.markusf.shout.model.Shout shout, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.updateShout(shout, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _shoutLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_shoutLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _shoutLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<de.markusf.shout.model.Shout> getShouts(
		long scopeId, java.util.Date before, int count)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.getShouts(scopeId, before, count);
	}

	public de.markusf.shout.model.Shout createShout(long scopeId,
		java.util.Date publishDate, long senderId, java.lang.String message)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoutLocalService.createShout(scopeId, publishDate, senderId,
			message);
	}

	public void addTransientProperties(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<de.markusf.shout.model.Shout> shouts)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoutLocalService.addTransientProperties(themeDisplay, shouts);
	}

	public void addTransientProperties(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		de.markusf.shout.model.Shout shout)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoutLocalService.addTransientProperties(themeDisplay, shout);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ShoutLocalService getWrappedShoutLocalService() {
		return _shoutLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedShoutLocalService(ShoutLocalService shoutLocalService) {
		_shoutLocalService = shoutLocalService;
	}

	public ShoutLocalService getWrappedService() {
		return _shoutLocalService;
	}

	public void setWrappedService(ShoutLocalService shoutLocalService) {
		_shoutLocalService = shoutLocalService;
	}

	private ShoutLocalService _shoutLocalService;
}