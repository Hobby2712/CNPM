package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDAO;
import DAOImpl.TaiKhoanDAOImpl;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/changePassword" })
public class ChangePassController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");

		String oldpass = request.getParameter("password_old");
		String pass = request.getParameter("password_new");
		String repass = request.getParameter("password_confirm");

		if (!pass.equals(repass)) {
			request.setAttribute("message", "Mật khẩu không khớp");
			request.getRequestDispatcher("loadchangePass").forward(request, response);
		} else if (!oldpass.equals(u.getPass().trim())) {
			request.setAttribute("message", "Mật khẩu sai");
			request.getRequestDispatcher("loadchangePass").forward(request, response);
		} else {
			TaiKhoanDAO dao = new TaiKhoanDAOImpl();
			dao.changePass(pass, u.getUserName());
			request.setAttribute("message", "Đổi mật khẩu thành công !!!");
			request.getRequestDispatcher("loadchangePass").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}