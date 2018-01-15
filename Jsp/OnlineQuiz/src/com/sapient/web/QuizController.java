package com.sapient.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.service.ExamSerImpl;
import com.sapient.service.IExamSer;
import com.sapient.vo.Question;

/**
 * Servlet implementation class QuizController
 */
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IExamSer ser=ExamSerImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private String startExam(HttpServletRequest request)
    {
		HttpSession sess=request.getSession();
    	ServletConfig cfg=getServletConfig();
		int noofquestion=Integer.parseInt(cfg.getInitParameter("pquestions"));
		List<Question> qlist=ser.generateQuestions(noofquestion);
    	sess.setAttribute("queslist", qlist);
		sess.setAttribute("curridx", 0);
		request.setAttribute("question", qlist.get(0));
		String view="QuizView.jsp";
    	return view;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ashdhasjkd");

		String url=request.getRequestURI();
		System.out.println(url);
		/*String url=request.getRequestURI();
		System.out.println(url);
		RequestDispatcher rd=null;
		String view=null;
	
		switch(url)
		{
		case "/OnlineQuiz/start":
			System.out.println("jjj");
			view=startExam(request);
			break;
			
		default:
		}
	
		rd=request.getRequestDispatcher(response.encodeURL(view));
		rd.forward(request, response);*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
