package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;


/**
 * Servlet implementation class editArtworkServlet
 */
@WebServlet("/editArtworkServlet")
public class editArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArtworkHelper dao = new ArtworkHelper();

		String title = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String value = request.getParameter("value");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		System.out.println("temp ID" + tempId);
		
		Artwork artworkToUpdate = dao.searchForArtworkById(tempId);
		artworkToUpdate.setTitle(title);
		artworkToUpdate.setArtistName(artistName);
		artworkToUpdate.setMedia(media);
		artworkToUpdate.setYear(year);
		artworkToUpdate.setValue(Double.valueOf(value));

		dao.updateArtwork(artworkToUpdate);
		System.out.println("update" + artworkToUpdate);

		getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
	}

}
