package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;


public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
//		deleteAllTest();
	}


//	private static void deleteAllTest() {
//		new UserDao().delete();
//		
//	}


	private static void insertTest() {
		System.out.println("==============insert test===============");
		
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		vo1.setName("곽세연");
		vo1.setPhone_number("010-1111-1111");
		vo1.setEmail("seyeon1@gmail.com");
		vo1.setPassword("1111");
		vo1.setAddress("서울시 -----1");
		dao.insert(vo1);
		System.out.println(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setName("곽세연2");
		vo2.setPhone_number("010-1122-1122");
		vo2.setEmail("seyeon2@gmail.com");
		vo2.setPassword("2222");
		vo2.setAddress("서울시 -----2");
		dao.insert(vo2);
		System.out.println(vo2);

		
	}

	
	private static void selectTest() {
		System.out.println("==============select test===============");
		UserDao dao = new UserDao();

		List<UserVo> list = dao.getList();
		for(UserVo vo:list) {
			System.out.println(vo);
		}
	}
}
