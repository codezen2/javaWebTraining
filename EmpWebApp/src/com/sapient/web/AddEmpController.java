package com.sapient.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sapient.dao.DaoFactory;
import com.sapient.dao.IDao;
import com.sapient.vo.Emp;

/**
 * Servlet implementation class AddEmpController
 */
public class AddEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDao dao = DaoFactory.getDaoInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpg");
		String imgname = request.getParameter("iname");
		FileInputStream fis = new FileInputStream("d:\\photos\\" + imgname);
		byte[] arr = new byte[fis.available()];
		fis.read(arr);
		ServletOutputStream out = response.getOutputStream();
		out.write(arr);
		out.close();
		fis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File tempPath = new File("d:\\temp\\");
		if (!tempPath.exists()) {
			tempPath.mkdirs();
		}

		File perPath = new File("d:\\photos");
		if (!perPath.exists()) {
			perPath.mkdirs();
		}

		Emp emp = new Emp(0, null, 0.0, 0, null);
		String ext = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(tempPath);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> files = upload.parseRequest(request);
			for (FileItem fi : files) {
				if (fi.isFormField()) {
					switch (fi.getFieldName()) {
					case "txtid":
						emp.setEmpId(Integer.parseInt(fi.getString()));
						break;
					case "txtname":
						emp.setEmpName(fi.getString());
						break;
					case "txtpass":
						emp.setPwd(fi.getString());
						break;
					case "txtsal":
						emp.setSal(Double.parseDouble(fi.getString()));
						break;
					case "txtdept":
						emp.setDeptId(Integer.parseInt(fi.getString()));
						break;

					}

				} else {
					String fname = fi.getName();
					ext = fname.substring(fname.lastIndexOf("."));
					File file = new File(perPath, emp.getEmpId() + ext);
					fi.write(file);

				}
			}
			emp.setDoj(LocalDate.now());
			emp.setImg(emp.getEmpId() + ext);
			dao.addEmployee(emp);
			request.setAttribute("msg", "your account created successfully");
			ServletContext ctx = getServletContext();
			List<Emp> lst = (List<Emp>) ctx.getAttribute("elist");
			lst.add(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.setAttribute("msg", "cannot be created, Id already exist");
		}

		String view = response.encodeURL("Main.jsp");
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
