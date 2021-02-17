package az.project.l14_delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBProcess {
	
	private static final Logger logger = LogManager.getLogger();

	public static void deletePerson(int personalId) {
		
		String deleteSQL = "Delete From Person Where ID = ?";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement prSt = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(deleteSQL);
			prSt.setInt(1, personalId);
			
			prSt.executeUpdate();
			
			logger.info("Delete Person ");
		} catch (Exception e) {
			logger.warn("Delete Person Error !");
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
