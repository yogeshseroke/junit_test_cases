package com.sqlPractice.service;

import com.sqlPractice.model.ResponseModel;
import com.sqlPractice.requestDto.StudentRequestDTO;

public interface StudentSqlEntityService {

	ResponseModel saveStudent(StudentRequestDTO studentRequestDTO);

	ResponseModel getAllStudent();

}
