

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePasswordIn
 */
@WebServlet("/ChangePasswordIn")
public class ChangePasswordIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordIn() {
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
			request.setAttribute("id",id);
			request.setAttribute("dispatcherPass", dispatcherPass);
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}
		else if(dispatcherPass.equals("fromAdminList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id",id);
			request.setAttribute("dispatcherPass", dispatcherPass);
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}
		else if(dispatcherPass.equals("fromTechnician"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id",id);
			request.setAttribute("dispatcherPass", dispatcherPass);
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}
		else if(dispatcherPass.equals("fromTechList"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id",id);
			request.setAttribute("dispatcherPass", dispatcherPass);
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}
		
	}

}
