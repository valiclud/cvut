

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UploadServlet
 */
//@WebServlet(name = "/DisplayPhotoServlet",
//	urlPatterns = {"/DisplayPhotoServlet"})
@WebServlet("/DisplayPhotoServlet")
public class DisplayPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DisplayPhotoServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexString = request.getParameter("photo");
		int index =  (new Integer(indexString.trim())).intValue();
		response.setContentType("image/jpeg");
		
		OutputStream out = response.getOutputStream();
		try {
			HttpSession session = request.getSession();
			PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(session);
			byte [] bytes = pa.getPhotoData(index);
			for (int i = 0 ; i < bytes.length; i++) {
				out.write(bytes[i]);
			}
			out.flush();
			out.close();
		} 
		finally {
			out.close();
			response.getOutputStream().close();
		}
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
