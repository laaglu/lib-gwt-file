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

import com.google.gwt.core.client.JsArrayNumber;

public class Float32Array extends ArrayBufferView {
  public static final int BYTES_PER_ELEMENT = 4;
  protected Float32Array() {
  }

  public static final native Float32Array createFloat32Array(int length) /*-{
    return new Float32Array(length);
  }-*/;
  public static final native Float32Array createFloat32Array(Float32Array array) /*-{
    return new Float32Array(array);
  }-*/;
  public static final native Float32Array createFloat32Array(JsArrayNumber array) /*-{
    return new Float32Array(array);
  }-*/;
  public static final native Float32Array createFloat32Array(ArrayBuffer buffer) /*-{
    return new Float32Array(buffer);
  }-*/;
  public static final native Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset) /*-{
    return new Float32Array(buffer, byteOffset);
  }-*/;
  public static final native Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset, int length) /*-{
    return new Float32Array(buffer, byteOffset, length);
  }-*/;
  // Implementation of the typedarray::Float32Array W3C IDL interface
  public final native int getLength() /*-{
    return this.length;
  }-*/;
  public final native float get(int index) /*-{
    return this[index];
  }-*/;
  public final native void set(int index, float value) /*-{
    this[index] = value;
  }-*/;
  public final native void set(Float32Array array, int offset) /*-{
    this.set(array, offset);
  }-*/;
  public final native void set(JsArrayNumber array, int offset) /*-{
    this.set(array, offset);
  }-*/;
  public final native Float32Array subarray(int start, int end) /*-{
    return this.subarray(start, end);
  }-*/;

}
