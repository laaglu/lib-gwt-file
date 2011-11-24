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


public class DataView extends ArrayBufferView {
  protected DataView() {
  }

  public static final native DataView createDataView(ArrayBuffer buffer) /*-{
    return new DataView(buffer);
  }-*/;
  public static final native DataView createDataView(ArrayBuffer buffer, int byteOffset) /*-{
    return new DataView(buffer, byteOffset);
  }-*/;
  public static final native DataView createDataView(ArrayBuffer buffer, int byteOffset, int byteLength) /*-{
    return new DataView(buffer, byteOffset, byteLength);
  }-*/;
  // Implementation of the typedarray::DataView W3C IDL interface
  public final native byte getInt8(int byteOffset) /*-{
    return this.getInt8(byteOffset);
  }-*/;
  public final native byte getUint8(int byteOffset) /*-{
    return this.getUint8(byteOffset);
  }-*/;
  public final native short getInt16(int byteOffset, boolean littleEndian) /*-{
    return this.getInt16(byteOffset, littleEndian);
  }-*/;
  public final native short getUint16(int byteOffset, boolean littleEndian) /*-{
    return this.getUint16(byteOffset, littleEndian);
  }-*/;
  public final native int getInt32(int byteOffset, boolean littleEndian) /*-{
    return this.getInt32(byteOffset, littleEndian);
  }-*/;
  public final native int getUint32(int byteOffset, boolean littleEndian) /*-{
    return this.getUint32(byteOffset, littleEndian);
  }-*/;
  public final native float getFloat32(int byteOffset, boolean littleEndian) /*-{
    return this.getFloat32(byteOffset, littleEndian);
  }-*/;
  public final native float getFloat64(int byteOffset, boolean littleEndian) /*-{
    return this.getFloat64(byteOffset, littleEndian);
  }-*/;
  public final native void setInt8(int byteOffset, byte value) /*-{
    this.setInt8(byteOffset, value);
  }-*/;
  public final native void setUint8(int byteOffset, byte value) /*-{
    this.setUint8(byteOffset, value);
  }-*/;
  public final native void setInt16(int byteOffset, short value, boolean littleEndian) /*-{
    this.setInt16(byteOffset, value, littleEndian);
  }-*/;
  public final native void setUint16(int byteOffset, short value, boolean littleEndian) /*-{
    this.setUint16(byteOffset, value, littleEndian);
  }-*/;
  public final native void setInt32(int byteOffset, int value, boolean littleEndian) /*-{
    this.setInt32(byteOffset, value, littleEndian);
  }-*/;
  public final native void setUint32(int byteOffset, int value, boolean littleEndian) /*-{
    this.setUint32(byteOffset, value, littleEndian);
  }-*/;
  public final native void setFloat32(int byteOffset, float value, boolean littleEndian) /*-{
    this.setFloat32(byteOffset, value, littleEndian);
  }-*/;
  public final native void setFloat64(int byteOffset, float value, boolean littleEndian) /*-{
    this.setFloat64(byteOffset, value, littleEndian);
  }-*/;

}
