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
package org.vectomatic.file.impl;

import org.vectomatic.arrays.ArrayBuffer;
import org.vectomatic.file.Blob;
import org.vectomatic.file.FileError;
import org.vectomatic.file.FileReader;

import com.google.gwt.core.client.JavaScriptObject;

public class FileReaderImpl extends JavaScriptObject {
	public static final short EMPTY = 0;
	public static final short LOADING = 1;
	public static final short DONE = 2;

	protected FileReaderImpl() {
	}
	public static final native FileReaderImpl newInstance() /*-{
      return new FileReader();
	}-*/; 
	public final native short getReadyState() /*-{
      return this.readyState;
	}-*/; 
	public final native String getStringResult() /*-{
      return this.result;
	}-*/; 
	public final native ArrayBuffer getArrayBufferResult() /*-{
    return this.result;
	}-*/; 
	public final native FileError getError() /*-{
      return this.error;
	}-*/; 
	public final native void abort() /*-{
	  this.abort();
	}-*/; 
	public final native void readAsBinaryString(Blob fileBlob) /*-{
	  this.readAsBinaryString(fileBlob);
	}-*/; 
	public final native void readAsText(Blob fileBlob) /*-{
	  this.readAsText(fileBlob);
	}-*/; 
	public final native void readAsText(Blob fileBlob, String encoding) /*-{
	  this.readAsText(fileBlob, encoding);
	}-*/; 
	public final native void readAsDataURL(Blob fileBlob) /*-{
	  this.readAsDataURL(fileBlob);
	}-*/;
	public final native void readAsArrayBuffer(Blob fileBlob) /*-{
	  this.readAsArrayBuffer(fileBlob);
	}-*/;
	public final native void registerEvent(FileReader reader, String eventType) /*-{
	    var x = this;
		var handler = function(evt) {
	        reader.@org.vectomatic.file.FileReader::dispatch(Lcom/google/gwt/dom/client/NativeEvent;)(evt);
		};
		this["on" + eventType] = handler;
	}-*/;
}
