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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PurchaseOrder service. Represents a row in the &quot;PurchaseOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sb.model.impl.PurchaseOrderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sb.model.impl.PurchaseOrderImpl}.
 * </p>
 *
 * @author amifxw0
 * @see PurchaseOrder
 * @see com.sb.model.impl.PurchaseOrderImpl
 * @see com.sb.model.impl.PurchaseOrderModelImpl
 * @generated
 */
public interface PurchaseOrderModel extends BaseModel<PurchaseOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a purchase order model instance should use the {@link PurchaseOrder} interface instead.
	 */

	/**
	 * Returns the primary key of this purchase order.
	 *
	 * @return the primary key of this purchase order
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this purchase order.
	 *
	 * @param primaryKey the primary key of this purchase order
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the po ID of this purchase order.
	 *
	 * @return the po ID of this purchase order
	 */
	public int getPoId();

	/**
	 * Sets the po ID of this purchase order.
	 *
	 * @param PoId the po ID of this purchase order
	 */
	public void setPoId(int PoId);

	/**
	 * Returns the status of this purchase order.
	 *
	 * @return the status of this purchase order
	 */
	public int getStatus();

	/**
	 * Sets the status of this purchase order.
	 *
	 * @param Status the status of this purchase order
	 */
	public void setStatus(int Status);

	/**
	 * Returns the order date of this purchase order.
	 *
	 * @return the order date of this purchase order
	 */
	public Date getOrderDate();

	/**
	 * Sets the order date of this purchase order.
	 *
	 * @param OrderDate the order date of this purchase order
	 */
	public void setOrderDate(Date OrderDate);

	/**
	 * Returns the user ID of this purchase order.
	 *
	 * @return the user ID of this purchase order
	 */
	public int getUserId();

	/**
	 * Sets the user ID of this purchase order.
	 *
	 * @param UserId the user ID of this purchase order
	 */
	public void setUserId(int UserId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(PurchaseOrder purchaseOrder);

	public int hashCode();

	public CacheModel<PurchaseOrder> toCacheModel();

	public PurchaseOrder toEscapedModel();

	public String toString();

	public String toXmlString();
}