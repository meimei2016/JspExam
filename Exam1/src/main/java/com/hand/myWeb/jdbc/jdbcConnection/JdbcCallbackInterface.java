package com.hand.myWeb.jdbc.jdbcConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface JdbcCallbackInterface<T> {
	public void setParam(PreparedStatement ps) throws SQLException;
	public List<T> getResultSet(ResultSet rs)throws SQLException;

}
