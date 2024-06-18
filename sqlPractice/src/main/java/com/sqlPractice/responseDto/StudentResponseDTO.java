package com.sqlPractice.responseDto;

import java.util.Date;

import com.sqlPractice.requestDto.StudentRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
	private String firstName;

	private String lastName;

	private Date enrollmentDate;

	private String totalMarks;
}
