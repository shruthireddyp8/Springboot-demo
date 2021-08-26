package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeUpdateDTO;
import com.example.dto.ResponseDTO;
import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/")
	public String test() {
		return "hello";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO getEmployeeById(@PathVariable("id") int id) {
		try {
			EmployeeDTO employeeDTO  = employeeService.getEmployeeById(id);
			employeeDTO.setResponseMessage("SUCCESS");
			return employeeDTO;
		} catch (EmployeeNotFoundException e) {
			return new ResponseDTO("Employee id not found");
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		try {
			EmployeeDTO employeeDTO = employeeService.updateEmployee(id,employeeUpdateDTO);
			employeeDTO.setResponseMessage("SUCCESS");
			return employeeDTO;
		} catch (EmployeeNotFoundException e) {
			return new ResponseDTO(e.getMessage());
		}		
	} 
	

}
