import com.hanul.book.BookDAO;
import com.hanul.book.BookDTO;

public class BookMain {
	public static void main(String[] args) {
		BookDTO[] book = new BookDTO[3];
		book[0] = new BookDTO("JAVA", "신용권", "한빛", 24000, 11);
		book[1] = new BookDTO("View", "김은옥", "삼양", 28000, 15);
		book[2] = new BookDTO("SQL", "개발팀", "한울", 15000, 13);
		
		BookDAO dao = new BookDAO();
		dao.getPrice(book);	//가격계산
		dao.display(book);	//출력
	}//main()
}//class
