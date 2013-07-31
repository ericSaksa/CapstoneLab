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

import com.sb.service.PurchaseItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amifxw0
 */
public class PurchaseItemClp extends BaseModelImpl<PurchaseItem>
	implements PurchaseItem {
	public PurchaseItemClp() {
	}

	public Class<?> getModelClass() {
		return PurchaseItem.class;
	}

	public String getModelClassName() {
		return PurchaseItem.class.getName();
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

	public BaseModel<?> getPurchaseItemRemoteModel() {
		return _purchaseItemRemoteModel;
	}

	public void setPurchaseItemRemoteModel(BaseModel<?> purchaseItemRemoteModel) {
		_purchaseItemRemoteModel = purchaseItemRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PurchaseItemLocalServiceUtil.addPurchaseItem(this);
		}
		else {
			PurchaseItemLocalServiceUtil.updatePurchaseItem(this);
		}
	}

	@Override
	public PurchaseItem toEscapedModel() {
		return (PurchaseItem)Proxy.newProxyInstance(PurchaseItem.class.getClassLoader(),
			new Class[] { PurchaseItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PurchaseItemClp clone = new PurchaseItemClp();

		clone.setPurchaseItemId(getPurchaseItemId());
		clone.setPoId(getPoId());
		clone.setItemId(getItemId());
		clone.setQuantity(getQuantity());
		clone.setUnitPrice(getUnitPrice());

		return clone;
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

		PurchaseItemClp purchaseItem = null;

		try {
			purchaseItem = (PurchaseItemClp)obj;
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

	private int _PurchaseItemId;
	private int _PoId;
	private int _ItemId;
	private int _Quantity;
	private double _UnitPrice;
	private BaseModel<?> _purchaseItemRemoteModel;
}