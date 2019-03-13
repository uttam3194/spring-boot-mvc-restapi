package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Employee;
import com.example.spring.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(method=RequestMethod.GET, value="/welcome/msg")
	public String sayHi(){
		return "Hi";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/welcome/emp")
	public List<Employee> getAllEmp(){
		return empService.getAllEmps();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/welcome/emp/{id}")
	public Employee getEmp(@PathVariable int id){ //@PathVariable("id)
		return empService.getEmp(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/welcome/emp")
	public void addEmp(@RequestBody Employee emp){
		empService.addEmp(emp);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/welcome/emp/{id}")
	public void updateEmp(@RequestBody Employee emp, @PathVariable int id){
		empService.updateEmp(emp, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/welcome/emp/{id}")
	public void deleteEmp(@PathVariable int id){
		empService.deleteEmp(id);
	}
	
}
