package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Users;
import com.example.api.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/saveUser")
	public String saveUsersIntoDatabase(@RequestBody Users user) {
		String savedUser = userService.saveUsers(user);
		return savedUser;
	}
	
	@GetMapping("/getByIdUser/{id}")
	public Users getUsers(@PathVariable int id) {
		Users UsersById = userService.getUsersById(id);
		return UsersById;
	}
	
	
	@PutMapping("/updateUser")
	public String updateUsers(@RequestBody Users emp) {
		String updateUsersById = userService.UpdateUsersById(emp);
		return updateUsersById;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUsers(@PathVariable int id) {
		String deleteUsersById = userService.deleteUsersById(id);
		return deleteUsersById;
	}
	
	@GetMapping("/getAllUser")
	public List<Users> getAll(){
		return userService.listar();
		
	}
}
