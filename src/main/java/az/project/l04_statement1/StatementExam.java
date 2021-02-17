package az.project.l04_statement1;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatementExam {
	
	public static void main(String[] args) {
		Logger     logger = LogManager.getLogger();
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
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					logger.warn("Error Statement close");
				}
			}
		}
		
		DBConnection.closeConnection(conn);
	}

}
