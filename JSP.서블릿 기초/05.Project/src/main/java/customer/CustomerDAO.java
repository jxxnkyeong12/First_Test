package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import common.CommonDAO;

public class CustomerDAO extends CommonDAO {  //상속받아오기!

//		private static	SqlSession sql;  그럼 이것들 안써도 돼~

	
	public List<CustomerDTO> getList() {
		List<CustomerDTO> list = sql.selectList("cus.cuslist");
		System.out.println(list.size()); //26개가 맞음~! 
		return list;
	}//
	
	public int deleteInfo(String id) {
		System.out.println("삭제 거치나 확인");
		int result = sql.delete("cus.delete", id);
		return result;
	}//삭제
	
}//class
