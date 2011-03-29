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


public enum ErrorCode {
	NOT_FOUND_ERR {
		public short getValue() {
			return 8;
		}
	},
	SECURITY_ERR {
		public short getValue() {
			return 18;
		}
	},
	ABORT_ERR {
		public short getValue() {
			return 20;
		}
	},
	NOT_READABLE_ERR {
		public short getValue() {
			return 24;
		}
	},
	ENCODING_ERR {
		public short getValue() {
			return 26;
		}
	};
	public abstract short getValue();
	public static ErrorCode fromValue(short value) {
		switch(value) {
		case 8:
			return NOT_FOUND_ERR;
		case 18:
			return SECURITY_ERR;
		case 20:
			return ABORT_ERR;
		case 24:
			return NOT_READABLE_ERR;
		case 26:
			return ENCODING_ERR;
		default:
			throw new IllegalStateException("Bad error code value " + value);
		}
	}
}
