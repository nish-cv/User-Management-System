

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.DatabaseConnectivity;
import test1.User;
import test1.UserOperations;

/**
 * Servlet implementation class EditUserSetDetails
 */
@WebServlet("/EditUserSetDetails")
public class EditUserSetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserSetDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			user = userObject.readSingleUser(id);
			request.setAttribute("user",user);
			request.getRequestDispatcher("userDetails.jsp").forward(request, response);
		}
		else
			System.out.println("Edit failed!");
	}


}
