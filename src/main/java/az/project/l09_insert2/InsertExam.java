package az.project.l09_insert2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import az.project.l09_insert2.DBConnection;

public class InsertExam {
	
	public static void main(String[] args) {
		
		insert(101,"Akif","HUSEYNZADA"); 
	}
	
	public static void insert(int id,String name,String surname) {
		
		String insertSQL = "Insert Into Person (ID,NAME,SURNAME) Values (?,?,?)";
		int insertCnt = 0;
		
		Logger logger = LogManager.getLogger();
		Connection conn = DBConnection.getConnection();
		PreparedStatement prSt = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(insertSQL);
			prSt.setInt(1, id);
			prSt.setString(2, name);
			prSt.setString(3, surname);
			
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
