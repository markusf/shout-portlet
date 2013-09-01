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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.markusf.shout.NoSuchShoutException;
import de.markusf.shout.model.Shout;
import de.markusf.shout.model.impl.ShoutImpl;
import de.markusf.shout.model.impl.ShoutModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Markus Feindler
 * @see ShoutPersistence
 * @see ShoutUtil
 * @generated
 */
public class ShoutPersistenceImpl extends BasePersistenceImpl<Shout>
	implements ShoutPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoutUtil} to access the shout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoutImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCOPEID = new FinderPath(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutModelImpl.FINDER_CACHE_ENABLED, ShoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByScopeId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPEID =
		new FinderPath(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutModelImpl.FINDER_CACHE_ENABLED, ShoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByScopeId",
			new String[] { Long.class.getName() },
			ShoutModelImpl.SCOPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCOPEID = new FinderPath(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScopeId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutModelImpl.FINDER_CACHE_ENABLED, ShoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutModelImpl.FINDER_CACHE_ENABLED, ShoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the shout in the entity cache if it is enabled.
	 *
	 * @param shout the shout
	 */
	public void cacheResult(Shout shout) {
		EntityCacheUtil.putResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutImpl.class, shout.getPrimaryKey(), shout);

		shout.resetOriginalValues();
	}

	/**
	 * Caches the shouts in the entity cache if it is enabled.
	 *
	 * @param shouts the shouts
	 */
	public void cacheResult(List<Shout> shouts) {
		for (Shout shout : shouts) {
			if (EntityCacheUtil.getResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
						ShoutImpl.class, shout.getPrimaryKey()) == null) {
				cacheResult(shout);
			}
			else {
				shout.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all shouts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShoutImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShoutImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the shout.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Shout shout) {
		EntityCacheUtil.removeResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutImpl.class, shout.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Shout> shouts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Shout shout : shouts) {
			EntityCacheUtil.removeResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
				ShoutImpl.class, shout.getPrimaryKey());
		}
	}

	/**
	 * Creates a new shout with the primary key. Does not add the shout to the database.
	 *
	 * @param shoutId the primary key for the new shout
	 * @return the new shout
	 */
	public Shout create(long shoutId) {
		Shout shout = new ShoutImpl();

		shout.setNew(true);
		shout.setPrimaryKey(shoutId);

		return shout;
	}

	/**
	 * Removes the shout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoutId the primary key of the shout
	 * @return the shout that was removed
	 * @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Shout remove(long shoutId)
		throws NoSuchShoutException, SystemException {
		return remove(Long.valueOf(shoutId));
	}

	/**
	 * Removes the shout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shout
	 * @return the shout that was removed
	 * @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shout remove(Serializable primaryKey)
		throws NoSuchShoutException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Shout shout = (Shout)session.get(ShoutImpl.class, primaryKey);

			if (shout == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShoutException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shout);
		}
		catch (NoSuchShoutException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Shout removeImpl(Shout shout) throws SystemException {
		shout = toUnwrappedModel(shout);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shout);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(shout);

		return shout;
	}

	@Override
	public Shout updateImpl(de.markusf.shout.model.Shout shout, boolean merge)
		throws SystemException {
		shout = toUnwrappedModel(shout);

		boolean isNew = shout.isNew();

		ShoutModelImpl shoutModelImpl = (ShoutModelImpl)shout;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shout, merge);

			shout.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShoutModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shoutModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(shoutModelImpl.getOriginalScopeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCOPEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPEID,
					args);

				args = new Object[] { Long.valueOf(shoutModelImpl.getScopeId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCOPEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
			ShoutImpl.class, shout.getPrimaryKey(), shout);

		return shout;
	}

	protected Shout toUnwrappedModel(Shout shout) {
		if (shout instanceof ShoutImpl) {
			return shout;
		}

		ShoutImpl shoutImpl = new ShoutImpl();

		shoutImpl.setNew(shout.isNew());
		shoutImpl.setPrimaryKey(shout.getPrimaryKey());

		shoutImpl.setShoutId(shout.getShoutId());
		shoutImpl.setSenderId(shout.getSenderId());
		shoutImpl.setScopeId(shout.getScopeId());
		shoutImpl.setPublishDate(shout.getPublishDate());
		shoutImpl.setMessage(shout.getMessage());

		return shoutImpl;
	}

	/**
	 * Returns the shout with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shout
	 * @return the shout
	 * @throws com.liferay.portal.NoSuchModelException if a shout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shout findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shout with the primary key or throws a {@link de.markusf.shout.NoSuchShoutException} if it could not be found.
	 *
	 * @param shoutId the primary key of the shout
	 * @return the shout
	 * @throws de.markusf.shout.NoSuchShoutException if a shout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Shout findByPrimaryKey(long shoutId)
		throws NoSuchShoutException, SystemException {
		Shout shout = fetchByPrimaryKey(shoutId);

		if (shout == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + shoutId);
			}

			throw new NoSuchShoutException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				shoutId);
		}

		return shout;
	}

	/**
	 * Returns the shout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shout
	 * @return the shout, or <code>null</code> if a shout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shout fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shoutId the primary key of the shout
	 * @return the shout, or <code>null</code> if a shout with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Shout fetchByPrimaryKey(long shoutId) throws SystemException {
		Shout shout = (Shout)EntityCacheUtil.getResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
				ShoutImpl.class, shoutId);

		if (shout == _nullShout) {
			return null;
		}

		if (shout == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				shout = (Shout)session.get(ShoutImpl.class,
						Long.valueOf(shoutId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (shout != null) {
					cacheResult(shout);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ShoutModelImpl.ENTITY_CACHE_ENABLED,
						ShoutImpl.class, shoutId, _nullShout);
				}

				closeSession(session);
			}
		}

		return shout;
	}

	/**
	 * Returns all the shouts where scopeId = &#63;.
	 *
	 * @param scopeId the scope ID
	 * @return the matching shouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Shout> findByScopeId(long scopeId) throws SystemException {
		return findByScopeId(scopeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Shout> findByScopeId(long scopeId, int start, int end)
		throws SystemException {
		return findByScopeId(scopeId, start, end, null);
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
	public List<Shout> findByScopeId(long scopeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCOPEID;
			finderArgs = new Object[] { scopeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCOPEID;
			finderArgs = new Object[] { scopeId, start, end, orderByComparator };
		}

		List<Shout> list = (List<Shout>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Shout shout : list) {
				if ((scopeId != shout.getScopeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SHOUT_WHERE);

			query.append(_FINDER_COLUMN_SCOPEID_SCOPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scopeId);

				list = (List<Shout>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Shout findByScopeId_First(long scopeId,
		OrderByComparator orderByComparator)
		throws NoSuchShoutException, SystemException {
		Shout shout = fetchByScopeId_First(scopeId, orderByComparator);

		if (shout != null) {
			return shout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scopeId=");
		msg.append(scopeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoutException(msg.toString());
	}

	/**
	 * Returns the first shout in the ordered set where scopeId = &#63;.
	 *
	 * @param scopeId the scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shout, or <code>null</code> if a matching shout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Shout fetchByScopeId_First(long scopeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Shout> list = findByScopeId(scopeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Shout findByScopeId_Last(long scopeId,
		OrderByComparator orderByComparator)
		throws NoSuchShoutException, SystemException {
		Shout shout = fetchByScopeId_Last(scopeId, orderByComparator);

		if (shout != null) {
			return shout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scopeId=");
		msg.append(scopeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoutException(msg.toString());
	}

	/**
	 * Returns the last shout in the ordered set where scopeId = &#63;.
	 *
	 * @param scopeId the scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shout, or <code>null</code> if a matching shout could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Shout fetchByScopeId_Last(long scopeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByScopeId(scopeId);

		List<Shout> list = findByScopeId(scopeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Shout[] findByScopeId_PrevAndNext(long shoutId, long scopeId,
		OrderByComparator orderByComparator)
		throws NoSuchShoutException, SystemException {
		Shout shout = findByPrimaryKey(shoutId);

		Session session = null;

		try {
			session = openSession();

			Shout[] array = new ShoutImpl[3];

			array[0] = getByScopeId_PrevAndNext(session, shout, scopeId,
					orderByComparator, true);

			array[1] = shout;

			array[2] = getByScopeId_PrevAndNext(session, shout, scopeId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Shout getByScopeId_PrevAndNext(Session session, Shout shout,
		long scopeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOUT_WHERE);

		query.append(_FINDER_COLUMN_SCOPEID_SCOPEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scopeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shout);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Shout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the shouts.
	 *
	 * @return the shouts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Shout> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Shout> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Shout> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Shout> list = (List<Shout>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOUT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOUT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Shout>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Shout>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the shouts where scopeId = &#63; from the database.
	 *
	 * @param scopeId the scope ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByScopeId(long scopeId) throws SystemException {
		for (Shout shout : findByScopeId(scopeId)) {
			remove(shout);
		}
	}

	/**
	 * Removes all the shouts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Shout shout : findAll()) {
			remove(shout);
		}
	}

	/**
	 * Returns the number of shouts where scopeId = &#63;.
	 *
	 * @param scopeId the scope ID
	 * @return the number of matching shouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByScopeId(long scopeId) throws SystemException {
		Object[] finderArgs = new Object[] { scopeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SCOPEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOUT_WHERE);

			query.append(_FINDER_COLUMN_SCOPEID_SCOPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scopeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SCOPEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of shouts.
	 *
	 * @return the number of shouts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOUT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the shout persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.markusf.shout.model.Shout")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Shout>> listenersList = new ArrayList<ModelListener<Shout>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Shout>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ShoutImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ShoutPersistence.class)
	protected ShoutPersistence shoutPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SHOUT = "SELECT shout FROM Shout shout";
	private static final String _SQL_SELECT_SHOUT_WHERE = "SELECT shout FROM Shout shout WHERE ";
	private static final String _SQL_COUNT_SHOUT = "SELECT COUNT(shout) FROM Shout shout";
	private static final String _SQL_COUNT_SHOUT_WHERE = "SELECT COUNT(shout) FROM Shout shout WHERE ";
	private static final String _FINDER_COLUMN_SCOPEID_SCOPEID_2 = "shout.scopeId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shout.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Shout exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Shout exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShoutPersistenceImpl.class);
	private static Shout _nullShout = new ShoutImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Shout> toCacheModel() {
				return _nullShoutCacheModel;
			}
		};

	private static CacheModel<Shout> _nullShoutCacheModel = new CacheModel<Shout>() {
			public Shout toEntityModel() {
				return _nullShout;
			}
		};
}