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

import org.vectomatic.dnd.impl.DataTransferImpl;
import org.vectomatic.file.FileList;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;

public class DataTransfer {
	protected DataTransferImpl impl;
	public DataTransfer(DataTransferImpl impl) {
		this.impl = impl;
	}
	public String getDropEffect() {
		return impl.getDropEffect();
	} 
	public void setDropEffect(String dropEffect) {
		impl.setDropEffect(dropEffect);
	} 
	public String getEffectAllowed() {
		return impl.getEffectAllowed();
	} 
	public void setEffectAllowed(String effectAllowed) {
		impl.setEffectAllowed(effectAllowed);
	} 
	public void clearData() {
		impl.clearData();
	} 
	public void clearData(String format) {
		impl.clearData(format);
	} 
	public void setData(String format, String data) {
		impl.setData(format, data);
	} 
	public String getData(String format) {
		return impl.getData(format);
	}
	public FileList getFiles() {
		return new FileList(impl.getFiles());
	}
	public StringList getTypes() {
		return new StringList(impl.getTypes());
	}
	public void setDragImage(Image image, int x, int y) {
		impl.setDragImage(image.getElement(), x, y);
	}
	public void addElement(UIObject uiObject) {
		impl.addElement(uiObject.getElement());
	}

}
