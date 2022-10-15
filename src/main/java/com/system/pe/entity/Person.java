/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.pe.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(catalog = "u278890402_unsa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByPersonName", query = "SELECT p FROM Person p WHERE p.personName = :personName"),
    @NamedQuery(name = "Person.findByPersonLastnameFather", query = "SELECT p FROM Person p WHERE p.personLastnameFather = :personLastnameFather"),
    @NamedQuery(name = "Person.findByPersonLastnameMother", query = "SELECT p FROM Person p WHERE p.personLastnameMother = :personLastnameMother"),
    @NamedQuery(name = "Person.findByPersonDateBirth", query = "SELECT p FROM Person p WHERE p.personDateBirth = :personDateBirth")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Basic(optional = false)
    @Column(name = "person_name", nullable = false, length = 128)
    private String personName;
    @Basic(optional = false)
    @Column(name = "person_lastname_father", nullable = false, length = 128)
    private String personLastnameFather;
    @Basic(optional = false)
    @Column(name = "person_lastname_mother", nullable = false, length = 128)
    private String personLastnameMother;
    @Column(name = "person_date_birth")
    @Temporal(TemporalType.DATE)
    private Date personDateBirth;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<EnrollmentStudent> enrollmentStudentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Account> accountCollection;
    @OneToMany(mappedBy = "professorId")
    private Collection<CourseDetail> courseDetailCollection;

    public Person() {
    }

    public Person(Long personId) {
        this.personId = personId;
    }

    public Person(Long personId, String personName, String personLastnameFather, String personLastnameMother) {
        this.personId = personId;
        this.personName = personName;
        this.personLastnameFather = personLastnameFather;
        this.personLastnameMother = personLastnameMother;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastnameFather() {
        return personLastnameFather;
    }

    public void setPersonLastnameFather(String personLastnameFather) {
        this.personLastnameFather = personLastnameFather;
    }

    public String getPersonLastnameMother() {
        return personLastnameMother;
    }

    public void setPersonLastnameMother(String personLastnameMother) {
        this.personLastnameMother = personLastnameMother;
    }

    public Date getPersonDateBirth() {
        return personDateBirth;
    }

    public void setPersonDateBirth(Date personDateBirth) {
        this.personDateBirth = personDateBirth;
    }

    public Collection<EnrollmentStudent> getEnrollmentStudentCollection() {
        return enrollmentStudentCollection;
    }

    public void setEnrollmentStudentCollection(Collection<EnrollmentStudent> enrollmentStudentCollection) {
        this.enrollmentStudentCollection = enrollmentStudentCollection;
    }

    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    public Collection<CourseDetail> getCourseDetailCollection() {
        return courseDetailCollection;
    }

    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.pe.entity.Person[ personId=" + personId + " ]";
    }
    
}
