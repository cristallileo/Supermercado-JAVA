package Data;

import java.sql.*;

public class DbConnector {

	private static DbConnector instancia;
	
	private String driver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="root";
	private String password="LYRxok51566";
	private String db="tp_java";
	private int conectados=0;
	private Connection conn=null;
	
	private DbConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error message = " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}

	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				//conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+ db +"?user="+ user + "&password=" + password +"&useSSL=false" );
				conn=DriverManager.getConnection("jdbc:mysql://node2943-env-6226861.sp.skdrive.net/"+db+"?serverTimezone=UTC", user, password);
				//conn=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password + "&useSSL=true");
				conectados=0;
			}
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		}
	}
}