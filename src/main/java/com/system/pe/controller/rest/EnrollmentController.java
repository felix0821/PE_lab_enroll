package com.system.pe.controller.rest;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.pe.Constant;
import com.system.pe.dto.Message;
import com.system.pe.dto.request.EnrollmentCourseSelectDto;
import com.system.pe.entity.Account;
import com.system.pe.entity.EnrollmentStudent;
import com.system.pe.entity.EnrollmentStudentPK;
import com.system.pe.entity.Person;
import com.system.pe.repository.AccountRepository;
import com.system.pe.repository.EnrollmentStudentRepository;
import com.system.pe.security.JwtProvider;
import com.system.pe.security.JwtUtil;

@RestController
@RequestMapping(value=Constant.URL_ENROLL_REQUEST)
@CrossOrigin
public class EnrollmentController {
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	EnrollmentStudentRepository enrollmentStudentRepository;
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping(value=Constant.URL_ENROLL_REGISTER_POST)
	@Transactional
	public ResponseEntity<?> register(@RequestHeader(name="Authorization")String token, 
			@Valid @RequestBody EnrollmentCourseSelectDto enrollmentCourseSelectDto, BindingResult bindingResult){
		try {
//			-►Realizar las validaciones pertinentes
			if(bindingResult.hasErrors())
	            return new ResponseEntity<>(new Message(bindingResult.getFieldError().getDefaultMessage()), 
	            		HttpStatus.BAD_REQUEST);
			Long accountId = jwtProvider.getIdFromToken(JwtUtil.headerBearerDecode(token));
			Person person = accountRepository.findById(accountId).orElseThrow().getPersonId();
//			-►Generar entidad
			EnrollmentStudentPK enrollmentStudentId = new EnrollmentStudentPK(person.getPersonId(),
					enrollmentCourseSelectDto.getCourseDetailId());
			EnrollmentStudent EnrollmentStudent = new EnrollmentStudent(enrollmentStudentId, Constant.SYSTEM_STATE_ACTIVE);
			enrollmentStudentRepository.save(EnrollmentStudent);
//	    	-►Enviar respuesta exitosa
			return new ResponseEntity<>(new Message(Constant.SYSTEM_SUCCESS), HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message(Constant.SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}

}
