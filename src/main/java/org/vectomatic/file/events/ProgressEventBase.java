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
package org.vectomatic.file.events;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base class for all file events
 */
public abstract class ProgressEventBase<H extends EventHandler> extends DomEvent<H> {
	public boolean lengthComputable() {
		return lengthComputable(getNativeEvent());
	}

	private static final native boolean lengthComputable(NativeEvent event) /*-{
      return event.lengthComputable;
	}-*/;
	
	public int loaded() {
		return loaded(getNativeEvent());
	}
	
	private static final native int loaded(NativeEvent event) /*-{
      return event.loaded;
	}-*/;

	public int total() {
		return total(getNativeEvent());
	}
	
	private static final native int total(NativeEvent event) /*-{
      return event.total;
	}-*/;
}
