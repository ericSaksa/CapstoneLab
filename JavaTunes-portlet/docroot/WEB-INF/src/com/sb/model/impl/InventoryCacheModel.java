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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sb.model.Inventory;

import java.io.Serializable;

/**
 * The cache model class for representing Inventory in entity cache.
 *
 * @author amifxw0
 * @see Inventory
 * @generated
 */
public class InventoryCacheModel implements CacheModel<Inventory>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{InvId=");
		sb.append(InvId);
		sb.append(", ItemId=");
		sb.append(ItemId);
		sb.append(", URL=");
		sb.append(URL);
		sb.append(", NoOfLicence=");
		sb.append(NoOfLicence);
		sb.append(", FileType=");
		sb.append(FileType);
		sb.append("}");

		return sb.toString();
	}

	public Inventory toEntityModel() {
		InventoryImpl inventoryImpl = new InventoryImpl();

		inventoryImpl.setInvId(InvId);
		inventoryImpl.setItemId(ItemId);

		if (URL == null) {
			inventoryImpl.setURL(StringPool.BLANK);
		}
		else {
			inventoryImpl.setURL(URL);
		}

		inventoryImpl.setNoOfLicence(NoOfLicence);

		if (FileType == null) {
			inventoryImpl.setFileType(StringPool.BLANK);
		}
		else {
			inventoryImpl.setFileType(FileType);
		}

		inventoryImpl.resetOriginalValues();

		return inventoryImpl;
	}

	public int InvId;
	public int ItemId;
	public String URL;
	public int NoOfLicence;
	public String FileType;
}