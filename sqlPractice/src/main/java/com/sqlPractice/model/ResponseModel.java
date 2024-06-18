package com.sqlPractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

	private String message;
	
	private String status;
	
	private int statusCode;
	
	private Object data;
}
