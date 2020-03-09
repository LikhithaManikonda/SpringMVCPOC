package com.ibs.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.stereotype.Repository;

import com.ibs.model.User;
@Repository
public class UserDAOImpl {
	String dbURL; 
	String username; 
	String password; 
	String className;
	Properties properties;
	Connection connection=null;
	PreparedStatement preparedStatement;
	private int count;
	
	private  void dataBaseConnectivity() throws ClassNotFoundException, SQLException, IOException {
		//ResourceBundle resourceBundle = ResourceBundle.getBundle("DatabaseDetails");
		//Properties.load(resourceBundle);
		properties=new Properties();		
		properties.load(new FileInputStream("//Users//a-8276//eclipse-workspace//PracticeSpringMVC//src//com//ibs//dao//DatabaseDetails.properties"));
		//loading JDBC Driver
		Class.forName(properties.getProperty("className"));
		connection=DriverManager.getConnection(properties.getProperty("dbURL"), properties.getProperty("username"), properties.getProperty("password"));
	

	}
	public void sendUserDetailsToDB(User user, UserDAOImpl userDAO) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		userDAO.dataBaseConnectivity();
		System.out.print(userDAO.connection);
		//try {
			userDAO.preparedStatement = userDAO.connection.prepareStatement("insert into userInformation(userName,password,phoneNumber) values(?,?,?)");
			userDAO.preparedStatement.setString(1, user.getUserName());
			userDAO.preparedStatement.setString(2, user.getPassword());
			userDAO.preparedStatement.setLong(3, user.getPhoneNumber());

			userDAO.count=userDAO.preparedStatement.executeUpdate();
			if(count>0) {
				System.out.println("Data saved successfully");
			}

	}

}
