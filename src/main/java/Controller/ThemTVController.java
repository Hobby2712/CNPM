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
import DAO.UserDAO;
import DAOImpl.DeTaiDAOImpl;
import DAOImpl.UserDAOImpl;
import Entity.DeTai;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/addTV" })
public class ThemTVController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DeTaiDAO dao = new DeTaiDAOImpl();
	UserDAO user = new UserDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		String uid = req.getParameter("uid");
		DeTai dt = dao.getDeTaiByID(dao.getIDdeTai(u.getUserName()));
		if (user.checkUserInNhom(uid) == false) {
			if (dao.soLuongSV(dao.getIDdeTai(u.getUserName())) < dt.getSoLuong()) {

				dao.insertTV(dao.getIDdeTai(u.getUserName()), uid);
				dao.deleteSVQT(dao.getIDdeTai(u.getUserName()), uid);
				req.setAttribute("message", "Đã thêm thành công");

				RequestDispatcher dispatcher = req.getRequestDispatcher("themTV");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("message", "Đã đủ số lượng!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("themTV");
				dispatcher.forward(req, resp);
			}
		} else {
			req.setAttribute("message", "Sinh viên này đã có nhóm!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("themTV");
			dispatcher.forward(req, resp);
		}
	}

}
