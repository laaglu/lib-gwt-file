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
/**
 * Documentation is adapted from W3C spec and content available from
 * http://developer.mozilla.org under http://creativecommons.org/licenses/by-sa/2.5/
 */
package org.vectomatic.file;

import com.google.gwt.core.client.JsDate;

/**
 * The File object provides information about and access to the contents of
 * files. These are generally retrieved from a
 * {@link org.vectomatic.file.FileList} object returned as a result of a user
 * selecting files using the input element, or from a drag and drop operation's
 * {@link org.vectomatic.dnd.DataTransferExt} object.
 */
public class File extends Blob {
	protected File() {
	}
	/**
	 * The name of the file referenced by the File object.
	 * @return The name of the file referenced by the File object.
	 */
	public final native String getName() /*-{
      return this.name;
	}-*/;
	/**
	 * The last modified date of the file. If unavailable, returns null.
	 * @return The last modified date of the file.
	 */
	public final native JsDate getLastModifiedDate() /*-{
      return this.lastModifiedDate;
	}-*/; 
}
