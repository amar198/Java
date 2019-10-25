package com.medplat.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

import com.medplat.exceptions.InvalidValueException;
import com.medplat.read.propertyfiles.ReadPropertyFile;

class CreateDBConnectionPool {

	private ArrayList<Connection> con;
	
	/**
	 * @param noOfConnections
	 * @return
	 * @throws InvalidValueException
	 */
	CreateDBConnectionPool(int noOfConnections) throws InvalidValueException{
		
		if(noOfConnections > 500) {
			throw new InvalidValueException();
		}
		
		con = new ArrayList<Connection>(noOfConnections);
		
		try {
			Properties prop = ReadPropertyFile.readProperties("config.properties", "");
			
			Class.forName(prop.getProperty("driver"));
			String conString;
			conString = "jdbc:mysql://" + prop.getProperty("host") + ":" + prop.getProperty("port") + "/" + prop.getProperty("schema_name");
			
			//Creating an array of connections
			for(int i = 0; i < (noOfConnections-1); i++) {
				con.add(DriverManager.getConnection(conString, prop.getProperty("user"), prop.getProperty("password")));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	boolean addAdditionalConnections(int additionalConnectionCount) {
		boolean bSuccess = false;
		
		if(con != null) {
			con.ensureCapacity(con.size() + additionalConnectionCount);
			bSuccess = true;
		}
		
		return bSuccess;
	}
}
