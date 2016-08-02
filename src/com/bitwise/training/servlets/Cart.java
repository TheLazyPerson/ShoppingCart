package com.bitwise.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class Cart
 */
//@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer,String> map=new HashMap<Integer,String>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
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
		PrintWriter out =response.getWriter();
		if(request.getParameter("add")!=null){
		      String[] shopingItems = request.getParameterValues("items");
              for(int i=0;i<shopingItems.length;i++){
                    map.put(new Integer(i+1),shopingItems[i]);
              }
              for(Map.Entry<Integer, String> entry : map.entrySet()){  
              }
        }
        else if(request.getParameter("Delete")!=null){
              
              int key=Integer.parseInt(request.getParameter("delete"));
              map.remove(key);
              out.println("Item deleted successfully\n\n");

        }

	}

}
