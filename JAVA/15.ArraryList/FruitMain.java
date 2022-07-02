import java.util.ArrayList;

import com.hanul.fruit.FruitDAO;
import com.hanul.fruit.FruitDTO;

public class FruitMain {
	

	public static void main(String[] args) {
		ArrayList<FruitDTO> fruit = new ArrayList<FruitDTO>();
		fruit.add(new FruitDTO("포도", 18000, 2));
		fruit.add(new FruitDTO("망고", 3000, 13));
		fruit.add(new FruitDTO("참다래", 900, 33));
		fruit.add(new FruitDTO("파인애플", 7000, 5));
		fruit.add(new FruitDTO("토마토", 1500, 15));
		
		FruitDAO dao = new FruitDAO(fruit);
		dao.getPrice();
		dao.priceDescSort();
		dao.display();
		dao.displayPrinf();
	}//main()
}//class
