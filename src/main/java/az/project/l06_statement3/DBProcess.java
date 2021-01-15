package az.project.l06_statement3;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBProcess {
	
	private final Logger  logger = LogManager.getLogger();
	
	public void createPersonTable() {
		
		Connection conn   = DBConnection.getConnection();
		Statement  st     = null;
		
		try {
			st = (Statement)conn.createStatement();
			String sqlCreateTable = "Create Table person(ID VARCHAR(20),NAME VARCHAR(50),SURNAME VARCHAR(50))";
			st.execute(sqlCreateTable);
			logger.info("Create table for Person");
		} catch (Exception e) {
			logger.warn("Can not Create table");
		}finally {
			DBConnection.closeConnection(conn,st);
		}			
	}

}
