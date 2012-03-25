package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplMozilla extends SliceImpl {
	public final native Blob slice(Blob blob) /*-{
    return blob.mozSlice();
	}-*/;
	
	public final native Blob slice(Blob blob, int start) /*-{
    return blob.mozSlice(start);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end) /*-{
    return blob.mozSlice(start, end);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end, String contentType) /*-{
    return blob.mozSlice(start, end, contentType);
	}-*/;

}
