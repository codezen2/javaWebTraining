package com.sapient.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.dao.DaoFactory;
import com.sapient.dao.IDao;
import com.sapient.exception.NotFoundException;
import com.sapient.vo.Emp;

/**
 * Servlet implementation class EmpViewController
 */
public class EmpViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDao dao = DaoFactory.getDaoInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpViewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		RequestDispatcher rd = null;
		String view = null;
		switch (uri) {
		case "/EmpWebApp/viewall":
			view = viewAll(request);
			break;
		case "/EmpWebApp/update":
			view = updateEmp(request);
			break;
		case "/EmpWebApp/viewbydept":
			view = viewByDept(request);
			break;
		}

		rd = request.getRequestDispatcher(response.encodeURL(view));
		rd.forward(request, response);
	}

	private String viewByDept(HttpServletRequest request) {
		int did = Integer.parseInt(request.getParameter("txtdid"));
		List<Emp> lst = (List<Emp>) dao.viewEmployeeByDept(did);
		request.setAttribute("emplist", lst);
		return "EmpView.jsp";

	}

	private String updateEmp(HttpServletRequest request) {
		int eid = Integer.parseInt(request.getParameter("hideid"));
		double sal = Double.parseDouble(request.getParameter("txtsal"));
		ServletContext ctx = getServletContext();
		String strpgid = request.getParameter("pgid");
		String view = "";

		if (request.getParameter("requri").startsWith("txtdid"))
			view = "viewbydept?"+request.getParameter("requri");
		else
			view = "viewall?pg=" + Integer.parseInt(strpgid);

		try {
			dao.updateEmployee(eid, sal);
			request.setAttribute("msg", "Employee salary for " + eid + " is updated.");
			ctx.setAttribute("elist", dao.viewEmployee());
		} catch (NotFoundException e) {
			request.setAttribute("msg", "Employee salary not updated");
			e.printStackTrace();
		}
		return view;
	}

	private String viewAll(HttpServletRequest request) {
		ServletContext ctx = getServletContext();
		String strpg = request.getParameter("pg");
		int pgno = 1;
		if (strpg == null)
			pgno = 1;
		else
			pgno = Integer.parseInt(strpg);

		int end = pgno * 3;
		int start = end - 3;

		List<Emp> lst = (List<Emp>) ctx.getAttribute("elist");
		if (end >= lst.size())
			end = lst.size();
		List<Emp> sublst = lst.subList(start, end);

		request.setAttribute("emplist", sublst);
		request.setAttribute("pgno", pgno);
		ctx.setAttribute("esize", Math.ceil(lst.size() / 3.0));

		return "EmpView.jsp";

	}

	@Override
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		ctx.setAttribute("elist", dao.viewEmployee());
		ctx.setAttribute("dlist", dao.getDepts());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
