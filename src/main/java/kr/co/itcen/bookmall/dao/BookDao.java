package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;



public class BookDao {
	public Boolean insert(BookVo vo1) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			String sql = "insert into book values(null, ?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo1.getTitle());
			pstmt.setLong(2, vo1.getPrice());
			pstmt.setLong(3, vo1.getCategory_no());
			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo1.setNo(no);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}

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

		return result;
	}

	public ArrayList getList() {
		ArrayList result = new ArrayList();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();

			String sql = "select no,title,price,category_no from book order by no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()){
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Long price = rs.getLong(3);
				Long category_no = rs.getLong(4);
				
				ArrayList temp = new ArrayList();
				temp.add(no);
				temp.add(title);
				temp.add(price);
				temp.add(category_no);

				result.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.1.73:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		}

		return connection;
	}


}

