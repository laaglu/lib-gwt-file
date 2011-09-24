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
package org.vectomatic.dnd;

import org.vectomatic.file.FileList;
import org.vectomatic.file.impl.FileListImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.DataTransfer;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;

public class DataTransferExt extends DataTransfer {
	protected DataTransferExt() {
	}
	private final native String getDropEffect_() /*-{
    	return this.dropEffect;
	}-*/; 
	private final native void setDropEffect_(String dropEffect) /*-{
		this.dropEffect = dropEffect;
	}-*/; 
	private final native String getEffectAllowed_() /*-{
		return this.effectAllowed;
	}-*/; 
	private final native void setEffectAllowed_(String effectAllowed) /*-{
		this.effectAllowed = effectAllowed;
	}-*/; 
	private final native FileListImpl getFiles_() /*-{
	  return this.files;
	}-*/; 
	private final native JavaScriptObject getTypes_() /*-{
	  return this.types;
	}-*/;
	private final native void addElement_(Element element) /*-{
	  this.addElement(element);
	}-*/;

	
	public final String getDropEffect() {
		return getDropEffect_();
	} 
	public final void setDropEffect(String dropEffect) {
		setDropEffect_(dropEffect);
	} 
	public final String getEffectAllowed() {
		return getEffectAllowed_();
	} 
	public final void setEffectAllowed(String effectAllowed) {
		setEffectAllowed_(effectAllowed);
	} 
	public final FileList getFiles() {
		return new FileList(getFiles_());
	}
	public final StringList getTypes() {
		return new StringList(getTypes_());
	}
	public final void setDragImage(Image image, int x, int y) {
		setDragImage(image.getElement(), x, y);
	}
	public final void addElement(UIObject uiObject) {
		addElement_(uiObject.getElement());
	}

}
