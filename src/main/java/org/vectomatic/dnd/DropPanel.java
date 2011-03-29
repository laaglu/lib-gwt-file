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
package org.vectomatic.dnd;

import org.vectomatic.file.events.DragEnterEvent;
import org.vectomatic.file.events.DragEnterHandler;
import org.vectomatic.file.events.DragLeaveEvent;
import org.vectomatic.file.events.DragLeaveHandler;
import org.vectomatic.file.events.DragOverEvent;
import org.vectomatic.file.events.DragOverHandler;
import org.vectomatic.file.events.DropEvent;
import org.vectomatic.file.events.DropHandler;
import org.vectomatic.file.events.HasDragEnterHandlers;
import org.vectomatic.file.events.HasDragLeaveHandlers;
import org.vectomatic.file.events.HasDragOverHandlers;
import org.vectomatic.file.events.HasDropHandlers;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.SimplePanel;

public class DropPanel extends SimplePanel implements HasDropHandlers, HasDragEnterHandlers, HasDragLeaveHandlers, HasDragOverHandlers {
	/**
	 * The event bus shared by all drop panels
	 */
	static protected EventBus eventBus;

	/**
	 * Returns the event bus shared by all drop panels
	 * @return the event bus shared by all drop panels
	 */
	public static EventBus getEventBus() {
		if (eventBus == null) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}
	
	/**
	 * Sets the event bus shared by all drop panels
	 * @param eventBus the event bus shared by all drop panels
	 */
	public static void setEventBus(EventBus eventBus) {
		DropPanel.eventBus = eventBus;
	}
	
	public DropPanel() {
		super();
		setup(getElement());
	}
	
	private final native void setup(Element elem) /*-{
	    var x = this;
		var handler = function(evt) {
	        x.@org.vectomatic.dnd.DropPanel::dispatch(Lcom/google/gwt/dom/client/NativeEvent;)(evt);
		};
		elem.addEventListener("dragenter", handler, false);
		elem.addEventListener("dragleave", handler, false);
		elem.addEventListener("dragover", handler, false);
		elem.addEventListener("drop", handler, false);
	}-*/;
	
	public void fireEvent(GwtEvent<?> event) {
		revive(event);
		getEventBus().fireEventFromSource(event, this);
	}
	/**
	 * Revive the event. GWT does it by taking advantage of the
	 * fact that HandlerManager has package access to GwtEvent.
	 * Here we use a JSNI call to bypass scope restrictions
	 */
	private static final native void revive(GwtEvent<?> event) /*-{
	  event.@com.google.gwt.event.shared.GwtEvent::revive()();
	}-*/;
	
	/**
	 * Dispatches the specified event to this node
	 * event handlers
	 * @param event The event to dispatch
	 */
	public void dispatch(NativeEvent event) {
		// This call wraps the native event into a DomEvent
		// and invokes fireEvent
	    DomEvent.fireNativeEvent(event, this, (Element)event.getCurrentEventTarget().cast());
	}
	
	@Override
	public HandlerRegistration addDropHandler(DropHandler handler) {
		return getEventBus().addHandlerToSource(DropEvent.getType(), this, handler);
	}

	@Override
	public HandlerRegistration addDragLeaveHandler(DragLeaveHandler handler) {
		return getEventBus().addHandlerToSource(DragLeaveEvent.getType(), this, handler);
	}

	@Override
	public HandlerRegistration addDragEnterHandler(DragEnterHandler handler) {
		return getEventBus().addHandlerToSource(DragEnterEvent.getType(), this, handler);
	}

	@Override
	public HandlerRegistration addDragOverHandler(DragOverHandler handler) {
		return getEventBus().addHandlerToSource(DragOverEvent.getType(), this, handler);
	}

}
