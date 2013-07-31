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
public class ItemSoap implements Serializable {
	public static ItemSoap toSoapModel(Item model) {
		ItemSoap soapModel = new ItemSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setNum(model.getNum());
		soapModel.setTitle(model.getTitle());
		soapModel.setArtist(model.getArtist());
		soapModel.setReleaseDate(model.getReleaseDate());
		soapModel.setListPrice(model.getListPrice());
		soapModel.setPrice(model.getPrice());
		soapModel.setVersion(model.getVersion());

		return soapModel;
	}

	public static ItemSoap[] toSoapModels(Item[] models) {
		ItemSoap[] soapModels = new ItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemSoap[][] toSoapModels(Item[][] models) {
		ItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemSoap[] toSoapModels(List<Item> models) {
		List<ItemSoap> soapModels = new ArrayList<ItemSoap>(models.size());

		for (Item model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemSoap[soapModels.size()]);
	}

	public ItemSoap() {
	}

	public int getPrimaryKey() {
		return _ItemId;
	}

	public void setPrimaryKey(int pk) {
		setItemId(pk);
	}

	public int getItemId() {
		return _ItemId;
	}

	public void setItemId(int ItemId) {
		_ItemId = ItemId;
	}

	public String getNum() {
		return _Num;
	}

	public void setNum(String Num) {
		_Num = Num;
	}

	public String getTitle() {
		return _Title;
	}

	public void setTitle(String Title) {
		_Title = Title;
	}

	public String getArtist() {
		return _Artist;
	}

	public void setArtist(String Artist) {
		_Artist = Artist;
	}

	public Date getReleaseDate() {
		return _ReleaseDate;
	}

	public void setReleaseDate(Date ReleaseDate) {
		_ReleaseDate = ReleaseDate;
	}

	public double getListPrice() {
		return _ListPrice;
	}

	public void setListPrice(double ListPrice) {
		_ListPrice = ListPrice;
	}

	public double getPrice() {
		return _Price;
	}

	public void setPrice(double Price) {
		_Price = Price;
	}

	public int getVersion() {
		return _Version;
	}

	public void setVersion(int Version) {
		_Version = Version;
	}

	private int _ItemId;
	private String _Num;
	private String _Title;
	private String _Artist;
	private Date _ReleaseDate;
	private double _ListPrice;
	private double _Price;
	private int _Version;
}