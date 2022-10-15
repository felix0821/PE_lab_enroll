package com.system.pe.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.pe.Constant;
import com.system.pe.dto.Message;
import com.system.pe.dto.response.CourseDetailItemDto;
import com.system.pe.entity.CourseDetail;
import com.system.pe.repository.CourseDetailRepository;

@RestController
@RequestMapping(value=Constant.URL_COURSExDETAIL_REQUEST)
@CrossOrigin
public class CourseDetailController {
	
	@Autowired
	CourseDetailRepository courseDetailRepository;
	
	@GetMapping(value=Constant.URL_COURSExDETAIL_COURSE_GET)
	public ResponseEntity<?> list(@RequestParam(name ="id")Long id) {
		List<CourseDetailItemDto> result;
		try {
			result = new ArrayList<>();
			Iterable<CourseDetail> allCourseDetail = courseDetailRepository.findByCourseId_CourseId(id);
			for(CourseDetail courseDetail: allCourseDetail) {
				result.add(new CourseDetailItemDto(courseDetail.getCourseDetailId(), courseDetail.getCourseId().getCourseName(),
						Constant.getTypeCourse(courseDetail.getCourseDetailType()), courseDetail.getGroupId().getGroupName(),
						courseDetail.getCourseDetailCapacity()));
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Message(Constant.SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}finally {
			result=null;
		}
	}

}
