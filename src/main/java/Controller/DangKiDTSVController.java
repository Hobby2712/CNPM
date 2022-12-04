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

@WebServlet(urlPatterns = { "/dkdtsv" })
public class DangKiDTSVController extends HttpServlet {

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
		int detai = Integer.parseInt(req.getParameter("dt"));

		if (dao.checkDotDKSV() == true) {
			dao.insertNhom(detai, u.getUid());
			req.setAttribute("message", "Đã đăng kí thành công");
		} else {
			req.setAttribute("message", "Chưa tới đợt đăng ký");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("detail");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		int detai = Integer.parseInt(req.getParameter("dt"));

		if (dao.checkDotDKSV() == true) {
			dao.insertNhom(detai, u.getUid());
			req.setAttribute("message", "Đã đăng kí thành công");
		} else {
			req.setAttribute("message", "Chưa tới đợt đăng ký");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("detail");
		dispatcher.forward(req, resp);

	}
}
