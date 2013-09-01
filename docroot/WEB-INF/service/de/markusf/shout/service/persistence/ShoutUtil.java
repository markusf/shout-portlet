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

package de.markusf.shout.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.markusf.shout.model.Shout;

import java.util.List;

/**
 * The persistence utility for the shout service. This utility wraps {@link ShoutPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Markus Feindler
 * @see ShoutPersistence
 * @see ShoutPersistenceImpl
 * @generated
 */
public class ShoutUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Shout shout) {
		getPersistence().clearCache(shout);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Shout> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Shout> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Shout> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Shout update(Shout shout, boolean merge)
		throws SystemException {
		return getPersistence().update(shout, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Shout update(Shout shout, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(shout, merge, serviceContext);
	}

	/**
	* Caches the shout in the entity cache if it is enabled.
	*
	* @param shout the shout
	*/
	public static void cacheResult(de.markusf.shout.model.Shout shout) {
		getPersistence().cacheResult(shout);
	}

	/**
	* Caches the shouts in the entity cache if it is enabled.
	*
	* @param shouts the shouts
	*/
	public static void cacheResult(
		java.util.List<de.markusf.shout.model.Shout> shouts) {
		getPersistence().cacheResult(shouts);
	}

	/**
	* Creates a new shout with the primary key. Does not add the shout to the database.
	*
	* @param shoutId the primary key for the new shout
	* @return the new shout
	*/
	public static de.markusf.shout.model.Shout create(long shoutId) {
		return getPersistence().create(shoutId);
	}

	/**
	* Removes the shout with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shoutId the primary key of the shout
	* @return the shout that was removed
	* @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout remove(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException {
		return getPersistence().remove(shoutId);
	}

	public static de.markusf.shout.model.Shout updateImpl(
		de.markusf.shout.model.Shout shout, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shout, merge);
	}

	/**
	* Returns the shout with the primary key or throws a {@link de.markusf.shout.NoSuchShoutException} if it could not be found.
	*
	* @param shoutId the primary key of the shout
	* @return the shout
	* @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout findByPrimaryKey(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException {
		return getPersistence().findByPrimaryKey(shoutId);
	}

	/**
	* Returns the shout with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shoutId the primary key of the shout
	* @return the shout, or <code>null</code> if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout fetchByPrimaryKey(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(shoutId);
	}

	/**
	* Returns all the shouts where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @return the matching shouts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.markusf.shout.model.Shout> findByScopeId(
		long scopeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScopeId(scopeId);
	}

	/**
	* Returns a range of all the shouts where scopeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param scopeId the scope ID
	* @param start the lower bound of the range of shouts
	* @param end the upper bound of the range of shouts (not inclusive)
	* @return the range of matching shouts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.markusf.shout.model.Shout> findByScopeId(
		long scopeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScopeId(scopeId, start, end);
	}

	/**
	* Returns an ordered range of all the shouts where scopeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param scopeId the scope ID
	* @param start the lower bound of the range of shouts
	* @param end the upper bound of the range of shouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shouts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.markusf.shout.model.Shout> findByScopeId(
		long scopeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScopeId(scopeId, start, end, orderByComparator);
	}

	/**
	* Returns the first shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shout
	* @throws de.markusf.shout.NoSuchShoutException if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout findByScopeId_First(
		long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException {
		return getPersistence().findByScopeId_First(scopeId, orderByComparator);
	}

	/**
	* Returns the first shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shout, or <code>null</code> if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout fetchByScopeId_First(
		long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByScopeId_First(scopeId, orderByComparator);
	}

	/**
	* Returns the last shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shout
	* @throws de.markusf.shout.NoSuchShoutException if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout findByScopeId_Last(
		long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException {
		return getPersistence().findByScopeId_Last(scopeId, orderByComparator);
	}

	/**
	* Returns the last shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shout, or <code>null</code> if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout fetchByScopeId_Last(
		long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByScopeId_Last(scopeId, orderByComparator);
	}

	/**
	* Returns the shouts before and after the current shout in the ordered set where scopeId = &#63;.
	*
	* @param shoutId the primary key of the current shout
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shout
	* @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.markusf.shout.model.Shout[] findByScopeId_PrevAndNext(
		long shoutId, long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException {
		return getPersistence()
				   .findByScopeId_PrevAndNext(shoutId, scopeId,
			orderByComparator);
	}

	/**
	* Returns all the shouts.
	*
	* @return the shouts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.markusf.shout.model.Shout> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<de.markusf.shout.model.Shout> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the shouts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shouts
	* @param end the upper bound of the range of shouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shouts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.markusf.shout.model.Shout> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shouts where scopeId = &#63; from the database.
	*
	* @param scopeId the scope ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByScopeId(long scopeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByScopeId(scopeId);
	}

	/**
	* Removes all the shouts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of shouts where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @return the number of matching shouts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByScopeId(long scopeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByScopeId(scopeId);
	}

	/**
	* Returns the number of shouts.
	*
	* @return the number of shouts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoutPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoutPersistence)PortletBeanLocatorUtil.locate(de.markusf.shout.service.ClpSerializer.getServletContextName(),
					ShoutPersistence.class.getName());

			ReferenceRegistry.registerReference(ShoutUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ShoutPersistence persistence) {
	}

	private static ShoutPersistence _persistence;
}