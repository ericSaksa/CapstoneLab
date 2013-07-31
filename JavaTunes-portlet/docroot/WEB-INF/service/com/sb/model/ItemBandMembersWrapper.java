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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ItemBandMembers}.
 * </p>
 *
 * @author    amifxw0
 * @see       ItemBandMembers
 * @generated
 */
public class ItemBandMembersWrapper implements ItemBandMembers,
	ModelWrapper<ItemBandMembers> {
	public ItemBandMembersWrapper(ItemBandMembers itemBandMembers) {
		_itemBandMembers = itemBandMembers;
	}

	public Class<?> getModelClass() {
		return ItemBandMembers.class;
	}

	public String getModelClassName() {
		return ItemBandMembers.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ItemBandMemberId", getItemBandMemberId());
		attributes.put("ItemId", getItemId());
		attributes.put("Member", getMember());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ItemBandMemberId = (Integer)attributes.get("ItemBandMemberId");

		if (ItemBandMemberId != null) {
			setItemBandMemberId(ItemBandMemberId);
		}

		Integer ItemId = (Integer)attributes.get("ItemId");

		if (ItemId != null) {
			setItemId(ItemId);
		}

		String Member = (String)attributes.get("Member");

		if (Member != null) {
			setMember(Member);
		}
	}

	/**
	* Returns the primary key of this item band members.
	*
	* @return the primary key of this item band members
	*/
	public int getPrimaryKey() {
		return _itemBandMembers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item band members.
	*
	* @param primaryKey the primary key of this item band members
	*/
	public void setPrimaryKey(int primaryKey) {
		_itemBandMembers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item band member ID of this item band members.
	*
	* @return the item band member ID of this item band members
	*/
	public int getItemBandMemberId() {
		return _itemBandMembers.getItemBandMemberId();
	}

	/**
	* Sets the item band member ID of this item band members.
	*
	* @param ItemBandMemberId the item band member ID of this item band members
	*/
	public void setItemBandMemberId(int ItemBandMemberId) {
		_itemBandMembers.setItemBandMemberId(ItemBandMemberId);
	}

	/**
	* Returns the item ID of this item band members.
	*
	* @return the item ID of this item band members
	*/
	public int getItemId() {
		return _itemBandMembers.getItemId();
	}

	/**
	* Sets the item ID of this item band members.
	*
	* @param ItemId the item ID of this item band members
	*/
	public void setItemId(int ItemId) {
		_itemBandMembers.setItemId(ItemId);
	}

	/**
	* Returns the member of this item band members.
	*
	* @return the member of this item band members
	*/
	public java.lang.String getMember() {
		return _itemBandMembers.getMember();
	}

	/**
	* Sets the member of this item band members.
	*
	* @param Member the member of this item band members
	*/
	public void setMember(java.lang.String Member) {
		_itemBandMembers.setMember(Member);
	}

	public boolean isNew() {
		return _itemBandMembers.isNew();
	}

	public void setNew(boolean n) {
		_itemBandMembers.setNew(n);
	}

	public boolean isCachedModel() {
		return _itemBandMembers.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_itemBandMembers.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _itemBandMembers.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _itemBandMembers.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemBandMembers.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemBandMembers.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemBandMembers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemBandMembersWrapper((ItemBandMembers)_itemBandMembers.clone());
	}

	public int compareTo(com.sb.model.ItemBandMembers itemBandMembers) {
		return _itemBandMembers.compareTo(itemBandMembers);
	}

	@Override
	public int hashCode() {
		return _itemBandMembers.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sb.model.ItemBandMembers> toCacheModel() {
		return _itemBandMembers.toCacheModel();
	}

	public com.sb.model.ItemBandMembers toEscapedModel() {
		return new ItemBandMembersWrapper(_itemBandMembers.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemBandMembers.toString();
	}

	public java.lang.String toXmlString() {
		return _itemBandMembers.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemBandMembers.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ItemBandMembers getWrappedItemBandMembers() {
		return _itemBandMembers;
	}

	public ItemBandMembers getWrappedModel() {
		return _itemBandMembers;
	}

	public void resetOriginalValues() {
		_itemBandMembers.resetOriginalValues();
	}

	private ItemBandMembers _itemBandMembers;
}