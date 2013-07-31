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

import com.sb.service.ItemBandMembersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amifxw0
 */
public class ItemBandMembersClp extends BaseModelImpl<ItemBandMembers>
	implements ItemBandMembers {
	public ItemBandMembersClp() {
	}

	public Class<?> getModelClass() {
		return ItemBandMembers.class;
	}

	public String getModelClassName() {
		return ItemBandMembers.class.getName();
	}

	public int getPrimaryKey() {
		return _ItemBandMemberId;
	}

	public void setPrimaryKey(int primaryKey) {
		setItemBandMemberId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_ItemBandMemberId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ItemBandMemberId", getItemBandMemberId());
		attributes.put("ItemId", getItemId());
		attributes.put("Member", getMember());

		return attributes;
	}

	@Override
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

	public int getItemBandMemberId() {
		return _ItemBandMemberId;
	}

	public void setItemBandMemberId(int ItemBandMemberId) {
		_ItemBandMemberId = ItemBandMemberId;
	}

	public int getItemId() {
		return _ItemId;
	}

	public void setItemId(int ItemId) {
		_ItemId = ItemId;
	}

	public String getMember() {
		return _Member;
	}

	public void setMember(String Member) {
		_Member = Member;
	}

	public BaseModel<?> getItemBandMembersRemoteModel() {
		return _itemBandMembersRemoteModel;
	}

	public void setItemBandMembersRemoteModel(
		BaseModel<?> itemBandMembersRemoteModel) {
		_itemBandMembersRemoteModel = itemBandMembersRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemBandMembersLocalServiceUtil.addItemBandMembers(this);
		}
		else {
			ItemBandMembersLocalServiceUtil.updateItemBandMembers(this);
		}
	}

	@Override
	public ItemBandMembers toEscapedModel() {
		return (ItemBandMembers)Proxy.newProxyInstance(ItemBandMembers.class.getClassLoader(),
			new Class[] { ItemBandMembers.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemBandMembersClp clone = new ItemBandMembersClp();

		clone.setItemBandMemberId(getItemBandMemberId());
		clone.setItemId(getItemId());
		clone.setMember(getMember());

		return clone;
	}

	public int compareTo(ItemBandMembers itemBandMembers) {
		int primaryKey = itemBandMembers.getPrimaryKey();

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

		ItemBandMembersClp itemBandMembers = null;

		try {
			itemBandMembers = (ItemBandMembersClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = itemBandMembers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{ItemBandMemberId=");
		sb.append(getItemBandMemberId());
		sb.append(", ItemId=");
		sb.append(getItemId());
		sb.append(", Member=");
		sb.append(getMember());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.sb.model.ItemBandMembers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ItemBandMemberId</column-name><column-value><![CDATA[");
		sb.append(getItemBandMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ItemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Member</column-name><column-value><![CDATA[");
		sb.append(getMember());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ItemBandMemberId;
	private int _ItemId;
	private String _Member;
	private BaseModel<?> _itemBandMembersRemoteModel;
}