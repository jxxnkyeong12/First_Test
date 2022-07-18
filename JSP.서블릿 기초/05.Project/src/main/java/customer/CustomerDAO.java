package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {

	private static SqlSession sql;
	static {
		
		String resource = "config/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql=	sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			System.out.println("sql연결에서 에러남!");
			e.printStackTrace();
		}//try
	}//static
	
	
	public List<CustomerDTO> getList() {
		List<CustomerDTO> list = sql.selectList("cus.cuslist");
		//System.out.println("고객사이즈 잘 넘어오나 확인용 : "+list.size()); //20 잘넘어옴
		
		return list;
	}//getList
	
	
	public int deleteInfo(String id) {
		System.out.println("삭제DAO거치니");
		return sql.delete("cus.cusdelete", id); //delete는 int타입이라서 int로 받는거야!
	}
	
}//class
