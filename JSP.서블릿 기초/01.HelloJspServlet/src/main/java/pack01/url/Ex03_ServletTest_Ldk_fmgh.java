package pack01.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet의 안의 클래스 이름이 아니라 webServlet 어노테이션 안에 들어있는 String값을 변경 해주면 돼 => 짧게! 
@WebServlet("/Ex03")
public class Ex03_ServletTest_Ldk_fmgh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex03_ServletTest_Ldk_fmgh() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
