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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sb.model.PurchaseOrder;
import com.sb.model.PurchaseOrderModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PurchaseOrder service. Represents a row in the &quot;PurchaseOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sb.model.PurchaseOrderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PurchaseOrderImpl}.
 * </p>
 *
 * @author amifxw0
 * @see PurchaseOrderImpl
 * @see com.sb.model.PurchaseOrder
 * @see com.sb.model.PurchaseOrderModel
 * @generated
 */
public class PurchaseOrderModelImpl extends BaseModelImpl<PurchaseOrder>
	implements PurchaseOrderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a purchase order model instance should use the {@link com.sb.model.PurchaseOrder} interface instead.
	 */
	public static final String TABLE_NAME = "PurchaseOrder";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PoId", Types.INTEGER },
			{ "Status", Types.INTEGER },
			{ "OrderDate", Types.TIMESTAMP },
			{ "UserId", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table PurchaseOrder (PoId INTEGER not null primary key IDENTITY,Status INTEGER,OrderDate DATE null,UserId INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table PurchaseOrder";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sb.model.PurchaseOrder"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sb.model.PurchaseOrder"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sb.model.PurchaseOrder"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sb.model.PurchaseOrder"));

	public PurchaseOrderModelImpl() {
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

	public Class<?> getModelClass() {
		return PurchaseOrder.class;
	}

	public String getModelClassName() {
		return PurchaseOrder.class.getName();
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
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _UserId;
		}

		_UserId = UserId;
	}

	public int getOriginalUserId() {
		return _originalUserId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public PurchaseOrder toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (PurchaseOrder)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PurchaseOrderImpl purchaseOrderImpl = new PurchaseOrderImpl();

		purchaseOrderImpl.setPoId(getPoId());
		purchaseOrderImpl.setStatus(getStatus());
		purchaseOrderImpl.setOrderDate(getOrderDate());
		purchaseOrderImpl.setUserId(getUserId());

		purchaseOrderImpl.resetOriginalValues();

		return purchaseOrderImpl;
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

		PurchaseOrder purchaseOrder = null;

		try {
			purchaseOrder = (PurchaseOrder)obj;
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
	public void resetOriginalValues() {
		PurchaseOrderModelImpl purchaseOrderModelImpl = this;

		purchaseOrderModelImpl._originalUserId = purchaseOrderModelImpl._UserId;

		purchaseOrderModelImpl._setOriginalUserId = false;

		purchaseOrderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PurchaseOrder> toCacheModel() {
		PurchaseOrderCacheModel purchaseOrderCacheModel = new PurchaseOrderCacheModel();

		purchaseOrderCacheModel.PoId = getPoId();

		purchaseOrderCacheModel.Status = getStatus();

		Date OrderDate = getOrderDate();

		if (OrderDate != null) {
			purchaseOrderCacheModel.OrderDate = OrderDate.getTime();
		}
		else {
			purchaseOrderCacheModel.OrderDate = Long.MIN_VALUE;
		}

		purchaseOrderCacheModel.UserId = getUserId();

		return purchaseOrderCacheModel;
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

	private static ClassLoader _classLoader = PurchaseOrder.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			PurchaseOrder.class
		};
	private int _PoId;
	private int _Status;
	private Date _OrderDate;
	private int _UserId;
	private int _originalUserId;
	private boolean _setOriginalUserId;
	private long _columnBitmask;
	private PurchaseOrder _escapedModelProxy;
}