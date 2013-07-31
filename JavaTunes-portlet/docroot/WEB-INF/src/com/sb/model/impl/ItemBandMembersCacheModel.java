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

import com.sb.model.ItemBandMembers;

import java.io.Serializable;

/**
 * The cache model class for representing ItemBandMembers in entity cache.
 *
 * @author amifxw0
 * @see ItemBandMembers
 * @generated
 */
public class ItemBandMembersCacheModel implements CacheModel<ItemBandMembers>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ItemBandMemberId=");
		sb.append(ItemBandMemberId);
		sb.append(", ItemId=");
		sb.append(ItemId);
		sb.append(", Member=");
		sb.append(Member);
		sb.append("}");

		return sb.toString();
	}

	public ItemBandMembers toEntityModel() {
		ItemBandMembersImpl itemBandMembersImpl = new ItemBandMembersImpl();

		itemBandMembersImpl.setItemBandMemberId(ItemBandMemberId);
		itemBandMembersImpl.setItemId(ItemId);

		if (Member == null) {
			itemBandMembersImpl.setMember(StringPool.BLANK);
		}
		else {
			itemBandMembersImpl.setMember(Member);
		}

		itemBandMembersImpl.resetOriginalValues();

		return itemBandMembersImpl;
	}

	public int ItemBandMemberId;
	public int ItemId;
	public String Member;
}