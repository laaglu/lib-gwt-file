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

/**
 * Constants to represent error that occurs while using the
 * {@link org.vectomatic.file.FileReader} interface.
 */
public enum ErrorCode {
	/**
	 * File not found.
	 */
	NOT_FOUND_ERR {
		public short getValue() {
			return 1;
		}
	},
	/**
	 * The file could not be accessed for security reasons.
	 */
	SECURITY_ERR {
		public short getValue() {
			return 2;
		}
	},
	/**
	 * The file operation was aborted, probably due to a call to the FileReader abort() method.
	 */
	ABORT_ERR {
		public short getValue() {
			return 3;
		}
	},
	/**
	 * File could not be read.
	 */
	NOT_READABLE_ERR {
		public short getValue() {
			return 4;
		}
	},
	/**
	 * The file data cannot be accurately represented in a data URL.
	 */
	ENCODING_ERR {
		public short getValue() {
			return 5;
		}
	};
	/**
	 * Returns the numerical javascript value corresponding
	 * to this constant.
	 * @return the numerical javascript value corresponding
	 * to this constant.
	 */
	public abstract short getValue();
	/**
	 * Converts a javascript error code to a java constant
	 * @param value a javascript error code.
	 * @return the corresponding java constant.
	 */
	public static ErrorCode fromValue(short value) {
		switch(value) {
			case 1:
				return NOT_FOUND_ERR;
			case 2:
				return SECURITY_ERR;
			case 3:
				return ABORT_ERR;
			case 4:
				return NOT_READABLE_ERR;
			case 5:
				return ENCODING_ERR;
			default:
				throw new IllegalStateException("Bad error code value " + value);
		}
	}
}
