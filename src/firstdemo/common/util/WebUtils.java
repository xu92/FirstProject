package firstdemo.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public final class WebUtils {
	public static final String WX_TOKEN = "461633744";
	
	public static final int OK = 1;
	public static final int PARAM_IS_EMPTY = -1;
	
	private WebUtils() {
		
	}
	
	public static String getParameterValues(HttpServletRequest request, String key) throws UnsupportedEncodingException {
		//String[] args = request.getParameterValues(key);
		String arg = new String(request.getParameter(key).getBytes("ISO-8859-1"),"UTF-8");
		if (!StringUtils.isEmpty(arg)) {
			return arg;
		}
		return null;
	}
	
	
	public int checkNullMulti(HttpServletRequest request, String... keys) throws UnsupportedEncodingException {
		int result = OK;
		for (String key : keys) {
			result = checkNull(request, key);
			if (result != OK) {
				return result;
			}
		}
		return result;
	}
	
	public int checkNull(HttpServletRequest request, String key) throws UnsupportedEncodingException {
		int result = OK;
		String arg = getParameterValues(request, key);
		if (StringUtils.isBlank(arg)) {
			result = PARAM_IS_EMPTY;
		}
		return result;
	}

}
