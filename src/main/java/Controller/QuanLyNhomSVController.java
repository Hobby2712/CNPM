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
import Entity.TaiKhoan;
import Entity.User;

@WebServlet(urlPatterns = { "/loadTV" })
public class QuanLyNhomSVController extends HttpServlet {
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
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		
		UserDAO dao = new UserDAOImpl();
		List<User> list = dao.getTVNhom(detai.getIDdeTai(u.getUserName()));
		req.setAttribute("list", list);
		
	
		User info = dao.getInfo(u.getUserName());
		req.setAttribute("info", info);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/QLNhom_SV.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		
		UserDAO dao = new UserDAOImpl();
		List<User> list = dao.getTVNhom(detai.getIDdeTai(u.getUserName()));
		req.setAttribute("list", list);
		
	
		User info = dao.getInfo(u.getUserName());
		req.setAttribute("info", info);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/QLNhom_SV.jsp");
		dispatcher.forward(req, resp);
	}
}
