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
import DAO.HoiDongDAO;
import DAOImpl.DeTaiDAOImpl;
import DAOImpl.HoiDongDAOImpl;
import Entity.DeTai;
import Entity.HoiDong;

@WebServlet(urlPatterns = { "/listHD" })
public class LoadHoiDongController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HoiDongDAO dao = new HoiDongDAOImpl();
		List<HoiDong> list = dao.getAllHD();
		
		DeTaiDAO dt = new DeTaiDAOImpl();
		List<DeTai> dtList = dt.getAllDeTai();
		
		req.setAttribute("list", list);
		req.setAttribute("dt", dtList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/taoHoiDong.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HoiDongDAO dao = new HoiDongDAOImpl();
		List<HoiDong> list = dao.getAllHD();
		
		DeTaiDAO dt = new DeTaiDAOImpl();
		List<DeTai> dtList = dt.getAllDeTai();
		
		req.setAttribute("list", list);
		req.setAttribute("dt", dtList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/taoHoiDong.jsp");
		dispatcher.forward(req, resp);
	}

}
