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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(catalog = "u278890402_unsa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCourseAcronym", query = "SELECT c FROM Course c WHERE c.courseAcronym = :courseAcronym"),
    @NamedQuery(name = "Course.findByCourseDescription", query = "SELECT c FROM Course c WHERE c.courseDescription = :courseDescription")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_id", nullable = false)
    private Long courseId;
    @Basic(optional = false)
    @Column(name = "course_name", nullable = false, length = 128)
    private String courseName;
    @Basic(optional = false)
    @Column(name = "course_acronym", nullable = false, length = 8)
    private String courseAcronym;
    @Column(name = "course_description", length = 128)
    private String courseDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseDetail> courseDetailCollection;

    public Course() {
    }

    public Course(Long courseId) {
        this.courseId = courseId;
    }

    public Course(Long courseId, String courseName, String courseAcronym) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAcronym = courseAcronym;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAcronym() {
        return courseAcronym;
    }

    public void setCourseAcronym(String courseAcronym) {
        this.courseAcronym = courseAcronym;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
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
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.pe.entity.Course[ courseId=" + courseId + " ]";
    }
    
}
