package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ValueObjects.Department;
import com.example.demo.ValueObjects.ResponseTemplateVO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	public ResponseTemplateVO getUserwithDepartment(int userId) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userrepository.findByUserId(userId);
		Department department= restTemplate.getForObject("http://localhost:9091/departments/" +user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	
	}

}
