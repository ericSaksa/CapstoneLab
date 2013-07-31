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

package com.sb.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sb.service.ItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author amifxw0
 */
public class ItemClp extends BaseModelImpl<Item> implements Item {
	public ItemClp() {
	}

	public Class<?> getModelClass() {
		return Item.class;
	}

	public String getModelClassName() {
		return Item.class.getName();
	}

	public int getPrimaryKey() {
		return _ItemId;
	}

	public void setPrimaryKey(int primaryKey) {
		setItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_ItemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ItemId", getItemId());
		attributes.put("Num", getNum());
		attributes.put("Title", getTitle());
		attributes.put("Artist", getArtist());
		attributes.put("ReleaseDate", getReleaseDate());
		attributes.put("ListPrice", getListPrice());
		attributes.put("Price", getPrice());
		attributes.put("Version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ItemId = (Integer)attributes.get("ItemId");

		if (ItemId != null) {
			setItemId(ItemId);
		}

		String Num = (String)attributes.get("Num");

		if (Num != null) {
			setNum(Num);
		}

		String Title = (String)attributes.get("Title");

		if (Title != null) {
			setTitle(Title);
		}

		String Artist = (String)attributes.get("Artist");

		if (Artist != null) {
			setArtist(Artist);
		}

		Date ReleaseDate = (Date)attributes.get("ReleaseDate");

		if (ReleaseDate != null) {
			setReleaseDate(ReleaseDate);
		}

		Double ListPrice = (Double)attributes.get("ListPrice");

		if (ListPrice != null) {
			setListPrice(ListPrice);
		}

		Double Price = (Double)attributes.get("Price");

		if (Price != null) {
			setPrice(Price);
		}

		Integer Version = (Integer)attributes.get("Version");

		if (Version != null) {
			setVersion(Version);
		}
	}

	public int getItemId() {
		return _ItemId;
	}

	public void setItemId(int ItemId) {
		_ItemId = ItemId;
	}

	public String getNum() {
		return _Num;
	}

	public void setNum(String Num) {
		_Num = Num;
	}

	public String getTitle() {
		return _Title;
	}

	public void setTitle(String Title) {
		_Title = Title;
	}

	public String getArtist() {
		return _Artist;
	}

	public void setArtist(String Artist) {
		_Artist = Artist;
	}

	public Date getReleaseDate() {
		return _ReleaseDate;
	}

	public void setReleaseDate(Date ReleaseDate) {
		_ReleaseDate = ReleaseDate;
	}

	public double getListPrice() {
		return _ListPrice;
	}

	public void setListPrice(double ListPrice) {
		_ListPrice = ListPrice;
	}

	public double getPrice() {
		return _Price;
	}

	public void setPrice(double Price) {
		_Price = Price;
	}

	public int getVersion() {
		return _Version;
	}

	public void setVersion(int Version) {
		_Version = Version;
	}

	public BaseModel<?> getItemRemoteModel() {
		return _itemRemoteModel;
	}

	public void setItemRemoteModel(BaseModel<?> itemRemoteModel) {
		_itemRemoteModel = itemRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemLocalServiceUtil.addItem(this);
		}
		else {
			ItemLocalServiceUtil.updateItem(this);
		}
	}

	@Override
	public Item toEscapedModel() {
		return (Item)Proxy.newProxyInstance(Item.class.getClassLoader(),
			new Class[] { Item.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemClp clone = new ItemClp();

		clone.setItemId(getItemId());
		clone.setNum(getNum());
		clone.setTitle(getTitle());
		clone.setArtist(getArtist());
		clone.setReleaseDate(getReleaseDate());
		clone.setListPrice(getListPrice());
		clone.setPrice(getPrice());
		clone.setVersion(getVersion());

		return clone;
	}

	public int compareTo(Item item) {
		int primaryKey = item.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ItemClp item = null;

		try {
			item = (ItemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = item.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ItemId=");
		sb.append(getItemId());
		sb.append(", Num=");
		sb.append(getNum());
		sb.append(", Title=");
		sb.append(getTitle());
		sb.append(", Artist=");
		sb.append(getArtist());
		sb.append(", ReleaseDate=");
		sb.append(getReleaseDate());
		sb.append(", ListPrice=");
		sb.append(getListPrice());
		sb.append(", Price=");
		sb.append(getPrice());
		sb.append(", Version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.sb.model.Item");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ItemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Num</column-name><column-value><![CDATA[");
		sb.append(getNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Artist</column-name><column-value><![CDATA[");
		sb.append(getArtist());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ReleaseDate</column-name><column-value><![CDATA[");
		sb.append(getReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ListPrice</column-name><column-value><![CDATA[");
		sb.append(getListPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ItemId;
	private String _Num;
	private String _Title;
	private String _Artist;
	private Date _ReleaseDate;
	private double _ListPrice;
	private double _Price;
	private int _Version;
	private BaseModel<?> _itemRemoteModel;
}