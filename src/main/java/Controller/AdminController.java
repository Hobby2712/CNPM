package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAO.TaiKhoanDAO;
import DAOImpl.DeTaiDAOImpl;
import DAOImpl.TaiKhoanDAOImpl;
import Entity.DeTai;

@WebServlet(urlPatterns = { "/admin" })
public class AdminController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		DeTaiDAO dao = new DeTaiDAOImpl();
		TaiKhoanDAO tk = new TaiKhoanDAOImpl();
		List<DeTai> dtList = dao.getDeTai();
		int countDT = dao.soDT();
		int countTK = tk.soTK();
		
		req.setAttribute("countDT", countDT);
		req.setAttribute("countTK", countTK);
		req.setAttribute("list", dtList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
		dispatcher.forward(req, resp);
	}

}
