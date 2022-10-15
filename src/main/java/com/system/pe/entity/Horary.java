/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.pe.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "horary", catalog = "u278890402_unsa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Horary.findAll", query = "SELECT h FROM Horary h"),
    @NamedQuery(name = "Horary.findByHoraryId", query = "SELECT h FROM Horary h WHERE h.horaryId = :horaryId"),
    @NamedQuery(name = "Horary.findByHoraryDay", query = "SELECT h FROM Horary h WHERE h.horaryDay = :horaryDay"),
    @NamedQuery(name = "Horary.findByHoraryTimeStart", query = "SELECT h FROM Horary h WHERE h.horaryTimeStart = :horaryTimeStart"),
    @NamedQuery(name = "Horary.findByHoraryTimeFinal", query = "SELECT h FROM Horary h WHERE h.horaryTimeFinal = :horaryTimeFinal"),
    @NamedQuery(name = "Horary.findByHoraryState", query = "SELECT h FROM Horary h WHERE h.horaryState = :horaryState")})
public class Horary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "horary_id", nullable = false)
    private Long horaryId;
    @Basic(optional = false)
    @Column(name = "horary_day", nullable = false)
    private Character horaryDay;
    @Basic(optional = false)
    @Column(name = "horary_time_start", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaryTimeStart;
    @Basic(optional = false)
    @Column(name = "horary_time_final", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaryTimeFinal;
    @Basic(optional = false)
    @Column(name = "horary_state", nullable = false)
    private Character horaryState;
    @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id", nullable = false)
    @ManyToOne(optional = false)
    private CourseDetail courseDetailId;

    public Horary() {
    }

    public Horary(Long horaryId) {
        this.horaryId = horaryId;
    }

    public Horary(Long horaryId, Character horaryDay, Date horaryTimeStart, Date horaryTimeFinal, Character horaryState) {
        this.horaryId = horaryId;
        this.horaryDay = horaryDay;
        this.horaryTimeStart = horaryTimeStart;
        this.horaryTimeFinal = horaryTimeFinal;
        this.horaryState = horaryState;
    }

    public Long getHoraryId() {
        return horaryId;
    }

    public void setHoraryId(Long horaryId) {
        this.horaryId = horaryId;
    }

    public Character getHoraryDay() {
        return horaryDay;
    }

    public void setHoraryDay(Character horaryDay) {
        this.horaryDay = horaryDay;
    }

    public Date getHoraryTimeStart() {
        return horaryTimeStart;
    }

    public void setHoraryTimeStart(Date horaryTimeStart) {
        this.horaryTimeStart = horaryTimeStart;
    }

    public Date getHoraryTimeFinal() {
        return horaryTimeFinal;
    }

    public void setHoraryTimeFinal(Date horaryTimeFinal) {
        this.horaryTimeFinal = horaryTimeFinal;
    }

    public Character getHoraryState() {
        return horaryState;
    }

    public void setHoraryState(Character horaryState) {
        this.horaryState = horaryState;
    }

    public CourseDetail getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(CourseDetail courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaryId != null ? horaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horary)) {
            return false;
        }
        Horary other = (Horary) object;
        if ((this.horaryId == null && other.horaryId != null) || (this.horaryId != null && !this.horaryId.equals(other.horaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Horary[ horaryId=" + horaryId + " ]";
    }
    
}
