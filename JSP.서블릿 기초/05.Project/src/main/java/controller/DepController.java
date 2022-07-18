package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employees.DepartmentDAO;
@WebServlet("*.dept")
public class DepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = "";
		DepartmentDAO dao = new DepartmentDAO();
		if(uri.equals("/list.dept")) {
			request.setAttribute("list", dao.getList());
			view = "department/dlist.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
	
	}

}
