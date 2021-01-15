package az.project.l12_batchInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBProcess {
	
	private static final Logger logger = LogManager.getLogger();
	public static void insertListPerson(List<PersonModel>  personModelList) {
		
		String insertSQL = "Insert Into Person (ID,NAME,SURNAME) Values (?,?,?)";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement prSt = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(insertSQL);
			
			for (PersonModel personModel : personModelList) {
				
				prSt.setInt(1, personModel.getPersonId());
				prSt.setString(2, personModel.getPersonName());
				prSt.setString(3, personModel.getPersonSurname());
				
				prSt.addBatch();
			}
			
			prSt.executeBatch();
			
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
