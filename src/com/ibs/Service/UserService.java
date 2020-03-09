package com.ibs.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ibs.dao.UserDAOImpl;
import com.ibs.model.User;

@Service
public class UserService {

public void sendUserDetailsToDAO(User user)  {
	// TODO Auto-generated method stub
	UserDAOImpl userDAO= new UserDAOImpl();
	try {
		userDAO.sendUserDetailsToDB(user,userDAO);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
