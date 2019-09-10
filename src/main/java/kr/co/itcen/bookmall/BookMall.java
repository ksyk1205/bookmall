package kr.co.itcen.bookmall;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.dao.OrdersDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.Order_BookVo;
import kr.co.itcen.bookmall.vo.OrdersVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("================category====================");
		
		CategoryDao cg_dao = new CategoryDao();

		List<CategoryVo> cg_list = cg_dao.getList();
		for(CategoryVo vo:cg_list) {
			System.out.println(vo);
			
		}
		System.out.println("=================book========================");	
	
		BookDao b_dao = new BookDao();

		List<BookVo> b_list = b_dao.getList();
		for(BookVo vo:b_list) {
			System.out.println(vo);
		}
		System.out.println("=================order_book===================");
		Order_BookDao ob_dao = new Order_BookDao();

		List<Order_BookVo> ob_list = ob_dao.getList();
		for(Order_BookVo vo:ob_list) {
			System.out.println(vo);
		}
		System.out.println("===================orders=====================");
		OrdersDao o_dao = new OrdersDao();

		List<OrdersVo> o_list = o_dao.getList();
		for(OrdersVo vo:o_list) {
			System.out.println(vo);
		}
		System.out.println("===================cart========================");
		CartDao c_dao = new CartDao();

		List<CartVo> c_list = c_dao.getList();
		for(CartVo vo:c_list) {
			System.out.println(vo);
		}
		System.out.println("===================user=========================");
		UserDao u_dao = new UserDao();

		List<UserVo> u_list = u_dao.getList();
		for(UserVo vo:u_list) {
			System.out.println(vo);
		}
}
}
