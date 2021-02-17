package az.project.l05_statement2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBConnection {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
		} catch (Exception e) {
			logger.warn("MySQL Driver not found");
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/IFA","root","12345");
			logger.info("Connection MySQL ......");
		} catch (Exception e) {
			logger.warn("Can not Connection MySQL");
		}			
		return conn;
	}
	
	public static void closeConnection (Connection conn,Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e2) {
				logger.warn("Error Statement close");
			}
		}		
		
		if(conn !=null) {
			try {
				conn.close();
				logger.info("Connect MySQL");	
			} catch (Exception e2) {
				logger.warn("Can not Connect close MySQL");
			}
		}		
	}
}
