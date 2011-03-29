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

import com.google.gwt.event.dom.client.DomEvent;

/**
 * The activate event occurs when an element is activated, for instance, 
 * through a mouse click or a keypress.
 */
public class ErrorEvent extends ProgressEventBase<ErrorHandler> {
	private static final Type<ErrorHandler> TYPE = new Type<ErrorHandler>(
			"error", new ErrorEvent());

	/**
	 * Protected constructor, use
	 * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
	 * to fire mouse out events.
	 */
	protected ErrorEvent() {
	}

	/**
	 * @return the handler type
	 */
	public Type<ErrorHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the handler type
	 */
	public static Type<ErrorHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ErrorHandler handler) {
		handler.onError(this);
	}
}
