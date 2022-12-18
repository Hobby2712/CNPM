package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TaiKhoanDAO;
import DAO.UserDAO;
import DAOImpl.TaiKhoanDAOImpl;
import DAOImpl.UserDAOImpl;
import Entity.TaiKhoan;
import Entity.User;

@WebServlet(urlPatterns = {"/addAccount"})
public class AddAcountController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6340653606352378946L;
	TaiKhoanDAO tkdao = new TaiKhoanDAOImpl();
	UserDAO userdao = new UserDAOImpl();
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		try {
			TaiKhoan tk = new TaiKhoan();
			User user = new User();
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			tk.setUserName(req.getParameter("username"));
			tk.setPass(req.getParameter("pass"));
			tk.setUid(req.getParameter("uid"));
			tk.setRole(Integer.parseInt(req.getParameter("role")));
			
			
			user.setuId(req.getParameter("uid"));
			user.setFullName(req.getParameter("name"));
			user.setAddress(req.getParameter("address"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("sdt"));
			user.setChuyenNganh(Integer.parseInt(req.getParameter("cn")));
			user.setGioiTinh(req.getParameter("gioiTinh"));
			
			
			userdao.insert(user);
			tkdao.insertAccount(tk);
			req.setAttribute("message", "Đã tạo tài khoản thành công");
			RequestDispatcher dispatcher = req.getRequestDispatcher("listTK");
			dispatcher.forward(req, resp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

	
	
}
