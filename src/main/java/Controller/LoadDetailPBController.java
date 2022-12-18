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
import Entity.User;

@WebServlet(urlPatterns = { "/detailPB" })
public class LoadDetailPBController extends HttpServlet {
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
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDAO user = new UserDAOImpl();
		List<User> giangvien = user.getGVPBByCN(user.getCNByuid(u.getUid()));
		List<User> gvpb = user.getGVPBByID(id);
		HoiDongDAO dao = new HoiDongDAOImpl();
		HoiDong dt = dao.getHDByID(id);
		req.setAttribute("gv", giangvien);
		req.setAttribute("gvpb", gvpb);
		req.setAttribute("detail", dt);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/phanBien.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDAO user = new UserDAOImpl();
		List<User> giangvien = user.getGVPBByCN(user.getCNByuid(u.getUid()));
		List<User> gvpb = user.getGVPBByID(id);
		HoiDongDAO dao = new HoiDongDAOImpl();
		HoiDong dt = dao.getHDByID(id);
		req.setAttribute("gv", giangvien);
		req.setAttribute("gvpb", gvpb);
		req.setAttribute("detail", dt);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/phanBien.jsp");
		dispatcher.forward(req, resp);
	}

}
