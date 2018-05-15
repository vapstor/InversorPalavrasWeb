/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/BridgeDB?useSSL=false";
    private static final String USER = "BridgeAdmin";
    private static final String PASS = "admin";

	public static Connection getConnection() throws ClassNotFoundException {
		System.out.println("Conectando ao Banco de Dados");
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}