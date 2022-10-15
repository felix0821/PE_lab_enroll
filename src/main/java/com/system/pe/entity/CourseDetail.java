/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.pe.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "course_detail", catalog = "u278890402_unsa", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"course_id", "group_id", "course_detail_type"})})
@NamedQueries({
    @NamedQuery(name = "CourseDetail.findAll", query = "SELECT c FROM CourseDetail c"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailId", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailType", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailType = :courseDetailType"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailCapacity", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailCapacity = :courseDetailCapacity")})
public class CourseDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_detail_id", nullable = false)
    private Long courseDetailId;
    @Basic(optional = false)
    @Column(name = "course_detail_type", nullable = false)
    private Character courseDetailType;
    @Basic(optional = false)
    @Column(name = "course_detail_capacity", nullable = false)
    private short courseDetailCapacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetailId")
    private Collection<Horary> horaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetail")
    private Collection<EnrollmentStudent> enrollmentStudentCollection;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    @ManyToOne(optional = false)
    private GroupTeaching groupId;
    @JoinColumn(name = "professor_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person professorId;

    public CourseDetail() {
    }

    public CourseDetail(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public CourseDetail(Long courseDetailId, Character courseDetailType, short courseDetailCapacity) {
        this.courseDetailId = courseDetailId;
        this.courseDetailType = courseDetailType;
        this.courseDetailCapacity = courseDetailCapacity;
    }

    public Long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public Character getCourseDetailType() {
        return courseDetailType;
    }

    public void setCourseDetailType(Character courseDetailType) {
        this.courseDetailType = courseDetailType;
    }

    public short getCourseDetailCapacity() {
        return courseDetailCapacity;
    }

    public void setCourseDetailCapacity(short courseDetailCapacity) {
        this.courseDetailCapacity = courseDetailCapacity;
    }

    public Collection<Horary> getHoraryCollection() {
        return horaryCollection;
    }

    public void setHoraryCollection(Collection<Horary> horaryCollection) {
        this.horaryCollection = horaryCollection;
    }

    public Collection<EnrollmentStudent> getEnrollmentStudentCollection() {
        return enrollmentStudentCollection;
    }

    public void setEnrollmentStudentCollection(Collection<EnrollmentStudent> enrollmentStudentCollection) {
        this.enrollmentStudentCollection = enrollmentStudentCollection;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public GroupTeaching getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupTeaching groupId) {
        this.groupId = groupId;
    }

    public Person getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Person professorId) {
        this.professorId = professorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseDetailId != null ? courseDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseDetail)) {
            return false;
        }
        CourseDetail other = (CourseDetail) object;
        if ((this.courseDetailId == null && other.courseDetailId != null) || (this.courseDetailId != null && !this.courseDetailId.equals(other.courseDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.pe.entity.CourseDetail[ courseDetailId=" + courseDetailId + " ]";
    }
    
}
