package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import DAOImpl.DeTaiDAOImpl;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/huyDT" })
public class HuyDeTaiController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DeTaiDAO dao = new DeTaiDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");

		dao.deleteTV(dao.getIDdeTai(u.getUserName()), u.getUid());

		RequestDispatcher dispatcher = req.getRequestDispatcher("listDT");
		dispatcher.forward(req, resp);
	}

}
