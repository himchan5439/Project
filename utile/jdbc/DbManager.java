package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class DbManager {

	private static final String URL = "jdbc:mysql://localhost/?" 
			+ "useSSL=false&" 
			+ "allowPublicKeyRetrieval=true&"
			+ "ChacterEncoing=UTF8&" 
			+ "severTimezone=TUC&" 
			+ "allowLoadLocalInfile=true&" 
			+ "allowMultiQueries=true";
	private static final String ID = "root";
	private static final String PW = "1234";
	private Connection con;

	public static DbManager db = new DbManager();

	public DbManager() {
		try {
			con = DriverManager.getConnection(URL, ID, PW);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int setData(String sql, Object... vals) {
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			int count = 1;
			for (Object vla : vals) {
				pstmt.setObject(count++, vla);
			}

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public Vector<Vector<String>> getData(String sql, Object... vals) {

		Vector<Vector<String>> table = new Vector<Vector<String>>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			int count = 1;
			for (Object vla : vals) {
				pstmt.setObject(count++, vla);
			}

			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					row.add(rs.getObject(i + 1) + "");// ""를 사용함으로 자료형을 변경
				}
			}

			return table;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}
}
