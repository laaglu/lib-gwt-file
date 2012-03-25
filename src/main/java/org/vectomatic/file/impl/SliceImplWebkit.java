package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplWebkit extends SliceImpl  {
	public final native Blob slice(Blob blob) /*-{
    return blob.webkitSlice();
	}-*/;

	public final native Blob slice(Blob blob, int start) /*-{
    return blob.webkitSlice(start);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end) /*-{
    return blob.webkitSlice(start, end);
	}-*/;
	
	public final native Blob slice(Blob blob, int start, int end, String contentType) /*-{
    return blob.webkitSlice(start, end, contentType);
	}-*/;
}
