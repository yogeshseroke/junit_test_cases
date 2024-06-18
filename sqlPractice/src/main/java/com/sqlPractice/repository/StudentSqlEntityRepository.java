package com.sqlPractice.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sqlPractice.entity.StudentSqlEntity;
@Repository
public interface StudentSqlEntityRepository extends JpaRepository<StudentSqlEntity, Integer>{

	@Query(value="select * from student_sql_entity where is_delete = 'false' ",nativeQuery=true)
	ArrayList<StudentSqlEntity> getAllStudents();

}
