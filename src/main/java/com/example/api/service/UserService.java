package com.example.api.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.model.Users;
import com.example.api.repository.UsersRepository;


@Service
public class UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	public String saveUsers(Users user) {
		usersRepository.save(user);
		return "Users saved succesfully";
	}
	
	public Users getUsersById(int id) {
		Users users =  usersRepository.findById(id).get();
		System.out.println(users);
		return users;
	}
	
	
	public String UpdateUsersById(Users user) {
		Users exitUser = usersRepository.findById(user.getEid()).orElse(null);
		
		if(exitUser!=null) {
			exitUser.setName(user.getName());
			exitUser.setPassword(user.getPassword());
			usersRepository.save(exitUser);
		}
		return "Users update succesfully";
	}
	
	public String deleteUsersById(int id) {
		usersRepository.deleteById(id);
		return "Users fetcthed succesfully";
	}
	
	
	public List<Users> listar(){
		return usersRepository.findAll();
	}
	
	
}
