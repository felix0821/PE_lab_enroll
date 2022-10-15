package com.system.pe.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class CourseViewDto {
	
	private String courseName;
	
	private List<CourseDetailItemDto> allDetails;

	public CourseViewDto(String courseName) {
		super();
		this.courseName = courseName;
		this.allDetails = new ArrayList<>();
	}
	
}
