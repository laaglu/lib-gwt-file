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
}
