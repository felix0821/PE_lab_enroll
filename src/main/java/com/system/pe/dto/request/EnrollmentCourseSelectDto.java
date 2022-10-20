package com.system.pe.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
@NoArgsConstructor
public class EnrollmentCourseSelectDto {
	
	@NotNull(message = "Ingrese un identificador de curso.")
	private Long courseDetailId;

}
