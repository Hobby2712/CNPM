package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HoiDongDAO;
import DAO.UserDAO;
import DAOImpl.HoiDongDAOImpl;
import DAOImpl.UserDAOImpl;

@WebServlet(urlPatterns = { "/addGVvaoHD" })
public class ThemGVvaoHDController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HoiDongDAO dao = new HoiDongDAOImpl();
	UserDAO u = new UserDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String uid = req.getParameter("uid");

		try {
			if (dao.soGVTrongHD(id) < dao.soGVYCHD(id)) {
				if (u.checkUserInHD(id, uid) == false) {
					dao.insertGVHD(id, uid);

					req.setAttribute("message", "Đã thêm giảng viên phản biện!!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("/detailPB?id=" + id);
					dispatcher.forward(req, resp);
				} else {
					req.setAttribute("message", "Giảng viên đã có trong hội đồng!!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("/detailPB?id=" + id);
					dispatcher.forward(req, resp);
				}
			}
			else{
				req.setAttribute("message", "Hội đồng đã đủ thành viên!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/detailPB?id=" + id);
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
