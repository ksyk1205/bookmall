package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;



public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();

	}


	private static void insertTest() {
		System.out.println("==============insert test===============");
		
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		dao.insert(vo1);
		System.out.println(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("예술");
		dao.insert(vo2);
		System.out.println(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setName("컴퓨터/IT");
		dao.insert(vo3);
		System.out.println(vo3);
	}
	
	private static void selectTest() {
		System.out.println("==============select test===============");

		CategoryDao dao = new CategoryDao();

		List<CategoryVo> list = dao.getList();
		for(CategoryVo vo:list) {
			System.out.println(vo);
		}
	}

}