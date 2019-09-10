package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;



public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
//		deleteAllTest();
	}


//	private static void deleteAllTest() {
//		new CartDao().delete();
//		
//	}


	private static void insertTest() {
		System.out.println("==============insert test===============");
		
		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		vo1.setBook_count((long) 2);
		vo1.setUser_no((long) 1);
		vo1.setBook_no((long) 2);
		dao.insert(vo1);
		System.out.println(vo1);
		
		


		
	}

	
	private static void selectTest() {
		System.out.println("==============select test===============");
		CartDao dao = new CartDao();

		ArrayList list = dao.getList();
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}