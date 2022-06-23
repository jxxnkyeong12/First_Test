package pack01.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//새로 만들었으면 서버 리스타트 엄청 중요해! 
@WebServlet("/Ex02_ServletTest")
public class Ex02_ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_ServletTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내가 왔get2222222");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 왔thㅓ2222222");
		doGet(request, response);
	}

}
