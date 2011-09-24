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

import org.vectomatic.dnd.DataTransferExt;
import org.vectomatic.dnd.impl.DataTransferImpl;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base class for all drag and drop events
 */
@Deprecated
public abstract class DragEventBase<H extends EventHandler> extends MouseEvent<H> {
	public DataTransferExt getDataTransfer() {
		return null;
	}
	private static native DataTransferImpl getDataTransfer(NativeEvent event) /*-{
      return event.dataTransfer;
	}-*/; 
}
