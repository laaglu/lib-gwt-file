package org.vectomatic.file.impl;

import org.vectomatic.file.Blob;

public abstract class SliceImpl {
	public abstract Blob slice(Blob blob);
	
	public Blob slice(Blob blob, long start) {
		return slice_(blob, toString(start));
	}
	
	public Blob slice(Blob blob, long start, long end) {
		return slice_(blob, toString(start), toString(end));
	}
	
	public Blob slice(Blob blob, long start, long end, String contentType) {
		return slice_(blob, toString(start), toString(end), contentType);
	}
	
	static String toString(long l) {
		if (l > 9007199254740992L) {
			throw new NumberFormatException();
		}
		return Long.toString(l);
	}

	abstract Blob slice_(Blob blob, String start);
	abstract Blob slice_(Blob blob, String start, String end);
	abstract Blob slice_(Blob blob, String start, String end, String contentType);
}
