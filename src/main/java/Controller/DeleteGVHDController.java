package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HoiDongDAO;
import DAOImpl.HoiDongDAOImpl;

@WebServlet(urlPatterns = {"/deleteGVkhoiHD"})
public class DeleteGVHDController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HoiDongDAO dao = new HoiDongDAOImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	int id = Integer.parseInt(request.getParameter("id"));
		String uid = request.getParameter("uid");
        dao.deleteGVHD(id, uid);
        request.setAttribute("message", "Xoá giảng viên ra hội đồng thành công!!!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detailPB?id=" + id);
		dispatcher.forward(request, response);
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
