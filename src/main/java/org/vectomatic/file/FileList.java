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

import java.util.Iterator;

import org.vectomatic.file.impl.FileListImpl;

/**
 * An object of this type is returned by the files property of the HTML input element; 
 * this lets you access the list of files selected with the &lt;input type="file"&gt; element. 
 * It's also used for a list of files dropped into web content when using the drag and drop API; 
 * see the {@link org.vectomatic.dnd.DataTransferExt} object for details on this usage.
 */
public class FileList implements Iterable<File> {
	private FileListImpl impl;
	
	/**
	 * Constructor. Do not call this constructor directly
	 * new FileList are generated automatically where needed in the API.
	 * @param impl the underlying implementation object.
	 */
	public FileList(FileListImpl impl) {
		this.impl = impl;
	}
	
	  /**
	   * Returns an iterator over the {@link org.vectomatic.file.File}
	   * elements in this list in proper sequence.
	   *
	   * <p>This implementation returns a straightforward implementation of the
	   * iterator interface, relying on the backing list's {@code getLength()},
	   * and {@code getItem(int)} methods.
	   *
	   * <p>Note that the iterator returned by this method will throw an
	   * {@code UnsupportedOperationException} in response to its
	   * {@code remove} method.
	   *
	   * @return an iterator over the {@link org.vectomatic.file.File}
	   * elements in this list in proper sequence
	   */
	@Override
	public Iterator<File> iterator() {
		return new Iterator<File>() {
			private int index;

			@Override
			public boolean hasNext() {
				return index < getLength();
			}

			@Override
			public File next() {
				return getItem(index++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}			
		};
	}
    /**
     * Returns the <code>index</code>th item in the collection. If 
     * <code>index</code> is greater than or equal to the number of nodes in 
     * the list, this returns <code>null</code>.
     * @param index Index into the collection.
     * @return The node at the <code>index</code>th position in the 
     *   <code>FileList</code>, or <code>null</code> if that is not a valid 
     *   index.
     */
	public final File getItem(int index) {
		return impl.getItem(index);
	}
    /**
     * The number of nodes in the list. The range of valid child node indices 
     * is 0 to <code>length-1</code> inclusive.
     */
	public final int getLength() {
		return impl.getLength();
	}
}
