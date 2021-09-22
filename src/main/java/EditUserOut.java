

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
 * Servlet implementation class EditUserOut
 */
@WebServlet("/EditUserOut")
public class EditUserOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String dispatcher = "";
		dispatcher = request.getParameter("dispatcher");
		if(dispatcher.equals("fromAdminList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int age = Integer.parseInt(request.getParameter("age"));
			long contact = Long.parseLong(request.getParameter("contact"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			
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
		else if(dispatcher.equals("fromUser"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int age = Integer.parseInt(request.getParameter("age"));
			long contact = Long.parseLong(request.getParameter("contact"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			
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
		else if(dispatcher.equals("fromTechnician"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int age = Integer.parseInt(request.getParameter("age"));
			long contact = Long.parseLong(request.getParameter("contact"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
		
			User user = new User(id,age,contact,address,firstname,lastname);
			DatabaseConnectivity dbObject = new DatabaseConnectivity();
			UserOperations userObject = new UserOperations();
			
			dbObject.getCon();
			if(userObject.editUser(user))
			{
				System.out.println("Edit Successfully!");
				user = userObject.readSingleUser(id);
				request.setAttribute("user",user);
				request.getRequestDispatcher("technician.jsp").forward(request, response);
			}
			else
				System.out.println("Edit failed!");
		}
		else if(dispatcher.equals("fromTechList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int age = Integer.parseInt(request.getParameter("age"));
			long contact = Long.parseLong(request.getParameter("contact"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			
			User user = new User(id,age,contact,address,firstname,lastname);
			DatabaseConnectivity dbObject = new DatabaseConnectivity();
			UserOperations userObject = new UserOperations();
			
			dbObject.getCon();
			if(userObject.editUser(user))
			{
				System.out.println("Edit Successfully!");
				request.getRequestDispatcher("ListUserTechnician").forward(request, response);
			}
			else
				System.out.println("Edit failed!");
		}
	}

}
