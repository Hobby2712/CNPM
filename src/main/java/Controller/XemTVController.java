package Controller;

import java.io.IOException;
import java.util.List;

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
import Entity.User;

@WebServlet(urlPatterns = { "/xemTV" })
public class XemTVController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeTaiDAO detai = new DeTaiDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDAO dao = new UserDAOImpl();
		List<User> list = dao.getAllTVNhom(id);
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/xemTV_GV.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDAO dao = new UserDAOImpl();
		List<User> list = dao.getAllTVNhom(id);
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/xemTV_GV.jsp");
		dispatcher.forward(req, resp);
	}

}
