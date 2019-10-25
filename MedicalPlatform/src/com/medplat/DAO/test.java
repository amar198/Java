package com.medplat.DAO;

import com.medplat.DAO.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class test {

	public static void main(String[] args) {
		DBConnection con = new DBConnection();
		Connection c = con.getDBConnection();
		
		try {
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("select count(*) from city_master");
			
			r.next();
			System.out.println("Record Count: " + r.getInt(1));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
