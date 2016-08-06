package com.hand.myWeb.jdbc.jdbcConnection;

import java.sql.Connection;

public interface JdbcConnectionInterface{
	Connection getConnection(boolean transactionSurport);
	void close(Connection con);

}
