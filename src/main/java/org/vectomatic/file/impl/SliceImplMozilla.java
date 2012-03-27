package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplMozilla extends SliceImpl {
	public final native Blob slice(Blob blob) /*-{
    return ('slice' in blob) ? blob.slice() : blob.mozSlice();
	}-*/;
	
	public final native Blob slice(Blob blob, int start) /*-{
    return ('slice' in blob) ? blob.slice(start) :blob.mozSlice(start);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end) /*-{
    return ('slice' in blob) ? blob.slice(start, end) : blob.mozSlice(start, end);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end, String contentType) /*-{
    return ('slice' in blob) ? blob.slice(start, end, contentType) : blob.mozSlice(start, end, contentType);
	}-*/;

}
