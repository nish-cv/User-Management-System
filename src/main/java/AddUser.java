import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test1.User;
import test1.DatabaseConnectivity;
import test1.UserOperations;
import test1.LoginOperations;
import test1.Encryption;
/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    //Default constructor. 

    public AddUser() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		int age = Integer.parseInt(request.getParameter("age"));
		long contact = Long.parseLong(request.getParameter("contact"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorText = "";
		
		Encryption encObj = new Encryption();
		password = encObj.encrypt(password);
		User user = new User(age,contact,address,firstname,lastname,username,password);
		
		DatabaseConnectivity dbObject = new DatabaseConnectivity();
		UserOperations userObject = new UserOperations();
		LoginOperations loginObj = new LoginOperations();
	    dbObject.getCon();
		if(loginObj.isUserName(username))
		{
			errorText = "The entered username already exists";
			request.setAttribute("errorText",errorText);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		else if(userObject.addUser(user))
		{
			errorText = "Added Successfully!";
			request.setAttribute("errorText",errorText);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		else
		{
			errorText = "Addition failed";
			request.setAttribute("errorText",errorText);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}

	}

}
