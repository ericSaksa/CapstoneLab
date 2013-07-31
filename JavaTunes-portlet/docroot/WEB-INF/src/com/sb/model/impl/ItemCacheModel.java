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

import com.sb.model.Item;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Item in entity cache.
 *
 * @author amifxw0
 * @see Item
 * @generated
 */
public class ItemCacheModel implements CacheModel<Item>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ItemId=");
		sb.append(ItemId);
		sb.append(", Num=");
		sb.append(Num);
		sb.append(", Title=");
		sb.append(Title);
		sb.append(", Artist=");
		sb.append(Artist);
		sb.append(", ReleaseDate=");
		sb.append(ReleaseDate);
		sb.append(", ListPrice=");
		sb.append(ListPrice);
		sb.append(", Price=");
		sb.append(Price);
		sb.append(", Version=");
		sb.append(Version);
		sb.append("}");

		return sb.toString();
	}

	public Item toEntityModel() {
		ItemImpl itemImpl = new ItemImpl();

		itemImpl.setItemId(ItemId);

		if (Num == null) {
			itemImpl.setNum(StringPool.BLANK);
		}
		else {
			itemImpl.setNum(Num);
		}

		if (Title == null) {
			itemImpl.setTitle(StringPool.BLANK);
		}
		else {
			itemImpl.setTitle(Title);
		}

		if (Artist == null) {
			itemImpl.setArtist(StringPool.BLANK);
		}
		else {
			itemImpl.setArtist(Artist);
		}

		if (ReleaseDate == Long.MIN_VALUE) {
			itemImpl.setReleaseDate(null);
		}
		else {
			itemImpl.setReleaseDate(new Date(ReleaseDate));
		}

		itemImpl.setListPrice(ListPrice);
		itemImpl.setPrice(Price);
		itemImpl.setVersion(Version);

		itemImpl.resetOriginalValues();

		return itemImpl;
	}

	public int ItemId;
	public String Num;
	public String Title;
	public String Artist;
	public long ReleaseDate;
	public double ListPrice;
	public double Price;
	public int Version;
}