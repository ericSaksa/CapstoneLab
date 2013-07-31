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

import com.sb.service.PurchaseOrderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author amifxw0
 */
public class PurchaseOrderClp extends BaseModelImpl<PurchaseOrder>
	implements PurchaseOrder {
	public PurchaseOrderClp() {
	}

	public Class<?> getModelClass() {
		return PurchaseOrder.class;
	}

	public String getModelClassName() {
		return PurchaseOrder.class.getName();
	}

	public int getPrimaryKey() {
		return _PoId;
	}

	public void setPrimaryKey(int primaryKey) {
		setPoId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_PoId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PoId", getPoId());
		attributes.put("Status", getStatus());
		attributes.put("OrderDate", getOrderDate());
		attributes.put("UserId", getUserId());

		return attributes;
	}

	@Override
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

	public int getPoId() {
		return _PoId;
	}

	public void setPoId(int PoId) {
		_PoId = PoId;
	}

	public int getStatus() {
		return _Status;
	}

	public void setStatus(int Status) {
		_Status = Status;
	}

	public Date getOrderDate() {
		return _OrderDate;
	}

	public void setOrderDate(Date OrderDate) {
		_OrderDate = OrderDate;
	}

	public int getUserId() {
		return _UserId;
	}

	public void setUserId(int UserId) {
		_UserId = UserId;
	}

	public BaseModel<?> getPurchaseOrderRemoteModel() {
		return _purchaseOrderRemoteModel;
	}

	public void setPurchaseOrderRemoteModel(
		BaseModel<?> purchaseOrderRemoteModel) {
		_purchaseOrderRemoteModel = purchaseOrderRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PurchaseOrderLocalServiceUtil.addPurchaseOrder(this);
		}
		else {
			PurchaseOrderLocalServiceUtil.updatePurchaseOrder(this);
		}
	}

	@Override
	public PurchaseOrder toEscapedModel() {
		return (PurchaseOrder)Proxy.newProxyInstance(PurchaseOrder.class.getClassLoader(),
			new Class[] { PurchaseOrder.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PurchaseOrderClp clone = new PurchaseOrderClp();

		clone.setPoId(getPoId());
		clone.setStatus(getStatus());
		clone.setOrderDate(getOrderDate());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(PurchaseOrder purchaseOrder) {
		int primaryKey = purchaseOrder.getPrimaryKey();

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

		PurchaseOrderClp purchaseOrder = null;

		try {
			purchaseOrder = (PurchaseOrderClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = purchaseOrder.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{PoId=");
		sb.append(getPoId());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", OrderDate=");
		sb.append(getOrderDate());
		sb.append(", UserId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.sb.model.PurchaseOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PoId</column-name><column-value><![CDATA[");
		sb.append(getPoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>OrderDate</column-name><column-value><![CDATA[");
		sb.append(getOrderDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UserId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _PoId;
	private int _Status;
	private Date _OrderDate;
	private int _UserId;
	private BaseModel<?> _purchaseOrderRemoteModel;
}