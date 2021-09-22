

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.User;
import test1.UserOperations;

/**
 * Servlet implementation class EditUserIn
 */
@WebServlet("/EditUserIn")
public class EditUserIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserIn() {
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
			User user = null;
			UserOperations userObject = new UserOperations();
			user = userObject.readSingleUser(id);
			request.setAttribute("user", user);
			request.setAttribute("dispatcher", dispatcher);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
		}
		else if(dispatcher.equals("fromUser"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			User user = null;
			
			UserOperations userObject = new UserOperations();
			user = userObject.readSingleUser(id);
			request.setAttribute("user", user);
			request.setAttribute("dispatcher", dispatcher);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
		}
		else if(dispatcher.equals("fromTechnician"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			User user = null;
			UserOperations userObject = new UserOperations();
			user = userObject.readSingleUser(id);
			request.setAttribute("user", user);
			request.setAttribute("dispatcher", dispatcher);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
		}
		else if(dispatcher.equals("fromTechList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			User user = null;
			UserOperations userObject = new UserOperations();
			user = userObject.readSingleUser(id);
			request.setAttribute("user", user);
			request.setAttribute("dispatcher", dispatcher);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
		}
		
	}

}
