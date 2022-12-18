package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAOImpl.DeTaiDAOImpl;
import Entity.DeTai;

@WebServlet(urlPatterns = { "/detailDuyetDT" })
public class LoadDeTailDuyetDTController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		
		DeTaiDAO dao = new DeTaiDAOImpl();
		DeTai dt = dao.getDeTaiByID(id);
		req.setAttribute("dt", dt);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/duyetDT_detail.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		
		DeTaiDAO dao = new DeTaiDAOImpl();
		DeTai dt = dao.getDeTaiByID(id);
		req.setAttribute("dt", dt);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/duyetDT_detail.jsp");
		dispatcher.forward(req, resp);
	}

}
