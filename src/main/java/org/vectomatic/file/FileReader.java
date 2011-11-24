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
/**
 * Documentation is adapted from W3C spec and content available from
 * http://developer.mozilla.org under http://creativecommons.org/licenses/by-sa/2.5/
 */
package org.vectomatic.file;

import org.vectomatic.arrays.ArrayBuffer;
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

/**
 * The {@link org.vectomatic.file.FileReader} object lets web applications
 * asynchronously read the contents of files (or raw data buffers) stored on the
 * user's computer, using {@link org.vectomatic.file.File} or
 * {@link org.vectomatic.file.Blob} objects to specify the file or data to read.
 * File objects may be obtained in one of two ways: from a FileList object
 * returned as a result of a user selecting files using the &lt;input&gt; element, or
 * from a drag and drop operation's {@link org.vectomatic.dnd.DataTransferExt}
 * object.
 * 
 * To create a {@link org.vectomatic.file.FileReader}, simply do the following:
 * 
 * <pre>
 * FileReader reader = new FileReader();
 * </pre>
 */
public class FileReader implements HasLoadHandlers, HasLoadStartHandlers, HasLoadEndHandlers, HasAbortHandlers, HasProgressHandlers, HasErrorHandlers {
	/**
	 * Enum to represent FileReader state constants.
	 */
	public enum State {
		/**
		 * No data has been loaded yet.
		 */
		EMPTY {
			public short getValue() {
				return FileReaderImpl.EMPTY;
			}
		},
		/**
		 * Data is currently being loaded.
		 */
		LOADING {
			public short getValue() {
				return FileReaderImpl.LOADING;
			}
		},
		/**
		 * The entire read request has been completed.
		 */
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
	
	/**
	 * Constructor.
	 */
	public FileReader() {
		impl = FileReaderImpl.newInstance();
	}

	/**
	 * Indicates the state of the FileReader. This will be one of the
	 * {@link org.vectomatic.file.FileReader.State} constants. Read only.
	 * 
	 * @return the state of the FileReader
	 */
	public State getReadyState() { 
		return State.fromValue(impl.getReadyState());
	}

	/**
	 * Returns the file's contents. This method should only be called after the
	 * read operation is complete, and the format of the data depends on which
	 * of the methods was used to initiate the read operation (one of:
	 * {@link #readAsBinaryString(org.vectomatic.file.Blob)},
	 * {@link #readAsText(org.vectomatic.file.Blob)},
	 * {@link #readAsText(org.vectomatic.file.Blob, java.lang.String)} or
	 * {@link #readAsDataURL(org.vectomatic.file.Blob)}).
	 * 
	 * @return the file's contents
	 */
	public String getStringResult() { 
		return impl.getStringResult();
	}

	/**
	 * Returns the file's contents. This method should only be called after the
	 * read operation (triggered by
	 * {@link #readAsArrayBuffer(org.vectomatic.file.Blob)}) is
	 * complete.
	 * 
	 * @return the file's contents
	 */
	public ArrayBuffer getArrayBufferResult() { 
		return impl.getArrayBufferResult();
	}
	public FileError getError() { 
		return impl.getError();
	}
	
	/**
	 * Aborts the read operation. Upon return, the readyState will be
	 * {@link org.vectomatic.file.FileReader.State#DONE}.
	 */
	public void abort() {
		impl.abort();
	}

	/**
	 * Starts reading the contents of the specified
	 * {@link org.vectomatic.file.Blob}, which may be a
	 * {@link org.vectomatic.file.File}. When the read operation is finished,
	 * the {@link #getReadyState()} will become
	 * {@link org.vectomatic.file.FileReader.State#DONE}, and the
	 * {@link org.vectomatic.file.events.LoadEndEvent} event, if any, will be
	 * fired. At that time, the {@link #getStringResult()} provides access to
	 * the raw binary data from the file.
	 * 
	 * @param fileBlob
	 *            The DOM {@link org.vectomatic.file.Blob} or
	 *            {@link org.vectomatic.file.File} from which to read.
	 */
	public void readAsBinaryString(Blob fileBlob) { 
		impl.readAsBinaryString(fileBlob);
	}
	/**
	 * Starts reading the contents of the specified
	 * {@link org.vectomatic.file.Blob}, which may be a
	 * {@link org.vectomatic.file.File}. When the read operation is finished,
	 * the {@link #getReadyState()} will become
	 * {@link org.vectomatic.file.FileReader.State#DONE}, and the
	 * {@link org.vectomatic.file.events.LoadEndEvent} event, if any, will be
	 * fired. At that time, the {@link #getStringResult()} provides access to
	 * the contents of the file as a text string.
	 * 
	 * @param fileBlob
	 *            The DOM {@link org.vectomatic.file.Blob} or
	 *            {@link org.vectomatic.file.File} from which to read.
	 */
	public void readAsText(Blob fileBlob) { 
		impl.readAsText(fileBlob);
	}

	/**
	 * Starts reading the contents of the specified
	 * {@link org.vectomatic.file.Blob}, which may be a
	 * {@link org.vectomatic.file.File}. When the read operation is finished,
	 * the {@link #getReadyState()} will become
	 * {@link org.vectomatic.file.FileReader.State#DONE}, and the
	 * {@link org.vectomatic.file.events.LoadEndEvent} event, if any, will be
	 * fired. At that time, the {@link #getStringResult()} provides access to
	 * the contents of the file as a text string.
	 * 
	 * @param fileBlob
	 *            The DOM {@link org.vectomatic.file.Blob} or
	 *            {@link org.vectomatic.file.File} from which to read.
	 * @param encoding
	 *            A string indicating the encoding to use for the returned data.
	 *            By default, UTF-8 is assumed if this parameter is not
	 *            specified.
	 */
	public void readAsText(Blob fileBlob, String encoding) { 
		impl.readAsText(fileBlob, encoding);
	}
	/**
	 * Starts reading the contents of the specified
	 * {@link org.vectomatic.file.Blob}, which may be a
	 * {@link org.vectomatic.file.File}. When the read operation is finished,
	 * the {@link #getReadyState()} will become
	 * {@link org.vectomatic.file.FileReader.State#DONE}, and the
	 * {@link org.vectomatic.file.events.LoadEndEvent} event, if any, will be
	 * fired. At that time, the {@link #getStringResult()} provides access to
	 * the contents of the file as a data: URL representing the file's data.
	 * 
	 * @param fileBlob
	 *            The DOM {@link org.vectomatic.file.Blob} or
	 *            {@link org.vectomatic.file.File} from which to read.
	 */
	public void readAsDataURL(Blob fileBlob) { 
		impl.readAsDataURL(fileBlob);
	}
	
	/**
	 * Starts reading the contents of the specified
	 * {@link org.vectomatic.file.Blob}, which may be a
	 * {@link org.vectomatic.file.File}. When the read operation is finished,
	 * the {@link #getReadyState()} will become
	 * {@link org.vectomatic.file.FileReader.State#DONE}, and the
	 * {@link org.vectomatic.file.events.LoadEndEvent} event, if any, will be
	 * fired. At that time, the {@link #getStringResult()} provides access to
	 * an {@link org.vectomatic.arrays.ArrayBuffer} representing the file's data.
	 * 
	 * @param fileBlob
	 *            The DOM {@link org.vectomatic.file.Blob} or
	 *            {@link org.vectomatic.file.File} from which to read.
	 */
	public void readAsArrayBuffer(Blob fileBlob) { 
		impl.readAsArrayBuffer(fileBlob);
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
