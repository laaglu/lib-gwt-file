package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public class SliceImplStandard extends SliceImpl {
	public final native Blob slice(Blob blob) /*-{
    return blob.slice();
	}-*/;
	
	final native Blob slice_(Blob blob, String start) /*-{
    return blob.slice(start);
	}-*/;
	
	final native Blob slice_(Blob blob, String start, String end) /*-{
    return blob.slice(start, end);
	}-*/;
	
	final native Blob slice_(Blob blob, String start, String end, String contentType) /*-{
    return blob.slice(start, end, contentType);
	}-*/;

}
