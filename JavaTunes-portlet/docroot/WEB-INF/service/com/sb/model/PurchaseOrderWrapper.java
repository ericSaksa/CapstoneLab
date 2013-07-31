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
 * This class is a wrapper for {@link PurchaseOrder}.
 * </p>
 *
 * @author    amifxw0
 * @see       PurchaseOrder
 * @generated
 */
public class PurchaseOrderWrapper implements PurchaseOrder,
	ModelWrapper<PurchaseOrder> {
	public PurchaseOrderWrapper(PurchaseOrder purchaseOrder) {
		_purchaseOrder = purchaseOrder;
	}

	public Class<?> getModelClass() {
		return PurchaseOrder.class;
	}

	public String getModelClassName() {
		return PurchaseOrder.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PoId", getPoId());
		attributes.put("Status", getStatus());
		attributes.put("OrderDate", getOrderDate());
		attributes.put("UserId", getUserId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer PoId = (Integer)attributes.get("PoId");

		if (PoId != null) {
			setPoId(PoId);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date OrderDate = (Date)attributes.get("OrderDate");

		if (OrderDate != null) {
			setOrderDate(OrderDate);
		}

		Integer UserId = (Integer)attributes.get("UserId");

		if (UserId != null) {
			setUserId(UserId);
		}
	}

	/**
	* Returns the primary key of this purchase order.
	*
	* @return the primary key of this purchase order
	*/
	public int getPrimaryKey() {
		return _purchaseOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this purchase order.
	*
	* @param primaryKey the primary key of this purchase order
	*/
	public void setPrimaryKey(int primaryKey) {
		_purchaseOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the po ID of this purchase order.
	*
	* @return the po ID of this purchase order
	*/
	public int getPoId() {
		return _purchaseOrder.getPoId();
	}

	/**
	* Sets the po ID of this purchase order.
	*
	* @param PoId the po ID of this purchase order
	*/
	public void setPoId(int PoId) {
		_purchaseOrder.setPoId(PoId);
	}

	/**
	* Returns the status of this purchase order.
	*
	* @return the status of this purchase order
	*/
	public int getStatus() {
		return _purchaseOrder.getStatus();
	}

	/**
	* Sets the status of this purchase order.
	*
	* @param Status the status of this purchase order
	*/
	public void setStatus(int Status) {
		_purchaseOrder.setStatus(Status);
	}

	/**
	* Returns the order date of this purchase order.
	*
	* @return the order date of this purchase order
	*/
	public java.util.Date getOrderDate() {
		return _purchaseOrder.getOrderDate();
	}

	/**
	* Sets the order date of this purchase order.
	*
	* @param OrderDate the order date of this purchase order
	*/
	public void setOrderDate(java.util.Date OrderDate) {
		_purchaseOrder.setOrderDate(OrderDate);
	}

	/**
	* Returns the user ID of this purchase order.
	*
	* @return the user ID of this purchase order
	*/
	public int getUserId() {
		return _purchaseOrder.getUserId();
	}

	/**
	* Sets the user ID of this purchase order.
	*
	* @param UserId the user ID of this purchase order
	*/
	public void setUserId(int UserId) {
		_purchaseOrder.setUserId(UserId);
	}

	public boolean isNew() {
		return _purchaseOrder.isNew();
	}

	public void setNew(boolean n) {
		_purchaseOrder.setNew(n);
	}

	public boolean isCachedModel() {
		return _purchaseOrder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_purchaseOrder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _purchaseOrder.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _purchaseOrder.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_purchaseOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _purchaseOrder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_purchaseOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PurchaseOrderWrapper((PurchaseOrder)_purchaseOrder.clone());
	}

	public int compareTo(com.sb.model.PurchaseOrder purchaseOrder) {
		return _purchaseOrder.compareTo(purchaseOrder);
	}

	@Override
	public int hashCode() {
		return _purchaseOrder.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sb.model.PurchaseOrder> toCacheModel() {
		return _purchaseOrder.toCacheModel();
	}

	public com.sb.model.PurchaseOrder toEscapedModel() {
		return new PurchaseOrderWrapper(_purchaseOrder.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _purchaseOrder.toString();
	}

	public java.lang.String toXmlString() {
		return _purchaseOrder.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_purchaseOrder.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PurchaseOrder getWrappedPurchaseOrder() {
		return _purchaseOrder;
	}

	public PurchaseOrder getWrappedModel() {
		return _purchaseOrder;
	}

	public void resetOriginalValues() {
		_purchaseOrder.resetOriginalValues();
	}

	private PurchaseOrder _purchaseOrder;
}