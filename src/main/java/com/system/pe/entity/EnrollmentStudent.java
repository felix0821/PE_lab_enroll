/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.pe.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "enrollment_student", catalog = "u278890402_unsa", schema = "")
@NamedQueries({
    @NamedQuery(name = "EnrollmentStudent.findAll", query = "SELECT e FROM EnrollmentStudent e"),
    @NamedQuery(name = "EnrollmentStudent.findByPersonId", query = "SELECT e FROM EnrollmentStudent e WHERE e.enrollmentStudentPK.personId = :personId"),
    @NamedQuery(name = "EnrollmentStudent.findByCourseDetailId", query = "SELECT e FROM EnrollmentStudent e WHERE e.enrollmentStudentPK.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "EnrollmentStudent.findByEnrollmentState", query = "SELECT e FROM EnrollmentStudent e WHERE e.enrollmentState = :enrollmentState")})
public class EnrollmentStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrollmentStudentPK enrollmentStudentPK;
    @Basic(optional = false)
    @Column(name = "enrollment_state", nullable = false)
    private Character enrollmentState;
    @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CourseDetail courseDetail;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public EnrollmentStudent() {
    }

    public EnrollmentStudent(EnrollmentStudentPK enrollmentStudentPK) {
        this.enrollmentStudentPK = enrollmentStudentPK;
    }

    public EnrollmentStudent(EnrollmentStudentPK enrollmentStudentPK, Character enrollmentState) {
        this.enrollmentStudentPK = enrollmentStudentPK;
        this.enrollmentState = enrollmentState;
    }

    public EnrollmentStudent(long personId, long courseDetailId) {
        this.enrollmentStudentPK = new EnrollmentStudentPK(personId, courseDetailId);
    }

    public EnrollmentStudentPK getEnrollmentStudentPK() {
        return enrollmentStudentPK;
    }

    public void setEnrollmentStudentPK(EnrollmentStudentPK enrollmentStudentPK) {
        this.enrollmentStudentPK = enrollmentStudentPK;
    }

    public Character getEnrollmentState() {
        return enrollmentState;
    }

    public void setEnrollmentState(Character enrollmentState) {
        this.enrollmentState = enrollmentState;
    }

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentStudentPK != null ? enrollmentStudentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentStudent)) {
            return false;
        }
        EnrollmentStudent other = (EnrollmentStudent) object;
        if ((this.enrollmentStudentPK == null && other.enrollmentStudentPK != null) || (this.enrollmentStudentPK != null && !this.enrollmentStudentPK.equals(other.enrollmentStudentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.pe.entity.EnrollmentStudent[ enrollmentStudentPK=" + enrollmentStudentPK + " ]";
    }
    
}
