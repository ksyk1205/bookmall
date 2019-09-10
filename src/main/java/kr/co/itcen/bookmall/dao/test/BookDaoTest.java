package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;


public class BookDaoTest {


	public static void main(String[] args) {
		insertTest();
		selectTest();


	}


	private static void insertTest() {
		System.out.println("==============insert test===============");

		BookDao dao = new BookDao();

		BookVo vo1 = new BookVo();
		vo1.setTitle("빨간머리앤");
		vo1.setPrice((long) 15000);
		vo1.setCategory_no((long)1);
		dao.insert(vo1);
		System.out.println(vo1);

		BookVo vo2 = new BookVo();
		vo2.setTitle("방구석 미술관");
		vo2.setPrice((long) 10000);
		vo2.setCategory_no((long)2);
		dao.insert(vo2);
		System.out.println(vo2);

		BookVo vo3 = new BookVo();
		vo3.setTitle("안드로이드 프로그래밍");
		vo3.setPrice((long) 27000);
		vo3.setCategory_no((long)3);
		dao.insert(vo3);
		System.out.println(vo3);
	}

	private static void selectTest() {
		System.out.println("==============select test===============");

		BookDao dao = new BookDao();

		ArrayList list = dao.getList();
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
