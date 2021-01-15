package az.project.l08_insert1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import az.project.l08_insert1.DBConnection;

public class InsertExam {
	
	public static void main(String[] args) {
		
		String insertSQL = "Insert Into Person (ID,NAME,SURNAME) Values (?,?,?)";
		int insertCnt = 0;
		
		Logger logger = LogManager.getLogger();
		Connection conn = DBConnection.getConnection();
		PreparedStatement prSt = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(insertSQL);
			prSt.setInt(1, 100);
			prSt.setString(2, "Irade");
			prSt.setString(3, "HUSEYNZADA");
			
			insertCnt = prSt.executeUpdate();
			
			logger.info("Insert Info " + insertCnt);
		} catch (Exception e) {
			logger.warn("Insert Error !");
		}finally {
			if( conn != null) {
				DBConnection.closeConnection(conn, prSt);
				logger.info("Connection Close");
			}else {
				logger.warn("Connection Close Error");
			}
		}
	}

}
