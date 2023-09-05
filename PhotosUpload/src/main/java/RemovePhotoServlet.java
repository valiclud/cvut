

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemovePhotoServlet
 */
@WebServlet(name = "/RemovePhotoServlet",
	urlPatterns = {"/RemovePhotoServlet"})
public class RemovePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePhotoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexString = request.getParameter("photo");
		int index =  (new Integer(indexString.trim())).intValue();
		HttpSession session = request.getSession();
		PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(session);
		pa.removePhoto(index);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAlbumServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
