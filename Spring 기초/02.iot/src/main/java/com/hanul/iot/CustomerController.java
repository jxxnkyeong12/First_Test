package com.hanul.iot;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import customer.CustomerServiceImpl;
import customer.CustomerVO;

@Controller
public class CustomerController {

	@Autowired private CustomerServiceImpl service;
	
	//고객정보 삭제처리 요청
	@RequestMapping("/delete.cu")
	public String delete(int id) {
		//해당 고객정보를 DB에서 삭제한 후 : 비지니스로직
		service.customer_delete(id);
		//응답화면연결
		return "redirect:list.cu";
	}
	
	//고객 정보 수정저장 처리 요청
	@RequestMapping("/update.cu")
	public String update(CustomerVO vo) {
		//화면에서 변경입력한 정보를 DB에 변경저장하고 :비지니스로직
		service.customer_update(vo);
		
		//응답할 화면 연결
		return "redirect: detail.cu?id="+ vo.getId();
	}
	
	
	//고객 정보 수정하는 화면 요청
	@RequestMapping("/modify.cu")
	public String modify(Model model, int id) {
		//DB에서 해당고객정보를 조회해와
		CustomerVO vo =service.customer_detail(id);
		//수정화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		//응답할 화면 연결
		 return "customer/modify";
		 		
	}
	
	
	//신규고객정보 저장처리 요청
	@RequestMapping("/insert.cu")
	public String insert(CustomerVO vo) {  //데이터 객체 한꺼번에 담기
		//화면에서 입력한 정보를 DB에 신규저장한 후 : 비지니스 로직
		service.customer_insert(vo);
		
		//응답할 화면연결
		return "redirect:list.cu";
	}
	
	//신규고객입력화면 요청
	@RequestMapping("/new.cu")
	public String customer() {
		//응답할 화면 연결
		return "customer/new";
	}
	
	
	
	//고객상세화면 요청
	@RequestMapping("/detail.cu")
   public String detail(int id, Model model) { //아무것도 지정하지 않으면 request 파라메터! 이건 문자열이니까 String -> 근데 Spring에서는 알아서 바꿔줘서 int로 !
	   //화면에서 선택한 고객의 정보를 DB에서 조회한 후 :비지니스로직
	   CustomerVO vo = service.customer_detail(id);
		//화면에 출력할 수 있도록 Model에 담는다
	   model.addAttribute("vo", vo);
	   //응답할 화면 연결
	   return "customer/detail";
   }
	
	
	
	//고객목록화면 요청
	@RequestMapping("/list.cu")
	public String list(Model model, HttpSession session) {
		session.setAttribute("category", "cu");
		
		//DB에서 고객목록정보를 조회해와 : 비지니스로직
		List<CustomerVO> list = service.customer_list();
		
		//화면에 출력할수 있도록 Model에 attribute로 데이터를 담는다
		model.addAttribute("list", list);
		//응답화면연결
		return "customer/list";
	}
}
