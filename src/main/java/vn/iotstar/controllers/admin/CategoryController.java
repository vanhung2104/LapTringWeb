package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/update", "/admin/category/edit", "/admin/category/delete" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "uploads";
	public ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/admin/categories")) {
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("cateList", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel cateModel = cateService.findById(id);

			req.setAttribute("cate", cateModel);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel cateModel = cateService.findById(id);
			cateService.delete(cateModel);
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("cateList", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			CategoryModel category = new CategoryModel();
			String categoryname = req.getParameter("categoryname");
			String image = req.getParameter("image");
			int status = Integer.parseInt(req.getParameter("status"));

			// đưa dữ liệu vào model
			category.setCategoryname(categoryname);
			category.setImage(image);
			category.setStatus(status);

			Part part = req.getPart("image1");
			String fname = getFileName(part);
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists())
				uploadDir.mkdir();
			try {
				if (part.getSize() > 0){
                    part.write(uploadPath + fname);
                    category.setImage(fname);
             }
             else if (!image.isEmpty()){
                     category.setImage(image);
             }
             else
                     category.setImage("avatar.png");
			} catch (FileNotFoundException fne) {

				req.setAttribute("message", "There was an error: " + fne.getMessage());
			}
			// gọi phương thức insert và truyền model vào
			cateService.insert(category);
			if (cateService.checkName(categoryname)) {
				System.out.println("thất bại");
			} else {
				System.out.println("thành công");
			}
			// trả về views
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		} else if (url.contains("/admin/category/edit")) {

		}
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return Constant.DIR;
	}
}
