package com.paris.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paris.backend.model.Role;
import com.paris.backend.model.User;
import com.paris.backend.repository.RoleRepository;
import com.paris.backend.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		if(user.getPassword()!=null){
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
        user.setActive(1);
		userRepository.save(user);
	}
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	@Override
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public void deleteUserById(int id){
		 userRepository.removeById(id);
	}
	@Override
	public List<Role> findAllRoles(){
		return roleRepository.findAll();
	}
	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
	@Override
	public void deleteRoleById(int id){
		 roleRepository.removeById(id);
	}
}