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

import com.google.gwt.core.client.JsArrayInteger;

public class Uint16Array extends ArrayBufferView {
  public static final int BYTES_PER_ELEMENT = 2;
  protected Uint16Array() {
  }

  public static final native Uint16Array createUint16Array(int length) /*-{
    return new Uint16Array(length);
  }-*/;
  public static final native Uint16Array createUint16Array(Uint16Array array) /*-{
    return new Uint16Array(array);
  }-*/;
  public static final native Uint16Array createUint16Array(JsArrayInteger array) /*-{
    return new Uint16Array(array);
  }-*/;
  public static final native Uint16Array createUint16Array(ArrayBuffer buffer) /*-{
    return new Uint16Array(buffer);
  }-*/;
  public static final native Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset) /*-{
    return new Uint16Array(buffer, byteOffset);
  }-*/;
  public static final native Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset, int length) /*-{
    return new Uint16Array(buffer, byteOffset, length);
  }-*/;
  // Implementation of the typedarray::Uint16Array W3C IDL interface
  public final native int getLength() /*-{
    return this.length;
  }-*/;
  public final native short get(int index) /*-{
    return this[index];
  }-*/;
  public final native void set(int index, short value) /*-{
    this[index] = value;
  }-*/;
  public final native void set(Uint16Array array, int offset) /*-{
    this.set(array, offset);
  }-*/;
  public final native void set(JsArrayInteger array, int offset) /*-{
    this.set(array, offset);
  }-*/;
  public final native Uint16Array subarray(int start, int end) /*-{
    return this.subarray(start, end);
  }-*/;

}
