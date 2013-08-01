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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the item local service. This utility wraps {@link com.sb.service.impl.ItemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author amifxw0
 * @see ItemLocalService
 * @see com.sb.service.base.ItemLocalServiceBaseImpl
 * @see com.sb.service.impl.ItemLocalServiceImpl
 * @generated
 */
public class ItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sb.service.impl.ItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the item to the database. Also notifies the appropriate model listeners.
	*
	* @param item the item
	* @return the item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item addItem(com.sb.model.Item item)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addItem(item);
	}

	/**
	* Creates a new item with the primary key. Does not add the item to the database.
	*
	* @param ItemId the primary key for the new item
	* @return the new item
	*/
	public static com.sb.model.Item createItem(int ItemId) {
		return getService().createItem(ItemId);
	}

	/**
	* Deletes the item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ItemId the primary key of the item
	* @return the item that was removed
	* @throws PortalException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item deleteItem(int ItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteItem(ItemId);
	}

	/**
	* Deletes the item from the database. Also notifies the appropriate model listeners.
	*
	* @param item the item
	* @return the item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item deleteItem(com.sb.model.Item item)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteItem(item);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.sb.model.Item fetchItem(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchItem(ItemId);
	}

	/**
	* Returns the item with the primary key.
	*
	* @param ItemId the primary key of the item
	* @return the item
	* @throws PortalException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item getItem(int ItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItem(ItemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @return the range of items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.Item> getItems(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItems(start, end);
	}

	/**
	* Returns the number of items.
	*
	* @return the number of items
	* @throws SystemException if a system exception occurred
	*/
	public static int getItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemsCount();
	}

	/**
	* Updates the item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param item the item
	* @return the item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item updateItem(com.sb.model.Item item)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateItem(item);
	}

	/**
	* Updates the item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param item the item
	* @param merge whether to merge the item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item updateItem(com.sb.model.Item item,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateItem(item, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.sb.model.ItemBandMembers> getBandMembers(
		int itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBandMembers(itemId);
	}

	public static java.util.List<com.sb.model.Inventory> getInventory(
		int itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInventory(itemId);
	}

	public static java.util.List<com.sb.model.Item> findByTitle(
		java.lang.String Title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTitle(Title);
	}

	public static java.util.List<com.sb.model.Item> findByArtist(
		java.lang.String Artist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByArtist(Artist);
	}

	public static void clearService() {
		_service = null;
	}

	public static ItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ItemLocalService.class.getName());

			if (invokableLocalService instanceof ItemLocalService) {
				_service = (ItemLocalService)invokableLocalService;
			}
			else {
				_service = new ItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ItemLocalService service) {
	}

	private static ItemLocalService _service;
}