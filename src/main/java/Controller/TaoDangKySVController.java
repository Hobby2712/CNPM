package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TaoDangKyDAO;
import DAOImpl.TaoDangKyDAOImpl;

import Entity.TaoDangKy;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/dotDangKySV")
public class TaoDangKySVController extends HttpServlet {

	TaoDangKyDAO dao = new TaoDangKyDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/detai.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaoDangKy dk = new TaoDangKy();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		
		String bd = req.getParameter("ngayBD");
		String newbd = bd.replace("T", " ");
		String kt = req.getParameter("ngayKT");
		String newkt = kt.replace("T", " ");
		
		dk.setNgayBD(Date.valueOf(newbd.substring(0, 10)));
		dk.setNgayKT(Date.valueOf(newkt.substring(0, 10)));

		
		
		if (dao.checkDKSV() == true) {
			dao.updateDKSV(dk);
		} else {
			dao.insertDKSV(dk);
		}

		req.setAttribute("message", "Đã tạo đợt đăng kí cho sinh viên thành công");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("detai.jsp");
		dispatcher.forward(req, resp);
	}
	
}
