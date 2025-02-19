import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class PhotoAlbum {
	
	private PhotoAlbum () {
	}

	public static String ATTRIBUTE_NAME = "Photo_Album";
	private List <byte []> photoDataList = new ArrayList<byte []> ();
	private List <String> names = new ArrayList<String> ();
	
	public static String SERVLET_CONTEXT_SESSION_LIST = "servlet_context_session_list";
	
	public static PhotoAlbum getPhotoAlbum(HttpSession session) {
		if(session.getAttribute(ATTRIBUTE_NAME) == null) {
			PhotoAlbum pa = new PhotoAlbum();
			session.setAttribute(ATTRIBUTE_NAME, pa);
		}
		if (!(session.getAttribute(ATTRIBUTE_NAME) instanceof PhotoAlbum))
			return null;
		
		return (PhotoAlbum) session.getAttribute(ATTRIBUTE_NAME);
	}
	
	public synchronized void addPhoto(String name, byte[] bytes) {
		if (!this.names.contains(name)) {
			this.photoDataList.add(bytes);
			this.names.add(name);
		}
	}
	
	public synchronized byte [] getPhotoData(int i) {
		return (byte []) photoDataList.get(i);
	}
	
	public synchronized String getPhotoName(int i) {
		return (String) names.get(i);
	}
	
	public synchronized int getPhotoCount() {
		return photoDataList.size();
	}

	public synchronized void removePhoto(int i) {
		if (!photoDataList.isEmpty()) {
			this.photoDataList.remove(i);
			this.names.remove(i);
		}
	}
	
	public int getViewerCount(HttpSession session) {
		ServletContext servletContext = session.getServletContext();
		List sessions = (List) servletContext
				.getAttribute(SERVLET_CONTEXT_SESSION_LIST);
		if(sessions != null) {
			return sessions.size();
		} else {
			return 0;
		}
	}
	
  }
