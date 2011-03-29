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

public class DndHandlerBase implements DragStartHandler, DragEndHandler, DragEnterHandler, DragLeaveHandler, DragHandler, DragOverHandler, DropHandler {

	@Override
	public void onDrop(DropEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

	@Override
	public void onDragOver(DragOverEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

	@Override
	public void onDrag(DragEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

	@Override
	public void onDragLeave(DragLeaveEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

	@Override
	public void onDragEnter(DragEnterEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

	@Override
	public void onDragEnd(DragEndEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

	@Override
	public void onDragStart(DragStartEvent event) {
		event.stopPropagation();
		event.preventDefault();
	}

}
