package com.example.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.model.Employee;

@Service
public class EmployeeService {
	
	private List<Employee> employees = new ArrayList<>(Arrays.asList(
								new Employee(1,"Uttam","Sony"),
								new Employee(2,"Shreesha","Ellucian"),
								new Employee(3,"Chan","SAP"),
								new Employee(4,"Ganguly","Unysis")));
	
	public List<Employee> getAllEmps(){
		return employees;
	}
	
	public Employee getEmp(int id){
		return employees.stream().filter(e -> e.getId()==id).findFirst().get();
	}

	public void addEmp(Employee emp) {
		
		employees.add(emp);
	}

	public void updateEmp(Employee emp, int id) {
		for(Employee e: employees){
			if(e.getId()==id){
				employees.set(id, emp);
			}
		}
	}

	public void deleteEmp(int id) {
		employees.removeIf(e -> e.getId()==id);
	}
}
