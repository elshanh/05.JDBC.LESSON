package az.project.l16_selectList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import az.project.l16_selectList.DBConnection;
import az.project.l16_selectList.PersonModel;

public class DBProcess {
	
	private static final Logger logger = LogManager.getLogger();

	public static List<PersonModel> selectPersonList() {
		
		String selectSQL = "Select * From Person";
		
		Connection conn = DBConnection.getConnection();
		ResultSet resultSet = null;
		PreparedStatement prSt = null;
		
		List<PersonModel> personModelList = new ArrayList<PersonModel>();
		
		try {
			prSt = (PreparedStatement) conn.prepareStatement(selectSQL);
			resultSet = prSt.executeQuery();
			
			while (resultSet.next()) {
				
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String surname = resultSet.getString(3);
				
				PersonModel personModel = new PersonModel(id, name, surname);
				personModelList.add(personModel);
				
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
		
		return personModelList;
	}

}
