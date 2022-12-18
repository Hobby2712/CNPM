package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAO.UserDAO;
import DAOImpl.DeTaiDAOImpl;
import DAOImpl.UserDAOImpl;

@WebServlet(urlPatterns = { "/addNT" })
public class ThemNhomTruongController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DeTaiDAO dao = new DeTaiDAOImpl();
	UserDAO u = new UserDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String uid = req.getParameter("uid");
		try {
			if(u.checkUserInNhom(uid) == false)
			{
				dao.insertNhom(id, uid);
				dao.deleteSVQT(id, uid);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/listDTHD");
				dispatcher.forward(req, resp);
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/listDTHD");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
