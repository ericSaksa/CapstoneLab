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
public class InventorySoap implements Serializable {
	public static InventorySoap toSoapModel(Inventory model) {
		InventorySoap soapModel = new InventorySoap();

		soapModel.setInvId(model.getInvId());
		soapModel.setItemId(model.getItemId());
		soapModel.setURL(model.getURL());
		soapModel.setNoOfLicence(model.getNoOfLicence());
		soapModel.setFileType(model.getFileType());

		return soapModel;
	}

	public static InventorySoap[] toSoapModels(Inventory[] models) {
		InventorySoap[] soapModels = new InventorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InventorySoap[][] toSoapModels(Inventory[][] models) {
		InventorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InventorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new InventorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InventorySoap[] toSoapModels(List<Inventory> models) {
		List<InventorySoap> soapModels = new ArrayList<InventorySoap>(models.size());

		for (Inventory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InventorySoap[soapModels.size()]);
	}

	public InventorySoap() {
	}

	public int getPrimaryKey() {
		return _InvId;
	}

	public void setPrimaryKey(int pk) {
		setInvId(pk);
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

	private int _InvId;
	private int _ItemId;
	private String _URL;
	private int _NoOfLicence;
	private String _FileType;
}