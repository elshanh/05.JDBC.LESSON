/*
         ***** ATTENTION *****
	DataBase Info
MySQL DB location   =>  localhost
MySQL DB port         =>  3306
MySQL DB name       =>  IFA
MySQL DB user         =>  root
MySQL DB password  => 12345

	Table Info
Table name                =>IFA.Person
Table column name1   =>ID (int)
Table column name2   =>NAME (varchar(100))
Table column name3   =>SURNAME(varchar(100))
*/
package az.project.l01_connection1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.jdbc.Driver;

public class ConnectionExam {
	
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.warn("MySQL Driver not Found !");
			return;
		}
		
		Connection connection = null;
		
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/IFA", "root", "12345");
			logger.info("Connection MySQL DataBase !");
		} catch (SQLException e) {
			logger.warn("Connection MySQL DataBase Error !");
		}finally {
			if (connection != null) {
				try {
					connection.close();
					logger.info("Connection Close !");
				} catch (Exception e2) {
					logger.warn("Connection Close Error");
				}
			}
		}
				
		
	}

}
