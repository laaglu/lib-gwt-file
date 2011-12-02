/**********************************************
 * Copyright (C) 2010 Lukas Laag
 * This file is part of lib-gwt-svg.
 * 
 * libgwtsvg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * libgwtsvg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with libgwtsvg.  If not, see http://www.gnu.org/licenses/
 **********************************************/
/*
 * Copyright (c) 2004 World Wide Web Consortium,
 *
 * (Massachusetts Institute of Technology, European Research Consortium for
 * Informatics and Mathematics, Keio University). All Rights Reserved. This
 * work is distributed under the W3C(r) Software License [1] in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 */

package org.vectomatic.dnd;

import java.util.Iterator;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class to store the mime types specifying the contents of
 * a {@link org.vectomatic.dnd.DataTransferExt} object.
 * @author laaglu
 */
public class StringList implements Iterable<String> {
  private JavaScriptObject ot;
  protected StringList(JavaScriptObject ot) {
    this.ot = ot;
  }

  // Implementation of the dom::DOMStringList W3C IDL interface
  /**
   * The length of the list.
   */
  public final native int length() /*-{
    return this.@org.vectomatic.dnd.StringList::ot.length;
  }-*/;
  /**
   * Returns the specified item from the list.
   * @param index The index of the item from the list which is to be returned.
   * The first item is number 0.
   * @return The selected item.
   * @throws DOMException(INDEX_SIZE_ERR) Raised if the index number is greater
   * than or equal to {@link org.vectomatic.dnd.StringList#length()}.
   */
  public final native String item(int index) throws JavaScriptException /*-{
    return this.@org.vectomatic.dnd.StringList::ot.item(index);
  }-*/;

  /**
   * Returns true/false depending on whether the given string is in the list.
   * @param str The item to test.
   * @return true if the item is in the list, false otherwise.
   */
  public final native boolean contains(String str) /*-{
    return this.@org.vectomatic.dnd.StringList::ot.contains(str);
  }-*/;

  /**
   * Returns an iterator over the {@link java.lang.String}
   * elements in this list in proper sequence.
   *
   * <p>This implementation returns a straightforward implementation of the
   * iterator interface, relying on the backing list's {@code length()},
   * and {@code item(int)} methods.
   *
   * <p>Note that the iterator returned by this method will throw an
   * {@code UnsupportedOperationException} in response to its
   * {@code remove} method.
   *
   * @return an iterator over the {@link java.lang.String}
   * elements in this list in proper sequence
   */
  @Override
  public final Iterator<String> iterator() {
	return new Iterator<String>() {
		private int index;
		@Override
		public boolean hasNext() {
			return index < length();
		}

		@Override
		public String next() {
			return item(index++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
  }

}
