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

import com.sb.model.PurchaseItem;
import com.sb.model.PurchaseItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PurchaseItem service. Represents a row in the &quot;PurchaseItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sb.model.PurchaseItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PurchaseItemImpl}.
 * </p>
 *
 * @author amifxw0
 * @see PurchaseItemImpl
 * @see com.sb.model.PurchaseItem
 * @see com.sb.model.PurchaseItemModel
 * @generated
 */
public class PurchaseItemModelImpl extends BaseModelImpl<PurchaseItem>
	implements PurchaseItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a purchase item model instance should use the {@link com.sb.model.PurchaseItem} interface instead.
	 */
	public static final String TABLE_NAME = "PurchaseItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PurchaseItemId", Types.INTEGER },
			{ "PoId", Types.INTEGER },
			{ "ItemId", Types.INTEGER },
			{ "Quantity", Types.INTEGER },
			{ "UnitPrice", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table PurchaseItem (PurchaseItemId INTEGER not null primary key IDENTITY,PoId INTEGER,ItemId INTEGER,Quantity INTEGER,UnitPrice DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table PurchaseItem";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sb.model.PurchaseItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sb.model.PurchaseItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sb.model.PurchaseItem"));

	public PurchaseItemModelImpl() {
	}

	public int getPrimaryKey() {
		return _PurchaseItemId;
	}

	public void setPrimaryKey(int primaryKey) {
		setPurchaseItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_PurchaseItemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	public Class<?> getModelClass() {
		return PurchaseItem.class;
	}

	public String getModelClassName() {
		return PurchaseItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PurchaseItemId", getPurchaseItemId());
		attributes.put("PoId", getPoId());
		attributes.put("ItemId", getItemId());
		attributes.put("Quantity", getQuantity());
		attributes.put("UnitPrice", getUnitPrice());

		return attributes;
	}

	@Override
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

	public int getPurchaseItemId() {
		return _PurchaseItemId;
	}

	public void setPurchaseItemId(int PurchaseItemId) {
		_PurchaseItemId = PurchaseItemId;
	}

	public int getPoId() {
		return _PoId;
	}

	public void setPoId(int PoId) {
		_PoId = PoId;
	}

	public int getItemId() {
		return _ItemId;
	}

	public void setItemId(int ItemId) {
		_ItemId = ItemId;
	}

	public int getQuantity() {
		return _Quantity;
	}

	public void setQuantity(int Quantity) {
		_Quantity = Quantity;
	}

	public double getUnitPrice() {
		return _UnitPrice;
	}

	public void setUnitPrice(double UnitPrice) {
		_UnitPrice = UnitPrice;
	}

	@Override
	public PurchaseItem toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (PurchaseItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PurchaseItemImpl purchaseItemImpl = new PurchaseItemImpl();

		purchaseItemImpl.setPurchaseItemId(getPurchaseItemId());
		purchaseItemImpl.setPoId(getPoId());
		purchaseItemImpl.setItemId(getItemId());
		purchaseItemImpl.setQuantity(getQuantity());
		purchaseItemImpl.setUnitPrice(getUnitPrice());

		purchaseItemImpl.resetOriginalValues();

		return purchaseItemImpl;
	}

	public int compareTo(PurchaseItem purchaseItem) {
		int primaryKey = purchaseItem.getPrimaryKey();

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

		PurchaseItem purchaseItem = null;

		try {
			purchaseItem = (PurchaseItem)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = purchaseItem.getPrimaryKey();

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
	}

	@Override
	public CacheModel<PurchaseItem> toCacheModel() {
		PurchaseItemCacheModel purchaseItemCacheModel = new PurchaseItemCacheModel();

		purchaseItemCacheModel.PurchaseItemId = getPurchaseItemId();

		purchaseItemCacheModel.PoId = getPoId();

		purchaseItemCacheModel.ItemId = getItemId();

		purchaseItemCacheModel.Quantity = getQuantity();

		purchaseItemCacheModel.UnitPrice = getUnitPrice();

		return purchaseItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{PurchaseItemId=");
		sb.append(getPurchaseItemId());
		sb.append(", PoId=");
		sb.append(getPoId());
		sb.append(", ItemId=");
		sb.append(getItemId());
		sb.append(", Quantity=");
		sb.append(getQuantity());
		sb.append(", UnitPrice=");
		sb.append(getUnitPrice());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.sb.model.PurchaseItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PurchaseItemId</column-name><column-value><![CDATA[");
		sb.append(getPurchaseItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PoId</column-name><column-value><![CDATA[");
		sb.append(getPoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ItemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UnitPrice</column-name><column-value><![CDATA[");
		sb.append(getUnitPrice());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PurchaseItem.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			PurchaseItem.class
		};
	private int _PurchaseItemId;
	private int _PoId;
	private int _ItemId;
	private int _Quantity;
	private double _UnitPrice;
	private PurchaseItem _escapedModelProxy;
}