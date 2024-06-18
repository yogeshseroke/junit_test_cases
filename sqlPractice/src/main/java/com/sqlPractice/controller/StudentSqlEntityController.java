package com.sqlPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqlPractice.model.ResponseModel;
import com.sqlPractice.requestDto.StudentRequestDTO;
import com.sqlPractice.service.StudentSqlEntityService;

@RestController
@RequestMapping("/student")
public class StudentSqlEntityController {

	@Autowired
	private StudentSqlEntityService studentSqlEntityService;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<ResponseModel> saveStudent(@RequestBody StudentRequestDTO studentRequestDTO){
		return ResponseEntity.ok(studentSqlEntityService.saveStudent(studentRequestDTO)); 
	}
	
	 
	@GetMapping("/getAllStudent")
	public ResponseEntity<ResponseModel> getAllStudent(){
		return ResponseEntity.ok(studentSqlEntityService.getAllStudent());
	}
}
