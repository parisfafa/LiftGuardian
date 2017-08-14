package com.paris.backend.service;

import java.util.List;

import com.paris.backend.model.Role;
import com.paris.backend.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public List<User> findAllUsers();
	public void deleteUserById(int id);
	public List<Role> findAllRoles();
	public void saveRole(Role role);
	public void deleteRoleById(int id);
	void updateUser(User user);
}