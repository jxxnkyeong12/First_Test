import com.hanul.fruit.FruitDAO;
import com.hanul.fruit.FruitDTO;

public class FruitMain {
	public static void main(String[] args) {
		FruitDTO[] fruit = new FruitDTO[5];
		fruit[0] = new FruitDTO("사과", 1500, 11);
		fruit[1] = new FruitDTO("바나나", 4000, 3);
		fruit[2] = new FruitDTO("망고", 3000, 6);
		
		FruitDTO dto1 = new FruitDTO();
		dto1.setName("키위");
		dto1.setCost(1000);;
		dto1.setQty(33);
		fruit[3] = dto1;
		
		FruitDTO dto2 = new FruitDTO();
		dto2.setName("딸기");
		dto2.setCost(9000);;
		dto2.setQty(2);
		fruit[4] = dto2;
		
		//FruitDAO 객체 생성 시 객체배열(fruit[])을 매개변수로 전달
		FruitDAO dao = new FruitDAO(fruit);
		dao.getPrice();
		dao.priceDescSort();
		dao.display();		
	}//main()
}//class








