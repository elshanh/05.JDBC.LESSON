package az.project.l13_update;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBProcess {
	
	private static final Logger logger = LogManager.getLogger();

	public static void updatePerson(PersonModel person) {
		
		String updateSQL = "Update Person Set NAME = ? Where ID = ?";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement prSt = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(updateSQL);
			prSt.setString(1, person.getPersonName());
			prSt.setInt(2, person.getPersonId());
			
			prSt.executeUpdate();
			
			logger.info("Update Person ");
		} catch (Exception e) {
			logger.warn("Update Person Error !");
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
