package az.project.l02_connection2;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionExam {
	
	private static Connection con = null;
	private static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		openConnection();
		closeConnection();
	}
	
	private static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
		} catch (Exception e) {
			logger.warn("MySQL Driver not found");
			return;
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IFA","root","12345");
			logger.info("Connection MySQL ......");
		} catch (Exception e) {
			logger.warn("Can not Connection MySQL");
		}		
	}
	private static void closeConnection() {
		if(con !=null) {
			try {
				con.close();
				logger.info("Connect MySQL");	
			} catch (Exception e2) {
				logger.warn("Can not Connect close MySQL");
			}
		}
	}	
}
