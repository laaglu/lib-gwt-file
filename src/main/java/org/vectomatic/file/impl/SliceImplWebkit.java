package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplWebkit extends SliceImpl  {
	public final native Blob slice(Blob blob) /*-{
    return ('slice' in blob) ? blob.slice() : blob.webkitSlice();
	}-*/;

	public final native Blob slice(Blob blob, int start) /*-{
    return ('slice' in blob) ? blob.slice(start) : blob.webkitSlice(start);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end) /*-{
    return ('slice' in blob) ? blob.slice(start, end) : blob.webkitSlice(start, end);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end, String contentType) /*-{
    return ('slice' in blob) ? blob.slice(start, end, contentType) : blob.webkitSlice(start, end, contentType);
	}-*/;
}
