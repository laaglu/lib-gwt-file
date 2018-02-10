/**********************************************
 * Copyright (C) 2015 Shaun Ediger
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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.typedarrays.client.ArrayBufferNative;
import com.google.gwt.typedarrays.client.ArrayBufferViewNative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Static utility methods pertaining to the creation of native {@link Blob} instances.
 *
 * Creation methods (except for  {@link #newBlob()}) accept an iterable of type {@link Object}.
 * An {@link IllegalArgumentException} will be thrown if an individual element type is not one of the following: {@link String},
 * {@link ArrayBufferNative}, {@link ArrayBufferViewNative}, or {@link Blob}.
 *
 * Pass a content type (e.g. "text/plain;charset=UTF-8") or null to defer to browser default, which is an empty string.
 *
 * @author Shaun Ediger
 */
public class Blobs {

	private static Set<Class<? extends JavaScriptObject>> acceptableJavaScriptObjectTypes = new HashSet<Class<? extends JavaScriptObject>>(Arrays.asList(ArrayBufferNative.class, ArrayBufferViewNative.class, Blob.class));

	/**
	 * Creates a {@link Blob} instance consisting of 0 bytes.
	 *
	 * @return
	 */
	public static Blob newBlob() {
		return createBlob();
	}

	public static Blob newBlob(Iterator<Object> blobParts) {
		return newBlob(blobParts, null);
	}

	public static Blob newBlob(Iterator<Object> blobParts, String contentType) {
		List<Object> blobPartsIterable = new ArrayList<Object>();
		while (blobParts.hasNext()) {
			blobPartsIterable.add(blobParts.next());
		}
		return newBlob(blobPartsIterable, contentType);
	}

	public static Blob newBlob(Iterable<Object> blobParts) {
		return newBlob(blobParts, null);
	}

	public static Blob newBlob(Iterable<Object> blobParts, String contentType) {
		checkAcceptable(blobParts);
		if (contentType == null) {
			return createBlob(createBlobPartsArray(blobParts));
		} else {
			return createBlob(createBlobPartsArray(blobParts), contentType);
		}
	}

	private static native Blob createBlob() /*-{
		return new Blob();
	}-*/;

	private static native Blob createBlob(JsArrayMixed blobParts) /*-{
		return new Blob(blobParts);
	}-*/;

	private static native Blob createBlob(JsArrayMixed blobParts, String contentType) /*-{
		return new Blob(blobParts, {type: contentType});
	}-*/;

	private static JsArrayMixed createBlobPartsArray(Iterable<Object> blobParts) {
		JsArrayMixed blobPartsArray = createBlobPartsArray();
		for (Object object : blobParts) {
			if (object instanceof String) {
				blobPartsArray.push((String) object);
			} else if (object instanceof JavaScriptObject) {
				blobPartsArray.push((JavaScriptObject) object);
			} else {
				// shouldn't happen if we correctly perform type checking
				throw new IllegalArgumentException();
			}
		}
		return blobPartsArray;
	}

	private static native JsArrayMixed createBlobPartsArray() /*-{
		return [];
	}-*/;

	private static void checkAcceptable(Iterable<Object> blobParts) {
		if (!isAcceptableBlobParts(blobParts)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isAcceptableBlobParts(Iterable<Object> blobParts) {
		for (Object object : blobParts) {
			if (isAcceptableBlobPart(object)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isAcceptableBlobPart(Object part) {
		if (part instanceof String) {
			return true;
		}
		for (Class clazz : acceptableJavaScriptObjectTypes) {
			if (isInstanceOf(clazz, part)) {
				return true;
			}
		}
		return false;
	}

	private static <T> boolean isInstanceOf(Class<T> type, Object object) {
		try {
			T objectAsType = (T) object;
		} catch (ClassCastException exception) {
			return false;
		}
		return true;
	}
}
