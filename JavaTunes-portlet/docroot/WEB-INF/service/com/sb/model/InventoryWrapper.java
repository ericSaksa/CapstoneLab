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
 * This class is a wrapper for {@link Inventory}.
 * </p>
 *
 * @author    amifxw0
 * @see       Inventory
 * @generated
 */
public class InventoryWrapper implements Inventory, ModelWrapper<Inventory> {
	public InventoryWrapper(Inventory inventory) {
		_inventory = inventory;
	}

	public Class<?> getModelClass() {
		return Inventory.class;
	}

	public String getModelClassName() {
		return Inventory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("InvId", getInvId());
		attributes.put("ItemId", getItemId());
		attributes.put("URL", getURL());
		attributes.put("NoOfLicence", getNoOfLicence());
		attributes.put("FileType", getFileType());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer InvId = (Integer)attributes.get("InvId");

		if (InvId != null) {
			setInvId(InvId);
		}

		Integer ItemId = (Integer)attributes.get("ItemId");

		if (ItemId != null) {
			setItemId(ItemId);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		Integer NoOfLicence = (Integer)attributes.get("NoOfLicence");

		if (NoOfLicence != null) {
			setNoOfLicence(NoOfLicence);
		}

		String FileType = (String)attributes.get("FileType");

		if (FileType != null) {
			setFileType(FileType);
		}
	}

	/**
	* Returns the primary key of this inventory.
	*
	* @return the primary key of this inventory
	*/
	public int getPrimaryKey() {
		return _inventory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this inventory.
	*
	* @param primaryKey the primary key of this inventory
	*/
	public void setPrimaryKey(int primaryKey) {
		_inventory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inv ID of this inventory.
	*
	* @return the inv ID of this inventory
	*/
	public int getInvId() {
		return _inventory.getInvId();
	}

	/**
	* Sets the inv ID of this inventory.
	*
	* @param InvId the inv ID of this inventory
	*/
	public void setInvId(int InvId) {
		_inventory.setInvId(InvId);
	}

	/**
	* Returns the item ID of this inventory.
	*
	* @return the item ID of this inventory
	*/
	public int getItemId() {
		return _inventory.getItemId();
	}

	/**
	* Sets the item ID of this inventory.
	*
	* @param ItemId the item ID of this inventory
	*/
	public void setItemId(int ItemId) {
		_inventory.setItemId(ItemId);
	}

	/**
	* Returns the u r l of this inventory.
	*
	* @return the u r l of this inventory
	*/
	public java.lang.String getURL() {
		return _inventory.getURL();
	}

	/**
	* Sets the u r l of this inventory.
	*
	* @param URL the u r l of this inventory
	*/
	public void setURL(java.lang.String URL) {
		_inventory.setURL(URL);
	}

	/**
	* Returns the no of licence of this inventory.
	*
	* @return the no of licence of this inventory
	*/
	public int getNoOfLicence() {
		return _inventory.getNoOfLicence();
	}

	/**
	* Sets the no of licence of this inventory.
	*
	* @param NoOfLicence the no of licence of this inventory
	*/
	public void setNoOfLicence(int NoOfLicence) {
		_inventory.setNoOfLicence(NoOfLicence);
	}

	/**
	* Returns the file type of this inventory.
	*
	* @return the file type of this inventory
	*/
	public java.lang.String getFileType() {
		return _inventory.getFileType();
	}

	/**
	* Sets the file type of this inventory.
	*
	* @param FileType the file type of this inventory
	*/
	public void setFileType(java.lang.String FileType) {
		_inventory.setFileType(FileType);
	}

	public boolean isNew() {
		return _inventory.isNew();
	}

	public void setNew(boolean n) {
		_inventory.setNew(n);
	}

	public boolean isCachedModel() {
		return _inventory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_inventory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _inventory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _inventory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_inventory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _inventory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_inventory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InventoryWrapper((Inventory)_inventory.clone());
	}

	public int compareTo(com.sb.model.Inventory inventory) {
		return _inventory.compareTo(inventory);
	}

	@Override
	public int hashCode() {
		return _inventory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sb.model.Inventory> toCacheModel() {
		return _inventory.toCacheModel();
	}

	public com.sb.model.Inventory toEscapedModel() {
		return new InventoryWrapper(_inventory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _inventory.toString();
	}

	public java.lang.String toXmlString() {
		return _inventory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_inventory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Inventory getWrappedInventory() {
		return _inventory;
	}

	public Inventory getWrappedModel() {
		return _inventory;
	}

	public void resetOriginalValues() {
		_inventory.resetOriginalValues();
	}

	private Inventory _inventory;
}