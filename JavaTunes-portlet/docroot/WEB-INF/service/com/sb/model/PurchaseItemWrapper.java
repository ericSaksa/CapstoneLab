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
 * This class is a wrapper for {@link PurchaseItem}.
 * </p>
 *
 * @author    amifxw0
 * @see       PurchaseItem
 * @generated
 */
public class PurchaseItemWrapper implements PurchaseItem,
	ModelWrapper<PurchaseItem> {
	public PurchaseItemWrapper(PurchaseItem purchaseItem) {
		_purchaseItem = purchaseItem;
	}

	public Class<?> getModelClass() {
		return PurchaseItem.class;
	}

	public String getModelClassName() {
		return PurchaseItem.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PurchaseItemId", getPurchaseItemId());
		attributes.put("PoId", getPoId());
		attributes.put("ItemId", getItemId());
		attributes.put("Quantity", getQuantity());
		attributes.put("UnitPrice", getUnitPrice());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer PurchaseItemId = (Integer)attributes.get("PurchaseItemId");

		if (PurchaseItemId != null) {
			setPurchaseItemId(PurchaseItemId);
		}

		Integer PoId = (Integer)attributes.get("PoId");

		if (PoId != null) {
			setPoId(PoId);
		}

		Integer ItemId = (Integer)attributes.get("ItemId");

		if (ItemId != null) {
			setItemId(ItemId);
		}

		Integer Quantity = (Integer)attributes.get("Quantity");

		if (Quantity != null) {
			setQuantity(Quantity);
		}

		Double UnitPrice = (Double)attributes.get("UnitPrice");

		if (UnitPrice != null) {
			setUnitPrice(UnitPrice);
		}
	}

	/**
	* Returns the primary key of this purchase item.
	*
	* @return the primary key of this purchase item
	*/
	public int getPrimaryKey() {
		return _purchaseItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this purchase item.
	*
	* @param primaryKey the primary key of this purchase item
	*/
	public void setPrimaryKey(int primaryKey) {
		_purchaseItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the purchase item ID of this purchase item.
	*
	* @return the purchase item ID of this purchase item
	*/
	public int getPurchaseItemId() {
		return _purchaseItem.getPurchaseItemId();
	}

	/**
	* Sets the purchase item ID of this purchase item.
	*
	* @param PurchaseItemId the purchase item ID of this purchase item
	*/
	public void setPurchaseItemId(int PurchaseItemId) {
		_purchaseItem.setPurchaseItemId(PurchaseItemId);
	}

	/**
	* Returns the po ID of this purchase item.
	*
	* @return the po ID of this purchase item
	*/
	public int getPoId() {
		return _purchaseItem.getPoId();
	}

	/**
	* Sets the po ID of this purchase item.
	*
	* @param PoId the po ID of this purchase item
	*/
	public void setPoId(int PoId) {
		_purchaseItem.setPoId(PoId);
	}

	/**
	* Returns the item ID of this purchase item.
	*
	* @return the item ID of this purchase item
	*/
	public int getItemId() {
		return _purchaseItem.getItemId();
	}

	/**
	* Sets the item ID of this purchase item.
	*
	* @param ItemId the item ID of this purchase item
	*/
	public void setItemId(int ItemId) {
		_purchaseItem.setItemId(ItemId);
	}

	/**
	* Returns the quantity of this purchase item.
	*
	* @return the quantity of this purchase item
	*/
	public int getQuantity() {
		return _purchaseItem.getQuantity();
	}

	/**
	* Sets the quantity of this purchase item.
	*
	* @param Quantity the quantity of this purchase item
	*/
	public void setQuantity(int Quantity) {
		_purchaseItem.setQuantity(Quantity);
	}

	/**
	* Returns the unit price of this purchase item.
	*
	* @return the unit price of this purchase item
	*/
	public double getUnitPrice() {
		return _purchaseItem.getUnitPrice();
	}

	/**
	* Sets the unit price of this purchase item.
	*
	* @param UnitPrice the unit price of this purchase item
	*/
	public void setUnitPrice(double UnitPrice) {
		_purchaseItem.setUnitPrice(UnitPrice);
	}

	public boolean isNew() {
		return _purchaseItem.isNew();
	}

	public void setNew(boolean n) {
		_purchaseItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _purchaseItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_purchaseItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _purchaseItem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _purchaseItem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_purchaseItem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _purchaseItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_purchaseItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PurchaseItemWrapper((PurchaseItem)_purchaseItem.clone());
	}

	public int compareTo(PurchaseItem purchaseItem) {
		return _purchaseItem.compareTo(purchaseItem);
	}

	@Override
	public int hashCode() {
		return _purchaseItem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<PurchaseItem> toCacheModel() {
		return _purchaseItem.toCacheModel();
	}

	public PurchaseItem toEscapedModel() {
		return new PurchaseItemWrapper(_purchaseItem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _purchaseItem.toString();
	}

	public java.lang.String toXmlString() {
		return _purchaseItem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_purchaseItem.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PurchaseItem getWrappedPurchaseItem() {
		return _purchaseItem;
	}

	public PurchaseItem getWrappedModel() {
		return _purchaseItem;
	}

	public void resetOriginalValues() {
		_purchaseItem.resetOriginalValues();
	}

	private PurchaseItem _purchaseItem;
}