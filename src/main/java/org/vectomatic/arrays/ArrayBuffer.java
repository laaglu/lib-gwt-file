/**********************************************
 * Copyright (C) 2011 Lukas Laag
 * This file is part of lib-gwt-file.
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
package org.vectomatic.arrays;

import com.google.gwt.core.client.JavaScriptObject;

public class ArrayBuffer extends JavaScriptObject {
  protected ArrayBuffer() {
  }

  public static final native ArrayBuffer createArrayBuffer(int length) /*-{
    return new ArrayBuffer(length);
  }-*/;
  // Implementation of the typedarray::ArrayBuffer W3C IDL interface
  public final native int getByteLength() /*-{
    return this.byteLength;
  }-*/;
  public final native ArrayBuffer slice(int begin, int end) /*-{
    return this.slice(begin, end);
  }-*/;

  // Helper methods
  /**
   * Instantiates a new array buffer.
   * @param byteLength The size, in bytes, of the array
   * @return the new array buffer.
   */
  public static final native ArrayBuffer create(int byteLength) /*-{
    return new ArrayBuffer(byteLength);
  }-*/; 
}
