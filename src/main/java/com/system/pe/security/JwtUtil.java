package com.system.pe.security;

public class JwtUtil {
	
	public static String headerBearerDecode(String key) {
        if(key != null && key.startsWith("Bearer"))
            return key.replace("Bearer ", "");
		return null;
	}

}
