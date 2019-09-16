package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.vo.Order_BookVo;



public class Order_BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();

	}


	private static void insertTest() {
		System.out.println("==============insert test===============");
		
		Order_BookDao dao = new Order_BookDao();
		
		Order_BookVo vo1 = new Order_BookVo();
		vo1.setBook_no((long) 2);
		vo1.setBook_count((long) 1);
		vo1.setOrder_no((long) 1);
		dao.insert(vo1);
		System.out.println(vo1);
	
	}
	
	private static void selectTest() {
		System.out.println("==============select test===============");
		Order_BookDao dao = new Order_BookDao();

		ArrayList list = dao.getList();
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}