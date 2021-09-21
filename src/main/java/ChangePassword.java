import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test1.LoginOperations;
import test1.Encryption;
/**
 * Servlet implementation class changePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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

}
