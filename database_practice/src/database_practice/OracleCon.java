package database_practice;

//required for database connectivity
import java.sql.*;

// required for parsing JSON file
import org.json.simple.ItemList;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

// required from reading JSON files
import java.io.FileReader;

public class OracleCon {
	public static void main(String[] args) {
		//reading properties from JSON file
		try (FileReader file = new FileReader("db_prop.json"))
        {
			JSONParser jp = new JSONParser();
			
			Object obj = jp.parse(file);
			JSONObject jo = (JSONObject)obj;
			
			Class.forName((String)jo.get("driver_name"));
			String con_str = getStr(jo.get("conn_str")) + getStr(jo.get("host_nm")) + ":" + getStr(jo.get("port")) + ":" + getStr(jo.get("schema_nm"));
			
			Connection con = DriverManager.getConnection(con_str, getStr(jo.get("user_nm")), getStr(jo.get("pwd")));
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BRANCH where branch_code = 'SITALA'");
			
			while(rs.next()) {
				System.out.println("Branch code: " + rs.getString(1));
			}
			System.out.println(System.getProperty("user.dir"));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static String getStr(Object obj) {
		return (String)obj;
	}
}