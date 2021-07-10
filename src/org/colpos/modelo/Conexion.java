package org.colpos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	static Connection connection = null;
    static String driver = "oracle.jdbc.driver.oracleDriver";
    static String URL = "jdbc:oracle:thin:@localhost:1521:ORCLCOLPOS";

    public static void connectDB() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Status: CARGO EL DRIVER OJDBC");
        } catch (Exception e) {
            System.out.println("Exception1: " + e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(URL, "SYSTEM", "Urzua9509");
            System.out.println("Status: Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Exception2: " + e.getMessage());
        }
    }
}
