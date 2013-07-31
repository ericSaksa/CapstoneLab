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

package com.sb.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.sb.model.PurchaseOrder;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PurchaseOrder in entity cache.
 *
 * @author amifxw0
 * @see PurchaseOrder
 * @generated
 */
public class PurchaseOrderCacheModel implements CacheModel<PurchaseOrder>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{PoId=");
		sb.append(PoId);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", OrderDate=");
		sb.append(OrderDate);
		sb.append(", UserId=");
		sb.append(UserId);
		sb.append("}");

		return sb.toString();
	}

	public PurchaseOrder toEntityModel() {
		PurchaseOrderImpl purchaseOrderImpl = new PurchaseOrderImpl();

		purchaseOrderImpl.setPoId(PoId);
		purchaseOrderImpl.setStatus(Status);

		if (OrderDate == Long.MIN_VALUE) {
			purchaseOrderImpl.setOrderDate(null);
		}
		else {
			purchaseOrderImpl.setOrderDate(new Date(OrderDate));
		}

		purchaseOrderImpl.setUserId(UserId);

		purchaseOrderImpl.resetOriginalValues();

		return purchaseOrderImpl;
	}

	public int PoId;
	public int Status;
	public long OrderDate;
	public int UserId;
}