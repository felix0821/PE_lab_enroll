package com.system.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.pe.Constant;
import com.system.pe.dto.Message;
import com.system.pe.dto.response.CourseItemDto;
import com.system.pe.entity.Course;
import com.system.pe.repository.CourseRepository;

@RestController
@RequestMapping(value=Constant.URL_COURSE_REQUEST)
@CrossOrigin
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> list() {
		List<CourseItemDto> result;
		try {
			result = new ArrayList<CourseItemDto>();
			Iterable<Course> allCourse = courseRepository.findAll();
			for(Course course: allCourse) {
				result.add(new CourseItemDto(course.getCourseId(), course.getCourseName(), 
						course.getCourseAcronym(), course.getCourseAcronym()));
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message(Constant.SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}finally {
			result=null;
		}
	}
	
	@GetMapping(value=Constant.URL_COURSE_ID_GET)
	public  ResponseEntity<?> view(@PathVariable(name ="course")Long id) {
		CourseItemDto courseItemDto;
		try {
			Course course = courseRepository.findById(id).orElseThrow();
			courseItemDto = new CourseItemDto(course.getCourseId(), course.getCourseName(), 
						course.getCourseAcronym(), course.getCourseAcronym());
			return new ResponseEntity<>(courseItemDto, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message(Constant.SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}finally {
			courseItemDto=null;
		}
	}

}
