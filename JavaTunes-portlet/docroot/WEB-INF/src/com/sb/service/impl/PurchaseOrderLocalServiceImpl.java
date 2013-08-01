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

package com.sb.service.impl;

import java.util.List;

import com.sb.model.PurchaseItem;
import com.sb.model.PurchaseOrder;
import com.sb.service.base.PurchaseOrderLocalServiceBaseImpl;
import com.sb.service.persistence.PurchaseOrderUtil;

/**
 * The implementation of the purchase order local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sb.service.PurchaseOrderLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author amifxw0
 * @see com.sb.service.base.PurchaseOrderLocalServiceBaseImpl
 * @see com.sb.service.PurchaseOrderLocalServiceUtil
 */
public class PurchaseOrderLocalServiceImpl extends
		PurchaseOrderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sb.service.PurchaseOrderLocalServiceUtil} to access the purchase
	 * order local service.
	 */
	public List<PurchaseItem> getItems(int orderId)
			throws com.liferay.portal.kernel.exception.SystemException

	{

		List<PurchaseItem> purchaseItemList;

		try {

			purchaseItemList = PurchaseOrderUtil.getPurchaseItems(orderId);

		} catch (Exception e) {

			throw new com.liferay.portal.kernel.exception.SystemException();

		}

		return purchaseItemList;

	}

	public List<PurchaseOrder> findByOrderByUserId(int UserId)

	throws com.liferay.portal.kernel.exception.SystemException,

	com.sb.NoSuchPurchaseOrderException

	{

		return PurchaseOrderUtil.findByOrderByUserId(UserId);

	}

}