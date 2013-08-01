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

import com.sb.model.Inventory;
import com.sb.model.ItemBandMembers;
import com.sb.service.base.ItemLocalServiceBaseImpl;
import com.sb.service.persistence.ItemUtil;

/**
 * The implementation of the item local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sb.service.ItemLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author amifxw0
 * @see com.sb.service.base.ItemLocalServiceBaseImpl
 * @see com.sb.service.ItemLocalServiceUtil
 */
public class ItemLocalServiceImpl extends ItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sb.service.ItemLocalServiceUtil} to access the item local service.
	 */

	public List<ItemBandMembers> getBandMembers(int itemId)
			throws com.liferay.portal.kernel.exception.SystemException {
		List<ItemBandMembers> itemBandMembersList;

		try {
			itemBandMembersList = ItemUtil.getItemBandMemberses(itemId);
		} catch (Exception e) {
			throw new com.liferay.portal.kernel.exception.SystemException();
		}

		return itemBandMembersList;
	}

	public List<Inventory> getInventory(int itemId)
			throws com.liferay.portal.kernel.exception.SystemException {
		List<Inventory> inventoryList;

		try {
			inventoryList = ItemUtil.getInventories(itemId);
		} catch (Exception e) {
			throw new com.liferay.portal.kernel.exception.SystemException();
		}

		return inventoryList;
	}

	public java.util.List<com.sb.model.Item> findByTitle(

	java.lang.String Title)

	throws com.liferay.portal.kernel.exception.SystemException {

		return ItemUtil.findByTitle(Title);

	}

	public java.util.List<com.sb.model.Item> findByArtist(

	java.lang.String Artist)

	throws com.liferay.portal.kernel.exception.SystemException {

		return ItemUtil.findByArtist(Artist);

	}

}