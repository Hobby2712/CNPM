package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAOImpl.DeTaiDAOImpl;

@WebServlet(urlPatterns = {"/duyetDT"})
public class DuyetDeTaiController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeTaiDAO dao = new DeTaiDAOImpl();
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	int id = Integer.parseInt(request.getParameter("id"));
        dao.duyetDeTai(id);
        String url="detailDuyetDT?id="+id;
        request.setAttribute("message", "Duyệt thành công!!!");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
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
