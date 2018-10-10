package lab.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		Person visiteur = new Person();
		visiteur.setFirstName(request.getParameter("firstName"));
		visiteur.setLastName(request.getParameter("lastName"));
		visiteur.setBirthDay(request.getParameter("birthDay"));
		visiteur.setSex(request.getParameter("sex"));
		request.setAttribute("bean", visiteur);
		String year = visiteur.getBirthDay().substring(visiteur.getBirthDay().length() - 4);
		
		if(Integer.parseInt(year)<1990) {
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/old.jsp");
			dispatcher.include(request, response);
		}
		else {
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/young.jsp");
			dispatcher.include(request, response);
		}
	}

}
