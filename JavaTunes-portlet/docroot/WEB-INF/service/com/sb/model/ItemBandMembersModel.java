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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ItemBandMembers service. Represents a row in the &quot;Item_BandMembers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sb.model.impl.ItemBandMembersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sb.model.impl.ItemBandMembersImpl}.
 * </p>
 *
 * @author amifxw0
 * @see ItemBandMembers
 * @see com.sb.model.impl.ItemBandMembersImpl
 * @see com.sb.model.impl.ItemBandMembersModelImpl
 * @generated
 */
public interface ItemBandMembersModel extends BaseModel<ItemBandMembers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a item band members model instance should use the {@link ItemBandMembers} interface instead.
	 */

	/**
	 * Returns the primary key of this item band members.
	 *
	 * @return the primary key of this item band members
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this item band members.
	 *
	 * @param primaryKey the primary key of this item band members
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the item band member ID of this item band members.
	 *
	 * @return the item band member ID of this item band members
	 */
	public int getItemBandMemberId();

	/**
	 * Sets the item band member ID of this item band members.
	 *
	 * @param ItemBandMemberId the item band member ID of this item band members
	 */
	public void setItemBandMemberId(int ItemBandMemberId);

	/**
	 * Returns the item ID of this item band members.
	 *
	 * @return the item ID of this item band members
	 */
	public int getItemId();

	/**
	 * Sets the item ID of this item band members.
	 *
	 * @param ItemId the item ID of this item band members
	 */
	public void setItemId(int ItemId);

	/**
	 * Returns the member of this item band members.
	 *
	 * @return the member of this item band members
	 */
	@AutoEscape
	public String getMember();

	/**
	 * Sets the member of this item band members.
	 *
	 * @param Member the member of this item band members
	 */
	public void setMember(String Member);

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

	public int compareTo(ItemBandMembers itemBandMembers);

	public int hashCode();

	public CacheModel<ItemBandMembers> toCacheModel();

	public ItemBandMembers toEscapedModel();

	public String toString();

	public String toXmlString();
}