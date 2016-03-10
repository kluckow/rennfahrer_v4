package db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Class MyConnection.
 */
public class MyConnection {
	
	/** The Constant PASSWORD. */
	private static final String PASSWORD = "";
	
	/** The Constant DB_USER. */
	private static final String DB_USER = "root";
	
	/** The Constant JDBC_MYSQL_LOCALHOST_3306_DB_RENNWAGEN. */
	private static final String JDBC_MYSQL_LOCALHOST_3306_DB_RENNWAGEN = "jdbc:mysql://localhost:3306/db_rennwagen";
	
	/** The Constant JDBC_DRIVER. */
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	/** The con. */
	private Connection con = null;
	
	/** The stmt. */
	private Statement stmt = null;
	
	/** The res. */
	private ResultSet res = null;

	/**
	 * Instantiates a new my connection.
	 */
	public MyConnection() {
		
		try {
			
//			initialize con
			Class.forName(JDBC_DRIVER).newInstance();
			con = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_DB_RENNWAGEN, DB_USER, PASSWORD);
			System.out.println("Created Database connection successfully!");
			
//	        initialize stmt
			stmt = con.createStatement();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found!");
		} catch (SQLException e) {
			System.out.println("SQL Query contains invalid syntax!");
		} catch (InstantiationException e) {
			System.out.println("Could not instanciate JDBC driver!");
		} catch (IllegalAccessException e) {
			System.out.println("Not allowed to access JDBC driver!");
		}
	}
	
	/**
	 * Gets the con.
	 *
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}
	
	/**
	 * Sets the con.
	 *
	 * @param con the new con
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * Gets the stmt.
	 *
	 * @return the stmt
	 */
	public Statement getStmt() {
		return stmt;
	}
	
	/**
	 * Sets the stmt.
	 *
	 * @param stmt the new stmt
	 */
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	/**
	 * Gets the res.
	 *
	 * @return the res
	 */
	public ResultSet getRes() {
		return res;
	}

	/**
	 * Sets the res.
	 *
	 * @param res the new res
	 */
	public void setRes(ResultSet res) {
		this.res = res;
	}
	
}
