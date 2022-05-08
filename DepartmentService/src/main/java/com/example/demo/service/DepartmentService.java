package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDept(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}
	
	

}
