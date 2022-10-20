package com.system.pe.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.pe.Constant;
import com.system.pe.dto.Message;
import com.system.pe.dto.response.HoraryItemDto;
import com.system.pe.entity.CourseDetail;
import com.system.pe.entity.Horary;
import com.system.pe.entity.Person;
import com.system.pe.repository.AccountRepository;
import com.system.pe.repository.HoraryRepository;
import com.system.pe.security.JwtProvider;
import com.system.pe.security.JwtUtil;

@RestController
@RequestMapping(value=Constant.URL_HORARY_REQUEST)
@CrossOrigin
public class HoraryController {
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	HoraryRepository horaryRepository;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> list(@RequestHeader(name="Authorization")String token){
		List<HoraryItemDto> result;
		try {
			result = new ArrayList<>();
			Long accountId = jwtProvider.getIdFromToken(JwtUtil.headerBearerDecode(token));
			Person person = accountRepository.findById(accountId).orElseThrow().getPersonId();
			Iterable<Horary> allHorary = horaryRepository.findByPersonId(person.getPersonId());
			for(Horary horary: allHorary) {
				CourseDetail courseDetail = horary.getCourseDetailId();
				Person professor = courseDetail.getProfessorId();
				String professorInfo = professor.getPersonName()+" "+professor.getPersonLastnameFather();
				result.add(new HoraryItemDto(horary.getHoraryId(), Constant.getTypeCourse(horary.getHoraryDay()), 
						horary.getHoraryTimeStart(), horary.getHoraryTimeFinal(), courseDetail.getCourseId().getCourseName(), 
						professorInfo));
				
			}
			allHorary = null;
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message(Constant.SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}finally {
			result = null;
		}
	}

}
