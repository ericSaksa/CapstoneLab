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
 * The utility for the inventory local service. This utility wraps {@link com.sb.service.impl.InventoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author amifxw0
 * @see InventoryLocalService
 * @see com.sb.service.base.InventoryLocalServiceBaseImpl
 * @see com.sb.service.impl.InventoryLocalServiceImpl
 * @generated
 */
public class InventoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sb.service.impl.InventoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the inventory to the database. Also notifies the appropriate model listeners.
	*
	* @param inventory the inventory
	* @return the inventory that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Inventory addInventory(
		com.sb.model.Inventory inventory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addInventory(inventory);
	}

	/**
	* Creates a new inventory with the primary key. Does not add the inventory to the database.
	*
	* @param InvId the primary key for the new inventory
	* @return the new inventory
	*/
	public static com.sb.model.Inventory createInventory(int InvId) {
		return getService().createInventory(InvId);
	}

	/**
	* Deletes the inventory with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InvId the primary key of the inventory
	* @return the inventory that was removed
	* @throws PortalException if a inventory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Inventory deleteInventory(int InvId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInventory(InvId);
	}

	/**
	* Deletes the inventory from the database. Also notifies the appropriate model listeners.
	*
	* @param inventory the inventory
	* @return the inventory that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Inventory deleteInventory(
		com.sb.model.Inventory inventory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInventory(inventory);
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

	public static com.sb.model.Inventory fetchInventory(int InvId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchInventory(InvId);
	}

	/**
	* Returns the inventory with the primary key.
	*
	* @param InvId the primary key of the inventory
	* @return the inventory
	* @throws PortalException if a inventory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Inventory getInventory(int InvId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getInventory(InvId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the inventories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of inventories
	* @param end the upper bound of the range of inventories (not inclusive)
	* @return the range of inventories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.Inventory> getInventories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInventories(start, end);
	}

	/**
	* Returns the number of inventories.
	*
	* @return the number of inventories
	* @throws SystemException if a system exception occurred
	*/
	public static int getInventoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInventoriesCount();
	}

	/**
	* Updates the inventory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param inventory the inventory
	* @return the inventory that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Inventory updateInventory(
		com.sb.model.Inventory inventory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInventory(inventory);
	}

	/**
	* Updates the inventory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param inventory the inventory
	* @param merge whether to merge the inventory with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the inventory that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Inventory updateInventory(
		com.sb.model.Inventory inventory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInventory(inventory, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static InventoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					InventoryLocalService.class.getName());

			if (invokableLocalService instanceof InventoryLocalService) {
				_service = (InventoryLocalService)invokableLocalService;
			}
			else {
				_service = new InventoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(InventoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(InventoryLocalService service) {
	}

	private static InventoryLocalService _service;
}