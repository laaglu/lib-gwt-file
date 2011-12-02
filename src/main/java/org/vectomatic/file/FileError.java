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

/**
 * Represents an error that occurs while using the
 * {@link org.vectomatic.file.FileReader} interface.
 */
public class FileError extends JavaScriptObject {
	/**
	 * Constructor.
	 */
	protected FileError() {
	}
	/**
	 * Returns a constant representing the error code in Java.
	 * @return a constant representing the error code in Java.
	 */
	public final ErrorCode getCode() {
      return ErrorCode.fromValue(getCode_());
	}
	private final native short getCode_() /*-{
      return this.code;
	}-*/; 
}
