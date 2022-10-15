package com.system.pe.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class ResponseLoginDto {
	
	private String token;
	
    private String type = "Bearer";
    
	private String username;

	public ResponseLoginDto(String token, String username) {
		super();
		this.token = token;
		this.username = username;
	}

}
