

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test1.UserOperations;
import test1.DatabaseConnectivity;
import test1.User;
/**
 * Servlet implementation class ListUser
 */
@WebServlet("/ListUser")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListUser() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		DatabaseConnectivity dbObject = new DatabaseConnectivity();
		UserOperations userObject = new UserOperations();
		dbObject.getCon();
		List<User> userList = new ArrayList<>();
		userList = userObject.readUser();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

}
