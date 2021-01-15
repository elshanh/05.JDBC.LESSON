package az.project.l03_connection3;

import java.sql.Connection;

public class Main {
	
	public static void main(String[] args) {
		Connection conn = ConnectionExam.getConnection();
		ConnectionExam.closeConnection(conn);
	}

}
