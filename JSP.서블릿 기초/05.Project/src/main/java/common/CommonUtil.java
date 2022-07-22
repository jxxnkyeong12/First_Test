package common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonUtil {
	
	//2022.07.21  파일 다운로드처리
	
	public void fileDownload(HttpServletRequest request, HttpServletResponse response, String filename, String filepath) {
		
		//다운로드할 파일 찾기
		filepath =request.getServletContext().getRealPath("/" + filepath); //디렉토리 구분자! 슬레쉬!
		File file =new File(filepath);
		//첨부된 파일의 마임타입을 지정한다
		String mime=request.getServletContext().getMimeType(filename);
		
		try {
			filename = URLEncoder.encode(filename, "utf-8");
			response.setContentType(mime);
			response.setHeader("content-disposition", "attachment; filename=" + filename);
		
		
			//Reader/Writer InputStream/OutputStream
			ServletOutputStream out =response.getOutputStream();
			BufferedInputStream in =new BufferedInputStream( new FileInputStream(file));
			byte buff[] = new byte[1024];  //1024 -> 962 1986
			int read = 0;
			while( (read = in.read(buff) ) != -1) {  //1024만큼씩 읽어들인다
				out.write(buff, 0, read); //0부터 읽어들인(read) 갯수만큼! 
				
			}
			in.close(); //버퍼 닫아주기
		} catch (IOException e) {

		}
		
		
	}
	
	
	
	//2022.07.20 파일 업로드처리
	public HashMap<String, String> fileUpload(HttpServletRequest request, String category) {
		//웹서버에 프로젝트의 물리적인 위치
		String app = request.getServletContext().getRealPath("/");
		//D:\Study_JspServlet\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\05.Project
		// /upload/notice/2022/07/20/abc.txt
		String upload = "upload/" + category + 
				 new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		String filepath = app + upload;
		File dir = new File( filepath );
		if( ! dir.exists() )	dir.mkdirs();
		
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			Collection<Part> files = request.getParts();
			for(Part file : files) {
				System.out.println(file);
				if(file.getName().contains("file") 
						&& !file.getSubmittedFileName().isEmpty() ) { //submit된 이름이 있으면!
					String filename	= file.getSubmittedFileName();
					String uuid = UUID.randomUUID().toString()+ "_" +  filename;
					//shelkfjadkj_abc.txt
					file.write(filepath + "/" + uuid );
					map.put("filename", filename);
					map.put("filepath", upload + "/" + uuid);
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			return map;
	}
	
	
	
	//2022.07.18 2)Http 요청결과를 받는 처리
	public String requestAPI(String apiURL, String property ) { //메소드 오버로딩!
		String result = "";
		
		 try {
		      URL url = new URL(apiURL); //요청 url에 대한 부분
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      con.setRequestProperty("Authorization", property);
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      System.out.print("responseCode="+responseCode);
		      if(responseCode==200) { // 정상 호출
		        br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		      } else {  // 에러 발생
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
		      }
		      String inputLine;
		      StringBuffer res = new StringBuffer();
		      while ((inputLine = br.readLine()) != null) {
		        res.append(inputLine);
		      }
		      br.close();
		      if(responseCode==200) {
		       result = res.toString();
		      }
		    } catch (Exception e) {
		      System.out.println(e);
		    }
		 return result;
	}
	
	//2022.07.18 1)Http 요청결과를 받는 처리
		public String requestAPI(String apiURL ) {
			String result = "";
			
			 try {
			      URL url = new URL(apiURL); //요청 url에 대한 부분
			      HttpURLConnection con = (HttpURLConnection)url.openConnection();
			      con.setRequestMethod("GET");
			      int responseCode = con.getResponseCode();
			      BufferedReader br;
			      System.out.print("responseCode="+responseCode);
			      if(responseCode==200) { // 정상 호출
			        br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			      } else {  // 에러 발생
			        br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			      }
			      String inputLine;
			      StringBuffer res = new StringBuffer();
			      while ((inputLine = br.readLine()) != null) {
			        res.append(inputLine);
			      }
			      br.close();
			      if(responseCode==200) {
			       result = res.toString();
			      }
			    } catch (Exception e) {
			      System.out.println(e);
			    }
			 return result;
		}
		
	
	
	//비밀번호 암호화에 사용할 솔트만들기
	public String generateSalt() {
	SecureRandom random = new SecureRandom();  //암호화문자를 만드는 객체를 생성!
	byte salt[] = new byte[24];
		random.nextBytes(salt);
		
		//각 byte 를 16 진수로 변환
		StringBuffer buf = new StringBuffer();
		for(byte b : salt ) {
			buf.append(String.format("%02x", b));
		}
	
		return buf.toString();
	
	}
	  //솔트를 사용해 문자를 암호화하기
		public String getEncrypt(String pw, String salt) {
			String salt_pw = pw + salt; 
			
			//암호화해쉬함수를 사용해서 암호화시키는 방식을 지정
		    try {
				MessageDigest md  =	MessageDigest.getInstance("SHA-256");
				md.update( salt_pw.getBytes() );
				byte[] digest = md.digest(); //24 + a 니까 배열로 주기
				
				//16진수로 변환
				StringBuffer buf = new StringBuffer();
					for (byte b : digest ) {
						buf.append(String.format("%02x", b));
					}
					salt_pw	= buf.toString();
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    return salt_pw;
		}
			
	
	
	
	//이메일 전송하기 
	public void sendEmail(String email, String name, HttpServletRequest request) {
		
		//1.간단한 이메일전송
		//sendSimpleEmail(email, name);
		
		
		
		//2.파일첨부한 이메일전송
		sendAttachEmail(email,name, request);
		
		
		//3. Html 형식의 이메일전송
		sendHtmlEmail(email, name, request);
		
	}
	
	 //Html 형식의 이메일 전송
	public void sendHtmlEmail(String email, String name, HttpServletRequest request) {
		HtmlEmail mail	= new HtmlEmail();
		mail.setCharset("utf-8");
		mail.setDebug(true);
		mail.setHostName("smtp.naver.com");
		mail.setAuthentication("jxxnkyeong12", "wlsrud12");
		mail.setSSLOnConnect(true);
		
		
		try {
			mail.setFrom("jxxnkyeong12@naver.com", "관리자");
			mail.addTo(email, name);
			mail.setSubject("회원가입을 축하합니다!");
			
			StringBuffer msg = new StringBuffer();
			msg.append("<html>");
			msg.append("<body>");

			msg.append("<h3>오픈소스기반의 IoT과정</h3>");
			msg.append("<a hrdf = 'http://naver.com'><img src ='https://imgnews.pstatic.net/image/660/2022/07/15/0000012405_001_20220715063402703.jpg'></a>");
			msg.append("<hr>");
			msg.append("<div>회원가입을 진심으로 축하합니다~!</div>");
			msg.append("<div>첨부된 가입관련 파일을 확인하세요!</div>");
			msg.append("<div>프로젝트까지 마무리하고 취업에 성공!!!</div>");
			msg.append("</body>");
			msg.append("</html>");
			mail.setHtmlMsg(msg.toString());
			
			
			EmailAttachment file = new EmailAttachment();
			file.setPath(request.getServletContext().getRealPath("files") + "/회원가입.txt");
			
			mail.attach(file);
			mail.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//파일첨부한 이메일전송
	public void sendAttachEmail(String email, String name, HttpServletRequest request) {
		MultiPartEmail mail	= new MultiPartEmail();
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true); 
		
		mail.setAuthentication("jxxnkyeong12", "wlsrud12");  //"관리자의 이메일 아이디", "해당 아이디의 비밀번호"
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("jxxnkyeong12@naver.com", "융합SW관리자"); //"메일 송신자의 이메일 주소", "융합SW관리자"
			mail.addTo(email, name);
			
			mail.setSubject("오픈소스기반형 지능형 IoT 과정 회원가입");
			mail.setMsg("회원가입을 축하합니다!");
			
			//파일첨부하기
			//파일첨부기능을 가진 객체 생성
			
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\과제\\superPhone.txt");
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setPath(request.getServletContext().getRealPath("files") + "/회원가입.txt");
			
			mail.attach(file);
			
			
			
			file = new EmailAttachment();
			file.setURL(new URL(
					"https://imgnews.pstatic.net/image/660/2022/07/15/0000012405_001_20220715063402703.jpg"));
			
			mail.attach(file);
			
			mail.send();
			
		}catch (Exception e) {
			System.out.println("파일첨부한 이메일 전송에서 에러남");
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	//간단한 이메일전송
	private void sendSimpleEmail(String email, String name) {
		//이메일전송 기능을 가진 객체 생성
		SimpleEmail mail =	new SimpleEmail() ;
		
		
		mail.setCharset("utf-8");  //한글깨지지 않고!
		mail.setDebug(true);  //메일전송 과정 확인!
		
		mail.setHostName("smtp.naver.com");//이메일서버지정
		//1.아이디, 비번 입력해서 로그인하기
		//■ mail.setAuthentication("관리자의 이메일 아이디", "해당 아이디의 비밀번호");
		mail.setAuthentication("jxxnkyeong12", "wlsrud12");
		mail.setSSLOnConnect(true);   //2.로그인하기!
		
		//mail.setFrom("관리자 이메일 주소")  abc@naver.com
		try {
			mail.setFrom("jxxnkyeong12@naver.com", "오픈소스 관리자");
			mail.addTo(email, name);//메일 받는 사람 지정
			//mail.addTo("hong@", "홍길동");//메일 받는 사람 지정 여러사람 보내려면 반복문으로 돌리면 된다~!
			//mail.addTo("sim@", "심청");//메일 받는 사람 지정
			
			mail.setSubject("오픈소스기반형 지능형 IoT 과정 회원가입"); //제목쓰기
			mail.setMsg(name + "님, 회원가입을 축하합니다 ^^ ");// 내용을 작성
			
			mail.send();//보내기 버튼 클릭!
			
		} catch (EmailException e) {
			System.out.println("이메일전송쪽에서 오류남!");
			e.printStackTrace();
		}//3.메일을 보내는 사람 지정
		//메일을 받는 사람 지정
		
		
	}
	
}//class
