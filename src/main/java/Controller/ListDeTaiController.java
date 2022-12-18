package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import DAO.UserDAO;
import DAOImpl.DeTaiDAOImpl;
import DAOImpl.UserDAOImpl;
import Entity.DeTai;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/listDT" })
public class ListDeTaiController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO user = new UserDAOImpl();
	DeTaiDAO dao = new DeTaiDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		if (user.checkUserInNhom(u.getUid()) == false) {
			
			List<DeTai> list = dao.getAllDeTai();
			req.setAttribute("list", list);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/list_detai.jsp");
			dispatcher.forward(req, resp);
		} else {
			DeTai detail = dao.getDeTaiByID(dao.getIDdeTai(u.getUserName()));
			req.setAttribute("detail", detail);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/deTaiSV.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
