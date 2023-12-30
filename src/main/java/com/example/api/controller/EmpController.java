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

import com.example.api.model.Employee;
import com.example.api.service.EmpService;



@RestController
public class EmpController {

	@Autowired
	private EmpService service;

	@PostMapping("/save")
	public String saveEmployeeIntoDatabase(@RequestBody Employee emp) {
		String savedEmployee = service.saveEmployee(emp);
		return savedEmployee;
	}
	
	@GetMapping("/getById/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employeeById = service.getEmployeeById(id);
		return employeeById;
	}
	
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee emp) {
		String updateEmployeeById = service.UpdateEmployeeById(emp);
		return updateEmployeeById;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String deleteEmployeeById = service.deleteEmployeeById(id);
		return deleteEmployeeById;
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		return service.listar();
		
	}
	
	
}
