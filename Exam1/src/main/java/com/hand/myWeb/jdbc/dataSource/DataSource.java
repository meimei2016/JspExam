package com.hand.myWeb.jdbc.dataSource;

import java.sql.Connection;

public interface DataSource {
	Connection getConn();
}
