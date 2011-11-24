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

public class Uint8ClampedArray extends Uint8Array {
  protected Uint8ClampedArray() {
  }

  public static final native Uint8ClampedArray createUint8ClampedArray(int length) /*-{
    return new Uint8ClampedArray(length);
  }-*/;
  public static final native Uint8ClampedArray createUint8ClampedArray(Uint8ClampedArray array) /*-{
    return new Uint8ClampedArray(array);
  }-*/;
  public static final native Uint8ClampedArray createUint8ClampedArray(Uint8Array array) /*-{
    return new Uint8ClampedArray(array);
  }-*/;
  public static final native Uint8ClampedArray createUint8ClampedArray(JsArrayInteger array) /*-{
    return new Uint8ClampedArray(array);
  }-*/;
  public static final native Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer) /*-{
    return new Uint8ClampedArray(buffer);
  }-*/;
  public static final native Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset) /*-{
    return new Uint8ClampedArray(buffer, byteOffset);
  }-*/;
  public static final native Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset, int length) /*-{
    return new Uint8ClampedArray(buffer, byteOffset, length);
  }-*/;
  // Implementation of the typedarray::Uint8ClampedArray W3C IDL interface
  public final native void set(Uint8ClampedArray array, int offset) /*-{
    this.set(array, offset);
  }-*/;

}
