import java.text.DecimalFormat;
import java.util.Iterator;

//행위정보(기능, 동작)를 저장하는 Class ▶ 메소드의 집합체
//DAO Class를 통해 DataBase에 접속하고 사용자의 요청을 처리-이게 백엔드!
public class BookDAO {
	//출력 메소드 : getter method
	public void display(BookDTO[] book) {
		DecimalFormat df = new DecimalFormat("￦#,##0");
		System.out.println("제목\t저자\t출판사\t가격");
		System.out.println("=============================");
		
		for (int i = 0; i < book.length; i++) {
				System.out.print(book[i].getTitle() + "\t");
				System.out.print(book[i].getName() + "\t");
				System.out.print(book[i].getCompany() + "\t");
				System.out.print(df.format(book[i].getPrice()) + "\n"); //마지막은 \n으로 바꿔줘~ 
			}//for
			
		System.out.println("=============================");
	}//display
		
}
