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
package org.vectomatic.file;

import org.vectomatic.file.events.AbortEvent;
import org.vectomatic.file.events.AbortHandler;
import org.vectomatic.file.events.ErrorEvent;
import org.vectomatic.file.events.ErrorHandler;
import org.vectomatic.file.events.HasAbortHandlers;
import org.vectomatic.file.events.HasErrorHandlers;
import org.vectomatic.file.events.HasLoadEndHandlers;
import org.vectomatic.file.events.HasLoadStartHandlers;
import org.vectomatic.file.events.HasProgressHandlers;
import org.vectomatic.file.events.LoadEndEvent;
import org.vectomatic.file.events.LoadEndHandler;
import org.vectomatic.file.events.LoadStartEvent;
import org.vectomatic.file.events.LoadStartHandler;
import org.vectomatic.file.events.ProgressEvent;
import org.vectomatic.file.events.ProgressHandler;
import org.vectomatic.file.impl.FileReaderImpl;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Element;

public class FileReader implements HasLoadHandlers, HasLoadStartHandlers, HasLoadEndHandlers, HasAbortHandlers, HasProgressHandlers, HasErrorHandlers {
	public enum State {
		EMPTY {
			public short getValue() {
				return FileReaderImpl.EMPTY;
			}
		},
		LOADING {
			public short getValue() {
				return FileReaderImpl.LOADING;
			}
		},
		DONE {
			public short getValue() {
				return FileReaderImpl.DONE;
			}
		};
		public abstract short getValue();
		public static State fromValue(short value) {
			switch(value) {
			case FileReaderImpl.EMPTY:
				return EMPTY;
			case FileReaderImpl.LOADING:
				return LOADING;
			case FileReaderImpl.DONE:
				return DONE;
			default:
				throw new IllegalStateException("Bad readyState value " + value);
			}
		}
	}
	private FileReaderImpl impl;
	static protected EventBus eventBus = new SimpleEventBus();
	public FileReader() {
		impl = FileReaderImpl.newInstance();
	}
	public State getReadyState() { 
		return State.fromValue(impl.getReadyState());
	}
	public String getResult() { 
		return impl.getResult();
	}
	public FileError getError() { 
		return impl.getError();
	}
	public void readAsBinaryString(Blob fileBlob) { 
		impl.readAsBinaryString(fileBlob);
	}
	public void readAsText(Blob fileBlob) { 
		impl.readAsText(fileBlob);
	}
	public void readAsText(Blob fileBlob, String encoding) { 
		impl.readAsText(fileBlob, encoding);
	}
	public void readAsDataURL(File file) { 
		impl.readAsDataURL(file);
	}
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
	public void fireEvent(GwtEvent<?> event) {
		revive(event);
		eventBus.fireEventFromSource(event, impl);
	}
	/**
	 * Revive the event. GWT does it by taking advantage of the
	 * fact that HandlerManager has package access to GwtEvent.
	 * Here we use a JSNI call to bypass scope restrictions
	 */
	private static final native void revive(GwtEvent<?> event) /*-{
	  event.@com.google.gwt.event.shared.GwtEvent::revive()();
	}-*/;
	
	protected final <H extends EventHandler> HandlerRegistration addDomHandler(
			final H handler, DomEvent.Type<H> type) {
		assert handler != null : "handler must not be null";
		assert type != null : "type must not be null";
		impl.registerEvent(this, type.getName());
		return eventBus.addHandlerToSource(type, impl, handler);
	}
	
	@Override
	public HandlerRegistration addErrorHandler(ErrorHandler handler) {
	    return addDomHandler(handler, ErrorEvent.getType());
	}
	@Override
	public HandlerRegistration addProgressHandler(ProgressHandler handler) {
	    return addDomHandler(handler, ProgressEvent.getType());
	}
	@Override
	public HandlerRegistration addAbortHandler(AbortHandler handler) {
	    return addDomHandler(handler, AbortEvent.getType());
	}
	@Override
	public HandlerRegistration addLoadEndHandler(LoadEndHandler handler) {
	    return addDomHandler(handler, LoadEndEvent.getType());
	}
	@Override
	public HandlerRegistration addLoadStartHandler(LoadStartHandler handler) {
	    return addDomHandler(handler, LoadStartEvent.getType());
	}
	@Override
	public HandlerRegistration addLoadHandler(LoadHandler handler) {
	    return addDomHandler(handler, LoadEvent.getType());
	}
}
