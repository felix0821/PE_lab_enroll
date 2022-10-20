package com.system.pe.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class HoraryCourseDto {
	
	private Long id;
	
	private String nameDetail;

	public HoraryCourseDto(Long id, String nameDetail) {
		super();
		this.id = id;
		this.nameDetail = nameDetail;
	}

}
