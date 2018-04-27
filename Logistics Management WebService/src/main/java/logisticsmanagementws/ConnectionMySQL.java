package logisticsmanagementws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConnectionMySQL {
	
	//private static String url = "jdbc:mysql://localhost/easy_route?user=root&password=mauricio";
	private static String url = "jdbc:mysql://127.0.0.1/logisticsmanagementdatabase?user=root&password=root@konoha";
	//private static String url = "jdbc:mysql://http://logisticsmanagementroute-logisticsmanagement.1d35.starter-us-east-1.openshiftapps.com//logisticsmanagementdatabase?user=root&password=root@konoha";
	public static String status = "";
		
	public static Connection getConexao(){
		Connection conn = null;
		
		try {Class.forName("com.mysql.jdbc.Driver").newInstance();				
				conn = DriverManager.getConnection(url);				
				status = "Connection opened";				
		}
	
	catch(SQLException e){
		status = e.getMessage();
	}
	catch(ClassNotFoundException e){		
		status = e.getMessage();
	}
	catch(Exception e){
		status = e.getMessage();
	}
		
	System.out.println(status);
	
	return conn;
	}
}
