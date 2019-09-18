package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import kr.co.itcen.bookmall.vo.Order_BookVo;

public class Order_BookDao {
	public Boolean insert(Order_BookVo vo1) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs =null;
		Boolean result = false;



		try {
			connection = getConnection();
			String sql= "insert into order_book values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo1.getBook_no());
			pstmt.setLong(2, vo1.getBook_count());
			pstmt.setLong(3, vo1.getOrder_no());


			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo1.setNo(no);

			}

			String sql1 = "select price from book where no=?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setLong(1, vo1.getBook_no());
			rs=pstmt.executeQuery();
			long total_price = 0; 

			while(rs.next()) {
				long price = rs.getLong(1);
				total_price = (long) (price*vo1.getBook_count());
			}

			String sql2 = "select price from orders where no=?";
			pstmt = connection.prepareStatement(sql2);
			pstmt.setLong(1, vo1.getOrder_no());
			rs=pstmt.executeQuery(); 

			while(rs.next()) {
				int price =rs.getInt(1);
				total_price+=price;

			}

			String sql3 ="update orders set price=? where no=?";

			pstmt = connection.prepareStatement(sql3);

			pstmt.setLong(1, total_price);									
			pstmt.setLong(2, vo1.getOrder_no());

			pstmt.executeUpdate();



		} catch (SQLException e) {
			System.out.println("error: "+e);
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	

	}
	public ArrayList getList() {
		ArrayList result = new ArrayList();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select a.book_no,b.title,a.book_count"
					+ " from order_book a, book b"
					+ " where a.book_no =b.no";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String book_title=rs.getString(2);
				Long book_count=rs.getLong(3);



				ArrayList temp = new ArrayList();
				temp.add("orderbook_no = "+no);
				temp.add("orderbook_title = "+book_title);
				temp.add("orderbook_count = "+book_count);


				result.add(temp);
			}


		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	private Connection getConnection() throws SQLException {
		Connection connection  =null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.1.73:3306/bookmall?characterEncoding=utf8";
			connection= DriverManager.getConnection(url, "bookmall", "bookmall");


		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver : "+ e);
		}
		return connection;

	}



}
