package com.system.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.pe.entity.EnrollmentStudent;
import com.system.pe.entity.EnrollmentStudentPK;

@Repository
public interface EnrollmentStudentRepository extends JpaRepository<EnrollmentStudent,EnrollmentStudentPK> {

}
