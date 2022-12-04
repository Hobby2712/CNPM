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
import DAOImpl.DeTaiDAOImpl;
import Entity.DeTai;

@WebServlet(urlPatterns = { "/listDT" })
public class ListDeTaiController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		DeTaiDAO dao = new DeTaiDAOImpl();
		List<DeTai> list = dao.getAllDeTai();
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list_detai.jsp");
		dispatcher.forward(req, resp);
	}

}
