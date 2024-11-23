package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DB.getConnection();
			preparedStatement = conn.prepareStatement(
					"UPDATE seller "
				   +"SET BaseSalary = BaseSalary + ? "
				   +"WHERE (DepartmentId = ?)"
					);
			preparedStatement.setDouble(1, 575.95);
			preparedStatement.setInt(2, 1);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			DB.closeStatement(preparedStatement);
			DB.closeConnection();
		}
	}
}