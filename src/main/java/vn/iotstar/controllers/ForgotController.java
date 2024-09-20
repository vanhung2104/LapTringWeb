package vn.iotstar.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import java.io.IOException;

/**
 * Servlet implementation class ForgotController
 */
@WebServlet(urlPatterns = { "/forgot" })
public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/views/forgot.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("UTF-8");
		// Nhận dữ liệu từ request URL
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		String alertMsg = "";
		if (!password.equals(repassword)) {
			alertMsg = "Mật khẩu không khớp!!!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
			return;
		}

		IUserService service = new UserServiceImpl();
		UserModel user = service.findByUsername(username);
		if (user != null) {
			if (!email.equals(user.getEmail())) {
				alertMsg = "Email không đúng!!!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
				return;
			}
			service.resetpassword(username, email, password);
			alertMsg = "Đã đổi mật khẩu thành công,vui lòng đăng nhập";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
		} else {
			alertMsg = "Tài khoản không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
		}
	}
}
