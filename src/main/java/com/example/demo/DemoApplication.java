package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoApplication.class, args);

		String url = "jdbc:postgresql://localhost:5432/springdata";
		String userName = "doik";
		String password = "pass";

		try(Connection connection = DriverManager.getConnection(url, userName, password)){
			System.out.println("Connection created ::" + connection);
			String sql = "INSERT INTO VALUES(1, 'doik', 'pass')";
			try(PreparedStatement psmt = connection.prepareStatement(sql)){
				psmt.execute();
			}
		}
	}

}
