package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public List<Order_BookVo> getList() {
		List<Order_BookVo> result = new ArrayList<Order_BookVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select no,book_no,book_count,order_no"
					+ " from order_book order by no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				Long book_no=rs.getLong(2);
				Long book_count=rs.getLong(3);
				Long order_no=rs.getLong(4);
				
				
				Order_BookVo vo = new Order_BookVo();
				vo.setNo(no);
				vo.setBook_no(book_no);
				vo.setBook_count(book_count);
				vo.setOrder_no(order_no);

				result.add(vo);
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
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();

			String sql = "delete from order_book";
			pstmt = connection.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
