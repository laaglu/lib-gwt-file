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

public class ArrayBufferView extends JavaScriptObject {
  protected ArrayBufferView() {
  }

  // Implementation of the typedarray::ArrayBufferView W3C IDL interface
  public final native ArrayBuffer getBuffer() /*-{
    return this.buffer;
  }-*/;
  public final native int getByteOffset() /*-{
    return this.byteOffset;
  }-*/;
  public final native int getByteLength() /*-{
    return this.byteLength;
  }-*/;

}
