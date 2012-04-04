package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplStandard extends SliceImpl {
	public final native Blob slice(Blob blob) /*-{
    return ('slice' in blob) ? blob.slice() : blob.mozSlice();
	}-*/;
	
	final native Blob slice_(Blob blob, String start) /*-{
    return ('slice' in blob) ? blob.slice(start) : blob.mozSlice(start);
	}-*/;
	
	final native Blob slice_(Blob blob, String start, String end) /*-{
    return ('slice' in blob) ? blob.slice(start, end) : blob.mozSlice(start, end);
	}-*/;
	
	final native Blob slice_(Blob blob, String start, String end, String contentType) /*-{
    return ('slice' in blob) ? blob.slice(start, end, contentType) : blob.mozSlice(start, end, contentType);
	}-*/;

}
