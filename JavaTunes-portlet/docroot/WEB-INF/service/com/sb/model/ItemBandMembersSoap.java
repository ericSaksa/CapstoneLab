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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    amifxw0
 * @generated
 */
public class ItemBandMembersSoap implements Serializable {
	public static ItemBandMembersSoap toSoapModel(ItemBandMembers model) {
		ItemBandMembersSoap soapModel = new ItemBandMembersSoap();

		soapModel.setItemBandMemberId(model.getItemBandMemberId());
		soapModel.setItemId(model.getItemId());
		soapModel.setMember(model.getMember());

		return soapModel;
	}

	public static ItemBandMembersSoap[] toSoapModels(ItemBandMembers[] models) {
		ItemBandMembersSoap[] soapModels = new ItemBandMembersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemBandMembersSoap[][] toSoapModels(
		ItemBandMembers[][] models) {
		ItemBandMembersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemBandMembersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemBandMembersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemBandMembersSoap[] toSoapModels(
		List<ItemBandMembers> models) {
		List<ItemBandMembersSoap> soapModels = new ArrayList<ItemBandMembersSoap>(models.size());

		for (ItemBandMembers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemBandMembersSoap[soapModels.size()]);
	}

	public ItemBandMembersSoap() {
	}

	public int getPrimaryKey() {
		return _ItemBandMemberId;
	}

	public void setPrimaryKey(int pk) {
		setItemBandMemberId(pk);
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

	private int _ItemBandMemberId;
	private int _ItemId;
	private String _Member;
}