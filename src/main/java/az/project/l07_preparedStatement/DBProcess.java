package az.project.l07_preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBProcess {
	
	private final Logger  logger = LogManager.getLogger();
	
	public void createPersonTable() {
		
		Connection conn   = DBConnection.getConnection();
		PreparedStatement  prSt     = null;
		
		String sqlCreateTable = "Create Table person(ID VARCHAR(20),NAME VARCHAR(50),SURNAME VARCHAR(50))";
		
		try {
			prSt = conn.prepareStatement(sqlCreateTable);
			prSt.execute();
			logger.info("Create table for Person");
		} catch (Exception e) {
			logger.warn("Can not Create table");
		}finally {
			DBConnection.closeConnection(conn,prSt);
		}	
	}

}
