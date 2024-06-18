package com.sqlPractice.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.sqlPractice.entity.StudentSqlEntity;
import com.sqlPractice.model.ResponseModel;
import com.sqlPractice.repository.StudentSqlEntityRepository;
import com.sqlPractice.requestDto.StudentRequestDTO;
import com.sqlPractice.responseDto.StudentResponseDTO;
import com.sqlPractice.serviceImpl.StudentSqlEntityServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StudentSqlEntityServiceImplTest { 
	
	@Mock
    private StudentSqlEntityRepository studentSqlEntityRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentSqlEntityServiceImpl studentService;

    @Test
    public void testSaveStudent() {
        // Mocking objects
        StudentSqlEntity studentSqlEntity = new StudentSqlEntity(/* provide necessary fields */);
        StudentRequestDTO studentRequestDTO = new StudentRequestDTO(/* provide necessary fields */);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(/* provide necessary fields */);

        
        // Mocking behavior for modelMapper
        when(modelMapper.map(studentRequestDTO, StudentSqlEntity.class)).thenReturn(studentSqlEntity);
        when(modelMapper.map(studentSqlEntity, StudentResponseDTO.class)).thenReturn(studentResponseDTO);

        // Mock behavior for studentSqlEntityRepository
        when(studentSqlEntityRepository.save(any(StudentSqlEntity.class))).thenReturn(studentSqlEntity);

        // Calling the service method
        ResponseModel response = studentService.saveStudent(studentRequestDTO);

        // Assertions
        assertNotNull(response);
        assertEquals("student save successfully", response.getMessage());
        assertEquals("success", response.getStatus());
        assertEquals(200, response.getStatusCode());
        assertEquals(studentResponseDTO, response.getData()); // Adjust based on your DTO structure

        // Verify interactions
        verify(modelMapper, times(1)).map(studentRequestDTO, StudentSqlEntity.class);
        verify(studentSqlEntityRepository, times(1)).save(studentSqlEntity);
        verify(modelMapper, times(1)).map(studentSqlEntity, StudentResponseDTO.class);
    }
    
    @Test
    public void testGetAllStudent() {
        // Mocking objects
        StudentSqlEntity studentSqlEntity1 = new StudentSqlEntity(/* provide necessary fields */);
        StudentSqlEntity studentSqlEntity2 = new StudentSqlEntity(/* provide necessary fields */);

        StudentResponseDTO studentResponseDTO1 = new StudentResponseDTO(/* provide necessary fields */);
        StudentResponseDTO studentResponseDTO2 = new StudentResponseDTO(/* provide necessary fields */);

        // Create a mutable ArrayList
        ArrayList<StudentSqlEntity> mockStudentList = new ArrayList<>(Arrays.asList(studentSqlEntity1, studentSqlEntity2));

        List<StudentResponseDTO> mockResponseList = List.of(studentResponseDTO1, studentResponseDTO2);

        // Mocking behavior for modelMapper
        when(modelMapper.map(studentSqlEntity1, StudentResponseDTO.class)).thenReturn(studentResponseDTO1);
        when(modelMapper.map(studentSqlEntity2, StudentResponseDTO.class)).thenReturn(studentResponseDTO2);

        // Mock behavior for studentSqlEntityRepository
        when(studentSqlEntityRepository.getAllStudents()).thenReturn(mockStudentList);

        // Calling the service method
        ResponseModel response = studentService.getAllStudent();

        // Assertions
        assertNotNull(response);
        assertEquals("All students", response.getMessage());
        assertEquals("ok", response.getStatus());
        assertEquals(200, response.getStatusCode());
        assertEquals(mockResponseList, response.getData()); // Adjust based on your DTO structure

        // Verify interactions
        verify(studentSqlEntityRepository, times(1)).getAllStudents();
        verify(modelMapper, times(2)).map(any(StudentSqlEntity.class), eq(StudentResponseDTO.class)); // Adjust count based on actual usage
    }
}
