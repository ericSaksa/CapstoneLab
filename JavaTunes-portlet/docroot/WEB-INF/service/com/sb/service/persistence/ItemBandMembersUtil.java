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

package com.sb.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sb.model.ItemBandMembers;

import java.util.List;

/**
 * The persistence utility for the item band members service. This utility wraps {@link ItemBandMembersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see ItemBandMembersPersistence
 * @see ItemBandMembersPersistenceImpl
 * @generated
 */
public class ItemBandMembersUtil {
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
	public static void clearCache(ItemBandMembers itemBandMembers) {
		getPersistence().clearCache(itemBandMembers);
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
	public static List<ItemBandMembers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemBandMembers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemBandMembers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ItemBandMembers update(ItemBandMembers itemBandMembers,
		boolean merge) throws SystemException {
		return getPersistence().update(itemBandMembers, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ItemBandMembers update(ItemBandMembers itemBandMembers,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemBandMembers, merge, serviceContext);
	}

	/**
	* Caches the item band members in the entity cache if it is enabled.
	*
	* @param itemBandMembers the item band members
	*/
	public static void cacheResult(com.sb.model.ItemBandMembers itemBandMembers) {
		getPersistence().cacheResult(itemBandMembers);
	}

	/**
	* Caches the item band memberses in the entity cache if it is enabled.
	*
	* @param itemBandMemberses the item band memberses
	*/
	public static void cacheResult(
		java.util.List<com.sb.model.ItemBandMembers> itemBandMemberses) {
		getPersistence().cacheResult(itemBandMemberses);
	}

	/**
	* Creates a new item band members with the primary key. Does not add the item band members to the database.
	*
	* @param ItemBandMemberId the primary key for the new item band members
	* @return the new item band members
	*/
	public static com.sb.model.ItemBandMembers create(int ItemBandMemberId) {
		return getPersistence().create(ItemBandMemberId);
	}

	/**
	* Removes the item band members with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members that was removed
	* @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.ItemBandMembers remove(int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemBandMembersException {
		return getPersistence().remove(ItemBandMemberId);
	}

	public static com.sb.model.ItemBandMembers updateImpl(
		com.sb.model.ItemBandMembers itemBandMembers, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemBandMembers, merge);
	}

	/**
	* Returns the item band members with the primary key or throws a {@link com.sb.NoSuchItemBandMembersException} if it could not be found.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members
	* @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.ItemBandMembers findByPrimaryKey(
		int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemBandMembersException {
		return getPersistence().findByPrimaryKey(ItemBandMemberId);
	}

	/**
	* Returns the item band members with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members, or <code>null</code> if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.ItemBandMembers fetchByPrimaryKey(
		int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ItemBandMemberId);
	}

	/**
	* Returns all the item band memberses.
	*
	* @return the item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.ItemBandMembers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item band memberses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of item band memberses
	* @param end the upper bound of the range of item band memberses (not inclusive)
	* @return the range of item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.ItemBandMembers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item band memberses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of item band memberses
	* @param end the upper bound of the range of item band memberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.ItemBandMembers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item band memberses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item band memberses.
	*
	* @return the number of item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemBandMembersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemBandMembersPersistence)PortletBeanLocatorUtil.locate(com.sb.service.ClpSerializer.getServletContextName(),
					ItemBandMembersPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemBandMembersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ItemBandMembersPersistence persistence) {
	}

	private static ItemBandMembersPersistence _persistence;
}