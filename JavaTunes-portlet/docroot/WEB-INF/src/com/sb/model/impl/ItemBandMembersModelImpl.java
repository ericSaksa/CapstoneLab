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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sb.model.ItemBandMembers;
import com.sb.model.ItemBandMembersModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ItemBandMembers service. Represents a row in the &quot;Item_BandMembers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sb.model.ItemBandMembersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ItemBandMembersImpl}.
 * </p>
 *
 * @author amifxw0
 * @see ItemBandMembersImpl
 * @see com.sb.model.ItemBandMembers
 * @see com.sb.model.ItemBandMembersModel
 * @generated
 */
public class ItemBandMembersModelImpl extends BaseModelImpl<ItemBandMembers>
	implements ItemBandMembersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a item band members model instance should use the {@link com.sb.model.ItemBandMembers} interface instead.
	 */
	public static final String TABLE_NAME = "Item_BandMembers";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ItemBandMemberId", Types.INTEGER },
			{ "ItemId", Types.INTEGER },
			{ "Member", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Item_BandMembers (ItemBandMemberId INTEGER not null primary key IDENTITY,ItemId INTEGER,Member VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Item_BandMembers";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sb.model.ItemBandMembers"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sb.model.ItemBandMembers"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sb.model.ItemBandMembers"));

	public ItemBandMembersModelImpl() {
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

	public Class<?> getModelClass() {
		return ItemBandMembers.class;
	}

	public String getModelClassName() {
		return ItemBandMembers.class.getName();
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
		if (_Member == null) {
			return StringPool.BLANK;
		}
		else {
			return _Member;
		}
	}

	public void setMember(String Member) {
		_Member = Member;
	}

	@Override
	public ItemBandMembers toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ItemBandMembers)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ItemBandMembersImpl itemBandMembersImpl = new ItemBandMembersImpl();

		itemBandMembersImpl.setItemBandMemberId(getItemBandMemberId());
		itemBandMembersImpl.setItemId(getItemId());
		itemBandMembersImpl.setMember(getMember());

		itemBandMembersImpl.resetOriginalValues();

		return itemBandMembersImpl;
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

		ItemBandMembers itemBandMembers = null;

		try {
			itemBandMembers = (ItemBandMembers)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ItemBandMembers> toCacheModel() {
		ItemBandMembersCacheModel itemBandMembersCacheModel = new ItemBandMembersCacheModel();

		itemBandMembersCacheModel.ItemBandMemberId = getItemBandMemberId();

		itemBandMembersCacheModel.ItemId = getItemId();

		itemBandMembersCacheModel.Member = getMember();

		String Member = itemBandMembersCacheModel.Member;

		if ((Member != null) && (Member.length() == 0)) {
			itemBandMembersCacheModel.Member = null;
		}

		return itemBandMembersCacheModel;
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

	private static ClassLoader _classLoader = ItemBandMembers.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ItemBandMembers.class
		};
	private int _ItemBandMemberId;
	private int _ItemId;
	private String _Member;
	private ItemBandMembers _escapedModelProxy;
}