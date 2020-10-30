package com.test.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		System.out.println(login + " - " + password);
		if (login == null ) login = "";
		if (password == null ) password = "";
		
		response.setContentType ( "text/html" );
		try ( PrintWriter out = response.getWriter() ) {
			out.print( "<!DOCTYPE html>\n" );
			out.print( "<html>\n"	);
			out.print( "<head>\n"	);
			out.print( "		<title>Veuillez vous authentifier</title>\n"	);
			out.print( "		<link rel='stylesheet' type ='text/css' href='style.css' /> \n"	);
			out.print( "	</head>\n" );
			out.print( "	<body>\n"	);
			out.print( "		<h1> Veuillez vous authentifier</h1>\n" );
			out.print( "		<h2>" + new Date() + "</h2>\n" );
			
			out.print("          <form method='post' action='login'> \n" );
			out.print("          <label for='txtLogin'> Login : </label> \n" );
			out.print("          <input name='txtLogin' type='value'" + login + "' autofocus /> <br/> \n" );
			out.print("          <label for='txtPassword'>  Password : </label> \n" );
			out.print("          <input name='txtPassword' type='password'" + password + "'/> <br/>\n" );
			
			out.print( " 		  <br/> \n" );
			out.print("           <input name='btnConnect' type='submit' /> <br/>\n" );
			
			out.print("</form>");
			
			out.print( "	</body>\n" );
			out.print( "</html>\n" );
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		System.out.println("in the doPost");
		if ( login.equals("admin") && password.equals("admin") ) {
			response.setContentType( "text/html" );
			try ( PrintWriter out = response.getWriter() ) {
				out.println("Vous êtes connecté");
			}
			
		} else {
		doGet(request, response);
	}

}
}
