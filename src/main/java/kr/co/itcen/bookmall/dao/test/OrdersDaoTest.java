package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrdersDao;
import kr.co.itcen.bookmall.vo.OrdersVo;



public class OrdersDaoTest {

		public static void main(String[] args) {
			insertTest();
			selectTest();

		}

		private static void insertTest() {
			System.out.println("==============insert test===============");
			
			OrdersDao dao = new OrdersDao();
			
			OrdersVo vo1 = new OrdersVo();
			vo1.setPrice((long) 0);
			vo1.setDeli_address("서울시-----123");
			vo1.setUser_no((long) 1);
			dao.insert(vo1);
			System.out.println(vo1);
			
		}

		
		private static void selectTest() {
			System.out.println("==============select test===============");
			OrdersDao dao = new OrdersDao();

			ArrayList list = dao.getList();
			for(int i =0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}


