package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns = {"/home","/logout"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("logout")) {
			getlogout(req, resp);
		} else {
			req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
	}
	
	private void getlogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("account"); // remove session
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0); // <=> remove cookie resp.addCookie(cookie); // add again break;
				}
			}
		}
		resp.sendRedirect(req.getContextPath()+"/home");

	}

}
