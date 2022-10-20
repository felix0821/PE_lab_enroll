package com.system.pe;

public class Constant {
	
//	Mapeo para el controlador "Autenticación"
	public static final String URL_AUTH_REQUEST = "/auth";
	public static final String URL_AUTH_LOGIN_POST = "/login";
	
	public static final String URL_COURSE_REQUEST = "/course";
	public static final String URL_COURSE_ID_GET = "/course/{course}";
	
	public static final String URL_COURSExDETAIL_REQUEST = "/course-detail";
	public static final String URL_COURSExDETAIL_COURSE_GET = "/course";
	
	public static final String URL_ENROLL_REQUEST = "/enroll";
	public static final String URL_ENROLL_REGISTER_POST = "/register";
	
	public static final String URL_HORARY_REQUEST = "/horary";
	
	
//	°Declaraciones de parametros respuestas
	public static final String SYSTEM_MSG_UNAUTHENTICATED = "Unauthenticated";
	public static final String SYSTEM_MSG_UNAUTHORIZED = "Unauthenticated";
//	°Declaraciones de parametros para ubicación
	public static final String ZONE_DATE_LIMA = "America/Lima";
//	°Recursos generales del sistema
//	°Recursos estados de entidad
	public static final Character SYSTEM_STATE_ACTIVE = 'A';
	public static final Character SYSTEM_STATE_INACTIVE = 'I';
	public static final Character SYSTEM_STATE_DELETE = '*';
	
//	°Recursos de tipo de entrada
	public static final Long SYSTEM_ACCOUNT_ADMINISTRATOR = 1000001001001L;
	public static final Long SYSTEM_PERSON_ADMINISTRATOR = 1000001000001L;
	
//	#Respuestas concretadas
	public static final String SYSTEM_SUCCESS = "Proceso exitoso";
//	Respuestas de error
	public static final String SYSTEM_ERROR_AUTH = "Login inválido";
	public static final String SYSTEM_ERROR_TOKEN = "Error de token";
	public static final String SYSTEM_ERROR = "Error de sistema";
	public static final String SYSTEM_ENTITY_NOT_FOUND = "No se encontro recurso";
	
//	°Tipos de curso
	public static String getTypeCourse(Character type) {
		String typeCourse = null;
		switch(type) {
		case 'T':
			typeCourse = "Teoria";
			break;
		case 'L':
			typeCourse = "Laboratorio";
			break;
		default:
			typeCourse = "No definido";
		}
		return typeCourse;
	}

}
