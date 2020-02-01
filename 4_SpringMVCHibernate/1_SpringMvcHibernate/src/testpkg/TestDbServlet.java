package testpkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = "root";
		String pass = "coderusx999";
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database +"+url);
			
			Connection con = DriverManager.getConnection(url,uname,pass);
			out.println("success");
			
		}
		catch (Exception e) {
			System.out.println("Exception occured "+e.getMessage());
			e.printStackTrace();
		}
		
	}



}
