
package co.micol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author suna 작성일자 : 20191107 상위DAO객체
 */
public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds; // 커넥션pool 사용을 위한 데이터연결 생성 객체
//
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String user = "jo";
//	String password = "jo";

	public DAO() {
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}