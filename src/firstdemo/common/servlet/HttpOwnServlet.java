package firstdemo.common.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import firstdemo.common.util.WebUtils;

/**
 * Servlet implementation class HttpServlet
 */
@WebServlet("/HttpOwnServlet")
public class HttpOwnServlet extends javax.servlet.http.HttpServlet {
	 
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(HttpOwnServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see javax.servlet.http.HttpServlet#javax.servlet.http.HttpServlet()
     */
    public HttpOwnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpOwnServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String aau = URLEncoder.encode(s);
		//URLDecoder.decode(s);
//		JSONObject json = JSONObject.parseObject(new String(request.getContent()));
		Map<String, String[]> aacc = request.getParameterMap();
		String aStr = WebUtils.getParameterValues(request, "id");
		String bStr = WebUtils.getParameterValues(request, "name");
		String aa = request.getQueryString();
		String charEncoding = request.getCharacterEncoding();
		String submitMehtod = request.getMethod();
		String jsonStr = getRequestJsonString(request);
		System.out.println("aaa:"+jsonStr);
		JSONObject json = JSONObject.parseObject(getRequestJsonString(request));

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpOwnServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().
            		getBytes("iso-8859-1"),"utf-8");
        // POST
        } else {
            return getRequestPostStr(request);
        }
    }
	
	/**      
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
    
    /**      
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

}
