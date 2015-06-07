package jpatest.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class defines several Java stored procedures that must be installed on
 * the database server, before it can be called using JPA. Reference:
 * http://docs.oracle.com/javase/tutorial/jdbc/basics/storedprocedures.html
 */
public class StoredProcedures {

	// On Derby database server, use the following command:
	// CREATE PROCEDURE GET_CUSTOMER_ORDER(IN custID INTEGER,
	// INOUT avgPrice DECIMAL(10,2))
	// PARAMETER STYLE JAVA READS SQL DATA LANGUAGE JAVA DYNAMIC RESULT SETS 1
	// EXTERNAL NAME 'jpatest.util.StoredProcedures.spCustomerAndPrice';

	// A Java procedure will use a parameter-passing convention that
	// conforms to the Java language and SQL Routines specification.
	// INOUT and OUT parameters will be passed as single entry arrays to
	// facilitate returning values. Result sets are returned
	// through additional parameters to the Java method of type
	// java.sql.ResultSet[] that are passed single entry arrays.

	// Derby does not support long column types (for example, LONG VARCHAR,
	// BLOB, and so on). An error will occur if you try to use one of these
	// long column types.
	public static void spCustomerAndPrice(Integer custID,
			BigDecimal[] avgPrice, java.sql.ResultSet[] resultSet)
			throws SQLException {

		Connection conn = getConnection();

		PreparedStatement ps = conn
				.prepareStatement("SELECT * FROM CUSTOMER c WHERE c.CUSTOMER_ID_PK = ?");
		ps.setInt(1, custID);
		resultSet[0] = ps.executeQuery();

		if (avgPrice[0] == null) {
			PreparedStatement ps2 = conn
					.prepareStatement("SELECT AVG(o.price) FROM CUSTOMER c, ORDERS o "
							+ "WHERE c.CUSTOMER_ID_PK = o.CUSTOMER_ID_FK AND c.CUSTOMER_TYPE = ?");
			ps2.setString(1, "G");
			ResultSet rsCust2 = ps2.executeQuery();
			while (rsCust2.next()) {
				avgPrice[0] = rsCust2.getBigDecimal(1);
			}
		}

	}

	/**
	 * Retrieve customer name given customer id and average price for all orders
	 * from regular customers.
	 * 
	 * @param custID
	 * @param avgPrice
	 * @param name
	 * @throws SQLException
	 */
	// Derby command to create a stored procedure for this Java method:
	// CREATE PROCEDURE GET_AVG_PRICE(IN custID INTEGER,
	// INOUT avgPrice DECIMAL(10,2), OUT custName VARCHAR(16))
	// PARAMETER STYLE JAVA READS SQL DATA LANGUAGE JAVA DYNAMIC RESULT SETS 0
	// EXTERNAL NAME 'jpatest.util.StoredProcedures.spAvgPriceName';
	public static void spAvgPriceName(Integer custID, BigDecimal[] avgPrice,
			String[] name) throws SQLException {

		Connection conn = getConnection();

		PreparedStatement ps = conn
				.prepareStatement("SELECT c.NAME FROM CUSTOMER c WHERE c.CUSTOMER_ID_PK = ?");
		ps.setInt(1, custID);
		ResultSet rsCust = ps.executeQuery();
		while (rsCust.next()) {
			name[0] = rsCust.getString(1);
		}

		if (avgPrice[0] == null) {
			PreparedStatement ps2 = conn
					.prepareStatement("SELECT AVG(o.price) FROM CUSTOMER c, ORDERS o "
							+ "WHERE c.CUSTOMER_ID_PK = o.CUSTOMER_ID_FK AND c.CUSTOMER_TYPE = ?");
			ps2.setString(1, "C");
			ResultSet rsCust2 = ps2.executeQuery();
			while (rsCust2.next()) {
				avgPrice[0] = rsCust2.getBigDecimal(1);
			}
		}

	}

	/**
	 * A Java stroed procedure that does updates on the database.
	 * 
	 * @param custID
	 * @param avgPrice
	 * @param name
	 * @throws SQLException
	 */
	// Derby command to create a stored procedure for this Java method:
	// CREATE PROCEDURE UPDATE_CUSTOMER(IN custID INTEGER,
	// IN custName VARCHAR(16), OUT sumPrice DECIMAL(10,2))
	// PARAMETER STYLE JAVA LANGUAGE JAVA DYNAMIC RESULT SETS 0
	// EXTERNAL NAME 'jpatest.util.StoredProcedures.spUpdateCustomer';
	public static void spUpdateCustomer(Integer custID, String newName,
			Double[] price) throws SQLException {

		Connection conn = getConnection();

		PreparedStatement ps = conn
				.prepareStatement("UPDATE CUSTOMER SET NAME = ? WHERE CUSTOMER_ID_PK = ?");
		ps.setString(1, newName);
		ps.setInt(2, custID);
		int status = ps.executeUpdate();

		PreparedStatement ps2 = conn
				.prepareStatement("SELECT SUM(o.price) FROM CUSTOMER c, ORDERS o "
						+ "WHERE c.CUSTOMER_ID_PK = o.CUSTOMER_ID_FK AND c.CUSTOMER_TYPE = ?");
		ps2.setString(1, "C");
		ResultSet rsCust2 = ps2.executeQuery();
		while (rsCust2.next()) {
			price[0] = rsCust2.getDouble(1);
		}
	}

	protected static Connection getConnection() throws SQLException {
		// The database connection URL jdbc:default:connection allows a Java
		// method to get the Connection of the SQL statement that called it.
		// This is the standard (SQL standard, Part 13, SQL Routines and Java)
		// mechanism to obtain the nested connection object.
		// Loading a JDBC driver in a database-side routine is not required.

		// Use this default connection inside the database server
		Connection conn = DriverManager
				.getConnection("jdbc:default:connection");

		// When debugging thru calling from outside database server, use this:
		// Connection conn = DriverManager.getConnection(
		// "jdbc:derby://localhost:1527/jpatest", "jpatest", "jpatest");

		return conn;
	}

}
