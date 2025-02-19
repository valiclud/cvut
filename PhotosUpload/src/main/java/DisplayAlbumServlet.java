

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class DisplayAlbumServlet
 */
//@WebServlet(name = "/DisplayAlbumServlet",
//		urlPatterns = {"/DisplayAlbumServlet"})
@WebServlet("/DisplayAlbumServlet")
@MultipartConfig()
/*@ServletSecurity(httpMethodConstraints={
		@HttpMethodConstraint(
				value = "GET",
				emptyRoleSemantic=ServletSecurity.EmptyRoleSemantic.PERMIT),
		@HttpMethodConstraint(
				value = "POST",
				rolesAllowed = {"admin","photographer"},
				emptyRoleSemantic=ServletSecurity.EmptyRoleSemantic.PERMIT),
})
*/
public class DisplayAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAlbumServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------- IA M H E R E ");
		handleRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request,response);
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(session);
		
		if(request.getContentType() != null &&
				request.getContentType().startsWith("multipart/form-data")){
		this.uploadPhoto(request, pa);
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		try {
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<title>Photo Viewer</title>");
			writer.write("</head>");
			writer.write("<body>");
			writer.write("<h3 align = 'center'>Photos<h3>");
			this.displayAlbumPost(pa, "", writer, session);
			writer.println("</body>");
			writer.println("</html>");
		} finally {
			writer.close();
		}
	}
		
	private void displayAlbumPost (PhotoAlbum pa, String label, PrintWriter writer, HttpSession session) {
		displayUserCounter(pa, writer, session);
		writer.write("<h3 align = 'center'>" + label +"<h3>");
		writer.write("<table align = 'center'>");
		
		displayPhotos(pa, writer);
		displayButtons(writer);
		displayPhotoNames(pa, writer);
		displayRemoveButtons(pa, writer);
		
		writer.write("</tr>");
		writer.write("</table>");
	}
	
	private void displayAlbumGet (PhotoAlbum pa, String label, PrintWriter writer, HttpSession session) {
		displayUserCounter(pa, writer, session);
		writer.write("<h3 align = 'center'>" + label +"<h3>");
		writer.write("<table align = 'center'>");
		
		displayPhotos(pa, writer);
		displayPhotoNames(pa, writer);
		
		writer.write("</tr>");
		writer.write("</table>");
	}
	
		private void uploadPhoto (HttpServletRequest request, 
				PhotoAlbum pa)
				throws ServletException, IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			String fileName = null;
			for (Part p : request.getParts()) {
				this.copyBytes(p.getInputStream(), baos);
				fileName = p.getSubmittedFileName();
		}
			if (!"".equals(fileName)) {
				String photoName = fileName.substring(0, fileName.lastIndexOf("."));
				pa.addPhoto(photoName,baos.toByteArray());
			}
		
	}
		
		private void displayButtons (PrintWriter writer) {
			writer.write("<td bgcolor='#cccccc' height='120' width='120'>");
			writer.write("<form align='left' action='DisplayAlbumServlet'"
					+ "method ='post' enctype = 'multipart/form-data'>");
			writer.write("<input value='Choose' name='myFile' type='file'"
					+ "accept='image/jpeg'><br>");
			writer.write("<input value='Upload' type='submit\'><br>");
			writer.write("</form>");
			writer.write("</td>");
		}
		
		private void displayRemoveButtons(PhotoAlbum pa, PrintWriter writer) {
			for (int i = 0 ; i < pa.getPhotoCount(); i++) {
				writer.write("<td align = 'center'>");
				writer.write("<a href='RemovePhotoServlet?photo=" + i + "'>remove</a>");
				writer.write("</td>");
			}
		}
		
		private void displayPhotoNames(PhotoAlbum pa, PrintWriter writer) {
			writer.write("<tr>");
			
			for (int i = 0 ; i < pa.getPhotoCount(); i++) {
				writer.write("<td align = 'center'>");
				writer.write(pa.getPhotoName(i));
				writer.write("</td>");
			}
			writer.write("</tr>");
			
		}
		
		private void displayPhotos(PhotoAlbum pa, PrintWriter writer) {
			for (int i = 0 ; i < pa.getPhotoCount(); i++) {
				writer.write("<td>");
				writer.write("<a href='./DisplayPhotoServlet?photo=" + i + "'>");
				writer.write("<img src='./DisplayPhotoServlet?photo="
				+ i + "' alt='photo' height='120' width='150'>");
				writer.write("</a>");
				writer.write("</td>");
			}
			
		}
		
		private void copyBytes(InputStream is, OutputStream os) throws IOException {
			int i;
			while ((i = is.read()) != -1) {
				os.write(i);
			}
			is.close();
			os.close();
		}
		
		private void displayUserCounter (PhotoAlbum pa, PrintWriter writer, HttpSession session) {
			String whosWatching;
			int viewerCount = pa.getViewerCount(session);
			if (viewerCount == 1) {
				whosWatching = "One person is viewing this album";
			} else {
				whosWatching = viewerCount + " other people are viewing this album";
			}
			writer.write("<h3 align = 'center'>" + whosWatching +"</h3>");
		}

}
