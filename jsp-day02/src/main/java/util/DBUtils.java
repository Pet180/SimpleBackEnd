package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	//DB連接參數
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String initSize;
	private static String max;
	private static BasicDataSource ds;
	static{
		//透過Properties對象處理
		Properties prop = new Properties();
		InputStream ips = DBUtils.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		
		try {
			prop.load(ips);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			initSize = prop.getProperty("initSize");
			max = prop.getProperty("max");
			
			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			ds.setInitialSize(Integer.parseInt(initSize));
			ds.setMaxActive(Integer.parseInt(max));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn() throws SQLException{
			Connection conn = ds.getConnection();
		return conn;
		
	}
	
	public static void closeConn(Connection conn){
		
		if (conn!=null) {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection conn) {
 		if (conn!=null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
