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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    amifxw0
 * @generated
 */
public class PurchaseOrderSoap implements Serializable {
	public static PurchaseOrderSoap toSoapModel(PurchaseOrder model) {
		PurchaseOrderSoap soapModel = new PurchaseOrderSoap();

		soapModel.setPoId(model.getPoId());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrderDate(model.getOrderDate());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static PurchaseOrderSoap[] toSoapModels(PurchaseOrder[] models) {
		PurchaseOrderSoap[] soapModels = new PurchaseOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseOrderSoap[][] toSoapModels(PurchaseOrder[][] models) {
		PurchaseOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseOrderSoap[] toSoapModels(List<PurchaseOrder> models) {
		List<PurchaseOrderSoap> soapModels = new ArrayList<PurchaseOrderSoap>(models.size());

		for (PurchaseOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseOrderSoap[soapModels.size()]);
	}

	public PurchaseOrderSoap() {
	}

	public int getPrimaryKey() {
		return _PoId;
	}

	public void setPrimaryKey(int pk) {
		setPoId(pk);
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

	private int _PoId;
	private int _Status;
	private Date _OrderDate;
	private int _UserId;
}