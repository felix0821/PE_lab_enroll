package com.system.pe.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class HoraryItemDto {
	
	private Long id;
	
	private String day;
	
	private Date startTime;
	
	private Date finalTime;
	
	private String courseName;
	
	private String professorName;

	public HoraryItemDto(Long id, String day, Date startTime, Date finalTime, String courseName, String professorName) {
		super();
		this.id = id;
		this.day = day;
		this.startTime = startTime;
		this.finalTime = finalTime;
		this.courseName = courseName;
		this.professorName = professorName;
	}

}
