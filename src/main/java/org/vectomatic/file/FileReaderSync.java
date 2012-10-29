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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.typedarrays.shared.ArrayBuffer;

/**
 * The {@link org.vectomatic.file.FileReaderSync} interface allows to read
 * {@link org.vectomatic.file.File} or {@link org.vectomatic.file.Blob} objects
 * in a synchronous way.
 * 
 * This interface is only available in workers as it enables synchronous I/O
 * that could potentially block.
 * 
 */
public class FileReaderSync extends JavaScriptObject {
	protected FileReaderSync() {
	}
	public final native String readAsBinaryString(Blob fileBlob) /*-{
	  return this.readAsBinaryString(fileBlob);
	}-*/; 
	public final native String readAsText(Blob fileBlob) /*-{
	  return this.readAsText(fileBlob);
	}-*/; 
	public final native String readAsText(Blob fileBlob, String encoding) /*-{
	  return this.readAsText(fileBlob, encoding);
	}-*/; 
	public final native String readAsDataURL(Blob fileBlob) /*-{
	  return this.readAsDataURL(fileBlob);
	}-*/; 
	public final native ArrayBuffer readAsArrayBuffer(Blob fileBlob) /*-{
	  return this.readAsArrayBuffer(fileBlob);
	}-*/; 

}
