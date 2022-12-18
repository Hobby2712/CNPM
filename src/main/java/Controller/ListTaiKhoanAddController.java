package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TaiKhoanDAO;
import DAOImpl.TaiKhoanDAOImpl;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/listTKadd" })
public class ListTaiKhoanAddController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3937012525574296903L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		TaiKhoanDAO dao = new TaiKhoanDAOImpl();
		List<TaiKhoan> list = dao.getAllTaiKhoan();
		req.setAttribute("listTK", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/addAccout.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		TaiKhoanDAO dao = new TaiKhoanDAOImpl();
		List<TaiKhoan> list = dao.getAllTaiKhoan();
		req.setAttribute("listTK", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/addAccout.jsp");
		dispatcher.forward(req, resp);
	}

	
}
