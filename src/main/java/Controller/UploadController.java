package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.BaoCaoDAO;
import DAOImpl.BaoCaoDAOImpl;
import Entity.BaoCao;



@MultipartConfig
@WebServlet(urlPatterns = { "/UploadFile" })
public class UploadController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5078314176508557220L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		req.getRequestDispatcher("nopBC.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		BaoCaoDAO dao = new BaoCaoDAOImpl();
		BaoCao bc = new BaoCao();
		
		Path uploadPath = Paths.get("D:\\Hoc Tap\\Nam3\\LT Web\\eclipse-workspace\\CNPM\\src\\main\\webapp\\uploads");
		
		if (!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}
		
		Part documentPart = req.getPart("document");
		
		String documentFilename = Paths.get(documentPart.getSubmittedFileName()).getFileName().toString();
		String chude = req.getParameter("tiltle");
		String noidung = req.getParameter("content");
		bc.setChude(req.getParameter("tiltle"));
		bc.setNoidung(req.getParameter("content"));
		bc.setFileName(documentFilename);
		dao.insert(bc);
		documentPart.write(Paths.get(uploadPath.toString(),documentFilename).toString());
		String message = "Nộp báo cáo thành công !";
		
		req.setAttribute("message", message);
		req.setAttribute("document", documentFilename);
		req.setAttribute("noidung", noidung);
		req.setAttribute("chude", chude);
		
		req.getRequestDispatcher("resultBC.jsp").forward(req, resp);
	}
}
