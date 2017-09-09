package com.imcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;

	private Connection connection;

	private ConnectionFactory() {
	}

	public static ConnectionFactory createInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}

		return connectionFactory;
	}

	public static Connection getConnection() {
		return createInstance().createConnection();
	}

	private Connection createConnection() {

		try {
			Class.forName(DaoConstants.DAO_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = (DaoConstants.DAO_URL);
		String user = (DaoConstants.DAO_UNAME);
		String password = (DaoConstants.DAO_PASSWORD);
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}