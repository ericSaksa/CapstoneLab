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

import com.sb.service.InventoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amifxw0
 */
public class InventoryClp extends BaseModelImpl<Inventory> implements Inventory {
	public InventoryClp() {
	}

	public Class<?> getModelClass() {
		return Inventory.class;
	}

	public String getModelClassName() {
		return Inventory.class.getName();
	}

	public int getPrimaryKey() {
		return _InvId;
	}

	public void setPrimaryKey(int primaryKey) {
		setInvId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_InvId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("InvId", getInvId());
		attributes.put("ItemId", getItemId());
		attributes.put("URL", getURL());
		attributes.put("NoOfLicence", getNoOfLicence());
		attributes.put("FileType", getFileType());

		return attributes;
	}

	@Override
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

	public int getInvId() {
		return _InvId;
	}

	public void setInvId(int InvId) {
		_InvId = InvId;
	}

	public int getItemId() {
		return _ItemId;
	}

	public void setItemId(int ItemId) {
		_ItemId = ItemId;
	}

	public String getURL() {
		return _URL;
	}

	public void setURL(String URL) {
		_URL = URL;
	}

	public int getNoOfLicence() {
		return _NoOfLicence;
	}

	public void setNoOfLicence(int NoOfLicence) {
		_NoOfLicence = NoOfLicence;
	}

	public String getFileType() {
		return _FileType;
	}

	public void setFileType(String FileType) {
		_FileType = FileType;
	}

	public BaseModel<?> getInventoryRemoteModel() {
		return _inventoryRemoteModel;
	}

	public void setInventoryRemoteModel(BaseModel<?> inventoryRemoteModel) {
		_inventoryRemoteModel = inventoryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			InventoryLocalServiceUtil.addInventory(this);
		}
		else {
			InventoryLocalServiceUtil.updateInventory(this);
		}
	}

	@Override
	public Inventory toEscapedModel() {
		return (Inventory)Proxy.newProxyInstance(Inventory.class.getClassLoader(),
			new Class[] { Inventory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InventoryClp clone = new InventoryClp();

		clone.setInvId(getInvId());
		clone.setItemId(getItemId());
		clone.setURL(getURL());
		clone.setNoOfLicence(getNoOfLicence());
		clone.setFileType(getFileType());

		return clone;
	}

	public int compareTo(Inventory inventory) {
		int primaryKey = inventory.getPrimaryKey();

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

		InventoryClp inventory = null;

		try {
			inventory = (InventoryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = inventory.getPrimaryKey();

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

		sb.append("{InvId=");
		sb.append(getInvId());
		sb.append(", ItemId=");
		sb.append(getItemId());
		sb.append(", URL=");
		sb.append(getURL());
		sb.append(", NoOfLicence=");
		sb.append(getNoOfLicence());
		sb.append(", FileType=");
		sb.append(getFileType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.sb.model.Inventory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>InvId</column-name><column-value><![CDATA[");
		sb.append(getInvId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ItemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>URL</column-name><column-value><![CDATA[");
		sb.append(getURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NoOfLicence</column-name><column-value><![CDATA[");
		sb.append(getNoOfLicence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FileType</column-name><column-value><![CDATA[");
		sb.append(getFileType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _InvId;
	private int _ItemId;
	private String _URL;
	private int _NoOfLicence;
	private String _FileType;
	private BaseModel<?> _inventoryRemoteModel;
}