package com.system.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.pe.entity.Horary;

@Repository
public interface HoraryRepository extends JpaRepository<Horary,Long> {
	
	@Query(value = "SELECT h FROM Horary h "
			+ "INNER JOIN CourseDetail c ON c.courseDetailId = h.courseDetailId.courseDetailId "
			+ "INNER JOIN EnrollmentStudent e ON e.enrollmentStudentPK.courseDetailId = c.courseDetailId "
			+ "WHERE e.enrollmentStudentPK.personId = :personId")
	public Iterable<Horary> findByPersonId(@Param(value="personId")Long personId);

}
