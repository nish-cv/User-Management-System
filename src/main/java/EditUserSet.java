

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test1.*;
/**
 * Servlet implementation class EditUserSet
 */
@WebServlet("/EditUserSet")
public class EditUserSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditUserSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		long contact = Long.parseLong(request.getParameter("contact"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		
		System.out.println(id + " " +  age + firstname);
		User user = new User(id,age,contact,address,firstname,lastname);
		DatabaseConnectivity dbObject = new DatabaseConnectivity();
		UserOperations userObject = new UserOperations();
		
		dbObject.getCon();
		if(userObject.editUser(user))
		{
			System.out.println("Edit Successfully!");
			request.getRequestDispatcher("ListUser").forward(request, response);
		}
		else
			System.out.println("Edit failed!");
	}


}
