import java.util.Scanner;

import com.hanul.game.Character;
import com.hanul.game.Gobook;
import com.hanul.game.Lee;
import com.hanul.game.Pickachu;
import com.hanul.game.Raichu;
import com.hanul.game.SubMenu;

public class GameMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 캐릭터를 선택하세요");
		System.out.print("1.피카츄\t2.이상해씨\t3.꼬부기\t4.라이츄 ▶ ");
		
		Character character = null;
		
		int menu = Integer.parseInt(scanner.nextLine());
		if(menu == 1) {  //1번을 선택했다
			 character = new Pickachu(); //일반적 객체 생성! ->앞에  Character character 가 받게 해줘 ->어? 근데 이거 공통되네? -> 맨위에 Character character = nu11; 값을 줘!
		}else if( menu ==2){//2번 선택했다
			 character	= new Lee();
		}else if( menu == 3) { //3번 선택했다
			 character = new Gobook();
		}else if(menu == 4) {
			 character = new Raichu();
		}else {
			System.out.println("잘못 선택하셨습니다!");
		}//if
		
		SubMenu sm = new SubMenu(scanner); //①scanner객체를 넘겨주겠다 
		sm.playGame(character); //playGame에 character을 넘기겠다
		
	}//main()
}//class
