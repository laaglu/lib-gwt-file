package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImpl {
	public native Blob slice(Blob blob) /*-{
    return blob.slice();
	}-*/;
	
	public native Blob slice(Blob blob, int start) /*-{
    return blob.slice(start);
	}-*/;
	
	public native Blob slice(Blob blob, int start, int end) /*-{
    return blob.slice(start, end);
	}-*/;
	
	public native Blob slice(Blob blob, int start, int end, String contentType) /*-{
    return blob.slice(start, end, contentType);
	}-*/;
}
