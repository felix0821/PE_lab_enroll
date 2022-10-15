package com.system.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.pe.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
