package az.project.l15_selectById;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import az.project.l15_selectById.DBConnection;
import az.project.l15_selectById.PersonModel;

public class DBProcess {
	
	private static final Logger logger = LogManager.getLogger();

	public static PersonModel selectByPersonId(int personId) {
		
		String selectSQL = "Select * From Person Where ID = ?";
		
		Connection conn = DBConnection.getConnection();
		ResultSet resultSet = null;
		PreparedStatement prSt = null;
		
		PersonModel personModel = null;
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(selectSQL);
			prSt.setInt(1, personId);
			resultSet = prSt.executeQuery();
			
			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String surname = resultSet.getString(3);
				
				personModel = new PersonModel(id, name, surname);
				
			}
			
			logger.info("Select Person ");
		} catch (Exception e) {
			logger.warn("Select Person Error !");
		}finally {
			if( conn != null) {
				DBConnection.closeConnection(conn, prSt,resultSet);
				logger.info("Connection Close");
			}else {
				logger.warn("Connection Close Error");
			}
		}		
		
		return personModel;
	}

}
