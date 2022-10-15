package com.system.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.pe.entity.CourseDetail;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail,Long> {
	
	Iterable<CourseDetail> findByCourseId_CourseId(Long courseId);

}
