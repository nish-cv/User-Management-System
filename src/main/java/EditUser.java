

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test1.User;
import test1.UserOperations;;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int id = 0;   

    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		id = Integer.parseInt(request.getParameter("id"));
		User user = null;
		System.out.println(id);
		
		UserOperations userObject = new UserOperations();
		user = userObject.readSingleUser(id);

		
		request.setAttribute("user", user);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
		

	}
}

