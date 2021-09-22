

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.DatabaseConnectivity;
import test1.User;
import test1.UserOperations;

/**
 * Servlet implementation class ListUserTechnician
 */
@WebServlet("/ListUserTechnician")
public class ListUserTechnician extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserTechnician() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DatabaseConnectivity dbObject = new DatabaseConnectivity();
		UserOperations userObject = new UserOperations();
		dbObject.getCon();
		List<User> userList = new ArrayList<>();
		userList = userObject.readUserTechnician();
	;
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("userListTechnician.jsp").forward(request, response);
	}

}
