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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Item}.
 * </p>
 *
 * @author    amifxw0
 * @see       Item
 * @generated
 */
public class ItemWrapper implements Item, ModelWrapper<Item> {
	public ItemWrapper(Item item) {
		_item = item;
	}

	public Class<?> getModelClass() {
		return Item.class;
	}

	public String getModelClassName() {
		return Item.class.getName();
	}

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

	/**
	* Returns the primary key of this item.
	*
	* @return the primary key of this item
	*/
	public int getPrimaryKey() {
		return _item.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item.
	*
	* @param primaryKey the primary key of this item
	*/
	public void setPrimaryKey(int primaryKey) {
		_item.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item.
	*
	* @return the item ID of this item
	*/
	public int getItemId() {
		return _item.getItemId();
	}

	/**
	* Sets the item ID of this item.
	*
	* @param ItemId the item ID of this item
	*/
	public void setItemId(int ItemId) {
		_item.setItemId(ItemId);
	}

	/**
	* Returns the num of this item.
	*
	* @return the num of this item
	*/
	public java.lang.String getNum() {
		return _item.getNum();
	}

	/**
	* Sets the num of this item.
	*
	* @param Num the num of this item
	*/
	public void setNum(java.lang.String Num) {
		_item.setNum(Num);
	}

	/**
	* Returns the title of this item.
	*
	* @return the title of this item
	*/
	public java.lang.String getTitle() {
		return _item.getTitle();
	}

	/**
	* Sets the title of this item.
	*
	* @param Title the title of this item
	*/
	public void setTitle(java.lang.String Title) {
		_item.setTitle(Title);
	}

	/**
	* Returns the artist of this item.
	*
	* @return the artist of this item
	*/
	public java.lang.String getArtist() {
		return _item.getArtist();
	}

	/**
	* Sets the artist of this item.
	*
	* @param Artist the artist of this item
	*/
	public void setArtist(java.lang.String Artist) {
		_item.setArtist(Artist);
	}

	/**
	* Returns the release date of this item.
	*
	* @return the release date of this item
	*/
	public java.util.Date getReleaseDate() {
		return _item.getReleaseDate();
	}

	/**
	* Sets the release date of this item.
	*
	* @param ReleaseDate the release date of this item
	*/
	public void setReleaseDate(java.util.Date ReleaseDate) {
		_item.setReleaseDate(ReleaseDate);
	}

	/**
	* Returns the list price of this item.
	*
	* @return the list price of this item
	*/
	public double getListPrice() {
		return _item.getListPrice();
	}

	/**
	* Sets the list price of this item.
	*
	* @param ListPrice the list price of this item
	*/
	public void setListPrice(double ListPrice) {
		_item.setListPrice(ListPrice);
	}

	/**
	* Returns the price of this item.
	*
	* @return the price of this item
	*/
	public double getPrice() {
		return _item.getPrice();
	}

	/**
	* Sets the price of this item.
	*
	* @param Price the price of this item
	*/
	public void setPrice(double Price) {
		_item.setPrice(Price);
	}

	/**
	* Returns the version of this item.
	*
	* @return the version of this item
	*/
	public int getVersion() {
		return _item.getVersion();
	}

	/**
	* Sets the version of this item.
	*
	* @param Version the version of this item
	*/
	public void setVersion(int Version) {
		_item.setVersion(Version);
	}

	public boolean isNew() {
		return _item.isNew();
	}

	public void setNew(boolean n) {
		_item.setNew(n);
	}

	public boolean isCachedModel() {
		return _item.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_item.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _item.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _item.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_item.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _item.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_item.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemWrapper((Item)_item.clone());
	}

	public int compareTo(Item item) {
		return _item.compareTo(item);
	}

	@Override
	public int hashCode() {
		return _item.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Item> toCacheModel() {
		return _item.toCacheModel();
	}

	public Item toEscapedModel() {
		return new ItemWrapper(_item.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _item.toString();
	}

	public java.lang.String toXmlString() {
		return _item.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_item.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Item getWrappedItem() {
		return _item;
	}

	public Item getWrappedModel() {
		return _item;
	}

	public void resetOriginalValues() {
		_item.resetOriginalValues();
	}

	private Item _item;
}