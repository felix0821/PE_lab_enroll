package com.system.pe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class Message {
	
	private String content;

	public Message(String content) {
		super();
		this.content = content;
	}

}
