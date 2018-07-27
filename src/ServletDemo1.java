

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstdemo.common.util.WebUtils;

/**
 * Servlet implementation class ServletDemo1
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet:" + System.currentTimeMillis());
//		String signature = WebUtils.getParameterValues(request, "signature");
//		String timestamp = WebUtils.getParameterValues(request, "timestamp");
//		String nonce = WebUtils.getParameterValues(request, "nonce");
//		String echostr = WebUtils.getParameterValues(request, "echostr");
		String aStr = WebUtils.getParameterValues(request, "111");
		String bStr = WebUtils.getParameterValues(request, "222");
		response.getWriter().append("Served1111 at: ").append(request.getContextPath());
//		List<String> keyList = new ArrayList<String>(request.getParameterMap().keySet());
//		Collections.sort(keyList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
