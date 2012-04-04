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

import org.vectomatic.file.impl.SliceImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Blob object represents a file-like object of raw data. It's used to
 * represent data that isn't necessarily in a JavaScript-native format. The
 * {@link org.vectomatic.file.File} interface is based on it, inheriting the
 * Blob's functionality and expanding it to support files on the user's system.
 */
public class Blob extends JavaScriptObject {
	private static SliceImpl sliceImpl;
	/**
	 * Temporary fix because the File API slice methods are currently prefixed.
	 * @return An implementation of the slice methods
	 */
	private static final SliceImpl getSliceImpl() {
		if (sliceImpl == null) {
			sliceImpl = GWT.create(SliceImpl.class);
		}
		return sliceImpl;
	}
	
	protected Blob() {
	}

	/**
	 * The size, in bytes, of the data contained in the Blob object.
	 * 
	 * @return The size, in bytes, of the data contained in the Blob object.
	 */
	public final long getSize() {
		String size = getSize_();
		return Long.parseLong(size);
	}
	
	private final native String getSize_() /*-{
      return "" + this.size;
	}-*/;
	
	
	/**
	 * An ASCII-encoded string, in all lower case, indicating the MIME type of
	 * the data contained in the Blob. If the type is unknown, this string is
	 * empty.
	 * 
	 * @return The MIME type of the data contained in the Blob
	 */
	public final native String getType() /*-{
      return this.type;
	}-*/;
	
	/**
	 * Returns a new Blob object containing a full copy of the data in the
	 * source Blob.
	 * 
	 * @return The new Blob object
	 */
	public final Blob slice() {
      return getSliceImpl().slice(this);
	}

	/**
	 * Returns a new Blob object containing the data in the specified range of
	 * bytes of the source Blob.
	 * 
	 * @param start
	 *            An index into the Blob indicating the first byte to copy into
	 *            the new Blob. If you specify a negative value, it's treated as
	 *            an offset from the end of the string toward the beginning (for
	 *            example, -10 would be the 10th from last byte in the Blob).
	 * @return The new Blob object
	 */
	public final Blob slice(long start) {
      return getSliceImpl().slice(this, start);
	}
	
	/**
	 * Returns a new Blob object containing the data in the specified range of
	 * bytes of the source Blob.
	 * 
	 * @param start
	 *            An index into the Blob indicating the first byte to copy into
	 *            the new Blob. If you specify a negative value, it's treated as
	 *            an offset from the end of the string toward the beginning (for
	 *            example, -10 would be the 10th from last byte in the Blob).
	 * @param end
	 *            An index into the Blob indicating the last byte to copy into
	 *            the new Blob. If you specify a negative value, it's treated as
	 *            an offset from the end of the string toward the beginning (for
	 *            example, -10 would be the 10th from last byte in the Blob).
	 * @return The new Blob object
	 */
	public final Blob slice(long start, long end) {
      return getSliceImpl().slice(this, start, end);
	}
	
	/**
	 * Returns a new Blob object containing the data in the specified range of
	 * bytes of the source Blob.
	 * 
	 * @param start
	 *            An index into the Blob indicating the first byte to copy into
	 *            the new Blob. If you specify a negative value, it's treated as
	 *            an offset from the end of the string toward the beginning (for
	 *            example, -10 would be the 10th from last byte in the Blob).
	 * @param end
	 *            An index into the Blob indicating the last byte to copy into
	 *            the new Blob. If you specify a negative value, it's treated as
	 *            an offset from the end of the string toward the beginning (for
	 *            example, -10 would be the 10th from last byte in the Blob).
	 * @param contentType
	 *            The content type to assign to the new Blob; this will be the
	 *            value of its type property.
	 * @return The new Blob object
	 */
	public final Blob slice(long start, long end, String contentType) {
      return getSliceImpl().slice(this, start, end, contentType);
	}

	/**
	 * Creates a new object URL, whose lifetime is tied to the document in the
	 * window on which it was created. The new object URL represents this
	 * specified Blob object.
	 * 
	 * @return a new object URL representing this blob.
	 */
	public final native String createObjectURL() /*-{
	  return $wnd.URL.createObjectURL(this);
	}-*/;

	/**
	 * Releases an existing object URL which was previously created by calling
	 * {@link #createObjectURL()} . Call this method when you've finished using
	 * a object URL, in order to let the browser know it doesn't need to keep
	 * the reference to the file any longer.
	 * 
	 * @param url
	 *            a string representing the object URL that was created by
	 *            calling {@link #createObjectURL()}
	 */
	public final native void revokeObjectURL(String url) /*-{
	  $wnd.URL.revokeObjectURL(url);
	}-*/;
}
