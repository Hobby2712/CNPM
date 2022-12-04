package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import DAOImpl.DeTaiDAOImpl;
import Entity.DeTai;
import Entity.TaiKhoan;

@WebServlet(urlPatterns = { "/dangki" })
public class DangKiDTController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DeTaiDAO dao = new DeTaiDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DeTai dt = new DeTai();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");

		dt.setTenDT(req.getParameter("tenDT"));
		dt.setNienKhoa(Integer.parseInt(req.getParameter("nienKhoa")));
		dt.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));
		dt.setIsKhacCN(Integer.parseInt(req.getParameter("isKhacCN")));
		dt.setSanPham(req.getParameter("sanPham"));
		dt.setLoaiDT(Integer.parseInt(req.getParameter("loaiDT")));
		dt.setMucTieu(req.getParameter("mucTieu"));
		dt.setYeuCau(req.getParameter("yeuCau"));
		dt.setGVHD(u.getUid());

		if (dao.checkDotDKGV() == true) {
			dao.insertDT(dt);
			req.setAttribute("message", "Đã đăng kí thành công");
		} else {
			req.setAttribute("message", "Chưa tới đợt đăng ký");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("dkdt");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DeTai dt = new DeTai();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		TaiKhoan u = (TaiKhoan) session.getAttribute("acc");

		dt.setTenDT(req.getParameter("tenDT"));
		dt.setNienKhoa(Integer.parseInt(req.getParameter("nienKhoa")));
		dt.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));
		dt.setIsKhacCN(Integer.parseInt(req.getParameter("isKhacCN")));
		dt.setSanPham(req.getParameter("sanPham"));
		dt.setLoaiDT(Integer.parseInt(req.getParameter("loaiDT")));
		dt.setMucTieu(req.getParameter("mucTieu"));
		dt.setYeuCau(req.getParameter("yeuCau"));
		dt.setGVHD(u.getUid());

		if (dao.checkDotDKGV() == true) {
			dao.insertDT(dt);
			req.setAttribute("message", "Đã đăng kí thành công");
		} else {
			req.setAttribute("message", "Chưa tới đợt đăng ký");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("dkdt");
		dispatcher.forward(req, resp);

	}
}
