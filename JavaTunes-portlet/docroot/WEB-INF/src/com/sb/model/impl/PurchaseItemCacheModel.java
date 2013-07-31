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

import com.sb.model.PurchaseItem;

import java.io.Serializable;

/**
 * The cache model class for representing PurchaseItem in entity cache.
 *
 * @author amifxw0
 * @see PurchaseItem
 * @generated
 */
public class PurchaseItemCacheModel implements CacheModel<PurchaseItem>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{PurchaseItemId=");
		sb.append(PurchaseItemId);
		sb.append(", PoId=");
		sb.append(PoId);
		sb.append(", ItemId=");
		sb.append(ItemId);
		sb.append(", Quantity=");
		sb.append(Quantity);
		sb.append(", UnitPrice=");
		sb.append(UnitPrice);
		sb.append("}");

		return sb.toString();
	}

	public PurchaseItem toEntityModel() {
		PurchaseItemImpl purchaseItemImpl = new PurchaseItemImpl();

		purchaseItemImpl.setPurchaseItemId(PurchaseItemId);
		purchaseItemImpl.setPoId(PoId);
		purchaseItemImpl.setItemId(ItemId);
		purchaseItemImpl.setQuantity(Quantity);
		purchaseItemImpl.setUnitPrice(UnitPrice);

		purchaseItemImpl.resetOriginalValues();

		return purchaseItemImpl;
	}

	public int PurchaseItemId;
	public int PoId;
	public int ItemId;
	public int Quantity;
	public double UnitPrice;
}