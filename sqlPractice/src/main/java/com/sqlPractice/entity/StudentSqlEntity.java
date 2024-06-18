package com.sqlPractice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_sql_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSqlEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	private String firstName;
	
	private String lastName;
	
	private Date enrollmentDate;
	
	private String totalMarks;
	
	private boolean isDelete = false;
}
