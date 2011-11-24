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
package org.vectomatic.dnd;

import org.vectomatic.file.FileList;
import org.vectomatic.file.impl.FileListImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.DataTransfer;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;

/**
 * Class to augment the {@link com.google.gwt.dom.client.DataTransfer} provided
 * by GWT with the methods it needs to support drag and drop of files. On
 * browsers which support file drag and drop, {@link com.google.gwt.dom.client.DataTransfer} objects
 * can simply be cast to this class.
 * @author laaglu
 */
public class DataTransferExt extends DataTransfer {
	/**
	 *  Constructor
	 */
	protected DataTransferExt() {
	}
	private final native String getDropEffect_() /*-{
    	return this.dropEffect;
	}-*/; 
	private final native void setDropEffect_(String dropEffect) /*-{
		this.dropEffect = dropEffect;
	}-*/; 
	private final native String getEffectAllowed_() /*-{
		return this.effectAllowed;
	}-*/; 
	private final native void setEffectAllowed_(String effectAllowed) /*-{
		this.effectAllowed = effectAllowed;
	}-*/; 
	private final native FileListImpl getFiles_() /*-{
	  return this.files;
	}-*/; 
	private final native JavaScriptObject getTypes_() /*-{
	  return this.types;
	}-*/;
	private final native void addElement_(Element element) /*-{
	  this.addElement(element);
	}-*/;

	/**
	 * <p>The actual effect that will be used, and should always be one of the
	 * possible values of effectAllowed.</p>
	 * 
	 * <p>For the dragenter and dragover events, the dropEffect will be initialized
	 * based on what action the user is requesting. How this is determined is
	 * platform specific, but typically the user can press modifier keys to
	 * adjust which action is desired. Within an event handler for the dragenter
	 * and dragover events, the dropEffect should be modified if the action the
	 * user is requesting is not the one that is desired.</p>
	 * 
	 * <p>For dragstart, drag, and dragleave events, the dropEffect is initialized
	 * to "none". Any value assigned to the dropEffect will be set, but the
	 * value isn't used for anything.</p>
	 * 
	 * <p>For the drop and dragend events, the dropEffect will be initialized to
	 * the action that was desired, which will be the value that the dropEffect
	 * had after the last dragenter or dragover event.</p>
	 * 
	 * <p>Possible values:</p>
	 * <dl>
	 * <dt>copy:</dt><dd>A copy of the source item is made at the new location.</dd>
	 * <dt>move:</dt><dd>An item is moved to a new location.</dd>
	 * <dt>link:</dt><dd>A link is established to the
	 * source at the new location.</dd>
	 * <dt>none:</dt><dd>The item may not be dropped.</dd>
	 * </dl>
	 * 
	 * <p>Assigning any other value has no effect and retains the old value.</p>
	 * 
	 * @return The drop effect.
	 */
	public final String getDropEffect() {
		return getDropEffect_();
	}
	/**
	 * <p>Sets the actual effect that will be used, and should always be one of the
	 * possible values of effectAllowed.</p>
	 * @param dropEffect The drop effect.
	 */
	public final void setDropEffect(String dropEffect) {
		setDropEffect_(dropEffect);
	}
	/**
	 * Returns the effect allowed for this drag.
	 * @return the effect allowed for this drag.
	 */
	public final String getEffectAllowed() {
		return getEffectAllowed_();
	} 

	/**
	 * <p>
	 * Specifies the effects that are allowed for this drag. You may set this in
	 * the dragstart event to set the desired effects for the source, and within
	 * the dragenter and dragover events to set the desired effects for the
	 * target. The value is not used for other events.
	 * </p>
	 * <p>
	 * Possible values:
	 * </p>
	 * <dl>
	 * <dt>copy:</dt>
	 * <dd>A copy of the source item may be made at the new location.</dd>
	 * <dt>move:</dt>
	 * <dd>An item may be moved to a new location.</dd>
	 * <dt>link:</dt>
	 * <dd>A link may be established to the source at the new location.</dd>
	 * <dt>copyLink:</dt>
	 * <dd>A copy or link operation is permitted.</dd>
	 * <dt>copyMove:</dt>
	 * <dd>A copy or move operation is permitted.</dd>
	 * <dt>linkMove:</dt>
	 * <dd>A link or move operation is permitted.</dd>
	 * <dt>all:</dt>
	 * <dd>All operations are permitted.</dd>
	 * <dt>none:</dt>
	 * <dd>the item may not be dropped.</dd>
	 * <dt>uninitialized:</dt>
	 * <dd>the default value when the effect has not been set, equivalent to
	 * all.</dd>
	 * </dl>
	 * <p>
	 * Assigning any other value has no effect and retains the old value.
	 * </p>
	 * 
	 * @param effectAllowed
	 *            the effect for this drag
	 */
	public final void setEffectAllowed(String effectAllowed) {
		setEffectAllowed_(effectAllowed);
	}

	/**
	 * Returns a list of all the local files available on the data transfer. If
	 * the drag operation doesn't involve dragging files, this property is an
	 * empty list. An invalid index access on the
	 * {@link org.vectomatic.file.FileList} specified by this property will
	 * return null.
	 * 
	 * @return a list of all the local files available on the data transfer.
	 */
	public final FileList getFiles() {
		return new FileList(getFiles_());
	}

	/**
	 * Returns a list of the format types of the data that is stored for the
	 * first item, in the same order the data was added. An empty list will be
	 * returned if no data was added.
	 * 
	 * @return a list of the format types of the data that is stored for the
	 *         first item, in the same order the data was added.
	 */
	public final StringList getTypes() {
		return new StringList(getTypes_());
	}

	/**
	 * <p>Set the image to be used for dragging if a custom one is desired. Most of
	 * the time, this would not be set, as a default image is created from the
	 * node that was dragged.</p>
	 * 
	 * <p>If the node is an HTML img element, an HTML canvas element or a XUL image
	 * element, the image data is used. Otherwise, image should be a visible
	 * node and the drag image will be created from this. If image is null, any
	 * custom drag image is cleared and the default is used instead.</p>
	 * 
	 * <p>The coordinates specify the offset into the image where the mouse cursor
	 * should be. To center the image, for instance, use values that are half
	 * the width and height of the image.</p>
	 * 
	 * @param image
	 *            An element to use as the drag feedback image.
	 * @param x
	 *            Horizontal offset within the image.
	 * @param y
	 *            Vertical offset within the image.
	 */
	public final void setDragImage(Image image, int x, int y) {
		setDragImage(image.getElement(), x, y);
	}

	/**
	 * Set the drag source. Usually you would not change this, but it will
	 * affect which node the drag and dragend events are fired at. The default
	 * target is the node that was dragged.
	 * @param uiObject The element to add.
	 */
	public final void addElement(UIObject uiObject) {
		addElement_(uiObject.getElement());
	}

}
