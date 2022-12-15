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

@WebServlet(urlPatterns = {"/delAcc"})
public class DeleteAccountController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TaiKhoanDAO dao = new TaiKhoanDAOImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
        String uName = request.getParameter("tk");
        dao.deleteAccount(uName);
        request.setAttribute("message", "Xoá thành công!!!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("listTK");
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
