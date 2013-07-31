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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the item band members local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author amifxw0
 * @see ItemBandMembersLocalServiceUtil
 * @see com.sb.service.base.ItemBandMembersLocalServiceBaseImpl
 * @see com.sb.service.impl.ItemBandMembersLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ItemBandMembersLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemBandMembersLocalServiceUtil} to access the item band members local service. Add custom service methods to {@link com.sb.service.impl.ItemBandMembersLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the item band members to the database. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @return the item band members that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers addItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new item band members with the primary key. Does not add the item band members to the database.
	*
	* @param ItemBandMemberId the primary key for the new item band members
	* @return the new item band members
	*/
	public com.sb.model.ItemBandMembers createItemBandMembers(
		int ItemBandMemberId);

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
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the item band members from the database. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @return the item band members that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers deleteItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sb.model.ItemBandMembers fetchItemBandMembers(
		int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item band members with the primary key.
	*
	* @param ItemBandMemberId the primary key of the item band members
	* @return the item band members
	* @throws PortalException if a item band members with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sb.model.ItemBandMembers getItemBandMembers(int ItemBandMemberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item band memberses.
	*
	* @return the number of item band memberses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getItemBandMembersesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the item band members in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemBandMembers the item band members
	* @return the item band members that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.ItemBandMembers updateItemBandMembers(
		com.sb.model.ItemBandMembers itemBandMembers)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;
}