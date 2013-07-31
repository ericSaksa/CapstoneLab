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

package com.sb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.sb.model.InventoryClp;
import com.sb.model.ItemBandMembersClp;
import com.sb.model.ItemClp;
import com.sb.model.PurchaseItemClp;
import com.sb.model.PurchaseOrderClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"JavaTunes-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"JavaTunes-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "JavaTunes-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(InventoryClp.class.getName())) {
			return translateInputInventory(oldModel);
		}

		if (oldModelClassName.equals(ItemClp.class.getName())) {
			return translateInputItem(oldModel);
		}

		if (oldModelClassName.equals(ItemBandMembersClp.class.getName())) {
			return translateInputItemBandMembers(oldModel);
		}

		if (oldModelClassName.equals(PurchaseItemClp.class.getName())) {
			return translateInputPurchaseItem(oldModel);
		}

		if (oldModelClassName.equals(PurchaseOrderClp.class.getName())) {
			return translateInputPurchaseOrder(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputInventory(BaseModel<?> oldModel) {
		InventoryClp oldClpModel = (InventoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInventoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItem(BaseModel<?> oldModel) {
		ItemClp oldClpModel = (ItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemBandMembers(BaseModel<?> oldModel) {
		ItemBandMembersClp oldClpModel = (ItemBandMembersClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemBandMembersRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPurchaseItem(BaseModel<?> oldModel) {
		PurchaseItemClp oldClpModel = (PurchaseItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPurchaseItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPurchaseOrder(BaseModel<?> oldModel) {
		PurchaseOrderClp oldClpModel = (PurchaseOrderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPurchaseOrderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.sb.model.impl.InventoryImpl")) {
			return translateOutputInventory(oldModel);
		}

		if (oldModelClassName.equals("com.sb.model.impl.ItemImpl")) {
			return translateOutputItem(oldModel);
		}

		if (oldModelClassName.equals("com.sb.model.impl.ItemBandMembersImpl")) {
			return translateOutputItemBandMembers(oldModel);
		}

		if (oldModelClassName.equals("com.sb.model.impl.PurchaseItemImpl")) {
			return translateOutputPurchaseItem(oldModel);
		}

		if (oldModelClassName.equals("com.sb.model.impl.PurchaseOrderImpl")) {
			return translateOutputPurchaseOrder(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.sb.NoSuchInventoryException")) {
			return new com.sb.NoSuchInventoryException();
		}

		if (className.equals("com.sb.NoSuchItemException")) {
			return new com.sb.NoSuchItemException();
		}

		if (className.equals("com.sb.NoSuchItemBandMembersException")) {
			return new com.sb.NoSuchItemBandMembersException();
		}

		if (className.equals("com.sb.NoSuchPurchaseItemException")) {
			return new com.sb.NoSuchPurchaseItemException();
		}

		if (className.equals("com.sb.NoSuchPurchaseOrderException")) {
			return new com.sb.NoSuchPurchaseOrderException();
		}

		return throwable;
	}

	public static Object translateOutputInventory(BaseModel<?> oldModel) {
		InventoryClp newModel = new InventoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInventoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItem(BaseModel<?> oldModel) {
		ItemClp newModel = new ItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemBandMembers(BaseModel<?> oldModel) {
		ItemBandMembersClp newModel = new ItemBandMembersClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemBandMembersRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPurchaseItem(BaseModel<?> oldModel) {
		PurchaseItemClp newModel = new PurchaseItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPurchaseItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPurchaseOrder(BaseModel<?> oldModel) {
		PurchaseOrderClp newModel = new PurchaseOrderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPurchaseOrderRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}