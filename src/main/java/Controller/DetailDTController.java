package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAOImpl.DeTaiDAOImpl;
import Entity.DeTai;

@WebServlet(urlPatterns = {"/detail"})
public class DetailDTController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DeTaiDAO dao = new DeTaiDAOImpl();
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		
		DeTai detail = dao.getDTByID(id);
		req.setAttribute("detail", detail);
       
		req.getRequestDispatcher("/detail_detai.jsp").forward(req, resp);
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
