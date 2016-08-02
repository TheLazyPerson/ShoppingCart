package com.bitwise.training.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationServlet
 */
//@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String> loginData = new HashMap<>(); 
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (loginData.isEmpty()) {
			loginData.put("trial@bitwiseglobal.com", "1234");
			loginData.put("harsh@bitwiseglobal.com", "1234");
			loginData.put("pooja@bitwiseglobal.com", "1234");
			loginData.put("taher@bitwiseglobal.com", "1234");
			loginData.put("om@bitwiseglobal.com", "1234");
			loginData.put("akanksha@bitwiseglobal.com", "1234");
			
		}
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, String> messages = new HashMap<String, String>();

        if (username == null || username.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {
            if (loginData.get(username).equals(password)) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/Index.jsp");
                return;
            } else {
                messages.put("login", "Unknown login, please try again");
            }  
        }
        
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
}
