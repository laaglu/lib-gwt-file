/**********************************************
 * Copyright (C) 2011 Lukas laag
 * This file is part of lib-gwt-file.
 * 
 * lib-gwt-file is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * lib-gwt-file is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with lib-gwt-file.  If not, see http://www.gnu.org/licenses/
 **********************************************/
package org.vectomatic.dnd.impl;

import org.vectomatic.file.impl.FileListImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class DataTransferImpl extends JavaScriptObject {
	protected DataTransferImpl() {
	}
	public final native String getDropEffect() /*-{
    	return this.dropEffect;
	}-*/; 
	public final native void setDropEffect(String dropEffect) /*-{
		this.dropEffect = dropEffect;
	}-*/; 
	public final native String getEffectAllowed() /*-{
		return this.effectAllowed;
	}-*/; 
	public final native void setEffectAllowed(String effectAllowed) /*-{
		this.effectAllowed = effectAllowed;
	}-*/; 
	public final native void clearData() /*-{
		this.clearData();
	}-*/; 
	public final native void clearData(String format) /*-{
		this.clearData(format);
	}-*/; 
	public final native void setData(String format, String data) /*-{
		this.setData(format, data);
	}-*/; 
	public final native String getData(String format) /*-{
		return this.getData(format);
	}-*/; 
	public final native FileListImpl getFiles() /*-{
	  return this.files;
	}-*/; 
	public final native JavaScriptObject getTypes() /*-{
	  return this.types;
	}-*/;
	public final native void setDragImage(Element element, int x, int y) /*-{
	  this.setDragImage(element, x, y);
	}-*/;
	public final native void addElement(Element element) /*-{
	  this.addElement(element);
	}-*/;
}
