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

import com.liferay.portal.service.persistence.BasePersistence;

import de.markusf.shout.model.Shout;

/**
 * The persistence interface for the shout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Markus Feindler
 * @see ShoutPersistenceImpl
 * @see ShoutUtil
 * @generated
 */
public interface ShoutPersistence extends BasePersistence<Shout> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoutUtil} to access the shout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the shout in the entity cache if it is enabled.
	*
	* @param shout the shout
	*/
	public void cacheResult(de.markusf.shout.model.Shout shout);

	/**
	* Caches the shouts in the entity cache if it is enabled.
	*
	* @param shouts the shouts
	*/
	public void cacheResult(java.util.List<de.markusf.shout.model.Shout> shouts);

	/**
	* Creates a new shout with the primary key. Does not add the shout to the database.
	*
	* @param shoutId the primary key for the new shout
	* @return the new shout
	*/
	public de.markusf.shout.model.Shout create(long shoutId);

	/**
	* Removes the shout with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shoutId the primary key of the shout
	* @return the shout that was removed
	* @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout remove(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException;

	public de.markusf.shout.model.Shout updateImpl(
		de.markusf.shout.model.Shout shout, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shout with the primary key or throws a {@link de.markusf.shout.NoSuchShoutException} if it could not be found.
	*
	* @param shoutId the primary key of the shout
	* @return the shout
	* @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout findByPrimaryKey(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException;

	/**
	* Returns the shout with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shoutId the primary key of the shout
	* @return the shout, or <code>null</code> if a shout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout fetchByPrimaryKey(long shoutId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shouts where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @return the matching shouts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.markusf.shout.model.Shout> findByScopeId(
		long scopeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.markusf.shout.model.Shout> findByScopeId(
		long scopeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.markusf.shout.model.Shout> findByScopeId(
		long scopeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shout
	* @throws de.markusf.shout.NoSuchShoutException if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout findByScopeId_First(long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException;

	/**
	* Returns the first shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shout, or <code>null</code> if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout fetchByScopeId_First(long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shout
	* @throws de.markusf.shout.NoSuchShoutException if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout findByScopeId_Last(long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException;

	/**
	* Returns the last shout in the ordered set where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shout, or <code>null</code> if a matching shout could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.markusf.shout.model.Shout fetchByScopeId_Last(long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.markusf.shout.model.Shout[] findByScopeId_PrevAndNext(
		long shoutId, long scopeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.markusf.shout.NoSuchShoutException;

	/**
	* Returns all the shouts.
	*
	* @return the shouts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.markusf.shout.model.Shout> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.markusf.shout.model.Shout> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.markusf.shout.model.Shout> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shouts where scopeId = &#63; from the database.
	*
	* @param scopeId the scope ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByScopeId(long scopeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shouts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shouts where scopeId = &#63;.
	*
	* @param scopeId the scope ID
	* @return the number of matching shouts
	* @throws SystemException if a system exception occurred
	*/
	public int countByScopeId(long scopeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shouts.
	*
	* @return the number of shouts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}