package com.sapient.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.service.ExamSerImpl;
import com.sapient.service.IExamSer;
import com.sapient.vo.Answer;
import com.sapient.vo.Question;

/**
 * Servlet implementation class QuizController
 */
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IExamSer ser = ExamSerImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuizController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private String startExam(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		ServletConfig cfg = getServletConfig();
		int noofquestion = Integer.parseInt(cfg.getInitParameter("pquestions"));
		ServletContext ctx = getServletContext();
		ctx.setAttribute("size", noofquestion);
		List<Question> qlist = ser.generateQuestions(noofquestion);
		Map<Integer, Answer> amap = new HashMap<>();
		sess.setAttribute("ansmap", amap);
		sess.setAttribute("queslist", qlist);
		sess.setAttribute("curridx", 0);
		request.setAttribute("question", qlist.get(0));
		String view = "QuizView.jsp";
		return view;
	}

	private String getNextPrevFinish(HttpServletRequest request) {
		String view = "";
		String btn = request.getParameter("btn");
		HttpSession sess = request.getSession();
		List<Question> qlist = (List<Question>) sess.getAttribute("queslist");
		int idx = (int) sess.getAttribute("curridx");

		Map<Integer, Answer> amap = (Map<Integer, Answer>) sess.getAttribute("ansmap");
		int qid = Integer.parseInt(request.getParameter("quesId"));
		String ans = request.getParameter("ques");
		Answer obj = new Answer(qid, ans);
		amap.put(obj.getQid(), obj);
		switch (btn) {
		case "next":
			request.setAttribute("question", qlist.get(++idx));
			view = "QuizView.jsp";
			sess.setAttribute("curridx", idx);

			break;
		case "prev":
			view = "QuizView.jsp";
			request.setAttribute("question", qlist.get(--idx));
			sess.setAttribute("curridx", idx);

			break;
		case "finish":
			List<Answer> alist = new ArrayList<>();
			alist.addAll(amap.values());
			int score = ser.evaluate(alist);
			request.setAttribute("score", score);
			request.setAttribute("ansmap", sess.getAttribute("ansmap"));
			request.setAttribute("queslist", sess.getAttribute("queslist"));
			sess.invalidate();
			view = "QuizScore.jsp";
		}
		return view;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();
		System.out.println(url);
		RequestDispatcher rd = null;
		String view = null;

		if (url.equals("/OnLineQuiz2/start")) {
			view = startExam(request);
		} else if (url.equals("/OnLineQuiz2/quiz")) {
			view = getNextPrevFinish(request);
		} else {
			view = "";
		}
		rd = request.getRequestDispatcher(response.encodeURL(view));
		rd.forward(request, response);

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
