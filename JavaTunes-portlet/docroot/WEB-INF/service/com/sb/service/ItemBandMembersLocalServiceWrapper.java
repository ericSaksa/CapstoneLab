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

package com.sb.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ItemBandMembersLocalService}.
 * </p>
 *
 * @author    amifxw0
 * @see       ItemBandMembersLocalService
 * @generated
 */
public class ItemBandMembersLocalServiceWrapper
	implements ItemBandMembersLocalService,
		ServiceWrapper<ItemBandMembersLocalService> {
	public ItemBandMembersLocalServiceWrapper(
		ItemBandMembersLocalService itemBandMembersLocalService) {
		_itemBandMembersLocalService = itemBandMembersLocalService;
	}

	/**
	* Adds the item band members to the database. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @return the item band members that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers addItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.addItemBandMembers(itemBandMembers);
	}

	/**
	* Creates a new item band members with the primary key. Does not add the item band members to the database.
	*
	* @param ItemBandMemberId the primary key for the new item band members
	* @return the new item band members
	*/
	public com.sb.model.ItemBandMembers createItemBandMembers(
		int ItemBandMemberId) {
		return _itemBandMembersLocalService.createItemBandMembers(ItemBandMemberId);
	}

	/**
	* Deletes the item band members with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members that was removed
	* @throws PortalException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers deleteItemBandMembers(
		int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.deleteItemBandMembers(ItemBandMemberId);
	}

	/**
	* Deletes the item band members from the database. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @return the item band members that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers deleteItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.deleteItemBandMembers(itemBandMembers);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemBandMembersLocalService.dynamicQuery();
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
		return _itemBandMembersLocalService.dynamicQuery(dynamicQuery);
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
		return _itemBandMembersLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _itemBandMembersLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _itemBandMembersLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.sb.model.ItemBandMembers fetchItemBandMembers(
		int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.fetchItemBandMembers(ItemBandMemberId);
	}

	/**
	* Returns the item band members with the primary key.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members
	* @throws PortalException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers getItemBandMembers(int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.getItemBandMembers(ItemBandMemberId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.getItemBandMemberses(start, end);
	}

	/**
	* Returns the number of item band memberses.
	*
	* @return the number of item band memberses
	* @throws SystemException if a system exception occurred
	*/
	public int getItemBandMembersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.getItemBandMembersesCount();
	}

	/**
	* Updates the item band members in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @return the item band members that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers updateItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.updateItemBandMembers(itemBandMembers);
	}

	/**
	* Updates the item band members in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @param merge whether to merge the item band members with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the item band members that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers updateItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemBandMembersLocalService.updateItemBandMembers(itemBandMembers,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _itemBandMembersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemBandMembersLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemBandMembersLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ItemBandMembersLocalService getWrappedItemBandMembersLocalService() {
		return _itemBandMembersLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedItemBandMembersLocalService(
		ItemBandMembersLocalService itemBandMembersLocalService) {
		_itemBandMembersLocalService = itemBandMembersLocalService;
	}

	public ItemBandMembersLocalService getWrappedService() {
		return _itemBandMembersLocalService;
	}

	public void setWrappedService(
		ItemBandMembersLocalService itemBandMembersLocalService) {
		_itemBandMembersLocalService = itemBandMembersLocalService;
	}

	private ItemBandMembersLocalService _itemBandMembersLocalService;
}