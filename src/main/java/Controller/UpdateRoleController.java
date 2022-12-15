package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TaiKhoanDAO;
import DAOImpl.TaiKhoanDAOImpl;

@WebServlet(urlPatterns = { "/updateRole" })
public class UpdateRoleController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaiKhoanDAO dao = new TaiKhoanDAOImpl();
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		int role = Integer.parseInt(req.getParameter("role"));
		String userName = req.getParameter("tk");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			dao.updateRole(role, userName);
			req.setAttribute("message", "Phân quyền thành công");
			RequestDispatcher dispatcher = req.getRequestDispatcher("listTK");
			dispatcher.forward(req, resp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
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
