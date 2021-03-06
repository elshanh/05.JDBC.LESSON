package az.project.l03_connection3;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionExam {
	
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
	
	public static void closeConnection (Connection conn) {
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
