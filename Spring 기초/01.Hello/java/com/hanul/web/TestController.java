package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.MemberVO;

@Controller
public class TestController {
	
	
	//로그인 처리 요청 
	@RequestMapping("/login_result")
	public String login(String id, String pw) {
		
		//아이디 /비번이 일치하여 로그인 성공하는 경우
		if(id.equals("admin") && pw.equals("123") ) {
			return"redirect : /"; //redirect 방식 띄어쓰기 해도 된다 ㅎㅇ
			//return "home"; //홈으로 연결! 근데 이건 기본이 forward방식이야. 그래서 홈으로 가도 주소창에 login_result가 떠벌임;
		}else {
			//실패하는 경우
			return "redirect :login";  //reidrect 방식 (깔금하게 해당주소창만 나와)
			//return "member/login"; //forward방식 (주소창에 login_result가그대로 남아있음)
		}
	}
	
	//로그인 화면 요청하기
	@RequestMapping("/login")
	public String login() {
		//응답화면 연결만 하면 된다
		return "member/login";
	}
	
	
	//회원가입 처리 요청: @PathVariable
	@RequestMapping("/joinPath/{name}/{g}/{email}")
	public String join(@PathVariable String name , Model model
						,@PathVariable("g") String gender //근데 그냥 똑같이 맞춰주는게 좋아
						, @PathVariable String email) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("method", "@PathVariable 방식");
		return "member/info";
	}
	
	
	
	//회원가입 처리 요청:데이터객체
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model) {
		model.addAttribute("vo", vo); //여기에 데이터가 다 담겨있어
		model.addAttribute("method", "데이터객체 방식"); 
		
		return "member/info";
	}
	
	
	
	//회원가입 처리 요청:@RequestParam
	@RequestMapping("/joinParam")
	public String join(Model model, @RequestParam String name , @RequestParam String gender
						, @RequestParam("email") String mail) {
		
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", mail);
		model.addAttribute("method", "@RequestParam 방식");
		//응답화면 연결
		return "member/info";
	}
	
	
	
	//회원가입 처리 요청: HttpServletRequest
	
	@RequestMapping("joinRequest")
	public String join(Model model, HttpServletRequest request) {
		//화면에서 입력한 정보를 HttpServletRequest 타입의 메소드로 접근
		//info 화면에 데이터를 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("method", "HttpServletRequest 방식");
		//응답화면연결
		return "member/info";
	}
	

	//회원가입화면 요청
	@RequestMapping("/join")
	public String member() {
		//응답화면을 연결하는 형태
		
		
		return "member/join";
	}
	
	
	@RequestMapping("/second")
	public ModelAndView view() {
		ModelAndView model = new ModelAndView();
		String now = new SimpleDateFormat("a hh시 mm분 ss초").format(new Date());
		model.addObject("now", now);
		model.setViewName("index");
		return model;
	}
	
	
	@RequestMapping("/first")
	public String view(Model model) {
		//화면에 출력할 데이터는 
		//Dynamic Web Project: HttpServletRequest 에 attribute 로 데이터를 담는다
		//                     setAttribute("명", 데이터)
		//Spring: Model 에 attribute 로 데이터를 담는다
		//                addAttribute("명", 데이터)
		String today = new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		model.addAttribute("today", today);
		return "index";
	}
	
}
