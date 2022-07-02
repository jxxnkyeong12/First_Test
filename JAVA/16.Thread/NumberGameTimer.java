import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//AWT, SWING : JAVA에서 제공하는 GUI 기능 ▶ 현재는 거의 사용하지 않는다.
public class NumberGameTimer extends JFrame implements ActionListener{
	JButton gameStart;
	
	public NumberGameTimer() {
		setTitle("Number Game with Timer");	//제목표시줄
		setSize(500, 550);	//Frame(창)의 크기
		setLocationRelativeTo(null);	//화면 중앙에 실행
		setVisible(true);	//화면에 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기버튼 클릭 시 Frame(창) 종료
		setLayout(null);	//컴포넌트(구성요소) 레이아웃 설정
		this.getContentPane().setBackground(Color.WHITE);	//배경색 설정
		
		gameStart = new JButton("Game Start!");	//버튼 컴포넌트 생성
		gameStart.setBounds(150, 180, 160, 60);	//버튼의 위치와 크기
		add(gameStart);	//Frame에 등록
		gameStart.setBorder(null);	//버튼 테두리
		gameStart.addActionListener(this);		//버튼 이벤트
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object == gameStart) {	//gameStart 버튼 눌러졌을 때
			GameGui game = new GameGui();	//Runnable Interface를 상속받은 객체를 생성
			Thread thGame = new Thread(game);	//진짜 Thread 객체를 생성
			thGame.start();	//Thread 실행
			
			dispose();	//현재 화면(Frame)만 종료
		}		
	}//actionPerformed()
	
	public static void main(String[] args) {
		new NumberGameTimer();
	}//main()		
}//class


//중첩클래스 : 게임 화면 구성 및 이벤트 처리
class GameGui extends JFrame implements Runnable, ActionListener{
	//컴포넌트 선언 및 생성
	JButton[] number = new JButton[25];
	String[] numberStr = new String[25];
	Random rnd = new Random();
	int rndValue;
	int[] rndValueCheck = new int[25];
	int[] numberCheck = new int[25];
	JLabel resultLabel = new JLabel("결과");
	JLabel resultTimerLabel = new JLabel();
	JLabel realTimerLabel = new JLabel();
		
	@Override
	public void run() {
		setTitle("Number Game with Timer");	//제목표시줄
		setSize(500, 550);	//Frame(창)의 크기
		setLocationRelativeTo(null);	//화면 중앙에 실행
		setVisible(true);	//화면에 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기버튼 클릭 시 Frame(창) 종료
		setLayout(null);	//컴포넌트(구성요소) 레이아웃 설정
		this.getContentPane().setBackground(Color.WHITE);	//배경색 설정
		
		realTimerLabel.setBounds(200, 5, 200, 50);	//타이머 위치
		realTimerLabel.setFont(new Font("Gothic", Font.BOLD, 30));	//타이머 글꼴
		
		RealTime realTime = new RealTime(realTimerLabel);	//타이머 객체 생성
		Thread thread = new Thread(realTime);	//진짜 쓰레드 객체
		
		add(realTimerLabel);	//타이머 등록
		repaint();	//새로고침
		
		thread.start();	//쓰레드 실행
		
		for(int i = 0; i <= 24; i++) {
			numberStr[i] = Integer.toString(i + 1);	//버튼 숫자 생성
			number[i] = new JButton(numberStr[i]);	//버튼 생성 및 숫자 등록
			number[i].setSize(95, 90);	//버튼의 크기
			number[i].setFont(new Font("Gothic", Font.BOLD, 30));	//버튼 숫자 글꼴
			if(i <= 23) {
				number[i].addActionListener(this);	//이벤트 처리를 위한 리스너 연동
			}
			this.numberCheck[i] = 0;
			rndValueCheck[i] = 0;
		}//for
		
		for(int i = 0; i <= 24; i++) {
			while(true) {
				rndValue = rnd.nextInt(25);
				if(rndValueCheck[rndValue] != 1) {
					break;
				}//if
			}//while
			
			number[rndValue].setLocation((i % 5) * 95, (i / 5) * 90 + 50);
			add(number[rndValue]);
			rndValueCheck[rndValue] = 1;
		}//for		
		
	}//run()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		numberCheck[0] = 1;
		for(int i = 0; i <= 24; i++) {
			if(i <= 23) {
				if(object == number[i]) {
					while(true) {
						if(numberCheck[i] == 1) {
							number[i].setEnabled(false);
							number[i].setVisible(false);
							numberCheck[i + 1] = 1;
						}//if
						break;
					}//while
				}//if
			}else if(i == 24) {
				if(numberCheck[24] == 1) {
					number[24].addActionListener(this);
				}//if
			}//if
		}//for
		
		if(object == number[24]) {
			resultLabel.setBounds(200, 150, 100, 40);
			resultLabel.setFont(new Font("Gothic", Font.BOLD, 30));
			resultLabel.setForeground(Color.black);
			add(resultLabel);
			
			resultTimerLabel.setBounds(170, 220, 150, 40);
			resultTimerLabel.setText(realTimerLabel.getText() + "초");
			resultTimerLabel.setFont(new Font("Gothic", Font.BOLD, 30));
			resultTimerLabel.setForeground(Color.black);
			add(resultTimerLabel);
			repaint();
			
			number[24].setEnabled(false);
			number[24].setVisible(false);
			realTimerLabel.setEnabled(false);
			realTimerLabel.setVisible(false);
		}//if
	}//actionPerformed()
}//class

//중첩클래스 : Timer 기능
class RealTime implements Runnable{
	private JLabel realTimerLabel;
	public RealTime(JLabel realTimerLabel) {
		this.realTimerLabel = realTimerLabel;
	}

	@Override
	public void run() {
		double number = 0;
		while(true) {
			number += 0.01;
			realTimerLabel.setText(String.format("%.2f", number));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}//run()
}//class
