package com.xworkz.vaccine.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@SuppressWarnings("serial")
@Controller
@RequestMapping("/")
public class LogoutController extends HttpServlet {
	//private static String email;
	public LogoutController() {
		System.out.println(this.getClass().getSimpleName()+"bean created");
	}

	@RequestMapping("/logout")
	   public void onClickLogout(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		//WelcomeController.email=email;
		HttpSession session=request.getSession();
		session.removeAttribute("email");
		session.invalidate();
		response.sendRedirect("Welcome.jsp");
	}
}
 


/*
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//WelcomeController.email=email;
		
		HttpSession session=request.getSession();
		request.removeAttribute("email");
		session.invalidate();
		response.sendRedirect("Welcome.jsp");
 */

/*
 // Get the print writer object to write into the response
		PrintWriter out = response.getWriter();
		// Set the content type of response to "text/html"
		response.setContentType("text/html");
		// For understanding purpose, print the session object in the console before
		// invalidating the session.
		System.out.println("Session before invalidate: "+ request.getSession(false));
		// Invalidate the session.
		request.getSession(false).invalidate();
		response.sendRedirect("Welcome.jsp");	
		// Print the session object in the console after invalidating the session.
		System.out.println("Session after invalidate: "+ request.getSession(false));

		// Print success message to the user and close the print writer object.
		out.println("Thank you! You are successfully logged out.");
		out.close();
 */


	
/* HttpSession newSession=request.getSession(false);
if(newSession!=null) {
	  newSession.invalidate();
}
response.sendRedirect("Welcome.jsp");*/

	
	/*
@RequestMapping("/logout")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
 
        if(session.getAttribute("WelcomeController.email") != null){
            session.removeAttribute("WelcomeController.email");
            response.sendRedirect("/Welcome.jsp");
        }
    }*/

/* // private static final long serialVersionUID = 1L;
public LogoutController() {
	System.out.println(this.getClass().getSimpleName()+" bean created");
}
 private static final Logger logger=Logger.getLogger(LogoutController.class);
   // doGet() method, <c:url value='/logout' />
@RequestMapping("/logout")
public String logout(HttpServletRequest request) {
	 logger.info("Invoked logout");
	 HttpSession httpSession=request.getSession(); 
	 httpSession.invalidate();
	 return "/Welcome.jsp";
}
}*/
