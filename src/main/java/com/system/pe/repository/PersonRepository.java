package com.system.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.pe.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
