package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDAO;
import DAOImpl.TaiKhoanDAOImpl;
import Entity.TaiKhoan;


@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		Boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
		TaiKhoanDAO dao = new TaiKhoanDAOImpl();
		TaiKhoan u = dao.login(username, password);
		if (u == null) {
			request.setAttribute("mess", "Sai tài khoản hoặc mật khẩu!!");
			request.getRequestDispatcher("/loginAccount").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("acc", u);
			session.setMaxInactiveInterval(1000);
			if (remember == true) {
				Cookie uNameCookie = new Cookie("username", username);
				uNameCookie.setMaxAge(24 * 3600);
				Cookie passCookie = new Cookie("pass", password);
				passCookie.setMaxAge(24 * 3600);
				response.addCookie(uNameCookie);
				response.addCookie(passCookie);
			}
			if(u.getRole() == 2)
			{
				response.sendRedirect("dkdt");
			}
			else if (u.getRole() == 1)
			{
				response.sendRedirect("admin");
			}
			else
			{
				response.sendRedirect("home");
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
