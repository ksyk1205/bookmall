package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrdersVo;


public class OrdersDao {
	public Boolean insert(OrdersVo vo1) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs =null;
		Boolean result = false;
		
		try {
			connection = getConnection();
			String sql= "insert into orders values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo1.getPrice());
			pstmt.setString(2, vo1.getDeli_address());
			pstmt.setLong(3, vo1.getUser_no());

			
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
	public List<OrdersVo> getList() {
		List<OrdersVo> result = new ArrayList<OrdersVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select no, price , deli_address,user_no"
					+ " from orders order by no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				Long price =rs.getLong(2);
				String deli_address =rs.getString(3);
				Long user_no =rs.getLong(4);

				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setPrice(price);
				vo.setDeli_address(deli_address);
				vo.setUser_no(user_no);

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
//	public void delete() {
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			connection = getConnection();
//
//			String sql = "delete from orders";
//			pstmt = connection.prepareStatement(sql);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}


}
