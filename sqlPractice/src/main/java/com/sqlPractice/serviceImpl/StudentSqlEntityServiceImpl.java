package com.sqlPractice.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqlPractice.entity.StudentSqlEntity;
import com.sqlPractice.model.ResponseModel;
import com.sqlPractice.repository.StudentSqlEntityRepository;
import com.sqlPractice.requestDto.StudentRequestDTO;
import com.sqlPractice.responseDto.StudentResponseDTO;
import com.sqlPractice.service.StudentSqlEntityService;

@Service
public class StudentSqlEntityServiceImpl implements StudentSqlEntityService{

	@Autowired
	private StudentSqlEntityRepository studentSqlEntityRepository;
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@Override
	public ResponseModel saveStudent(StudentRequestDTO studentRequestDTO) {
		
		StudentSqlEntity map = modelMapper.map(studentRequestDTO, StudentSqlEntity.class);
		
		studentSqlEntityRepository.save(map);
		
		StudentResponseDTO map2 = modelMapper.map(map, StudentResponseDTO.class);
		
		return new ResponseModel("student save successfully", "success", 200, map2);
	}

	@Override
	public ResponseModel getAllStudent() {
		
		ArrayList<StudentSqlEntity> allStudents = studentSqlEntityRepository.getAllStudents();
		System.out.println("list >>>>>> "+allStudents);
		ArrayList<StudentResponseDTO> map1 = new ArrayList<>();
				
		for (StudentSqlEntity studentSqlEntity : allStudents) {
			StudentResponseDTO map = modelMapper.map(studentSqlEntity, StudentResponseDTO.class);			
			map1.add(map);
		}
		return new ResponseModel("All students", "ok", 200, map1);
	}

}
