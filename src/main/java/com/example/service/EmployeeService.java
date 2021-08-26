package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeUpdateDTO;
import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException {
		if (employeeRepository.findById(id).isPresent()){
			Employee employee = employeeRepository.findById(id).get();
			 return new EmployeeDTO(employee.getId(), employee.getFirstName(),
					 employee.getlastName(), employee.getSalary());
		}else {
			throw new EmployeeNotFoundException("employee id "+id+"  not found") ;
		}
		 
	}

	public EmployeeDTO updateEmployee(int id, EmployeeUpdateDTO employeeDTO) throws EmployeeNotFoundException {
		if (employeeRepository.findById(id).isPresent()){
			 Employee existingEmployee = employeeRepository.findById(id).get();

			 existingEmployee.setFirstName(employeeDTO.getFirstName());
			 existingEmployee.setlastName(employeeDTO.getLastName());
			 existingEmployee.setSalary(employeeDTO.getSalary());

			 Employee updatedEmployee = employeeRepository.save(existingEmployee);

	         return new EmployeeDTO(updatedEmployee.getId(), updatedEmployee.getFirstName(),
	            		updatedEmployee.getlastName(), updatedEmployee.getSalary());
		}
		else{
            throw new EmployeeNotFoundException("employee id "+id+"  not found can't be updated") ;
        }
	}

}
