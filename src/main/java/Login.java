
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test1.User;
import test1.DatabaseConnectivity;
import test1.LoginOperations;
import test1.Encryption;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String errorText = "The username/password entered is not valid";
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		Encryption encObj = new Encryption();
		password = encObj.encrypt(password);
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		dbObj.getCon();
		LoginOperations loginObj = new LoginOperations();
		User user = loginObj.loginValidation(username, password);
		if(user==null)
		{
			request.setAttribute("errorText",errorText);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			if(loginObj.isAdmin(username, password))
			{
				response.sendRedirect("admin.jsp");
			}
			else if(loginObj.isTechnician(username, password))
			{
				request.setAttribute("user",user);
				request.getRequestDispatcher("technician.jsp").forward(request, response);
			}
			else
			{	
				request.setAttribute("user",user);
				request.getRequestDispatcher("userDetails.jsp").forward(request, response);
			}
		}
		
	}

}
