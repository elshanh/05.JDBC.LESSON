package az.project.l11_insert4;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import az.project.l11_insert4.DBConnection;

public class DBProcess {
	
	private static final Logger logger = LogManager.getLogger();
	public static void insert(PersonModel personModel) {
		
		String insertSQL = "Insert Into Person (ID,NAME,SURNAME) Values (?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement prSt = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(insertSQL);
			prSt.setInt(1, personModel.getPersonId());
			prSt.setString(2, personModel.getPersonName());
			prSt.setString(3, personModel.getPersonSurname());
			
			prSt.executeUpdate();
			
			logger.info("Insert Info ");
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
