import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//AWT, SWING : JAVA에서 제공하는 GUI
public class LottoGameSwing {
	//컴포넌트 선언 (그림 생성돼)
	JFrame frame;
	
	JTextArea output;
	
	JPanel panel; 	//밑에 버튼들 하나로 관리하는게 panel!
	
	JButton startBtn;
	
	JButton clearBtn;
	
	//생성자 메소드 : 코드구현 → 객체가 생성될 때 동작되는 메소드
	public LottoGameSwing() {
		//컴포넌트 생성
		frame = new JFrame();
		output = new JTextArea();
		panel = new JPanel();
		startBtn = new JButton("번호생성");
		clearBtn = new JButton("번호삭제");
		
		//startBtn과 clearBtn 을 panel에 묶어준다(등록
		panel.add(startBtn);
		panel.add(clearBtn);
		
		//output의 글꼴 스타일을 변경
		output.setFont(new Font("굴림", Font.BOLD, 20));
		
		//frame에 output와panel배치
		frame.getContentPane().add(new JScrollPane(output),BorderLayout.CENTER);
		frame.getContentPane().add(panel,BorderLayout.SOUTH);
		
		//frame 속성 설정
		frame.setTitle("Lotto Game");		//제목표시줄 출력내용
		frame.setSize(300, 300); 			//window크기
		frame.setVisible(true);   			//화면에 표시
		frame.setLocationRelativeTo(null);  //화면 중앙에 표시
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //닫기 단추 클릭시 완전 종료 ->이거 안하면 화면꺼도 console은 계속 돌아가
		
		//이벤트 처리를 위한 Listener 클래스와 연계
		startBtn.addActionListener(new StartBtnListener());
		clearBtn.addActionListener(new ClearBtnListener());
	
	}//
	
	//번호생성 이벤트 클래스 : 중첩클래스
	class StartBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			LottoGame game = new LottoGame();
			int[] lotto = game.getNumber();
			for (int i = 0; i < lotto.length; i++) {
				if(lotto[i]<10) {
					output.append("0" + lotto[i]+"  ");
				}else {
					if(i<lotto.length -1) {
						output.append(lotto[i] + "  ");
					}else {
						output.append(lotto[i]+ ""); 	//문자로 인식하게끔 ""넣어줘
					}//if
				}//if
			}//for
			output.append("\n");
		}
	}//class 
	
	
	//번호삭제 이벤트 클래스 : 중첩클래스
	class ClearBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			output.setText(""); 	//빈칸산입
			
		}
		
	}//class 
	
	public static void main(String[] args) {
		new LottoGameSwing(); 		//LottoGameSwing 객체 생성
	}//main()
}//class
