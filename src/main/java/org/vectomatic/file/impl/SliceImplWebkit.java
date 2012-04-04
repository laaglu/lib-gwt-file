package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplWebkit extends SliceImpl  {
	public final native Blob slice(Blob blob) /*-{
    return ('slice' in blob) ? blob.slice() : blob.webkitSlice();
	}-*/;

	final native Blob slice_(Blob blob, String start) /*-{
    return ('slice' in blob) ? blob.slice(start) : blob.webkitSlice(start);
	}-*/;
	
	final native Blob slice_(Blob blob, String start, String end) /*-{
    return ('slice' in blob) ? blob.slice(start, end) : blob.webkitSlice(start, end);
	}-*/;
	
	final native Blob slice_(Blob blob, String start, String end, String contentType) /*-{
    return ('slice' in blob) ? blob.slice(start, end, contentType) : blob.webkitSlice(start, end, contentType);
	}-*/;
}
