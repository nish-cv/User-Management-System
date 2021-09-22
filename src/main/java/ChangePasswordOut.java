

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.Encryption;
import test1.LoginOperations;
import test1.User;
import test1.UserOperations;

/**
 * Servlet implementation class ChangePasswordOut
 */
@WebServlet("/ChangePasswordOut")
public class ChangePasswordOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String dispatcherPass = "";
		dispatcherPass = request.getParameter("dispatcherPass");
		
		if(dispatcherPass.equals("fromUser"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String newpassword = request.getParameter("newpassword");
			LoginOperations loginObj = new LoginOperations();
			Encryption encObj = new Encryption();
			newpassword = encObj.encrypt(newpassword);
			String errorText="";
			if(loginObj.changePassword(id, newpassword))
			{	
				errorText = "Password successfully changed!Login with new password to continue.";
				request.setAttribute("errorText",errorText);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				errorText = "Password change failed!";
				request.setAttribute("errorText",errorText);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(dispatcherPass.equals("fromAdminList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String newpassword = request.getParameter("newpassword");
			LoginOperations loginObj = new LoginOperations();
			Encryption encObj = new Encryption();
			newpassword = encObj.encrypt(newpassword);
			String errorText="";
			if(loginObj.changePassword(id, newpassword))
			{	
				errorText = "Password successfully changed";
				request.setAttribute("errorText",errorText);
				UserOperations userObject = new UserOperations();
				List<User> userList = new ArrayList<>();
				userList = userObject.readUser();
				request.setAttribute("userList", userList);
				request.getRequestDispatcher("userList.jsp").forward(request, response);
			}
			else
			{
				errorText = "Password change failed!";
				request.setAttribute("errorText",errorText);
				request.getRequestDispatcher("userList.jsp").forward(request, response);
			}
		}
		else if(dispatcherPass.equals("fromTechnician"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String newpassword = request.getParameter("newpassword");
			LoginOperations loginObj = new LoginOperations();
			Encryption encObj = new Encryption();
			newpassword = encObj.encrypt(newpassword);
			String errorText="";
			if(loginObj.changePassword(id, newpassword))
			{	
				errorText = "Password successfully changed!Login with new password to continue.";
				request.setAttribute("errorText",errorText);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				errorText = "Password change failed!";
				request.setAttribute("errorText",errorText);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(dispatcherPass.equals("fromTechList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String newpassword = request.getParameter("newpassword");
			LoginOperations loginObj = new LoginOperations();
			Encryption encObj = new Encryption();
			newpassword = encObj.encrypt(newpassword);
			String errorText="";
			if(loginObj.changePassword(id, newpassword))
			{	
				errorText = "Password successfully changed";
				request.setAttribute("errorText",errorText);
				UserOperations userObject = new UserOperations();
				List<User> userList = new ArrayList<>();
				userList = userObject.readUserTechnician();
				request.setAttribute("userList", userList);
				request.getRequestDispatcher("userListTechnician.jsp").forward(request, response);
			}
			else
			{
				errorText = "Password change failed!";
				request.setAttribute("errorText",errorText);
				request.getRequestDispatcher("userListTechnician.jsp").forward(request, response);
			}
		}
	}

}
