package com.system.pe.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class CourseDetailItemDto {
	
	private Long id;
	
	private String courseName;
	
	private String courseType;
	
	private String courseGroup;
	
	private Short capacity;

	public CourseDetailItemDto(Long id, String courseName, String courseType, String courseGroup, Short capacity) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseType = courseType;
		this.courseGroup = courseGroup;
		this.capacity = capacity;
	}

}
