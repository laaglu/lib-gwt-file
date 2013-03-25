package org.vectomatic.file;


/**
 * Class to group miscellaneous file-related utility methods.
 * @author laaglu
 */
public class FileUtils {
	/**
	 * Returns a base64 encoding of the specified binary string
	 * @param str
	 * A binary string (obtained for instance by the FileReader API).
	 * @return a base64 encoded string.
	 */
	public static native String base64encode(String str) /*-{
		return $wnd.btoa(str);
	}-*/;

	/**
	 * Decodes the specified base64 encoded string
	 * @param str
	 * A base64 encoded string.
	 * @return the decoded string.
	 */
	private static native String base64decode(String str) /*-{
	    return $wnd.atob(a);
	}-*/;
	
	/**
	 * Returns a <a href="http://en.wikipedia.org/wiki/Data_URI_scheme">data
	 * url</a> with the specified mime type and data.
	 * @param type The mime type to use in the data url.
	 * @param data A binary string (obtained for instance by the FileReader API)
	 * @return a base64 encoded string.
	 */
	public static String createDataUrl(String type, String data) {
		return "data:" + type + ";base64," + base64encode(data);
	}
	
	/**
	 * Creates a new object URL, whose lifetime is tied to the document in the
	 * window on which it was created. The new object URL represents the
	 * specified Blob object.
	 * @param blob the blob to represent
	 * @return a new object URL representing the blob.
	 */
	public static final native String createObjectURL(Blob blob) /*-{
	  return $wnd.URL.createObjectURL(blob);
	}-*/;

	/**
	 * Releases an existing object URL which was previously created by calling
	 * {@link #createObjectURL(org.vectomatic.file.Blob)} . Call this method
	 * when you've finished using a object URL, in order to let the browser know
	 * it doesn't need to keep the reference to the file any longer.
	 * 
	 * @param url
	 *            a string representing the object URL that was created by
	 *            calling {@link #createObjectURL(org.vectomatic.file.Blob)}
	 */
	public static final native void revokeObjectURL(String url) /*-{
	  $wnd.URL.revokeObjectURL(url);
	}-*/;
	
	/**
	 * Tests whether the browser support the W3C File API
	 * @return true is supported, false otherwise
	 */
	public static final native boolean supportsFileAPI() /*-{
	  return typeof(FileReader) === 'function' && ("files" in DataTransfer.prototype);
	}-*/;
}
