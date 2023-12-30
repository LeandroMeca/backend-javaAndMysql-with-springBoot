package com.example.api.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.model.Employee;
import com.example.api.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	
	public String saveEmployee(Employee emp) {
		empRepository.save(emp);
		return "Employee saved succesfully";
	}
	
	public Employee getEmployeeById(int id) {
		Employee employee =  empRepository.findById(id).get();
		System.out.println(employee);
		return employee;
	}
	
	
	public String UpdateEmployeeById(Employee emp) {
		Employee exitEmp = empRepository.findById(emp.getEid()).orElse(null);
		
		if(exitEmp!=null) {
			exitEmp.setName(emp.getName());
			exitEmp.setAge(emp.getAge());
			empRepository.save(exitEmp);
		}
		return "Employee update succesfully";
	}
	
	public String deleteEmployeeById(int id) {
		empRepository.deleteById(id);
		return "Employee fetcthed succesfully";
	}
	
	
	public List<Employee> listar(){
		return empRepository.findAll();
	}
	
}
