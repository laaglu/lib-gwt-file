package org.vectomatic.file;


/**
 * Class to group miscellaneous file-related utility methods.
 * @author laaglu
 */
public class FileUtils {
	/**
	 * Returns a base64 encoding of the specified binary string
	 * @param str
	 * A binary string (obtained for instance by the FileReader API)
	 * @return a base64 encoded string.
	 */
	public static native String base64encode(String str) /*-{
		return $wnd.btoa(str);
	}-*/;

	/**
	 * Returns data url with the specified mime type and data 
	 * @see http://en.wikipedia.org/wiki/Data_URI_scheme
	 * @param type
	 * The mime type to use in the data url.
	 * @param data
	 * A binary string (obtained for instance by the FileReader API)
	 * @return a base64 encoded string.
	 */
	public static String createDataUrl(String type, String data) {
		return "data:" + type + ";base64," + base64encode(data);
	}
}
