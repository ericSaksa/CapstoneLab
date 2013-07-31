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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sb.model.ItemBandMembers;

/**
 * The persistence interface for the item band members service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see ItemBandMembersPersistenceImpl
 * @see ItemBandMembersUtil
 * @generated
 */
public interface ItemBandMembersPersistence extends BasePersistence<ItemBandMembers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemBandMembersUtil} to access the item band members persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the item band members in the entity cache if it is enabled.
	*
	* @param itemBandMembers the item band members
	*/
	public void cacheResult(com.sb.model.ItemBandMembers itemBandMembers);

	/**
	* Caches the item band memberses in the entity cache if it is enabled.
	*
	* @param itemBandMemberses the item band memberses
	*/
	public void cacheResult(
		java.util.List<com.sb.model.ItemBandMembers> itemBandMemberses);

	/**
	* Creates a new item band members with the primary key. Does not add the item band members to the database.
	*
	* @param ItemBandMemberId the primary key for the new item band members
	* @return the new item band members
	*/
	public com.sb.model.ItemBandMembers create(int ItemBandMemberId);

	/**
	* Removes the item band members with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members that was removed
	* @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers remove(int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemBandMembersException;

	public com.sb.model.ItemBandMembers updateImpl(
		com.sb.model.ItemBandMembers itemBandMembers, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item band members with the primary key or throws a {@link com.sb.NoSuchItemBandMembersException} if it could not be found.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members
	* @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers findByPrimaryKey(int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemBandMembersException;

	/**
	* Returns the item band members with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members, or <code>null</code> if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers fetchByPrimaryKey(int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item band memberses.
	*
	* @return the item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.ItemBandMembers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.ItemBandMembers> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.ItemBandMembers> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item band memberses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item band memberses.
	*
	* @return the number of item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}