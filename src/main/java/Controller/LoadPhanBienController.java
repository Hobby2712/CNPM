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

import DAO.HoiDongDAO;
import DAO.UserDAO;
import DAOImpl.HoiDongDAOImpl;
import DAOImpl.UserDAOImpl;
import Entity.HoiDong;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/listPB" })
public class LoadPhanBienController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		
		UserDAO user = new UserDAOImpl();
		HoiDongDAO dao = new HoiDongDAOImpl();
		List<HoiDong> dt = dao.getHDByCN(user.getCNByuid(u.getUid()));
		req.setAttribute("list", dt);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list_PB.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		
		UserDAO user = new UserDAOImpl();
		HoiDongDAO dao = new HoiDongDAOImpl();
		List<HoiDong> dt = dao.getHDByCN(user.getCNByuid(u.getUid()));
		req.setAttribute("list", dt);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list_PB.jsp");
		dispatcher.forward(req, resp);
	}

}
