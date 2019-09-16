package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;


public class CartDao {
	public Boolean insert(CartVo vo1) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs =null;
		Boolean result = false;
		
		try {
			connection = getConnection();
			String sql= "insert into cart values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo1.getBook_count());
			pstmt.setLong(2, vo1.getUser_no());
			pstmt.setLong(3, vo1.getBook_no());

			
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
	public ArrayList getList() {
		ArrayList result = new ArrayList();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql ="select a.title, b.book_count , a.price*b.book_count "
					+ "from book a , cart b  "
					+ "where a.no =b.book_no order by b.no asc";
			pstmt = connection.prepareStatement(sql);


			rs = pstmt.executeQuery();

			while (rs.next()) {
				String title =rs.getString(1);
				Long book_count =rs.getLong(2);
				Long price =rs.getLong(3);

				 
				ArrayList temp = new ArrayList();
				temp.add(title);
				temp.add(book_count);
				temp.add( price);


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
