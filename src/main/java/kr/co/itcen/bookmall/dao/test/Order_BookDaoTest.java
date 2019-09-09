package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.vo.Order_BookVo;



public class Order_BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteAllTest();
	}


	private static void deleteAllTest() {
		new Order_BookDao().delete();
		
	}


	private static void insertTest() {
		System.out.println("==============insert test===============");
		
		Order_BookDao dao = new Order_BookDao();
		
		Order_BookVo vo1 = new Order_BookVo();
		vo1.setBook_no((long) 22);
		vo1.setBook_count((long) 2);
		vo1.setOrder_no((long) 5);
		dao.insert(vo1);
		System.out.println(vo1);
		


		
	}

	
	private static void selectTest() {
		System.out.println("==============select test===============");
		Order_BookDao dao = new Order_BookDao();

		List<Order_BookVo> list = dao.getList();
		for(Order_BookVo vo:list) {
			System.out.println(vo);
		}
	}
}