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
package org.vectomatic.file;

import org.vectomatic.file.impl.FileListImpl;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FileUpload;

/**
 * FileUpload widget with support for multiple files.
 * 
 * @author laaglu
 */
public class FileUploadExt extends FileUpload {
	/**
	 * Constructor. This constructors creates instances with multiple file
	 * support activated by default.
	 */
	public FileUploadExt() {
		this(false);
	}

	/**
	 * Constructor.
	 * 
	 * @param multiple
	 *            true to active multiple file upload support, false otherwise
	 */
	public FileUploadExt(boolean multiple) {
		super();
		setMultiple(multiple);
	}

	protected FileUploadExt(Element element, boolean multiple) {
		super(element);
		setMultiple(multiple);
	}

	/**
	 * Returns true if support for multiple file upload is activated, false
	 * otherwise.
	 * 
	 * @return true if support for multiple file upload is activated
	 */
	public boolean isMultiple() {
		return isMultiple(getElement());
	}

	private static final native boolean isMultiple(Element element) /*-{
																	return element.multiple;
																	}-*/;

	/**
	 * Sets support for multiple file upload.
	 * 
	 * @param value
	 *            true to activate support for multiple file upload, false
	 *            otherwise.
	 */
	public void setMultiple(boolean value) {
		setMultiple(getElement(), value);
	}

	private static final native void setMultiple(Element element, boolean value) /*-{
																					element.multiple = value;
																					}-*/;

	/**
	 * Returns the files selected by the end-user.
	 * 
	 * @return the files selected by the end-user.
	 */
	public FileList getFiles() {
		return new FileList(getFiles(getElement()));
	}

	private static final native FileListImpl getFiles(Element element) /*-{
																		return element.files;
																		}-*/;

	/**
	 * Fix webkit bug input file will not fire change event if one chooses the
	 * same file twice in a row
	 */
	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
		Element parent = getElement().getParentElement();
		Element nextSibling = getElement().getNextSiblingElement();
		FormElement form = Document.get().createFormElement();
		form.appendChild(getElement());
		form.reset();
		parent.insertBefore(getElement(), nextSibling);
	}
}
