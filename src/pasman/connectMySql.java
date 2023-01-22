package pasman;


import java.sql.Connection;
import java.sql.DriverManager;

public class connectMySql{
	public static Connection connectdb(String username,String Passwd) {
		Connection connector=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connector=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp",
					username,
					Passwd
					);
			
				
		}catch(Exception e){
			System.out.println("Error Connecting to Database Make Sure You have MySQL installed On your system ");
			//return null;
		}
		return connector;	
		
	}
}