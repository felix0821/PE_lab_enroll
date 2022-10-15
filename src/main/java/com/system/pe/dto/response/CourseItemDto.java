package com.system.pe.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class CourseItemDto {
	
	private Long id;
	
	private String name;
	
	private String acronym;
	
	private String description;

	public CourseItemDto(Long id, String name, String acronym, String description) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
		this.description = description;
	}

}
