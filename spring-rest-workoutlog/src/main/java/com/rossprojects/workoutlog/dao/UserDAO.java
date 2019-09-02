package com.rossprojects.workoutlog.dao;

import java.util.List;

import com.rossprojects.workoutlog.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
}
