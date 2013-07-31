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
public class PurchaseItemSoap implements Serializable {
	public static PurchaseItemSoap toSoapModel(PurchaseItem model) {
		PurchaseItemSoap soapModel = new PurchaseItemSoap();

		soapModel.setPurchaseItemId(model.getPurchaseItemId());
		soapModel.setPoId(model.getPoId());
		soapModel.setItemId(model.getItemId());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setUnitPrice(model.getUnitPrice());

		return soapModel;
	}

	public static PurchaseItemSoap[] toSoapModels(PurchaseItem[] models) {
		PurchaseItemSoap[] soapModels = new PurchaseItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseItemSoap[][] toSoapModels(PurchaseItem[][] models) {
		PurchaseItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseItemSoap[] toSoapModels(List<PurchaseItem> models) {
		List<PurchaseItemSoap> soapModels = new ArrayList<PurchaseItemSoap>(models.size());

		for (PurchaseItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseItemSoap[soapModels.size()]);
	}

	public PurchaseItemSoap() {
	}

	public int getPrimaryKey() {
		return _PurchaseItemId;
	}

	public void setPrimaryKey(int pk) {
		setPurchaseItemId(pk);
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

	private int _PurchaseItemId;
	private int _PoId;
	private int _ItemId;
	private int _Quantity;
	private double _UnitPrice;
}