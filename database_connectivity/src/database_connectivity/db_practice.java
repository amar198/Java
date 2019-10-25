package database_connectivity;

import java.sql.*;
import java.util.Properties;

public class db_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ReadPropertyFile propRead = new ReadPropertyFile();
			Properties prop = propRead.getPropertiesFile();
			
			Class.forName(prop.getProperty("driver"));
			String conString;
			conString = "jdbc:mysql://" + prop.getProperty("host") + ":" + prop.getProperty("port") + "/" + prop.getProperty("schema_name");
			
			System.out.println(conString);
			
			Connection con = DriverManager.getConnection(conString, prop.getProperty("user"), prop.getProperty("password"));
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(*) from city_master");
			
			rs.next();
			System.out.println("Record Count: " + rs.getInt(1));
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}