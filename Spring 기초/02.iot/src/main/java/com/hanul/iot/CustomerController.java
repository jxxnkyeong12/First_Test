package com.hanul.iot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	//고객목록화면 요청
	@RequestMapping("/list.cu")
	public String list() {
		//DB에서 고객목록정보를 조회해와 
		//화면에 출력할수 있도록 Model에 attribute로 데이터를 담는다
		//응답화면연결
		return "customer/list";
	}
}
