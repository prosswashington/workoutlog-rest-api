package com.rossprojects.workoutlog.service;

import java.util.List;

import com.rossprojects.workoutlog.entity.User;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
}
