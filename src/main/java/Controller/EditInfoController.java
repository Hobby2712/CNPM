package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DAOImpl.UserDAOImpl;
import Entity.TaiKhoan;
import Entity.User;

@WebServlet(urlPatterns = "/editInfo")
public class EditInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		User info = dao.getInfo(u.getUserName());
		
		dao.editInfo(email, address, phone, info.getuId());
		req.setAttribute("message", "Chỉnh sửa thành công !!!");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("loadEditInfo");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");
		User info = dao.getInfo(u.getUserName());
		
		dao.editInfo(email, address, phone, info.getuId());
		req.setAttribute("message", "Chỉnh sửa thành công !!!");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("loadEditInfo");
		dispatcher.forward(req, resp);
	}

}
