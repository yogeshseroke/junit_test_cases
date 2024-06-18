package com.sqlPractice.requestDto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
	private String firstName;

	private String lastName;

	private Date enrollmentDate;

	private String totalMarks;
}
