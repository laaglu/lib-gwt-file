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
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * FileUpload widget with support for multiple files.
 * @author laaglu
 */
public class FileUploadExt extends Widget implements HasName, HasChangeHandlers, HasEnabled {
	/**
	 * Constructor. This constructors creates instances
	 * with multiple file support activated by default.
	 */
	public FileUploadExt() {
		this(true);
	}
	/**
	 * Constructor.
	 * @param multiple true to active multiple file upload support, false otherwise 
	 */
	public FileUploadExt(boolean multiple) {
		this(Document.get().createFileInputElement(), multiple);
	}
	
	protected FileUploadExt(Element element, boolean multiple) {
	    setElement(element);
	    setStyleName("gwt-FileUpload");
		setMultiple(multiple);
	}
	
	/**
	 * Returns true if support for multiple file upload is activated, false otherwise.
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
	 * @param value true to activate support for multiple file upload, false otherwise.
	 */
	public void setMultiple(boolean value) {
		setMultiple(getElement(), value);
	} 
	private static final native void setMultiple(Element element, boolean value) /*-{
	  element.multiple = value;
	}-*/; 
	/**
	 * Returns the files selected by the end-user.
	 * @return the files selected by the end-user.
	 */
	public FileList getFiles() {
		return new FileList(getFiles(getElement()));
	}
	private static final native FileListImpl getFiles(Element element) /*-{
	  return element.files;
	}-*/;
	/**
	 * Shows the file selection box.
	 */
	public void click() {
		click(getElement());
	}
	private static final native void click(Element element) /*-{
	  element.click();
	}-*/; 
	
	@Override
	public void onBrowserEvent(Event event) {
		// Fix webkit bug
		// input file will not fire change event if one chooses the same file twice in a row
		super.onBrowserEvent(event);
		Element parent = getElement().getParentElement();
		Element nextSibling = getElement().getNextSiblingElement();
		FormElement form = Document.get().createFormElement();
		form.appendChild(getElement());
		form.reset();
		parent.insertBefore(getElement(), nextSibling);
	}
	
	//====================================================
	//
	//            Copied from GWT's FileUpload
	//
	//====================================================
	
	/**
	 * Creates a FileUploadExt widget that wraps an existing &lt;input
	 * type='file'&gt; element.
	 * 
	 * This element must already be attached to the document. If the element is
	 * removed from the document, you must call
	 * {@link RootPanel#detachNow(Widget)}.
	 * 
	 * @param element the element to be wrapped
	 * @param multiple true to active multiple file upload support, false otherwise 
	 */
	public static FileUploadExt wrap(Element element, boolean multiple) {
		// Assert that the element is attached.
		assert Document.get().getBody().isOrHasChild(element);

		FileUploadExt fileUpload = new FileUploadExt(element, multiple);

		// Mark it attached and remember it for cleanup.
		fileUpload.onAttach();
		RootPanel.detachOnWindowClose(fileUpload);

		return fileUpload;
	}
	
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return addDomHandler(handler, ChangeEvent.getType());
	}

	/**
	 * Gets the filename selected by the user. This property has no mutator, as
	 * browser security restrictions preclude setting it.
	 * 
	 * @return the widget's filename
	 */
	public String getFilename() {
		return getInputElement().getValue();
	}

	public String getName() {
		return getInputElement().getName();
	}

	/**
	 * Gets whether this widget is enabled.
	 * 
	 * @return <code>true</code> if the widget is enabled
	 */
	public boolean isEnabled() {
		return !getElement().getPropertyBoolean("disabled");
	}	
	/**
	 * Sets whether this widget is enabled.
	 * 
	 * @param enabled
	 *            <code>true</code> to enable the widget, <code>false</code> to
	 *            disable it
	 */
	public void setEnabled(boolean enabled) {
		getElement().setPropertyBoolean("disabled", !enabled);
	}

	public void setName(String name) {
		getInputElement().setName(name);
	}

	private InputElement getInputElement() {
		return getElement().cast();
	}
}
