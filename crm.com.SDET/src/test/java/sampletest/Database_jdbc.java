package sampletest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Database_jdbc {

	public static void main(String[] args) throws SQLException {
		//step 1: load/register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		//step2:connect database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost3306/testyantra", "root", "root");
		//step3: issue sql Query
		Statement stat = conn.createStatement();
		//step4: execute Query
		String query = "select * from student_info";
		ResultSet result = stat.executeQuery(query);
		while(result.next()) {
			System.out.println();
			
		}
		

	}

}
